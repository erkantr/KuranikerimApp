package com.example.kuranikerimm.ui.indirilenler;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.kuranikerimm.CustomAdapter;
import com.example.kuranikerimm.R;
import com.example.kuranikerimm.User;
import com.example.kuranikerimm.indirilenler_listesi;
import com.example.kuranikerimm.oynatmaekranlari.sesplayer;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.example.kuranikerimm.ses_listesi.nassar.mediaPlayer;

public class indirilenler extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    ListView allsoundlist;
    ArrayAdapter<String> sureArrayAdapter;
    String sesler[];
    public static ArrayList<File> sureler;
    public static int ses;
   List<indirilenler_listesi> indirilenler_listesi = new ArrayList<indirilenler_listesi>();
    final List<User> users = new ArrayList<User>();
   public static int pozisyon;
   public static String indirilenlerisim;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        allsoundlist = root.findViewById(R.id.allsoundfiles);
        CustomAdapter.a = 5;
        ses = 1;
        //Intent player = new Intent(getActivity(), sesplayer.class);
        //player.putExtra("songFileList",sureler);
        Dexter.withActivity(getActivity()).withPermission(Manifest.permission.READ_EXTERNAL_STORAGE).withListener(new PermissionListener() {
            @Override
            public void onPermissionGranted(PermissionGrantedResponse response) {
                //Environment.getExternalStorageState(new File("Downloads"));
                sureler =findSoundFiles(Environment.getExternalStorageDirectory());
                sesler = new String[sureler.size()];


                for (int i =0; i<sureler.size();i++){
                    sesler[i] = sureler.get(i).getName();
                }
               //CustomAdapter adapter = new CustomAdapter(getActivity(), users);
                //allsoundlist.setAdapter(adapter);
                //sureArrayAdapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,sesler);
                //allsoundlist.setAdapter(sureArrayAdapter);
                //users.add(new User("Fâtiha","fatiha Fatiha FATİHA FATIHA", true));
                //sureArrayAdapter = new ArrayAdapter<>(getActivity(), R.layout.anatasarim, sesler);
                //allsoundlist.setAdapter(sureArrayAdapter);

                allsoundlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent player = new Intent(getActivity(), sesplayer.class);
                        startActivity(player);
                       // player.putExtra("songFileList",sureler);
                        pozisyon = position;
                        //player.putExtra("position",position);

                    }
                });
            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse response) {

            }

            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
token.continuePermissionRequest();
            }
        }).check();

        return root;
    }

    private ArrayList<File> findSoundFiles(File user) {
       // ArrayList<File> asa = new ArrayList<indirilenler_listesi>();
        ArrayList<File> allSoundFilesObject = new ArrayList<>();
        File[] files = user.listFiles();
        for (File currentFile : files) {
            if (currentFile.isDirectory() && !currentFile.isHidden()) {
                allSoundFilesObject.addAll(findSoundFiles(currentFile));
            } else {
               if (currentFile.getName().endsWith(".mp3") || currentFile.getName().endsWith("📖📓.mp3") || currentFile.getName().startsWith("Nasser", 0)) {
                    //users.add(new User(currentFile.getName(),"", true));
                    //allSoundFilesObject.add(currentFile);
                    //users.add(new User(currentFile.getName(),"",true));
                     //allSoundFilesObject.add(currentFile);
                     //users.add(new User(currentFile.getName(),"",true));
                     allSoundFilesObject.add(currentFile);
                    //nassar.media1 = MediaPlayer.create(indirilenler.class,Uri.parse(String.valueOf(currentFile))));

                }
            }
        }
        return allSoundFilesObject;
    }
    public static void initSurePlayer(int position , Context mContext){
        if (mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.reset();
        }
        indirilenlerisim = indirilenler.sureler.get(position).getName();

        Uri songResourceUri = Uri.parse(sureler.get(position).toString());

        mediaPlayer = MediaPlayer.create(mContext,songResourceUri);
         mediaPlayer.start();
        //media2.start();

    }
}
