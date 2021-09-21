package com.example.newfinanceapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExpenseAdapterRecord extends RecyclerView.Adapter<ExpenseAdapterRecord.HolderRecord>{


    //variables
    private Context context;
    private ArrayList<ExpenseModelRecord> recordList;
    private RecyclerView mRecyclerV;

    //constructor
    public ExpenseAdapterRecord(Context context, ArrayList<ExpenseModelRecord> recordList){
        this.context = context;
        this.recordList = recordList;
    }

    @NonNull

    @Override
    public HolderRecord onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        //infiate layout
        View view = LayoutInflater.from(context).inflate(R.layout.row_record,parent,false);

        return new HolderRecord(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderRecord holder, int position) {
        //get data, se data, handle view click son this method


        //getdata
        ExpenseModelRecord modelRecord = recordList.get(position);
        String  id = modelRecord.getId();
        String  note = modelRecord.getNote();
        byte [] image = modelRecord.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
        String paymethod = modelRecord.getPay_method();
        String category = modelRecord.getCategory();
        String amount = modelRecord.getAmount();

        //setdata
        holder.note.setText(note);
        holder.pMethod.setText(paymethod);
        holder.category.setText(category);
        holder.amount.setText(amount);
        holder.recordIv.setImageBitmap(bitmap);

        //handle item clicks
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (context, UpdateExpenseActivity.class);
                intent.putExtra("_id", id);
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return recordList.size();//return size of recordlist
    }


    class HolderRecord extends RecyclerView.ViewHolder{

        //VIEWS
        ImageView recordIv;
        TextView note, category, amount, pMethod;
        LinearLayout mainLayout;


        public HolderRecord(@NonNull  View itemView) {
            super(itemView);

            //init views
            recordIv = itemView.findViewById(R.id.recordIv);
            note = itemView.findViewById(R.id.note);
            category = itemView.findViewById(R.id.category);
            pMethod= itemView.findViewById(R.id.pMethod);
            amount = itemView.findViewById(R.id.amount);




        }
    }
}
