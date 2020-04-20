import java.awt.datatransfer.*;
import java.awt.*;
import java.io.*;
public class ClipboardHelper{
    public String getClipboardContents(){
        try{
            System.setErr(new PrintStream("error.log"));
            Clipboard c=Toolkit.getDefaultToolkit().getSystemClipboard();
            return c.getData(DataFlavor.stringFlavor).toString();
        }
        catch(Exception ex){
            ex.printStackTrace();
            return null;
        }

    }
    public boolean putContents(String text){
       try{
             Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
             Transferable transferable = new StringSelection(text);
             clipboard.setContents(transferable,null);
             return true;
       }
       catch(Exception ex){
            ex.printStackTrace();
            return false;
       }
    }
}