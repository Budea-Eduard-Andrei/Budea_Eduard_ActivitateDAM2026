package com.example.seminar07_2026;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AdaugaBaterie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adauga_baterie);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText etMarca = findViewById(R.id.nume_ET);
        Switch switchFastCharge = findViewById(R.id.nume_SW);
        Spinner spinnerCapacitate = findViewById(R.id.spinnerCapacitate);
        Button btnSalveaza = findViewById(R.id.btnSalveazaDate);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("obiect_baterie")) {
            Baterie bateriePrimita = intent.getParcelableExtra("obiect_baterie");

            if (bateriePrimita != null) {
                etMarca.setText(bateriePrimita.getMarca());
                switchFastCharge.setChecked(bateriePrimita.isEsteReincarcabila());

                String capacitateCurenta = String.valueOf(bateriePrimita.getCapacitate());
                for (int i = 0; i < spinnerCapacitate.getCount(); i++) {
                    if (spinnerCapacitate.getItemAtPosition(i).toString().equals(capacitateCurenta)) {
                        spinnerCapacitate.setSelection(i);
                        break;
                    }
                }
            }
        }

        btnSalveaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String marca = etMarca.getText().toString();
                boolean areFastCharge = switchFastCharge.isChecked();

                String valoareSpinner = spinnerCapacitate.getSelectedItem().toString();
                int capacitate = Integer.parseInt(valoareSpinner);

                Baterie baterieNoua = new Baterie(marca, capacitate, areFastCharge);

                Intent intentReturn = new Intent();
                intentReturn.putExtra("obiect_baterie", baterieNoua);

                setResult(RESULT_OK, intentReturn);
                finish();
            }
        });
    }
}