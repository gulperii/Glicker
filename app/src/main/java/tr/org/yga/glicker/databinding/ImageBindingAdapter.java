package tr.org.yga.glicker.databinding;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageBindingAdapter {
    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView imageView, String imageUrl) {
            Glide.with(imageView.getContext())
                    .asBitmap()
                    .load(imageUrl)
                    .into(imageView);
        }


}
