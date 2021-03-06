package com.twu.biblioteca.GUI;

import com.twu.biblioteca.widgets.MessageDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Peizhen Zheng on 2016/4/21.
 */
public class Biblioteca extends JFrame{


    public Biblioteca() {
        initComponents();
        initEventListeners();
    }

    private void initComponents() {
        setTitle("Biblioteca - Library Management System");
        setSize(800,600);

        Container contentPane = getContentPane();

        setJMenuBar(new Menus());

        JLabel welcomeLabel = new JLabel("Welcome to the Biblioteca System!");

        contentPane.add(welcomeLabel);

        setLocationRelativeTo(null);
    }

    private void initEventListeners() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void start() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Biblioteca().setVisible(true);
            }
        });
    }

}
