package com.udemy.recipeApp.repositories;

import com.udemy.recipeApp.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
