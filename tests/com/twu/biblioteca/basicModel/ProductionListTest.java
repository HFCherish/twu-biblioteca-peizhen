package com.twu.biblioteca.basicModel;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Peizhen Zheng on 2016/4/21.
 */
public class ProductionListTest {
    ProductionList bookList;
    @Before
    public void setUp() {
        //test the checkout and return method using the booklist
        bookList = Library.getInstance().getBookList();
    }
    
    @Test
    public void getBook() throws Exception {

    }

    @Test
    public void getTotalCount() throws Exception {
        assertEquals(10, bookList.getTotalCount());
    }

    @Test
    public void checkoutBookRight() throws Exception {
        bookList.checkoutProduction("1");
        assertTrue(bookList.getAvailableProductions().size()==9 && !bookList.getAvailableProductions().contains("1"));
        bookList.returnProduction("1");
        System.out.println("show book lists");
        System.out.println(bookList.getAvailableProductions());
    }

    @Test
    public void checkoutBookWrong() throws Exception {
        bookList.checkoutProduction("1");
        bookList.checkoutProduction("1");
        assertTrue(bookList.getAvailableProductions().size()==9 && !bookList.getAvailableProductions().contains("1"));
        bookList.returnProduction("1");
        System.out.println("show book lists");
        System.out.println(bookList.getAvailableProductions());
    }

    @Test
    public void returnBookRight() throws Exception {
        bookList.checkoutProduction("1");
        bookList.returnProduction("1");
        assertTrue(bookList.getAvailableProductions().size()==10 && bookList.getAvailableProductions().contains("1"));
        System.out.println("show book lists");
        System.out.println(bookList.getAvailableProductions());
    }

    @Test
    public void returnBookWrong() throws Exception {
        bookList.returnProduction("0");
        assertTrue(bookList.getAvailableProductions().size()==10 && bookList.getAvailableProductions().contains("1"));
        System.out.println("show book lists");
        System.out.println(bookList.getAvailableProductions());
    }

    @Test
    public void getAvailableBooks() throws Exception {
        assertTrue(bookList.getAvailableProductions().size()==10 && bookList.getAvailableProductions().contains("1"));
        System.out.println("show book lists");
        System.out.println(bookList.getAvailableProductions());
    }

    @Test
    public void createBookID() throws Exception {
        assertEquals("11", bookList.createProductionID());
    }

}