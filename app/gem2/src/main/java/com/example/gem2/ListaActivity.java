package com.example.gem2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista);
        ListView listview = findViewById(R.id.budea_eduard_lv_lista);

        Intent intent = getIntent();
        ArrayList<Masina> listaPrimita = new ArrayList<>();

        if(intent.hasExtra("lista_de_trimis")){
            listaPrimita = (ArrayList<Masina>) intent.getSerializableExtra("lista_de_trimis");
        }

        AdapterMasina adapter = new AdapterMasina(listaPrimita,this,R.layout.item_lista);
        listview.setAdapter(adapter);

    }
}