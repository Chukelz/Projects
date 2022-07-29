package uk.ac.soton.comp1206.game;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;

public class SerializePack implements Serializable{
    String name;
    Integer score;
    Integer lives;
    Integer level;
    Integer multiplier;
    GamePiece currentPiece;
    GamePiece followingPiece;
    int[][] gridCoordinate;
    long delay;

    public SerializePack(String name, Integer score, Integer lives, Integer level, Integer multiplier, GamePiece currentPiece, GamePiece followingPiece, int[][]grid, long delay) {
        this.name = name;
        this.score = score;
        this.lives = lives;
        this.level = level;
        this.multiplier = multiplier;
        this.currentPiece = currentPiece;
        this.followingPiece = followingPiece;
        this.gridCoordinate = grid;
        this.delay = delay;
    }
}
