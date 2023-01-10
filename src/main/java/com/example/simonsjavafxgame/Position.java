package com.example.simonsjavafxgame;

/**
 * Represents a position in a game grid.
 *
 * @author Grishma Kagde
 */
public class Position {
    public int row;
    public int column;

    /**
     * Creates a new Position with default values.
     */
    public Position(){

    }
    /**
     * Creates a new Position with the given row and column values.
     *
     * @param x the row value of the position
     * @param y the column value of the position
     */
    public Position(int x, int y) {
        row = x;
        column = y;
    }
    /**
     * Returns the row value of the position.
     *
     * @return the row value of the position
     */
    public int getRow() {
        return row;
    }
    /**
     * Sets the row value of the position.
     *
     * @param row the row value to set for the position
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * Returns the column value of the position.
     *
     * @return the column value of the position
     */
    public int getColumn() {
        return column;
    }
    /**
     * Sets the column value of the position.
     *
     * @param column the column value to set for the position
     */
    public void setColumn(int column) {
        this.column = column;
    }
}
