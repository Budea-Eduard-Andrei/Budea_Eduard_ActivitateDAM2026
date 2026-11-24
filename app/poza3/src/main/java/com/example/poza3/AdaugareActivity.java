package com.example.poza3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
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

        ///RadioGroup rgCuloare = findViewById(R.id.incercare_radio_grup);
        EditText etCod = findViewById(R.id.budea_eduard_et_cod);
        EditText etCuloare = findViewById(R.id.budea_eduard_et_culoare);
        Switch switchFragila = findViewById(R.id.budea_eduard_switch_fragila);
        RatingBar rbRating = findViewById(R.id.budea_eduard_rb_rating);
        ///Spinner incercareSpinner = findViewById(R.id.incercare_spinner)

        Button btnSalvare = findViewById(R.id.budea_eduard_btn_salvare);
        btnSalvare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cod = Integer.parseInt(etCod.getText().toString());
                String culoare = etCuloare.getText().toString();
                double volum = 0;
                boolean esteFragila = switchFragila.isChecked();
                float rating = rbRating.getRating();
//               int idBifat = rgCuloare.getCheckedRadioButtonId();
//               adioButton rbBifat = findViewById(idBifat);
//               String tipCuloare = rbBifat.getText().toString();
                ///String producator = incercareSpinner.getSelectedItem().toString();


                Cutie cutie = new Cutie(cod,culoare,volum,esteFragila, rating);
                Intent intentResult = new Intent();
                intentResult.putExtra("cutie_noua", cutie);
                setResult(RESULT_OK,intentResult);
                finish();
            }
        });

    }
}