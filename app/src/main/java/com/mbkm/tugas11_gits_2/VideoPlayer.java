package com.mbkm.tugas11_gits_2;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayer extends AppCompatActivity {

    private VideoView mVideo;
    private Button mVideo1, mVideo2, mVideo3;
    private MediaController mediaController;
    private Uri video1, video2, video3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        setTitle("Video Player");

        mVideo = (VideoView) findViewById(R.id.video);
        mVideo1 = (Button) findViewById(R.id.video1);
        mVideo2 = (Button) findViewById(R.id.video2);
        mVideo3 = (Button) findViewById(R.id.video3);

        video1 = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video1);
        video2 = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video2);
        video3 = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video3);

        mediaController = new MediaController(this);

        mVideo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo1();
            }
        });

        mVideo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo2();
            }
        });

        mVideo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo3();
            }
        });

    }

    private void playVideo1(){
        mVideo.stopPlayback();
        mVideo.setVideoURI(video1);
        play();
    }

    private void playVideo2(){
        mVideo.stopPlayback();
        mVideo.setVideoURI(video2);
        play();
    }

    private void playVideo3(){
        mVideo.stopPlayback();
        mVideo.setVideoURI(video3);
        play();
    }

    private void play(){
        mVideo.setMediaController(mediaController);
        mediaController.setAnchorView(mVideo);
        mVideo.start();
    }

}