package com.app.sangue.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.sangue.MenuActivity;
import com.app.sangue.R;

public class FimQuizActivity extends AppCompatActivity {


    ImageView btnVoltar;
    TextView acertos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fim_quiz);

        btnVoltar = findViewById(R.id.btnVoltar);
        acertos = findViewById(R.id.acertos);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int intacertos = bundle.getInt("acertos");
            int nQuestoes = bundle.getInt("nQuestoes");

            acertos.setText("Acertou " + String.valueOf(intacertos) + " de " + String.valueOf(nQuestoes));
        } else {
            acertos.setText("Erro, tente novamente mais tarde");
        }

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FimQuizActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });


    }
}