package com.example.newfinanceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SecondActivity extends AppCompatActivity {

    RecyclerView recycle_view;
    FloatingActionButton floatButton;

    //DB helper
    private MyDatabaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //Tool bar
        ImageView left_arrow = findViewById(R.id.left_arrow);
        ImageView check = findViewById(R.id.check);
        TextView title = findViewById(R.id.title);

        //display list and floating action button
        recycle_view = findViewById(R.id.dataDisplay_listRv);
        floatButton = findViewById(R.id.floatingAction_add);

        //init db helper class
        DB = new MyDatabaseHelper(this);

        //load records
        loadRecords();


        floatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(newIntent);
            }
        });

        left_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this, "You clicked in left icon" , Toast.LENGTH_SHORT).show();
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SecondActivity.this, "Inserted Successfully" , Toast.LENGTH_SHORT).show();
            }
        });

        title.setText("Manage Expense");
    }

    private void loadRecords() {
        ExpenseAdapterRecord adapterRecord = new ExpenseAdapterRecord(SecondActivity.this, DB.getAllRecords("MAX(_id)"));
        recycle_view.setAdapter(adapterRecord);
    }

    private void searchRecords(String query){
        ExpenseAdapterRecord adapterRecord = new ExpenseAdapterRecord(SecondActivity.this, DB.searchRecords(query));
        recycle_view.setAdapter(adapterRecord);
    }

    @Override
    protected void onResume() {
        super.onResume();

        loadRecords();//refresh record list

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchRecords(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                searchRecords(s);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}