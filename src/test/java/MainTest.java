import com.example.simonsjavafxgame.Main;
import com.example.simonsjavafxgame.Obstacles;
import com.example.simonsjavafxgame.Player;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    public  Player player1;
    public Player player2;

    @Test
    public void testGetDirection() {
        Main testing=new Main();
        //Main testing =new Main(player1,player2);
        // test case for value 1

        int m = 1;
        String expectedResult = "forward";
        String actualResult = testing.getDirection(m);
        assertEquals(expectedResult, actualResult);

        // test case for value 2
        m = 2;
        expectedResult = "forward";
        actualResult = testing.getDirection(m);
        assertEquals(expectedResult, actualResult);

        // test case for value 3
        m = 3;
        expectedResult = "backward";
        actualResult = testing.getDirection(m);
        assertEquals(expectedResult, actualResult);

        // test case for value 4
        m = 4;
        expectedResult = "miss a turn";
        actualResult = testing.getDirection(m);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testScoreBoard() throws FileNotFoundException {
        // Create a new player with a name
        Main testing=new Main();
        Player player = new Player("grish");

        // Invoke the scoreBoard method with the player object
        testing.scoreBoard(player);

        // Read the ScoreBoard.csv file and store the contents in a list
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/ScoreBoard.csv"))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Split the line by the comma delimiter and store the name and score in separate variables
        String[] nameAndScore = lines.get(0).split(",");
        String name = nameAndScore[0];
        int score = Integer.parseInt(nameAndScore[1]);

        // Assert that the name and score match the player's name and score (100)
        assertEquals(player.name, name);
        assertEquals(0, score);
    }

}
