package mdwairy.spring.meals.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    Category category;

    @BeforeEach // @BeforeEach runs before the execution of each test
    public void setUp() {
        category = new Category(); // create new Category instance before each test
    }
    @Test // Test1
    void getDescription() {
    }

    @Test // Test2
    void getId() {
        category.setId(4L);
        assertEquals(4L, category.getId());
    }
}