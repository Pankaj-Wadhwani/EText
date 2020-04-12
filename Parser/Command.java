package Parser;
import  java.util.*;
import Parser.*;
public class Command{
    private final ArrayList<String> commandName = new ArrayList<>();
    public Command(){
        commandName.add(Constants.READ);
        commandName.add(Constants.WRITE);
        commandName.add(Constants.CLIPBOARD);
        commandName.add(Constants.APPEND);
        commandName.add(Constants.FILE);
    }
    public boolean containsCommand(String command){
         return commandName.contains(command);
    }

    public ArrayList<String> getCommandName() {
        return commandName;
    }
}