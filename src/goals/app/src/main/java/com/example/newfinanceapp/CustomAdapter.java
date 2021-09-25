package com.example.newfinanceapp;

<<<<<<< HEAD
import android.annotation.SuppressLint;
=======
>>>>>>> 04e8260 (Add all files again)
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList goal_id, goal_name, goal_amount, goal_description;

<<<<<<< HEAD
    //Animation translate_anim;

    CustomAdapter(Activity activity, Context context, ArrayList goal_id, ArrayList goal_name, ArrayList goal_amount, ArrayList goal_description){
=======
    CustomAdapter(Activity activity, Context context, ArrayList goal_id, ArrayList goal_name, ArrayList goal_amount, ArrayList goal_desc){
>>>>>>> 04e8260 (Add all files again)

        this.activity = activity;
        this.context = context;
        this.goal_id = goal_id;
        this.goal_name = goal_name;
        this.goal_amount = goal_amount;
<<<<<<< HEAD
        this.goal_description = goal_description;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from((context));
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.goal_id_txt.setText(String.valueOf(goal_id.get(position)));
        holder.goal_name_txt.setText(String.valueOf(goal_name.get(position)));
        holder.goal_amount_txt.setText(String.valueOf(goal_amount.get(position)));
        holder.goal_desc_txt.setText(String.valueOf(goal_description.get(position)));
        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, updateGoal.class);
                intent.putExtra("id", String.valueOf(goal_id.get(position)));
                intent.putExtra("name", String.valueOf(goal_name.get(position)));
                intent.putExtra("amount", String.valueOf(goal_amount.get(position)));
                intent.putExtra("description", String.valueOf(goal_description.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });

    }

    @Override
    public int getItemCount()
    {
        return goal_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView goal_id_txt, goal_name_txt, goal_amount_txt, goal_desc_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            goal_id_txt = itemView.findViewById(R.id.goal_id_txt);
            goal_name_txt = itemView.findViewById(R.id.goal_name_txt);
            goal_amount_txt = itemView.findViewById(R.id.goal_amount_txt);
            goal_desc_txt = itemView.findViewById(R.id.goal_desc_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            //Animate Recyclerview
            //Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            //mainLayout.setAnimation(translate_anim);
        }
    }
}





/*
package com.example.newfinanceapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList goal_id, goal_name, goal_amount, goal_description;

    CustomAdapter(Activity activity, Context context, ArrayList goal_id, ArrayList goal_name, ArrayList goal_amount, ArrayList goal_description){

        this.activity = activity;
        this.context = context;
        this.goal_id = goal_id;
        this.goal_name = goal_name;
        this.goal_amount = goal_amount;
        this.goal_description = goal_description;
=======
        this.goal_desc = goal_description;
>>>>>>> 04e8260 (Add all files again)
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from((context));
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.goal_id_txt.setText(String.valueOf(goal_id.get(position)));
        holder.goal_name_txt.setText(String.valueOf(goal_name.get(position)));
        holder.goal_amount_txt.setText(String.valueOf(goal_amount.get(position)));
<<<<<<< HEAD
        holder.goal_desc_txt.setText(String.valueOf(goal_description.get(position)));
=======
        holder.goal_desc_txt.setText(String.valueOf(goal_desc.get(position)));
>>>>>>> 04e8260 (Add all files again)
        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
<<<<<<< HEAD
                Intent intent = new Intent(context, updateGoal.class);
                intent.putExtra("id", String.valueOf(goal_id.get(position)));
                intent.putExtra("name", String.valueOf(goal_name.get(position)));
                intent.putExtra("amount", String.valueOf(goal_amount.get(position)));
                intent.putExtra("description", String.valueOf(goal_description.get(position)));
=======
                Intent intent = new Intent(context, updateIncomeActivity.class);
                intent.putExtra("id", String.valueOf(goal_id.get(position)));
                intent.putExtra("name", String.valueOf(goal_name.get(position)));
                intent.putExtra("amount", String.valueOf(goal_amount.get(position)));
                intent.putExtra("description", String.valueOf(goal_desc.get(position)));
>>>>>>> 04e8260 (Add all files again)
                activity.startActivityForResult(intent, 1);
            }
        });

    }

    @Override
    public int getItemCount()
    {
<<<<<<< HEAD
        return goal_id.size();
=======
        return income_id.size();
>>>>>>> 04e8260 (Add all files again)
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView goal_id_txt, goal_name_txt, goal_amount_txt, goal_desc_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            goal_id_txt = itemView.findViewById(R.id.goal_id_txt);
            goal_name_txt = itemView.findViewById(R.id.goal_name_txt);
            goal_amount_txt = itemView.findViewById(R.id.goal_amount_txt);
            goal_desc_txt = itemView.findViewById(R.id.goal_desc_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            //Animate Recyclerview
            //Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
<<<<<<< HEAD
           //mainLayout.setAnimation(translate_anim);
        }
    }
}
*/
=======
           // mainLayout.setAnimation(translate_anim);
        }
    }
}

>>>>>>> 04e8260 (Add all files again)



