import com.example.simonsjavafxgame.Fire;
import com.example.simonsjavafxgame.Obstacles;
import com.example.simonsjavafxgame.Pit;
import com.example.simonsjavafxgame.Teleportation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ObstaclesTest {

    @Test
    public void fireTest() {
        Fire f = new Fire();
        assertTrue(f instanceof Fire);
        assertTrue(f instanceof Obstacles);
    }

    @Test
    public void pitTest() {
        Pit f = new Pit();
        assertTrue(f instanceof Pit);
        assertTrue(f instanceof Obstacles);
    }

    @Test
    public void TeleportersTest() {
        Teleportation f = new Teleportation();
        assertTrue(f instanceof Teleportation);
        assertTrue(f instanceof Obstacles);
    }
}
