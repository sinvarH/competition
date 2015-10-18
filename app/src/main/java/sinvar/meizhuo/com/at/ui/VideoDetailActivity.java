package sinvar.meizhuo.com.at.ui;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import sinvar.meizhuo.com.at.R;
import sinvar.meizhuo.com.at.entity.Comment;
import sinvar.meizhuo.com.at.utils.ActivitySwitcher;

/**
 * Created by sinvar on 2015/10/8.
 */
public class VideoDetailActivity extends BaseActivity {
    private Integer id;
    private int mSkip = 0;
    private int mStep = 5;
    private LayoutInflater inflater ;
    private Context mContext ;
    private ArrayList<String> avatarUrl  = new ArrayList<>() ;

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
    @InjectView(R.id.comments)
    LinearLayout comments ;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_detail);
        ButterKnife.inject(this);
        toolbar.setTitle("");
        toolbar.setLogo(R.drawable.icon);

        mContext = this ;
        inflater = (LayoutInflater)
                this.getSystemService(LAYOUT_INFLATER_SERVICE);

        AVOSCloud.initialize(this,
                "w43xht9daji0uut74pseeiibax8c2tnzxowmx9f81nvtpims",
                "86q8251hrodk6wnf4znistay1mva9rm1xikvp1s9mhp5n7od") ;

        //设置切换动画
        overridePendingTransition(R.anim.scale_in, R.anim.alpha_out);

        //返回上一个activity
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        ArrayList<String> list = getIntent().getStringArrayListExtra("data");
        Picasso.with(this).load(list.get(1))
                .into(imageView);
        title.setText(list.get(2)) ;
        autor.setText(list.get(3)) ;
        content.setText(list.get(4)) ;
        id = Integer.parseInt(list.get(5)) ;

        new CommentsTask().execute();
    }

    @OnClick(R.id.play_button)
    public void play()
    {
        Bundle bundle = new Bundle();
        bundle.putString("videosource", getIntent().getStringExtra("videosource"));
        ActivitySwitcher.pushDefault(VideoDetailActivity.this, PlayAcitivity.class, bundle);
    }

    private class CommentsTask extends AsyncTask<Void,LinearLayout, Boolean>
    {

        @Override
        protected Boolean doInBackground(Void... params)
        {
            AVQuery<AVObject> query = new AVQuery<AVObject>(
                    "Comments");
            query.whereEqualTo("vid", id);
            query.setLimit(mStep);
            query.setSkip(mSkip);
            query.include("uid");
            query.orderByDescending("updatedAt");
            try {
                ArrayList<LinearLayout> commentsLayout = new ArrayList<LinearLayout>();
                List<AVObject> commentList = query.find();
                if (commentList.size() < mStep) {
                    Integer i=commentList.size() ;
                    Log.e("test",i.toString()) ;
                }
                for (AVObject comment : commentList) {
                    AVObject user = comment.getAVObject("uid");
                    Comment commentInformation = new Comment(
                            user.getString("username"),
                            user.getString("avatar"),
                            user.getString("platform"), comment.getUpdatedAt(),
                            comment.getString("content"));
                    LinearLayout commentItem = (LinearLayout)inflater.inflate(R.layout.comments_item, null) ;
                    TextView userName =(TextView)commentItem.findViewById(R.id.username) ;
                    userName.setText(commentInformation.Username);
                    TextView content =(TextView)commentItem.findViewById(R.id.content) ;
                    content.setText(commentInformation.Content);

                    avatarUrl.add(commentInformation.Avatar);
                    commentsLayout.add(commentItem);
                }
                publishProgress(commentsLayout
                        .toArray(new LinearLayout[commentList.size()]));
            } catch (AVException e)
            {

            }

            return  false ;
        }

        @Override
        protected void onProgressUpdate(LinearLayout... values) {
            super.onProgressUpdate(values);
            int position =  0;
            Integer i = values.length ;
            Log.e("shuliang", i.toString()) ;
            for (LinearLayout commentView : values) {
                ImageView avatar =(ImageView)commentView.findViewById(R.id.usernamepic) ;
                Picasso.with(mContext)
                        .load(avatarUrl.get(position))
                        .into(avatar) ;
                position++ ;
                comments.addView(commentView);
            }
        }
    }

}
