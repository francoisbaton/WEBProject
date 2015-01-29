package controllers; 

import play.*;
import play.mvc.*;

@With(Secure.class)
public class Inscription extends Controller {

    public static void index() {
        //Recette frontRecette = Recette.find("order by title").first();
        /*List<Recette> olderRecettes = Recette.find(
            "").from(0).fetch(10);*/

  		//List<Recette> olderRecettes = Recette.find("select distinct r from Recette r where r.categorie = ?",
           // "Plat").fetch();

        render();
        
    }

}

