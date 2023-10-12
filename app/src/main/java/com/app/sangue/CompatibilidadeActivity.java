package com.app.sangue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CompatibilidadeActivity extends AppCompatActivity {

    Spinner spinnerTiposSanguineos;
    TextView podeReceber, podeDoar;
    ImageView btnVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compatibilidade);

        spinnerTiposSanguineos = findViewById(R.id.spinnerTiposSanguineos);
        podeReceber = findViewById(R.id.textoPodeReceber);
        podeDoar = findViewById(R.id.textoPodeDoar);
        btnVoltar = findViewById(R.id.btnVoltar);

        String[] items = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinnerTiposSanguineos.setAdapter(adapter);

        spinnerTiposSanguineos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                List<String> lista = verificarCompatibilidade(selectedItem);
                podeReceber.setText("Pode receber de: " + lista.get(0));
                podeDoar.setText("Pode doar para: " + lista.get(1));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing if no item is selected
            }
        });
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CompatibilidadeActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
    }



    private List<String> verificarCompatibilidade(String tipoSanguineo) {
            List<String> lista = new ArrayList<>();
            String podeReceber = "";
            String podeDoar = "";

            switch (tipoSanguineo.toUpperCase()) {
                case "A+":
                    podeReceber = "A+ e O+";
                    podeDoar = "A+ e AB+";
                    break;
                case "A-":
                    podeReceber = "A+, A-, O+ e O-";
                    podeDoar = "A+ e AB-";
                    break;
                case "B+":
                    podeReceber = "B+ e O+";
                    podeDoar = "B+ e AB+";
                    break;
                case "B-":
                    podeReceber = "B+, B-, O+ e O-";
                    podeDoar = "B+ e AB-";
                    break;
                case "AB+":
                    podeReceber = "Todos os tipos sanguíneos";
                    podeDoar = "AB+";
                    break;
                case "AB-":
                    podeReceber = "AB+, AB-, A-, B-, O-";
                    podeDoar = "AB+ e AB-";
                    break;
                case "O+":
                    podeReceber = "O+ e O-";
                    podeDoar = "Todos os tipos sanguíneos";
                    break;
                case "O-":
                    podeReceber = "O-";
                    podeDoar = "A+, B+, AB+ e O+";
                    break;
                default:
                    System.out.println("Tipo sanguíneo inválido");
                    break;
            }
            lista.add(podeReceber);
            lista.add(podeDoar);

            return lista;
    }
}