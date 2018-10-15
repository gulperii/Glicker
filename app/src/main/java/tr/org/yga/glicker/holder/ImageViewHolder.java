package tr.org.yga.glicker.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import tr.org.yga.glicker.R;
import tr.org.yga.glicker.interestingPhotos.PhotoItem;
// DONE: 15.10.2018 MyVıewHolder oooooolmmaaaaaaazz

public class ImageViewHolder extends RecyclerView.ViewHolder{
    // DONE: 15.10.2018 Bunu ayrı bır class olarak tanımla
        public ImageView thumbnail;
        // DONE: 15.10.2018 degıskenler camelCase olaacaaaaaaak
        TextView imageContent;
        RelativeLayout parentLayout;
        Context context;
        // TODO: 15.10.2018  Burası da databındıng
        public ImageViewHolder(View view, Context context, List<PhotoItem> images) {
            super(view);
            thumbnail = view.findViewById(R.id.thumbnail);
            this.context = context;
            parentLayout = view.findViewById(R.id.album_layout);
        }

}
