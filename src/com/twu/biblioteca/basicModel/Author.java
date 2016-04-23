package com.twu.biblioteca.basicModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peizhen Zheng on 2016/4/21.
 */
public class Author {
    private final String name;
    private List<Book> productions;

    public Author( String name ) {
        this.name = name;
        productions = new ArrayList<Book>();
    }

    public String getName() {
        return name;
    }

    public List<Book> getProductions() {
        return productions;
    }

    public void addProduction( Book book ){
        productions.add(book);
    }
}
