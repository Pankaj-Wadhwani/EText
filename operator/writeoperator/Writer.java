package operator.writeoperator;
import helper.connectionhelper.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Writer {
    private static final String API_DEV_KEY = "2667ed2bd4a9549eb25bac7eae6aea7e"; // your api_developer_key
//    private static String api_paste_code = ""; // your paste text
    private static final String API_PASTE_PRIVATE = "0"; // 0=public 1=unlisted 2=private
//    private static String api_paste_name = ""; // name or title of your paste
    private static final String API_PASTE_EXPIRE_DATE = "N";
//    private static final String api_paste_format = "php";
    private static final String API_USER_KEY = "787c84251cf7b08378d22c547e838bf4"; // if an invalid or expired API_USER_KEY is used, an error will spawn. If no API_USER_KEY is used, a guest paste will be created





    private static final String WRITE_URL = "https://pastebin.com/api/api_post.php";

    private static final String API_WRITE_OPTION ="paste";

    public static void write(String name, String content) {
        try {

            String apiPasteName = URLEncoder.encode(name, "UTF-8");
            String apiPasteCode = URLEncoder.encode(content, "UTF-8");
            String postParams = "api_option="+API_WRITE_OPTION+"&api_user_key=" + API_USER_KEY + "&api_paste_private=" + API_PASTE_PRIVATE + "&api_paste_name=" + apiPasteName + "&api_paste_expire_date=" + API_PASTE_EXPIRE_DATE + "&api_dev_key=" + API_DEV_KEY + "&api_paste_code=" + apiPasteCode + "";
            ConnectionHelper.sendPOST(WRITE_URL, postParams);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
