package com.example.kuranikerimm.ui.videolar;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.kuranikerimm.CustomAdapter;
import com.example.kuranikerimm.R;
import com.example.kuranikerimm.User;
import com.example.kuranikerimm.ses_listesi.nassar;
import com.example.kuranikerimm.ui.tumsureler.tumsureler;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
       final ListView listView = root.findViewById(R.id.listview1);
        CustomAdapter.a = 4;
        final List<User> users = new ArrayList<User>();
        final TextView sayi = root.findViewById(R.id.textViewSystemClock);

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


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {



            //Check if internet is present or not



            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Intent nassarv = new Intent(getContext(), nassar.class);
                    startActivity(nassarv);
                    tumsureler.b = 1;
                }
                if (position == 1) {
                }





            }
        });
        //CustomAdapter adapter = new CustomAdapter(getActivity(), users);
        //listView.setAdapter(adapter);

        return root;
    }
}
