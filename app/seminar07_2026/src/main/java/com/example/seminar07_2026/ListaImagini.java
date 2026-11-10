package com.example.seminar07_2026;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ListaImagini extends AppCompatActivity {

    private List<ImaginiDomeniu> listaObiecte = new ArrayList<>();
    private List<Bitmap> imaginiDescarcate = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_imagini);

        ListView lv = findViewById(R.id.imagini);

        Toast.makeText(this, "Se descarcă imaginile...", Toast.LENGTH_SHORT).show();

        List<String> linkuriImagini = new ArrayList<>();
        linkuriImagini.add("https://images.unsplash.com/photo-1605152276897-4f618f831968?w=300");
        linkuriImagini.add("https://images.unsplash.com/photo-1596562095034-754e92a40660?w=300");
        linkuriImagini.add("https://images.unsplash.com/photo-1616781832049-74dcefa5e468?w=300");

        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.myLooper());

        executor.execute(new Runnable() {
            @Override
            public void run() {
                for (String link : linkuriImagini) {
                    try {
                        URL url = new URL(link);
                        HttpURLConnection con = (HttpURLConnection) url.openConnection();
                        InputStream is = con.getInputStream();
                        imaginiDescarcate.add(BitmapFactory.decodeStream(is));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (imaginiDescarcate.size() >= 3) {
                            listaObiecte.add(new ImaginiDomeniu("Baterie Externă", imaginiDescarcate.get(0), "https://ro.wikipedia.org/wiki/Acumulator_Li-ion"));
                            listaObiecte.add(new ImaginiDomeniu("Baterii Alcaline AA", imaginiDescarcate.get(1), "https://ro.wikipedia.org/wiki/Baterie_alcalin"));
                            listaObiecte.add(new ImaginiDomeniu("Baterie Auto", imaginiDescarcate.get(2), "https://ro.wikipedia.org/wiki/Acumulator_cu_plumb"));

                            ImagineAdapter adapter = new ImagineAdapter(ListaImagini.this, R.layout.item_imagine, listaObiecte);
                            lv.setAdapter(adapter);
                        } else {
                            Toast.makeText(ListaImagini.this, "Eroare la descărcare", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(ListaImagini.this, WebViewActivity.class);
                it.putExtra("link", listaObiecte.get(position).getLink());
                startActivity(it);
            }
        });
    }
}