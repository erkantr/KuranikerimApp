package com.example.kuranikerimm.ses_listesi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.app.NavUtils;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kuranikerimm.ApiClient;
import com.example.kuranikerimm.ApiInterface;
import com.example.kuranikerimm.CustomAdapter;
import com.example.kuranikerimm.LoadingDialog;
import com.example.kuranikerimm.R;
import com.example.kuranikerimm.User;
import com.example.kuranikerimm.Veriler;
import com.example.kuranikerimm.oynatmaekranlari.sesplayer;
import com.example.kuranikerimm.ui.indirilenler.indirilenler;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.kuranikerimm.oynatmaekranlari.sesplayer.dialog1;
import static com.example.kuranikerimm.oynatmaekranlari.sesplayer.ileri;

public class nassar<animRightIn> extends AppCompatActivity{
     public static String nassarses;
    public static MediaPlayer mediaPlayer;
    public static String nassarvideo;
     public static ListView listView;
    Intent player;
    public static int surepozisyonu;
   private int position;
    public static int internet =1;
   int arama;
    TextView sureokuyan;
    Snackbar snackbar;
   public static String[] isimlerr = {"Fâtiha", "Bakara", "Âl-i İmrân", "Nisâ", "Mâide"};
    String Fatiha ;
    String[] filtre = {"fatiha Fatiha FATİHA FATIHA","BAKARA bakara","Ali İmran ali imran aliimran Ali imran ALİİMRAN ALI IMRAN ALIIMRAN alı ımran","nisa Nisa NİSA NISA nısa","Maide maide MAİDE MAIDE maıde"};
    Boolean[] resim = {true,true,true,true,true};
    public static User user;
    User userss;
    String isimm;
    String name;
    CountDownTimer countDownTimer;
    ListView lview;
    public static LoadingDialog loadingDialog;
     ArrayAdapter<String> arrayAdapter;
    CustomAdapter adapter;

