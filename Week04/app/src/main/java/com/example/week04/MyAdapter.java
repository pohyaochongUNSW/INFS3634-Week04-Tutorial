package com.example.week04;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.UserViewHolder>{
    private ArrayList<Article> articlesList;

    // Provide a suitable constructor (depends on the kind of dataset)
    public void setData(ArrayList<Article> articles){
        this.articlesList = articles;
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView headline;
        public TextView content;
        public TextView timeAgo;
        public ImageView photo;
        public ImageView saveBtn;
        public ImageView shareBtn;
        public boolean btnSaveState = false;

        public UserViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            headline = itemView.findViewById(R.id.newsHeadline);
            content = itemView.findViewById(R.id.newsDetails);
            timeAgo = itemView.findViewById(R.id.newsTimeAgo);
            photo = itemView.findViewById(R.id.newsPhoto);
            saveBtn = itemView.findViewById(R.id.newsSaveButton);
            shareBtn = itemView.findViewById(R.id.newsShareButton);
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.article, parent, false);
        UserViewHolder userViewHolder = new UserViewHolder(view);

        return userViewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final UserViewHolder holder, final int position) {
        holder.content.setText(articlesList.get(position).getSummary());
        holder.timeAgo.setText("7h ago");
        holder.photo.setImageResource(R.drawable.news_headline_photo);
        holder.headline.setText(articlesList.get(position).getHeadline());

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext().getApplicationContext(), ArticleDetailActivity.class);
                intent.putExtra("ArticleID", articlesList.get(position).getArticleID());
                view.getContext().startActivity(intent);
            }
        });

        holder.saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!holder.btnSaveState) {
                    holder.saveBtn.setImageResource(R.drawable.ic_bookmark_black_24dp);
                    Toast.makeText(view.getContext().getApplicationContext(), "Saved.", Toast.LENGTH_SHORT).show();
                } else {
                    holder.saveBtn.setImageResource(R.drawable.ic_bookmark_border_black_24dp);
                    Toast.makeText(view.getContext().getApplicationContext(), "Unsaved.", Toast.LENGTH_SHORT).show();
                }

                holder.btnSaveState = !holder.btnSaveState;
            }
        });

        holder.shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "Here is a cool article: " +
                        articlesList.get(position).getHeadline());
                view.getContext().startActivity(intent);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return articlesList.size();
    }
}