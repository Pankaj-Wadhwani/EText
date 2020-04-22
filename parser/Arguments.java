package parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Arguments{
    //defining the Rules
    static final String RULE1= ".+";//matches with shrib uri name
    static final String RULE2 = ".+(\\.txt)$";//matches with filename .txt

    public static boolean isValidRule(String text,String whichRule){
        Pattern p = null;
        p = Pattern.compile(whichRule);
        Matcher m = p.matcher(text);
        return m.find();

    }
}