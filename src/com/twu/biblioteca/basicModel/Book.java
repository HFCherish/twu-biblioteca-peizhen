package com.twu.biblioteca.basicModel;

import java.util.List;

/**
 * Created by Peizhen Zheng on 2016/4/21.
 */
public class Book {
    public Book(String id, String name,  List<Author> authors, int publishYear) {
        this.id = id;
        this.name = name;
        this.authors = authors;
        this.publishYear = publishYear;
        state = 0;
    }

    public String getName() {
        return name;
    }

    public List<Author> getAuthor() {
        return authors;
    }

    public String getAuthorName() {
        StringBuilder name = new StringBuilder();
        for(Author author: authors) {
            name.append(author.getName() + ", ");
        }
        return name.substring(0, name.length()-2);
    }

    public int getPublishYear() {
        return publishYear;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getId() {
        return id;
    }
    public boolean isAvailable(){
        return state == 0;
    }

    //@BeanColumn(name = "Book Name", index = 1)
    private final String name;
    //@BeanColumn(name = "Author", index = 2)
    private final List<Author> authors;
    //@BeanColumn(name = "Published Year", index = 3)
    private final int publishYear;
    private int state;  //0 is available, and 1 is checked out



    //@BeanColumn(name = "ID", index = 0)
    private String id;  //the bookId which identifies the book uniquely
}
