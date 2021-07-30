/** 
 * This class holds the command words in the game. 
 */

public class CommandWords {
    private static final String validCommands[] = {""
        "go", "quit", "help"
    };
/**
 * Constructor
 */
    public CommandWords() {

    }
/** 
 * Check if String is a valid command word. True if it is, false 
 * if it isn't.
*/
    public boolean isCommand(String aString) {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
            return true;
        } return false;
    }
/** 
 * Print all valid commands
*/

    public void showAll() {
        for(int i = 0; i < validCommands.length; i++) {
            System.out.print(validCommands[i] + "  ");
        } System.out.println();
    }
}

