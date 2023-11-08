package com.app.sangue.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.app.sangue.MenuActivity;
import com.app.sangue.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private List<Question> questions;
    private int currentQuestionIndex;
    private TextView questionTextView, nDaPergunta;
    private Button[] optionButtons;
    private ImageView btnVoltar;
    private int acertos = 0;
    private int nQuestoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Inicialize as perguntas e respostas
        initializeQuestions();

        // Inicialize os elementos da interface de usuário
        questionTextView = findViewById(R.id.questionTextView);
        optionButtons = new Button[4];
        optionButtons[0] = findViewById(R.id.optionButton1);
        optionButtons[1] = findViewById(R.id.optionButton2);
        optionButtons[2] = findViewById(R.id.optionButton3);
        optionButtons[3] = findViewById(R.id.optionButton4);
        btnVoltar = findViewById(R.id.btnVoltar);

        // Embaralhe a ordem das perguntas
        Collections.shuffle(questions);

        // Exiba a primeira pergunta
        showQuestion(0);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initializeQuestions() {
        questions = new ArrayList<>();
        // Pergunta 1
        String questionText1 = "Qual é a função principal das células vermelhas do sangue?";
        String[] options1 = {"Transportar oxigênio", "Transportar glicose", "Transportar dióxido de carbono", "Fazer a coagulação do sangue"};
        int correctOptionIndex1 = 0; // Transportar oxigênio
        Question question1 = new Question(questionText1, options1, correctOptionIndex1);
        questions.add(question1);

        // Pergunta 2
        String questionText2 = "Qual é o fluido que ajuda a prevenir infecções no sangue?";
        String[] options2 = {"Soro", "Plasma", "Água", "Linfócitos"};
        int correctOptionIndex2 = 1; // Plasma
        Question question2 = new Question(questionText2, options2, correctOptionIndex2);
        questions.add(question2);

        // Pergunta 3
        String questionText3 = "Qual é o nome do processo de coagulação do sangue?";
        String[] options3 = {"Fagocitose", "Hemólise", "Hemostasia", "Respiração celular"};
        int correctOptionIndex3 = 2; // Hemostasia
        Question question3 = new Question(questionText3, options3, correctOptionIndex3);
        questions.add(question3);

        // Pergunta 4
        String questionText4 = "Qual é o tipo mais comum de sangue humano?";
        String[] options4 = {"Tipo A", "Tipo B", "Tipo AB", "Tipo O"};
        int correctOptionIndex4 = 3; // Tipo O
        Question question4 = new Question(questionText4, options4, correctOptionIndex4);
        questions.add(question4);

        // Pergunta 5
        String questionText5 = "Qual é a proteína responsável pela coagulação do sangue?";
        String[] options5 = {"Hemoglobina", "Plaquetas", "Fibrina", "Insulina"};
        int correctOptionIndex5 = 2; // Fibrina
        Question question5 = new Question(questionText5, options5, correctOptionIndex5);
        questions.add(question5);

        // Pergunta 6
        String questionText6 = "Qual é o nome das células que combatem infecções no sangue?";
        String[] options6 = {"Hemácias", "Plaquetas", "Linfócitos", "Leucócitos"};
        int correctOptionIndex6 = 3; // Leucócitos
        Question question6 = new Question(questionText6, options6, correctOptionIndex6);
        questions.add(question6);

        // Pergunta 7
        String questionText7 = "Qual é a função das plaquetas no sangue?";
        String[] options7 = {"Transportar oxigênio", "Coagular o sangue", "Eliminar toxinas", "Produzir insulina"};
        int correctOptionIndex7 = 1; // Coagular o sangue
        Question question7 = new Question(questionText7, options7, correctOptionIndex7);
        questions.add(question7);

        // Pergunta 8
        String questionText8 = "Qual é a porcentagem aproximada de plasma no sangue humano?";
        String[] options8 = {"5%", "25%", "50%", "75%"};
        int correctOptionIndex8 = 3; // 50%
        Question question8 = new Question(questionText8, options8, correctOptionIndex8);
        questions.add(question8);

        // Pergunta 9
        String questionText9 = "Qual é a função das hemácias no sangue?";
        String[] options9 = {"Defesa imunológica", "Coagulação", "Transportar oxigênio", "Digestão"};
        int correctOptionIndex9 = 2; // Transportar oxigênio
        Question question9 = new Question(questionText9, options9, correctOptionIndex9);
        questions.add(question9);

        // Pergunta 10
        String questionText10 = "Qual é a quantidade aproximada de sangue em um adulto saudável?";
        String[] options10 = {"2 litros", "5 litros", "10 litros", "20 litros"};
        int correctOptionIndex10 = 1; // 5 litros
        Question question10 = new Question(questionText10, options10, correctOptionIndex10);
        questions.add(question10);

        // Pergunta 11
        String questionText11 = "O que são os grupos sanguíneos Rh positivo e Rh negativo?";
        String[] options11 = {"Antígenos na superfície das hemácias", "Tipos de glóbulos brancos", "Subdivisões dos tipos sanguíneos A e B", "Fatores de coagulação"};
        int correctOptionIndex11 = 0; // Antígenos na superfície das hemácias
        Question question11 = new Question(questionText11, options11, correctOptionIndex11);
        questions.add(question11);

        // Pergunta 12
        String questionText12 = "O que é hemofilia?";
        String[] options12 = {"Uma doença autoimune", "Um distúrbio na coagulação do sangue", "Um tipo raro de câncer sanguíneo", "Um excesso de plaquetas no sangue"};
        int correctOptionIndex12 = 1; // Um distúrbio na coagulação do sangue
        Question question12 = new Question(questionText12, options12, correctOptionIndex12);
        questions.add(question12);

        // Pergunta 13
        String questionText13 = "O que é o fator Rh na tipagem sanguínea?";
        String[] options13 = {"Um tipo de proteína no plasma", "Um antígeno na superfície das hemácias", "Uma enzima envolvida na digestão", "Um tipo de anticorpo no soro"};
        int correctOptionIndex13 = 1; // Um antígeno na superfície das hemácias
        Question question13 = new Question(questionText13, options13, correctOptionIndex13);
        questions.add(question13);

        // Pergunta 14
        String questionText14 = "Qual é a função das plaquetas no processo de coagulação sanguínea?";
        String[] options14 = {"Transportar oxigênio", "Prevenir infecções", "Eliminar toxinas", "Formar coágulos"};
        int correctOptionIndex14 = 3; // Formar coágulos
        Question question14 = new Question(questionText14, options14, correctOptionIndex14);
        questions.add(question14);

        // Pergunta 15
        String questionText15 = "Qual é o órgão responsável pela produção de células sanguíneas em adultos?";
        String[] options15 = {"Coração", "Rim", "Pulmões", "Medula óssea"};
        int correctOptionIndex15 = 3; // Medula óssea
        Question question15 = new Question(questionText15, options15, correctOptionIndex15);
        questions.add(question15);

        nQuestoes = questions.size();
    }

    private void showQuestion(int index) {
        Question question = questions.get(index);
        questionTextView.setText(question.getQuestionText());

        String[] options = question.getOptions();
        for (int i = 0; i < 4; i++) {
            optionButtons[i].setText(options[i]);
            int finalI = i;
            optionButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkAnswer(index, finalI);
                }
            });
        }
        currentQuestionIndex = index;
    }

    private void checkAnswer(int questionIndex, int selectedOptionIndex) {
        Question question = questions.get(questionIndex);
        int correctOptionIndex = question.getCorrectOptionIndex();

        if (selectedOptionIndex == correctOptionIndex) {
            Toast.makeText(this, "Resposta correta!", Toast.LENGTH_SHORT).show();
            acertos = acertos + 1;
        } else {
            Toast.makeText(this, "Resposta incorreta.", Toast.LENGTH_SHORT).show();
        }


        // Mostrar a próxima pergunta
        if (currentQuestionIndex < questions.size() - 1) {
            showQuestion(currentQuestionIndex + 1);
        } else {

            Bundle bundle = new Bundle();
            bundle.putInt("nQuestoes", nQuestoes);
            bundle.putInt("acertos", acertos);

            Toast.makeText(this, "Fim do quiz!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(QuizActivity.this, FimQuizActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
}