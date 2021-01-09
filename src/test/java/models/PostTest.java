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
}