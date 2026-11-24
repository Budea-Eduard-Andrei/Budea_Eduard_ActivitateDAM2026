package com.example.pregatire_test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AdaugareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adaugare);

        EditText etCod = findViewById(R.id.eduard_andrei_et_cod);
        EditText etVolum = findViewById(R.id.eduard_andrei_et_volum);
        Switch switchFragil = findViewById(R.id.eduard_andrei_switch_fragil);
        RatingBar ratingBar = findViewById(R.id.eduard_andrei_ratingbar);
        Button btnSalvare = findViewById(R.id.eduard_andrei_btn_salvare);

        btnSalvare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cod = etCod.getText().toString();
                double volum = Double.parseDouble(etVolum.getText().toString());
                boolean esteFragil = switchFragil.isChecked();
                float rating = ratingBar.getRating();
                String culoare = "Nespecificat";

                Cutie cutie = new Cutie(cod, culoare, volum, esteFragil, rating);
                Intent intentResult = new Intent();
                intentResult.putExtra("cutie_noua", cutie);
                setResult(RESULT_OK, intentResult);
                finish();
            }
        });
    }
}