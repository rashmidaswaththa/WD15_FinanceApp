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

    public TextView type, amount, date;

    public SearchViewHolder(View itemView){
        super(itemView);
        type = (TextView)itemView.findViewById(R.id.in_type_txt);
        amount = (TextView)itemView.findViewById(R.id.in_amount_txt);
        date = (TextView)itemView.findViewById(R.id.in_date_txt);
    }

}

public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder> {

    private Context context;
    private List<Reminder> Reminder;

    public SearchAdapter(Context context, List<Income> income) {
        this.context = context;
        this.income = income;
    }
    @Override
    public SearchViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.my_row,parent, false);
        return new SearchViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder( SearchViewHolder holder, int position) {
        holder.type.setText(income.get(position).getType());
        holder.amount.setText(income.get(position).getAmount());
        holder.date.setText(income.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return reminder.size();
    }
}
