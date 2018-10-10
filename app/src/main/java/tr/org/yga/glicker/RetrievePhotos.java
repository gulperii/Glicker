package tr.org.yga.glicker;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import tr.org.yga.glicker.Api.ApiInterface;
import tr.org.yga.glicker.Response.PhotoItem;
import tr.org.yga.glicker.Response.Response;

//adaptore photolistitemlist gönder ve hepsini imageview a yüklesin

public class RetrievePhotos {
    String method_inter = "flickr.interestingness.getList";
    String method_info = "flickr.photos.getInfo";
    private List<PhotoItem> photoItems=new ArrayList<PhotoItem>();
    private List<String> urlList = new ArrayList<String>();
    public List<PhotoListItem> getPhotoListItemList() {
        return photoListItemList;
    }

    private List<PhotoListItem> photoListItemList = new ArrayList<>();

    public RetrievePhotos(ApiInterface apiService) {

        requestListFromAPI(apiService);
/*    for (PhotoItem photoItem : photoItems) {
        requestPhotoInfo(apiService, photoItem);
    }
    constructURLs(photoItems);
*/
}

    public List<PhotoItem> getPhotoItems() {
        return photoItems;
    }

    public List<String> getUrlList() {
        return urlList;
    }

    public void requestListFromAPI(final ApiInterface apiService) {
        Call<Response> interestingList = apiService.interestingList(method_inter, "d475314235e52c86ab300fcb4f6501db", "json", "1");
        interestingList.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                photoItems = response.body().getPhotos().getPhoto();
               //TODO: Normalde bu constructordaydı ama on response
                for (PhotoItem photoItem : photoItems) {
                    requestPhotoInfo(apiService, photoItem);
                }
                constructURLs(photoItems);

            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void requestPhotoInfo(ApiInterface apiService, final PhotoItem photoItem) {
        Call<tr.org.yga.glicker.PhotoInfo.Response> getPhotoInfo = apiService.photoInfo(method_info, "d475314235e52c86ab300fcb4f6501db", photoItem.getId(), "json", "1");
        getPhotoInfo.enqueue(new Callback<tr.org.yga.glicker.PhotoInfo.Response>() {
            @Override
            public void onResponse(Call<tr.org.yga.glicker.PhotoInfo.Response> call, retrofit2.Response<tr.org.yga.glicker.PhotoInfo.Response> response) {
                String content = response.body().getPhoto().getDescription().getContent();
                String constructedUrl = "https://farm" + photoItem.getFarm() + ".staticflickr.com/" + photoItem.getServer() + "/" + photoItem.getId() + "_" + photoItem.getSecret() + ".jpg";
                PhotoListItem photoListItem = new PhotoListItem(constructedUrl, content);
                photoListItemList.add(photoListItem);
            }

            @Override
            public void onFailure(Call<tr.org.yga.glicker.PhotoInfo.Response> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }


    public void constructURLs(List<PhotoItem> photoIds) {
// URL format : https://farm{farm-id}.staticflickr.com/{server-id}/{id}_{secret}.jpg
        for (PhotoItem photoItem : photoItems) {
            String constructedUrl = "https://farm" + photoItem.getFarm() + ".staticflickr.com/" + photoItem.getServer() + "/" + photoItem.getId() + "_" + photoItem.getSecret() + ".jpg";
            urlList.add(constructedUrl);
        }
    }
}
 //   ImageView imageView = (ImageView) view.findViewById(R.id.thumbnail);
