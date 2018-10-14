package tr.org.yga.glicker;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import tr.org.yga.glicker.Api.ApiClient;
import tr.org.yga.glicker.Api.ApiInterface;
import tr.org.yga.glicker.PhotoInfo.Response;

public class DisplayActivity extends AppCompatActivity {
    private ProgressDialog progressDoalog;
    private static final String TAG = "DisplayActivity";
    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Log.d(TAG, "onCreate: started");
        progressDoalog = new ProgressDialog(DisplayActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();
        getIncomingIntent();
            }

    private void getIncomingIntent() {

        Log.d(TAG, "getIncomingIntent: checking for incoming intents.");
        if (getIntent().hasExtra("image_id") && getIntent().hasExtra("image_url")) {
            Log.d(TAG, "getIncomingIntent: found intent extras.");
            String imageId = getIntent().getStringExtra("image_id");
            final String imageUrl = getIntent().getStringExtra("image_url");
            ApiInterface apiService_2_2 = ApiClient.getClient().create(ApiInterface.class);
            Call<Response> getPhotoInfo = apiService_2_2.photoInfo("flickr.photos.getInfo", "d475314235e52c86ab300fcb4f6501db", imageId, "json", "1");
            getPhotoInfo.enqueue(new Callback<Response>() {
                @Override
                public void onResponse(Call<tr.org.yga.glicker.PhotoInfo.Response> call, retrofit2.Response<tr.org.yga.glicker.PhotoInfo.Response> response) {
                    String content = response.body().getPhoto().getDescription().toString();
content=content.substring(content.indexOf("=")+1,content.indexOf("}"));
                 setImage(content,imageUrl);
                 progressDoalog.dismiss();
                }

                @Override
                public void onFailure(Call<tr.org.yga.glicker.PhotoInfo.Response> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        }


    }

    private void setImage(String imageContent, String imageUrl) {
        Log.d(TAG, "setImage: setting te image and name to widgets.");
        TextView content = findViewById(R.id.image_content);
        content.setMovementMethod(new ScrollingMovementMethod());


        content.setText(imageContent);

        ImageView image = findViewById(R.id.image_with_content);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);
    }

}



