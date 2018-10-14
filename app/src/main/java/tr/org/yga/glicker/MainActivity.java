package tr.org.yga.glicker;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import tr.org.yga.glicker.Adapter.MyAdapter;
import tr.org.yga.glicker.Api.ApiClient;
import tr.org.yga.glicker.Api.ApiInterface;
import tr.org.yga.glicker.Response.PhotoItem;
import tr.org.yga.glicker.Response.Photos;
import tr.org.yga.glicker.Response.Response;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class MainActivity extends AppCompatActivity {
    String BASE_URL = " https://api.flickr.com/services";
    private List<PhotoItem> images;
    private MyAdapter mAdapter;
    private RecyclerView recyclerView;
    private ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDoalog = new ProgressDialog(MainActivity.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Response> interestingList = apiService.interestingList("flickr.interestingness.getList", "d475314235e52c86ab300fcb4f6501db", "json", "1");
        interestingList.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {


                images = response.body().getPhotos().getPhoto();
                generateDataList(images);
                progressDoalog.dismiss();

            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }

    private void generateDataList(List<PhotoItem> images) {
        recyclerView = findViewById(R.id.recyclerView);
        mAdapter = new MyAdapter(getApplicationContext(), images);
        //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);
    }


}





