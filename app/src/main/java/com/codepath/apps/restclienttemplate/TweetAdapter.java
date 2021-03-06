package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import java.util.List;

public class TweetAdapter extends RecyclerView.Adapter<TweetAdapter.ViewHolder> {

    private List<Tweet> mTweets;
    private Context context;

    public TweetAdapter(List<Tweet> tweets){
        mTweets = tweets;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View tweetView = inflater.inflate(R.layout.item_tweet, parent, false);
        ViewHolder viewHolder = new ViewHolder(tweetView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tweet tweet = mTweets.get(position);
        holder.tvUserName.setText(tweet.user.Name);
        holder.tvBody.setText(tweet.Body);
        Glide.with(context).load(tweet.user.ProfileImageUrl).into(holder.ivProfileImage);
    }

    @Override
    public int getItemCount() {
        return mTweets.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
            public ImageView ivProfileImage;
            public TextView tvUserName;
            public TextView tvBody;

            public ViewHolder (View itemView){
                super(itemView);

                ivProfileImage = (ImageView) itemView.findViewById(R.id.ivProfileImage);
                tvUserName = (TextView) itemView.findViewById(R.id.tvUserName);
                tvBody = (TextView) itemView.findViewById(R.id.tvBody);
            }

    }

}