package com.twu.biblioteca.basicModel;

import java.util.List;

/**
 * Created by Peizhen Zheng on 2016/4/24.
 */
public class Production {
    private final String name;
    private final int year;
    private final List<Author> authors;
    private int state;  //0 is available, 1 is checked out.

    public Production( String name, int year, List<Author> authors ) {
        this.name = name;
        this.year = year;
        this.authors = authors;
        state = 0;
    }

    public String getAuthorName() {
        StringBuilder name = new StringBuilder();
        for(Author author: authors) {
            name.append(author.getName() + ", ");
        }
        return name.substring(0, name.length()-2);
    }

    public boolean isAvailable(){
        return state == 0;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
