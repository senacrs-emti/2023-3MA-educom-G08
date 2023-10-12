package com.app.appsanguineo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MenusActivity extends AppCompatActivity {

    ImageView btnMenuConteudo, btnMenuCompatibilidade, btnMenuComoDoar, btnMenuQuiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);

        btnMenuConteudo = findViewById(R.id.btnMenuConteudo);
        btnMenuCompatibilidade = findViewById(R.id.btnMenuCompatibilidade);
        btnMenuComoDoar = findViewById(R.id.btnMenuComoDoar);
        btnMenuQuiz = findViewById(R.id.btnMenuQuiz);

        btnMenuConteudo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenusActivity.this, ConteudoActivity.class);
                startActivity(intent);
            }
        });
        btnMenuCompatibilidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenusActivity.this, CompatibilidadeActivity.class);
                startActivity(intent);
            }
        });
        btnMenuComoDoar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenusActivity.this, MapaActivity.class);
                startActivity(intent);
            }
        });
        btnMenuQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenusActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });
    }
}