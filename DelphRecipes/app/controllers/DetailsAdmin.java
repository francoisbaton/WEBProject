package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class DetailsAdmin extends Controller {

	public static void index(Long id) {
    	//Post post = Post.findById(id);
    	Recette currentRecipe = Recette.findById(id);
    	String usermail = Security.connected();
		User currentUser = User.findByEmail(usermail);
		render(currentRecipe,currentUser);
	}

}