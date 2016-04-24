package com.twu.biblioteca.GUI;

import com.twu.biblioteca.basicModel.Movie;
import com.twu.biblioteca.basicModel.ProductionList;

/**
 * Created by Peizhen Zheng on 2016/4/24.
 */
public class MovieTableModel extends ProductionTableModel {
    private String[] tableHeads = new String[] {
            "ID", "Name", "Year", "Director", "rating"
    };

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Movie movie = (Movie) ProductionList.getProduction(productions.get(rowIndex));
        switch (columnIndex) {
            case 0: return movie.getId();
            case 1: return movie.getName();
            case 2: return movie.getYear();
            case 3: return movie.getAuthorName();
            case 4: return movie.getRating() == 0 ? "unrated" : movie.getRating();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return tableHeads[column];
    }
}
