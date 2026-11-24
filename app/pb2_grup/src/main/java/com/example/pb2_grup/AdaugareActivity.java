package com.example.pb2_grup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
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

        EditText etID = findViewById(R.id.budea_eduard_et_ID);
        EditText etMemorie = findViewById(R.id.budea_eduard_et_memorie);
        Spinner spinnerModel = findViewById(R.id.budea_eduard_spinner);
        CheckBox cbWireless = findViewById(R.id.budea_eduard_cb_wireless);

        Button btnSalveaza = findViewById(R.id.budea_eduard_btn_salveaza);
        btnSalveaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(etID.getText().toString());
                String model = spinnerModel.getSelectedItem().toString();
                double memorie = Double.parseDouble(etMemorie.getText().toString());
                boolean wireless = cbWireless.isChecked();

                Tableta tableta = new Tableta(id,model,memorie,wireless);
                Intent intentResult = new Intent();
                intentResult.putExtra("tableta_noua", tableta);
                setResult(RESULT_OK,intentResult);
                finish();
            }
        });

    }
}