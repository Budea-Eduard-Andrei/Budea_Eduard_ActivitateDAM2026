package com.example.gem3;

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

    private List<Zbor> listaZboruri = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button btnAdauga = findViewById(R.id.budea_eduard_btn_adauga);
        btnAdauga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AdaugareZbor.class);
                startActivityForResult(intent,100);
            }
        });

        Button btnLista = findViewById(R.id.budea_eduard_btn_lista);
        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentZ = new Intent(MainActivity.this, ListaActivity.class);
                ArrayList<Zbor> listaDeTrimis = new ArrayList<>(listaZboruri);
                intentZ.putExtra("lista_de_trimis", listaDeTrimis);
                startActivity(intentZ);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100 && resultCode == RESULT_OK){
            if(data!=null){
                Zbor zbor = (Zbor) data.getSerializableExtra("zbor_nou");
                listaZboruri.add(zbor);
            }
        }
    }
}