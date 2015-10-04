package sinvar.meizhuo.com.at.gsonvolleyandokhttp;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;

import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import sinvar.meizhuo.com.at.utils.Constant;


/**
 * Created by hh3677815 on 2015/9/14.
 */
public class MyStringRequest extends Request<String>{
    private Map<String,String> parmas;
    private  final  Response.Listener<String> listener;

    public MyStringRequest(int method, String url,Map<String,String> parmas,Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.parmas = parmas;
        this.listener =listener ;
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return parmas;
    }


    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        //对cookie的处理
        Map<String, String> headers = super.getHeaders();
        if (headers == null
                || headers.equals(Collections.emptyMap())) {
            headers = new HashMap<String, String>();
        }
        VolleySingleQueue.getInstance().addSessionCookie(headers, Constant.isHaveCookie);
        Log.e("method", "getheaders");
        return headers;
    }

    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        Log.e("method", "parseNetworkResponse");
       VolleySingleQueue.getInstance().checkSessionCookie(response.headers);
        String parsed ;
        try {
            parsed = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
        } catch (UnsupportedEncodingException e) {
            parsed = new String(response.data) ;
        }
        return Response.success(parsed, HttpHeaderParser.parseCacheHeaders(response));
    }

    @Override
    protected void deliverResponse(String response) {
        listener.onResponse(response);
    }

    public static void get (String url,Map<String,String> parmas,Response.Listener<String> listener, Response.ErrorListener errorListener)
    {
        MyStringRequest myStringRequest =new MyStringRequest(Method.GET,url,parmas,listener,errorListener) ;
        VolleySingleQueue.addRequest(myStringRequest);
    }
    public static void post (String url,Map<String,String> parmas,Response.Listener<String> listener, Response.ErrorListener errorListener)
    {
        MyStringRequest myStringRequest =new MyStringRequest(Method.POST,url,parmas,listener,errorListener) ;
        VolleySingleQueue.addRequest(myStringRequest);
    }
}
