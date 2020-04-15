
package Parser;
import java.util.*;
import Parser.*;
import Helpers.*;
class ParseEText{

    private final List<String> readRule = new ArrayList<>();
    private final List<String> writeRule = new ArrayList<>();
    private final List<String> appendRule = new ArrayList<>();
    private final List<String> optionClipboardRule = new ArrayList<>();
    private final List<String> optionFileRule = new ArrayList<>();
    private final List<String> optionHelpRule = new ArrayList<>();

    private final Map<Integer,List<String>> read = new HashMap<>();
    private final Map<Integer,List<String>> write = new HashMap<>();
    private final Map<Integer,List<String>> append = new HashMap<>();
    private final Map<Integer,List<String>> optionClipboard = new HashMap<>();
    private final Map<Integer,List<String>> optionFile = new HashMap<>();
    private final Map<Integer,List<String>> optionHelp= new HashMap<>();

    private final Map<String,Map<Integer,List<String>>> commandInfoWithRules = new HashMap<>();

    private void addingRule(Map<String,Map<Integer,List<String>>> commandInfoWithRules, Map<Integer,List<String>> rulesCount, String cmdOrOption,List<String> rules,int noOfArgs){
        rulesCount.put(noOfArgs,rules);
        commandInfoWithRules.put(cmdOrOption,rulesCount);
        System.out.println(commandInfoWithRules.get(cmdOrOption));
    }
    private void addingRules(){
        readRule.add(Arguments.RULE1);
        addingRule(commandInfoWithRules,read,Constants.READ,readRule,1);

        writeRule.add(Arguments.RULE1);
        addingRule(commandInfoWithRules,write,Constants.WRITE,writeRule,1);

        appendRule.add(Arguments.RULE1);
        addingRule(commandInfoWithRules,append,Constants.APPEND,appendRule,1);

        addingRule(commandInfoWithRules,optionClipboard,Constants.CLIPBOARD[0],optionClipboardRule,0);
        addingRule(commandInfoWithRules,optionHelp,Constants.HELP[0],optionHelpRule,0);

//        optionFileRule.add(Arguments.RULE1);
        optionFileRule.add(Arguments.RULE2);
        addingRule(commandInfoWithRules,optionFile,Constants.FILE[0],optionFileRule,1);
    }
    private List<String> addingCommandToList(String[] args){
        List<String> commandWords=new ArrayList<>();
        for(int i=0;i<args.length;i++)
            commandWords.add(args[0]);
        return commandWords;
    }
    public void checkingRules(String[] args){
        addingRules();
        List<String > command = addingCommandToList(args);
//        if(command.get(1).charAt("-")=="-"){
//            System.out.println("true");
//        }
//        else{
//            System.out.println("Your command wrong");
//        }
        System.out.println(command.get(1));
    }

    public static void main(String[] args) {
        new ParseEText().checkingRules(args);
//        new ParseEText().addingRules();

    }
}