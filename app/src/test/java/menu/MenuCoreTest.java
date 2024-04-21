package menu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MenuCoreTest {
    public static MenuCore menu = MainMenu.getInstance(); 
    
    @Test
    public void menuControlerTest() {
        menu.setPointerPosition(0);
        assertEquals(false, menu.menuControler('j'));
        assertEquals(1, menu.getPointerPosition());
        menu.setPointerPosition(1);
        assertEquals(false, menu.menuControler('k'));
        assertEquals(0, menu.getPointerPosition());
        menu.setPointerPosition(1);
        assertEquals(true, menu.menuControler('\n'));
        assertEquals(1, menu.getPointerPosition());
        menu.setPointerPosition(2);
        assertEquals(false, menu.menuControler('w'));
        assertEquals(2, menu.getPointerPosition());
    } 
}