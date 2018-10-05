package tr.org.yga.glicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import tr.org.yga.glicker.Api.ApiClient;
import tr.org.yga.glicker.Api.ApiInterface;

public class MainActivity extends AppCompatActivity {
    String BASE_URL = " https://api.flickr.com/services";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
           }
}

