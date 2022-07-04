package com.example.kuranikerimm.oynatmaekranlari;

import android.os.Bundle;

import com.example.kuranikerimm.R;
import com.example.kuranikerimm.ses_listesi.nassar;
import com.example.kuranikerimm.ses_listesi.ses_liste_ekrani;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class videoplayer extends YouTubeBaseActivity {

   private YouTubePlayerView youTubePlayerView;
   private  YouTubePlayer.OnInitializedListener onInitializedListener;
    String  API_KEY = "AIzaSyCsHMHOulMFpcaZRp82lyhN6eLZ4z2bm2Q" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videoplayer);

        youTubePlayerView = findViewById(R.id.youtube_view);
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                     youTubePlayer.loadVideo(nassar.nassarvideo);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
                youTubePlayerView.initialize(API_KEY, onInitializedListener);


    }
}