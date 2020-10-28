package com.example.videoplayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

import com.khizar1556.mkvideoplayer.MKPlayer;

public class MainActivity extends AppCompatActivity {
/* private lateinit var decorView: View
    private var player : MKPlayer?= null
    private val stableUiFlags: Int
        get() = (View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)*/
    private View decorView;
    private MKPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                if (visibility == 0){
                    decorView.setSystemUiVisibility(hideUiBar());
                }
            }
        });
        player = new MKPlayer(this);
        player.play("https://scontent.fmdl1-2.fna.fbcdn.net/v/t66.36240-6/10000000_196090301920825_6342925987280597807_n.mp4?_nc_cat=102&ccb=2&_nc_sid=985c63&efg=eyJ2ZW5jb2RlX3RhZyI6Im9lcF9oZCJ9&_nc_ohc=-k5HErwH7QsAX-hRKmw&_nc_ht=scontent.fmdl1-2.fna&oh=880664881afa4de6a9577d9e2ced6d1d&oe=5FB744D5");

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus)
            decorView.setSystemUiVisibility(hideUiBar());
    }

    private int hideUiBar(){
        return View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        | View.SYSTEM_UI_FLAG_FULLSCREEN
        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN ;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (player != null){
            player.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(player != null)
            player.pause();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (player != null) {
            player.onDestroy();
        }
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (player != null){
            player.onConfigurationChanged(newConfig);
        }
    }
}