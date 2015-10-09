package sinvar.meizhuo.com.at.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;

import sinvar.meizhuo.com.at.R;
import sinvar.meizhuo.com.at.utils.ActivitySwitcher;
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
        new Handler().postDelayed(new Runnable() {
            public void run() {
                ActivitySwitcher.pushDefault(LoadActivity.this, StartActivity.class);
                LoadActivity.this.finish();
            }
        }, 1000);
    }
}
