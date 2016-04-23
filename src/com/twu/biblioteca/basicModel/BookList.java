package com.twu.biblioteca.basicModel;

import com.twu.biblioteca.widgets.MessageDialog;

import javax.swing.*;
import javax.swing.undo.AbstractUndoableEdit;
import java.util.*;

/**
 * Created by Peizhen Zheng on 2016/4/21.
 */
public class BookList {
    private static Map<String, Book> books;
    private static List<String> availableBooks;

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

    public static int checkoutBook( String bookID ) {
        if( !availableBooks.contains(bookID) ){
            MessageDialog.showMessageDialog("That book is not available.", JOptionPane.ERROR_MESSAGE);
            return -1;
        }

        books.get(bookID).setState(1);
        availableBooks.remove(bookID);
        MessageDialog.showMessageDialog("Thank you! Enjoy the book.", JOptionPane.INFORMATION_MESSAGE);
        return 1;
    }

    public static int returnBook( String bookID ) {
        if( !books.containsKey(bookID) ) {
            MessageDialog.showMessageDialog("That is not a valid book to return.", JOptionPane.ERROR_MESSAGE);
            return -1;
        }

        availableBooks.add( bookID );
        books.get(bookID).setState(0);
        MessageDialog.showMessageDialog("Thank you for returning the book.", JOptionPane.INFORMATION_MESSAGE);
        return 1;
    }

    public static List<String> getAvailableBooks() {
        return availableBooks;
    }

    public static String createBookID(){
        return String.valueOf( books.size() + 1 );
    }

    public static Book getBook(String id) {
        return books.get(id);
    }

    public static int getTotalCount() {
        return books.size();
    }
}
