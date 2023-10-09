package com.app.appsanguineo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.app.appsanguineo.classes.compatibiliidade.Compatibilidade;

import java.util.List;

public class CompatibilidadeActivity extends AppCompatActivity {

    Spinner dropDown;
    TextView podeDoar, podeReceber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compatibilidade);

        dropDown = findViewById(R.id.spinner1);
        podeDoar = findViewById(R.id.podeDoar);
        podeReceber = findViewById(R.id.podeReceber);
        String[] items = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropDown.setAdapter(adapter);

        dropDown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                List<String> lista = Compatibilidade.verificarCompatibilidade(selectedItem);
                podeReceber.setText("PODE RECEBER DE: " + lista.get(0));
                podeDoar.setText("PODE DOAR PARA: " + lista.get(1));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing if no item is selected
            }
        });

    }
}