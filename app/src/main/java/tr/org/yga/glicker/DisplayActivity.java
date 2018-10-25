package tr.org.yga.glicker;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import tr.org.yga.glicker.api.ApiClient;
import tr.org.yga.glicker.api.ApiInterface;
import tr.org.yga.glicker.databinding.ActivityDisplayBinding;
import tr.org.yga.glicker.photoInfo.Response;

public class DisplayActivity extends AppCompatActivity {
    private ProgressDialog progressDialog;
    private static final String TAG = "DisplayActivity";
    private ActivityDisplayBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_display);

        Log.d(TAG, "onCreate: started");
        progressDialog = new ProgressDialog(DisplayActivity.this);
        progressDialog.setMessage(getString(R.string.loading_warning));
        progressDialog.show();
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
                public void onResponse(Call<tr.org.yga.glicker.photoInfo.Response> call, retrofit2.Response<tr.org.yga.glicker.photoInfo.Response> response) {
                    String content = response.body().getPhoto().getDescription().toString();
                    content = content.substring(content.indexOf("=") + 1, content.indexOf("}"));
                    setImage(content, imageUrl);
                    progressDialog.dismiss();
                }

                @Override
                public void onFailure(Call<tr.org.yga.glicker.photoInfo.Response> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        }


    }

    private void setImage(String imageContent, String imageUrl) {
        Log.d(TAG, "setImage: setting the image and name to widgets.");
        TextView content = findViewById(R.id.imageContent);
        content.setText(imageContent);
        binding.setPhotoUrl(imageUrl);

    }
}



