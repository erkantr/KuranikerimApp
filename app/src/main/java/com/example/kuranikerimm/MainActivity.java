package com.example.kuranikerimm;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.kuranikerimm.ses_listesi.nassar;
import com.google.android.material.navigation.NavigationView;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    public static int internet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final LoadingDialog loadingDialog = new LoadingDialog(MainActivity.this);

        if (internet == 1){

            loadingDialog.startLoadingDialog();
        } else {
//            loadingDialog.dismissDialog();
        }

        overridePendingTransition(R.anim.left_out, R.anim.right_in);
        //Button kuran = findViewById(R.id.kuranikerim);
        //kuran.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View v) {

                //Intent kuran = new Intent(MainActivity.this, com.example.kuranikerimm.oynatmaekranlari.kuran.class);
              //  startActivity(kuran);

          //  }
        //});



        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,R.id.kuranikerim,R.id.meal,R.id.tefsir)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

      /*  nassar.searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {

            }

            @Override
            public void onSearchViewClosed() {
                CustomAdapter adapter = new CustomAdapter(MainActivity.this, nassar.users);
                nassar.listView.setAdapter(adapter);
            }
        });

        nassar.searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText != null && !newText.isEmpty()){
                    List<User> userssearch = new ArrayList<User>();
                    for (User item:nassar.users){
                        if (item.getUserName().contains(newText))
                            userssearch.add(item);
                    }
                    CustomAdapter adapter = new CustomAdapter(MainActivity.this, userssearch);
                    nassar.listView.setAdapter(adapter);
                }
                else{
                    CustomAdapter adapter = new CustomAdapter(MainActivity.this, nassar.users);
                    nassar.listView.setAdapter(adapter);
                }
                return true;
            }
        }); */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem item = menu.findItem(R.id.action_search);

        SearchView searchView = (SearchView) item.getActionView();


        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode)
        {
            case 9:
                if(grantResults[0] > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    //permission granted
                    return;
                }
                break;
        }
    }
}
