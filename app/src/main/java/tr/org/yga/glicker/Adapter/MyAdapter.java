package tr.org.yga.glicker.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import tr.org.yga.glicker.DisplayActivity;
import tr.org.yga.glicker.PhotoListItem;
import tr.org.yga.glicker.R;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<PhotoListItem> images;
    private Context mContext;

    public MyAdapter(Context context, List<PhotoListItem> images) {
        mContext = context;
        this.images = images;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView thumbnail;

        public MyViewHolder(View view, Context context, List<PhotoListItem> images) {
            super(view);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            view.setOnClickListener(this);
            mContext = context;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mContext, DisplayActivity.class);
            intent.putExtra("image_id", images.indexOf(getAdapterPosition()));
            mContext.startActivity(intent);
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
        PhotoListItem image = images.get(position);
        Glide.with(mContext).load(image.getUrl()).
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
