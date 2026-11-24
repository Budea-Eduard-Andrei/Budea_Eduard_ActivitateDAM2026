package com.example.gem3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AdaugareZbor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adaugare_zbor);

        EditText etID = findViewById(R.id.budea_eduard_et_ID);
        EditText etPret = findViewById(R.id.budea_eduard_et_pret);
        Switch aSwitch = findViewById(R.id.budea_eduard_switch_cazare);
        RadioGroup rg = findViewById(R.id.budea_eduard_rg_destinatie);


        Button btnSalveaza = findViewById(R.id.budea_eduard_btn_salveaza);
        btnSalveaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idBifat = rg.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(idBifat);


                int id = Integer.parseInt(etID.getText().toString());
                String destinatie = radioButton.getText().toString();
                float pret = Float.parseFloat(etPret.getText().toString());
                boolean cazare = aSwitch.isChecked();

                Zbor zbor = new Zbor(id,destinatie,pret,cazare);
                Intent intentResult = new Intent();
                intentResult.putExtra("zbor_nou",zbor);
                setResult(RESULT_OK,intentResult);
                finish();
            }
        });
    }
}