package com.example.skyrider.mobopsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RecyclerView myRecyclerView;
    MyAdapter myAdapter;
    Spinner mySpinner;
    ArrayAdapter<CharSequence> spinAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myRecyclerView = (RecyclerView) findViewById(R.id.rv_numbers);
        myAdapter = new MyAdapter(this,Data.getData());
        myRecyclerView.setAdapter(myAdapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(layoutManager);
        myRecyclerView.setHasFixedSize(true);


        mySpinner = (Spinner) findViewById(R.id.spinner_options);
        spinAdapter = ArrayAdapter.createFromResource(this,R.array.options,R.layout.spinner_layout);
        spinAdapter.setDropDownViewResource(R.layout.spinner_layout);
        mySpinner.setAdapter(spinAdapter);



        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), (CharSequence) parent.getItemAtPosition(position),Toast.LENGTH_SHORT).show();

                if(position==1){
                    myAdapter = new MyAdapter(getBaseContext(),EvenData.getData());
                    myRecyclerView.setAdapter(myAdapter);
                }
                else if(position==2){
                    myAdapter = new MyAdapter(getBaseContext(),OddData.getData());
                    myRecyclerView.setAdapter(myAdapter);
                }
                else{ myAdapter = new MyAdapter(getBaseContext(),Data.getData());
                    myRecyclerView.setAdapter(myAdapter);
                }
                myAdapter.notifyDataSetChanged();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




    }
}
