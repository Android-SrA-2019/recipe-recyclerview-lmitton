//Linda Mitton ~ 19 March 2019
package com.example.recipebasic;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

import static android.support.v4.content.ContextCompat.startActivity;
import static com.example.recipebasic.MainActivity.ID_EXTRA;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {

    private final LinkedList<Recipe> recipeList;
    private LayoutInflater rInflater;
   // private OnCardListner rOnCardListner;
    private Context rContext;

    public RecipeAdapter(Context context, LinkedList<Recipe> rList) { //, OnCardListner onCardListner
        rInflater = LayoutInflater.from(context);
        this.recipeList = rList;
        //this.rOnCardListner = onCardListner;
        this.rContext = context;
    }

    public class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView rName;
        public final TextView rDesc;
        final RecipeAdapter rAdapter;
        public final CardView rCard;
        public int rPosition=0;

        public RecipeViewHolder(View itemView, RecipeAdapter adapter) { //, OnCardListner onCardListner
            super(itemView);
            rName = itemView.findViewById(R.id.recipe_name_list);
            rDesc = itemView.findViewById(R.id.recipe_desc_list);
            rCard = itemView.findViewById(R.id.card_view);
            this.rAdapter = adapter;
            //this.onCardListner = onCardListner;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            Intent intent = new Intent(rContext, RecipeFull.class);
            intent.putExtra(ID_EXTRA, String.valueOf(rPosition));
            rContext.startActivity(intent);
        }
    }


    @NonNull
    @Override
    public RecipeAdapter.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View rCardView = rInflater.inflate(R.layout.recipelist_item, parent, false);
        return new RecipeViewHolder(rCardView, this); //, rOnCardListner
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeAdapter.RecipeViewHolder recipeViewHolder, int position) {
        Recipe recipe = recipeList.get(position);
        recipeViewHolder.rPosition = position;
        recipeViewHolder.rName.setText(recipe.name);
        recipeViewHolder.rDesc.setText(recipe.description);
     }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

//    public interface OnCardListner{
//        void onCardClick(int rPosition);
//    }
}
