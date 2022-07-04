package com.example.kuranikerimm;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class IndirilenlerAdapter extends BaseAdapter {
    private LayoutInflater userInflater;
    private List<indirilenler_listesi> indirilenler_listesi;

    public IndirilenlerAdapter(Activity activity, List<indirilenler_listesi> indirilenler_listesi) {
        userInflater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        this.indirilenler_listesi = indirilenler_listesi;
    }

    @Override
    public int getCount() {
        return indirilenler_listesi.size();
    }

    @Override
    public Object getItem(int i) {
        return indirilenler_listesi.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View lineView = null;
        lineView = userInflater.inflate(R.layout.anatasarim, null);
        TextView textViewUserName = (TextView) lineView.findViewById(R.id.textViewUserName);
        ImageView imageViewUserPicture = (ImageView) lineView.findViewById(R.id.imageViewUserPicture);
        indirilenler_listesi Indirilenler_listesi = indirilenler_listesi.get(i);
        //textViewUserName.setText((CharSequence) Indirilenler_listesi.getFileName());
        //if (Indirilenler_listesi.isUserGender()) {
            imageViewUserPicture.setImageResource(R.drawable.rgbred);
        //}
        return lineView; }
}
