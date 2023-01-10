
import com.example.simonsjavafxgame.Player;
import com.example.simonsjavafxgame.Position;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testConstructor() {
        // Test the default constructor
        Player player1 = new Player();
        assertNull(player1.name);
        assertNull(player1.currentPosition);
        assertNull(player1.initialPosition);
        assertNull(player1.icon);
        assertFalse(player1.missTurn);

        // Test the other constructor
        Player player2 = new Player("Grishma", Color.BLUE);
        assertEquals("Grishma", player2.name);
        assertNotNull(player2.currentPosition);
        assertNotNull(player2.initialPosition);
        assertNotNull(player2.icon);
        assertFalse(player2.missTurn);
    }

    @Test
    void testSetInitialPosition() {
        Player player = new Player();
        Position position = new Position(1, 2);
        player.setInitialPosition(position);
        assertEquals(position, player.initialPosition);
    }
}
