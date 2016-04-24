package com.twu.biblioteca.basicModel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Peizhen Zheng on 2016/4/24.
 */
public class LibraryTest {
    Library library;
    @Before
    public void setUp() throws Exception {
        library = new Library();
    }

    @Test
    public void getBookList() throws Exception {
        assertNotNull( library.getBookList() );
    }

    @Test
    public void getMovieList() throws Exception {
        assertNotNull(library.getMovieList());
    }

    @Test
    public void getUsers() throws Exception {
        assertNotNull(library.getUsers());
    }

    @Test
    public void getPresentUser() throws Exception {
        assertNull(library.getPresentUser());
    }

    @Test
    public void setPresentUser() throws Exception {
        User user = new User();
        library.setPresentUser(user);
        assertEquals(user, library.getPresentUser());
    }

}