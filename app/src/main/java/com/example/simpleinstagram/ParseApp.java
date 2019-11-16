package com.example.simpleinstagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("sevara-instagram") // should correspond to APP_ID env variable
                .clientKey("SevaMasterKey")  // set explicitly unless clientKey is explicitly configured on Parse server
                .server("https://sevara-instagram.herokuapp.com/parse/").build());
    }


}
