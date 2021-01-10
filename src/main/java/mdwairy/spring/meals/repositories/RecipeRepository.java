package mdwairy.spring.meals.repositories;


import mdwairy.spring.meals.models.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
