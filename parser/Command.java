package parser;
import  java.util.*;
import helper.*;
public class Command{
    private final ArrayList<String> commandName = new ArrayList<>();
    public Command(){
        commandName.add(Constants.READ);
        commandName.add(Constants.WRITE);
        commandName.add(Constants.APPEND);
    }
    public boolean containsCommand(String command){
         return commandName.contains(command);
    }

    public ArrayList<String> getCommandName() {
        return commandName;
    }
}