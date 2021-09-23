package com.example.newfinanceapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExpenseAdapterRecord extends RecyclerView.Adapter<ExpenseAdapterRecord.HolderRecord> {


    //variables
    private Context context;
    private Activity activity;
    private ArrayList expense_id, expense_note, expense_amount,expense_paymethod, expense_category ;


    //constructor


    public ExpenseAdapterRecord(Context context, Activity activity, ArrayList expense_id, ArrayList expense_note, ArrayList expense_amount, ArrayList expense_paymethod, ArrayList expense_category) {
        this.context = context;
        this.activity = activity;
        this.expense_id = expense_id;
        this.expense_note = expense_note;
        this.expense_amount = expense_amount;
        this.expense_paymethod = expense_paymethod;
        this.expense_category = expense_category;
    }

    @NonNull

    @Override
    public HolderRecord onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //infiate layout
        View view = LayoutInflater.from(context).inflate(R.layout.expense_row_record, parent, false);

        return new HolderRecord(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final HolderRecord holder,  final int position) {


        //get data, se data, handle view click son this method
        holder.ex_id_txt.setText(String.valueOf(expense_id.get(position)));
        holder.note.setText(String.valueOf(expense_note.get(position)));
        holder.amount.setText(String.valueOf(expense_amount.get(position)));
        holder.pMethod.setText(String.valueOf(expense_paymethod.get(position)));
        holder.category.setText(String.valueOf(expense_category.get(position)));
        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateExpenseActivity.class);
                intent.putExtra("id", String.valueOf(expense_id.get(position)));
                intent.putExtra("note", String.valueOf(expense_note.get(position)));
                intent.putExtra("amount", String.valueOf(expense_amount.get(position)));
                intent.putExtra("method", String.valueOf(expense_paymethod.get(position)));
                intent.putExtra("category", String.valueOf(expense_category.get(position)));
                activity.startActivityForResult(intent, 1);
            }


        });

    }

    @Override
    public int getItemCount() {
        return expense_id.size();//return size of recordlist
    }


    class HolderRecord extends RecyclerView.ViewHolder {

        //VIEWS
        ImageView recordIv;
        TextView note, category, amount, pMethod , ex_id_txt;
        LinearLayout mainLayout;

        public HolderRecord(@NonNull View itemView) {
            super(itemView);

            //init views
            ex_id_txt = itemView.findViewById(R.id.ex_id_txt);
            note = itemView.findViewById(R.id.note);
            category = itemView.findViewById(R.id.category);
            pMethod = itemView.findViewById(R.id.pMethod);
            amount = itemView.findViewById(R.id.amount);
            mainLayout = itemView.findViewById(R.id.mainLayout);


        }
    }
}
