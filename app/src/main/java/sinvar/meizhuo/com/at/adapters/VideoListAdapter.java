package sinvar.meizhuo.com.at.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import sinvar.meizhuo.com.at.R;
import sinvar.meizhuo.com.at.entity.ViedoAnimeInfo;

/**
 * Created by sinvar on 2015/10/2.
 */
public class VideoListAdapter extends BaseAdapter {

    private Context context;
    private List<ViedoAnimeInfo.AnimeEntity> animeEntity;
    private ViewHolder holder;

    public void setAnimeEntity(List<ViedoAnimeInfo.AnimeEntity> animeEntity) {
        this.animeEntity = animeEntity;
    }

    public VideoListAdapter(Context context) {
        this.context = context;
        this.animeEntity = new ArrayList<>() ;
    }

    @Override
    public int getCount() {
        return animeEntity.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(context).inflate(R.layout.video_item, null, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }

        Picasso.with(context).load(animeEntity.get(position).getHomePic())
                .placeholder(R.drawable.placeholder_thumb)
                .error(R.drawable.placeholder_fail).into(holder.thumb);
        holder.title.setText(animeEntity.get(position).getName());
        holder.content.setText(animeEntity.get(position).getBrief());
        return convertView;
    }

    /**
     * This class contains all butterknife-injected Views & Layouts from layout file 'video_item.xml'
     * for easy to all layout elements.
     *
     * @author ButterKnifeZelezny, plugin for Android Studio by Avast Developers (http://github.com/avast)
     */
    static class ViewHolder {
        @InjectView(R.id.thumb)
        ImageView thumb;
        @InjectView(R.id.title)
        TextView title;
        @InjectView(R.id.content)
        TextView content;

        ViewHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }

    /**
     * This class contains all butterknife-injected Views & Layouts from layout file 'video_item.xml'
     * for easy to all layout elements.
     *
     * @author ButterKnifeZelezny, plugin for Android Studio by Avast Developers (http://github.com/avast)
     */

}
