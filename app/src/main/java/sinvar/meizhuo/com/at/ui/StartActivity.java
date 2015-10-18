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
import java.util.HashMap;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bingoogolapple.refreshlayout.BGARefreshViewHolder;
import cn.lightsky.infiniteindicator.InfiniteIndicatorLayout;
import cn.lightsky.infiniteindicator.slideview.BaseSliderView;
import cn.lightsky.infiniteindicator.slideview.DefaultSliderView;
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
public class StartActivity extends BaseActivity implements BGARefreshLayout.BGARefreshLayoutDelegate
{

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.list)
    ListView list;
    @InjectView(R.id.rl_modulename_refresh)
    BGARefreshLayout mRefreshLayout;
    @InjectView(R.id.leftMenu)
    FrameLayout leftMenu;
    @InjectView(R.id.dl_main_drawer)
    DrawerLayout drawerLayout;
//    @InjectView(R.id.indicator_default_circle)
//    InfiniteIndicatorLayout  mDefaultIndicator ;

    private ActionBarDrawerToggle mDrawerToggle;
    private LeftMenuFragment leftMenuFragment;
    private ViedoAnimeInfo viedoAnimeInfo;
    public static VideoListAdapter videoListAdapter ;
    private ListView letfMenuListView ;
    private  InfiniteIndicatorLayout mDefaultIndicator ;

    private String nextPageUrl ;
    private int currentPage ;
    private int type ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ButterKnife.inject(this);

        //设置Indicator的属性，这样有个坑，需要有viewgrop参数，调用三个参数的
        mDefaultIndicator = (InfiniteIndicatorLayout)getLayoutInflater().inflate(R.layout.listview_header,list,false) ;
        setIndicator();

        //设置listview，注意addheaderview在setadapter之前
        videoListAdapter = new VideoListAdapter(StartActivity.this) ;
        list.addHeaderView(mDefaultIndicator);
        list.setAdapter(videoListAdapter);

        initLayout();
        getFirstPageData(ApiAdress.getList(currentPage));
    }

    private void initLayout()
    {
        currentPage = 1 ;
        //4是调用api的getlist
        type = 4  ;
        toolbar.setTitle("");
        toolbar.setLogo(R.drawable.icon);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //创建返回键，并实现打开关/闭监听
        mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0)
        {
            @Override
            public void onDrawerOpened(View drawerView)
            {
                super.onDrawerOpened(drawerView);
                letfMenuListView = leftMenuFragment.getMenuList() ;

                letfMenuListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                    {
                        switch (position)
                        {
                            case (0):
                                type = 0 ;
                                videoListAdapter.clearData();
                                currentPage = 1 ;
                                getFirstPageData(ApiAdress.getCategory(0, currentPage, 10));
                                drawerLayout.closeDrawers();
                                break;
                            case (1):
                                type = 1 ;
                                videoListAdapter.clearData();
                                currentPage = 1 ;
                                getFirstPageData(ApiAdress.getCategory(1, currentPage, 10));
                                drawerLayout.closeDrawers();
                                break;
                            case (2):
                                type = 2 ;
                                videoListAdapter.clearData();
                                currentPage = 1 ;
                                getFirstPageData(ApiAdress.getCategory(2,currentPage, 10));
                                drawerLayout.closeDrawers();
                                break;
                            case (3):
                                type = 3 ;
                                videoListAdapter.clearData();
                                currentPage = 1 ;
                                getFirstPageData(ApiAdress.getCategory(3, currentPage, 10));
                                drawerLayout.closeDrawers();
                                break;
                        }
                    }
                });
            }

            @Override
            public void onDrawerClosed(View drawerView)
            {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerToggle.syncState();
        drawerLayout.setDrawerListener(mDrawerToggle);

        leftMenuFragment = new LeftMenuFragment();
        leftMenuFragment.setVideoListAdapter(videoListAdapter);
        getFragmentManager().beginTransaction().add(R.id.leftMenu, leftMenuFragment).commit();

        initRefreshLayout();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                viedoAnimeInfo.setAnime(videoListAdapter.getAnimeEntity());
                Bundle bundle = new Bundle();

                //这里为了使用添加了header而减一
                position=position-1;
                ArrayList<String> list = new ArrayList<String>();
                list.add(viedoAnimeInfo.getAnime().get(position).getVideoSource().getSd());
                list.add(viedoAnimeInfo.getAnime().get(position).getDetailPic());
                list.add(viedoAnimeInfo.getAnime().get(position).getName());
                list.add(viedoAnimeInfo.getAnime().get(position).getAuthor());
                list.add(viedoAnimeInfo.getAnime().get(position).getBrief());
                list.add(viedoAnimeInfo.getAnime().get(position).getId());

                bundle.putString("videosource", viedoAnimeInfo.getAnime().get(position).getVideoSource().getSd());
                bundle.putStringArrayList("data", list);
                ActivitySwitcher.pushDefault(StartActivity.this, VideoDetailActivity.class, bundle);
            }
        });

    }

    /**
     * 来日叶良辰修复这段垃圾代码
     */
    public void getFirstPageData(String url)
    {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String jsonString = response.getJSONObject("data").getJSONObject("list").getJSONArray("anime").
                            toString();
                    jsonString = "{\"anime\":" + jsonString + "}";
                    Log.e("fuckyou",jsonString) ;

                    Gson gson = new Gson();
                    viedoAnimeInfo = gson.fromJson(jsonString, ViedoAnimeInfo.class);

                    List<ViedoAnimeInfo.AnimeEntity> animeEntity = videoListAdapter.getAnimeEntity();
                    animeEntity.addAll(viedoAnimeInfo.getAnime());
                    videoListAdapter.setAnimeEntity(viedoAnimeInfo.getAnime());
                    videoListAdapter.notifyDataSetChanged();

                } catch (JSONException e)
                {
                    e.printStackTrace() ;
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
        getNextPageData();
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
    }

    public void getNextPageData()
    {
        currentPage++ ;
        switch (type)
        {
            case (0) :
                nextPageUrl = ApiAdress.getCategory(0,currentPage,10) ;
                break;
            case (1):
                nextPageUrl = ApiAdress.getCategory(1,currentPage,10) ;
                break;
            case (2):
                nextPageUrl = ApiAdress.getCategory(2,currentPage,10) ;
                break;
            case (3) :
                nextPageUrl = ApiAdress.getCategory(3,currentPage,10) ;
                break;
            case (4):
                nextPageUrl=ApiAdress.getList(currentPage) ;
                break;
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(nextPageUrl, null, new Response.Listener<JSONObject>() {
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
                    //里面包含notifydatachange

                } catch (JSONException e) {
                    e.printStackTrace();
                    mRefreshLayout.endRefreshing();
                }finally {
                    mRefreshLayout.endRefreshing();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                mRefreshLayout.endRefreshing();
            }
        });
        VolleySingleQueue.addRequest(jsonObjectRequest);
    }

    /**
     * 轮播设置
     */
    private void setIndicator ()
    {
        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps = new HashMap<String, String>();
        url_maps.put("Page A", "http://ww3.sinaimg.cn/large/0066P23Wjw1ex549ry7xsj30hs07sq45.jpg");
        url_maps.put("Page B", "http://ww1.sinaimg.cn/large/0066P23Wjw1eww0y71jg4j30hs0buwfy.jpg");
        url_maps.put("Page C", "http://ww1.sinaimg.cn/large/0066P23Wjw1eww0ikuu0bj30hs07s3z8.jpg");
        url_maps.put("Page D", "http://ww4.sinaimg.cn/large/0066P23Wjw1ew6m6mgspij30hs07smxw.jpg");

        for(String name : url_maps.keySet()){
            DefaultSliderView textSliderView = new DefaultSliderView(this);
            textSliderView
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .showImageResForEmpty(R.drawable.placeholder_fail)
                    .showImageResForError(R.drawable.placeholder_thumb)
                    .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                        @Override
                        public void onSliderClick(BaseSliderView baseSliderView) {

                        }
                    });
            textSliderView.getBundle()
                    .putString("extra",name);
            mDefaultIndicator.addSlider(textSliderView);
        }
        mDefaultIndicator.setIndicatorPosition(InfiniteIndicatorLayout.IndicatorPosition.Center_Bottom);
        mDefaultIndicator.startAutoScroll();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mDefaultIndicator.stopAutoScroll();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mDefaultIndicator.startAutoScroll();
    }
}
