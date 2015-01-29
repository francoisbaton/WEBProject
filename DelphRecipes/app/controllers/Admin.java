package controllers;
 
import play.*;
import play.mvc.*;
import play.data.validation.*;
 
import java.util.*;
 
import models.*;
 
@With(Secure.class)
public class Admin extends Controller {
    
    @Before
    static void setConnectedUser() {
        if(Security.isConnected()) {
            User user = User.find("byEmail", Security.connected()).first();
            renderArgs.put("user", user.fullname);
        }
    }
	
    public static void index() {
        Recette frontRecette = Recette.find("order by title").first();
        List<Recette> olderRecettes = Recette.find(
            "order by title desc").from(0).fetch(5);
		String usermail = Security.connected();
		User currentUser = User.findByEmail(usermail);
        render(frontRecette,olderRecettes,currentUser);
    }
	 
	
}
