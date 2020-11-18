package com.example.myofflinenews;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.util.Log;

import com.example.myofflinenews.models.NewsDB;
import com.example.myofflinenews.models.NewsDao;
import com.example.myofflinenews.models.Article;
import com.example.myofflinenews.network.Root;
import com.example.myofflinenews.network.NewsInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {

    private static final String TAG = "debug";
    private static Repository instance;
    public List<Article> news=new ArrayList<>();
    private Call<Root> call;
    private NewsDao newsItemDao;
    LiveData<List<Article>> mAllNews;

    private Repository(Application application) {
        NewsDB newsDB = NewsDB.getDatabase(application);
        newsItemDao = newsDB.newsItemDao();
        mAllNews = newsItemDao.getAllnews();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NewsInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NewsInterface newsInterface = retrofit.create(NewsInterface.class);
        call = newsInterface.getNews();
        call.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                if(!response.isSuccessful()){
                    Log.d(TAG, "onResponse: "+response.code());
                    return;

                }
                news=response.body().articles;
                insertPosts(news);
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {

            }
        });
    }


    public static Repository getInstance(Application application) {
        if (instance == null)
            instance = new Repository(application);
        return instance;
    }

    public void insertPosts(List<Article> articles) {
        this.news=articles;
        new insertAsyncTask(newsItemDao).execute(articles);


    }

    public LiveData<List<Article>> getmAllNews() {
        return mAllNews;
    }
    // public MutableLiveData<ArrayList<News>> getNews() {
    //getServerData();
    //   return news;
    //}
    // public LiveData<ArrayList<News>> getAllNews() {
    //   newsDao.getAllnews();
    // return news;}


    private static class insertAsyncTask extends AsyncTask<List<Article>, Void, Void> {

        private NewsDao mAsyncTaskDao;

        insertAsyncTask(NewsDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final List<Article>... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }

    }
}
