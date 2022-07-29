package uk.ac.soton.comp1206.component;

import uk.ac.soton.comp1206.game.GamePiece;
import uk.ac.soton.comp1206.game.Grid;

public class PieceBoard extends GameBoard{
    public PieceBoard(Grid grid, double width, double height) {
        super(grid, width, height);
    }

    /**
     * Creat a new PieceBoard with it's own cols, rows, width and height
     * @param cols number of columns for internal grid
     * @param rows number of rows for internal grid
     * @param width the visual width
     * @param height the visual height
     */
    public PieceBoard(int cols, int rows, double width, double height) {
        super(cols,rows,width,height);
        //Build the PieceBoard
        build();
    }

    /**
     * Display a GamePiece instance on the PieceBoard
     * @param gamePiece GamePiece to be displayed on the monitor
     */
    public void displayPiece(GamePiece gamePiece) {
        this.grid.clear();
        this.grid.playPiece(gamePiece,0,0);
    }

    /**
     * Show the place point on the PieceBoard instance
     */
    public void showCenter() {
        this.getBlock(1,1).setCenter();
    }
}
