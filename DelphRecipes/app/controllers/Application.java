package controllers;

import play.*;
import play.mvc.*;
import java.util.*;
import models.*;



public class Application extends Controller {

    public static void index() {
        //Front recette recupé toutes les recettes et choisir un chiffre aléatoirement
        List<Recette> listAlea = Recette.find("select distinct r from Recette r ").fetch();

        int taille = listAlea.size();

        long indice = (int)(Math.random() * taille );

        Recette frontRecette = Recette.find("select distinct r from Recette r where r.id = ?", indice).first();
        
        List<Recette> olderRecettes = Recette.find(
            "select distinct r from Recette r").from(0).fetch(5);
        render(frontRecette,olderRecettes);
    }


    public static void show(Long id) {
    Recette rec = Recette.findById(id);
    render(rec);
	}


    public static void postComment(Long recId, String author, String content) {
    	Recette currentRec = Recette.findById(recId);
    	currentRec.addComment(author,content);
    	//render(recId);
        Details.index(recId);
	}

    public static void searchRecipe(String name){
        String query = "select distinct r from Recette r where r.categorie LIKE '%";
        query += name;
        query +="%' OR r.title LIKE '%";
        query += name;
        query += "%'";
        List<Recette> res = Recette.find(query).fetch();
        render("Search/index.html",res);
    }

        public static void subscribe(String login, String pwd, String pwd2,String email){
        if( pwd.equals(pwd)){

            String queryAlready = "select distinct u from User where u.email =";
            queryAlready += email;
            List<User> getUser = User.find(queryAlready).fetch();
            if(getUser.size() == 0){

                User newUser = new User(email,pwd,login);
                newUser.save();

            }else{
                //L'utilisateur existe déjà
                Error.index("Error : User already existe");
            }
        }else{
            //Confirmation incorrecte
            Error.index("Error : Mot de passe incorrect");
        }
    }

}
