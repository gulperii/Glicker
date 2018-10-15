package tr.org.yga.glicker.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import tr.org.yga.glicker.R;
import tr.org.yga.glicker.holder.ImageViewHolder;
import tr.org.yga.glicker.interestingPhotos.PhotoItem;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class ImageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    private final ItemClickEvent itemClickEvent;
    private List<PhotoItem> images;
    // TODO: 15.10.2018 Context gecmeye gerek yok
    private Context mContext;

    public ImageAdapter(Context context, List<PhotoItem> images, ItemClickEvent itemClickEvent) {
        mContext = context;
        this.images = images;
        this.itemClickEvent = itemClickEvent;


    }


    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_layout, parent, false);

        ImageViewHolder ImageViewHolder = new ImageViewHolder(itemView, mContext, images);
        return ImageViewHolder;

    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, final int position) {
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


    public interface ItemClickEvent {
        void onItemClicked(int position);
    }
}
