package tr.org.yga.glicker.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

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

// TODO: 15.10.2018 MyVıewHolder oooooolmmaaaaaaazz
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    private final ItemClickEvent itemClickEvent;
    private List<PhotoItem> images;
    // TODO: 15.10.2018 Context gecmeye gerek yok
    private Context mContext;

    public MyAdapter(Context context, List<PhotoItem> images, ItemClickEvent itemClickEvent) {
        mContext = context;
        this.images = images;
        this.itemClickEvent = itemClickEvent;

    }

    // TODO: 15.10.2018 Bunu ayrı bır class olarak tanımla
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView thumbnail;
        // TODO: 15.10.2018 degıskenler camelCase olaacaaaaaaak
        TextView image_content;
        RelativeLayout parentLayout;

        // TODO: 15.10.2018  Burası da databındıng
        public MyViewHolder(View view, Context context, List<PhotoItem> images) {
            super(view);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            mContext = context;
            parentLayout = view.findViewById(R.id.album_layout);
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
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        PhotoItem image = images.get(position);
        final String constructedUrl = "https://farm" + image.getFarm() + ".staticflickr.com/" + image.getServer() + "/" + image.getId() + "_" + image.getSecret() + ".jpg";
        Glide.with(mContext).load(constructedUrl).
                thumbnail(0.5f).
                transition(withCrossFade()).
                into(holder.thumbnail);
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: 15.10.2018
                // Toast.makeText(mContext, mImageNames.get(position), Toast.LENGTH_SHORT).show();
                itemClickEvent.onItemClicked(position);
            }
        });
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

     public interface ItemClickEvent{
         void onItemClicked(int position);
     }
}
