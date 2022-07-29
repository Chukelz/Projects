package uk.ac.soton.comp1206.game;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.io.Serializable;

/**
 * The Grid is a model which holds the state of a game board. It is made up of a set of Integer values arranged in a 2D
 * arrow, with rows and columns.
 *
 * Each value inside the Grid is an IntegerProperty can be bound to enable modification and display of the contents of
 * the grid.
 *
 * The Grid contains functions related to modifying the model, for example, placing a piece inside the grid.
 *
 * The Grid should be linked to a GameBoard for it's display.
 */
public class Grid implements Serializable {

    private final int cols;
    private final int rows;
    private final SimpleIntegerProperty[][] grid;

    //initializes variables in the code

    public Grid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        //creates a grid with rows and columns

        //Create the grid itself
        grid = new SimpleIntegerProperty[cols][rows];

        //Add a SimpleIntegerProperty to every block in the grid
        for(var y = 0; y < rows; y++) {
            for(var x = 0; x < cols; x++) {
                grid[x][y] = new SimpleIntegerProperty(0);
            }
        }
    }

    public IntegerProperty getGridProperty(int x, int y) {
        return grid[x][y];
        //return integer property at the point in the grid
    }

    public void set(int x, int y, int value) {
        grid[x][y].set(value);
        //updates or sets the value at the point in the grid
    }

    public int get(int x, int y) {
        try {
            //Get the value held in the property at the x and y index provided
            return grid[x][y].get();
        } catch (ArrayIndexOutOfBoundsException e) {
            //No such index
            return -1;
        }
    }

    public int getCols() {
        return cols;
        //getter to return number of columns
    }

    public int getRows() {
        return rows;
        //getter to return number of rows
    }

    public boolean canPlayPiece(GamePiece gamePiece, int placeX, int placeY) {

        int[][] blocks = gamePiece.getBlocks();

        for (int x = 0; x < blocks.length; x++) {
            for (int y = 0; y < (blocks[x]).length; y++) {

                int value = blocks[x][y];

                if (value != 0) {
                    int gridValue = get(x + placeX, y + placeY);
                    if (gridValue != 0)
                        return false;
                }
            }
        }
        return true;
        //iterates over all the blocks and checks to see if their property is 0
        //if its 0, it can be played, and it returns true else false
    }

    public boolean playPiece(GamePiece piece, int placeX, int placeY) {

        int[][] blocks = piece.getBlocks();

        if (!canPlayPiece(piece, placeX, placeY))
            return false;

        for (int x = 0; x < blocks.length; x++) {
            for (int y = 0; y < (blocks[x]).length; y++) {
                int value = blocks[x][y];
                if (value != 0)
                    set(x + placeX , y + placeY, value);
            }
        }

        return true;
    }

    /**
     * Center the piece
     * @param piece the game piece
     * @param placeX x coordinate
     * @param placeY y coordinate
     * @return
     */
    public boolean centerPiece(GamePiece piece, int placeX, int placeY) {
        placeX--;
        placeY--;
        return playPiece(piece, placeX, placeY);
    }

    /**
     * Clear a line
     */
    public void clear() {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                this.grid[i][j].set(0);
            }
        }
    }

}
