package com.example.newssphere;



import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface api {
    @GET
    Call<NewsModal> getAllNews(@Url String url);

    @GET
    Call<NewsModal> getNewsCatagory(@Url String url);
}
