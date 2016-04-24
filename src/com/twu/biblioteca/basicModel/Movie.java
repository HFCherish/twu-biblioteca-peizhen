package com.twu.biblioteca.basicModel;

import java.util.List;

/**
 * Created by Peizhen Zheng on 2016/4/24.
 */
public class Movie extends Production {
    private String id;
    private int rating; //from 0-10, while 0 represents unrated.

    public Movie(String name, int year, List<Author> authors ){
        super(name, year, authors);
        rating = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
