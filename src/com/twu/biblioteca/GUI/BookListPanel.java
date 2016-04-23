package com.twu.biblioteca.GUI;

import com.twu.biblioteca.basicModel.Book;
import com.twu.biblioteca.basicModel.BookList;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by Peizhen Zheng on 2016/4/21.
 */
public class BookListPanel extends JPanel {
    private JTable bookListTable;
    private BookTableModel bookTableModel;
    private JPanel buttonPanel;
    private JButton checkoutButton;
    private JButton returnButton;

    public BookListPanel() {
        initComponents();
        initEventListeners();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        //add book lists
        bookTableModel = new BookTableModel();
        bookTableModel.setBooks(BookList.getAvailableBooks());
        bookListTable = new JTable(bookTableModel);
        JScrollPane scrollPane = new JScrollPane(bookListTable);
        this.add(scrollPane);

        //add operation buttons: check out and return
        buttonPanel = new JPanel();
        checkoutButton = new JButton("check out");
        returnButton = new JButton("return");
        buttonPanel.add(checkoutButton);
        buttonPanel.add(returnButton);
        this.add(buttonPanel,BorderLayout.SOUTH);
    }

    private void initEventListeners() {
        //handle the checkout operation
        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowIndex = bookListTable.getSelectedRow();
                bookTableModel.deleteRow(rowIndex);
                //System.out.println("the books size after checkout:" + BookList.getTotalCount());
            }
        });

        //handle the return operation
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final JDialog returnDialog = new JDialog();
                returnDialog.setSize(400,150);
                returnDialog.setTitle("Return Book");

                JLabel bookNameLab = new JLabel("Input the ID of the book to return:");
                final JTextField bookIDTextField = new JTextField(20);
                JButton returnConfirmButton = new JButton("confirm to return the book");

                returnDialog.setLayout(new FlowLayout());
                returnDialog.add(bookNameLab);
                returnDialog.add(bookIDTextField);
                returnDialog.add(returnConfirmButton);
                returnDialog.setVisible(true);

                returnConfirmButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String id = bookIDTextField.getText();
                        bookTableModel.addRow(id);
                        //System.out.println("the books size after return:" + BookList.getTotalCount());
                        returnDialog.setVisible(false);
                    }
                });


            }
        });
    }

    public static void showBookList( Container contentPane ) {
        contentPane.removeAll();
        contentPane.add( new BookListPanel() );
        contentPane.repaint();
        contentPane.validate();
        contentPane.invalidate();
        contentPane.validate();
    }

}

class BookTableModel extends AbstractTableModel {
    private List<String> books;
    private String[] tableHeads = new String[] {
            "ID", "Name", "Author", "Publish Time"
    };

    @Override
    public int getRowCount() {
        return books.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        return tableHeads[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Book book = BookList.getBook(books.get(rowIndex));
        switch(columnIndex) {
            case 0: return book.getId();
            case 1: return book.getName();
            case 2: return book.getAuthorName();
            case 3: return book.getPublishYear();
            default: return null;
        }
    }

    public void setBooks( List<String> books ) {
        if( books == null )
            throw new IllegalArgumentException("The book list cannot be null");
        this.books = books;
        fireTableDataChanged();
    }

    public void addRow( String bookID ) {
        if( BookList.getBook(bookID) == null )
            throw new RuntimeException("Add fails");
        BookList.returnBook(bookID);
        fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
    }

    /**
     * delete according to the row
     * @param rowIndex the row to remove
     */
    public void deleteRow( int rowIndex ) {
        BookList.checkoutBook(books.get(rowIndex));
        fireTableRowsDeleted(getColumnCount(),getColumnCount());
    }

    /**
     * delete according to the object
     * @param book the book to remove
     */
    public void deleteRow( Book book ) {
        BookList.checkoutBook(book.getId());
        fireTableRowsDeleted(getColumnCount(),getColumnCount());
    }
}