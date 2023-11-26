package com.example.newssphere;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DetailPage extends AppCompatActivity {

    String title,desc,content,imageURL,url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);
        title=getIntent().getStringExtra("title");
        desc=getIntent().getStringExtra("desc");
        content=getIntent().getStringExtra("content");
        imageURL=getIntent().getStringExtra("image");
        url=getIntent().getStringExtra("url");
    }
}