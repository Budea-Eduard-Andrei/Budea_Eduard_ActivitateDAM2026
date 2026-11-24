package com.example.gem4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListaActivity extends AppCompatActivity {

    ArrayList<Film> listaPrimita = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista);
        ListView listView = findViewById(R.id.budea_eduard_lv_lista);

        Intent intent = getIntent();


        if(intent.hasExtra("lista_de_trimis")){
            listaPrimita = (ArrayList<Film>) intent.getSerializableExtra("lista_de_trimis");
        }

        AdapterFIlm adapterFIlm = new AdapterFIlm(listaPrimita,this,R.layout.item_lista);
        listView.setAdapter(adapterFIlm);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Film filmSelectat = listaPrimita.get(position);
                Toast.makeText(ListaActivity.this,"Ai selectat filmul: " + filmSelectat.getTitlu(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}