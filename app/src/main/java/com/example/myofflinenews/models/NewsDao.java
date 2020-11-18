package com.example.myofflinenews.models;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Article> news);

    @Query("select * from article_info")
     LiveData<List<Article>> getAllnews();

    @Query("delete  from article_info")
      void   deleteAll();


}

