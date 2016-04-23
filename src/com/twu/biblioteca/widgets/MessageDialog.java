package com.twu.biblioteca.widgets;

import javax.swing.*;

/**
 * Created by Peizhen Zheng on 2016/4/21.
 */
public class MessageDialog {
    public static void showMessageDialog( Object message, int messageType ) {
        JOptionPane.showMessageDialog(null, message, "System Message", messageType);
    }
}
