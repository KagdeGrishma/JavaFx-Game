package com.example.simonsjavafxgame;

import javafx.animation.TranslateTransition;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.File;

/**
 * Represents a fire obstacle in the simon's game.
 *
 * @author Grishma Kagde
 */
public class Fire extends Obstacles {
    public Fire() {
    }

    /**
     * Creates a new Fire object with the given position.
     *
     * @param x the row value of the position
     * @param y the column value of the position
     */
    public Fire(int x, int y) {
        icon = new ImageView(new Image(
                new File("src/main/resources/images/fire.png").toURI().toString(), imageHeight, imageWidth, false , false)
        );
        obstaclePosition = new Position(x, y);
    }

    /**
     * Moves the player around the fire obstacle. If the player is approaching the fire from the front or back, they can
     * choose to move left or right around the obstacle. If the player is approaching the fire from the side, they will
     * simply move past the obstacle.
     * @param player current player rolling the dice.
     * @param direction direction in which player will move.
     * @param diceRollValue dice roll value.
     * @param finalPosition final position of the player.
     */

    @Override
    public void simulation(Player player, String direction, int diceRollValue, Position finalPosition) {


        for (int i = 1; i <= diceRollValue; i++) {
            if (direction == "forward") {
                if (player.getCurrentPosition().row == obstaclePosition.row + 1) {
                    Button moveLeft = new Button();
                    Button moveRight = new Button();
                    int finalI = i;
                    moveLeft.setOnAction(e -> {
                        finalPosition.column = player.getCurrentPosition().column - finalI;

                    });
                    moveRight.setOnAction(e -> {
                        finalPosition.column = player.getCurrentPosition().column + finalI;
                    });
                    break;
                } else {
                    finalPosition.row = player.getCurrentPosition().row - i;
                }
            }


 /*       if(direction == "forward"){
            if(player.getCurrentPosition().row == obstaclePosition.row+1) {
                Button moveLeft = new Button();
                Button moveRight = new Button();
                moveLeft.setOnAction(e -> {
                    finalPosition.column = player.getCurrentPosition().column - steps;
                });
                moveRight.setOnAction(e -> {
                    finalPosition.column = player.getCurrentPosition().column + steps;
                });
            }
        }*/
            else if (direction == "backward") {
                if (player.getCurrentPosition().row == obstaclePosition.row - 1) {
                    Button moveLeft = new Button();
                    Button moveRight = new Button();
                    int finalI = i;
                    moveLeft.setOnAction(e -> {
                        finalPosition.column = player.getCurrentPosition().column - finalI;

                    });
                    moveRight.setOnAction(e -> {
                        finalPosition.column = player.getCurrentPosition().column + finalI;
                    });
                    break;
                } else {
                    finalPosition.row = player.getCurrentPosition().row + i;
                }
            }
            TranslateTransition transition = new TranslateTransition(Duration.millis(1000));
            transition.setToX((player.getCurrentPosition().column * 50) + 25);
            transition.setToY((player.getCurrentPosition().row * 50) + 25);
            transition.setAutoReverse(false);
            player.setCurrentPosition(finalPosition.row, finalPosition.column);
        }
    }
}
