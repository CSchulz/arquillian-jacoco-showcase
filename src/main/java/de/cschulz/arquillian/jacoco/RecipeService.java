package de.cschulz.arquillian.jacoco;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class RecipeService {
    public Recipe createRecipe(String recipeName, List ingredients) {
        Recipe recipe = new Recipe(recipeName);
        recipe.addIngredients(ingredients);

        return recipe;
    }
}
