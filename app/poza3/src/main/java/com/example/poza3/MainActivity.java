package com.example.poza3;

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

    List<Cutie> listaCutii = new ArrayList<>();

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
    }

    protected void onActivityResult(int requestedCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestedCode,resultCode,data);
        if(requestedCode == 100 && resultCode == RESULT_OK){
            if(data != null){
                Cutie cutiePrimita = (Cutie) data.getSerializableExtra("cutie_noua");
                listaCutii.add(cutiePrimita);
            }
        }
    }
}