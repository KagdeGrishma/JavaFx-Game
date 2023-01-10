

import com.example.simonsjavafxgame.Dice;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class DiceTest {

    // Test the roll method for different values of the numberOnDice field

    @Test
    public void testRollNumberOnDiceFour() {
        Dice dice = new Dice(4);
        for (int i = 0; i < 1000; i++) {
            int roll = dice.roll();
            assertTrue(roll >= 1 && roll <= 4);
        }
    }


    // Test the roll method for different instances of the Dice class
    @Test
    public void testRollDifferentInstances() {
        Dice dice1 = new Dice(6);
        Dice dice2 = new Dice(4);
        int roll1 = dice1.roll();
        int roll2 = dice2.roll();
        assertTrue(roll1 != roll2);
    }

}

