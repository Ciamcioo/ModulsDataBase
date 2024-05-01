package menu;

public final class MainMenu extends MenuCore {
    private static MainMenu instance = null;
    private boolean isUp = true;

    public static MainMenu getInstance() {
        if (instance == null) 
            instance = new MainMenu();
        return instance;
    }

    private MainMenu() {
        super(MenuConsts.MAIN_MENU_LIMIT);
    }

    // Menu can be wrote based on separete therad 
    public void menuRunner() {
        do {
            printMenu();
            char input = takeUserInput();
            boolean action = menuControler(input);
            if (action)
                proccessAction();
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

    protected void proccessAction() {
        switch(getPointerPosition()) {
            case MenuConsts.FETCH_MODUL_DATA-> console.writer().print("Fetch module data\n");
            case MenuConsts.LOAD_MODULE-> console.writer().print("Load module\n"); 
            case MenuConsts.UPDATE_MODULE -> console.writer().print("Update module\n");
            case MenuConsts.DELETE_MODULE -> console.writer().print("Delete module\n");
            case MenuConsts.EXIT -> isUp = false; 
        }
        showConsoleCurrsor(); 
        console.writer().print("Press Enter to continue...\n");
        console.flush();
        proccessInputWithExceptionHandling();
        clearConsole();
        console.flush();
        
        setPointerPosition(MenuConsts.DEFAULT_POINTER_POSITION);
    } 
}
