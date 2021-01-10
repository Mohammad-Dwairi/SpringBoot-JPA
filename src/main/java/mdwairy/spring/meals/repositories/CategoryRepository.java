package mdwairy.spring.meals.repositories;

import mdwairy.spring.meals.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
