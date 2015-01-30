package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

@With(Secure.class)
public class EntreeAdmin extends Controller {
	
	public static void index() {
		String usermail = Security.connected();
		User currentUser = User.findByEmail(usermail);
		List<Recette> olderRecettes = Recette.find("select distinct r from Recette r where r.categorie = ?",
            "Entree").fetch();
		
		render(olderRecettes,currentUser);
    }
	
}