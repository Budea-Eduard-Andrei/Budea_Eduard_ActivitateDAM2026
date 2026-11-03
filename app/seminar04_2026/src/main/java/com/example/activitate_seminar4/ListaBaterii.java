package com.example.activitate_seminar4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListaBaterii extends AppCompatActivity {

    private ArrayList<Baterie> listaPrimita = null;
    private BaterieAdapter adapter = null;
    private int idModificat = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_baterii);

        ListView listView = findViewById(R.id.listViewBaterii);
        Button btnInapoi = findViewById(R.id.btnInapoi);
        Intent intent = getIntent();

        if (intent != null && intent.hasExtra("lista_baterii")) {
            listaPrimita = intent.getParcelableArrayListExtra("lista_baterii");

            if (listaPrimita != null) {
                adapter = new BaterieAdapter(this, R.layout.layoutlistview, listaPrimita);
                listView.setAdapter(adapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intentModifica = new Intent(ListaBaterii.this, AdaugaBaterie.class);
                        intentModifica.putExtra("obiect_baterie", listaPrimita.get(position));
                        idModificat = position;
                        startActivityForResult(intentModifica, 2);
                    }
                });

                listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                        listaPrimita.remove(position);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(ListaBaterii.this, "Baterie ștearsă!", Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
            }
        }

        btnInapoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 2 && resultCode == RESULT_OK && data != null) {
            Baterie baterieModificata = data.getParcelableExtra("obiect_baterie");

            if (baterieModificata != null && idModificat != -1) {
                listaPrimita.set(idModificat, baterieModificata);
                adapter.notifyDataSetChanged();
                Toast.makeText(this, "Baterie modificată cu succes!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}