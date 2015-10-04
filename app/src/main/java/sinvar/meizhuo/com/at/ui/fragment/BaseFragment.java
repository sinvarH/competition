package sinvar.meizhuo.com.at.ui.fragment;

import android.app.Activity;
import android.app.Fragment;

import sinvar.meizhuo.com.at.ui.BaseActivity;

/**
 * Created by sinvar on 2015/10/2.
 */
public class BaseFragment extends Fragment {
    protected BaseActivity baseActivity ;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        baseActivity = (BaseActivity)activity ;
    }
}
