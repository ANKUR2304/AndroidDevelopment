package com.example.musicplayer;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final int SEEK_FORWARD_TIME = 10000; // 10 seconds
    private ProgressBar progressBar;
    private ImageButton playPauseBtn;
    private ImageButton seekForwardBtn;
    private ImageButton replayToBtn;
    private Handler handler = new Handler();

    boolean isPlaying;

    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        playPauseBtn = findViewById(R.id.playPauseBtn);
        seekForwardBtn = findViewById(R.id.seekForwardBtn);
        replayToBtn = findViewById(R.id.replayToBtn);
        mediaPlayer = MediaPlayer.create(this, R.raw.king);

        progressBar = findViewById(R.id.progressBar);

        playPauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    isPlaying = false;
                    //Toast.makeText(getApplicationContext(), "isPlaying = " + isPlaying, Toast.LENGTH_SHORT).show();
                    playPauseBtn.setImageResource(R.drawable.baseline_play_arrow_24);
                }
                else{
                    mediaPlayer.start();
                    isPlaying = true;
                    //Toast.makeText(getApplicationContext(), "isPlaying = " + isPlaying, Toast.LENGTH_SHORT).show();
                    playPauseBtn.setImageResource(R.drawable.baseline_pause_24);
                }
            }
        });

        seekForwardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveForward();
            }
        });

        replayToBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replayTo();
            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopAudio();
            }
        });

        // Update the progress bar
        updateProgressBar();
    }

    private void stopAudio() {
        mediaPlayer.stop();
        mediaPlayer.reset();
        mediaPlayer.release();
        MediaPlayer.create(this, R.raw.king);
        playPauseBtn.setImageResource(R.drawable.baseline_play_arrow_24);
        progressBar.setProgress(0);
    }

    private void updateProgressBar() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mediaPlayer != null && isPlaying) {
                    int currentPosition = mediaPlayer.getCurrentPosition();
                    int totalDuration = mediaPlayer.getDuration();
                    int progress = (int) (((float) currentPosition / totalDuration) * 100);
                    progressBar.setProgress(progress);
                }
                handler.postDelayed(this, 500);
            }
        }, 500);
    }

    private void moveForward() {
        if (mediaPlayer != null) {
            int currentPosition = mediaPlayer.getCurrentPosition();
            int duration = mediaPlayer.getDuration();

            // Check if it's possible to move forward
            int newPos = Math.min(currentPosition + SEEK_FORWARD_TIME, duration);
            mediaPlayer.seekTo(newPos);
        }
    }

    private void replayTo() {
        if (mediaPlayer != null) {
            int currentPosition = mediaPlayer.getCurrentPosition();

            // Check if it's possible to move backward
            int newPos = Math.max(currentPosition - SEEK_FORWARD_TIME, 0);
            mediaPlayer.seekTo(newPos);
        }
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}

