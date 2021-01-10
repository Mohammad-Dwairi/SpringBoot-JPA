package mdwairy.spring.meals.services;

import mdwairy.spring.meals.models.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
