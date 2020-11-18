package com.example.myofflinenews.models;

import android.os.AsyncTask;

public class PopulateDbAsync extends AsyncTask<Void,Void,Void> {
    private final NewsDao mDao;
    PopulateDbAsync(NewsDB db){
        mDao=db.newsItemDao();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        return null;
    }
}

