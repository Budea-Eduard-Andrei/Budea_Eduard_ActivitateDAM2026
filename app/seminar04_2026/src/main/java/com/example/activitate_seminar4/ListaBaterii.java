package com.example.activitate_seminar4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListaBaterii extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_baterii);

        ListView listView = findViewById(R.id.listViewBaterii);
        Button btnInapoi = findViewById(R.id.btnInapoi);
        Intent intent = getIntent();

        if (intent != null && intent.hasExtra("lista_baterii")) {
            ArrayList<Baterie> listaPrimita = (ArrayList<Baterie>) intent.getSerializableExtra("lista_baterii");

            if (listaPrimita != null) {
                ArrayAdapter<Baterie> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaPrimita);
                listView.setAdapter(adapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Baterie baterieSelectata = listaPrimita.get(position);
                        Toast.makeText(ListaBaterii.this, baterieSelectata.toString(), Toast.LENGTH_LONG).show();
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
}