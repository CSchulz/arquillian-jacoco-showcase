package de.cschulz.arquillian.jacoco;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@Category(Arquillian.class)
@RunWith(Arquillian.class)
public class RecipeServiceTest {

    private static final String RECIPE_NAME = "Cookie";
    private static final String[] RECIPE_INGREDIENTS = new String[]{"Egg", "Chocolade", "Meal", "Milk"};

    @Inject
    private RecipeService service;

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClasses(Recipe.class, RecipeService.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void testCreateRecipe() throws Exception {
        Recipe recipe = service.createRecipe(RECIPE_NAME, Arrays.asList(RECIPE_INGREDIENTS));

        assertEquals(recipe.getName(), RECIPE_NAME);
        assertEquals(recipe.getIngredientsCount(), RECIPE_INGREDIENTS.length);
    }
}