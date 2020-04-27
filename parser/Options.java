package parser;
import helper.*;
import java.util.*;
public class Options{
    //defining the Rules
    private static  final ArrayList<String> optionName = new ArrayList<>();
    public Options(){
        optionName.add(Constants.CLIPBOARD[0]);
        optionName.add(Constants.CLIPBOARD[1]);
        optionName.add(Constants.HELP[0]);
        optionName.add(Constants.HELP[1]);
        optionName.add(Constants.FILE[0]);
        optionName.add(Constants.FILE[1]);
    }
    public static boolean containsOption(String option){
        return optionName.contains(option);
    }

    public ArrayList<String> getOptionName() {
        return optionName;
    }

}