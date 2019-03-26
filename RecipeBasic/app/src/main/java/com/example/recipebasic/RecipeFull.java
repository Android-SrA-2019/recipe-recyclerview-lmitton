//Linda Mitton ~ 19 March 2019
package com.example.recipebasic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class RecipeFull extends AppCompatActivity {

    private static final String LOG_TAG = "FullRecipeActivity";
    private int rPosition = 0;
    private Recipe recipe;
    TextView rName;
    ImageView rImage;
    TextView rIngredients;
    TextView rDirections;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_full);
        Log.d(LOG_TAG, "Full Recipe started LLM");

        //get the id of the item to be retrieved from the intent
        rPosition = Integer.parseInt(getIntent().getStringExtra(MainActivity.ID_EXTRA));
        //get the individual item from the DataProvider
        recipe = DataProvider.getRecipes().get(rPosition);
        //put all the values from the recipe object retrieved into the various text and image views
        rName = findViewById(R.id.recipe_name_full);
        rName.setText(recipe.name);
        rImage = findViewById(R.id.recipe_imageView);
        Picasso.get().load(recipe.image).fit().placeholder(R.drawable.ic_launcher_background)
         .error(R.drawable.ic_launcher_background).into(rImage);
        rIngredients = findViewById(R.id.recipe_ingredients);
        rIngredients.setText(recipe.ingredients);
        rDirections = findViewById(R.id.recipe_directions);
        rDirections.setText(recipe.directions);

    }

}
