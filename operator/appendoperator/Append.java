package operator.appendoperator;
import operator.readoperator.*;
import operator.writeoperator.*;
import helper.connectionhelper.*;
import helper.apihelper.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Append {
    public static void append(String pasteTitle,String text) {

            String pasteKey = APIHelper.getPasteKey(pasteTitle);
            String oldText = Reader.read(pasteTitle);
            APIHelper.deletePaste(pasteKey);
            Writer.write(pasteTitle,oldText+"\n"+text);


    }
}