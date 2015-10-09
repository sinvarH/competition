package sinvar.meizhuo.com.at.ui;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;
import sinvar.meizhuo.com.at.R;

/**
 * Created by sinvar on 2015/10/5.
 */
public class PlayAcitivity extends BaseActivity {

    private String sourceUrl ;

    @InjectView(R.id.video_view)
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!LibsChecker.checkVitamioLibs(this))
            return;
        sourceUrl = getIntent().getStringExtra("videosource");

        // 隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_playviedo);
        ButterKnife.inject(this);

        initLayout();
    }

    public void initLayout()
    {
        videoView.setVideoPath(sourceUrl);

        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        Integer width = metric.widthPixels;  // 宽度（PX）
        Integer height = metric.heightPixels;  // 高度（PX）
        Log.e("bili",width.toString()) ;
        Log.e("bili",height.toString()) ;

        videoView.setVideoLayout(2,width/height);
        videoView.setMediaController(new MediaController(this));
        videoView.requestFocus();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setPlaybackSpeed(1.0f);
            }
        });
    }
}