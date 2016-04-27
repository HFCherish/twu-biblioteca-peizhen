package com.twu.biblioteca.basicModel;

import com.twu.biblioteca.widgets.MessageDialog;

import javax.swing.*;
import java.util.*;

/**
 * Created by Peizhen Zheng on 2016/4/21.
 */
public class ProductionList<T extends Production> {
    private Map<String, T> productions;
    private List<String> availableProductions;

    public ProductionList(){
        productions = new HashMap<String, T>();
        availableProductions = new ArrayList<String>();
    }

    public int checkoutProduction(String productionID ) {
        if( !availableProductions.contains(productionID) ){
            MessageDialog.showMessageDialog("That production is not available.", JOptionPane.ERROR_MESSAGE);
            return -1;
        }

        productions.get(productionID).setState(1);
        availableProductions.remove(productionID);
        MessageDialog.showMessageDialog("Thank you! Enjoy the production.", JOptionPane.INFORMATION_MESSAGE);
        return 1;
    }

    public int returnProduction(String productionID ) {
        if( !productions.containsKey(productionID) ) {
            MessageDialog.showMessageDialog("That is not a valid production to return.", JOptionPane.ERROR_MESSAGE);
            return -1;
        }

        availableProductions.add( productionID );
        productions.get(productionID).setState(0);
        MessageDialog.showMessageDialog("Thank you for returning the book.", JOptionPane.INFORMATION_MESSAGE);
        return 1;
    }

    public List<String> getAvailableProductions() {
        return availableProductions;
    }

    public Map<String, T> getAllProductions() {
        return productions;
    }

    public String createProductionID(){
        return String.valueOf( productions.size() + 1 );
    }

    public T getProduction(String id) {
        return productions.get(id);
    }

    public int getTotalCount() {
        return productions.size();
    }
}
