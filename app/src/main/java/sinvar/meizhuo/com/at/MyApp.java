package sinvar.meizhuo.com.at;

import android.app.Application;
import android.content.Context;

/**
 * Created by sinvar on 2015/9/30.
 */
public class MyApp extends Application
{
    private static Context context ;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext() ;
    }

    public static Context getContext ()
    {
        return context ;
    }
}
