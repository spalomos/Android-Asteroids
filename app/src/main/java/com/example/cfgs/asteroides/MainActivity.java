package com.example.cfgs.asteroides;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import java.io.File;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity{

    Button playButton;
    Button laderBoardButton;
    Button exitButton;
    ImageView title;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVars();
        //setBackground();
        setTitle();
        setButtonColors();
    }

    private void setTitle() {

        final Runnable r = new Runnable() {
            public void run() {
                String titleS = "";
                for (int i = 1; i < 21; i++) {

                    title.setBackgroundResource(getResources().getIdentifier(titleS, "drawable", getPackageName()));

                }
                handler.postDelayed(this, 1000);
            }
        };

        System.out.println("1");
        handler.postDelayed(r, 1000);

    }

    private void setBackground() {
        VideoView videoview = (VideoView) findViewById(R.id.background);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.background);
        videoview.setVideoURI(uri);
        //RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) videoview.getLayoutParams();
        //lp.addRule(RelativeLayout.);
        videoview.setMinimumWidth(9000);
        videoview.setMinimumHeight(9000);
        videoview.start();
        videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                setBackground();
            }
        });
    }

    private void initVars() {
        handler = new Handler();
        title = (ImageView) findViewById(R.id.title);
        playButton = (Button) findViewById(R.id.playButton);
        laderBoardButton = (Button) findViewById(R.id.laderBoardButton);
        exitButton = (Button) findViewById(R.id.exitButton);
    }

    private void setButtonColors() {

    }

    public int getId(String titleS) {
        return getResources().getIdentifier(titleS, "drawable", getPackageName());
    }
}
