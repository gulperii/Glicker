package tr.org.yga.glicker.holder;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import tr.org.yga.glicker.databinding.AdapterAlbumBinding;
import tr.org.yga.glicker.interestingPhotos.PhotoItem;

public class ImageViewHolder extends RecyclerView.ViewHolder {
    public ImageView thumbnail;
    private final AdapterAlbumBinding binding;

    public ImageViewHolder(AdapterAlbumBinding binding) {
        super(binding.getRoot());
        this.binding=binding;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void setItem(PhotoItem image) {
        binding.setPhoto(image);
        binding.setPosition(getLayoutPosition());
    }

}
