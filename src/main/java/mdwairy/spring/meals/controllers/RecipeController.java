package mdwairy.spring.meals.controllers;

import mdwairy.spring.meals.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/")
    public String showRecipes(Model model) {
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
