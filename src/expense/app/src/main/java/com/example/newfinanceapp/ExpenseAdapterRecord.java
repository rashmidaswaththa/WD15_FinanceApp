package com.example.newfinanceapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
<<<<<<< HEAD
import android.os.Build;
=======
>>>>>>> 04e8260 (Add all files again)
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
<<<<<<< HEAD
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
=======
import android.widget.TextView;

import androidx.annotation.NonNull;
>>>>>>> 04e8260 (Add all files again)
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExpenseAdapterRecord extends RecyclerView.Adapter<ExpenseAdapterRecord.HolderRecord> {


    //variables
    private Context context;
    private Activity activity;
<<<<<<< HEAD
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
=======
    private ArrayList<ExpenseModelRecord> recordList;
    private ArrayList income_id, income_note, income_amount, income_category;

    //constructor
    public ExpenseAdapterRecord(Activity activity, Context context, ArrayList<ExpenseModelRecord> recordList) {
        this.context = context;
        this.recordList = recordList;
        this.activity = activity;

>>>>>>> 04e8260 (Add all files again)
    }

    @NonNull

    @Override
    public HolderRecord onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //infiate layout
        View view = LayoutInflater.from(context).inflate(R.layout.expense_row_record, parent, false);

        return new HolderRecord(view);
    }

<<<<<<< HEAD
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

=======
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


>>>>>>> 04e8260 (Add all files again)
    }

    @Override
    public int getItemCount() {
<<<<<<< HEAD
        return expense_id.size();//return size of recordlist
=======
        return recordList.size();//return size of recordlist
>>>>>>> 04e8260 (Add all files again)
    }


    class HolderRecord extends RecyclerView.ViewHolder {

        //VIEWS
        ImageView recordIv;
<<<<<<< HEAD
        TextView note, category, amount, pMethod , ex_id_txt;
        LinearLayout mainLayout;
=======
        TextView note, category, amount, pMethod;
        //LinearLayout mainLayout;

>>>>>>> 04e8260 (Add all files again)

        public HolderRecord(@NonNull View itemView) {
            super(itemView);

            //init views
<<<<<<< HEAD
            ex_id_txt = itemView.findViewById(R.id.ex_id_txt);
=======

>>>>>>> 04e8260 (Add all files again)
            note = itemView.findViewById(R.id.note);
            category = itemView.findViewById(R.id.category);
            pMethod = itemView.findViewById(R.id.pMethod);
            amount = itemView.findViewById(R.id.amount);
<<<<<<< HEAD
            mainLayout = itemView.findViewById(R.id.mainLayout);
=======
>>>>>>> 04e8260 (Add all files again)


        }
    }
}
