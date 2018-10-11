package tr.org.yga.glicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {
    private static final String TAG = "DisplayActivity";
ImageView imageView;
TextView  textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Log.d(TAG,"onCreate: started");
        imageView=findViewById(R.id.image_preview);
        textView=findViewById(R.id.content_display);
        imageView.setImageResource(getIntent().getIntExtra("image_id",00));
       // textView.setText();
//TODO:
    }
}
