package com.twu.biblioteca.basicModel;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Peizhen Zheng on 2016/4/21.
 */
public class ProductionListTest {
    @Test
    public void getBook() throws Exception {

    }

    @Test
    public void getTotalCount() throws Exception {
        assertEquals(10, ProductionList.getTotalCount());
    }

    @Test
    public void checkoutBookRight() throws Exception {
        ProductionList.checkoutObject("1");
        //assertArrayEquals(new String[]{"2","3","4","5","6","7","8","9","10"}, ProductionList.getAvailableObjects().toArray());
        assertTrue(ProductionList.getAvailableObjects().size()==9 && !ProductionList.getAvailableObjects().contains("1"));
        ProductionList.returnObject("1");
        System.out.println("show book lists");
        System.out.println(ProductionList.getAvailableObjects());
    }

    @Test
    public void checkoutBookWrong() throws Exception {
        ProductionList.checkoutObject("1");
        ProductionList.checkoutObject("1");
        //assertArrayEquals(new String[]{"2","3","4","5","6","7","8","9","10"}, ProductionList.getAvailableObjects().toArray());
        assertTrue(ProductionList.getAvailableObjects().size()==9 && !ProductionList.getAvailableObjects().contains("1"));
        ProductionList.returnObject("1");
        System.out.println("show book lists");
        System.out.println(ProductionList.getAvailableObjects());
    }

    @Test
    public void returnBookRight() throws Exception {
        ProductionList.checkoutObject("1");
        ProductionList.returnObject("1");
       // assertArrayEquals(new String[]{"1","2","3","4","5","6","7","8","9","10"}, ProductionList.getAvailableObjects().toArray());
        assertTrue(ProductionList.getAvailableObjects().size()==10 && ProductionList.getAvailableObjects().contains("1"));
        System.out.println("show book lists");
        System.out.println(ProductionList.getAvailableObjects());
    }

    @Test
    public void returnBookWrong() throws Exception {
        ProductionList.returnObject("0");
        Arrays.sort(ProductionList.getAvailableObjects().toArray());
        //assertArrayEquals(new String[]{"1","2","3","4","5","6","7","8","9","10"}, ProductionList.getAvailableObjects().toArray());
        assertTrue(ProductionList.getAvailableObjects().size()==10 && ProductionList.getAvailableObjects().contains("1"));
        System.out.println("show book lists");
        System.out.println(ProductionList.getAvailableObjects());
    }

    @Test
    public void getAvailableBooks() throws Exception {
        Arrays.sort(ProductionList.getAvailableObjects().toArray());
        //assertArrayEquals( new String[]{"1","2","3","4","5","6","7","8","9","10"}, ProductionList.getAvailableObjects().toArray() );
        assertTrue(ProductionList.getAvailableObjects().size()==10 && ProductionList.getAvailableObjects().contains("1"));
        System.out.println("show book lists");
        System.out.println(ProductionList.getAvailableObjects());
    }

    @Test
    public void createBookID() throws Exception {
        assertEquals("11", ProductionList.createObjectID());
    }

}