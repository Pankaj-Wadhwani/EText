package operator.readoperator;
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

public class Reader {
    private static final String API_DEV_KEY = "2667ed2bd4a9549eb25bac7eae6aea7e"; // your api_developer_key
    //    private static String api_paste_code = ""; // your paste text
//    private static final String api_paste_private = "0"; // 0=public 1=unlisted 2=private
    //    private static String api_paste_name = ""; // name or title of your paste
//    private static final String api_paste_expire_date = "10M";
    //    private static final String api_paste_format = "php";
    private static final String API_USER_KEY = "787c84251cf7b08378d22c547e838bf4"; // if an invalid or expired API_USER_KEY is used, an error will spawn. If no API_USER_KEY is used, a guest paste will be created


//    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.163 Safari/537.36";


    private static final String READ_URL = "https://pastebin.com/api/api_raw.php";
    private static final String API_READ_OPTION = "show_paste";


    public static String read(String pasteTitle) {
        try {
            String pasteKey = APIHelper.getPasteKey(pasteTitle);
//            System.out.println(pasteKey);
            String postParams = "api_option=" + API_READ_OPTION + "&api_user_key=" + API_USER_KEY + "&api_dev_key=" + API_DEV_KEY + "&api_paste_key=" + pasteKey + "";
            return ConnectionHelper.sendPOST(READ_URL, postParams);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return "";
    }
}