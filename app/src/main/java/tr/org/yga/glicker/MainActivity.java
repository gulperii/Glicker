package tr.org.yga.glicker;

import android.app.ProgressDialog;
import android.content.Intent;
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
    // TODO: 15.10.2018 kullanılmayan degıskenlerı ve ımportları temızle (Optimize imports shortcut,ı kullanabilirsin)
    String BASE_URL = " https://api.flickr.com/services";
    private List<PhotoItem> images;
    // TODO: 15.10.2018 Isımlendirmeye dikkat 
    private MyAdapter mAdapter;
    private RecyclerView recyclerView;
    private ProgressDialog progressDoalog;

    // TODO: 15.10.2018  
    /**
     * Paket ısımlerı ufak harfle baslasın
     * databinding'e gecıleceeeeeek
     * git ignore dosyası androide gore düzenlenecek.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // TODO: 15.10.2018 typo 
        progressDoalog = new ProgressDialog(MainActivity.this);
        // TODO: 15.10.2018 Hardcoded string bırakılmayaacaaak 
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

    private void generateDataList(final List<PhotoItem> images) {

        recyclerView = findViewById(R.id.recyclerView);
        // TODO: 15.10.2018 lambda expression acılacaaaaak
        mAdapter = new MyAdapter(getApplicationContext(), images, new MyAdapter.ItemClickEvent() {
            @Override
            public void onItemClicked(int position) {
                // TODO: 15.10.2018 Adapterdan buraya kadar aldım. Devamı sende

                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                String id = images.get(position).getId();
                intent.putExtra("image_id", id);
                intent.putExtra("image_url", images.get(position));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });
        //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);
    }


}





