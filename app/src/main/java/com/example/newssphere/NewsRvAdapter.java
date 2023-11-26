package com.example.newssphere;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsRvAdapter extends RecyclerView.Adapter<NewsRvAdapter.ViewHolder> {
    private ArrayList<Articles> articlesArrayList;
    private Context context;

    public NewsRvAdapter(ArrayList<Articles> articles, Context context) {
        this.articlesArrayList = articles;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsRvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.news_rv_item,parent,false);
        return new NewsRvAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsRvAdapter.ViewHolder holder, int position) {
        Articles articles = articlesArrayList.get(position);
        holder.subTitle.setText(articles.getDescription());
        holder.title.setText(articles.getTitle());
        Picasso.get().load(articles.getUrlToImage()).into(holder.thumbNail);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(context, DetailPage.class);
                i.putExtra("title",articles.getTitle());
                i.putExtra("content",articles.getContent());
                i.putExtra("desc",articles.getDescription());
                i.putExtra("image",articles.getUrlToImage());
                i.putExtra("url",articles.getUrl());
                context.startActivity(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return articlesArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title,subTitle;
        private ImageView thumbNail;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.heading);
            subTitle=itemView.findViewById(R.id.subheading);
            thumbNail=itemView.findViewById(R.id.horizonView);
        }
    }
}
