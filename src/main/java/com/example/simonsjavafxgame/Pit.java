package com.example.simonsjavafxgame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
/** This class is a Pit Obstacle class.
 * <p>
 *     If in this pit, current player will miss it's next turn.
 *     It extends the abstract Obstacle class.
 * </p>
 *
 * @author Grishma Kagde
 *
 * @version 2022.12.01
 */
public class Pit extends Obstacles {

    public Pit() {
    }

    /**
     * This constructor will set the position of the obstacle on the board each time it's new instance is created.
     * It sets the pit image.
     * @param x x position of the pit on the board.
     * @param y y position of the pit on the board.
     */
    public Pit(int x, int y) {
        icon = new ImageView(new Image(
                new File("src/main/resources/images/pit.png").toURI().toString(), imageHeight, imageWidth, false , false)
        );
        obstaclePosition = new Position(x, y);
    }

    /**
     * This method will decide the movement of the player while in the pit.
     * <p>
     *     THis method will decide whether the current player has a miss a turn value as true or false and accordingly set it's current position.
     * </p>
     * @param player current player rolling the dice.
     * @param direction direction in which player will move.
     * @param diceRollValue dice roll value.
     * @param finalPosition final position of the player.
     */
    @Override
    public void simulation(Player player, String direction, int diceRollValue, Position finalPosition) {
        if(player.missTurn) {
            player.missTurn = false;
            player.setCurrentPosition(obstaclePosition.row, obstaclePosition.column);
        } else {
            player.missTurn = true;
            player.setCurrentPosition(obstaclePosition.row, obstaclePosition.column);
            System.out.println("Inside the  Pit");
            System.out.println(player.name + " misses the turn");
        }
    }
}
