package de.cschulz.arquillian.jacoco;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private ArrayList<String> ingredients;

    private String name;

    public Recipe(String recipeName) {
        name = recipeName;
        ingredients = new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    public void addIngredient(String ingredient) {
        ingredients.add(ingredient);
    }

    public void addIngredients(List<String> ingredientsList) {
        ingredients.addAll(ingredientsList);
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public int getIngredientsCount() {
        return ingredients.size();
    }
}
