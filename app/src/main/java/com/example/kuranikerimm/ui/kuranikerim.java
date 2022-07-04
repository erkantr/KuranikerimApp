package com.example.kuranikerimm.ui;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kuranikerimm.CustomAdapter;
import com.example.kuranikerimm.R;
import com.example.kuranikerimm.User;
import com.example.kuranikerimm.oynatmaekranlari.pdfviewer;

import java.util.ArrayList;
import java.util.List;

public class kuranikerim extends Fragment {

    private KuranikerimViewModel mViewModel;
    public static String kuranikerimlink;
    public static String kitapismi;

    public static kuranikerim newInstance() {
        return new kuranikerim();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = ViewModelProviders.of(this).get(KuranikerimViewModel.class);
        View root = inflater.inflate(R.layout.kuranikerimfragment, container, false);
        CustomAdapter.a = 3;
        final List<User> users = new ArrayList<User>();
        final TextView sayi = root.findViewById(R.id.textViewSystemClock);
        ListView listView = root.findViewById(R.id.kuranlist);

        /*
        users.add(new User("Husrev Hattı", "hüsrev hatti hattı Hüsrev",true));
        users.add(new User("Diyanet", "diyanet DİYANET DIYANET", true));
        users.add(new User("Kelime Mealli", "KELİME MEALLİ kelime mealli meal" , true));
        users.add(new User("Bilgisayar Hattı-1", "bilgisayar hattı 1 bilgisayar BİLGİSAYAR" , true));
        users.add(new User("Kuran-ı Kerim-1", "KURAN kuran kuranikerim kuran 1 kuran i kerim 1" , true));
        users.add(new User("Kuran-ı Kerim-2", "KURAN kuran kuranikerim kuran 2 kuran i kerim 2" ,true));
        users.add(new User("Bilgisayar Hattı-2", "bilgisayar hattı 2 bilgisayar BİLGİSAYAR" ,true));


         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            //Check if internet is present or not

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    kitapismi = "Husrev Hattı Kur'an-ı Kerim";
                  kuranikerimlink = "https://drive.google.com/file/d/1OlJg0r76c9qjrKnTTlxh_ug1FQHutFLq/view?usp=sharing";
                }
                if (position == 1) {
                    kitapismi = "Diyanet Kur'an-ı Kerim";
                    kuranikerimlink = "https://drive.google.com/file/d/1wcPUqa8I6pHFWeXneujgQpM_uYTn81Rl/view";

                }
                if (position ==2) {
                    kitapismi = "Kelime Mealli Kur'an-ı Kerim";
                    kuranikerimlink = "https://drive.google.com/file/d/1nqNkIrAQSUhOBs-YDgf-adx4H8gUFkXe/view?usp=sharing";

                }
                if (position == 3) {
                    kitapismi = "Bilgisayar Hattı Kur'an-ı Kerim";
                    kuranikerimlink = "https://drive.google.com/file/d/1fYvGD47AUx2Rm1vGXsD8ED0ijbPLsgTr/view?usp=sharing";

                }
                if (position == 4) {
                    kitapismi = "Kur'an-ı Kerim-1";
                    kuranikerimlink = "https://drive.google.com/file/d/11AL4FK2YjECsF-csE2wJeib09CwT3niV/view?usp=sharing";

                }
                if (position == 5) {
                    kitapismi = "Kur'an-ı Kerim-2";
                    kuranikerimlink = "https://drive.google.com/file/d/1uoPB5QKESwUeqwY6VNAHvOHqMLAYDJkU/view?usp=sharing";

                }
                if (position == 6) {
                    kitapismi = "Bilgisayar Hattı Kur'an-ı Kerim-2";
                    kuranikerimlink = "https://drive.google.com/file/d/1CPf4eVKiVQ0tkBP3BPBnU38mCfttuUFS/view?usp=sharing";
                }



                Intent intent = new Intent(getContext(), pdfviewer.class);
                startActivity(intent);





            }

        });
        //CustomAdapter adapter = new CustomAdapter(getActivity(), users);
        //listView.setAdapter(adapter);

        return root;
    }

   /* @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(KuranikerimViewModel.class);
        // TODO: Use the ViewModel
    }*/

}
