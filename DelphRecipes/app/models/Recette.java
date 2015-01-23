/*package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
public Enum Categorie (Entrees, Plats, Desserts);

@Entity
public class Recette extends Model {
 
    public String nom;
    public List<String> ingredients;
    public Categorie cat;
    public Date postedAt;

    @Lob
    public String descritption;
    
    @OneToOne
    public Resume resume;

    @ManyToOne
    public User auteur;

    public Recette(User auteur, Resume resume, String nom, List<String> ingredients, Categorie cat, String description) {
        this.nom = nom;
        this.ingredients = ingredients;
        this.cat = cat;
        this.description = description;  
        this.resume = resume;
	this.auteur = auteur;
	this.postedAt = new Date();
    }
 
}
*/