package sinvar.meizhuo.com.at.ui;


import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bingoogolapple.refreshlayout.BGARefreshViewHolder;
import sinvar.meizhuo.com.at.R;
import sinvar.meizhuo.com.at.adapters.VideoListAdapter;
import sinvar.meizhuo.com.at.entity.ViedoAnimeInfo;
import sinvar.meizhuo.com.at.gsonvolleyandokhttp.VolleySingleQueue;
import sinvar.meizhuo.com.at.ui.fragment.LeftMenuFragment;
import sinvar.meizhuo.com.at.utils.ActivitySwitcher;
import sinvar.meizhuo.com.at.utils.ApiAdress;

/**
 * Created by sinvar on 2015/10/2.
 */
public class StartActivity extends BaseActivity implements BGARefreshLayout.BGARefreshLayoutDelegate{

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.list)
    ListView list;
    @InjectView(R.id.rl_modulename_refresh)
    BGARefreshLayout mRefreshLayout;
    @InjectView(R.id.leftMenu)
    FrameLayout leftMenu;
    @InjectView(R.id.dl_main_drawer)
    DrawerLayout dlMainDrawer;

    private ActionBarDrawerToggle mDrawerToggle;
    private LeftMenuFragment leftMenuFragment;
    private ViedoAnimeInfo viedoAnimeInfo;
    private Integer currentPage ;
    private VideoListAdapter videoListAdapter ;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ButterKnife.inject(this);
        videoListAdapter = new VideoListAdapter(StartActivity.this);
        initLayout();
        getData();
    }

    private void initLayout()
    {
        toolbar.setTitle("AT");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //创建返回键，并实现打开关/闭监听
        mDrawerToggle = new ActionBarDrawerToggle(this, dlMainDrawer, toolbar, 0, 0) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        mDrawerToggle.syncState();
        dlMainDrawer.setDrawerListener(mDrawerToggle);

        leftMenuFragment = new LeftMenuFragment();
        getFragmentManager().beginTransaction().add(R.id.leftMenu, leftMenuFragment).commit();

        initRefreshLayout();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                viedoAnimeInfo.setAnime(videoListAdapter.getAnimeEntity()) ;
                Bundle bundle = new Bundle() ;

                ArrayList<String> list =new ArrayList<String>() ;
                list.add(viedoAnimeInfo.getAnime().get(position).getVideoSource().getSd());
                list.add(viedoAnimeInfo.getAnime().get(position).getDetailPic());
                list.add( viedoAnimeInfo.getAnime().get(position).getName());
                list.add(viedoAnimeInfo.getAnime().get(position).getAuthor());
                list.add(viedoAnimeInfo.getAnime().get(position).getBrief());

                bundle.putString("videosource", viedoAnimeInfo.getAnime().get(position).getVideoSource().getSd());
                bundle.putStringArrayList("data",list);
                ActivitySwitcher.pushDefault(StartActivity.this, VideoDetailActivity.class,bundle);
            }
        });
    }

    /**
     * 来日叶良辰修复这段垃圾代码
     */
    public void getData()
    {
        currentPage =1 ;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(ApiAdress.getList(currentPage), null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String jsonString = response.getJSONObject("data").getJSONObject("list").getJSONArray("anime").
                            toString();
                    jsonString = "{\"anime\":" + jsonString + "}";
                    Log.e("fuck", "{\"anime\":" + jsonString + "}");

                    Gson gson = new Gson();
                    viedoAnimeInfo = gson.fromJson(jsonString, ViedoAnimeInfo.class);
                    Log.e("eee", viedoAnimeInfo.toString());

                    list.setAdapter(videoListAdapter);
                    videoListAdapter.setAnimeEntity(viedoAnimeInfo.getAnime());
                    videoListAdapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleySingleQueue.addRequest(jsonObjectRequest);
    }

    /**
     * 下拉刷新
     */
    @Override
    public void onBGARefreshLayoutBeginRefreshing()
    {

    }

    /**
     * 加载更多
     */
    @Override
    public void onBGARefreshLayoutBeginLoadingMore()
    {
        currentPage++ ;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(ApiAdress.getList(currentPage), null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String jsonString = response.getJSONObject("data").getJSONObject("list").getJSONArray("anime").
                            toString();
                    jsonString = "{\"anime\":" + jsonString + "}";

                    Gson gson = new Gson();
                    viedoAnimeInfo = gson.fromJson(jsonString, ViedoAnimeInfo.class) ;

                    List<ViedoAnimeInfo.AnimeEntity> animeEntity = videoListAdapter.getAnimeEntity();
                    animeEntity.addAll(viedoAnimeInfo.getAnime());
                    videoListAdapter.setAnimeEntity(animeEntity);
                    mRefreshLayout.endRefreshing();
                    videoListAdapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        VolleySingleQueue.addRequest(jsonObjectRequest);
    }

    public void initRefreshLayout ()
    {
        // 为BGARefreshLayout设置代理
        mRefreshLayout.setDelegate(this);
        // 设置下拉刷新和上拉加载更多的风格     参数1：应用程序上下文，参数2：是否具有上拉加载更多功能
        BGARefreshViewHolder refreshViewHolder = new BGARefreshViewHolder(StartActivity.this,true) {
            @Override
            public View getRefreshHeaderView() {
                return null;
            }

            @Override
            public void handleScale(float v, int i) {

            }

            @Override
            public void changeToIdle() {

            }

            @Override
            public void changeToPullDown() {

            }

            @Override
            public void changeToReleaseRefresh() {

            }

            @Override
            public void changeToRefreshing() {

            }

            @Override
            public void onEndRefreshing() {

            }
        } ;
        // 设置下拉刷新和上拉加载更多的风格
        mRefreshLayout.setRefreshViewHolder(refreshViewHolder);
        // 为了增加下拉刷新头部和加载更多的通用性，提供了以下可选配置选项  -------------START
        // 设置正在加载更多时不显示加载更多控件
        // mRefreshLayout.setIsShowLoadingMoreView(false);
        // 设置正在加载更多时的文本
        refreshViewHolder.setLoadingMoreText("Loading");
        // 设置整个加载更多控件的背景颜色资源id
        refreshViewHolder.setLoadMoreBackgroundColorRes(R.color.LoadBackground);
        // 设置整个加载更多控件的背景drawable资源id
        refreshViewHolder.setLoadMoreBackgroundDrawableRes(R.drawable.ic_action_name);

        /*
        // 设置下拉刷新控件的背景颜色资源id
        refreshViewHolder.setRefreshViewBackgroundColorRes(refreshViewBackgroundColorRes);
        // 设置下拉刷新控件的背景drawable资源id
        refreshViewHolder.setRefreshViewBackgroundDrawableRes(refreshViewBackgroundDrawableRes);
        // 设置自定义头部视图（也可以不用设置）     参数1：自定义头部视图（例如广告位）， 参数2：上拉加载更多是否可用
        mRefreshLayout.setCustomHeaderView(mBanner, true);
        // 可选配置  -------------END
        */
    }
}
