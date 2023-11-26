package com.example.newssphere;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainApp extends AppCompatActivity implements CategoryRvAdapter.CategorClickInterface{


    private RecyclerView newsRV,categoryRV;
    private ProgressBar loadingPB;
    private ArrayList<Articles> articlesArrayList;
    private ArrayList<CategoryRvModal> categoryRVModalArrayList;
    private CategoryRvAdapter categoryRVAdapter;
    private NewsRvAdapter newsRvAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_app);
        newsRV=findViewById(R.id.recyclerView1);
        categoryRV=findViewById(R.id.recyclerView2);
        loadingPB=findViewById(R.id.loading);
        articlesArrayList=new ArrayList<>();
        categoryRVModalArrayList=new ArrayList<>();
        newsRvAdapter=new NewsRvAdapter(articlesArrayList, this);
        categoryRVAdapter=new CategoryRvAdapter(categoryRVModalArrayList,this,this::onCategoryClick);
        newsRV.setLayoutManager(new LinearLayoutManager(this));
        newsRV.setAdapter(newsRvAdapter);
        categoryRV.setAdapter(categoryRVAdapter);
        getCategoties();

    }

    private void getCategoties(){
        categoryRVModalArrayList.add(new CategoryRvModal("All",""));
        categoryRVModalArrayList.add(new CategoryRvModal("Technology","https://images.unsplash.com/photo-1531297484001-80022131f5a1?q=80&w=1420&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"));
        categoryRVModalArrayList.add(new CategoryRvModal("Science","https://images.unsplash.com/photo-1628595351029-c2bf17511435?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTR8fHNjaWVuY2V8ZW58MHx8MHx8fDA%3D"));
        categoryRVModalArrayList.add(new CategoryRvModal("Sports","https://images.unsplash.com/photo-1461896836934-ffe607ba8211?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8U3BvcnR8ZW58MHx8MHx8fDA%3D"));
        categoryRVModalArrayList.add(new CategoryRvModal("Game","https://images.unsplash.com/photo-1493711662062-fa541adb3fc8?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8Z2FtZXxlbnwwfHwwfHx8MA%3D%3D"));
        categoryRVModalArrayList.add(new CategoryRvModal("Business","https://images.unsplash.com/photo-1590283603385-17ffb3a7f29f?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8c3RvY2slMjBtYXJrZXR8ZW58MHx8MHx8fDA%3D"));
        categoryRVModalArrayList.add(new CategoryRvModal("Politic","https://images.unsplash.com/photo-1529107386315-e1a2ed48a620?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8cG9saXRpY3xlbnwwfHwwfHx8MA%3D%3D"));
        categoryRVAdapter.notifyDataSetChanged();
    }

    private void getNews(String category){
        loadingPB.setVisibility(View.VISIBLE);
        articlesArrayList.clear();
        String categoryURL="https://newsapi.org/v2/everything?q="+category+"&apiKey=5dce79cf80e54b7096f71581f1663583";
        String url="https://newsapi.org/v2/top-headlines?country=id&sortBy=publishedAt&apiKey=5dce79cf80e54b7096f71581f1663583";
        String BASE_URL="https://newsapi.org/";
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        api retrofitAPI=retrofit.create(api.class);
        Call<NewsModal> call;
        if (category.equals("All")){
            call=retrofitAPI.getAllNews(url);
        }else{
            call=retrofitAPI.getNewsCatagory(categoryURL);
        }

        call.enqueue(new Callback<NewsModal>() {
            @Override
            public void onResponse(Call<NewsModal> call, Response<NewsModal> response) {

            }

            @Override
            public void onFailure(Call<NewsModal> call, Throwable t) {

            }
        });
    }
    @Override
    public void onCategoryClick(int position) {

    }
}