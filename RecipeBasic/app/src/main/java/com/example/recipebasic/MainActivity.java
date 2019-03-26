//Linda Mitton ~ 19 March 2019

package com.example.recipebasic;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;


import java.util.LinkedList;

public class MainActivity extends AppCompatActivity  { //implements RecipeAdapter.OnCardListner

    private LinkedList<Recipe> recipes = new LinkedList<>();
    private RecyclerView rRecyclerView;
    private RecipeAdapter rAdapter;
    public static final String ID_EXTRA = "com.example.recipebasic.extras._ID";
    private int rPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //establish the data list to display
        recipes = DataProvider.getRecipes();

        //Get the recyclerview id
        rRecyclerView = findViewById(R.id.recycler_view);

        //create an adapter and supply the data to be displayed
        rAdapter = new RecipeAdapter(this, recipes); //, this

        //connect the adapter with the recycler view
        rRecyclerView.setAdapter(rAdapter);

        //provide the recyclerview with a default layout manager
        rRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

//    @Override
//    public void onCardClick(int rPosition) {
//        recipes.get(rPosition);
//
//    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
