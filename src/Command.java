/** This class will demonstrate  the parsing of commands such as 
 * "pickup map"
 *  Commands will first be verified, then accepted. 
*/

class Command
{
    private String commandWord;
    private String secondWord;

/** Returns a command object and splits it. Either word cn be null. 
*/

    public Command(String firstWord, String secondWord) {
        commandWord = firstWord;
        this.secondWord = secondWord;
    }

/** Return first word, if not understood it returns null */
    public String getCommandWord() {
        return commandWord;
    }

/** Return second word, if not understood it returns null */
    public String getSecondWord() {
        return secondWord;
    }

/** Return true if command not understood */
    public boolean isUnknown() {
        return (commandWord == null);
    }
    
/** Return true if command has second word */
    public boolean hasSecondWord() {
        return (secondWord != null);
    }
}