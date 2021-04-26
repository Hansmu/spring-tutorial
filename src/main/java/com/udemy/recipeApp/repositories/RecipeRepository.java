package com.udemy.recipeApp.repositories;

import com.udemy.recipeApp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

// CrudRepository takes two types - the class that you are persisting and the ID field's type.
// Uses reflection and generics then to set up the repositories.
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
