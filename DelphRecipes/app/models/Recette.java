package models;
 
import java.util.*;
import javax.persistence.*;
 
import play.db.jpa.*;
 
@Entity
public class Recette extends Model {

    public String title;

    @ManyToOne
    public User author;
    
    public String listIng;

    @Lob
    public String content;
    
    public String categorie;

    public int difficulte;

    public String prix;

    public int preparation;
    
    public int cuisson;

    @OneToMany(mappedBy="recette", cascade=CascadeType.ALL)
    public List<Comment> comments;


 
    public Recette(String title,User author, String ingredients, String content, int diff, String prix,
     int preparation, int cuisson) {
        this.comments = new ArrayList<Comment>(); 
        this.author = author;
        this.title = title;
        this.content = content;
        this.listIng = ingredients;
        this.difficulte = diff;
        this.prix = prix;
        this.preparation = preparation;
        this.cuisson = cuisson;
    }

    public Recette addComment(String author, String content) {
        Comment newComment = new Comment(this, author, content).save();
        this.comments.add(newComment);
        this.save();
        return this;
    }

    /*
    public Post addRecette(String author, String content) {
    Comment newComment = new Comment(this, author, content).save();
    this.comments.add(newComment);
    this.save();
    return this;
    }
    */
 
}