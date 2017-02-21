package appbar.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class AlphaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alpha);

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.title_layout);

        //relativeLayout.getBackground().setAlpha(0);//透明度初始化为0
    }

}
