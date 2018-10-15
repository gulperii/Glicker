package tr.org.yga.glicker;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import tr.org.yga.glicker.adapter.ImageAdapter;
import tr.org.yga.glicker.api.ApiClient;
import tr.org.yga.glicker.api.ApiInterface;
import tr.org.yga.glicker.interestingPhotos.PhotoItem;
import tr.org.yga.glicker.interestingPhotos.Response;

public class MainActivity extends AppCompatActivity {
    // DONE: 15.10.2018 kullanılmayan degıskenlerı ve ımportları temızle
    private List<PhotoItem> images;
    // TODO: 15.10.2018 Isımlendirmeye dikkat 
    private ImageAdapter mAdapter;
    private RecyclerView recyclerView;
    private ProgressDialog progressDialog;

    //DONE: 15.10.2018 : Paket isimleri ufak harfle başlasın
    //TODO: databinding e gecileceeeek
    //TODO: git ignore dosyası androide göre düzenlenecek

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // DONE: 15.10.2018 typo
        progressDialog = new ProgressDialog(MainActivity.this);
        // TODO: 15.10.2018 Hardcoded string bırakılmayaacaaak 
        progressDialog.setMessage("Loading....");
        progressDialog.show();
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Response> interestingList = apiService.interestingList("flickr.interestingness.getList", "d475314235e52c86ab300fcb4f6501db", "json", "1");
        interestingList.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {


                images = response.body().getPhotos().getPhoto();
                generateDataList(images);
                progressDialog.dismiss();

            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }

    private void generateDataList(final List<PhotoItem> images) {

        recyclerView = findViewById(R.id.recyclerView);
        // TODO: 15.10.2018 lambda expression acılacaaaaak
        mAdapter = new ImageAdapter(getApplicationContext(), images, new ImageAdapter.ItemClickEvent() {
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





