package com.example.myofflinenews.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myofflinenews.R;
import com.example.myofflinenews.models.Article;

import java.util.ArrayList;
import java.util.List;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder>{

    Context mContext;
    List<Article> news = new ArrayList<>();

    public MainRecyclerViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.news_list_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.by.setText( news.get(i).getAuthor());
        viewHolder.title.setText(news.get(i).getTitle());
        viewHolder.content.setText(news.get(i).getDescription());
        viewHolder.date.setText((CharSequence) news.get(i).getPublishedAt());
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public void setData(List<Article> news){
        this.news = news;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView by;
        TextView title;
        TextView content;
        TextView date;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            by=     itemView.findViewById(R.id.by);
            title = itemView.findViewById(R.id.title1);
            content = itemView.findViewById(R.id.description);
            date = itemView.findViewById(R.id.date);
        }
    }
}
