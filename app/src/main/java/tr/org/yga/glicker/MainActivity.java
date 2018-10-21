package tr.org.yga.glicker;

import android.app.ProgressDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
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
    // DONE: 15.10.2018 Isımlendirmeye dikkat
    private ImageAdapter imageAdapter;
    private RecyclerView recyclerView;
    private ProgressDialog progressDialog;
     //DONE: _ Merte haber verilecek <<snake_case kebab-case>>
    //DONE: 15.10.2018 : Paket isimleri ufak harfle başlasın
    //TODO: databinding e gecileceeeek
    //DONE: git ignore dosyası androide göre düzenlenecek

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // DONE: 15.10.2018 typo
        progressDialog = new ProgressDialog(MainActivity.this);
        // DONE: 15.10.2018 Hardcoded string bırakılmayaacaaak
        progressDialog.setMessage(getString(R.string.loading_warning));
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
                Toast.makeText(MainActivity.this, getString(R.string.loading_error), Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }

    private void generateDataList(final List<PhotoItem> images) {

        recyclerView = findViewById(R.id.recyclerView);
        // TODO: 15.10.2018 lambda expression acılacaaaaak
        imageAdapter = new ImageAdapter(images, new ImageAdapter.ItemClickEvent() {
            @Override
            public void onItemClicked(int position) {
                // DONE: 15.10.2018 Adapterdan buraya kadar aldım. Devamı sende
                String constructedUrl = "https://farm" + images.get(position).getFarm() + ".staticflickr.com/" + images.get(position).getServer() + "/" + images.get(position).getId() + "_" + images.get(position).getSecret() + ".jpg";
                String id = images.get(position).getId();
                Intent intent = new Intent(getApplicationContext(), DisplayActivity.class);
                intent.putExtra("image_id", id);
                intent.putExtra("image_url", constructedUrl);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getApplicationContext().startActivity(intent);

            }
        });

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(imageAdapter);
    }


}





