package com.mbkm.tugas11_gits_2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MusicPlayer extends AppCompatActivity {

    private Button mPlay;
    private Button mPause;
    private Button mStop;
    private Button mPlay2;
    private Button mPause2;
    private Button mStop2;
    private Button mPlay3;
    private Button mPause3;
    private Button mStop3;




    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
        setTitle("Music Player");

        mPlay = (Button) findViewById(R.id.play);
        mPause = (Button) findViewById(R.id.pause);
        mStop = (Button) findViewById(R.id.stop);
        mPlay2 = (Button) findViewById(R.id.play2);
        mPause2 = (Button) findViewById(R.id.pause2);
        mStop2 = (Button) findViewById(R.id.stop2);
        mPlay3 = (Button) findViewById(R.id.play3);
        mPause3 = (Button) findViewById(R.id.pause3);
        mStop3 = (Button) findViewById(R.id.stop3);

        mPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playAudio();
                mPlay2.setEnabled(false);
                mPause2.setEnabled(false);
                mStop2.setEnabled(false);
                mPlay3.setEnabled(false);
                mPause3.setEnabled(false);
                mStop3.setEnabled(false);
            }
        });
        mPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pauseAudio();
            }
        });
        mStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAudio();
                stateAwal2();
                stateAwal3();
            }
        });

        mPlay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playAudio2();
                mPlay.setEnabled(false);
                mPause.setEnabled(false);
                mStop.setEnabled(false);
                mPlay3.setEnabled(false);
                mPause3.setEnabled(false);
                mStop3.setEnabled(false);
            }
        });
        mPause2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pauseAudio2();
            }
        });
        mStop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAudio2();
                stateAwal1();
                stateAwal3();
            }
        });

        mPlay3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playAudio3();
                mPlay2.setEnabled(false);
                mPause2.setEnabled(false);
                mStop2.setEnabled(false);
                mPlay.setEnabled(false);
                mPause.setEnabled(false);
                mStop.setEnabled(false);
            }
        });
        mPause3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pauseAudio3();
            }
        });
        mStop3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAudio3();
                stateAwal1();
                stateAwal2();
            }
        });

        stateAwal1();
        stateAwal2();
        stateAwal3();
    }


    private void stateAwal1(){
        mPlay.setEnabled(true);
        mPause.setEnabled(false);
        mStop.setEnabled(false);
    }
    private void stateAwal2(){
        mPlay2.setEnabled(true);
        mPause2.setEnabled(false);
        mStop2.setEnabled(false);
    }
    private void stateAwal3(){
        mPlay3.setEnabled(true);
        mPause3.setEnabled(false);
        mStop3.setEnabled(false);
    }

    // start of playAudio method

    private void playAudio(){
        mediaPlayer = MediaPlayer.create(this, R.raw.music1);
        mPlay.setEnabled(false);
        mPause.setEnabled(true);
        mStop.setEnabled(true);

        try{
            mediaPlayer.prepare();
        }catch (IllegalStateException ex){
            ex.printStackTrace();
        }catch (IOException ex1){
            ex1.printStackTrace();
        }
        mediaPlayer.start();

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal1();
            }
        });
    }

    private void playAudio2(){
        mediaPlayer = MediaPlayer.create(this, R.raw.music2);
        mPlay2.setEnabled(false);
        mPause2.setEnabled(true);
        mStop2.setEnabled(true);

        try{
            mediaPlayer.prepare();
        }catch (IllegalStateException ex){
            ex.printStackTrace();
        }catch (IOException ex1){
            ex1.printStackTrace();
        }
        mediaPlayer.start();

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal2();
            }
        });
    }

    private void playAudio3(){
        mediaPlayer = MediaPlayer.create(this, R.raw.music3);
        mPlay3.setEnabled(false);
        mPause3.setEnabled(true);
        mStop3.setEnabled(true);

        try{
            mediaPlayer.prepare();
        }catch (IllegalStateException ex){
            ex.printStackTrace();
        }catch (IOException ex1){
            ex1.printStackTrace();
        }
        mediaPlayer.start();

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal2();
            }
        });
    }

    // end of playAudio method
    // start of pauseAudio method

    private void pauseAudio(){
        if(mediaPlayer.isPlaying()){
            if(mediaPlayer != null){
                mediaPlayer.pause();
                mPause.setText("Resume");
            }
        } else {
            if(mediaPlayer != null){
                mediaPlayer.start();
                mPause.setText("Pause");
            }
        }
    }

    private void pauseAudio2(){
        if(mediaPlayer.isPlaying()){
            if(mediaPlayer != null){
                mediaPlayer.pause();
                mPause2.setText("Resume");
            }
        } else {
            if(mediaPlayer != null){
                mediaPlayer.start();
                mPause2.setText("Pause");
            }
        }
    }

    private void pauseAudio3(){
        if(mediaPlayer.isPlaying()){
            if(mediaPlayer != null){
                mediaPlayer.pause();
                mPause3.setText("Resume");
            }
        } else {
            if(mediaPlayer != null){
                mediaPlayer.start();
                mPause3.setText("Pause");
            }
        }
    }

    // end of pauseAudio method
    // start of stopAudio method

    private void stopAudio(){
        mediaPlayer.stop();
        try {
            mediaPlayer.prepare();
            mediaPlayer.seekTo(0);
        } catch (Throwable t){
            t.printStackTrace();
        }
        stateAwal1();
    }

    private void stopAudio2(){
        mediaPlayer.stop();
        try {
            mediaPlayer.prepare();
            mediaPlayer.seekTo(0);
        } catch (Throwable t){
            t.printStackTrace();
        }
        stateAwal2();
    }

    private void stopAudio3(){
        mediaPlayer.stop();
        try {
            mediaPlayer.prepare();
            mediaPlayer.seekTo(0);
        } catch (Throwable t){
            t.printStackTrace();
        }
        stateAwal3();
    }

}