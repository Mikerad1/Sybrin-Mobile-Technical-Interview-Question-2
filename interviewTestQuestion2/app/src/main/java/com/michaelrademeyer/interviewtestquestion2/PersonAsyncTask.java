package com.michaelrademeyer.interviewtestquestion2;

import android.os.AsyncTask;

import java.lang.ref.WeakReference;

public class PersonAsyncTask extends AsyncTask<Void, Void, Integer> {
    private WeakReference<MainActivity> weakActivity;
    private Person person;
    private AppDatabase db;

    public PersonAsyncTask(MainActivity activity, Person person, AppDatabase db){
        weakActivity = new WeakReference<>(activity);
        this.person = person;
        this.db = db;
    }

    @Override
    protected Integer doInBackground(Void... params){
        PersonDao personDao = db.personDao();
        personDao.insertAll(person);
        return 0;
    }
}
