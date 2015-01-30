package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class SearchAdmin extends Controller {

    /*public static void index() {
        render();
    }*/

    /*public static void index() {
        render();
    }*/

     public static void index(String content) {
		String usermail = Security.connected();
		User currentUser = User.findByEmail(usermail);
        

        render(currentUser);
    }

}