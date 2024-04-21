import menu.MainMenu;

public class App {
    private MainMenu menu = null;
    
    public App() {
        menu = MainMenu.getInstance();
    }
    public static void main(String[] args) {
        App application = new App();
        application.menu.menuRunner();
    }

    public static void applicationExit() {
        System.exit(0);
    }

/* GETTERS AND SETTERS  */
    public void setMenu(MainMenu menu) {
        this.menu = menu;
    }
    
    public MainMenu getMenu() {
        return this.menu;
    }
}
