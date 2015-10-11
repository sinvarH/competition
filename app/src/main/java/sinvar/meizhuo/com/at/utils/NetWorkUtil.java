package sinvar.meizhuo.com.at.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import sinvar.meizhuo.com.at.MyApp;

/**
 * Created by sinvar on 2015/9/29.
 */
public class NetWorkUtil {
    private static Context context ;

    /**
     * 判断是否连接wifi
     * @return
     */
    public static boolean isWifiConnected()
    {
        context = MyApp.getContext() ;
        ConnectivityManager connectivityManager = (ConnectivityManager)context
                .getSystemService(Context.CONNECTIVITY_SERVICE) ;
        NetworkInfo mWifi = connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        if (mWifi.isConnected())
        {
            return true ;
        }else
        {
            return false;
        }
    }

    /**
     * 因地制宜的网络请求，接口写的太恶心
     * 获取anime
     * @return
     */
}
