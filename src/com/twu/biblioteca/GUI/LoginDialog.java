package com.twu.biblioteca.GUI;

import com.twu.biblioteca.basicModel.Library;
import com.twu.biblioteca.basicModel.User;
import com.twu.biblioteca.widgets.MessageDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Peizhen Zheng on 2016/4/24.
 */
public class LoginDialog extends JDialog {
    private JButton loginButton;
    private JTextField accountTextField;
    private JPasswordField passwordField;

    public LoginDialog() {
        initComponents();
        initEventListeners();
    }

    private void initComponents() {
        //the input panel including account and password
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2,2,2,5));
        JLabel accountLabel = new JLabel("account:");
        JLabel passwordLabel = new JLabel("password:");
        accountTextField = new JTextField(10);
        passwordField = new JPasswordField(10);
        inputPanel.add(accountLabel);
        inputPanel.add(accountTextField);
        inputPanel.add(passwordLabel);
        inputPanel.add(passwordField);

        //hint for the input
        JLabel hint;
        hint = new JLabel("<html>The account is your library number, which is<br> in the format xxx-xxxx</html>");
        hint.setForeground(Color.red);

        //login button
        loginButton = new JButton("login");

        Container contentPane = getContentPane();
        contentPane.add(inputPanel);
        contentPane.add(hint);
        contentPane.add(loginButton);

        setSize(300,170);
        setLayout(new FlowLayout());
        setTitle("Login");
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void initEventListeners() {
        //handle login event
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String account = accountTextField.getText();
                String password = new String(passwordField.getPassword());
                boolean res = checkAccount(account, password);
                if(res){
                    Library library = Library.getInstance();
                    library.setPresentUser( library.getUser(account));
                    setVisible(false);
                    Biblioteca.start();
                }
            }
        });

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private boolean checkAccount(String account, String password) {
        User user = Library.getInstance().getUser(account);
        if( user == null ){
            MessageDialog.showMessageDialog("The account doesn't exist!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if( !user.getPassword().equals(password) ){
            MessageDialog.showMessageDialog("The Password is wrong!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginDialog();
            }
        });
    }
}
