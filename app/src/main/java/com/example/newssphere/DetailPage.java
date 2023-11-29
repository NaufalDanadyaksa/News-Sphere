package com.example.newssphere;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailPage extends AppCompatActivity {


    String title,desc,content,imageURL,url;
    private TextView titleTv,SubDescTv,contentTv;
    private ImageView newsIv;
    private Button readNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);
        title=getIntent().getStringExtra("title");
        desc=getIntent().getStringExtra("desc");
        content=getIntent().getStringExtra("content");
        imageURL=getIntent().getStringExtra("image");
        url=getIntent().getStringExtra("url");
        titleTv=findViewById(R.id.idTvTitle);
        SubDescTv=findViewById(R.id.idTvSubDesc);
        newsIv=findViewById(R.id.idIvNews);
        contentTv=findViewById(R.id.idTvContent);
        readNews=findViewById(R.id.idBtnReadNews);
        titleTv.setText(title);
        SubDescTv.setText(desc);
        contentTv.setText(content);
        Picasso.get().load(imageURL).into(newsIv);
        readNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}