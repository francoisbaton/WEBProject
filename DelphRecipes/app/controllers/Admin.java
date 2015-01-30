package controllers;
 
import play.*;
import play.mvc.*;
import play.data.validation.*;
 
import java.util.*;
 
import models.*;
 
@With(Secure.class)
public class Admin extends Controller {
    

    public static void index() {
        Recette frontRecette = Recette.find("order by title").first();
        List<Recette> olderRecettes = Recette.find(
            "order by title desc").from(0).fetch(5);
		String usermail = Security.connected();
		User currentUser = User.findByEmail(usermail);
        render(frontRecette,olderRecettes,currentUser);
    }

    public static void postRecipe(String userEmail, String title, String listIng, String content, int difficulte, String prix,
     int preparation, int cuisson) {
        User currentUser = User.findByEmail(userEmail);
        //User currentUser = User.findById(userId);

        currentUser.addRecipe(title,listIng,content,difficulte,prix,preparation,cuisson);
        RecettesAdmin.index(currentUser);
    }


	 
	
}
