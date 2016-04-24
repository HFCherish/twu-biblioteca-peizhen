package com.twu.biblioteca.basicModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peizhen Zheng on 2016/4/24.
 */
public class CheckHistory {
    private List<String> checkedBooks;
    private List<String> toReturnBooks;
    private List<String> checkedMovies;
    private List<String> toReturnMovies;

    public CheckHistory() {
        checkedBooks = new ArrayList<String>();
        toReturnBooks = new ArrayList<String>();
        checkedMovies = new ArrayList<String>();
        toReturnMovies = new ArrayList<String>();
    }

    public List<String> getCheckedBooks() {
        return checkedBooks;
    }

    public void addCheckedBooks(String bookID) {
        checkedBooks.add(bookID);
    }

    public List<String> getToReturnBooks() {
        return toReturnBooks;
    }

    public void addToReturnBooks(String bookID) {
        toReturnBooks.add(bookID);
    }

    public List<String> getCheckedMovies() {
        return checkedMovies;
    }

    public void addCheckedMovies(String movieID) {
        checkedMovies.add(movieID);
    }

    public List<String> getToReturnMovies() {
        return toReturnMovies;
    }

    public void addToReturnMovies(String movieID) {
        toReturnMovies.add(movieID);
    }
}
