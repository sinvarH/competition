package sinvar.meizhuo.com.at.utils;

import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sinvar.meizhuo.com.at.MyApp;

/**
 * Created by sinvar on 2015/9/30.
 */
public class CommonUtil {

    public static void shortToast(String context)
    {
        Toast.makeText(MyApp.getContext(), context, Toast.LENGTH_SHORT).show();
    }

    /**
     * uncicode解码
     * @param unicode
     * @return
     */

    static final Pattern reUnicode = Pattern.compile("\\\\u([0-9a-zA-Z]{4})");

    public static String getFromUnicode(String s) {
        Matcher m = reUnicode.matcher(s);
        StringBuffer sb = new StringBuffer(s.length());
        while (m.find()) {
            m.appendReplacement(sb,
                    Character.toString((char) Integer.parseInt(m.group(1), 16)));
        }
        m.appendTail(sb);
        return sb.toString().replace("\\r\\n\\r\\n","").replace("\\r\\n \\r\\n","");
    }
}
