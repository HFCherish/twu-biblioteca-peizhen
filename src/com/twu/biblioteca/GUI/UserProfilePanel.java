package com.twu.biblioteca.GUI;

import com.twu.biblioteca.basicModel.Library;
import com.twu.biblioteca.basicModel.User;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Peizhen Zheng on 2016/4/24.
 */
public class UserProfilePanel extends JPanel{

    public UserProfilePanel() {
        initComponets();
    }

    private void initComponets() {
        JLabel titleLabel = new JLabel("My Profile");
        titleLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));

        JPanel profilePanel = new JPanel();
        profilePanel.setLayout(new GridLayout(10,1));
        profilePanel.setSize(200,300);
        User user = Library.getInstance().getPresentUser();
        JLabel nameLabel = new JLabel("Name: " + user.getName());
        JLabel libNumLabel = new JLabel("Library Number: " + user.getLibNum());
        JLabel emailLabel = new JLabel("Email: " + user.getEmail());
        JLabel addressLabel = new JLabel("Address: " + user.getAddress());
        JLabel phoneLabel = new JLabel("Phone: " + user.getPhoneNumber());
        profilePanel.add(nameLabel);
        profilePanel.add(libNumLabel);
        profilePanel.add(emailLabel);
        profilePanel.add(addressLabel);
        profilePanel.add(phoneLabel);

        setLayout(new BorderLayout());
        add(titleLabel, BorderLayout.NORTH);
        add(profilePanel);
    }

    public static void showUserProfilePanel( Container contentPane ) {
        contentPane.removeAll();
        contentPane.add( new UserProfilePanel() );
        contentPane.repaint();
        contentPane.validate();
        contentPane.invalidate();
        contentPane.validate();
    }
}
;
