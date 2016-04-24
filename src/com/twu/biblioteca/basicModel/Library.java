package com.twu.biblioteca.basicModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Peizhen Zheng on 2016/4/24.
 */
public class Library {
    private static Library library = null;  //singleton. There is only one library in the system.

    private static ProductionList bookList;
    private static ProductionList movieList;
    private static List<User> users;
    private static User presentUser;
    static {
        books = new HashMap<String, Book>();

        List<Author> authors = new ArrayList<Author>();
        authors.add(new Author("James Whittaker"));
        authors.add(new Author("Jason Arbob"));
        authors.add(new Author("Jeff Carollo"));
        String id = createBookID();
        books.put(id, new Book(id, "How Google Tests Software", authors, 2012));

        authors = new ArrayList<Author>();
        authors.add(new Author("William Meisel"));
        id = createBookID();
        books.put(id, new Book( id, "The Software Society: Cultural and Economic Impact", authors, 2013));

        authors = new ArrayList<Author>();
        authors.add(new Author("Tarun Lalwani"));
        authors.add(new Author("Manika Garg"));
        id = createBookID();
        books.put(id, new Book(id, "Uft/Qtp Interview Unplugged: And I Thought I Knew Uft!", authors, 2013));

        authors = new ArrayList<Author>();
        authors.add(new Author("Brent Schlender"));
        authors.add(new Author("Rick Tetzeli"));
        id = createBookID();
        books.put(id, new Book(id, "Becoming Steve Jobs: The Evolution of a Reckless Upstart into a Visionary Leader", authors, 2015));

        authors = new ArrayList<Author>();
        authors.add(new Author("Ashlee Vance"));
        id = createBookID();
        books.put(id, new Book(id, "Elon Musk: How the Billionaire CEO of SpaceX and Tesla is Shaping our Future", authors, 2015));

        authors = new ArrayList<Author>();
        authors.add(new Author("Walter Isaacson"));
        id = createBookID();
        books.put(id, new Book(id, "Steve Jobs", authors, 2011));

        authors = new ArrayList<Author>();
        authors.add(new Author("Bethesda Softworks"));
        id = createBookID();
        books.put(id, new Book(id, "The Art of Fallout 4", authors, 2015) );

        authors = new ArrayList<Author>();
        authors.add(new Author("Nick Farwell"));
        authors.add(new Author(" Donald R. Steer"));
        id = createBookID();
        books.put(id, new Book(id, "Minecraft: Redstone Handbook", authors, 2015));

        authors = new ArrayList<Author>();
        authors.add(new Author("Ci-Ling Pan"));
        id = createBookID();
        books.put(id, new Book(id, "Photonics for THz and Millimeter Waves in Ultra-Fast Wireless Communications", authors, 2016));

        authors = new ArrayList<Author>();
        authors.add(new Author("Scholastic Inc."));
        id = createBookID();
        books.put(id, new Book(id, "Minecraft: The Complete Handbook Collection", authors, 2015));

        availableBooks = new ArrayList<String>( books.keySet() );
    }

    private Library() {
        bookList = new ProductionList<Book>();
        movieList = new ProductionList<Movie>();
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

    public Map getBookList() {
        return bookList;
    }

    public ProductionList getMovieList() {
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
