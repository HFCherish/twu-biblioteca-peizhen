package com.twu.biblioteca.basicModel;

import java.util.List;

/**
 * Created by Peizhen Zheng on 2016/4/21.
 */
public class Book extends Production {
    public Book(String id, String name, int publishYear, List<Author> authors) {
        super( name, publishYear, authors );
        this.id = id;
    }

    public String getId() {
        return id;
    }

    private String id;  //the bookId which identifies the book uniquely
}
