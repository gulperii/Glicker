package tr.org.yga.glicker.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import tr.org.yga.glicker.R;
import tr.org.yga.glicker.holder.ImageViewHolder;
import tr.org.yga.glicker.interestingPhotos.PhotoItem;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class ImageAdapter extends RecyclerView.Adapter<ImageViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    private final ItemClickEvent itemClickEvent;
    private List<PhotoItem> images;
    // DONE: 15.10.2018 Context gecmeye gerek yok
    private Context mContext;
    ImageViewHolder imageViewHolder;

    public ImageAdapter(List<PhotoItem> images, ItemClickEvent itemClickEvent) {
        this.images = images;
        this.itemClickEvent = itemClickEvent;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_album, parent, false);
        imageViewHolder = new ImageViewHolder(itemView, mContext, images);
        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, final int position) {
        PhotoItem image = images.get(position);
        final String constructedUrl = "https://farm" + image.getFarm() + ".staticflickr.com/" + image.getServer() + "/" + image.getId() + "_" + image.getSecret() + ".jpg";
        Glide.with(holder.context).load(constructedUrl).
                thumbnail(0.5f).
                transition(withCrossFade()).
                into(holder.thumbnail);
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: 15.10.2018

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
