package sinvar.meizhuo.com.at.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import sinvar.meizhuo.com.at.R;
import sinvar.meizhuo.com.at.gsonvolleyandokhttp.VolleySingleQueue;
import sinvar.meizhuo.com.at.utils.ActivitySwitcher;
import sinvar.meizhuo.com.at.utils.ApiAdress;
import sinvar.meizhuo.com.at.utils.NetWorkUtil;

/**
 * Created by sinvar on 2015/9/29.
 */
public class LoadActivity extends BaseActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);

        if (!NetWorkUtil.isWifiConnected())
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this).setTitle("网络提示")
                    .setMessage("当前为非wifi环境") ;
            builder.setCancelable(false) ;
            builder.setPositiveButton("继续", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    init();
                }
            }) ;
            builder.setNegativeButton("退出", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            }) ;
            builder.create().show() ;
        }else
        {
            init();
        }
    }

    protected void init()
    {
        JsonObjectRequest jsonObjectRequest  = new JsonObjectRequest(ApiAdress.getList(1), null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                    Log.e("fuck", ApiAdress.getList(1));
                    Log.e("fuck", response.toString());


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) ;
        VolleySingleQueue.addRequest(jsonObjectRequest);

        ActivitySwitcher.pushDefault(LoadActivity.this, StartActivity.class);
    }
}
