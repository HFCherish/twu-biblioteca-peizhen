package com.twu.biblioteca.basicModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Peizhen Zheng on 2016/4/24.
 */
public class Library {
    private static Library library = null;  //singleton. There is only one library in the system.

    private static ProductionList<Book> bookList;
    private static ProductionList<Movie> movieList;
    private static List<User> users;
    private static User presentUser;

    private void initBookList() {
        bookList = new ProductionList<Book>();
        Map<String, Book> books = bookList.getAllProductions();


        List<Author> authors = new ArrayList<Author>();
        authors.add(new Author("James Whittaker"));
        authors.add(new Author("Jason Arbob"));
        authors.add(new Author("Jeff Carollo"));
        String id = bookList.createProductionID();
        books.put(id, new Book(id, "How Google Tests Software", authors, 2012));

        authors = new ArrayList<Author>();
        authors.add(new Author("William Meisel"));
        id = bookList.createProductionID();
        books.put(id, new Book( id, "The Software Society: Cultural and Economic Impact", authors, 2013));

        authors = new ArrayList<Author>();
        authors.add(new Author("Tarun Lalwani"));
        authors.add(new Author("Manika Garg"));
        id = bookList.createProductionID();
        books.put(id, new Book(id, "Uft/Qtp Interview Unplugged: And I Thought I Knew Uft!", authors, 2013));

        authors = new ArrayList<Author>();
        authors.add(new Author("Brent Schlender"));
        authors.add(new Author("Rick Tetzeli"));
        id = bookList.createProductionID();
        books.put(id, new Book(id, "Becoming Steve Jobs: The Evolution of a Reckless Upstart into a Visionary Leader", authors, 2015));

        authors = new ArrayList<Author>();
        authors.add(new Author("Ashlee Vance"));
        id = bookList.createProductionID();
        books.put(id, new Book(id, "Elon Musk: How the Billionaire CEO of SpaceX and Tesla is Shaping our Future", authors, 2015));

        authors = new ArrayList<Author>();
        authors.add(new Author("Walter Isaacson"));
        id = bookList.createProductionID();
        books.put(id, new Book(id, "Steve Jobs", authors, 2011));

        authors = new ArrayList<Author>();
        authors.add(new Author("Bethesda Softworks"));
        id = bookList.createProductionID();
        books.put(id, new Book(id, "The Art of Fallout 4", authors, 2015) );

        authors = new ArrayList<Author>();
        authors.add(new Author("Nick Farwell"));
        authors.add(new Author(" Donald R. Steer"));
        id = bookList.createProductionID();
        books.put(id, new Book(id, "Minecraft: Redstone Handbook", authors, 2015));

        authors = new ArrayList<Author>();
        authors.add(new Author("Ci-Ling Pan"));
        id = bookList.createProductionID();
        books.put(id, new Book(id, "Photonics for THz and Millimeter Waves in Ultra-Fast Wireless Communications", authors, 2016));

        authors = new ArrayList<Author>();
        authors.add(new Author("Scholastic Inc."));
        id = bookList.createProductionID();
        books.put(id, new Book(id, "Minecraft: The Complete Handbook Collection", authors, 2015));

        bookList.getAvailableProductions().addAll(books.keySet());
    }

    private void initMovieList(){
        movieList = new ProductionList<Movie>();
        Map<String, Movie> movies = movieList.getAllProductions();
        List<Author> directors;
        String id;
        Movie movie;

        directors = new ArrayList<Author>();
        directors.add(new Author("Alejandro González Iñárritu"));
        id = movieList.createProductionID();
        movies.put(id, new Movie(id, "The Revenant", 2015, directors));

        directors = new ArrayList<Author>();
        directors.add(new Author("Jeff Nichols"));
        id = movieList.createProductionID();
        movie = new Movie(id, "Midnight Special", 2016, directors);
        movie.setRating(6);
        movies.put(id, movie);

        directors = new ArrayList<Author>();
        directors.add(new Author("Stéphane Brizé"));
        id = movieList.createProductionID();
        movie = new Movie(id, "La loi du marché", 2015, directors);
        movie.setRating(7);
        movies.put(id, movie);

        movieList.getAvailableProductions().addAll(movies.keySet());
    }

    private void initUsers() {
        users = new ArrayList<User>();
        users.add(new User("Lily", "111-1111", "123"));
        users.add(new User("Amy", "111-1112", "1234"));
    }

    private Library() {
        initBookList();
        initMovieList();
        initUsers();
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

    public ProductionList<Book> getBookList() {
        return bookList;
    }

    public ProductionList<Movie> getMovieList() {
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
