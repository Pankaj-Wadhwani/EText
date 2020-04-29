package helper;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Helper{
    public static String findUsingRegex(String text,String regex,String pasteTitle){
        // Create a Pattern object
        Pattern r = Pattern.compile(regex);

        // Now create matcher object.
        Matcher m = r.matcher(text);
        while (m.find()) {
            if(m.group(2).equals(pasteTitle))
                return m.group(1);


//            System.out.println("Found value: " + m.group(1) );
//            System.out.println("Found value: " + m.group(1) );
//            System.out.println("Found value: " + m.group(2) );
        }
//        System.out.println("No match");
        return "";
    }
}