    public static final List<User> users = new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nassar);
        listView = findViewById(R.id.nassarlist1);
        loadingDialog = new LoadingDialog(nassar.this);
       // CustomAdapter adapter = new CustomAdapter(nassar.this, users);
        //final ArrayList<String> list = new ArrayList<>();
        // listView.setAdapter(adapter);
        this.setTitle("Nasser al Qatami");
        dialog1 = 1;
        indirilenler.ses =0;
        //arrayAdapter = new ArrayAdapter<>(nassar.this, android.R.layout.select_dialog_item,list);
        //listView.setAdapter(arrayAdapter);
        final ApiInterface apiInterface =
                ApiClient.getRetrofitInstance().create(ApiInterface.class);
        //user =  users.get(position);
        //   viewPager = findViewById(R.id.view);
       // mySekmeErisimAdapter = new fragment_pager_adapter(getSupportFragmentManager());
        //viewPager.setAdapter(mySekmeErisimAdapter);
       // Toolbar toolbar = findViewById(R.id.toolbar);
        /*
        for (int i = 0; i < isimlerr.length; i++ ){
            list.add(isimlerr[i]);
            //user = new User(isimlerr[i],filtre[i],true);
            users.add(user);
            //user.setUserName("item"+i);
        }

         */
        // https://stackoverflow.com/questions/45101599/how-to-pass-searchview-text-from-action-bar-to-new-activity-in-android/45102218
        // https://stackoverflow.com/questions/39070069/is-it-possible-to-pass-search-context-data-using-the-search-widget-searchview
        if (dialog1 == 0){
            loadingDialog.dismissDialog();
        }
        CustomAdapter.a = 1;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ConnectivityManager conMgr = (ConnectivityManager) nassar.this.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conMgr.getActiveNetworkInfo() == null )
        {
          //loadingDialog.startLoadingDialog();
        }
        //users.get(position).getUserName();
               // listView.setTag(user.getUserName());
        //Toast.makeText(this, ""+listView.getItemIdAtPosition(position), Toast.LENGTH_SHORT).show();

        Call<List<Veriler>> call=apiInterface.getJson();

        call.enqueue(new Callback<List<Veriler>>() {
            @Override
            public void onResponse(Call<List<Veriler>> call, final Response<List<Veriler>> response) {
                //Intent i = getIntent();

                //String name = i.getStringExtra("url");

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        final String path = "https://download.quranicaudio.com/quran/";
                        Veriler res = response.body().get(position);
                        Intent intent = new Intent(nassar.this, sesplayer.class);
                        intent.putExtra("url", path + res.getQari().getRelativePath() + res.getFileName());
                        startActivity(intent);
                    }
                });

                CustomAdapter adapter = new CustomAdapter(nassar.this, response.body());
                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Veriler>> call, Throwable t) {

            }
        });


        /*

            users.add(new User("Fâtiha","fatiha Fatiha FATİHA FATIHA", true));
            users.add(new User("Bakara","BAKARA bakara" , true));
            users.add(new User("Âl-i İmrân", "Ali İmran ali imran aliimran Ali imran ALİİMRAN ALI IMRAN ALIIMRAN alı ımran", true));
            users.add(new User("Nisâ","nisa Nisa NİSA NISA nısa" , true));
            users.add(new User("Mâide", "Maide maide MAİDE MAIDE maıde", true));
            users.add(new User("En'âm","enam en am EN AM ENAM En am Enam", true));
            users.add(new User("A'râf","araf ARAF Araf A raf" , true));
            users.add(new User("Enfâl","enfal ENFAL Enfal" , true));
            users.add(new User("Tevbe", "tevbe TEVBE", true));
            users.add(new User("Yunus","yunus YUNUS" , true));
            users.add(new User("Hûd","HUD hud Hud" , true));
            users.add(new User("Yusuf", "yusuf YUSUF" ,  true));
            users.add(new User("Ra'd", "rad RAD RA D Rad Ra d" , true));
            users.add(new User("İbrahim", "Ibrahim ibrahim IBRAHIM İBRAHİM" , true));
            users.add(new User("Hicr", "HİCR hicr HICR", true));
            users.add(new User("Nahl", "NAHL nahl" , true));
            users.add(new User("İsrâ", "Isra isra ISRA İSRA" , true));
            users.add(new User("Kehf", "KEHF kehf " ,true));
            users.add(new User("Meryem", "meryem MERYEM" , true));
            users.add(new User("Tâ-Hâ", "TAHA TA HA ta ha Taha ta-ha taha" , true));
            users.add(new User("Enbiyâ", "enbiya Enbiya ENBIYA ENBİYA" , true));
            users.add(new User("Hac","hac haç HAÇ Haç HAC"  , true));
            users.add(new User("Mü'minûn", "Muminun muminun müminun MUMINUN MÜMİNUN" , true));
            users.add(new User("Nûr", "nur Nur NUR" , true));
            users.add(new User("Furkan", "furkan FURKAN" , true));
            users.add(new User("Şuarâ","suara şuara SUARA ŞUARA Suara Şuara" , true));
            users.add(new User("Neml", "neml NEML" , true));
            users.add(new User("Kasas", "KASAS kasas" , true));
            users.add(new User("Ankebût", "ankebut ANKEBUT Ankebut" , true));
            users.add(new User("Rûm", "rum RUM Rum" , true));
            users.add(new User("Lokman", "lokman LOKMAN" , true));
            users.add(new User("Secde", "SECDE secde " , true));
            users.add(new User("Ahzâb", "ahzab AHZAB Ahzab" , true));
            users.add(new User("Sebe'", "sebe SEBE Sebe" , true));
            users.add(new User("Fâtır", "fatır FATIR Fatır fatir FATİR Fatir" , true));
            users.add(new User("Yâsin", "yasin YASİN YASIN yasın Yasin" , true));
            users.add(new User("Sâffât", "saffat Saffat SAFFAT" , true));
            users.add(new User("Sâd", "sad SAD Sad" , true));
            users.add(new User("Zümer", "zümer zumer ZUMER ZÜMER Zumer" , true));
            users.add(new User("Mü'min", "mumin mümin mumın mümın MÜMİN MUMİN MUMIN MÜMİN" , true));
            users.add(new User("Fussilet", "fussilet FUSSİLET FUSSILET fussılet" , true));
            users.add(new User("Şûrâ", "Sura Şura şura sura ŞURA SURA" , true));
            users.add(new User("Zuhruf", "ZUHRUF zuhruf", true));
            users.add(new User("Duhân", "duhan Duhan DUHAN" , true));
            users.add(new User("Câsiye", "CASİYE CASIYE casiye casıye" , true));
            users.add(new User("Ahkâf", "Ahkaf ahkaf AHKAF" , true));
            users.add(new User("Muhammed", "muhammed MUHAMMED" , true));
            users.add(new User("Fetih", "fetih Fetıh FETİH FETIH fetıh" , true));
            users.add(new User("Hucurât", "hucurat Hucurat HUCURAT" , true));
            users.add(new User("Kaf", "kaf KAF" , true));
            users.add(new User("Zâriyât", "ZARİYAT ZARIYAT Zariyat Zarıyat zariyat zarıyat" , true));
            users.add(new User("Tûr", "tur TUR " , true));
            users.add(new User("Necm", "necm NECM" , true));
            users.add(new User("Kamer", "KAMER kamer", true));
            users.add(new User("Rahmân", "rahman Rahman RAHMAN" , true));
            users.add(new User("Vâkıa", "Vakıa vakıa vakia VAKIA VAKİA Vakia" , true));
            users.add(new User("Hadid", "HADID HADİD hadid hadıd Hadıd" , true));
            users.add(new User("Mücâdele", "mucadele mücadele MUCADELE MÜCADELE Mucadele Mücadele" , true));
            users.add(new User("Haşr", "haşr HAŞR HASR hasr Hasr" , true));
            users.add(new User("Mümtehine", "mümtehine mumtehine Mumtehine Mümtehine MUMTEHINE MUMTEHİNE MÜMTEHİNE" , true));
            users.add(new User("Saf", "saf SAF" , true));
            users.add(new User("Cum'a", "cuma CUMA Cuma" , true));
            users.add(new User("Münâfikûn", "munafikun münafikun Munafikun Münafikun MUNAFIKUN MÜNAFIKUN MÜNAFİKUN MUNAFİKUN" , true));
            users.add(new User("Teğabün", "TEGABUN TEĞABÜN TEĞABUN teğabun teğabün tegabün tegabun Teğabun Teğabün Tegabün", true));
            users.add(new User("Talâk", "Talak TALAK talak" , true));
            users.add(new User("Tahrim", "tahrim tahrım TAHRIM TAHRİM Tahrım" , true));
            users.add(new User("Mülk", "mulk mülk MULK MÜLK Mulk Mülk", true));
            users.add(new User("Kalem", "KALEM kalem" , true));
            users.add(new User("Hâkka", "hakka HAKKA Hakka" , true));
            users.add(new User("Meâric", "mearic meariç MEARİC MEARIC MEARİÇ MEARIÇ Mearic Meariç Mearıc" , true));
            users.add(new User("Nuh", "nuh MUH" , true));
            users.add(new User("Cin", "cin CIN CİN Cın" , true));
            users.add(new User("Müzzemmil", "MUZEMMIL MUZEMMİL MÜZEMMİL MÜZEMMIL müzemmil muzemmil Muzemmil" , true));
            users.add(new User("Müddessir", "Mudessir müdessir mudessir MUDESSİR MUDESSIR MÜDESSİR MÜDESSIR" , true));
            users.add(new User("Kıyamet", "KIYAMET KİYAMET kıyamet kiyamet Kiyamet" , true));
            users.add(new User("İnsan", "Insan insan ınsan INSAN İNSAN" , true));
            users.add(new User("Mürselât", "MURSELAT MÜRSELAT mürselat murselat Murselat Mürselat" , true));
            users.add(new User("Nebe'", "nebe NEBE Nebe" , true));
            users.add(new User("Nâziât", "Naziat NAZIAT NAZİAT naziat nazıat Nazıat" , true));
            users.add(new User("Abese", "abese ABESE" , true));
            users.add(new User("Tekvir", "TEKVİR TEKVIR tekvir Tekvır" , true));
            users.add(new User("İnfitâr", "infitar ınfıtar INFITAR İNFİTAR İnfitar Infıtar Infitar" , true));
            users.add(new User("Mutaffifin", "mutaffifin mutaffıfın MUTAFFIFIN MUTAFFİFİN Mutaffıfın" , true));
            users.add(new User("İnşikak", "Insikak Inşikak Insıkak Inşıkak İNŞİKAK INSIKAK INŞIKAK inşikak ınsıkak ınşıkak" , true));
            users.add(new User("Bürûc", "buruc büruc BURUC BÜRUC Büruc Buruc" , true));
            users.add(new User("Târık", "tarık tarik TARIK TARİK Tarık Tarik" , true));
            users.add(new User("A'lâ", "A la a la ala ALA Ala A LA" , true));
            users.add(new User("Gâşiye", "gaşiye ğaşiye ĞAŞİYE GAŞİYE GASIYE GAŞIYE GASİYE Gasiye Gaşiye Ğaşiye Ğasiye" , true));
            users.add(new User("Fecr", "fecr FECR" , true));
            users.add(new User("Beled", "BELED beled" , true));
            users.add(new User("Şems", "sems şems SEMS ŞEMS Sems" , true));
            users.add(new User("Leyl", "leyl LEYL" , true));
            users.add(new User("Duhâ", "DUHA duha Duha" , true));
            users.add(new User("İnşirâh", "Insirah Inşirah Insırah Inşırah İnşirah İnsirah inşirah ınsırah ınşırah INSIRAH INŞIRAH İNŞİRAH" , true));
            users.add(new User("Tin", "tin TIN TİN tın" , true));
            users.add(new User("Alak", "alak ALAK" , true));
            users.add(new User("Kadir", "KADIR KADİR Kadır kadir kadır" , true));
            users.add(new User("Beyyine", "beyyine BEYYİNE BEYYINE beyyıne Beyyıne" , true));
            users.add(new User("Zilzâl", "Zilzal Zılzal ZILZAL ZİLZAL zilzal zılzal" , true));
            users.add(new User("Âdiyât", "adiyat ADIYAT ADİYAT Adiyat Adıyat" , true));
            users.add(new User("Kâria", "karia KARIA KARİA " , true));
            users.add(new User("Tekâsür", "tekasür tekasur Tekasür Tekasur TEKASUR TEKASÜR" , true));
            users.add(new User("Asr", "ASR asr" , true));
            users.add(new User("Hümeze", "humeze HUMEZE hümeze HÜMEZE Humeze" , true));
            users.add(new User("Fil", "FİL FIL Fıl fil fıl" , true));
            users.add(new User("Kureyş", "kureyş kureys KUREYS KUREYŞ Kureys" , true));
            users.add(new User("Mâûn", "Maun maun MAUN" , true));
            users.add(new User("Kevser", "KEVSER kevser" , true));
            users.add(new User("Kâfirûn", "kafirun kafırun KAFIRUN KAFİRUN Kafirun Kafırun" , true));
            users.add(new User("Nasr", "nasr NASR" , true));
            users.add(new User("Tebbet", "TEBBET tebbet" , true));
            users.add(new User("İhlâs", "ihlas ıhlas IHLAS İHLAS İhlas Ihlas" , true));
            users.add(new User("Felâk", "felak FELAK Felak" , true));
            users.add(new User("Nâs", "nas NAS Nas" , true));

         */
           
            //adapter = new CustomAdapter(nassar.this,users);
        //listView.setAdapter(arrayAdapter);

        final FloatingActionButton fab = findViewById(R.id.fab1);
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


        /*

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, final View view , int position, long id) {
                            // if (media1 != null) {
                             //   if (!media1.isPlaying()) {
                                    // media1.start();
                              //      fab.setImageResource(R.drawable.pause);
                                //} else {
                                    // media1.pause();
                                  //  fab.setImageResource(R.drawable.play);
                                //}
                            //}
                           // listView.setTag("erkan");
                            //Toast.makeText(nassar.this, CustomAdapter.İD, Toast.LENGTH_SHORT).show();
                            Toast.makeText(nassar.this,arrayAdapter.getItem(position), Toast.LENGTH_SHORT).show();
                           //Toast.makeText(nassar.this,""+arrayAdapter.getItem(position), Toast.LENGTH_SHORT).show();
                            //CharSequence charSequence = user.getUserName();

                            //player = new Intent(nassar.this, sesplayer.class);
                            //player.putExtra("isim",charSequence);
                           // startActivity(player);
                            //surepozisyonu = position;
                            //loadingDialog.startLoadingDialog();
                            //Toast.makeText(getApplicationContext(),isimlerr[(int) id], Toast.LENGTH_SHORT).show();
                            MainActivity.internet = 1;
                            if (media1 != null && media1.isPlaying()) {
                                media1.stop();
                            }
                                //switch (position){
                                  //  case 0:
                                    //    nassarses = "http://erkantr.tk/fatiha.mp3";
                                      //  break;
                                    //case 1:
                                      //  nassarses = "https://ia601407.us.archive.org/24/items/nasser-al-qatami/bakara.mp3";
                                       // break;
                                //}
                            //String isim = parent.getItemAtPosition(position).toString();
                            //Snackbar.make(view, CustomAdapter.isim, Snackbar.LENGTH_LONG)
                              //      .setAction("Action", null).show();
                            //switch (isim){
                              //  case "Fâtiha":
                                //    nassarses = nasser0;
                                  //  break;
                            //}
                           // switch (isim){
                             //   case "Fâtiha":
                               //     nassarses = nasser0;
                                 //   break;
                            //}
                            //switch (CustomAdapter.isim){
                              //  case "Bakara":
                               //     nassarses =nasser1;
                                 //   break;
                            //}
                          // user =  users.get(position);
                            //switch (user.getUserName()) {
                              //  case "Bakara":
                                //    nassarses = nasser1;
                                  //  break;

                            //}
                            //userss = (User) listView.getAdapter().getItem(position);
                           // switch (userss.getUserName()){
                             //   case "Bakara":
                                //    Toast.makeText(nassar.this, "Bakara suresi", Toast.LENGTH_SHORT).show();
                            //}
                                switch (position){
                                    case 0:
                                    nassarses = nasser0;
                                    nassarvideo = nasserv0;

                                break;
                                    case 1:
                                    nassarses = nasser1;
                                    nassarvideo = nasserv1;
                                break;
                                    case 2:
                                    nassarses = nasser2;
                                        nassarvideo = nasserv2;
                                break;
                                    case 3:
                                    nassarses = nasser3;
                                        nassarvideo = nasserv3;
                                break;
                                    case 4:
                                    nassarses = nasser4;
                                        nassarvideo = nasserv4;
                                break;
                                    case 5:
                                    nassarses = nasser5;
                                        nassarvideo = nasserv5;
                                break;
                                    case 6:
                                    nassarses = nasser6;
                                        nassarvideo = nasserv6;
                                break;
                                    case 7:
                                    nassarses = nasser7;
                                        nassarvideo = nasserv7;
                                break;
                                    case 8:
                                    nassarses = nasser8;
                                        nassarvideo = nasserv8;
                                break;
                                    case 9:
                                    nassarses = nasser9;
                                        nassarvideo = nasserv9;
                                break;
                                    case 10:
                                    nassarses = nasser10;
                                        nassarvideo = nasserv10;
                                break;
                                    case 11:
                                    nassarses = nasser11;
                                        nassarvideo = nasserv11;
                                break;
                                    case 12:
                                    nassarses = nasser12;
                                        nassarvideo = nasserv12;
                                break;
                                    case 13:
                                    nassarses = nasser13;
                                        nassarvideo = nasserv13;
                                break;
                                    case 14:
                                    nassarses = nasser14;
                                        nassarvideo = nasserv14;
                                break;
                                    case 15:
                                    nassarses = nasser15;
                                        nassarvideo = nasserv15;
                                break;
                                    case 16:
                                    nassarses = nasser16;
                                        nassarvideo = nasserv16;
                                break;
                                    case 17:
                                    nassarses = nasser17;
                                        nassarvideo = nasserv17;
                                break;
                                    case 18:
                                    nassarses = nasser18;
                                        nassarvideo = nasserv18;
                                break;
                                    case 19:
                                    nassarses = nasser19;
                                        nassarvideo = nasserv19;
                                break;
                                    case 20:
                                    nassarses = nasser20;
                                        nassarvideo = nasserv20;
                                break;
                                    case 21:
                                    nassarses = nasser21;
                                        nassarvideo = nasserv21;
                                break;
                                    case 22:
                                    nassarses = nasser22;
                                        nassarvideo = nasserv22;
                                break;
                                    case 23:
                                    nassarses = nasser23;
                                        nassarvideo = nasserv23;
                                break;
                                    case 24:
                                    nassarses = nasser24;
                                        nassarvideo = nasserv24;
                                break;
                                    case 25:
                                    nassarses = nasser25;
                                        nassarvideo = nasserv25;
                                break;
                                    case 26:
                                    nassarses = nasser26;
                                        nassarvideo = nasserv26;
                                break;
                                    case 27:
                                    nassarses = nasser27;
                                        nassarvideo = nasserv27;
                                break;
                                    case 28:
                                    nassarses = nasser28;
                                        nassarvideo = nasserv28;
                                break;
                                    case 29:
                                    nassarses = nasser29;
                                        nassarvideo = nasserv29;
                                break;
                                    case 30:
                                    nassarses = nasser30;
                                        nassarvideo = nasserv30;
                                break;
                                    case 31:
                                    nassarses = nasser31;
                                        nassarvideo = nasserv31;
                                break;
                                    case 32:
                                    nassarses = nasser32;
                                        nassarvideo = nasserv32;
                                break;
                                    case 33:
                                    nassarses = nasser33;
                                        nassarvideo = nasserv33;
                                break;
                                    case 34:
                                    nassarses = nasser34;
                                        nassarvideo = nasserv34;
                                break;
                                    case 35:
                                    nassarses = nasser35;
                                        nassarvideo = nasserv35;
                                break;
                                    case 36:
                                    nassarses = nasser36;
                                        nassarvideo = nasserv36;
                                break;
                                    case 37:
                                    nassarses = nasser37;
                                        nassarvideo = nasserv37;
                                break;
                                    case 38:
                                    nassarses = nasser38;
                                        nassarvideo = nasserv38;
                                break;
                                    case 39:
                                    nassarses = nasser39;
                                        nassarvideo = nasserv39;
                                break;
                                    case 40:
                                    nassarses = nasser40;
                                        nassarvideo = nasserv40;
                                break;
                                    case 41:
                                    nassarses = nasser41;
                                        nassarvideo = nasserv41;
                                break;
                                    case 42:
                                    nassarses = nasser42;
                                        nassarvideo = nasserv42;
                                break;
                                    case 43:
                                    nassarses = nasser43;
                                break;
                                    case 44:
                                    nassarses = nasser44;
                                break;
                                    case 45:
                                    nassarses = nasser45;
                                break;
                                    case 46:
                                    nassarses = nasser46;
                                break;
                                    case 47:
                                    nassarses = nasser47;
                                break;
                                    case 48:
                                    nassarses = nasser48;
                                break;
                                    case 49:
                                    nassarses = nasser49;
                                break;
                                    case 50:
                                    nassarses = nasser50;
                                break;
                                    case 51:
                                    nassarses = nasser51;
                                break;
                                    case 52:
                                    nassarses = nasser52;
                                break;
                                    case 53:
                                    nassarses = nasser53;
                                break;
                                    case 54:
                                    nassarses = nasser54;
                                break;
                                    case 55:
                                    nassarses = nasser55;
                                break;
                                    case 56:
                                    nassarses = nasser56;
                                break;
                                    case 57:
                                    nassarses = nasser57;
                                break;
                                    case 58:
                                    nassarses = nasser58;
                                break;
                                    case 59:
                                    nassarses = nasser59;
                                break;
                                    case 60:
                                    nassarses = nasser60;
                                break;
                                    case 61:
                                    nassarses = nasser61;
                                break;
                                    case 62:
                                    nassarses = nasser62;
                                break;
                                    case 63:
                                    nassarses = nasser63;
                                break;
                                    case 64:
                                    nassarses = nasser64;
                                break;
                                    case 65:
                                    nassarses = nasser65;
                                break;
                                    case 66:
                                    nassarses = nasser66;
                                break;
                                    case 67:
                                    nassarses = nasser67;
                                break;
                                    case 68:
                                    nassarses = nasser68;
                                break;
                                    case 69:
                                    nassarses = nasser69;
                                break;
                                    case 70:
                                    nassarses = nasser70;
                                break;
                                    case 71:
                                    nassarses = nasser71;
                                break;
                                    case 72:
                                    nassarses = nasser72;
                                break;
                                    case 73:
                                    nassarses = nasser73;
                                break;
                                    case 74:
                                    nassarses = nasser74;
                                break;
                                    case 75:
                                    nassarses = nasser75;
                                break;
                                    case 76:
                                    nassarses = nasser76;
                                break;
                                    case 77:
                                    nassarses = nasser77;
                                break;
                                    case 78:
                                    nassarses = nasser78;
                                break;
                                    case 79:
                                    nassarses = nasser79;
                                break;
                                    case 80:
                                    nassarses = nasser80;
                                break;
                                    case 81:
                                    nassarses = nasser81;
                                break;
                                    case 82:
                                    nassarses = nasser82;
                                break;
                                    case 83:
                                    nassarses = nasser83;
                                break;
                                    case 84:
                                    nassarses = nasser84;
                                break;
                                    case 85:
                                    nassarses = nasser85;
                                break;
                                    case 86:
                                    nassarses = nasser86;
                                break;
                                    case 87:
                                    nassarses = nasser87;
                                break;
                                    case 88:
                                    nassarses = nasser88;
                                break;
                                    case 89:
                                    nassarses = nasser89;
                                break;
                                    case 90:
                                    nassarses = nasser90;
                                break;
                                    case 91:
                                    nassarses = nasser91;
                                break;
                                    case 92:
                                    nassarses = nasser92;
                                break;
                                    case 93:
                                    nassarses = nasser93;
                                break;
                                    case 94:
                                    nassarses = nasser94;
                                break;
                                    case 95:
                                    nassarses = nasser95;
                                break;
                                    case 96:
                                    nassarses = nasser96;
                                break;
                                    case 97:
                                    nassarses = nasser97;
                                break;
                                    case 98:
                                    nassarses = nasser98;
                                break;
                                    case 99:
                                    nassarses = nasser99;
                                break;
                                    case 100:
                                    nassarses = nasser100;
                                break;
                                    case 101:
                                    nassarses = nasser101;
                                break;
                                    case 102:
                                    nassarses = nasser102;
                                break;
                                    case 103:
                                    nassarses = nasser103;
                                break;
                                    case 104:
                                    nassarses = nasser104;
                                break;
                                    case 105:
                                    nassarses = nasser105;
                                break;
                                    case 106:
                                    nassarses = nasser106;
                                break;
                                    case 107:
                                    nassarses = nasser107;
                                break;
                                    case 108:
                                    nassarses = nasser108;
                                break;
                                    case 109:
                                    nassarses = nasser109;
                                break;
                                    case 110:
                                    nassarses = nasser110;
                                break;
                                    case 111:
                                    nassarses = nasser111;
                                break;
                                    case 112:
                                    nassarses = nasser112;
                                break;
                                    case 113:
                                    nassarses = nasser113;
                                break;
                                }
                           // player = new Intent(nassar.this, sesplayer.class);
                            //startActivity(player);
                            //dialog1 = 1;


                               // if (ileri ==0){
                                 //   media1.stop();
                                   //Uri uri = Uri.parse(link[position + 1]);
                                    //mediaPlayer.setDataSource(getApplicationContext(), uri);
                                    //mediaPlayer.prepare();
                                    //mediaPlayer.start();
                                //}else{

                                //}
                            if (tumsureler.b == 2 ) {
                                //if (media1 != null){
                                //media1.start();
                                CountDownTimer newCount;
                                //loadingDialog.startLoadingDialog();
                                newCount = new CountDownTimer(1000, 5000) {
                                    @Override
                                    public void onTick(long millisUntilFinished) {
                                    }

                                    @Override
                                    public void onFinish() {
                                       // countDownTimer = new CountDownTimer(600, 500) {
                                         //   @Override
                                           // public void onTick(long millisUntilFinished) {
                                             //   System.out.println((millisUntilFinished / 1000));
                                                //media1 = MediaPlayer.create(nassar.this, Uri.parse(nassarses));
                                               // loadingDialog.dismissDialog();
                                            //}

                                            //@Override
                                            //public void onFinish() {
                                                if (networkConnection() && media1 != null) {
                                                    //player = new Intent(nassar.this, sesplayer.class);
                                                 //startActivity(player);
                                                    //}
                                                    //}.start();
                                                    loadingDialog.dismissDialog();

                                                    overridePendingTransition(R.anim.right_in, R.anim.left_out);
                                                } else {
                                                    Snackbar.make(view, "İnternet Bağlantınızı Kontrol Edin.", Snackbar.LENGTH_LONG)
                                                            .setAction("Action", null).show();
                                                   // loadingDialog.dismissDialog();
                                                }
                                            }
                                        }.start();
                                    }
                               // }.start();
                            //}
                                    //}
                                    //if (internet == 1){

                                    // if (internet == 0){
                                    //   Snackbar.make(view, "İnternet Bağlantınız Zaman Aşımına Uğradı.", Snackbar.LENGTH_LONG)
                                    //      .setAction("Action", null).show();

                                    // }
                                    //Intent yukleme = new Intent(nassar.this,LoadingDialog.class);
                                    //startActivity(yukleme);
                            if (tumsureler.b == 1){
                                if (networkConnection()) {
                                player = new Intent(nassar.this, videoplayer.class);
                                startActivity(player);
                                } else {
                                    Snackbar.make(view, "İnternet Bağlantınızı Kontrol Edin.", Snackbar.LENGTH_LONG)
                                            .setAction("Action", null).show();
                                }
                            }

                      }
                    });

         */

        //if (sesplayer.d == 0){
          //  loadingDialog.dismissDialog();
        //}
               }
       public boolean networkConnection() {
           ConnectivityManager conMgr = (ConnectivityManager) nassar.this.getSystemService(Context.CONNECTIVITY_SERVICE);
           if (conMgr.getActiveNetworkInfo() != null && conMgr.getActiveNetworkInfo().isAvailable() && conMgr.getActiveNetworkInfo().isConnected()) {
               return true;
           } else {
               return false;
           }
       }
        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            switch (item.getItemId()) {
                // Respond to the action bar's Up/Home button
                case android.R.id.home:
                    ileri = 1;
                    CustomAdapter.a = 2;
                    NavUtils.navigateUpFromSameTask(this);
                    //overridePendingTransition(R.anim.left_out,R.anim.left_out);
                    return true;
            }
            return super.onOptionsItemSelected(item);
        }
        @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomAdapter.arama = 1;
                Toast.makeText(nassar.this, "Aramaya tıklandııı", Toast.LENGTH_SHORT).show();
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                CustomAdapter.arama = 1;
                //adapter.getFilter().filter(newText);
                //arrayAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
