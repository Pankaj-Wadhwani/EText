
package parser;
import java.util.*;
import parser.*;
import helper.*;
class ParseEText{

    private static final List<String> readRule = new ArrayList<>();
    private static final List<String> writeRule = new ArrayList<>();
    private static final List<String> appendRule = new ArrayList<>();
    private static final List<String> optionClipboardRule = new ArrayList<>();
    private static final List<String> optionFileRule = new ArrayList<>();
    private static final List<String> optionHelpRule = new ArrayList<>();

    private static final Map<Integer,List<String>> read = new HashMap<>();
    private static final Map<Integer,List<String>> write = new HashMap<>();
    private static final Map<Integer,List<String>> append = new HashMap<>();
    private static final Map<Integer,List<String>> optionClipboard = new HashMap<>();
    private static final Map<Integer,List<String>> optionFile = new HashMap<>();
    private static final Map<Integer,List<String>> optionHelp= new HashMap<>();

    private static final Map<String,Map<Integer,List<String>>> commandInfoWithRules = new HashMap<>();

    private Command cmd = new Command();
    private Options opt = new Options();
    private Map<String,String> cmdArgs = new HashMap<>();

    public Map<String,String> getCmdArgs(){
        return cmdArgs;
    }
    private void addingRule(Map<String,Map<Integer,List<String>>> commandInfoWithRules, Map<Integer,List<String>> rulesCount, String cmdOrOption,       List<String> rules,int noOfArgs){
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
            commandWords.add(args[i]);
        return commandWords;
    }
    private String getShortOption(String option){
        if(option.equals("--clipboard"))
            return "-c";
        else if(option.equals("--FILE"))
            return "-f";
        else if(option.equals("--help"))
            return "-h";
        return option;
    }
    private void checkArg(int i,List<String> commandList){
        for(Map.Entry<Integer,List<String>> argCount : commandInfoWithRules.get(commandList.get(i)).entrySet()) {
            for (int j = i; j < (argCount.getKey() + i); j++)
                if (Arguments.isValidRule(commandList.get(j + 1), argCount.getValue().get(0))) {
                    cmdArgs.put(Constants.FILE[0], commandList.get(j + 1));
                    commandList.remove(i);
                    commandList.remove(i);
                } else {
                    System.out.println("U missed some argument... Try HELP command... etext -h");
                    flag = false;
                    isError=true;
                    break;
                }
        }
    }
    boolean flag=true;
    boolean isError = false;
    public void checkingRules(String[] args){
        addingRules();
        List<String> commandList = addingCommandToList(args);
        try{
            if(commandList.size()>2){
                for(int i=1;i>=0;i--){
                    if((commandList.get(i).equals(Constants.FILE[0]) ||commandList.get(i).equals(Constants.FILE[1]))&& commandInfoWithRules.containsKey(getShortOption(commandList.get(i)))){
                        checkArg(i,commandList);
                    }
                    else if(i==1 &&(commandList.get(i).equals(Constants.CLIPBOARD[0]) ||commandList.get(i).equals(Constants.CLIPBOARD[1])) && commandInfoWithRules.containsKey(getShortOption(commandList.get(i)))){
                        cmdArgs.put(Constants.CLIPBOARD[0],null);
                        commandList.remove(i);
                    }
                    else if((commandList.get(i).equals(Constants.HELP[0]) ||commandList.get(i).equals(Constants.HELP[1])) && commandInfoWithRules.containsKey(getShortOption(commandList.get(i)))){
                        cmdArgs.put(Constants.HELP[0],null);
                        commandList.remove(i);
                    }
                    if(flag==false){
                        break;
                    }
                }
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("NO command found");
            isError=true;
            cmdArgs.clear();
        }catch(Exception e){
            isError=true;
            System.out.println("no command found");
        }
        if(flag &&commandList.size()==2 ) {
            if(commandList.get(0).equals(Constants.READ)){
                checkArgForcmd(Constants.READ,commandList);
            }
            else if(commandList.get(0).equals(Constants.APPEND)){
                checkArgForcmd(Constants.APPEND,commandList);
            }
            else if(commandList.get(0).equals(Constants.WRITE)) {
                checkArgForcmd(Constants.WRITE,commandList);
            }
            else{
                System.out.println("your command 😢 is wrong");
            }
        }
        if(commandList.size()>0 && !isError){
            System.out.println("U missed some argument... Try HELP command... etext -h");
            cmdArgs.clear();
        }
        System.out.println(cmdArgs);



    }

    private void checkArgForcmd(String command,List<String> commandList){
        for (Map.Entry<Integer, List<String>> argCount : commandInfoWithRules.get(commandList.get(0)).entrySet()) {
            for (int j = 0; j < argCount.getKey(); j++)
                if (Arguments.isValidRule(commandList.get(j + 1), argCount.getValue().get(j))) {
                    cmdArgs.put(command, commandList.get(j + 1));
                    commandList.remove(0);
                    commandList.remove(0);
                } else {
                    System.out.println("U missed some argument... Try HELP command... etext -h");
                    flag = false;
                    isError=true;
                    break;
                }
        }
    }
    public static void main(String[] args) {
        new ParseEText().checkingRules(args);
//        new ParseEText().addingRules();

    }
}

