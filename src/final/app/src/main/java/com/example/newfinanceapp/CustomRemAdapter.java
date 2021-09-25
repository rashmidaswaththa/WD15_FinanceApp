package com.example.newfinanceapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class CustomRemAdapter extends RecyclerView.Adapter<CustomRemAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList reminder_id, reminder_type, reminder_amount, reminder_date;

    CustomRemAdapter(Activity activity, Context context, ArrayList reminder_id, ArrayList reminder_type, ArrayList reminder_amount, ArrayList reminder_date){

        this.activity = activity;
        this.context = context;
        this.reminder_id = reminder_id;
        this.reminder_type = reminder_type;
        this.reminder_amount = reminder_amount;
        this.reminder_date = reminder_date;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from((context));
        View view = inflater.inflate(R.layout.my_row_rem, parent, false);
        return new MyViewHolder(view);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.rm_id_txt.setText(String.valueOf(reminder_id.get(position)));
        holder.rm_type_txt.setText(String.valueOf(reminder_type.get(position)));
        holder.rm_amount_txt.setText(String.valueOf(reminder_amount.get(position)));
        holder.rm_date_txt.setText(String.valueOf(reminder_date.get(position)));
        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, updateRemActivity.class);
                intent.putExtra("id", String.valueOf(reminder_id.get(position)));
                intent.putExtra("type", String.valueOf(reminder_type.get(position)));
                intent.putExtra("amount", String.valueOf(reminder_amount.get(position)));
                intent.putExtra("date", String.valueOf(reminder_date.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });

    }

    @Override
    public int getItemCount() {
        return reminder_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView rm_id_txt, rm_type_txt, rm_amount_txt, rm_date_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            rm_id_txt = itemView.findViewById(R.id.rm_id_txt);
            rm_type_txt = itemView.findViewById(R.id.rm_type_txt);
            rm_amount_txt = itemView.findViewById(R.id.rm_amount_txt);
            rm_date_txt = itemView.findViewById(R.id.rm_date_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            //Animate Recyclerview
            //Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
           // mainLayout.setAnimation(translate_anim);
        }
    }
}


/*

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.book_id_txt.setText(String.valueOf(book_id.get(position)));
        holder.book_title_txt.setText(String.valueOf(book_title.get(position)));
        holder.book_author_txt.setText(String.valueOf(book_author.get(position)));
        holder.book_pages_txt.setText(String.valueOf(book_pages.get(position)));
        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(book_id.get(position)));
                intent.putExtra("title", String.valueOf(book_title.get(position)));
                intent.putExtra("author", String.valueOf(book_author.get(position)));
                intent.putExtra("pages", String.valueOf(book_pages.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return book_id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView in_id_txt, in_note_txt, in_amount_txt, in_cat_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            book_id_txt = itemView.findViewById(R.id.book_id_txt);
            book_title_txt = itemView.findViewById(R.id.book_title_txt);
            book_author_txt = itemView.findViewById(R.id.book_author_txt);
            book_pages_txt = itemView.findViewById(R.id.book_pages_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            //Animate Recyclerview
            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }

    }

}*/

