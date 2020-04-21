package Parser;
import java.util.*;
import Helpers.*;
class Redirect{
    public static void main(String[] args) {
        ParseEText parse = new ParseEText();
        parse.checkingRules(args);//checking command rule and if all perfect then it will add the command data pair to HAShMAP
        Map<String,String> cmdArg = parse.getCmdArgs();
//        String key="",value="";
//        System.out.println(cmdArg);
        if(cmdArg.containsKey(Constants.READ)){
            System.out.println("read("+cmdArg.get(Constants.READ)+")");
            for(Map.Entry<String,String> separatedOptionCommand : cmdArg.entrySet()) {
                if(separatedOptionCommand.getKey().equals("-f"))
                    System.out.println("file("+separatedOptionCommand.getValue()+")");
                if(separatedOptionCommand.getKey().equals("-c"))
                    System.out.println("Clipboard("+separatedOptionCommand.getValue()+",textwhichisreturn"+")");
                else
                    System.out.println("Clipboard("+separatedOptionCommand.getValue()+",textwhichisreturn"+")");
            }
        }
        else if(cmdArg.containsKey(Constants.WRITE)){
            System.out.println("write("+cmdArg.get(Constants.WRITE)+")");
            for(Map.Entry<String,String> separatedOptionCommand : cmdArg.entrySet()) {
                System.out.println("read method :"+separatedOptionCommand.getKey()+":"+separatedOptionCommand.getValue());
            }
        }
        else if(cmdArg.containsKey(Constants.APPEND)){
            System.out.println("append("+cmdArg.get(Constants.APPEND)+")");
            for(Map.Entry<String,String> separatedOptionCommand : cmdArg.entrySet()) {
                System.out.println("read method :"+separatedOptionCommand.getKey()+":"+separatedOptionCommand.getValue());
            }
        }

    }
}