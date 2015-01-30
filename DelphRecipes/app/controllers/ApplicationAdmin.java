package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

@Check("admin")
@With(Secure.class)
public class ApplicationAdmin extends Controller {
	
	public static void index() {
		String usermail = Security.connected();
		User currentUser = User.findByEmail(usermail);
		List<Recette> listAlea = Recette.find("select distinct r from Recette r ").fetch();

        int taille = listAlea.size();

        long indice = (int)(Math.random() * taille );

        Recette frontRecette = Recette.find("select distinct r from Recette r where r.id = ?", indice).first();
        
        List<Recette> olderRecettes = Recette.find(
            "select distinct r from Recette r").from(0).fetch(5);
		render(frontRecette,olderRecettes,currentUser);
    }

	public static void searchRecipe(String name){
        String query = "select distinct r from Recette r where r.categorie LIKE '%";
        query += name;
        query +="%' OR r.title LIKE '%";
        query += name;
        query += "%'";
        List<Recette> res = Recette.find(query).fetch();
		String usermail = Security.connected();
		User currentUser = User.findByEmail(usermail);
        render("SearchAdmin/index.html",res,currentUser);
    }
	
	public static void postComment(Long recId, String author, String content) {
    	Recette currentRec = Recette.findById(recId);
    	currentRec.addComment(author,content);
    	//render(recId);
        DetailsAdmin.index(recId);
	}
}