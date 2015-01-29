package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Search extends Controller {

    /*public static void index() {
        render();
    }*/

    /*public static void index() {
        render();
    }*/

     public static void index(String content) {

        //render(content);
        String contentOut = content;

        render(contentOut);
    }

}