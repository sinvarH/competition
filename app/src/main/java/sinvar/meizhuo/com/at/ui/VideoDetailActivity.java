package sinvar.meizhuo.com.at.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import sinvar.meizhuo.com.at.R;
import sinvar.meizhuo.com.at.utils.ActivitySwitcher;

/**
 * Created by sinvar on 2015/10/8.
 */
public class VideoDetailActivity extends BaseActivity {
    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.imageView)
    ImageView imageView;
    @InjectView(R.id.play_button)
    ImageButton playButton;
    @InjectView(R.id.title)
    TextView title;
    @InjectView(R.id.autor)
    TextView autor;
    @InjectView(R.id.content)
    TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_detail);
        ButterKnife.inject(this);
        //设置切换动画
        overridePendingTransition(R.anim.scale_in,R.anim.alpha_out);

        //返回上一个activity
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        ArrayList<String> list = getIntent().getStringArrayListExtra("data") ;
        Picasso.with(this).load(list.get(1))
                .into(imageView) ;
        title.setText(list.get(2)) ;
        autor.setText(list.get(3)) ;
        content.setText(list.get(4)) ;
    }

    @OnClick(R.id.play_button)
    public void play()
    {
        Bundle bundle =new Bundle() ;
        bundle.putString("videosource",getIntent().getStringExtra("videosource"));
        ActivitySwitcher.pushDefault(VideoDetailActivity.this, PlayAcitivity.class,bundle);
    }

}
