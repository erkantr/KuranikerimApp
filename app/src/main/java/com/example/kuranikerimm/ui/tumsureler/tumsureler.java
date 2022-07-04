package com.example.kuranikerimm.ui.tumsureler;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.kuranikerimm.ApiClient;
import com.example.kuranikerimm.ApiInterface;
import com.example.kuranikerimm.CustomAdapter;
import com.example.kuranikerimm.Okuyanlar;
import com.example.kuranikerimm.OkuyanlarAdapter;
import com.example.kuranikerimm.R;
import com.example.kuranikerimm.User;
import com.example.kuranikerimm.Veriler;
import com.example.kuranikerimm.oynatmaekranlari.sesplayer;
import com.example.kuranikerimm.ses_listesi.nassar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class tumsureler extends Fragment {
    public static int b;
    private HomeViewModel homeViewModel;
    private OkuyanlarAdapter okuyanlarAdapter;

    private List<Okuyanlar> okuyanlars;
    private ListView listView;
    public static String okuyanisim;
    static  String  fatiha = "http://erkantr.tk/fatiha.mp3";
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final ApiInterface apiInterface =
                ApiClient.getRetrofitInstance().create(ApiInterface.class);

        //final TextView textView = root.findViewById(R.id.text_home);
       // homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
        //    @Override
          //  public void onChanged(@Nullable String s) {
          //      textView.setText(s);
          //  }
        //});
       // okuyanlars = new ArrayList<Okuyanlar>();
        //listView = root.findViewById(R.id.listview);
        //readUsers();
        sesplayer.dialog1 = 1;
        b = 2;
        CustomAdapter.a = 2;
        //Call<VeriResponse> call = apiInterface.getJson();
        final List<User> users = new ArrayList<User>();
        final ListView listView = root.findViewById(R.id.listview);
        String val1 = "[{test: \"test\"}]";

        //final GsonBuilder gsonBuilder = new GsonBuilder();
        //final Gson gson = gsonBuilder.create();

        //Veriler[] testCase = gson.fromJson(val1, Veriler[].class);

         //apiInterface=RetrofitInstance.getRetrofitInstance().create(BirdsApi.class);
        Call<List<Okuyanlar>> call=apiInterface.getJson2();
        //final Call<Okuyanlar> verilerCall = apiInterface.getJson1();

        call.enqueue(new Callback<List<Okuyanlar>>() {
            @Override
            public void onResponse(Call<List<Okuyanlar>> call, final Response<List<Okuyanlar>> response1) {
                //String s = response.headers().get("qari");
                //String all = response.body().getSurahId().toString();
                //String okuyan = response.body().getMetadata().getArtist();
                //String[] sureadiarabic = response.body().getMetadata().getTitle();
                //String path2 = response.body().getFileName();
                //final List<Veriler> users = new ArrayList<Veriler>();
                //users.add(new Veriler(response.body(),"filter",true));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        final String path = "https://download.quranicaudio.com/quran/";


                        Okuyanlar res = response1.body().get(position);
                        Intent intent = new Intent(getContext(), nassar.class);
                        intent.putExtra("okuyan",res.getName());
                        startActivity(intent);

                        okuyanisim = res.getName();

                        //MediaPlayer mediaPlayer = MediaPlayer.create(getContext(), Uri.parse(path + res.getQari().getRelativePath() + res.getFileName()));
                       // mediaPlayer.start();
                    }
                });

                OkuyanlarAdapter adapter = new OkuyanlarAdapter(getActivity(), response1.body());
                listView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<Okuyanlar>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("Error", t.getMessage());
                System.out.println(t.getMessage());
                final List<User> users = new ArrayList<User>();
                //users.add(new User(t.getMessage(),"filter",true));
                //CustomAdapter adapter = new CustomAdapter(getActivity(), users);
                //listView.setAdapter(adapter);
            }
        });
        //final List<User> users = new ArrayList<User>();
        //final TextView sayi = root.findViewById(R.id.textViewSystemClock);
        //final ListView listView = root.findViewById(R.id.listview);
        /*
        users.add(new User("Nasser al Qatami", "nassar al qatami Nassar QATAMI QATAMİ NASSER NASSAR AL" ,true));

        users.add(new User("İshak Danış", "İSHAK DANIŞ ishak danış danis ISHAK" , true));
        users.add(new User("Maher al Muayqali", "mahir MAHIR MAHİR MAHER AL MUAYQALI MUAYQALİ " , true));
        users.add(new User("Nasser al Qatami(cüz)", "nassar al qatami Nassar QATAMI QATAMİ NASSER NASSAR AL" ,true));
        users.add(new User("Fatih Çollak", "FATİH ÇOLAK ÇOLLAK fatih FATIH çolak colak COLAK" ,true));
        users.add(new User("Muhammed al Qurdi", "Muahmmad al qurdi QURDİ kurdi MUAHMMAD AL QUARDI" , true));
        users.add(new User("İslam Subhi", "ISLAM SUBHI SUBHİ islam subhi " , true));
        users.add(new User("Hazza al Balushi", "hazza al balushi HAZZA AL BALUSHİ BALUSHI " , true));
        users.add(new User("Ebubekir Şatıri", "EBUBEKİR ŞATİRİ ebubekir şatıri shatri satiri SATİRİ SATIRI" , true));
        users.add(new User("Mishary Rashid al Afasy", "mishary rashid al afasy MİSHARY RASHİD RASHID AFASY" , true));
        users.add(new User("İdris Abkar", "idris abkar IDRIS ABKAR İDRİS" , true));
        users.add(new User("Salman al Utaybi","SELMAN AL UTAYBİ Selman salman utaybi" , true));
        users.add(new User("Yasser al Dosari", "yasser al dosari YASSER AL DOSARİ DOSARI" , true));

         */



        /*
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            //Check if internet is present or not

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){

                    Intent seslistesi = new Intent(getContext(), com.example.kuranikerimm.ses_listesi.nassar.class);
                    startActivity(seslistesi);
                    b = 2;
                }
                    //CustomAdapter.a = 1;

                       // MediaPlayer media1 = MediaPlayer.create(getContext(), Uri.parse(fatiha));
                        //media1.start();




            }

        });

         */

        //CustomAdapter adapter = new CustomAdapter(getActivity(), users);
        //listView.setAdapter(adapter);

        return root;

    }
    private void readUsers() {
        final FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                okuyanlars.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Okuyanlar okuyan = dataSnapshot.getValue(Okuyanlar.class);

                    assert okuyan !=null;
                    assert firebaseUser !=null;
                    //if (!okuyan.getId().equals(firebaseUser.getUid())){
                        okuyanlars.add(okuyan);
                    //}
                }

                okuyanlarAdapter = new OkuyanlarAdapter((Activity) getContext(),okuyanlars);
                listView.setAdapter(okuyanlarAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}

