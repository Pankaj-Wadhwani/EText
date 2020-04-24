package parser;
import operator.readoperator.*;
import operator.writeoperator.*;
import operator.appendoperator.*;
import helper.clipboardhelper;
import helper.fileboardhelper;
import java.util.*;
import helper.*;
class Redirect{
    private static String getContent(boolean workOnFile,boolean workOnClipboard,String fileName){
        String content = "";
        if(workOnClipboard){
            content=ClipboardHelper.getClipboardContents();
        }
        if (workOnFile){
            content=FileHelper.getContent(fileName);
        }
        return content;

    }
    private static boolean putContent(boolean workOnFile,boolean workOnClipboard,String fileName,String content){
        boolean wrote=false;
        if(workOnFile)
             wrote = FileHelper.putContent(fileName,content);
        if(workOnClipboard)
             wrote = ClipboardHelper.putContents(content);
        return wrote;
    }
    private static void performOperation(Map<String,String> hashMap){
        //checking for options
        if(cmdArg.containsKey(Constants.FILE[0]) || cmdArg.containsKey(Constants.FILE[1])) {
            workOnFile = true;
            fileName = cmdArg.get(Constants.FILE[0]);

        }
        if(cmdArg.containsKey(Constants.CLIPBOARD[0]) || cmdArg.containsKey(Constants.CLIPBOARD[1]))
            workOnClipboard=true;
//        if(cmdArg.containsKey(Constants.HELP[0]) || cmdArg.containsKey(Constants.HELP[1]))
//            System.out.println("help("+separatedOptionCommand.getValue()+",textwhichisreturn"+")");
        if(!workOnFile && !workOnClipboard)
            workOnClipboard=true;

        //checking for commands
        if(cmdArg.containsKey(Constants.READ)){
//            System.out.println("read("+cmdArg.get(Constants.READ)+")");
            String content = Reader.read(cmdArg.get(Constants.READ));
            boolean wrote=putContent(workOnFile,workOnClipboard,fileName,content);

        }
        else if(cmdArg.containsKey(Constants.WRITE)){
            String content = getContent(workOnFile,workOnClipboard,fileName);
            Writer.write(cmdArg.get(Constants.WRITE),content);

        }
        else if(cmdArg.containsKey(Constants.APPEND)){
            String content = getContent(workOnFile,workOnClipboard,fileName);
            Append.append(cmdArg.get(Constants.APPEND),content);
        }

    }
    public static void main(String[] args) {
        ParseEText parse = new ParseEText();
        boolean workOnFile=false,workOnClipboard=false;
        String fileName = "";
        parse.checkingRules(args);//checking command rule and if all perfect then it will add the command data pair to HAShMAP
        performOperation(parse.getCmdArgs());
    }
}