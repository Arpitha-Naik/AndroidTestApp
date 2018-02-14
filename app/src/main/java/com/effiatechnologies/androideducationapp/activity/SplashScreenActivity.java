package com.effiatechnologies.androideducationapp.activity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.effiatechnologies.androideducationapp.R;


public class SplashScreenActivity extends AppCompatActivity {

  //  private static final String TAG = "splash";
    private ProgressBar mProgressBar = null;
    private AlertDialog.Builder builder = null;
    private Intent intent = null;
    private String userName = null;
    private String roleIds = null;
    private BroadcastReceiver mRegistrationBroadcastReceiver;
    private String regId;
    private String currentVersion;
    private ImageView imgSplash = null;
    private Button btnNext;
    private String roleDescription = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
       // Log.d(TAG, "inside oncreate");

        imgSplash = (ImageView) findViewById(R.id.imgSplash);
        btnNext = findViewById(R.id.eduApp_btn_Next);

        AnimationSet animation = new AnimationSet(true);
        animation.addAnimation(new AlphaAnimation(0.0F, 1.0F));
        animation.addAnimation(new ScaleAnimation(0.0f, 1, 0.0f, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)); // Change args as desired
        animation.setDuration(1500);
        imgSplash.startAnimation(animation);

        builder = new AlertDialog.Builder(this);

       //  Log.d(TAG, roleDescription + "Stored roleDescription is");
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentSplash = new Intent(SplashScreenActivity.this, MainNavigationActivity.class);
                startActivity(intentSplash);
                finish();
            }
        });
    }

}
