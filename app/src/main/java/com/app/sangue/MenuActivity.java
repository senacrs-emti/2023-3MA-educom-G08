package com.app.sangue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MenuActivity extends AppCompatActivity {

    ImageView btnMenuConteudo, btnMenuCompatibilidade, btnMenuComoDoar, btnMenuQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnMenuConteudo = findViewById(R.id.btnMenuConteudo);
        btnMenuCompatibilidade = findViewById(R.id.btnMenuCompatibilidade);
        btnMenuComoDoar = findViewById(R.id.btnMenuComoDoar);
        btnMenuQuiz = findViewById(R.id.btnMenuQuiz);

        btnMenuConteudo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, ConteudoActivity.class);
                startActivity(intent);
            }
        });
        btnMenuCompatibilidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnMenuComoDoar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnMenuQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}