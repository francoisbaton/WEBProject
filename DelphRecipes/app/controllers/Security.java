package controllers;
 
import models.*;
import play.mvc.Http.Request;
 
public class Security extends Secure.Security {
	
    static boolean authenticate(String username, String password) {
        return User.connect(username, password) != null;
    }
    
	static boolean check(String profile) {
		if("admin".equals(profile)) {
			return User.find("byEmail", connected()).<User>first().isAdmin;
		}
		return false;
	}
	
	static void onDisconnected(){
		Application.index();
		
	}
	
	static void onAuthenticated(){
		Admin.index();
	}
	
	/**
	   * Return the email of the logged in user, or null if no logged in user.
	   * 
	   * @param ctx the context containing the session
	   * @return The email of the logged in user, or null if user is not logged in.
	   
	  public static String getUser(Context ctx) {
		return ctx.session().get("email");
	  }
	  
	  /**
	   * True if there is a logged in user, false otherwise.
	   * @param ctx The context.
	   * @return True if user is logged in.
	   
	  public static boolean isLoggedIn(Context ctx) {
		return (getUser(ctx) != null);
	  }
	*/
	
}