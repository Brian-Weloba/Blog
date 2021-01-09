package models;

import java.util.ArrayList;

public class Post {

    private String content;
    private static ArrayList<Post> instances = new ArrayList<>();


    public Post(String content) {
        this.content = content;
        instances.add(this);
    }

    public String getContent() {
        return content;
    }

    public Post() {

    }

    public static ArrayList<Post> getAll() {
        return instances;
    }

    public static void clearAllposts(){
        instances.clear();
    }

}
