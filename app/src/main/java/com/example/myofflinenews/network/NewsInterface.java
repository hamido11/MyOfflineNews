package com.example.myofflinenews.network;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsInterface {
    String BASE_URL = "https://newsapi.org";

    @GET("v1/articles?source=the-next-web&sortBy=latest&apiKey=8577a99437ca45c7bb8afa53b94d8475")
    Call<Root> getNews();
}
