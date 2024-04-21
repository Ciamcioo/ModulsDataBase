package menu;

public final class MainMenu extends MenuCore {
    private static MainMenu instance = null;
    private boolean isUp = true;

    private MainMenu() {
        super(MenuConsts.MAIN_MENU_LIMIT);
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
        for (int i = 0; i < MenuConsts.MAIN_MENU_OPTIONS.length; i++) {
            if (i == pointerPosition)
                console.writer().print(">");
            else 
                console.writer().print(" ");
            console.writer().print(MenuConsts.MAIN_MENU_OPTIONS[i]);  
            console.flush();
        }
    }

    public static MainMenu getInstance() {
        if (instance == null) 
            instance = new MainMenu();
        return instance;
    }
}
