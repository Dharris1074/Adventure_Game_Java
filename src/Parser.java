import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 
 * This class reads input and tries to interpret it as a command.
 * It is invoked and reads a line from the terminal and returns the command as 
 * an object of class Command.
 * It has a set group of known command words. Input is checked against this storage
 * and if it isn't one of the known commands, it returns the Command object unknown command. 
*/

public class Parser {
    
    /** Holds all command words */
    private CommandWords commands;

/** 
 * Create new Parser
*/
    public Parser() {
        commands = new CommandWords();
    }


/** 
 * Get new command from input terminal
 */
    public Command getCommand() {
        String inputLine = ""; // full input line
        String word1;
        String word2;
        
        System.out.print("> "); // terminal prompt

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            inputLine = reader.readLine();
        }
        catch(java.io.IOException exc) {
            System.out.println("There was an error during reading: " + exc.getMessage());
        }

        StringTokenizer tokenizer = new StringTokenizer(inputLine);

        if(tokenizer.hasMoreTokens())
            word1 = tokenizer.nextToken();  // Get first word
        else
            word1 = null;
        if(tokenizer.hasMoreTokens())
            word2 = tokenizer.nextToken();  // Get second word
        else    
            word2 = null;

/**
 * Check whether word is known, if it is - create command with it. If not, create null.
 */
        if(commands.isCommand(word1))
            return new Command(word1, word2);
        else
            return new Command(null, word2);
    }
/**
 * Prints out a list of all valid commands.
 */
    public void showCommands() {
        commands.showAll();
    }
}
