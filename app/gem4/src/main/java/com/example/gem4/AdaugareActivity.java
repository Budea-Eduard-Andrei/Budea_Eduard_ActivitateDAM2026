package com.example.gem4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
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
        EditText etTitlu = findViewById(R.id.budea_eduard_et_titlu);
        Spinner spinner = findViewById(R.id.budea_eduard_spinner_cinematografe);
        RatingBar bar = findViewById(R.id.budea_eduard_RB_rating);

        Button btnSalveaza = findViewById(R.id.budea_eduard_btn_salveaza);
        btnSalveaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(etID.getText().toString());
                String titlu = etTitlu.getText().toString();
                float rating = bar.getRating();
                String cinematograf = spinner.getSelectedItem().toString();

                Film film = new Film(id,titlu,rating,cinematograf);
                Intent intentResult = new Intent();
                intentResult.putExtra("film_nou", film);
                setResult(RESULT_OK,intentResult);
                finish();

            }
        });

    }
}