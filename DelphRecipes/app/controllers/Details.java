package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Details extends Controller {

	public static void index(Long id) {
    	//Post post = Post.findById(id);
    	Recette currentRecipe = Recette.findById(id);
    	render(currentRecipe);
	}

}