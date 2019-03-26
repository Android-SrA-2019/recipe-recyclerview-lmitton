package com.example.recipe;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {


    private final LinkedList<Recipe> recipeList;
    private LayoutInflater rInflater;

    public class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView rName;
        public final TextView rDesc;
        final RecipeAdapter rAdapter;

        public RecipeViewHolder(View itemView, RecipeAdapter adapter) {
            super(itemView);
            rName = itemView.findViewById(R.id.recipe_name);
            rDesc = itemView.findViewById(R.id.recipe_desc);
            this.rAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int rPosition = getLayoutPosition();
            Recipe recipe = recipeList.get(rPosition);
            rAdapter.notifyItemChanged(rPosition, recipe);
        }
    }

    public RecipeAdapter(Context context, LinkedList<Recipe> rList) {
        rInflater = LayoutInflater.from(context);
        this.recipeList = rList;
    }

    @NonNull
    @Override
    public RecipeAdapter.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rCardView = rInflater.inflate(R.layout.recipelist_item, parent, false);

        return new RecipeViewHolder(rCardView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeAdapter.RecipeViewHolder recipeViewHolder, int position) {
        Recipe recipe = recipeList.get(position);
        recipeViewHolder.rName.setText(recipe.name);
        recipeViewHolder.rDesc.setText(recipe.description);

    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }


}
