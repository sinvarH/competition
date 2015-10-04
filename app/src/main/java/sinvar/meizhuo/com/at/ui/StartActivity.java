package sinvar.meizhuo.com.at.ui;


import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import sinvar.meizhuo.com.at.R;
import sinvar.meizhuo.com.at.adapters.VideoListAdapter;
import sinvar.meizhuo.com.at.entity.ViedoAnimeInfo;
import sinvar.meizhuo.com.at.gsonvolleyandokhttp.VolleySingleQueue;
import sinvar.meizhuo.com.at.ui.fragment.LeftMenuFragment;
import sinvar.meizhuo.com.at.utils.ApiAdress;

/**
 * Created by sinvar on 2015/10/2.
 */
public class StartActivity extends BaseActivity{
    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(android.R.id.list)
    ListView list;
    @InjectView(R.id.leftMenu)
    FrameLayout leftMenu;
    @InjectView(R.id.dl_main_drawer)
    DrawerLayout dlMainDrawer;
    private ActionBarDrawerToggle mDrawerToggle;
    private LeftMenuFragment leftMenuFragment;
    private ViedoAnimeInfo viedoAnimeInfo ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ButterKnife.inject(this);
        initLayout();
        getData();
    }

    private void initLayout() {
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
    }

    public void getData()
    {
        JsonObjectRequest jsonObjectRequest  = new JsonObjectRequest(ApiAdress.getList(1), null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String jsonString = response.getJSONObject("data").getJSONObject("list").getJSONArray("anime").
                            toString() ;
                    jsonString = "{\"anime\":"+jsonString+"}" ;
                    Log.e("fuck",ApiAdress.getInitData(20,5,2));
                    Log.e("fuck", "{\"anime\":"+jsonString+"}");


                    Gson gson = new Gson() ;
                    viedoAnimeInfo = gson.fromJson(jsonString,ViedoAnimeInfo.class) ;
                    Log.e("eee",viedoAnimeInfo.toString()) ;
                    VideoListAdapter videoListAdapter = new VideoListAdapter(StartActivity.this) ;
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
        }) ;
        VolleySingleQueue.addRequest(jsonObjectRequest);
    }
}
