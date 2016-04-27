package com.twu.biblioteca.GUI;

import com.twu.biblioteca.basicModel.ProductionList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Peizhen Zheng on 2016/4/21.
 */
public class ProductionListPanel extends JPanel {
    private JTable productionListTable;
    private ProductionTableModel productionTableModel;
    private ProductionList productionList;
    private JPanel buttonPanel;
    private JButton checkoutButton;
    private JButton returnButton;

    public ProductionListPanel( ProductionTableModel productionTableModel, ProductionList productionList ) {
        this.productionTableModel = productionTableModel;
        this.productionList = productionList;
        initComponents();
        initEventListeners();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        //add production lists
        productionTableModel.setProductions(productionList.getAvailableProductions());
        productionListTable = new JTable(productionTableModel);
        JScrollPane scrollPane = new JScrollPane(productionListTable);
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
                int rowIndex = productionListTable.getSelectedRow();
                productionTableModel.deleteRow(rowIndex);
                //System.out.println("the books size after checkout:" + ProductionList.getTotalCount());
            }
        });

        //handle the return operation
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final JDialog returnDialog = new JDialog();
                returnDialog.setSize(400,150);
                returnDialog.setTitle("Return Production");

                JLabel productionNameLab = new JLabel("Input the ID of the production to return:");
                final JTextField productionIDTextField = new JTextField(20);
                JButton returnConfirmButton = new JButton("confirm to return the production");

                returnDialog.setLayout(new FlowLayout());
                returnDialog.add(productionNameLab);
                returnDialog.add(productionIDTextField);
                returnDialog.add(returnConfirmButton);
                returnDialog.setVisible(true);
                returnDialog.setLocationRelativeTo(productionListTable);

                returnConfirmButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String id = productionIDTextField.getText();
                        productionTableModel.addRow(id);
                        returnDialog.setVisible(false);
                    }
                });


            }
        });
    }

    public static void showProductionList(Container contentPane, ProductionListPanel productionListPanel ) {
        contentPane.removeAll();
        contentPane.add( productionListPanel );
        contentPane.repaint();
        contentPane.validate();
        contentPane.invalidate();
        contentPane.validate();
    }

}