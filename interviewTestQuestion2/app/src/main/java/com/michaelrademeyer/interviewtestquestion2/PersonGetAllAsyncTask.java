package com.michaelrademeyer.interviewtestquestion2;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonGetAllAsyncTask extends AsyncTask<Void, Void, List<Person>> {
    private WeakReference<ViewAllData> weakActivity;
    private Person person;
    private AppDatabase db;
    public List<Person> people;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private  RecyclerView.LayoutManager layoutManager;
    public Boolean jobComplete = true;
    private ListView mListView;

    public PersonGetAllAsyncTask(ViewAllData activity, AppDatabase db){
        jobComplete = false;
        weakActivity = new WeakReference<>(activity);
        this.person = person;
        this.db = db;
    }

    @Override
    protected List<Person> doInBackground(Void... params){
        PersonDao personDao = db.personDao();
        people = personDao.getAll();
        return people;
    }

    @Override
    protected void onPostExecute (List<Person> result){
        //recyclerView = (RecyclerView) weakActivity.get().findViewById(R.id.recyclerView);

        //recyclerView.setHasFixedSize(true);

        //layoutManager = new LinearLayoutManager(weakActivity.get());
        //recyclerView.setLayoutManager(layoutManager);
        mListView = (ListView)weakActivity.get().findViewById(R.id.listView);
        ArrayList<String> data = new ArrayList<String>();
        for (int i = 0; i < people.size(); i++){
            String stringData = people.get(i).firstName + " | " + people.get(i).lastName + " | " + people.get(i).country + " | " + people.get(i).age;
            data.add(stringData);

        }
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(weakActivity.get(), android.R.layout.simple_list_item_1, data);
        //mAdapter = new MyAdapter(adapter);
        //recyclerView.setAdapter(adapter);
        mListView.setAdapter(adapter);
    }

}
