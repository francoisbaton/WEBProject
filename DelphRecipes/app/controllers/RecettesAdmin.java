package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

@With(Secure.class)
public class RecettesAdmin extends Controller {
	
	public static void index(User user) {
		String usermail = Security.connected();
		User currentUser = User.findByEmail(usermail);
		List<Recette> olderRecettes = Recette.find("select distinct r from Recette r where r.author = ?",
            currentUser).fetch();
			
		render(currentUser, olderRecettes,user);
    }
	
}