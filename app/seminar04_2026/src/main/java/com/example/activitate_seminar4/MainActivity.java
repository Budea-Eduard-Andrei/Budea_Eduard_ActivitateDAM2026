package com.example.activitate_seminar4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Baterie> listaBaterii = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void AdaugaBaterie(View view) {
        Intent intent = new Intent(this, AdaugaBaterie.class);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            Baterie bateriePrimita = (Baterie) data.getSerializableExtra("obiect_baterie");

            if (bateriePrimita != null) {
                listaBaterii.add(bateriePrimita);
                Toast.makeText(this, "Baterie adăugată! Total: " + listaBaterii.size(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void VeziLista(View view) {
        Intent intent = new Intent(this, ListaBaterii.class);
        intent.putExtra("lista_baterii", listaBaterii);
        startActivity(intent);
    }
}