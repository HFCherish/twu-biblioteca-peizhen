package com.twu.biblioteca.basicModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peizhen Zheng on 2016/4/24.
 */
public class Library {
    private static Library library = null;  //singleton. There is only one library in the system.

    private static ObjectList<Book> bookList;
    private static ObjectList<Movie> movieList;
    private static List<User> users;
    private static User presentUser;

    private Library() {
        bookList = new ObjectList<Book>();
        movieList = new ObjectList<Movie>();
        users = new ArrayList<User>();
        presentUser = null;
    }

    public static Library getInstance() {
        if( library == null ) {
            synchronized ( Library.class ) {
                if( null == library )
                    library = new Library();
            }
        }
        return library;
    }

    public User getUser( String account ) {
        for( User user: users )
            if( user.getLibNum().equals(account) )
                return user;
        return null;
    }

    public ObjectList<Book> getBookList() {
        return bookList;
    }

    public ObjectList<Movie> getMovieList() {
        return movieList;
    }

    public List<User> getUsers() {
        return users;
    }

    public User getPresentUser() {
        return presentUser;
    }

    public void setPresentUser(User presentUser) {
        this.presentUser = presentUser;
    }
}
