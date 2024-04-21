package menu;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void testInitalizationOfMainMenuContent() {
       ArrayList<String> menuOptions = new ArrayList<>(List.of("1. Something\n", "2. Something else\n", "3. Exit\n"));
        assertEquals(menuOptions.get(0), menu.getMainMenuOptions().get(0));
        assertEquals(menuOptions.get(1), menu.getMainMenuOptions().get(1));
        assertEquals(menuOptions.get(2), menu.getMainMenuOptions().get(2));

    }
}
