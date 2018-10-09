package tr.org.yga.glicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import tr.org.yga.glicker.Adapter.MyAdapter;
import tr.org.yga.glicker.Api.ApiClient;
import tr.org.yga.glicker.Api.ApiInterface;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class MainActivity extends AppCompatActivity {
    String BASE_URL = " https://api.flickr.com/services";
    private List<PhotoListItem> images;
    private MyAdapter mAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        RetrievePhotos retrievePhotos = new RetrievePhotos(apiService);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        ImageView iv= findViewById(R.id.thumbnail);
        images = retrievePhotos.getPhotoListItemList();
        Glide.with(this).load(images.get(0).getUrl()).
                thumbnail(0.5f).
                transition(withCrossFade()).
                into(iv);

        /*
        mAdapter = new MyAdapter(getApplicationContext(), images);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
*/

    }


}