/*
        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            getMenuInflater().inflate(R.menu.main, menu);
            MenuItem item = menu.findItem(R.id.action_search);
            SearchView searchView = (SearchView) item.getActionView();
           searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
               @Override
               public boolean onQueryTextSubmit(String query) {
                   return false;
               }

               @Override
               public boolean onQueryTextChange(String newText) {
                   adapter.getFilter().filter(newText);
                   if (newText != null && !newText.isEmpty()) {
                          //userss = (User) listView.getAdapter().getItem(position);
                       List<User> userssearch = new ArrayList<User>();
                       for (User item : users) {
                           if (item.getFiltre().contains(newText)) {

                               userssearch.add(item);
                           }
                           if (item.getUserName().contains(newText)) {
                               userssearch.add(item);
                               //Toast.makeText(getApplicationContext(), item.getUserName(), Toast.LENGTH_SHORT).show();
                           }
                           switch (item.getUserName()) {
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
                               case "En'âm":
                                   nassarses = nasser5;
                                   break;
                               case "A'râf":
                                   nassarses = nasser6;
                                   break;
                               case "Enfâl":
                                   nassarses =nasser7;
                                   break;
                               case "Tevbe":
                                   nassarses = nasser8;
                                   break;
                               case "Yunus":
                                   nassarses = nasser9;
                                   break;
                               case "Hûd":
                                   nassarses =nasser10;
                                   break;
                               case "Yusuf":
                                   nassarses = nasser11;
                                   break;
                               case "Ra'd":
                                   nassarses = nasser12;
                                   break;
                               case "İbrahim":
                                   nassarses =nasser13;
                                   break;
                               case "Hicr":
                                   nassarses =nasser14;
                                   break;
                               case "Nahl":
                                   nassarses = nasser15;
                                   break;
                               case "İsrâ":
                                nassarses = nasser16;
                                   break;
                               case "Kehf":
                                   nassarses = nasser17;
                                   break;
                               case "Meryem":
                                   nassarses = nasser18;
                                   break;
                               case "Tâ-Hâ":
                                   nassarses = nasser19;
                                   break;
                               case "Enbiyâ":
                                   nassarses = nasser20;
                                   break;
                               case "Hac":
                                   nassarses = nasser21;
                                   break;
                               case "Mü'minûn":
                                   nassarses = nasser22;
                                   break;
                               case "Furkan":
                                   nassarses = nasser23;
                                   break;
                               case "Şuarâ":
                                   nassarses = nasser24;
                                   break;
                               case "Neml":
                                   nassarses = nasser25;
                                   break;
                               case "Kasas":
                                   nassarses = nasser26;
                                   break;
                               case "Ankebût":
                                   nassarses = nasser27;
                                   break;
                               case "Rûm":
                                   nassarses = nasser28;
                                   break;
                               case "Lokman":
                                   nassarses = nasser29;
                                   break;
                               case "Secde":
                                   nassarses = nasser30;
                                   break;
                               case "Ahzâb":
                                   nassarses = nasser31;
                                   break;
                               case "Sebe'":
                                   nassarses = nasser32;
                                   break;
                               case "Fâtır":
                                   nassarses = nasser33;
                                   break;
                               case "Yâsin":
                                   nassarses = nasser34;
                                   break;
                               case "Sâffât":
                                   nassarses = nasser35;
                                   break;
                               case "Sâd":
                                   nassarses = nasser36;
                                   break;
                               case "Zümer":
                                   nassarses = nasser37;
                                   break;
                               case "Mü'min":
                                   nassarses = nasser38;
                                   break;
                               case "Fussilet":
                                   nassarses = nasser39;
                                   break;
                               case "Şûrâ":
                                   nassarses = nasser40;
                                   break;
                               case "Zuhruf":
                                   nassarses = nasser41;
                                   break;
                               case "Duhân":
                                   nassarses = nasser42;
                                   break;
                               case "Câsiye":
                                   nassarses = nasser43;
                                   break;
                               case "Ahkaf":
                                   nassarses = nasser44;
                                   break;
                               case "Muhammed":
                                   nassarses = nasser45;
                                   break;
                               case "Fetih":
                                   nassarses = nasser46;
                                   break;
                               case "Hucurât":
                                   nassarses = nasser47;
                                   break;
                               case "Kaf":
                                   nassarses = nasser48;
                                   break;
                               case "Zâriyât":
                                   nassarses = nasser49;
                                   break;
                               case "Tûr":
                                   nassarses = nasser50;
                                   break;
                               case "Necm":
                                   nassarses = nasser51;
                                   break;
                               case "Kamer":
                                   nassarses = nasser52;
                                   break;
                               case "Rahmân":
                                   nassarses = nasser53;
                                   break;
                               case "Vâkıa":
                                   nassarses = nasser54;
                                   break;
                               case "Hadid":
                                   nassarses = nasser55;
                                   break;
                               case "Mücâdele":
                                   nassarses = nasser56;
                                   break;
                               case "Haşr":
                                   nassarses = nasser57;
                                   break;
                               case "Mümtehine":
                                   nassarses = nasser58;
                                   break;
                               case "Saf":
                                   nassarses = nasser59;
                                   break;
                               case "Cum'a":
                                   nassarses = nasser60;
                                   break;
                               case "Münâfikûn":
                                   nassarses = nasser61;
                                   break;
                               case "Teğabün ":
                                   nassarses = nasser62;
                                   break;
                               case "Talâk":
                                   nassarses = nasser63;
                                   break;
                               case "Tahrim":
                                   nassarses = nasser64;
                                   break;
                               case "Mülk":
                                   nassarses = nasser65;
                                   break;
                               case "Kalem":
                                   nassarses= nasser66;
                               break;
                               case "Hâkka":
                                   nassarses = nasser67;
                                   break;
                               case "Meâric":
                                   nassarses = nasser68;
                                   break;
                               case "Nuh":
                                   nassarses = nasser69;
                                   break;
                               case "Cin":
                                   nassarses = nasser70;
                                   break;
                               case "Müzzemmil":
                                   nassarses = nasser71;
                                   break;
                               case "Müddessir":
                                   nassarses = nasser72;
                                   break;
                               case "Kıyamet":
                                   nassarses = nasser73;
                                   break;
                               case "İnsan":
                                   nassarses = nasser74;
                                   break;
                               case "Mürselât":
                                   nassarses = nasser75;
                                   break;
                               case "Nebe'":
                                   nassarses = nasser76;
                                   break;
                               case "Nâziât":
                                   nassarses = nasser77;
                                   break;
                               case "Abese":
                                   nassarses = nasser78;
                                   break;
                               case "Tekvir":
                                   nassarses = nasser79;
                                   break;
                               case "İnfitâr":
                                   nassarses = nasser80;
                                   break;
                               case "Mutaffifin":
                                   nassarses = nasser81;
                                   break;
                               case "İnşikak":
                                   nassarses = nasser82;
                                   break;
                               case "Bürûc":
                                   nassarses = nasser83;
                                   break;
                               case "Târık":
                               nassarses = nasser84;
                                   break;
                               case "A'lâ":
                                   nassarses = nasser85;
                               break;
                               case "Gâşiye":
                                   nassarses = nasser86;
                                   break;
                               case "Fecr":
                                   nassarses = nasser87;
                                   break;
                               case "Beled":
                                   nassarses = nasser88;
                                   break;
                               case "Şems":
                                   nassarses = nasser89;
                               case "Leyl":
                                   nassarses = nasser90;
                                   break;
                               case "Duhâ":
                                   nassarses = nasser91;
                                   break;
                               case "İnşirâh":
                                   nassarses = nasser92;
                                   break;
                               case "Tin":
                                   nassarses = nasser93;
                                   break;
                               case "Alak":
                                   nassarses = nasser94;
                                   break;
                               case "Kadir":
                                   nassarses = nasser95;
                                   break;
                               case "Beyyine":
                                   nassarses = nasser96;
                                   break;
                               case "Zilzâl":
                                   nassarses = nasser97;
                                   break;
                               case "Âdiyât":
                                   nassarses = nasser98;
                                   break;
                               case "Kâria":
                                   nassarses = nasser99;
                                   break;
                               case "Tekâsür":
                                   nassarses = nasser100;
                                   break;
                               case "Asr":
                                   nassarses =nasser101;
                                   break;
                               case "Hümeze":
                                   nassarses = nasser102;
                               case "Fil ":
                                   nassarses = nasser103;
                                   break;
                               case "Kureyş":
                                   nassarses = nasser104;
                                   break;
                               case "Mâûn":
                                   nassarses = nasser105;
                                   break;
                               case "Kevser":
                                   nassarses = nasser106;
                                   break;
                               case "Kâfirûn":
                                   nassarses = nasser107;
                                   break;
                               case "Nasr":
                                   nassarses = nasser108;
                                   break;
                               case "Tebbet":
                                   nassarses = nasser109;
                                   break;
                               case "İhlâs":
                                   nassarses = nasser110;
                               case "Felâk":
                                   nassarses = nasser111;
                                   break;
                               case "Nâs":
                                   nassarses = nasser112;
                                   break;
                           }

                   }

                       CustomAdapter adapter = new CustomAdapter(nassar.this, userssearch);
                       listView.setAdapter(adapter);
                   }
                   else{
                       CustomAdapter adapter = new CustomAdapter(nassar.this, users);
                       listView.setAdapter(adapter);
                   }
                   return false;
               }

           });

            searchView.setOnCloseListener(new SearchView.OnCloseListener() {
                @Override
                public boolean onClose() {
                    arama = 0;
                    return true;
                }
            });

            return true;
        }

 */

        @Override
        public boolean onKeyDown ( int keyCode, KeyEvent event){
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                ileri = 1;
                CustomAdapter.a = 2;
                overridePendingTransition(R.anim.right_in,R.anim.left_out);
            }
            return super.onKeyDown(keyCode, event);
        }

    public static void isimdegisme(){

        //sesplayer.sureisim.setText(user.getUserName());

    }

    }