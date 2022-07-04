package com.example.kuranikerimm.ses_listesi;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.kuranikerimm.LoadingDialog;
import com.example.kuranikerimm.R;
import com.example.kuranikerimm.User;
import com.example.kuranikerimm.oynatmaekranlari.sesplayer;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import static com.example.kuranikerimm.ses_listesi.nassar.mediaPlayer;
import static com.example.kuranikerimm.strings.nasser0;
import static com.example.kuranikerimm.strings.nasser1;
import static com.example.kuranikerimm.strings.nasser10;
import static com.example.kuranikerimm.strings.nasser11;
import static com.example.kuranikerimm.strings.nasser12;
import static com.example.kuranikerimm.strings.nasser13;
import static com.example.kuranikerimm.strings.nasser14;
import static com.example.kuranikerimm.strings.nasser15;
import static com.example.kuranikerimm.strings.nasser16;
import static com.example.kuranikerimm.strings.nasser17;
import static com.example.kuranikerimm.strings.nasser18;
import static com.example.kuranikerimm.strings.nasser19;
import static com.example.kuranikerimm.strings.nasser2;
import static com.example.kuranikerimm.strings.nasser20;
import static com.example.kuranikerimm.strings.nasser21;
import static com.example.kuranikerimm.strings.nasser22;
import static com.example.kuranikerimm.strings.nasser23;
import static com.example.kuranikerimm.strings.nasser24;
import static com.example.kuranikerimm.strings.nasser25;
import static com.example.kuranikerimm.strings.nasser26;
import static com.example.kuranikerimm.strings.nasser27;
import static com.example.kuranikerimm.strings.nasser28;
import static com.example.kuranikerimm.strings.nasser29;
import static com.example.kuranikerimm.strings.nasser3;
import static com.example.kuranikerimm.strings.nasser30;
import static com.example.kuranikerimm.strings.nasser31;
import static com.example.kuranikerimm.strings.nasser32;
import static com.example.kuranikerimm.strings.nasser33;
import static com.example.kuranikerimm.strings.nasser34;
import static com.example.kuranikerimm.strings.nasser35;
import static com.example.kuranikerimm.strings.nasser36;
import static com.example.kuranikerimm.strings.nasser37;
import static com.example.kuranikerimm.strings.nasser38;
import static com.example.kuranikerimm.strings.nasser39;
import static com.example.kuranikerimm.strings.nasser4;
import static com.example.kuranikerimm.strings.nasser40;
import static com.example.kuranikerimm.strings.nasser41;
import static com.example.kuranikerimm.strings.nasser43;
import static com.example.kuranikerimm.strings.nasser44;
import static com.example.kuranikerimm.strings.nasser45;
import static com.example.kuranikerimm.strings.nasser47;
import static com.example.kuranikerimm.strings.nasser48;
import static com.example.kuranikerimm.strings.nasser49;
import static com.example.kuranikerimm.strings.nasser5;
import static com.example.kuranikerimm.strings.nasser50;
import static com.example.kuranikerimm.strings.nasser6;
import static com.example.kuranikerimm.strings.nasser7;
import static com.example.kuranikerimm.strings.nasser8;
import static com.example.kuranikerimm.strings.nasser9;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ses_liste_ekrani#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ses_liste_ekrani extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static String nassarses;
   // public static MediaPlayer media1;
    public static ListView listView;
    String[] e = new String[]{"(new User(\"Fâtiha\", true)"};
    Intent player;
    public static final List<User> users = new ArrayList<User>();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ses_liste_ekrani() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ses_liste_ekrani.
     */
    // TODO: Rename and change types and number of parameters
    public static ses_liste_ekrani newInstance(String param1, String param2) {
        ses_liste_ekrani fragment = new ses_liste_ekrani();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
           // CustomAdapter.a = 1;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.ses_liste_ekrani_tasarim, container, false);

        listView = view.findViewById(R.id.nassarlist1);
        final LoadingDialog loadingDialog = new LoadingDialog(getActivity());
        //CustomAdapter adapter = new CustomAdapter(getActivity(), users);
        //listView.setAdapter(adapter);
       // CustomAdapter.a = 1;

      /*  users.add(new User("Fâtiha", true));
        users.add(new User("Bakara", true));
        users.add(new User("Âl-i İmrân", true));
        users.add(new User("Nisâ", true));
        users.add(new User("Mâide", true));
        users.add(new User("En'âm", true));
        users.add(new User("A'râf", true));
        users.add(new User("Enfâl", true));
        users.add(new User("Tevbe", true));
        users.add(new User("Yunus", true));
        users.add(new User("Hûd", true));
        users.add(new User("Yusuf", true));
        users.add(new User("Ra'd", true));
        users.add(new User("İbrahim", true));
        users.add(new User("Hicr", true));
        users.add(new User("Nahl", true));
        users.add(new User("İsrâ", true));
        users.add(new User("Kehf", true));
        users.add(new User("Meryem", true));
        users.add(new User("Tâ-Hâ", true));
        users.add(new User("Enbiyâ", true));
        users.add(new User("Hac", true));
        users.add(new User("Mü'minûn", true));
        users.add(new User("Furkan", true));
        users.add(new User("Şuarâ", true));
        users.add(new User("Neml", true));
        users.add(new User("Kasas", true));
        users.add(new User("Ankebût", true));
        users.add(new User("Rûm", true));
        users.add(new User("Lokman", true));
        users.add(new User("Secde", true));
        users.add(new User("Ahzâb", true));
        users.add(new User("Sebe'", true));
        users.add(new User("Fâtır", true));
        users.add(new User("Yâsin", true));
        users.add(new User("Sâffât", true));
        users.add(new User("Sâd", true));
        users.add(new User("Zümer", true));
        users.add(new User("Mü'min", true));
        users.add(new Uammed", true));
        users.add(new User("Fetih", true));
        users.add(new User("Hucurât", true));
        users.add(new User("Kaf", true));
        users.add(new User("Zâriyât", true));
        users.add(new User("Tûr", trueser("Fussilet", true));
        users.add(new User("Şûrâ", true));
        users.add(new User("Zuhruf", true));
        users.add(new User("Duhân", true));
        users.add(new User("Câsiye", true));
        users.add(new User("Ahkâf", true));
        users.add(new User("Muh));
        users.add(new User("Necm", true));
        users.add(new User("Kamer", true));
        users.add(new User("Rahmân", true));
        users.add(new User("Vâkıa", true));
        users.add(new User("Hadid", true));
        users.add(new User("Mücâdele", true));
        users.add(new User("Haşr", true));
        users.add(new User("Mümtehine", true));
        users.add(new User("Saf", true));
        users.add(new User("Cum'a", true));
        users.add(new User("Münâfikûn", true));
        users.add(new User("Teğabün", true));
        users.add(new User("Talâk", true));
        users.add(new User("Tahrim", true));
        users.add(new User("Mülk", true));
        users.add(new User("Kalem", true));
        users.add(new User("Hâkka", true));
        users.add(new User("Meâric", true));
        users.add(new User("Nuh", true));
        users.add(new User("Cin", true));
        users.add(new User("Müzzemmil", true));
        users.add(new User("Müddessir", true));
        users.add(new User("Kıyamet", true));
        users.add(new User("İnsan", true));
        users.add(new User("Mürselât", true));
        users.add(new User("Nebe'", true));
        users.add(new User("Nâziât", true));
        users.add(new User("Abese", true));
        users.add(new User("Tekvir", true));
        users.add(new User("İnfitâr", true));
        users.add(new User("Mutaffifin", true));
        users.add(new User("İnşikak", true));
        users.add(new User("Bürûc", true));
        users.add(new User("Târık", true));
        users.add(new User("A'lâ", true));
        users.add(new User("Gâşiye", true));
        users.add(new User("Fecr", true));
        users.add(new User("Beled", true));
        users.add(new User("Şems", true));
        users.add(new User("Leyl", true));
        users.add(new User("Duhâ", true));
        users.add(new User("İnşirâh", true));
        users.add(new User("Tin", true));
        users.add(new User("Alak", true));
        users.add(new User("Kadir", true));
        users.add(new User("Beyyine", true));
        users.add(new User("Zilzâl", true));
        users.add(new User("Âdiyât", true));
        users.add(new User("Kâria", true));
        users.add(new User("Tekâsür", true));
        users.add(new User("Asr", true));
        users.add(new User("Hümeze", true));
        users.add(new User("Fil", true));
        users.add(new User("Kureyş", true));
        users.add(new User("Mâûn", true));
        users.add(new User("Kevser", true));
        users.add(new User("Kâfirûn", true));
        users.add(new User("Nasr", true));
        users.add(new User("Tebbet", true));
        users.add(new User("İhlâs", true));
        users.add(new User("Felâk", true));
        users.add(new User("Nâs", true)); */


        final FloatingActionButton fab = view.findViewById(R.id.fab1);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if  (mediaPlayer != null) {
                    switch (view.getId()) {
                        case R.id.fab1:
                            if (!mediaPlayer.isPlaying()) {
                                mediaPlayer.start();
                                fab.setImageResource(R.drawable.pause);
                            } else {
                                mediaPlayer.pause();
                                fab.setImageResource(R.drawable.play);
                            }
                    }
                } else {
                    Snackbar.make(view, "İşlemi yapmadan önce bir sure açmalısınız.", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view , int position, long id) {
                // if (media1 != null) {
                //   if (!media1.isPlaying()) {
                // media1.start();
                //      fab.setImageResource(R.drawable.pause);
                //} else {
                // media1.pause();
                //  fab.setImageResource(R.drawable.play);
                //}
                //}
                loadingDialog.startLoadingDialog();

                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                if (networkConnection() == true){

                    //switch (position){
                    //  case 0:
                    //    nassarses = "http://erkantr.tk/fatiha.mp3";
                    //  break;
                    //case 1:
                    //  nassarses = "https://ia601407.us.archive.org/24/items/nasser-al-qatami/bakara.mp3";
                    // break;
                    //}

                    if (position == 0) {
                        nassarses = nasser0;
                    }
                    if (position == 1) {
                        nassarses = nasser1;
                    }
                    if (position == 2) {
                        nassarses = nasser2;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 4) {
                        nassarses = nasser4;
                    }
                    if (position == 5) {
                        nassarses = nasser5;
                    }
                    if (position == 6) {
                        nassarses = nasser6;
                    }
                    if (position == 7) {
                        nassarses = nasser7;
                    }
                    if (position == 8) {
                        nassarses = nasser8;
                    }
                    if (position == 9) {
                        nassarses = nasser9;
                    }
                    if (position == 10) {
                        nassarses = nasser10;
                    }
                    if (position == 11) {
                        nassarses = nasser11;
                    }
                    if (position == 12) {
                        nassarses = nasser12;
                    }
                    if (position == 13) {
                        nassarses = nasser13;
                    }
                    if (position == 14) {
                        nassarses = nasser14;
                    }
                    if (position == 15) {
                        nassarses = nasser15;
                    }
                    if (position == 16) {
                        nassarses = nasser16;
                    }
                    if (position == 17) {
                        nassarses = nasser17;
                    }
                    if (position == 18) {
                        nassarses = nasser18;
                    }
                    if (position == 19) {
                        nassarses = nasser19;
                    }
                    if (position == 20) {
                        nassarses = nasser20;
                    }
                    if (position == 21) {
                        nassarses = nasser21;
                    }
                    if (position == 22) {
                        nassarses = nasser22;
                    }
                    if (position == 23) {
                        nassarses = nasser23;
                    }
                    if (position == 24) {
                        nassarses = nasser24;
                    }
                    if (position == 25) {
                        nassarses = nasser25;
                    }
                    if (position == 26) {
                        nassarses = nasser26;
                    }if (position == 27) {
                        nassarses = nasser27;
                    }
                    if (position == 28) {
                        nassarses = nasser28;
                    }
                    if (position == 29) {
                        nassarses = nasser29;
                    }
                    if (position == 30) {
                        nassarses = nasser30;
                    }
                    if (position == 31) {
                        nassarses = nasser31;
                    }
                    if (position == 32) {
                        nassarses = nasser32;
                    }
                    if (position == 33) {
                        nassarses = nasser33;
                    }
                    if (position == 34) {
                        nassarses = nasser34;
                    }
                    if (position == 35) {
                        nassarses = nasser35;
                    }
                    if (position == 36) {
                        nassarses = nasser36;
                    }
                    if (position == 37) {
                        nassarses = nasser37;
                    }
                    if (position == 38) {
                        nassarses = nasser38;
                    }
                    if (position == 39) {
                        nassarses = nasser39;
                    }
                    if (position == 40) {
                        nassarses = nasser40;
                    }
                    if (position == 41) {
                        nassarses = nasser41;
                    }
                    if (position == 43) {
                        nassarses = nasser43;
                    }
                    if (position == 44) {
                        nassarses = nasser44;
                    }
                    if (position == 45) {
                        nassarses = nasser45;
                    }
                    if (position == 46) {
                        nassarses = nasser47;
                    }
                    if (position == 48) {
                        nassarses = nasser48;
                    }
                    if (position == 49) {
                        nassarses = nasser49;
                    }
                    if (position == 50) {
                        nassarses = nasser50;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }
                    if (position == 3) {
                        nassarses = nasser3;
                    }

                    // if (ileri ==0){
                    //   media1.stop();
                    //Uri uri = Uri.parse(link[position + 1]);
                    //mediaPlayer.setDataSource(getApplicationContext(), uri);
                    //mediaPlayer.prepare();
                    //mediaPlayer.start();
                    //}else{

                    //}

                    mediaPlayer = MediaPlayer.create(getContext(), Uri.parse(nassarses));
                    if (mediaPlayer != null){
                        mediaPlayer.start();

                    }
                    player = new Intent(getContext(), sesplayer.class);
                    startActivity(player);
                } else {
                    Snackbar.make(view, "İnternet Bağlantınızı Kontrol Edin.", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }

            private void finish(Intent player) {
                player = new Intent(getContext(), sesplayer.class);
                finish(player);
            }
        });
        //if (sesplayer.d == 0){
        //  loadingDialog.dismissDialog();
        //}
    return  view;}
    public boolean networkConnection() {
        ConnectivityManager conMgr = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conMgr.getActiveNetworkInfo() != null && conMgr.getActiveNetworkInfo().isAvailable() && conMgr.getActiveNetworkInfo().isConnected()) {
            return true;
        } else {
            return false;
        }
    }

    }
//}
