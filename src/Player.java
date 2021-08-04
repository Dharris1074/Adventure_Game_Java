import java.util.Scanner;

class Player {
    
    public static int hp;
    public static int maxhp = 100;
    public static int level;
    public static int xp;
    public static int attack;
    public static int defence;
    public static int luck;
    public static String name;

    public Player()
    {
        hp = maxhp;
        level = 1;
        attack = 1;
        defence = 1;
        xp = 1;
        luck = 1;
        Scanner myName = new Scanner(System.in);
        System.out.println("Hey you, you're finally awake");
        System.out.println("Who are you?");

        

        String name = myName.nextLine();
        System.out.println("You're name is " + name);
        myName.close();
    }
}
