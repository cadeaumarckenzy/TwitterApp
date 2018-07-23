package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;

public class User {

    public String Name;
    public long Uid;
    public String ScreenName;
    public String ProfileImageUrl;

    public static User fromJSON(JSONObject json)throws JSONException{
        User user = new User();

        user.Name = json.getString("name");
        user.Uid = json.getLong("id");
        user.ScreenName = json.getString("screen_name");
        user.ProfileImageUrl = json.getString("profile_image_url");

        return user;
    }
}
