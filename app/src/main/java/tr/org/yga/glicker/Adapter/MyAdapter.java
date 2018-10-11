package tr.org.yga.glicker.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import tr.org.yga.glicker.DisplayActivity;
import tr.org.yga.glicker.PhotoListItem;
import tr.org.yga.glicker.R;
import tr.org.yga.glicker.Response.PhotoItem;
import tr.org.yga.glicker.Response.Photos;
import tr.org.yga.glicker.Response.Response;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    private List<PhotoItem> images;
    private Context mContext;

    public MyAdapter(Context context, List<PhotoItem> images) {
        mContext = context;
        this.images = images;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView thumbnail;
        TextView image_content;

        public MyViewHolder(View view, Context context, List<PhotoItem> images) {
            super(view);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            mContext = context;
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_layout, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(itemView, mContext, images);
        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        PhotoItem image = images.get(position);
        String constructedUrl = "https://farm" + image.getFarm() + ".staticflickr.com/" + image.getServer() + "/" + image.getId() + "_" + image.getSecret() + ".jpg";

        Glide.with(mContext).load(constructedUrl).
                thumbnail(0.5f).
                transition(withCrossFade()).
                into(holder.thumbnail);

    }

    @Override
    public int getItemCount() {
        return images.size();
    }

     /*
    public void glideDownload(RetrievePhotos retrievePhotos, Activity activity) {
        for (String url : urlList)
            Glide.with(activity).load(url);

    }
*/
}
