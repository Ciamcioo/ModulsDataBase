package menu;
import java.util.ArrayList;
public final class MainMenu extends MenuCore {
    private static MainMenu instance = null;
    private static int MAIN_MENU_LIMIT = 2;
    private boolean isUp = true;
    private ArrayList<String> mainMenuOptions;

    private MainMenu() {
        super(MAIN_MENU_LIMIT);
        mainMenuOptions = intializeMenu();
    }

    // Menu can be wrote based on separete therad 
    public void menuRunner() {
        do {
            printMenu();
            char input = takeUserInput();
            menuControler(input);
        } while (isUp);
    }

    protected void printMenu() {
        for (int i = 0; i < mainMenuOptions.size(); i++) {
            if (i == pointerPosition)
                console.writer().print(">");
            else 
                console.writer().print(" ");
            console.writer().print(mainMenuOptions.get(i).toString());  
            console.flush();
        }
    }

    public static MainMenu getInstance() {
        if (instance == null) 
            instance = new MainMenu();
        return instance;
    }


    private ArrayList<String> intializeMenu() {
        ArrayList<String> menuOptions = new ArrayList<String>();
        menuOptions.add("1. Something\n");
        menuOptions.add("2. Something else\n");
        menuOptions.add("3. Exit\n");
        return menuOptions;
    }

    protected ArrayList<String> getMainMenuOptions() {
        return this.mainMenuOptions;
    }
}
