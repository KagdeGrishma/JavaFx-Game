package com.example.simonsjavafxgame;

import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.File;

/**
 * Represents a teleportation obstacle in the simons game.
 *
 * @author Grishma Kagde
 */
public class Teleportation extends Obstacles {

    public Teleportation() {
    }

    /**
     * Creates a new Teleportation object with the given position.
     *
     * @param x the row value of the position
     * @param y the column value of the position
     */
    public Teleportation(int x, int y) {
        icon = new ImageView(new Image(
                new File("src/main/resources/images/portal.png").toURI().toString(), imageHeight, imageWidth, false , false)
        );
        obstaclePosition = new Position(x, y);
    }

    /**
     *
     * Teleports the player to a initial  position on the game board.
     *
     * @param player current player rolling the dice.
     * @param direction direction in which player will move.
     * @param diceRollValue dice roll value.
     * @param finalPosition final position of the player.
     */

    @Override
    public void simulation(Player player, String direction, int diceRollValue, Position finalPosition) {
        // teleport to a random position
        System.out.println("In Teleportaion Portal");
        player.setCurrentPosition(obstaclePosition);
        System.out.println("Obstacle position for first animation: (" + obstaclePosition.row + ", " + obstaclePosition.column + ")");
        TranslateTransition transition = new TranslateTransition(Duration.millis(1000));
        transition.setToX((player.getCurrentPosition().column * 50) + 25);
        transition.setToY((player.getCurrentPosition().row * 50) + 25);
        transition.setAutoReverse(false);
//        transition.setOnFinished( animate2(player));
//        transition.play();
        int initialx = player.initialPosition.row;
        int initialy = player.initialPosition.column;
       player.setCurrentPosition(new Position(initialx, initialy)); // this works
 //       player.setCurrentPosition(randX, randY);
        System.out.println("Obstacle position for second animation: (" + obstaclePosition.row + ", " + obstaclePosition.column + ")");
        TranslateTransition transition2 = new TranslateTransition(Duration.millis(1000));
        transition2.setToX((player.getCurrentPosition().column * 50) + 25);
        transition2.setToY((player.getCurrentPosition().row * 50) + 25);
        transition2.setAutoReverse(false);

        SequentialTransition seqT = new SequentialTransition (player.icon, transition, transition2);
        seqT.play();

        System.out.println("Initial position: (" + player.initialPosition.row + ", " + player.initialPosition.column + ")");

    }

}