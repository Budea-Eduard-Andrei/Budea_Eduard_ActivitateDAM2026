package com.example.pb2_grup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Tableta> listaTablete = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button btnAdauga = findViewById(R.id.budea_eduard_btn_adauga);
        btnAdauga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AdaugareActivity.class);
                startActivityForResult(intent,100);
            }
        });

        Button btnLista = findViewById(R.id.budea_eduard_btn_lista);
        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLista = new Intent(MainActivity.this, ListaACtivity.class);
                ArrayList<Tableta> listaDeTrimis = new ArrayList<>(listaTablete);
                intentLista.putExtra("lista_mea_de_tablete", listaDeTrimis);

                startActivity(intentLista);
            }
        });

    }

    protected void onActivityResult(int requestedCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestedCode,resultCode,data);
        if(requestedCode == 100 && resultCode == RESULT_OK){
            if(data != null){
                Tableta tabletaPrimita = (Tableta) data.getSerializableExtra("tableta_noua");
                listaTablete.add(tabletaPrimita);
            }
        }
    }
}