package uk.ac.soton.comp1206.game;

import java.io.Serializable;

/**
 * Instances of GamePiece Represents the model of a specific Game Piece with it's block makeup.
 *
 * The GamePiece class also contains a factory for producing a GamePiece of a particular shape, as specified by it's
 * number.
 */
public class GamePiece implements Serializable{

    public static final int PIECES = 15;
    private int[][] blocks;
    private final int value;
    private final String name;

    public static GamePiece createPiece(int piece) {
        switch (piece) {
            //Line
            case 0 -> {
                int[][] blocks = {{0, 0, 0}, {1, 1, 1}, {0, 0, 0}};
                return new GamePiece("Line", blocks, 1);
            }

            //C
            case 1 -> {
                int[][] blocks = {{0, 0, 0}, {1, 1, 1}, {1, 0, 1}};
                return new GamePiece("C", blocks, 2);
            }

            //Plus
            case 2 -> {
                int[][] blocks = {{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};
                return new GamePiece("Plus", blocks, 3);
            }

            //Dot
            case 3 -> {
                int[][] blocks = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
                return new GamePiece("Dot", blocks, 4);
            }

            //Square
            case 4 -> {
                int[][] blocks = {{1, 1, 0}, {1, 1, 0}, {0, 0, 0}};
                return new GamePiece("Square", blocks, 5);
            }

            //L
            case 5 -> {
                int[][] blocks = {{0, 0, 0}, {1, 1, 1}, {0, 0, 1}};
                return new GamePiece("L", blocks, 6);
            }

            //J
            case 6 -> {
                int[][] blocks = {{0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
                return new GamePiece("J", blocks, 7);
            }

            //S
            case 7 -> {
                int[][] blocks = {{0, 0, 0}, {0, 1, 1}, {1, 1, 0}};
                return new GamePiece("S", blocks, 8);
            }

            //Z
            case 8 -> {
                int[][] blocks = {{1, 1, 0}, {0, 1, 1}, {0, 0, 0}};
                return new GamePiece("Z", blocks, 9);
            }

            //T
            case 9 -> {
                int[][] blocks = {{1, 0, 0}, {1, 1, 0}, {1, 0, 0}};
                return new GamePiece("T", blocks, 10);
            }

            //X
            case 10 -> {
                int[][] blocks = {{1, 0, 1}, {0, 1, 0}, {1, 0, 1}};
                return new GamePiece("X", blocks, 11);
            }

            //Corner
            case 11 -> {
                int[][] blocks = {{0, 0, 0}, {1, 1, 0}, {1, 0, 0}};
                return new GamePiece("Corner", blocks, 12);
            }

            //Inverse Corner
            case 12 -> {
                int[][] blocks = {{1, 0, 0}, {1, 1, 0}, {0, 0, 0}};
                return new GamePiece("Inverse Corner", blocks, 13);
            }

            //Diagonal
            case 13 -> {
                int[][] blocks = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
                return new GamePiece("Diagonal", blocks, 14);
            }

            //Double
            case 14 -> {
                int[][] blocks = {{0, 1, 0}, {0, 1, 0}, {0, 0, 0}};
                return new GamePiece("Double", blocks, 15);
            }
        }

        //Not a valid piece number
        throw new IndexOutOfBoundsException("No such piece: " + piece);
    }

    public static GamePiece createPiece(int piece, int rotation) {
        var newPiece = createPiece(piece);

        newPiece.rotate(rotation);
        return newPiece;
        //creates a new piece from above and rotates it by a given amount
    }

    private GamePiece(String name, int[][] blocks, int value) {
        this.name = name;
        this.blocks = blocks;
        this.value = value;
        //initializes a new gamepiece

        //Use the shape of the block to create a grid with either 0 (empty) or the value of this shape for each block.
        for(int x = 0; x < blocks.length; x++) {
            for (int y = 0; y < blocks[x].length; y++) {
                if(blocks[x][y] == 0) continue;
                blocks[x][y] = value;
            }
        }
    }

    public int getValue() {
        return value;
        //returns the value of this piece
    }

    public int[][] getBlocks() {
        return blocks;
        //returns the blocks taken up by the piece
    }


    public void rotate(int rotations) {
        for(int rotated = 0; rotated < rotations; rotated ++) {
            rotate();
            //rotate it as miny times as stated above
        }
    }

    public void rotate() {
        int[][] rotated = new int[blocks.length][blocks[0].length];
        rotated[2][0] = blocks[0][0];
        rotated[1][0] = blocks[0][1];
        rotated[0][0] = blocks[0][2];

        rotated[2][1] = blocks[1][0];
        rotated[1][1] = blocks[1][1];
        rotated[0][1] = blocks[1][2];

        rotated[2][2] = blocks[2][0];
        rotated[1][2] = blocks[2][1];
        rotated[0][2] = blocks[2][2];

        blocks = rotated;
        //rotate each piece block by block by assuming each piece is a 3x3 grid
    }

    public String toString() {
        return this.name;
    }

}
