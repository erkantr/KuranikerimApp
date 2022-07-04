package com.example.kuranikerimm.oynatmaekranlari;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NavUtils;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.kuranikerimm.R;
import com.example.kuranikerimm.User;
import com.example.kuranikerimm.ses_listesi.nassar;
import com.example.kuranikerimm.ui.indirilenler.indirilenler;
import com.google.android.material.snackbar.Snackbar;

import java.io.File;
import java.util.ArrayList;

import static com.example.kuranikerimm.ses_listesi.nassar.nassarses;
import static com.example.kuranikerimm.ui.indirilenler.indirilenler.ses;

public class sesplayer extends AppCompatActivity {
    Bundle songExtraData;
    ArrayList<String> songList;
    ArrayList<File> songFileList;
    SeekBar seekBar;
    Button play;
    Button prev;
    String a;
    Button next;
    ConstraintLayout constraintLayout;
    int pausePosition;
   public static TextView sureisim;
    int totalTime;
    TextView zaman1;
    TextView zaman2;
    MediaPlayer mediaPlayer;
    public static MediaPlayer media2;
    public static int ileri = 1;
    public static int d = 0;
    public static int dialog1;
    String indirilecekDosyaYolu;
    User user;
    public static ImageView img;

    // @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesplayer);
        //ConnectivityManager conMgr = (ConnectivityManager) sesplayer.this.getSystemService(Context.CONNECTIVITY_SERVICE);
        seekBar = findViewById(R.id.seekBar);
        play = findViewById(R.id.play);
        zaman1 = findViewById(R.id.zaman1);
        zaman2 = findViewById(R.id.zaman2);
        sureisim = findViewById(R.id.sureisim);
        prev = findViewById(R.id.prev);
        next = findViewById(R.id.next);
        img = findViewById(R.id.imageView2);
        dialog1 = 0;
        Intent intent = getIntent();
        String url =intent.getStringExtra("url");
        mediaPlayer = MediaPlayer.create(sesplayer.this,Uri.parse(url));
        // if (indirilenler.ses == 1) {
        // Intent songData = getIntent();
        //songExtraData = songData.getExtras();
        //sureisim.setText(isimlerr[surepozisyonu]);
        //CharSequence gelenyazi = gelenveri.getCharSequence("isim");
        //Toast.makeText(sesplayer.this,gelenyazi, Toast.LENGTH_SHORT).show();
       // Intent intent = getIntent();
        //if (intent.getExtras() !=null){
            //user = (User) intent.getSerializableExtra("item");
           //sureisim.setText(user.getUserName());
           /* switch (isimlerr[1]){
                case  "Fâtiha":
                    nassarses = nasser0;
                    break;
                case "Bakara":
                    nassarses = nasser1;
                    break;
                case "Âl-i İmrân":
                    nassarses = nasser2;
                    break;
                case "Nisâ":
                    nassarses = nasser3;
                    break;
                case "Mâide":
                    nassarses =nasser4;
                    break;
                    */
           // }
       // }
        //assert songExtraData != null;
        //songFileList = (ArrayList) songExtraData.getParcelableArrayList("songFileList");
        //int position = songExtraData.getInt("position", 0);
        //assert songFileList != null;
        //initSurePlayer(position);
        if (ses ==1){
            indirilenler.initSurePlayer(indirilenler.pozisyon, sesplayer.this);
            sureisim.setText(indirilenler.indirilenlerisim);
        }

        // }
        if (ses ==0){
            //media1 = MediaPlayer.create(sesplayer.this, Uri.parse(nasser0));
        if (mediaPlayer != null) {
            mediaPlayer.start();
//            Toast.makeText(this, user.getUserName(), Toast.LENGTH_SHORT).show();
        }
        }


