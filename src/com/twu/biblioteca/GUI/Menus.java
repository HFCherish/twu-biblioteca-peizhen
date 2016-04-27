package com.twu.biblioteca.GUI;

import com.twu.biblioteca.basicModel.Library;
import com.twu.biblioteca.basicModel.Production;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Peizhen Zheng on 2016/4/21.
 */
public class Menus extends JMenuBar{
    private JMenu operationMenu;
    private JMenuItem listBooksMenuItem;
    private JMenuItem listMoviesMenuItem;
    private JMenu myAccountMenu;
    private JMenuItem myProfileMenuItem;

    public Menus() {
        initComponents();
        initEventListeners();
    }

    private void initComponents() {
        //add the operation menu, including "List Books" and "List Movies"
        operationMenu = new JMenu("Operations");
        listBooksMenuItem = new JMenuItem("List Books");
        listMoviesMenuItem = new JMenuItem("List Movies");
        operationMenu.add(listBooksMenuItem);
        operationMenu.add(listMoviesMenuItem);
        add(operationMenu);

        //add the user account menu, including "My Profile"
        myAccountMenu = new JMenu("My Account");
        myProfileMenuItem = new JMenuItem("My Profile");
        myAccountMenu.add(myProfileMenuItem);
        add(myAccountMenu);
    }

    private void initEventListeners() {
        listBooksMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductionListPanel.showProductionList( getRootPane().getContentPane(), new ProductionListPanel(new BookTableModel(), Library.getInstance().getBookList()) );
            }
        });

        listMoviesMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductionListPanel.showProductionList( getRootPane().getContentPane(), new ProductionListPanel(new MovieTableModel(), Library.getInstance().getMovieList()));
            }
        });

        myProfileMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserProfilePanel.showUserProfilePanel(getRootPane().getContentPane());
            }
        });
    }
}
