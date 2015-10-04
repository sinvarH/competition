package sinvar.meizhuo.com.at.gsonvolleyandokhttp;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.squareup.okhttp.OkHttpClient;

import java.util.Map;

import sinvar.meizhuo.com.at.MyApp;
import sinvar.meizhuo.com.at.utils.Constant;

/**queue类
 * 讲volley和okhttp封装
 * Created by sinvar on 2015/9/11.
 */
public class VolleySingleQueue {
    private static final String SET_COOKIE_KEY = "Set-Cookie";
    private static final String COOKIE_KEY = "Cookie";
    private static final String SESSION_COOKIE = "JSESSIONID";
    private SharedPreferences sharedPreferences ;

    private RequestQueue mRequestQueue;

    private static VolleySingleQueue instance = new VolleySingleQueue() ;
    private VolleySingleQueue (){}

    /**
     * 实现单例模式
     * @return
     */
    public static VolleySingleQueue getInstance()
    {
        return instance ;
    }


    /**
     * 返回一个uohevolley的requestqueue
     * @return
     */
    public RequestQueue getVolleyRequestQueue()
    {
        if(mRequestQueue == null)
        {
            mRequestQueue = Volley.newRequestQueue(MyApp.getContext(), new OkHttpStack(new OkHttpClient())) ;
        }
        return  mRequestQueue ;
    }


    /**
     * 添加request到volleyqueue
     */
    public static void addRequest(Request<?> request ,String tag)
    {
        request.setTag(tag) ;
        addRequest(request);
    }
    public static void addRequest(Request<?> request)
    {
        getInstance().getVolleyRequestQueue().add(request) ;
    }


    /**
     * 取消请求
     */
    public static void cancelAllRequests(String tag)
    {
        if (getInstance().getVolleyRequestQueue()!= null)
        {
            getInstance().getVolleyRequestQueue().cancelAll(tag);
        }
    }


    /**
     * 检查http请求的响应头，如果有SET-COOKIE标志，那么就获取并保存
     * 以便下次请求使用保持状态
     * @param header
     */
    public final  void checkSessionCookie(Map<String, String> header) {
        if (header.containsKey(SET_COOKIE_KEY) && header.get(SET_COOKIE_KEY).startsWith(SESSION_COOKIE)) {
            String cookie = header.get(SET_COOKIE_KEY);
            if (cookie.length() > 0) {
                String[] splitCookie = cookie.split(";");
                String[] splitSessionId = splitCookie[0].split("=");
                cookie = splitSessionId[1];
                sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MyApp.getContext()) ;
                sharedPreferences.edit().putString(SESSION_COOKIE, cookie).commit();
                Constant.isHaveCookie = true;
            }
        }
    }
    /**
     * 如果header中有cookie这个，那么就添加sessionID到cookie中
     * @param header
     */
    public final void addSessionCookie(Map<String, String> header,boolean isHaveSessionCookie) {
        if (isHaveSessionCookie) {
            //这里要对是否存在seesioncookie是否存在，否这句语句会抛出空指针异常
            String sessionId = sharedPreferences.getString(SESSION_COOKIE, "");
            Log.e("sessionid", sessionId);
            if (sessionId.length() > 0) {
                StringBuilder sb = new StringBuilder();
                // 添加sessionId="sessionID"
                sb.append(SESSION_COOKIE).append("=").append(sessionId);
                if (header.containsKey(COOKIE_KEY)) {
                    // 如果cookie里面有其他的内容，那么把其他的内容加进来，避免覆盖信息丢失
                    sb.append(";");
                    sb.append(header.get(COOKIE_KEY));
                }
                header.put(COOKIE_KEY, sb.toString());
            }
        }
    }
}
