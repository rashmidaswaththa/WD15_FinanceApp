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
<<<<<<< HEAD
        type = (TextView)itemView.findViewById(R.id.rm_type_txt);
        amount = (TextView)itemView.findViewById(R.id.rm_amount_txt);
        date = (TextView)itemView.findViewById(R.id.rm_date_txt);
=======
        type = (TextView)itemView.findViewById(R.id.in_type_txt);
        amount = (TextView)itemView.findViewById(R.id.in_amount_txt);
        date = (TextView)itemView.findViewById(R.id.in_date_txt);
>>>>>>> 04e8260 (Add all files again)
    }

}

public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder> {

    private Context context;
<<<<<<< HEAD
    private List<Reminder> reminder;

    public SearchAdapter(Context context, List<Reminder> reminder) {
        this.context = context;
        this.reminder= reminder;
=======
    private List<Reminder> Reminder;

    public SearchAdapter(Context context, List<Income> income) {
        this.context = context;
        this.income = income;
>>>>>>> 04e8260 (Add all files again)
    }
    @Override
    public SearchViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.my_row,parent, false);
        return new SearchViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder( SearchViewHolder holder, int position) {
<<<<<<< HEAD
        holder.type.setText(reminder.get(position).getType());
        holder.amount.setText(reminder.get(position).getAmount());
        holder.date.setText(reminder.get(position).getDate());
=======
        holder.type.setText(income.get(position).getType());
        holder.amount.setText(income.get(position).getAmount());
        holder.date.setText(income.get(position).getDate());
>>>>>>> 04e8260 (Add all files again)
    }

    @Override
    public int getItemCount() {
        return reminder.size();
    }
}
