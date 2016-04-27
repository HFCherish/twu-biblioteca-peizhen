package com.twu.biblioteca.GUI;

import com.twu.biblioteca.basicModel.Book;
import com.twu.biblioteca.basicModel.Library;
import com.twu.biblioteca.basicModel.Movie;
import com.twu.biblioteca.basicModel.ProductionList;

/**
 * Created by Peizhen Zheng on 2016/4/24.
 */
public class MovieTableModel extends ProductionTableModel {
    private String[] tableHeads = new String[] {
            "ID", "Name", "Year", "Director", "Rating"
    };

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ProductionList<Movie> movieList = Library.getInstance().getMovieList();
        Movie movie = movieList.getProduction(productions.get(rowIndex));
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
    public void addRow( String productionID ) {
        ProductionList<Movie> movieList = Library.getInstance().getMovieList();
        if( movieList.getProduction(productionID) == null )
            throw new RuntimeException("Add fails");
        movieList.returnProduction(productionID);
        fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
    }

    /**
     * delete according to the row
     * @param rowIndex the row to remove
     */
    @Override
    public void deleteRow( int rowIndex ) {
        ProductionList<Movie> movieList = Library.getInstance().getMovieList();
        movieList.checkoutProduction(productions.get(rowIndex));
        fireTableRowsDeleted(getColumnCount(),getColumnCount());
    }

    @Override
    public String getColumnName(int column) {
        return tableHeads[column];
    }
}
