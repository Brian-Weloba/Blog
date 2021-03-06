package models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Post {

    private static ArrayList<Post> instances = new ArrayList<>();
    private String content;
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

    public Post() {

    }

    public static ArrayList<Post> getAll() {
        return instances;
    }

    public static void clearAllPosts() {
        instances.clear();
    }

    public static Post findById(int id) {
        return instances.get(id - 1);
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public boolean isPublished() {
        return published;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void update(String content) {
        this.content = content;
    }

    public void deletePost() {
        instances.remove(id - 1);
    }
}
