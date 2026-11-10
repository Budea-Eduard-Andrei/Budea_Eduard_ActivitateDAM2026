package com.example.activitate_seminar4;

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

        // Cele 5 link-uri de imagini
        List<String> linkuriImagini = new ArrayList<>();
        linkuriImagini.add("https://images.unsplash.com/photo-1605152276897-4f618f831968?w=300");
        linkuriImagini.add("https://images.unsplash.com/photo-1596562095034-754e92a40660?w=300");
        linkuriImagini.add("https://images.unsplash.com/photo-1616781832049-74dcefa5e468?w=300");
        linkuriImagini.add("https://images.unsplash.com/photo-1581452391054-946761ce4c94?w=300");
        linkuriImagini.add("https://images.unsplash.com/photo-1605333555562-b9a527c1f8a8?w=300");

        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.myLooper());

        executor.execute(() -> {
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

            handler.post(() -> {
                if (imaginiDescarcate.size() >= 5) {
                    listaObiecte.add(new ImaginiDomeniu("Baterie Externă", imaginiDescarcate.get(0), "https://ro.wikipedia.org/wiki/Acumulator_Li-ion"));
                    listaObiecte.add(new ImaginiDomeniu("Baterii Alcaline AA", imaginiDescarcate.get(1), "https://ro.wikipedia.org/wiki/Baterie_alcalin%C4%83"));
                    listaObiecte.add(new ImaginiDomeniu("Baterie Auto", imaginiDescarcate.get(2), "https://ro.wikipedia.org/wiki/Acumulator_cu_plumb"));
                    listaObiecte.add(new ImaginiDomeniu("Baterie Telefon", imaginiDescarcate.get(3), "https://en.wikipedia.org/wiki/Lithium-ion_battery"));
                    listaObiecte.add(new ImaginiDomeniu("Baterie Laptop", imaginiDescarcate.get(4), "https://en.wikipedia.org/wiki/Smart_battery"));

                    ImagineAdapter adapter = new ImagineAdapter(ListaImagini.this, R.layout.item_imagine, listaObiecte);
                    lv.setAdapter(adapter);
                } else {
                    Toast.makeText(ListaImagini.this, "Eroare! S-au descărcat doar " + imaginiDescarcate.size() + " imagini din 5.", Toast.LENGTH_LONG).show();
                }
            });
        });

        lv.setOnItemClickListener((parent, view, position, id) -> {
            Intent it = new Intent(ListaImagini.this, WebViewActivity.class);
            it.putExtra("link", listaObiecte.get(position).getLink());
            startActivity(it);
        });
    }
}