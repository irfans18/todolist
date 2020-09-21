package com.irfams.todolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView titlepage, subtitlepage, endpage;
    DatabaseReference reference;
    RecyclerView ourdoes;
    ArrayList<ToDoList> lists;
    DoesAdapter doesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titlepage = (TextView)findViewById(R.id.titlepage);
        subtitlepage = (TextView)findViewById(R.id.subtitlepage);
        endpage = (TextView)findViewById(R.id.endpage);

        /*//import font
        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/ML.ttf")
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MM.ttf")

         //costumize font
        titlepage.setTypeface(MLight);
        subtitlepage.setTypeface(MMedium);
        endpage.setTypeface(MLight);*/
        //working with database
        ourdoes = findViewById(R.id.ourdoes);
        ourdoes.setLayoutManager(new LinearLayoutManager(this));
        lists = new ArrayList<ToDoList>();

        //get data from firebase
        reference = FirebaseDatabase.getInstance().getReference().child("todolistapp");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //retrieve data
                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    ToDoList toDoList = dataSnapshot1.getValue(ToDoList.class);
                    lists.add(toDoList);
                }
                doesAdapter = new DoesAdapter(MainActivity.this, lists);
                ourdoes.setAdapter(doesAdapter);
                doesAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //show an error
                Toast.makeText(getApplicationContext(), "No Data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}