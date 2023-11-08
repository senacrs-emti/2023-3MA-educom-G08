package com.app.sangue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.app.sangue.Mapa.MapaActivity;
import com.app.sangue.quiz.QuizActivity;

public class MenuActivity extends AppCompatActivity {

    ImageView btnMenuConteudo, btnMenuCompatibilidade, btnMenuComoDoar, btnMenuQuiz;
//    Button btnSairApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnMenuConteudo = findViewById(R.id.btnMenuConteudo);
        btnMenuCompatibilidade = findViewById(R.id.btnMenuCompatibilidade);
        btnMenuComoDoar = findViewById(R.id.btnMenuComoDoar);
        btnMenuQuiz = findViewById(R.id.btnMenuQuiz);
//        btnSairApp = findViewById(R.id.btnSairApp);

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
                Intent intent = new Intent(MenuActivity.this, CompatibilidadeActivity.class);
                startActivity(intent);
            }
        });
        btnMenuComoDoar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, MapaActivity.class);
                startActivity(intent);
            }
        });
        btnMenuQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });

//        btnSairApp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish(); // Fecha a atividade atual
//                System.exit(0); // Fecha o aplicativo
//            }
//        });
    }
}