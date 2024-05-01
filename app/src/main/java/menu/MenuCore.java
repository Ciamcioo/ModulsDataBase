package menu;
import java.io.Console;

public abstract class MenuCore implements MenuInterface {
    protected static Console console;
    protected int pointerPosition = 0, pointierLimit;

    protected MenuCore(int pointerLimit) {
        console = getConosle();
        setPointerLimit(pointerLimit);
    }
    
    private Console getConosle() {
        Console console = System.console();
        if (console == null) 
            System.err.println("No cosnole.");
        return console;
    }

    protected abstract void printMenu(); 
    protected abstract void proccessAction();

    /**
     *  Method takes value returned by the proccess of handling user input before hiding the currssor and then poping it back. 
     * @return - character that was returned by the proccess method
     */
    protected char takeUserInput() {
        hideConsoleCurrsor();
        char input = proccessInputWithExceptionHandling(); 
        showConsoleCurrsor();
        clearConsole();
        return input; 
    }

    /**
     * Menu contoler checks user input and based on that calculate pointerPosition. 
     * @param input - character which was passed by the user
     * @return - returns true when the input was '\n' which indicates taking action, false is there is no need to take action
     */
    protected boolean menuControler(char input) {
        int tmpPointerPosition = pointerPosition;
        switch (input){
            case 'j' -> setPointerPosition(++tmpPointerPosition);
            case 'k' -> setPointerPosition(--tmpPointerPosition); 
            case '\n' -> { return true; } 

        }
        return false;
    }

    /**
     * Method proccess the user input from consol if it exists. In case of expection end line character is returned
     * @return - character based on the proccesses in method
     */
    protected char proccessInputWithExceptionHandling() {
        try {
            char[] inputArray  = console.readPassword();
            char input = inputArray.length > 0 ? inputArray[0] : '\n'; 
            return input;
        } catch(IndexOutOfBoundsException e) {
            return '\n';
        }
    }

    private void hideConsoleCurrsor() {
        console.writer().print("\033[?25l");
        console.flush();
    }

    protected void showConsoleCurrsor() {
        console.writer().print("\033[?25h");
        console.flush();
    }
    
    protected void clearConsole() {
        console.writer().print("\033[H\033[2J");
        console.flush();
    }

    protected int getPointerPosition() {
        return pointerPosition;
    }

    /**
     * Setter for pointerPosition. If the if statment is true the pointer is set, if not the pointer remains the same
     * @param tmpPointer - value of pointer to be set
     */
    protected void setPointerPosition(int tmpPointer) {
        if (tmpPointer >= 0 && tmpPointer <= pointierLimit)
            pointerPosition = tmpPointer;
    }


    /**
     * Method sets the limit of pointer if it is greater than zero.
     * @param limit - limit of the pointer
     */
    protected void setPointerLimit(int limit) {
        if(limit > 0)
            pointierLimit = limit;
    }
}

