package com.example.simonsjavafxgame;


/**
 * The ScoreCard class represents a scorecard for a game.
 * It contains a player's name and their score.
 * @author Grishma Kagde
 * @version 2022.18.01
 */
public class ScoreCard {
    private String name;
    private int score;

    /**Constructs a ScoreCard object with the given name and score.
     * @param name the player's name
     * @param score the player's score
     */
    public ScoreCard(String name, int score) {
        this.name = name;
        this.score = score;
    }

    /**
     * Returns the player's name.
     * @return the player's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the player's name.
     * @param name the player's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the player's score.
     * @return the player's score.
     */
    public int getScore() {
        return score;
    }

    /**
     * Sets the player's score.
     * @param score the player's name.
     */
    public void setScore(int score) {
        this.score = score;
    }
}
