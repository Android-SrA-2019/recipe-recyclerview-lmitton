//Linda Mitton ~ 19 March, 2019
package com.example.recipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private LinkedList<Recipe> recipes = new LinkedList<>();
    private RecyclerView rRecyclerView;
    private RecipeAdapter rAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //establish the data list to display
        recipes = DataProvider.getRecipes();

        //Get the recyclerview id
        rRecyclerView = findViewById(R.id.recyclerview);

        //create an adapter and supply the data to be displayed
        rAdapter = new RecipeAdapter(this, recipes);

        //connect the adapter with the recycler view
        rRecyclerView.setAdapter(rAdapter);

        //provide the recyclerview with a default layout manager
        rRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


}
