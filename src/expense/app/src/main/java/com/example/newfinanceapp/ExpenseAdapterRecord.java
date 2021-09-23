package com.example.newfinanceapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExpenseAdapterRecord extends RecyclerView.Adapter<ExpenseAdapterRecord.HolderRecord> {


    //variables
    private Context context;
    private Activity activity;
    private ArrayList<ExpenseModelRecord> recordList;
    private ArrayList income_id, income_note, income_amount, income_category;

    //constructor
    public ExpenseAdapterRecord(Activity activity, Context context, ArrayList<ExpenseModelRecord> recordList) {
        this.context = context;
        this.recordList = recordList;
        this.activity = activity;

    }

    @NonNull

    @Override
    public HolderRecord onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //infiate layout
        View view = LayoutInflater.from(context).inflate(R.layout.expense_row_record, parent, false);

        return new HolderRecord(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderRecord holder, int position) {
        //get data, se data, handle view click son this method


        //getdata
        ExpenseModelRecord modelRecord = recordList.get(position);
        String id = modelRecord.getId();
        String note = modelRecord.getNote();
        String paymethod = modelRecord.getPay_method();
        String category = modelRecord.getCategory();
        String amount = modelRecord.getAmount();

        //setdata
        holder.note.setText(note);
        holder.pMethod.setText(paymethod);
        holder.category.setText(category);
        holder.amount.setText(amount);


        //handle item clicks
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateExpenseActivity.class);
                intent.putExtra("_id", id);
                intent.putExtra("expense_note", note);
                intent.putExtra("expense_amount", amount);
                intent.putExtra("payment_method", paymethod);
                intent.putExtra("expense_category", category);

                activity.startActivityForResult(intent, 1);

            }
        });


    }

    @Override
    public int getItemCount() {
        return recordList.size();//return size of recordlist
    }


    class HolderRecord extends RecyclerView.ViewHolder {

        //VIEWS
        ImageView recordIv;
        TextView note, category, amount, pMethod;
        //LinearLayout mainLayout;


        public HolderRecord(@NonNull View itemView) {
            super(itemView);

            //init views

            note = itemView.findViewById(R.id.note);
            category = itemView.findViewById(R.id.category);
            pMethod = itemView.findViewById(R.id.pMethod);
            amount = itemView.findViewById(R.id.amount);


        }
    }
}
