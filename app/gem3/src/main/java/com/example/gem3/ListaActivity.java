package com.example.gem3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
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
        ListView listView = findViewById(R.id.budea_eduard_lv_lista);

        Intent intent = getIntent();
        ArrayList<Zbor> listaPrimita = new ArrayList<>();

        if(intent.hasExtra("lista_de_trimis")){
            listaPrimita = (ArrayList<Zbor>) intent.getSerializableExtra("lista_de_trimis");
        }

        AdapterZbor adapter = new AdapterZbor(listaPrimita,this,R.layout.item_lista);
        listView.setAdapter(adapter);
    }
}