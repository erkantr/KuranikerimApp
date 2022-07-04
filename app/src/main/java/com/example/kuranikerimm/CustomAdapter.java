package com.example.kuranikerimm;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.os.ParcelUuid;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.kuranikerimm.ui.tumsureler.tumsureler.okuyanisim;

public class CustomAdapter extends BaseAdapter {
    private LayoutInflater userInflater;
    private List<Veriler> userList;
    private List<Veriler> userListFull;
    User user;
    public static String isim;
    public static int a = 0;
    public static int arama;
    public static String İD;

    public CustomAdapter(Activity activity, List<Veriler> userList) {
        userInflater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        this.userList = userList;
        userListFull = new ArrayList<>(userList);
    }
    //https://medium.mybridge.co/38-amazing-android-open-source-apps-java-1a62b7034c40
    @Override
    public int getCount() {
       return userList.size();
    }

    @Override
    public Object getItem(int i) {
        //user.getUserName();
        return userList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    /*
    @Override
    public Filter getFilter() {
        return exampleFilter;
    }
    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<User> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0){
                filteredList.addAll(userListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (User item : userListFull){
                    if (item.getUserName().toLowerCase().contains(filterPattern) || item.getFiltre().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            userList.clear();
            userList.addAll((List) results.values);
            notifyDataSetChanged();

        }
    };
    */

    @SuppressLint({"ViewHolder", "CutPasteId"})
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View lineView = null;
        //lineView = userInflater.inflate(R.layout.listetasarim, null);
        if (a == 5) {
            lineView = userInflater.inflate(R.layout.indirilenlertasarim, null);
            TextView textViewUserName = (TextView) lineView.findViewById(R.id.textViewindirilen);
            ImageView imageViewUserPicture = (ImageView) lineView.findViewById(R.id.imageViewUserPicture);
           // TextView textViewSystemClock = lineView.findViewById(R.id.textViewSystemClock);
         //   textViewSystemClock.setText("");
            //User user = userList.get(i);
            Veriler veriler = userList.get(i);
            //textViewUserName.setText(user.getUserName().toString());
            textViewUserName.setText(veriler.getQari().getName());
            //isim = user.getUserName();

            if (user.isUserGender()) {
                imageViewUserPicture.setImageResource(R.drawable.rgbred);
            }
        }
        if (a == 4) {
            lineView = userInflater.inflate(R.layout.anatasarim, null);
            TextView textViewUserName = (TextView) lineView.findViewById(R.id.textViewUserName);
            ImageView imageViewUserPicture = (ImageView) lineView.findViewById(R.id.imageViewUserPicture);
            //User user = userList.get(i);
            //textViewUserName.setText(user.getUserName());
            //isim = textViewUserName.getText().toString();
            //isim = user.getUserName();
            if (user.isUserGender()) {
                imageViewUserPicture.setImageResource(R.drawable.play_red);
            }
        }

        if (a == 3) {
            lineView = userInflater.inflate(R.layout.kurantasarim, null);
            TextView textViewUserName = (TextView) lineView.findViewById(R.id.textViewUserName);
            ImageView imageViewUserPicture = (ImageView) lineView.findViewById(R.id.imageViewUserPicture);
            //User user = userList.get(i);
            //textViewUserName.setText(user.getUserName());
            //textViewUserName.setText(user.getUserName());
            //isim = textViewUserName.getText().toString();
            //isim = user.getUserName();
            if (user.isUserGender()) {
                imageViewUserPicture.setImageResource(R.drawable.sarihat2);
            }
        }
        if (a == 2) {
            lineView = userInflater.inflate(R.layout.anatasarim, null);
            TextView textViewUserName = (TextView) lineView.findViewById(R.id.textViewUserName);
            ImageView imageViewUserPicture = (ImageView) lineView.findViewById(R.id.imageViewUserPicture);
            TextView textViewSystemClock = lineView.findViewById(R.id.textViewSystemClock);
            textViewSystemClock.setText("");
            //User user = userList.get(i);
            //textViewUserName.setText(user.getUserName());
            //textViewUserName.setText(userList.get(i).getQari().getName() + " " +userList.get(i).getMetadata().getTitle());
            //textViewSystemClock.setText(""+this.getItemId(i));


            if (userList.get(i).getQari().getName() == null){
                textViewUserName.setText("bos");

            } else {
                //if (okuyanisim.equals(userList.get(i).getQari().getName()))
                textViewSystemClock.setText(userList.get(i).getQari().getName());
                textViewUserName.setText(userList.get(i).getMetadata().getTitle());
            }

            //isim = textViewUserName.getText().toString();
            //isim = user.getUserName();
            isim = ((TextView) lineView.findViewById(R.id.textViewUserName)).getText().toString();
            //if (user.isUserGender()) {
                imageViewUserPicture.setImageResource(R.drawable.hatt);
           // }

            //return lineView;
        }
        if (a == 1) {
            lineView = userInflater.inflate(R.layout.listetasarim, null);
            TextView textViewUserName = (TextView) lineView.findViewById(R.id.textViewUserName);
            ImageView imageViewUserPicture = (ImageView) lineView.findViewById(R.id.imageViewUserPicture);
            TextView filtre = lineView.findViewById(R.id.filtre);
            TextView textViewSystemClock = lineView.findViewById(R.id.textViewSystemClock);
            //User user = userList.get(i);
            //textViewUserName.setText(user.getUserName());
            //isim = textViewUserName.getText().toString();
            //isim = user.getUserName();

            //if (userList.get(i).getQari().getName() == null){
              //  textViewUserName.setText("bos");

            //} else {
                //if(okuyanisim.equals(userList.get(i).getQari().getName())){
                    textViewSystemClock.setText(userList.get(i).getQari().getName());
                textViewUserName.setText(userList.get(i).getMetadata().getTitle());
           // }

            //isim = textViewUserName.getText().toString();
            //isim = user.getUserName();
            //isim = ((TextView) lineView.findViewById(R.id.textViewUserName)).getText().toString();
            //if (user.isUserGender()) {
            imageViewUserPicture.setImageResource(R.drawable.hatt);

            /*
            İD = ""+textViewUserName.getId();

            textViewSystemClock.setText(""+this.getItemId(i));
            if (arama != 1){
                textViewSystemClock.setText(""+this.getItemId(i));
            } else {
                CharSequence sayilar = textViewSystemClock.getText();
                textViewSystemClock.setText(sayilar);
            }
           // filtre.setText((user.getFiltre()));
            //if (user.isUserGender()) {
                imageViewUserPicture.setImageResource(R.drawable.besmele);
            //} else {
                imageViewUserPicture.setImageResource(R.drawable.beyaz);

             */
            }

            // return lineView;
        //}

        //TextView textViewUserName = (TextView) lineView.findViewById(R.id.textViewUserName);
        //ImageView imageViewUserPicture = (ImageView) lineView.findViewById(R.id.imageViewUserPicture);
        // User user = userList.get(i);
        //textViewUserName.setText(user.getUserName());

        // if (user.isUserGender()) {
        //   imageViewUserPicture.setImageResource(R.drawable.besmele);
        //}

        //return lineView;
        return lineView;
    }
}
