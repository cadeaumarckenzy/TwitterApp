package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;

public class Tweet {

    public String Body;
    public long Uid;
    public User user;
    public String CreatedAt;

    public static Tweet fromJSON(JSONObject jsonObject) throws JSONException{
        Tweet tweet = new Tweet();

        tweet.Body = jsonObject.getString("text");
        tweet.Uid = jsonObject.getLong("id");
        tweet.CreatedAt = jsonObject.getString("created_at");
        tweet.user = User.fromJSON(jsonObject.getJSONObject("user"));
        return tweet;


    }
}
