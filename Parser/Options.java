package Parser;
import Helpers.*;
public class Options{
    //defining the Rules
    private final ArrayList<String> optionName = new ArrayList<>();
    public Command(){
        optionName.add(Constants.CLIPBOARD[0]);
        optionName.add(Constants.CLIPBOARD[1]);
        optionName.add(Constants.HELP[0]);
        optionName.add(Constants.HELP[1]);
        optionName.add(Constants.FILE[0]);
        optionName.add(Constants.FILE[1]);
    }
    public boolean containsOption(String option){
        return optionName.contains(option);
    }

    public ArrayList<String> getOptionName() {
        return optionName;
    }

}