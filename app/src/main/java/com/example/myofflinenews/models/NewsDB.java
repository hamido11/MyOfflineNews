package com.example.myofflinenews.models;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

@Database(entities = {Article.class},version = 2,exportSchema = false)
public abstract class NewsDB extends RoomDatabase {
    public abstract NewsDao newsItemDao();
    private static volatile NewsDB INSTANCE;

   public static  synchronized NewsDB getDatabase(final Context context){
        if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        NewsDB.class, "news_database")
                        .fallbackToDestructiveMigration()
                        .addCallback(sRoomDatabaseCallback)
                        .build();
            }

        return INSTANCE;
    }
    private static Callback sRoomDatabaseCallback =
            new Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };
}
