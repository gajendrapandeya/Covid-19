package com.codermonkeys.covid_19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.bumptech.glide.Glide;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private List<NewsItems> mNewsItems;
    private Context mContext;
    private onItemClickListner mListner;

    public interface onItemClickListner {

        void onItemClick(int position);
    }

    public NewsAdapter(List<NewsItems> mNewsItems, Context mContext) {
        this.mNewsItems = mNewsItems;
        this.mContext = mContext;
    }

    public void setOnItemClickListner(onItemClickListner listner) {

        mListner = listner;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(mContext).inflate(R.layout.layout_news, parent, false);
       return new NewsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {

        NewsItems currentItems = mNewsItems.get(position);
        String imageUrl = currentItems.getImageUrl();
        String newsTitle = currentItems.getNewsTitle();

        holder.mTextViewNewsTitle.setText(newsTitle);
        Glide.with(mContext).load(imageUrl).fitCenter().centerInside().into(holder.mImageViewImageUrl);

    }

    @Override
    public int getItemCount() {
        return mNewsItems.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageViewImageUrl;
        private TextView mTextViewNewsTitle;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);

            mImageViewImageUrl = itemView.findViewById(R.id.image_view_image_resource);
            mTextViewNewsTitle = itemView.findViewById(R.id.text_view_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListner != null) {

                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION) {
                            mListner.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
