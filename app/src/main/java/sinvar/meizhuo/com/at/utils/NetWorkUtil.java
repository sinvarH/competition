package sinvar.meizhuo.com.at.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import sinvar.meizhuo.com.at.MyApp;
import sinvar.meizhuo.com.at.entity.ViedoAnimeInfo;
import sinvar.meizhuo.com.at.gsonvolleyandokhttp.VolleySingleQueue;

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
    public static void  Gsonrequest()
    {

        JsonObjectRequest jsonObjectRequest  = new JsonObjectRequest(ApiAdress.getInitData(20, 5, 2), null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {

                    Log.e("jsonobject", response.getJSONObject("data").getJSONObject("list").getJSONArray("anime").
                            toString()) ;
                    String jsonString = response.getJSONObject("data").getJSONObject("list").getJSONArray("anime").
                            toString() ;
                    Gson gson = new Gson() ;
                    ViedoAnimeInfo viedoAnimeInfo= gson.fromJson(jsonString, ViedoAnimeInfo.class) ;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CommonUtil.shortToast("网络出现问题");
            }
        }) ;
        VolleySingleQueue.addRequest(jsonObjectRequest);

    }
}
