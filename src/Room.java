
import java.util.Hashtable;
import java.util.Enumeration;

/**
Room represents a location that the player is currently in, setting the
scene for the game. It is connected to other rooms via north, south, east
as west, with two available actions.
*/

class Room
{
  private String description;
  private Hashtable exits;
  // private Hashtable actions;

/**
This creates a room described "description".
*/
  public Room(String description)
  {
    this.description = description;
    exits = new Hashtable();
    // actions = new Hashtable();
}

/**
Defines exits of the room, each direction leading to a neighbouring room.
*/
public void setExits(Room north, Room east, Room south, Room west)
{
    if(north != null)
      exits.put("north", north);
    if(east != null)
      exits.put("east", east);
    if(west != null)
      exits.put("west", west);
    if(south != null)
      exits.put("south", south);
}

/**
Describes the actions possible within the room. This is also dependant
on if a room contains an object.
*/
// public void setActions(Room search, Room pickup)
// {
//   if(search != null)
//     actions.put("search", search);
//   if(pickup != null)
//     actions.put("pickup", pickup);
// }

/**
Return short description of the room already defined in constructor.
*/
public String shortDescription()
{
  return description;
}

/**
Return long description for the room.
*/
public String longDescription()
{
  return "You are in " + description + ".\n" + exitString() + ".\n"; 
  // + "actions available are: " + actionString();
}

/**
Return string describing room's exits.
*/
private String exitString()
{
  String returnString = "Exits:";
  Enumeration keys = exits.keys();
  while(keys.hasMoreElements())
    returnString += " " + keys.nextElement();
  return returnString;
}

/**
Return string describing room's actions.
*/
// private String actionString()
// {
//   String returnActionString = "Actions:";
//   Enumeration keysAction = actions.keys();
//   while(keysAction.hasMoreElements())
//     returnActionString += " " + keysAction.nextElement();
//   return returnActionString;
// }

/**
Return to room that is reached if we go to direction. If there is no direction,
return null.
*/
public Room nextRoom(String direction)
{
  return (Room)exits.get(direction);
}

/**
Return action that is defined. If not action, return null.
*/
// public Room nextAction(String actionChoice)
// {
//   return(Room)actions.get(actionChoice);
// }
}
