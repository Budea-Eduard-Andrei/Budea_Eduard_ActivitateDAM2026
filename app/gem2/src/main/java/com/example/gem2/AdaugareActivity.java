package com.example.gem2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;

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

        EditText etId = findViewById(R.id.budea_eduard_et_ID);
        EditText etMarca = findViewById((R.id.budea_eduard_et_Marca));
        CheckBox cbAsigurare = findViewById(R.id.budea_eduard_cb_asigurare);
        RatingBar rbRating = findViewById(R.id.budea_eduard_rb_rating);

        Button btnSalvare = findViewById(R.id.budea_eduard_btn_salvare);
        btnSalvare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(etId.getText().toString());
                String marca = etMarca.getText().toString();
                boolean asigurare = cbAsigurare.isChecked();
                float rating = rbRating.getRating();
                float pret = 0;

                Masina masina = new Masina(id,marca,pret,asigurare,rating);
                Intent intentResult = new Intent();
                intentResult.putExtra("masina_noua", masina);
                setResult(RESULT_OK, intentResult);
                finish();
            }
        });


    }
}