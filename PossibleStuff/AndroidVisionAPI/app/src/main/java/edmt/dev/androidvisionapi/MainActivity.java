package edmt.dev.androidvisionapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.microsoft.projectoxford.vision.VisionServiceClient;
public class MainActivity extends AppCompatActivity {
    public VisionServiceClient = new VisionServiceRestClient("");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
