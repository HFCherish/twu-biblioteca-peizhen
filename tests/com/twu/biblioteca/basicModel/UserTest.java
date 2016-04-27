package com.twu.biblioteca.basicModel;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Peizhen Zheng on 2016/4/24.
 */
public class UserTest {
    User user;

    @Test
    public void testNonNullConstructor() throws Exception {
        user = new User("testName", "111-1113","123");
        assertEquals("testName", user.getName());
        assertEquals("111-1113", user.getLibNum());
        assertEquals("123", user.getPassword());
    }


}