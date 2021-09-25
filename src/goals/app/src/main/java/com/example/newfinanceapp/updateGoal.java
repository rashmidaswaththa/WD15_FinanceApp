package com.example.newfinanceapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

<<<<<<< HEAD
public class updateGoal extends AppCompatActivity {

    EditText name_input, amount_input, description_input;
    Button update_button;
    ImageButton back_button2 , delete_button;

    String id, name, amount, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_goal);

        name_input = findViewById(R.id.updateField1_text);
        amount_input = findViewById(R.id.updateField2_text);
        description_input = findViewById(R.id.updateField3_text);
        update_button = findViewById(R.id.update_button);
        back_button2 = findViewById(R.id.back_button2);
        delete_button = findViewById(R.id.delete_button);

        //First we call this
        getAndSetIntentData();

        //Set actionbar title after getAndSetIntentData method
        /*ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(title);
        }*/

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = name_input.getText().toString();
                String amount = amount_input.getText().toString();
                String description = description_input.getText().toString();


                //making a function for validation and pass all parameters
                boolean  check= validateinfo(name,amount,description);

                if (check == true) {
                    //And only then we call this
                    MyDatabaseHelper myDB = new MyDatabaseHelper(updateGoal.this);
                    name = name_input.getText().toString().trim();
                    amount = amount_input.getText().toString().trim();
                    description = description_input.getText().toString().trim();
                    myDB.updateData(id, name, amount, description);

                    Toast.makeText(getApplicationContext(),"Updated Succesfully",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Sorry check information again",Toast.LENGTH_SHORT).show();
                }
                }

        });
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });

        back_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (updateGoal.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("name") &&
                getIntent().hasExtra("amount") && getIntent().hasExtra("description")){
            //Getting Data from Intent
            id = getIntent().getStringExtra("id");
            name = getIntent().getStringExtra("name");
            amount = getIntent().getStringExtra("amount");
            description = getIntent().getStringExtra("description");

            //Setting Intent Data
            name_input.setText(name);
            amount_input.setText(amount);
            description_input.setText(description);
            Log.d("stev", name+" "+amount+" "+description);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }



    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + name + " ?");
        builder.setMessage("Are you sure you want to delete " + name + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(updateGoal.this);
                myDB.deleteOneRow(id);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }

    //validation
    private boolean validateinfo(String name, String amount, String description) {
        if (name.length() == 0) {
            //checking for null goal name inputs
            name_input.requestFocus();
            name_input.setError("THIS FIELD CAN NOT BE EMPTY");
            return false;
        } else if (!name.matches("^\\s*[\\da-zA-Z][\\da-zA-Z\\s]*$")) {
            //checking for relevant input types for the field
            name_input.requestFocus();
            name_input.setError("ENTER ONLY ALPHABETICAL CHARACTERS");
            return false;
        } else if (amount.length() == 0) {
            //checking for null amount inputs
            amount_input.requestFocus();
            amount_input.setError("FIELD CAN NOT BE EMPTY");
            return false;
        } else if (!amount.matches("\\d+")) {
            //checking for relevant input types for the field
            amount_input.requestFocus();
            amount_input.setError("PLEASE ENTER NUMBERS");
            return false;
        } else if (description.length() == 0) {
            //checking for null description inputs
            description_input.requestFocus();
            description_input.setError("FILED CAN NOT BE EMPTY");
            return false;
        } else if (!name.matches("^\\s*[\\da-zA-Z][\\da-zA-Z\\s]*$")) {
            //checking for relevant input types for the field
            description_input.requestFocus();
            description_input.setError("ENTER ONLY ALPHABETICAL CHARACTERS");
            return false;
        }
        else {
            return true;
        }
    }
}

/*
package com.example.newfinanceapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class updateGoal extends AppCompatActivity {
=======
public class updateGoalActivity extends AppCompatActivity {
>>>>>>> 04e8260 (Add all files again)

    EditText goal_input, amount_input, desc_input;
    Button update_button;
    ImageButton back_button2 , delete_button;

<<<<<<< HEAD
    String id, goal, amount, description;
=======
    String id, goal, amount, desc;
>>>>>>> 04e8260 (Add all files again)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        setContentView(R.layout.activity_update_goal);
=======
        setContentView(R.layout.activity_update_income);
>>>>>>> 04e8260 (Add all files again)

        goal_input = findViewById(R.id.updateField1_text);
        amount_input = findViewById(R.id.updateField2_text);
        desc_input = findViewById(R.id.updateField3_text);
        update_button = findViewById(R.id.update_button);
        back_button2 = findViewById(R.id.back_button2);
        delete_button = findViewById(R.id.delete_button);

        //First we call this
        getAndSetIntentData();

        //Set actionbar title after getAndSetIntentData method
        /*ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(title);
        }*/
<<<<<<< HEAD
/*
=======

>>>>>>> 04e8260 (Add all files again)
        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //And only then we call this
<<<<<<< HEAD
                MyDatabaseHelper myDB = new MyDatabaseHelper(updateGoal.this);
                goal = goal_input.getText().toString().trim();
                amount = amount_input.getText().toString().trim();
                description = desc_input.getText().toString().trim();
                myDB.updateData(id, goal, amount, description);
=======
                MyDatabaseHelper myDB = new MyDatabaseHelper(updateGoalActivity.this);
                goal = goal_input.getText().toString().trim();
                amount = amount_input.getText().toString().trim();
                desc = desc_input.getText().toString().trim();
                myDB.updateData(id, goal, amount, desc);
>>>>>>> 04e8260 (Add all files again)
            }
        });
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });

        back_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
<<<<<<< HEAD
                Intent intent = new Intent (updateGoal.this, MainActivity.class);
=======
                Intent intent = new Intent (updateGoalActivity.this, MainActivity.class);
>>>>>>> 04e8260 (Add all files again)
                startActivity(intent);
            }
        });

    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("goal") &&
<<<<<<< HEAD
                getIntent().hasExtra("amount") && getIntent().hasExtra("description")){
            //Getting Data from Intent
            id = getIntent().getStringExtra("id");
            goal = getIntent().getStringExtra("goal");
            amount = getIntent().getStringExtra("amount");
            description = getIntent().getStringExtra("description");

            //Setting Intent Data
            goal_input.setText(goal);
            amount_input.setText(amount);
            desc_input.setText(description);
            Log.d("stev", goal+" "+amount+" "+description);
=======
                getIntent().hasExtra("amount") && getIntent().hasExtra("desc")){
            //Getting Data from Intent
            id = getIntent().getStringExtra("id");
            note = getIntent().getStringExtra("goal");
            amount = getIntent().getStringExtra("amount");
            category = getIntent().getStringExtra("desc");

            //Setting Intent Data
            note_input.setText(goal);
            amount_input.setText(amount);
            category_input.setText(desc);
            Log.d("stev", goal+" "+amount+" "+desc);
>>>>>>> 04e8260 (Add all files again)
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }



   void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + goal + " ?");
        builder.setMessage("Are you sure you want to delete " + goal + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
<<<<<<< HEAD
                MyDatabaseHelper myDB = new MyDatabaseHelper(updateGoal.this);
=======
                MyDatabaseHelper myDB = new MyDatabaseHelper(updateGoalActivity.this);
>>>>>>> 04e8260 (Add all files again)
                myDB.deleteOneRow(id);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
<<<<<<< HEAD
}*/
=======
}
>>>>>>> 04e8260 (Add all files again)
