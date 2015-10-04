package sinvar.meizhuo.com.at.gsonvolleyandokhttp;

import android.support.annotation.Nullable;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import sinvar.meizhuo.com.at.utils.Constant;

/**
 * Created by sinvar on 2015/9/12.
 */
public class GsonRequest<T> extends Request<T> {
    //响应的callback
    private Response.Listener<T> listener ;
    private Gson gson ;
    //要解析成的GSON对应的javabean
    private Type type ;
    private Class<T> clazz ;
    private Map<String ,String > params ;

    public GsonRequest(int method, Class<T> clazz, String url, @Nullable Map<String, String> params, Response.Listener<T> listener,
                       Response.ErrorListener errorListener)
    {
        super(method,url,errorListener);
        this.listener = listener;
        this.gson = new Gson();
        this.clazz = clazz ;
       // this.type = new TypeToken<T>() {}.getType();
        this.params = params;
    }

    @Override
    public Map<String, String> getParams() {
        Log.e("test", "getparams") ;
        return params;
    }


    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        Log.e("test", "getHeaders") ;
        //对cookie的处理
        Map<String, String> headers = super.getHeaders();
        if (headers == null
                || headers.equals(Collections.emptyMap())) {
            headers = new HashMap<String, String>();
        }
        VolleySingleQueue.getInstance().addSessionCookie(headers, Constant.isHaveCookie);
        return headers;
    }


    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        Log.e("test", "parseNetworkResponse") ;
        VolleySingleQueue.getInstance().checkSessionCookie(response.headers);
        try {
            String jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers)) ;
            Log.e("jsonstring", jsonString) ;
            return Response.success((gson.fromJson(jsonString,clazz)),HttpHeaderParser.parseCacheHeaders(response)) ;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return Response.error(new ParseError()) ;
        }
    }


    @Override
    protected void deliverResponse(T response) {
        Log.e("--->>", response.toString());
        listener.onResponse(response);
    }

    public static <T> void get(String url,Class<T> clazz, Map<String, String> params, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        GsonRequest<T> request = new GsonRequest<T>(Method.GET,clazz,url,params, listener, errorListener);
        VolleySingleQueue.getInstance().addRequest(request);
    }
    public static <T> void post(String url,Class<T> clazz,Map<String, String> params, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        GsonRequest<T> request = new GsonRequest<T>(Method.POST,clazz,url, params, listener, errorListener);
        VolleySingleQueue.getInstance().addRequest(request);
    }
}
