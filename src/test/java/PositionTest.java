
import com.example.simonsjavafxgame.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionTest {
    @Test
    void testConstructor() {
        // Test the default constructor
        Position position1 = new Position();
        assertEquals(0, position1.row);
        assertEquals(0, position1.column);

        // Test the other constructor
        Position position2 = new Position(2, 3);
        assertEquals(2, position2.row);
        assertEquals(3, position2.column);
    }

    @Test
    void testGettersAndSetters() {
        Position position = new Position();

        position.setRow(2);
        assertEquals(2, position.getRow());

        position.setColumn(3);
        assertEquals(3, position.getColumn());
    }
}

