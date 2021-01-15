package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
        Post post = new Post("Day 1: Intro");
        assertEquals("Day 1: Intro", post.getContent());
    }

    @Test
    public void AllPostsAreCorrectlyReturned_true() {
        Post post = new Post("Day 1: Intro");
        Post otherPost = new Post("How to pair successfully");
        assertEquals(2, Post.getAll().size());
    }

    @Test
    public void AllPostsContainAllPosts_true() {
        Post post = new Post("Day 1: Intro");
        Post otherPost = new Post("How to pair successfully");
        assertTrue(Post.getAll().contains(post));
        assertTrue(Post.getAll().contains(otherPost));
    }

    @Test
    public void getPublished_isFalseAfterInstantiation_false() throws Exception{
        Post post = new Post("Day 1: Intro");
        assertFalse(post.isPublished());
    }

}