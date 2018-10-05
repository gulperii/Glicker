package tr.org.yga.glicker;

import android.app.Activity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import tr.org.yga.glicker.Api.ApiClient;
import tr.org.yga.glicker.Api.ApiInterface;
import tr.org.yga.glicker.Response.PhotoItem;
import tr.org.yga.glicker.Response.Response;

public class RetrievePhotos {
    String method_inter = "flickr.interestingness.getList";
    String method_info = "flickr.photos.getInfo";
    private List<PhotoItem> photoItems;
    private List<String> urlList = new ArrayList<String>();

    public RetrievePhotos(ApiInterface apiService) {

        requestListFromAPI(apiService);
    }

    public List<PhotoItem> getPhotoItems() {
        return photoItems;
    }

    public List<String> getUrlList() {
        return urlList;
    }

    public void requestListFromAPI(ApiInterface apiService) {
        Call<Response> interestingList = apiService.interestingList(method_inter, "d475314235e52c86ab300fcb4f6501db", "json","1");
        interestingList.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                photoItems = response.body().getPhotos().getPhoto();
                constructURLs(photoItems);

            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
    public void glideDownload (RetrievePhotos retrievePhotos, Activity activity){
        for (String url : urlList)
        Glide.with(activity).load(url);

    }

    public void constructURLs(List<PhotoItem> photoIds) {
// URL format : https://farm{farm-id}.staticflickr.com/{server-id}/{id}_{secret}.jpg
        for (PhotoItem photoItem : photoItems) {
            String constructedUrl = "https://farm" + photoItem.getFarm() + ".staticflickr.com/" + photoItem.getServer() + "/" + photoItem.getId() + "_" + photoItem.getSecret() + ".jpg";
            urlList.add(constructedUrl);
        }
    }


}
/*
    String imgUrl = "https://api.androidhive.info/images/glide/medium/deadpool.jpg";

    ImageView imageView = (ImageView) view.findViewById(R.id.thumbnail);





/*



 */
// Call<tr.org.yga.glicker.PhotoInfo.Response> getInfo= apiService.photoInfo(method_info,"d475314235e52c86ab300fcb4f6501db",)}