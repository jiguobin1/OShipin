package jiguobin.example.com.oshipin;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by acer-PC on 2017/8/21.
 */

public class MyAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context mContext;
    private List<Bean.TrailersBean> list;

    public MyAdapter(Context mContext, List<Bean.TrailersBean> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv.setText(list.get(position).getVideoTitle());
        holder.jcVideoPlayer.setUp(list.get(position).getHightUrl(),JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,list.get(position).getMovieName());
        Picasso.with(mContext).load(list.get(position).getCoverImg()).into(holder.jcVideoPlayer.thumbImageView);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
class ViewHolder extends RecyclerView.ViewHolder{

    public JCVideoPlayerStandard jcVideoPlayer;
    public TextView tv;
    public ViewHolder(View itemView) {
        super(itemView);
        jcVideoPlayer=itemView.findViewById(R.id.item_video);
        tv=itemView.findViewById(R.id.item_tv);
    }
}
