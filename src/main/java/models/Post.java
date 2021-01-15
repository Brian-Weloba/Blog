package models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Post {

    private String content;
    private static ArrayList<Post> instances = new ArrayList<>();
    private boolean published;
    private LocalDateTime createdAt;
    private int id;


    public Post(String content) {
        this.content = content;
        this.published = false;
        this.createdAt = LocalDateTime.now();
        instances.add(this);
        this.id = instances.size();
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Post() {

    }

    public boolean isPublished() {
        return published;
    }

    public static ArrayList<Post> getAll() {
        return instances;
    }

    public static void clearAllPosts() {
        instances.clear();
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
