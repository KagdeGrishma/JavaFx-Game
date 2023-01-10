package com.example.simonsjavafxgame;

import javafx.scene.image.ImageView;

/** This class is an Obstacle class.
 * <p>
 *    It is an obstract class which is inherited by other obstacle classes.
 *    It provides different implementation for different obstacles.
 *    It's methods can only have a declaration but not an implementation.
 * </p>
 *
 * @author Grishma Kagde
 *
 * @version 2022.12.01
 */
public abstract class Obstacles {

    public Position obstaclePosition;
    public ImageView icon;
    int imageHeight;
    int imageWidth;

    /**
     * Obstacle class constructor. (For setting the height and width of the obstacle images in the code.)
     */
    public Obstacles() {
        imageHeight = 50;
        imageWidth = 50;
    }

    /**
     * This is an abstract method for obstacles implemented by different obstacle classes.
     * <p>
     *     It gives information about players movement while discovering an obstacle in between.
     * </p>
     * @param player current player rolling the dice.
     * @param direction direction in which player will move.
     * @param diceRollValue dice roll value.
     * @param finalPosition final position of the player.
     */
    public abstract void simulation(Player player, String direction, int diceRollValue, Position finalPosition);
}
