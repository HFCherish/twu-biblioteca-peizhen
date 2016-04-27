package com.twu.biblioteca.GUI;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by Peizhen Zheng on 2016/4/24.
 */
public abstract class ProductionTableModel extends AbstractTableModel {
    protected List<String> productions;

    @Override
    public int getRowCount() {
        return productions.size();
    }

    /**
     * This Method should be override by the children
     * @return
     */
    @Override
    public int getColumnCount() {
        return 0;
    }

    /**
     * This Method should be override by the childer
     * @param rowIndex
     * @param columnIndex
     * @return
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }

    public void setProductions(List<String> productions) {
        if( productions == null )
            throw new IllegalArgumentException("The production list cannot be null");
        this.productions = productions;
        fireTableDataChanged();
    }

    public abstract void addRow( String productionID );

    public abstract void deleteRow( int rowIndex );

}
