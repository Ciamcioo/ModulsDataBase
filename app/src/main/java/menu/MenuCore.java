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

    protected char takeUserInput() {
        char input = proccessInputWithExceptionHandling(); 
        console.writer().print("\033[H\033[2J"); 
        console.flush();
        return input; 
    }

    protected boolean menuControler(char input) {
        int tmpPointerPosition = pointerPosition;
        switch (input){
            case 'j' -> setpointerPosition(++tmpPointerPosition);
            case 'k' -> setpointerPosition(--tmpPointerPosition); 
            case '\n' -> { 
                setpointerPosition(0);
                return true; 
            }
        }
        return false;
    }

    protected boolean checkPointerLimis(int tmpPointerValue) {
        return tmpPointerValue <= pointierLimit || tmpPointerValue >= 0 ? true : false;
    }

    protected void setpointerPosition(int tmpPointer) {
        if (tmpPointer >= 0 && tmpPointer <= pointierLimit)
            pointerPosition = tmpPointer;
    }

    protected void setPointerLimit(int limit) {
        if(limit > 0)
            pointierLimit = limit;
    }

    protected char proccessInputWithExceptionHandling() {
        try {
            char input = console.readLine().charAt(0);
            return input;
        } catch(IndexOutOfBoundsException e) {
            return '\n';
        }
    }
}
