package com.twu.biblioteca.GUI;

import com.twu.biblioteca.basicModel.Book;
import com.twu.biblioteca.basicModel.Production;
import com.twu.biblioteca.basicModel.ProductionList;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by Peizhen Zheng on 2016/4/24.
 */
public class ProductionTableModel extends AbstractTableModel {
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

    public void addRow( String productionID ) {
        if( ProductionList.getProduction(productionID) == null )
            throw new RuntimeException("Add fails");
        ProductionList.returnProduction(productionID);
        fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
    }

    /**
     * delete according to the row
     * @param rowIndex the row to remove
     */
    public void deleteRow( int rowIndex ) {
        ProductionList.checkoutProduction(productions.get(rowIndex));
        fireTableRowsDeleted(getColumnCount(),getColumnCount());
    }

}
