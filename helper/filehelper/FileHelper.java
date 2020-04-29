package helper.filehelper;
import java.io.*;
public class FileHelper{
    public static String getContent(String filename){
        StringBuilder content = new StringBuilder();
        try{
            String temp;
            BufferedReader br = new BufferedReader(new FileReader(filename));
            while((temp = br.readLine()) !=null){
                content.append(temp);
                content.append("\n");
            }
            br.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return content.toString();
    }
    public static boolean putContent(String filename, String content) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
            bw.write(content);
            bw.close();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}