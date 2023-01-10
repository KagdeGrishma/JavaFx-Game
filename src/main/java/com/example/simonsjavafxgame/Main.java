package com.example.simonsjavafxgame;

import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;


/** Main class of the game.
 * <p>
 *     This class contains the main method from where the execution of the game will begin.
 * </p>
 * <p>
 *     This class contains important methods for the game.
 *     It contains the method to start the game, setup the player and obstacles on the board, player movement and presence of any obstacles.
 * </p>
 *
 * @author Grishma Kagde
 *
 * @version 2022.12.01
 */
public class Main extends Application {
    Player player1;
    Player player2;
    Group tileGroup = new Group();
    VBox diceArea = new VBox();
    ArrayList<Obstacles> obstacles = new ArrayList<Obstacles>();
    HashMap<String,Integer> winnerList = new HashMap<>();


/*    public Main(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }*/

    /**
     * The start() method is the main entry point for all JavaFX applications.
     * <p>
     *     It takes stage as input and set the game scene.
     * </p>
     * <p>
     *     This method contains the game board and the dice Area information along with displaying all the player related information.
     * </p>
     *
     * @param stage
     *
     */
    public void start(Stage stage) {
        Dice dice = new Dice(4);
        try {
            Text text1 = new Text(" Enter Your Name Player One");
            TextField field = new TextField();
            field.setMaxWidth(200);
            Button btn = new Button("Enter game");
            btn.setStyle("-fx-background-color: #fc88b5");
            btn.setPrefSize(200,70);
            VBox vBox1 = new VBox(20);
            vBox1.setStyle("-fx-background-color: #6b9eb0");
            vBox1.getChildren().addAll(text1, field, btn);
            vBox1.setAlignment(Pos.CENTER);
            Scene scene = new Scene(vBox1, 600, 600);
            scene.setFill(Color.DARKGREY);
            stage.setTitle("Grishmas Game");
            stage.setScene(scene);
            stage.show();

            btn.setOnAction(event -> {
                // create com.example.gamedemo.Player
                player1 = new Player(field.getText(), Color.GREEN);
                Text text2 = new Text("Enter Your Name Player Two");
                TextField nameField2 = new TextField();
                nameField2.setMaxWidth(200);
                Button btn2 = new Button("Start game");
                btn2.setStyle("-fx-background-color: #fc88b5");
                btn2.setPrefSize(200,70);
                VBox vBox2 = new VBox(20);
                vBox2.setStyle("-fx-background-color: #6b9eb0");
                vBox2.getChildren().addAll(text2, nameField2, btn2);
                vBox2.setAlignment(Pos.CENTER);

                Scene scene2 = new Scene(vBox2, 600, 600);
                stage.setScene(scene2);

                btn2.setOnAction(event2 -> {
                    player2 = new Player(nameField2.getText(), Color.YELLOW);
                    VBox playground = new VBox();
                    playground.setStyle("-fx-background-color: #6b9eb0");
                    diceArea = new VBox();
                    Text rollTheDice = new Text(player1.name + " Roll The Dice.");
                    Text diceDirection = new Text();
                    Button button = new Button("Dice");
                    button.setPrefSize(100,60);
                    diceArea.getChildren().add(rollTheDice);
                    diceArea.getChildren().add(diceDirection);
                    diceArea.getChildren().add(button);
                    Pane board = new Pane();
                    board.setPrefSize(300,600);
                    Dialog<Boolean> boardSpecs = new Dialog<>();
                    Button showLeaderBoard = new Button("LeaderBoard");
                    showLeaderBoard.setPrefSize(290,50);
                    Button quit = new Button("Quit");
                    quit.setOnMouseClicked(event1 ->{
                        boardSpecs.setResult(Boolean.TRUE);
                        boardSpecs.hide();
                        boardSpecs.close();
                    });
                    showLeaderBoard.setLayoutX(100);
                    showLeaderBoard.setLayoutY(boardSpecs.getHeight()-50);
                    showLeaderBoard.setOnAction(actionEvent -> {
                        try {
                            displayScoreBoard();
                        } catch (FileNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    for(int i = 0; i < 10; i++) {
                        for(int j = 0; j < 7; j++) {
                            Rectangle tile = new Rectangle(50, 50);
                            tile.setFill(Color.BURLYWOOD);
                            tile.setStroke(Color.BLACK);
                            tile.setTranslateX(j * 50);
                            tile.setTranslateY(i * 50);
                            tileGroup.getChildren().addAll(tile);
                        }
                    }

                    Pit pitObstacle = new Pit(6,0);
                    Pit pitObstacle1 = new Pit(4,4);
                    Fire fireObstacle1 = new Fire(2,1);
                    Fire fireObstacle2 = new Fire(5,3);
                    Fire fireObstacle3 = new Fire(2, 3);
                    //Fire fireObstacle4 = new Fire(2,5);

                    Teleportation portalObstacle1 = new Teleportation(4,2);
                    Teleportation portalObstacle2 = new Teleportation(5,5);
/*                   Pit pitObstacle = new Pit(0,0);
                    Pit pitObstacle1 = new Pit(0,4);
                    Fire fireObstacle1 = new Fire(0,1);
                    Fire fireObstacle2 = new Fire(0,3);
                    Fire fireObstacle3 = new Fire(2, 3);
                    //Fire fireObstacle4 = new Fire(2,5);

                    Teleportation portalObstacle1 = new Teleportation(0,2);
                    Teleportation portalObstacle2 = new Teleportation(0,5);*/


                    isObstacle(pitObstacle);
                    isObstacle(pitObstacle1);
                    isObstacle(fireObstacle1);
                    isObstacle(fireObstacle2);
                    isObstacle(fireObstacle3);
                    isObstacle(portalObstacle1);
                    isObstacle(portalObstacle2);

                    player1.setInitialPosition(new Position(9, 0));
                    player2.setInitialPosition(new Position(9, 1));
                    player(player1, new Position(9, 0));
                    player(player2, new Position(9, 4));

                    board.getChildren().addAll(tileGroup);
                    playground.getChildren().add(0, diceArea);
                    playground.getChildren().add(1, board);
                    playground.getChildren().add(2,showLeaderBoard);
                    Scene scene3 = new Scene(playground);
                    stage.setScene(scene3);

                    final Player[] currentPlayer = {player1};
                    button.setOnAction(event3 -> {
                        // roll the dice
                        int diceRollValue = dice.roll();
                        rollTheDice.setText("You got " + diceRollValue + ". Waiting for the Direction Now.");
                        button.setDisable(true);
                        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(2));
                        pauseTransition.setOnFinished(e -> {
                            String direction = getDirection(dice.roll());
                            diceDirection.setText("You Got " + direction + ".");
                            PauseTransition pauseTransition1 = new PauseTransition(Duration.seconds(2));
                            pauseTransition1.setOnFinished(e2 -> {
                                // move the currentplayer here
                                simulation(currentPlayer[0], direction, diceRollValue);
                                if(currentPlayer[0].getCurrentPosition().row == 0) {
                                    rollTheDice.setText(currentPlayer[0].name + " !!!!You Won!!!!");
                                    diceDirection.setText(" !!!Congrats!!!");
                                    try {
                                        scoreBoard(currentPlayer[0]);
                                    } catch (FileNotFoundException ex) {
                                        throw new RuntimeException(ex);
                                    }
                                    // Change Scene
                                    button.setVisible(false);
                                } else {
                                    currentPlayer[0] = changePlayer(currentPlayer[0]);
                                    rollTheDice.setText( currentPlayer[0].name + " Roll The Dice");
                                    diceDirection.setText("");
                                    button.setDisable(false);
                                }
                            });
                            pauseTransition1.play();
                        });
                        pauseTransition.play();
                    });
                });
            });
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Displays the scoreboard for the game.
     * <p>
     *     This method reads a file containing the scores and names of previous winners and displays them in a dialog box.
     *     The scores are sorted in descending order, with the highest score at the top.
     * </p>
     * <p>
     *     The scoreboard dialog also includes a cancel button to close the dialog.
     * </p>
     * @throws FileNotFoundException if the file containing the scores cannot be found
     */
    private void displayScoreBoard() throws FileNotFoundException {
        String line = "";
        Dialog scoreboard = new Dialog();
        scoreboard.setTitle("ScoreBoard");
        ScrollPane scrollPane = new ScrollPane();
        VBox scoreboardVbox = new VBox();
        scoreboardVbox.setStyle("-fx-background-color: #6b9eb0");

        try {
            BufferedReader bf = new BufferedReader(new FileReader("src/main/resources/ScoreBoard.csv"));
            while ((line = bf.readLine()) != null) {
                String[] winners = line.split(",");
                winnerList.put(winners[0],Integer.parseInt(winners[1]));
            }
            Rectangle scoreHeader = new Rectangle(100, 50);
            scoreHeader.setFill(Color.LIGHTGREY);
            Label headerLabel = new Label("SCORE");
            StackPane stackPaneScoreHeader = new StackPane(scoreHeader, headerLabel);
            Rectangle winnerHeader = new Rectangle(100, 50);
            winnerHeader.setFill(Color.LIGHTGREY);
            Label pHeaderLabel = new Label("NAME");
            StackPane stackPanePlayerHeader = new StackPane(winnerHeader, pHeaderLabel);
            HBox header = new HBox(stackPaneScoreHeader, stackPanePlayerHeader);
            scoreboardVbox.getChildren().add(header);
            winnerList.forEach((key,value) -> {
                Rectangle score = new Rectangle(100, 50);
                score.setFill(Color.TRANSPARENT);
                Label scoreLabel = new Label(Integer.toString(value));
                StackPane scoreSP = new StackPane(score, scoreLabel);
                Rectangle playerName = new Rectangle(100, 50);
                playerName.setFill(Color.TRANSPARENT);
                Label winnerName = new Label(key);
                StackPane StackPaneWinnerName = new StackPane(playerName, winnerName);
                HBox entries = new HBox(scoreSP, StackPaneWinnerName);
                scoreboardVbox.getChildren().addAll(entries);
            });
            bf.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        scrollPane.setContent(scoreboardVbox);
        scoreboard.getDialogPane().setContent(scrollPane);
        scoreboard.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);

        scoreboard.showAndWait();
    }
    /**
     * This method gives the direction that the player will move whenever a dice is rolled.
     * <p>
     *     It uses a switch case to determine the direction. the player will move.
     *     If the value is 1 and 2 it will move the player forward, if it's 3 it will mover the player backward and finally for 4 it will  miss a turn.
     * </p>
     *
     * @param m is the dice value
     * @return direction at which the player will move.
     */
    public String getDirection(int m) {
        switch(m) {
            case 1:
            case 2:
                return "forward";
            case 3:
                return "backward";
            default:
                return "miss a turn";
        }
    }

    /**
     * This method is used for displaying player on the board.
     * <p>
     *     It sets the x and y coordinates using javafx methods.
     * </p>
     * @param player contains player's information like it's current, initial position and also its display information.
     * @param position it contains the row and column values.
     */
    public void player(Player player, Position position) {
        // TO DO: Get first position from user
        player.setCurrentPosition(position);
        player.icon.setTranslateX((position.column * 50) + 25);
        player.icon.setTranslateY((position.row * 50) + 25);
        tileGroup.getChildren().add(player.icon);
    }

    /**
     * <p>
     *     This is the method from where the execution begin.
     * </p>
     * @param args
     */
    public static void main(String args[]) {
        Application.launch(args);
    }

    /**
     * This method is used for setting the obstacles on the gameboard.
     * @param obstacle is an object of an abstract class Obstacles that gives information of different types of obstacles on the board.
     */
    public void isObstacle(Obstacles obstacle) {
        obstacle.icon.setTranslateX((obstacle.obstaclePosition.column * 50) + 2);
        obstacle.icon.setTranslateY((obstacle.obstaclePosition.row * 50) + 2);
        tileGroup.getChildren().addAll(obstacle.icon);
        obstacles.add(obstacle);
    }


    /**
     * This method displays the players movement from the current position to the final position.
     *<p>
     *     It uses a Translate Transition reference variable to set the X and Y coordinated of the player on the board.
     *</p>
     * @param p represents a player.
     */
    public void gameAnimation(Player p){
        TranslateTransition transition = new TranslateTransition(Duration.millis(1000),p.icon);
        transition.setToX((p.getCurrentPosition().column * 50) + 25);
        transition.setToY((p.getCurrentPosition().row * 50) + 25);
        transition.setAutoReverse(false);
        transition.play();
    }

    /**
     * This method is for Pit obstacle.
     * <p>
     *     It checks whether the current player, on the pit will miss the turn or not.
     * </p>
     * @param currentPlayer it takes the current player as input
     * @return returns either player 1 or player 2.
     */
    public Player changePlayer(Player currentPlayer) {
        if(currentPlayer == player1){
            if(player2.missTurn) {
                System.out.println("Player2 will miss a turn");
                player2.missTurn = false;
                return player1;
            }
            else {
                System.out.println("Player2 will not miss the turn");
                return player2;
            }
        }
        else {
            if(player1.missTurn) {
                System.out.println("Player1 will miss a turn");
                player1.missTurn = false;
                return player2;
            }
            else {
                System.out.println("Player1 will not miss the turn");
                return player1;
            }
        }
    }

    /**
     * This method will move the player on the board.
     * <p>
     *     It first checks that direction is forward or backward and then checks for any obstacle while the player is moving.
     * </p>
     * @param player it is the  current player who has rolled the dice
     * @param direction this is the direction in which the player will move
     * @param diceRollValue this is the value of the dice rolled by the player.
     */
    public void simulation(Player player, String direction, int diceRollValue) {
        if (direction.equals("miss a turn")) {
            return;
        }
        Position playerPosition = player.getCurrentPosition();
        int rowValue = 9;
        // move the players according to the input given
        if (direction.equals("forward")) {
            rowValue = playerPosition.row - diceRollValue;
            if(rowValue < 0) {
                rowValue = 0;
            }
        } else if (direction.equals("backward")) {
            rowValue = playerPosition.row + diceRollValue;
            if(rowValue > 9)
                rowValue = 9;
        }
        Position finalPosition = new Position(rowValue, playerPosition.column);
        int flag = 0;
//        System.out.println("******ITERATION STARTS*************");
//        printObstacles();
        for(Obstacles obstacle: obstacles) {
//            System.out.println("_____BEFORE OBSTACLE CHECK----------");
//            System.out.println("Player INITIAL Position: (" + playerPos.row + ", " + playerPos.column + ")");
//            System.out.println("Player FINAL Position: (" + finalPosition.row + ", " + finalPosition.column + ")");
//            System.out.println("Obstacle Position: (" + obstacle.position.row + ", " + obstacle.position.column + ")");

            if(((playerPosition.row < obstacle.obstaclePosition.row && obstacle.obstaclePosition.row <= finalPosition.row) ||
                (finalPosition.row <= obstacle.obstaclePosition.row && obstacle.obstaclePosition.row < playerPosition.row)) &&
                (finalPosition.column == obstacle.obstaclePosition.column)) {
                System.out.println("Obstacles");
                //This is the method to move the player while there is an obstacle
                obstacle.simulation(player, direction, diceRollValue, finalPosition);
                flag = 1;
                break;
            }
        }
//        System.out.println("******ITERATION ENDS*************");

        if(flag == 0){
            player.setCurrentPosition(finalPosition.row, finalPosition.column);
        }
        System.out.println("Before multiplying: " + (player.getCurrentPosition().row)  + ", " + (player.getCurrentPosition().column));
        gameAnimation(player);
    }

    /**
     * This method reads a file containing the scores and names of previous winners.
     * If the player's name is already in the file, their score is set to 100.
     * Otherwise, the player's name and score (initialized to 100) are added to the file.
     * @param player the player whose score is to be added to the scoreboard.
     */
    public void scoreBoard(Player player) throws FileNotFoundException {
        String line = "";
        try{
            BufferedReader bf = new BufferedReader(new FileReader("src/main/resources/ScoreBoard.csv"));
            while ((line = bf.readLine()) != null) {
                String[] winners = line.split(",");
                winnerList.put(winners[0], Integer.parseInt(winners[1]));
            }

        int winnerScore=0;
                ArrayList<ScoreCard> list=new ArrayList();

            if(winnerList.containsKey(player.name)){
                winnerScore=winnerList.get(player.name) + 100;
            }
            else
                winnerScore=100;

            winnerList.put(player.name,winnerScore);
            File scoreBoard = new File("src/main/resources/ScoreBoard.csv");
            System.out.println("Outside If condition");
            if (scoreBoard.isFile()) {
                System.out.println("Inside If condition");
                FileWriter writer = new FileWriter(scoreBoard,true);
                String str= "";
                for(Map.Entry<String, Integer> entry : winnerList.entrySet()) {
                    str=str + entry.getKey() + ',' + entry.getValue() + '\n';
                };
                System.out.println(str);
                writer.write(str);
                writer.flush();
                writer.close();


            } else {
                FileWriter newFile = new FileWriter("src/main/resources/ScoreBoard.csv");
                newFile.append(String.join(",", player.name, Integer.toString(100)));
                newFile.append("\n");
                newFile.flush();
                newFile.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

        public void printObstacles() {
        for (Obstacles obstacle : obstacles) {
            System.out.println("Obstacle Position: (" + obstacle.obstaclePosition.row + ", " + obstacle.obstaclePosition.column + ")");
        }
    }
}
