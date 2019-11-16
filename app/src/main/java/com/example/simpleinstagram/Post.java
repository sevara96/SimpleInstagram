package com.example.simpleinstagram;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("Post")
public class Post extends ParseObject {

    public  static  final String  key_description = "description";
    public  static  final String  key_image = "image";
    public  static  final String  key_user = "user";

    public String getDescription() {
        return getString(key_description);
    }

    public  void  setDescription(String description){
        put(key_description, description);
    }
    public ParseFile getImage(){
        return  getParseFile(key_image);
    }
    public  void  setImage(ParseFile parseFile){
        put(key_image, parseFile);
    }
    public ParseUser getUser() {
        return getParseUser(key_user);
    }

    public void setUser(ParseUser parseUser){
        put(key_user, parseUser) ;
    }

}
