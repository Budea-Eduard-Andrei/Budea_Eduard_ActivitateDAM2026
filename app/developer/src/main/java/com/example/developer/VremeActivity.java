package com.example.developer;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VremeActivity extends AppCompatActivity {

    private static final String API_KEY = "CHEIE SA N O FURATI";

    private EditText etOras;
    private Spinner spZile;
    private Button btnCautaVreme;
    private TextView tvRezultat;

    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private final Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vreme);

        etOras = findViewById(R.id.etOras);
        spZile = findViewById(R.id.spinnerZile);
        btnCautaVreme = findViewById(R.id.btnCauta);
        tvRezultat = findViewById(R.id.tvRezultat);

        String[] optiuniZile = {"1 zi", "5 zile"};
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                optiuniZile
        );
        spZile.setAdapter(spinnerAdapter);

        btnCautaVreme.setOnClickListener(v -> {
            String oras = etOras.getText().toString().trim();
            if (oras.isEmpty()) {
                Toast.makeText(this, "Introdu numele unui oras!", Toast.LENGTH_SHORT).show();
                return;
            }

            boolean este5Zile = spZile.getSelectedItemPosition() == 1;
            tvRezultat.setText("Se incarca datele...");
            cautaCodSiVreme(oras, este5Zile);
        });
    }

    private void cautaCodSiVreme(String oras, boolean este5Zile) {
        executor.execute(() -> {
            try {
                String orasCodat = URLEncoder.encode(oras, "UTF-8");
                String linkCitySearch = "http://dataservice.accuweather.com/locations/v1/cities/search?apikey="
                        + API_KEY + "&q=" + orasCodat;

                String jsonCity = executaGet(linkCitySearch);
                JSONArray vectorOrase = new JSONArray(jsonCity);

                if (vectorOrase.length() == 0) {
                    handler.post(() -> tvRezultat.setText("Orasul nu a fost gasit."));
                    return;
                }

                JSONObject obiectOras = vectorOrase.getJSONObject(0);
                String cheieOras = obiectOras.getString("Key");
                String numeGasit = obiectOras.optString("LocalizedName", oras);

                String tipForecast = este5Zile ? "5day" : "1day";
                String linkForecast = "http://dataservice.accuweather.com/forecasts/v1/daily/"
                        + tipForecast + "/" + cheieOras + "?apikey=" + API_KEY + "&metric=true";

                String jsonForecast = executaGet(linkForecast);
                JSONObject rootForecast = new JSONObject(jsonForecast);
                JSONArray dailyForecasts = rootForecast.getJSONArray("DailyForecasts");

                StringBuilder rezultatFinal = new StringBuilder();
                rezultatFinal.append("Oras: ").append(numeGasit).append("\n");
                rezultatFinal.append("Cod oras (Key): ").append(cheieOras).append("\n\n");

                for (int i = 0; i < dailyForecasts.length(); i++) {
                    JSONObject ziObj = dailyForecasts.getJSONObject(i);
                    String data = ziObj.getString("Date").substring(0, 10);

                    JSONObject tempObj = ziObj.getJSONObject("Temperature");
                    JSONObject minObj = tempObj.getJSONObject("Minimum");
                    JSONObject maxObj = tempObj.getJSONObject("Maximum");

                    double tempMin = minObj.getDouble("Value");
                    String unitMin = minObj.getString("Unit");
                    double tempMax = maxObj.getDouble("Value");
                    String unitMax = maxObj.getString("Unit");

                    rezultatFinal.append("Data: ").append(data).append("\n")
                            .append("Temperatura minima: ").append(tempMin).append(" °").append(unitMin).append("\n")
                            .append("Temperatura maxima: ").append(tempMax).append(" °").append(unitMax).append("\n\n");
                }

                String textAfisat = rezultatFinal.toString();
                handler.post(() -> {
                    Toast.makeText(VremeActivity.this, "Cheie oras: " + cheieOras, Toast.LENGTH_SHORT).show();
                    tvRezultat.setText(textAfisat);
                });

            } catch (Exception e) {
                e.printStackTrace();
                handler.post(() -> tvRezultat.setText("Eroare la preluarea datelor: " + e.getMessage()));
            }
        });
    }

    private String executaGet(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(10000);
        conn.setReadTimeout(10000);
        conn.setInstanceFollowRedirects(true);
        conn.connect();

        int status = conn.getResponseCode();
        if (status == HttpURLConnection.HTTP_MOVED_TEMP
                || status == HttpURLConnection.HTTP_MOVED_PERM
                || status == 307 || status == 308) {
            String redirectUrl = conn.getHeaderField("Location");
            conn = (HttpURLConnection) new URL(redirectUrl).openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        reader.close();
        conn.disconnect();
        return builder.toString();
    }
}