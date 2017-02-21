package appbar.com;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    //
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void goToSecondActivity(View view){
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());

    }

    public void goAlphaActivity(View view){
        //Toast.makeText(this,"alpha",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,AlphaActivity.class);
        startActivity(intent);
    }
}
