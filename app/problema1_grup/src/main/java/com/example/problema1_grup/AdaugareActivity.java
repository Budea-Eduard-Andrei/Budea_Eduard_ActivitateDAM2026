package com.example.problema1_grup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

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

        EditText etId = findViewById(R.id.eduard_andrei_et_id);
        EditText etPret = findViewById(R.id.eduard_andrei_et_pret);

        RadioGroup rgTip = findViewById(R.id.eduard_andrei_rg_tip);
        RadioButton rbAlb = findViewById(R.id.eduard_andrei_rb_alb);
        RadioButton rbNegru = findViewById(R.id.eduard_andrei_rb_negru);

        Spinner spinnerProducator = findViewById(R.id.eduard_andrei_sp_producator);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.lista_producatori, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerProducator.setAdapter(adapter);

        Button btnSalvare = findViewById(R.id.eduard_andrei_btn_salvare);
        btnSalvare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = etId.getText().toString();
                float pret =Float.parseFloat(etPret.getText().toString());

                String producator = spinnerProducator.getSelectedItem().toString();

                int idButonBifat = rgTip.getCheckedRadioButtonId();
                RadioButton rbSelectat = findViewById(idButonBifat);
                String tipincarcare = rbSelectat.getText().toString();

                Incarcator incarcator = new Incarcator(id,producator,pret,tipincarcare, producator);
                Intent intentResult = new Intent();
                intentResult.putExtra("incarcator_nou", incarcator);
                setResult(RESULT_OK, intentResult);
                finish();
            }
        });
        }

    }
