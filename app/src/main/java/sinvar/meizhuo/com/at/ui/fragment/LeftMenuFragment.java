package sinvar.meizhuo.com.at.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import sinvar.meizhuo.com.at.R;

/**
 * Created by sinvar on 2015/10/2.
 */
public class LeftMenuFragment extends BaseFragment {


    @InjectView(R.id.menu_list)
    ListView menuList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_letf_menu, container, false);
        ButterKnife.inject(this, view);

        List<String> itemList = new ArrayList<>() ;
        itemList.add("MV") ;
        itemList.add("广告") ;
        itemList.add("预告") ;
        itemList.add("纪录片");
        itemList.add("剧场版") ;
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(baseActivity,R.layout.letf_menu_item,itemList) ;
        menuList.setAdapter(adapter) ;
        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              switch (position)
              {
                  case (0):
                      Toast.makeText(baseActivity, "personal information", Toast.LENGTH_SHORT).show();
                      break;
                  case (1):
                      Toast.makeText(baseActivity,"settings",Toast.LENGTH_SHORT).show();
                      break;
                  case (2):
                      Toast.makeText(baseActivity,"about",Toast.LENGTH_SHORT).show();
                      break;
                  case (3):
                      Toast.makeText(baseActivity,"share",Toast.LENGTH_SHORT).show();
                      break;
              }
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
