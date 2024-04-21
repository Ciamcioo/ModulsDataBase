package menu;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MainMenuTest {
    static MainMenu menu = MainMenu.getInstance();

    @Test
    public void mainMenuIsNotNull() {
        assertNotNull(MainMenu.getInstance());
    }

    @Test
    public void getInstanceReturnsMenuVariable() {
        assertEquals(menu, MainMenu.getInstance());
    }
}
