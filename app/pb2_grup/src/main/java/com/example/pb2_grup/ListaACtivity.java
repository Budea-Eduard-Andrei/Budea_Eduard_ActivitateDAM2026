package com.example.pb2_grup;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListaACtivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista);
        ListView listView = findViewById(R.id.budea_eduard_lv_lista);

        Intent intent = getIntent();
        ArrayList<Tableta> listaPrimita = new ArrayList<>();

        if(intent.hasExtra("lista_mea_de_tablete")){
            listaPrimita = (ArrayList<Tableta>) intent.getSerializableExtra("lista_mea_de_tablete");
        }

        TabletaAdapter adapter = new TabletaAdapter(listaPrimita,this,R.layout.item_tableta);
        listView.setAdapter(adapter);
    }
}