        //play.setOnClickListener((View.OnClickListener) this);
        //next.setOnClickListener(this);
//        media1.setLooping(true);
        if (mediaPlayer != null) {
            mediaPlayer.setLooping(true);
            mediaPlayer.seekTo(0);
            totalTime = mediaPlayer.getDuration();
            seekBar.setMax(totalTime);
            //}else { if (conMgr.getActiveNetworkInfo() != null && conMgr.getActiveNetworkInfo().isAvailable() && conMgr.getActiveNetworkInfo().isConnected()){
            //       nassar.internet = 1;
        } else {
            nassar.internet = 0;
            //}
        }

        //if (internet == 0){

        //Toast toast =  Toast.makeText(sesplayer.this, "Bağlantı Zaman Aşımına Uğradı", 2800);
        //View toastView = toast.getView();
        //toastView.setBackgroundResource(R.drawable.toastmessage);
        //toast.show();

        //}


        seekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        if (fromUser) {
                            mediaPlayer.seekTo(progress);
                            seekBar.setProgress(progress);
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }


        );
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mediaPlayer != null) {
                    try {
                        Message msg = new Message();
                        msg.what = mediaPlayer.getCurrentPosition();
                        handler.sendMessage(msg);
                        Thread.sleep(1000);

                    } catch (InterruptedException e) {
                    }
                }
            }
        }).start();

        Button indir = findViewById(R.id.indir);
        indir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // new DownloadTask(sesplayer.this, nassarses);
                String dosyadi;
                indirilecekDosyaYolu = nassarses;
                dosyadi = indirilecekDosyaYolu.replace("https://ia601401.us.archive.org/29/items/sureler/", "");
                String url = indirilecekDosyaYolu;
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
                request.setDescription(dosyadi);
                request.setTitle("Kur'an-ı Kerim");

                //dosyayı yazacağımız yer ve dosyanın ismine karar verebiliyoruz.
                 request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, dosyadi);

                //download servisini çalıştırma ve kuyruğa alması
                DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                manager.enqueue(request);
            }
        });

        ImageView geri = findViewById(R.id.geri);
        geri.setOnClickListener(new View.OnClickListener() {
            private short sesplayer;

            @Override
            public void onClick(View v) {
                // finishActivity(sesplayer);
                NavUtils.navigateUpFromSameTask(sesplayer.this);
                //loadingDialog.dismissDialog();
                return;
            }

        });

        Button button = findViewById(R.id.next);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newintent = new Intent(sesplayer.this, sesplayer.class);
                ileri = 0;
                startActivity(newintent);
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer == null) {
                    Snackbar.make(v, "İnternet Bağlantınızı Kontrol Edin.", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    if (!mediaPlayer.isPlaying()) {
                        mediaPlayer.start();
                        play.setBackgroundResource(R.drawable.pause);
                    } else {
                        mediaPlayer.pause();
                        play.setBackgroundResource(R.drawable.play);
                    }
                }

            }
        });

    }
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            int currentPosition = msg.what;
            seekBar.setProgress(currentPosition);

            String zamann1 = createTimeLabel(currentPosition);
            zaman1.setText(zamann1);

            String remainingTime = createTimeLabel(totalTime - currentPosition);
            zaman2.setText("- " + remainingTime);
        }
    };

    public String createTimeLabel(int time) {
        String timeLabel = "";
        int min = time / 1000 / 60;
        int hour = time / 1000 / 60 / 60;
        int sec = time / 1000 % 60;
        int min1 = time / 1000 / 60 - 60;

        timeLabel = min + ":";
        if (min > 60) timeLabel = hour + ":" + min1 + ":";
        if (sec < 10) timeLabel += "0";
        timeLabel += sec;

        return timeLabel;

    }

    //@Override
    /*public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play:
                if (media1 == null) {
                    Snackbar.make(v, "İnternet Bağlantınızı Kontrol Edin.", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    if (!media1.isPlaying()) {
                        media1.start();
                        play.setBackgroundResource(R.drawable.pause);
                    } else {
                        media1.pause();
                        play.setBackgroundResource(R.drawable.play);
                    }
                }
        }
    } */
}
