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

public class OkuyanlarAdapter extends BaseAdapter {
    private LayoutInflater userInflater;
    private List<Okuyanlar> userList;

    public OkuyanlarAdapter (Activity activity, List<Okuyanlar> mUsers){
        userInflater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        this.userList = mUsers;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View lineView = null;
        final Okuyanlar okuyanlar = userList.get(position);
        lineView = userInflater.inflate(R.layout.anatasarim, null);
        TextView textViewUserName = lineView.findViewById(R.id.textViewUserName);
        ImageView imageViewUserPicture = lineView.findViewById(R.id.imageViewUserPicture);
        TextView alsatir = lineView.findViewById(R.id.textViewSystemClock);
        //textViewUserName.setText(okuyanlar.getUsername());
        textViewUserName.setText(okuyanlar.getName());
            imageViewUserPicture.setImageResource(R.drawable.hat);
            /*
        textViewUserName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

             */
        return lineView;
    }
}
