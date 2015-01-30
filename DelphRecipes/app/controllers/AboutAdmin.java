package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

@With(Secure.class)
public class AboutAdmin extends Controller {
	
	public static void index() {
		String usermail = Security.connected();
		User currentUser = User.findByEmail(usermail);
		render(currentUser);
    }
	
}