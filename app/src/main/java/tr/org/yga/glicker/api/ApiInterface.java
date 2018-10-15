package tr.org.yga.glicker.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import tr.org.yga.glicker.interestingPhotos.Response;

public interface ApiInterface {
    @GET("rest/")
    Call<Response> interestingList(@Query("method") String method_name, @Query("api_key") String api_key, @Query("format") String format,@Query("nojsoncallback") String jsoncallback);

    @GET("rest/")
    Call<tr.org.yga.glicker.photoInfo.Response> photoInfo(@Query("method") String method_name, @Query("api_key") String api_key, @Query("photo_id") String photo_id, @Query("format") String format, @Query("nojsoncallback") String jsoncallback);
}
