/** 
 * Main class of Adventure Game.
 * By creating an instance of this class, you can play the game.
 * This class creates and initialises all the others in the folder. It also 
 * creates the rooms, parser and starts the game. It also evaluate the 
 * commands that the parser returns.
*/

class Game 
{
    private Parser parser;
    private Room currentRoom;


    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    private void createRooms() 
    {
        Room outside, lab, tavern, study, armory;

        outside = new Room("Outside the strange mansion");
        lab = new Room("A lab, there are bodies everywhere");
        tavern = new Room("A Tavern, it still stinks of beer, but there's nobody here.");
        study = new Room("A smaller offshoot of the lab, there are books everywhere.");
        armory = new Room("An armory, there are weapons everywhere");

        outside.setExits(null, lab, study, tavern);
        lab.setExits(null, null, null, outside);
        tavern.setExits(null, outside, null, null);
        study.setExits(outside, tavern, null, null);
        armory.setExits(null, outside, null, null);

        currentRoom = outside;
    }
        public void play() 
        {
             
            printWelcome();
            
            boolean finished = false;
            while (! finished) 
            {
                Command command = parser.getCommand();
                finished = processCommand(command);
            }
            System.out.println("Thank you for playing. Good bye.");
        }

        private void printWelcome() 
        {
            System.out.println();
            System.out.println("Welcome to your adventure");
            System.out.println("Type help if you need anything");
            System.out.println();
            System.out.println("You awake in a strange room, your head hurst but you can roughly take in  your surroundings");
            System.out.println(currentRoom.longDescription());
        }

        private boolean processCommand(Command command) 
        {
            if(command.isUnknown()) 
            {
                System.out.println("You are dazed and confused, try again...");
                return false;
            }
            
            String commandWord = command.getCommandWord();
            if (commandWord.equals("help"))
                printHelp();
            else if (commandWord.equals("go"))
                goRoom(command);
            else if (commandWord.equals("quit"))
            {
                if(command.hasSecondWord())
                    System.out.println("Quit what?");
                else    return true;
            }
            return false;
        }

        private void printHelp()
        {
            System.out.println("You are lost, you are alone. You wander aimlessly");
            System.out.println("Your command words are:");
            parser.showCommands();
        }

        private void goRoom(Command command)
        {
            if(!command.hasSecondWord())
            {
                System.out.println("Go where(north, south..?");
                return;
            }

            String direction = command.getSecondWord();

            Room nextRoom = currentRoom.nextRoom(direction);

            if (nextRoom == null)
                System.out.println("There is no door!");
            else
            {
                currentRoom = nextRoom;
                System.out.println(currentRoom.longDescription());
            }
        }
    }