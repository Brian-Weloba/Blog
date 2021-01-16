package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class PostTest {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        Post.clearAllPosts();
    }

    @Test
    public void Post_canInstantiate_true() {
        Post post = new Post();
        assertTrue(post instanceof Post);
    }

    @Test
    public void Post_canInstantiateWithContent_true() {
        Post post = setupNewPost();
        assertEquals("Day 1: Intro", post.getContent());
    }

    @Test
    public void AllPostsAreCorrectlyReturned_true() {
        Post post = setupNewPost();
        Post otherPost = new Post("How to pair successfully");
        assertEquals(2, Post.getAll().size());
    }

    @Test
    public void AllPostsContainAllPosts_true() {
        Post post = setupNewPost();
        Post otherPost = new Post("How to pair successfully");
        assertTrue(Post.getAll().contains(post));
        assertTrue(Post.getAll().contains(otherPost));
    }

    @Test
    public void getPublished_isFalseAfterInstantiation_false() {
        Post post = setupNewPost();
        assertFalse(post.isPublished());
    }

    @Test
    public void getCreatedAt_instantiatesWithCurrentTime_today() {
        Post myPost = setupNewPost(); //see below
        assertEquals(LocalDateTime.now().getDayOfWeek(), myPost.getCreatedAt().getDayOfWeek());
    }

    private Post setupNewPost(){
        return new Post("Day 1: Intro");
    }

    @Test
    public void getId_postsInstantiateWithAnID_1() {
        Post.clearAllPosts();  // Remember, the test will fail without this line! We need to empty leftover Posts from previous tests!
        Post myPost = new Post("Day 1: Intro");
        assertEquals(1, myPost.getId());
    }

    @Test
    public void findReturnsCorrectPost() {
        Post post = setupNewPost();
        assertEquals(1, Post.findById(post.getId()).getId());
    }

    @Test
    public void findReturnsCorrectPostWhenMoreThanOnePostExists() {
        Post post = setupNewPost();
        Post otherPost = new Post("How to pair successfully");
        assertEquals(2, Post.findById(otherPost.getId()).getId());
    }

    @Test
    public void updateChangesPostContent() throws Exception {
        Post post = setupNewPost();
        String formerContent = post.getContent();
        LocalDateTime formerDate = post.getCreatedAt();
        int formerId = post.getId();

        post.update("Android: Day 40");

        assertEquals(formerId, post.getId());
        assertEquals(formerDate, post.getCreatedAt());
        assertNotEquals(formerContent, post.getContent());
    }

    @Test
    public void deleteDeletesACurrentPost() {
        Post post = setupNewPost();
        Post otherPost = new Post("How to pair successfully.");
        post.deletePost();
        assertEquals(1,post.getAll().size());
        assertEquals(Post.getAll().get(0).getId(),1);
    }
}