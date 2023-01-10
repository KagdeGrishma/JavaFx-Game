package com.example.simonsjavafxgame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Represents a player in the game demo.
 *
 * @author Grishma Kagde
 */
public class Player {
    public String name;
    public Position currentPosition;
    public Position initialPosition;
    public Circle icon;
    int score = 0;

    public boolean missTurn;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    /**
     * Creates a new Player with the given name and color for the player's icon.
     *
     * @param name the name of the player
     * @param player1Color the color to use for the player's icon
     */

    public Player(String name, Color player1Color) {
        this.name = name;
        currentPosition = new Position();
        initialPosition = new Position();
        this.missTurn = false;
        icon = new Circle();
        icon.setRadius(20);
        icon.setFill(player1Color);
    }

    /**
     * Creates a new Player with default values.
     */
    public Player() {    }

    public Player(String name) {
        this.name=name;
    }


    /**
     * Sets the current position of the player.
     *
     * @param rowR the row of the position
     * @param colC the column of the position
     */
    public void setCurrentPosition(int rowR, int colC) {
        currentPosition.row = rowR;
        currentPosition.column = colC;
    }
    /**
     * Sets the initial position of the player.
     *
     * @param position the initial position of the player
     */
    public void setInitialPosition(Position position) {
        System.out.println("Seeeeetttinnggg initial position");
        initialPosition = position;
    }
    /**
     * Sets the current position of the player.
     *
     * @param p the current position of the player
     */
    public void setCurrentPosition(Position p) {
        currentPosition = p;
    }
    /**
     * Returns the current position of the player.
     *
     * @return the current position of the player
     */
    public Position getCurrentPosition() {
        return currentPosition;
    }
}