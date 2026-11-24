package com.example.gem;

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

public class AdaugareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adaugare);

        EditText etId = findViewById(R.id.budea_eduard_et_id);
        EditText etPret = findViewById(R.id.budea_eduatd_et_pret);
        Switch switchGaming = findViewById(R.id.budea_eduard_switch_gaming);
        Spinner spinnerProcesor = findViewById(R.id.budea_eduard_spinner_procesor);

        Button btnSalveaza = findViewById(R.id.budea_eduard_btn_salveaza);
        btnSalveaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(etId.getText().toString());
                String procesor = spinnerProcesor.getSelectedItem().toString();
                float pret = Float.parseFloat(etPret.getText().toString());
                boolean gaming = switchGaming.isChecked();

                Laptop laptopnou = new Laptop(id,procesor,pret,gaming);
                Intent intent = new Intent();
                intent.putExtra("laptop_nou", laptopnou);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}