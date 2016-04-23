package com.twu.biblioteca.GUI;

import com.twu.biblioteca.widgets.MessageDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Peizhen Zheng on 2016/4/21.
 */
public class Menus extends JMenuBar{
    //private JMenu operationMenu;
    private JMenuItem listBooksMenu;

    public Menus() {
        initComponents();
        initEventListeners();
    }

    private void initComponents() {
        //operationMenu = new JMenu("Operations");
        listBooksMenu = new JMenuItem("List Books");
        //operationMenu.add(listBooksMenu);
        add(listBooksMenu);
    }

    private void initEventListeners() {
        listBooksMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BookListPanel.showBookList( getRootPane().getContentPane() );
            }
        });

    }
}
