package com.twu.biblioteca.basicModel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Peizhen Zheng on 2016/4/24.
 */
public class CheckHistoryTest {
    CheckHistory testCheckHistory;

    @Before
    public void setUp() throws Exception {
        testCheckHistory = new CheckHistory();
    }

    @Test
    public void getCheckedBooks() throws Exception {

    }

    @Test
    public void addCheckedBooks() throws Exception {
        testCheckHistory.addCheckedBooks("1");
        assertArrayEquals(new String[]{"1"}, testCheckHistory.getCheckedBooks().toArray());
    }

    @Test
    public void getToReturnBooks() throws Exception {

    }

    @Test
    public void addToReturnBooks() throws Exception {
        testCheckHistory.addToReturnBooks("1");
        assertArrayEquals(new String[]{"1"}, testCheckHistory.getToReturnBooks().toArray());
    }

    @Test
    public void getCheckedMovies() throws Exception {

    }

    @Test
    public void addCheckedMovies() throws Exception {
        testCheckHistory.addCheckedMovies("1");
        assertArrayEquals(new String[]{"1"}, testCheckHistory.getCheckedMovies().toArray());
    }

    @Test
    public void getToReturnMovies() throws Exception {

    }

    @Test
    public void addToReturnMovies() throws Exception {
        testCheckHistory.addToReturnMovies("1");
        assertArrayEquals(new String[]{"1"}, testCheckHistory.getToReturnMovies().toArray());
    }

}