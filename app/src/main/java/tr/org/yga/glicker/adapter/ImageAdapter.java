package tr.org.yga.glicker.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import tr.org.yga.glicker.databinding.AdapterAlbumBinding;
import tr.org.yga.glicker.holder.ImageViewHolder;
import tr.org.yga.glicker.interestingPhotos.PhotoItem;

public class ImageAdapter extends RecyclerView.Adapter<ImageViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    private final ItemClickEvent itemClickEvent;
    private List<PhotoItem> images;
    private AdapterAlbumBinding binding;

    public ImageAdapter(List<PhotoItem> images, ItemClickEvent itemClickEvent) {
        this.images = images;
        this.itemClickEvent = itemClickEvent;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        binding = AdapterAlbumBinding.inflate(layoutInflater, parent, false);
        binding.setClickEvent(itemClickEvent);
        return new ImageViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, final int position) {
        PhotoItem image = images.get(position);
        final String constructedUrl = "https://farm" + image.getFarm() + ".staticflickr.com/" + image.getServer() + "/" + image.getId() + "_" + image.getSecret() + ".jpg";
        image.setImageUrl(constructedUrl);
        holder.setItem(image);

    }

    @Override
    public int getItemCount() {
        return images.size();
    }


    public interface ItemClickEvent {
        void onItemClicked(int position);
    }
}
