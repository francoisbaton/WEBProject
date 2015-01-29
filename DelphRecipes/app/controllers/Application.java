package controllers;

import play.*;
import play.mvc.*;
import java.util.*;
import models.*;



public class Application extends Controller {

    public static void index() {
        Recette frontRecette = Recette.find("order by title").first();
        List<Recette> olderRecettes = Recette.find(
            "order by title desc").from(0).fetch(5);
        render(frontRecette,olderRecettes);
    }

}
	