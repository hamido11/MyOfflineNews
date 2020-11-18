package com.example.myofflinenews;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.myofflinenews.models.Article;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

   private LiveData<List<Article>> news;
   private Repository repository;
   private static final String TAG = "MainViewModel";

    public MainViewModel(    Application application) {
        super(application);
        repository = Repository.getInstance(application);
        news = repository.getmAllNews();
    }

    public LiveData<List<Article>> getNews() {
        return news;
    }
}
