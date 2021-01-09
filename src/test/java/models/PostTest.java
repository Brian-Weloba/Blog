package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PostTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void Post_canInstantiate_true() throws Exception{
        Post post = new Post();
        assertTrue(post instanceof Post);
    }

    @Test
    public void Post_canInstantiateWithContent_true() throws Exception{
        Post post = new Post("Day 1: Intro");
        assertEquals("Day 1: Intro", post.getContent());
    }
}