package com.example.simonsjavafxgame;

import java.util.Random;

/** This class give the Dice information.
 * <p>
 *     It contains the method to generate a random value everytime a dice is rolled by the player.
 * </p>
 *
 * @author Grishma Kagde
 *
 * @version 2022.12.01
 */
public class Dice {
    int numberOnDice;

    /**
     * Parameterized constructor to set the value of the dice whenever it's instance is created.
     * @param m
     */
    public Dice(int m) {
        numberOnDice = m;
    }

    /**
     * This method provides the random value for the dice each time it is rolled
     * @return It returns a different integer value of the dice.
     */
    public int roll() {
        Random random = new Random();
        return (random.nextInt(numberOnDice) + 1);
    }
}
