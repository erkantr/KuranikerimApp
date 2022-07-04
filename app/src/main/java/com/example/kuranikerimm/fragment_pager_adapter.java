package com.example.kuranikerimm;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.kuranikerimm.ses_listesi.ses_liste_ekrani;

public class fragment_pager_adapter extends FragmentPagerAdapter {


    public fragment_pager_adapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        ses_liste_ekrani ses = new ses_liste_ekrani();
        return ses;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
