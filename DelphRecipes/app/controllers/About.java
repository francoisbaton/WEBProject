package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

@With(Secure.class)
public class About extends Controller {
	
	public static void index() {
        render();
    }
	
	public static void index(User user) {
        render(user);
    }
}