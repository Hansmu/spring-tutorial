package com.udemy.recipeApp.domain;

import com.udemy.recipeApp.domain.types.Difficulty;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Set;

@Entity
//@Table(name = "recipe") // this isn't needed if the Java class name matches the table name.
public class Recipe {

    // Objects in the JVM get their own ID behind the scenes, but since we're saving it to a DB, then it doesn't have the same concept.
    @Id
    /* GeneratedValue states that the value for this field will be automatically generated. The default strategy is AUTO.
    * AUTO -
    *   Hibernate (or some other persistence provider that you're using) chooses what type of generation to use based on
    *   the type of the field. A numeric value bases it on the sequence or table generator. With Hibernate 5, you have
    *   an UUIDGenerator, so if you declare it of type UUID, then Hibernate will create the UUID itself. So it might
    *   turn to the DB, might not, decides on its own.
    * IDENTITY -
    *   The database is always responsible for determining and assigning the next primary key. Auto-increment DB column called
    *   an identity column.  An identity column has a start value, an increment, a maximum value, a minimum value, and a cycle option.
    *   A cycle option says if the keys will start cycling again if the min/max is reached.
    * SEQUENCE -
    *   Assign keys based on a database sequence. Have to specify the sequence name and using it in the class. Same as IDENTITY,
    *   have a sequence declared in a database with ID increasing strategies. It is not transactional, so if an insert
    *   wants to get an ID and the transaction fails, then it gets incremented, but the value remains unused.
    * TABLE -
    *   A separate table declared with pre-defined keys to use. Reads from over there. It's essentially to simulate a
    *   sequence, so it's legacy in most cases.
    * */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "description") // have to specify this if the column name is different from the property
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;

    // mappedBy specifies the property through which the relationship will be defined on the child object.
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients;

    // Gets marked as a blob in the DB. Lob - large object
    @Lob
    private Byte[] image;

    // The default EnumType is ORDINAL, which means it will get persisted as a number. So EASY - 1, MODERATE - 2 etc.
    // With EnumType.STRING, however, it gets persisted as "EASY", "MODERATE", etc.
    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    @ManyToMany
    // If Boot creates the DB for us, then it'll create different join tables if the name of one isn't  specified on
    // both ends of the relationship.
    @JoinTable(
            name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"), // These names are the default conventional names used, but you can add custom ones.
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
