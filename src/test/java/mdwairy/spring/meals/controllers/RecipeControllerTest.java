package mdwairy.spring.meals.controllers;

import mdwairy.spring.meals.models.Recipe;
import mdwairy.spring.meals.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RecipeControllerTest {

    RecipeController recipeController;

    @Mock
    RecipeService recipeService;

    @Mock //Mockito is used to mock interfaces so that a dummy functionality can be added to a mock interface that can be used in unit testing.
    Model model;

    @BeforeEach
    public void setUp() {
        // Initializes fields annotated with mockito annotations.
        //Allows shorthand creation of objects required for testing. Minimizes repetitive mock creation code. Makes the test class more readable.
        MockitoAnnotations.initMocks(this);
        recipeController = new RecipeController(recipeService);
    }

    @Test
    void showRecipes() {

        // Given
        Set<Recipe> recipes = new HashSet<>();
        recipes.add(new Recipe());
        recipes.add(new Recipe());

        Mockito.when(recipeService.getRecipes()).thenReturn(recipes);

        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        // When
        String viewName = recipeController.showRecipes(model);

        // Then
        assertEquals("index", viewName);

        // Mockito Verify methods are used to check that certain behavior happened.
        // We can use Mockito verify methods at the end of the testing method code to make sure that specified methods are called.
        // Mockito times used to specify the number of calls to the method.
        Mockito.verify(recipeService, Mockito.times(1)).getRecipes();
        Mockito.verify(model, Mockito.times(1)).addAttribute(Mockito.eq("recipes"), argumentCaptor.capture());
        Set<Recipe> setInController = argumentCaptor.getValue();
        assertEquals(2, setInController.size());
    }
}