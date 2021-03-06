package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
import play.data.validation.*;

import play.models.*;

@Entity
public class User extends Model {
    
    @Email
    @Required
    public String email;
    
    @Required
    public String password;
    public String fullname;
    public boolean isAdmin;
    
    public User(String email, String password, String fullname) {
        this.email = email;
        this.password = password;
        this.fullname = fullname;
    }
 
    public static User connect(String email, String password) {
        return find("byEmailAndPassword", email, password).first();
    }
    
    public static User findByEmail(String email) {
        return ((User) find("byEmail", email).first());
    }



    public User addRecipe(String title, String ingredients, String content, int diff, String prix,
     int preparation, int cuisson) {
        Recette newRecipe = new Recette(title,this, ingredients, content,diff,prix,preparation,cuisson).save();
        //this.comments.add(newRecipe);
        this.save();
        return this;
    }


}

