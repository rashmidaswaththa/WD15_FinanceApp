package com.example.newfinanceapp;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class SearchViewHolder extends RecyclerView.ViewHolder{

    public TextView name, amount, description;

    public SearchViewHolder(View itemView){
        super(itemView);
<<<<<<< HEAD
        name = (TextView)itemView.findViewById(R.id.goal_name_txt);
        amount = (TextView)itemView.findViewById(R.id.goal_amount_txt);
        description = (TextView)itemView.findViewById(R.id.goal_desc_txt);
=======
        name = (TextView)itemView.findViewById(R.id.in_name_txt);
        amount = (TextView)itemView.findViewById(R.id.in_amount_txt);
        description = (TextView)itemView.findViewById(R.id.in_desc_txt);
>>>>>>> 04e8260 (Add all files again)
    }

}

public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder> {

    private Context context;
    private List<Goal> goal;

    public SearchAdapter(Context context, List<Goal> goal) {
        this.context = context;
        this.goal = goal;
    }
    @Override
    public SearchViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.my_row,parent, false);
        return new SearchViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder( SearchViewHolder holder, int position) {
        holder.name.setText(goal.get(position).getName());
        holder.amount.setText(goal.get(position).getAmount());
<<<<<<< HEAD
        holder.description.setText(goal.get(position).getDescription());
=======
        holder.description.setText(goal.get(position).getDesscription());
>>>>>>> 04e8260 (Add all files again)
    }

    @Override
    public int getItemCount() {
        return goal.size();
    }
}
