package com.example.kuranikerimm.oynatmaekranlari;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import com.example.kuranikerimm.R;
import com.example.kuranikerimm.ui.kuranikerim;
import com.github.barteksc.pdfviewer.PDFView;

import static com.example.kuranikerimm.strings.nasser1;

public class pdfviewer extends AppCompatActivity {

    private PDFView pdfView;
    //public static String kuranikerim;
    Button indirbutton,gericikis,isim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuran);

        WebView webview = (WebView) findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl(kuranikerim.kuranikerimlink);
        //webview.getSettings().setUserAgentString("Mozilla/5.0 (Windows NT 6.1; rv:15.0) Gecko/20120716 Firefox/15.0a2");
        //pdfView = findViewById(R.id.pdfviewer);
       // pdfView.fromAsset(R.drawable.bilgisayar hattı 2.pdf).load();
        //button = findViewById(R.id.buttonas);
        indirbutton = findViewById(R.id.indirbutton);
        gericikis = findViewById(R.id.gericikis);
        isim = findViewById(R.id.isim);
        isim.setText(kuranikerim.kitapismi);

        indirbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        gericikis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        final ProgressDialog progress = ProgressDialog.show(this, "Lütfen Bekleyin", "Yükleniyor....", true);
        progress.show();
        webview.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                System.out.println("Sayfa Yüklendi");
                //Toast.makeText(getApplicationContext(), "Sayfa yüklendi", Toast.LENGTH_SHORT).show();
                progress.dismiss();
            }

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(getApplicationContext(), "Bir hata oluştu", Toast.LENGTH_SHORT).show();
                progress.dismiss();
            }
        });
    }
}
