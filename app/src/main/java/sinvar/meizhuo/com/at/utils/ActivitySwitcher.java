package sinvar.meizhuo.com.at.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * activity的切换
 * Created by sinvar on 2015/9/17.
 */
public class ActivitySwitcher {
    public static void pushForResultDefault(Context from,Class<?> to,int requestCode,Bundle data)
    {
        Intent intent = new Intent(from,to) ;
        if (data != null)
        {
            intent.putExtras(data);
        }
        ((Activity)from).startActivityForResult(intent,requestCode);
    }


    public static void pushDefault(Context from, Class<?> to) {
        pushDefault(from,to,null);
    }


    public static void pushDefault(Context from, Class<?> to, Bundle data) {
        Intent intent = new Intent(from, to);
        if (data != null) {
            intent.putExtras(data);
        }
        ((Activity) from).startActivity(intent);
    }


    public static void pushFragmnet(Context from,Class<?> to ,Bundle data)
    {
        Intent intent = new Intent(from,to) ;
        if (data != null)
        {
            intent.putExtras(data);
        }
        ((Activity)from).startActivity(intent);
    }


    public static void pushFragmnet(Context from,Class<?> to )
    {
        pushFragmnet(from,to,null);
    }

}

