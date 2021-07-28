/** This class will demonstrate  the parseing of commands such as 
 * "pickup map"
 * Comamnds will first be verified, then accepted. 
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

    public String getCommandWord() {
        return commandWord;
    }

    public String getSecondWord() {
        return secondWord;
    }

    public boolean isUnknown() {
        return (commandWord == null);
    }

    public boolean hasSecondWord() {
        return (secondWord != null);
    }
}