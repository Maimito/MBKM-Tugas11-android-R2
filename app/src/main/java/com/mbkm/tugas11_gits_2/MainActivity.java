package com.mbkm.tugas11_gits_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private CardView mMusicbutton;
    private CardView mVideobutton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMusicbutton = (CardView) findViewById(R.id.musicbutton);
        mVideobutton = (CardView) findViewById(R.id.moviebutton);

        mMusicbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MusicPlayer.class);
                startActivity(intent);
            }
        });

        mVideobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, VideoPlayer.class);
                startActivity(intent);
            }
        });

    }
}