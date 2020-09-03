package com.michaelrademeyer.interviewtestquestion2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;

import java.util.List;

public class ViewAllData extends AppCompatActivity {

    AppDatabase db;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private  RecyclerView.LayoutManager layoutManager;
    public List<Person> people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_data);

        Intent intent = getIntent();
        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "quesetion2").build();
        //db = (AppDatabase) intent.getSerializableExtra(MainActivity.EXTRA_MESSAGE);


        PersonGetAllAsyncTask personGetAllAsyncTask = (PersonGetAllAsyncTask) new PersonGetAllAsyncTask(this, db).execute();



    }
}