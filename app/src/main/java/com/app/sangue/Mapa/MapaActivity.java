package com.app.sangue.Mapa;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.sangue.MenuActivity;
import com.app.sangue.R;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class MapaActivity extends AppCompatActivity {

    ImageView btnVoltar;

    private Endereco[] enderecoss = {
            new Endereco("Acre", "Av. Getúlio Vargas, 2787 - Vila Ivonete - Rio Branco"),
            new Endereco("Amapá", "Av Fab, 0 - Central - Macapa"),
            new Endereco("Amazonas", "Av Constantino Nery, 4397 - Chapada - Manaus"),
            new Endereco("Pará", "Travessa Padre Eutiquio, 2109 - Batista Campos - Belem"),
            new Endereco("Rondônia", "R Benedito De S Brito, 0 Fhemeron - Industrial - Porto Velho"),
            new Endereco("Rondônia", "R Vilagran Cabrita, 1440 - Centro - Ji-parana"),
            new Endereco("Roraima", "Av Brg Eduardo Gomes, 3418 - Aeroporto - Boa Vista"),
            new Endereco("Tocantins", "Rua Anicuns, 200 - Centro - Augustinópolis"),
            new Endereco("Tocantins", "301 Norte, Av. Ns 01, Conj. 02 Lote 01, 0 - Plano Diretor Norte - Palmas"),
            new Endereco("Tocantins", "R Treze De Maio, 1336 - Setor Central - Araguaina"),
            new Endereco("Tocantins", "R Quatorze De Novembro, 0 Qd: 117 Lote:18 - Setor Central - Gurupi"),
            new Endereco("Alagoas", "Av. Jorge De Lima, 58 - Trapiche - Maceio"),
            new Endereco("Bahia", "Ld Do Hospital Geral, 0 2º Andar - Brotas - Salvador"),
            new Endereco("Ceará", "Av. José Bastos, 3390 Rodolfo Teófilo - Fortaleza"),
            new Endereco("Maranhão", "R Cinco De Janeiro, 0 - Jordoa - Sao Luis"),
            new Endereco("Paraíba", "Av D Pedro Ii, 1119 - Centro - Joao Pessoa"),
            new Endereco("Pernambuco", "Rua Joaquim Nabuco, 171 - Gracas - Recife"),
            new Endereco("Pernambuco", "Av Oswaldo Cruz, 0 - Mauricio De Nassau - Caruaru"),
            new Endereco("Pernambuco", "Av Goncalves Maia, 0 - Heliopolis - Garanhuns"),
            new Endereco("Pernambuco", "Av Joaquim Nabuco, 0 - Centro - Arcoverde"),
            new Endereco("Pernambuco", "Rua Ulisses Guimarães, 0 - Centro - Ouricuri"),
            new Endereco("Pernambuco", "R Pacifico Da Luz, 0 - Centro - Petrolina"),
            new Endereco("Pernambuco", "Rua Joaquim Gondim, 65 - Centro - Salgueiro"),
            new Endereco("Pernambuco", "R Joaquim Godoy, 0 - Nossa Senhora Da Penha - Serra Talhada"),
            new Endereco("Piauí", "Rua 1º De Maio, 235 - Centro/sul - Teresina"),
            new Endereco("Rio Grande Do Norte", "Av Alm Alexandrino De Alencar, 1800 - Tirol - Natal"),
            new Endereco("Rio Grande Do Norte", "Av Nilo Pecanha, 199 - Petropolis - Natal"),
            new Endereco("Sergipe", "Av Pres Tancredo Neves, 0 C. Adm. Gov Augusto - Capucho - Aracaju"),
            new Endereco("Distrito Federal", "Smhn, 03 Qd.03 Conj.a Bloco03 - Asa Norte - Brasilia"),
            new Endereco("Goiás", "Av Anhanguera, 5195 - Setor Coimbra - Goiania"),
            new Endereco("Mato Grosso", "R Treze De Junho, 1055 - Porto - Cuiaba"),
            new Endereco("Mato Grosso Do Sul", "Av Fernando C Da Costa, 1304 - Centro - Campo Grande"),
            new Endereco("Espírito Santo", "Av Mal Campos, 1468 - Maruípe - Vitoria"),
            new Endereco("Minas Gerais", "Rua José Gabriel Medef, 221 - Bairro: Padre Libério"),
            new Endereco("Minas Gerais", "R Maj Gote, 1255 - Centro - Patos De Minas"),
            new Endereco("Minas Gerais", "R Carlos Gomes, 17 - Esplanada - Ponte Nova"),
            new Endereco("Minas Gerais", "R Comendador José Garcia, 825 - Centro - Pouso Alegre"),
            new Endereco("Minas Gerais", "R Pref Nascimento Teixeira, 175 - Segredo - Sao Joao Del Rei"),
            new Endereco("Minas Gerais", "Av Renato Azeredo, 3170 - Canaa - Sete Lagoas"),
            new Endereco("Minas Gerais", "Rua Salvador Gonçalves Diniz, 191 - Baixada - Betim"),
            new Endereco("Minas Gerais", "Rua Felizardo Esquerdo, 45 - Ilha Recreio - Alem Paraiba"),
            new Endereco("Minas Gerais", "R Dr Cristiano Rezende, 2505 - Flavio Marques Lisboa - Belo Horizonte"),
            new Endereco("Minas Gerais", "Al Ezequiel Dias, 321 - Centro - Belo Horizonte"),
            new Endereco("Minas Gerais", "R Br De Cataguases, 0 - Santa Helena - Juiz De Fora"),
            new Endereco("Minas Gerais", "Rua Urbino Viana, 640 - Vila Guilhermina - Montes Claros"),
            new Endereco("Minas Gerais", "Av Getulio Guarita, 250 - Nossa Senhora Da Abadia - Uberaba"),
            new Endereco("Minas Gerais", "Av Levino De Souza, 1845 - Umuarama - Uberlandia"),
            new Endereco("Minas Gerais", "R Rui Barbosa, 149 - Centro - Governador Valadares"),
            new Endereco("Minas Gerais", "Av. 5 A, 0 - Progresso - Ituiutaba"),
            new Endereco("Minas Gerais", "R Dr Jose L De Barros, 313 - Belo Horizonte - Passos"),
            new Endereco("Minas Gerais", "Av Jose R Prezia, 303 - Jardim Dos Estados - Pocos De Caldas"),
            new Endereco("Minas Gerais", "Rua Da Glória, 469 Fundos - Centro - Diamantina"),
            new Endereco("Minas Gerais", "Rua Frederico Dolabela, 289 - Baixada - Manhuacu"),
            new Endereco("Rio de Janeiro", "Rua Rocha Leão, 2 – Cajú – Campos dos Goytacazes"),
            new Endereco("Rio de Janeiro", "Boulevard 28 de setembro, 109 - Vila Isabel - Rio de Janeiro"),
            new Endereco("Rio de Janeiro", "Praça Cruz Vermelha, 23 2º Andar - Centro - Rio De Janeiro"),
            new Endereco("São Paulo", "Rua Paulino Botelho de Abreu Sampaio, 535 – Jardim Pureza – São Carlos"),
            new Endereco("São Paulo", "R Ten Catao Roxo, 2501 - Vila Monte Alegre - Ribeirao Preto"),
            new Endereco("São Paulo", "Rua Oswaldo Cruz, 197 - Boqueirao - Santos"),
            new Endereco("São Paulo", "R Mns Claro, 888 - Centro - Bauru"),
            new Endereco("São Paulo", "R Da Silveria, 150 - Chacara Braz Miraglia - Jau"),
            new Endereco("São Paulo", "R Antenor D Vilela, 1331 - Doutor Paulo Prata - Barretos"),
            new Endereco("São Paulo", "Rua Dr° Diogo de Faria, nº 824 - 1º andar - Vila Clementino - Sao Paulo"),
            new Endereco("São Paulo", "R Exps Do Brasil, 1621 - Centro - Araraquara"),
            new Endereco("São Paulo", "Av Cdor Pereira Inacio, 564 - Jardim Faculdade - Sorocaba"),
            new Endereco("São Paulo", "R Jamil Feres Kfouri, 80 - Jardim Panorama - Sao Jose Do Rio Preto"),
            new Endereco("São Paulo", "R Lourival Freire, 240 - Fragata - Marilia"),
            new Endereco("São Paulo", "R Mq De Itu, 579 Laboratório 2º Andar - Vila Buarque - Sao Paulo"),
            new Endereco("São Paulo", "Distrito De Rubião Júnior, 0 - Rubião Junior - Botucatu"),
            new Endereco("São Paulo", "R Carlos Chagas, 480 - Cidade Universitaria - Campinas"),
            new Endereco("Paraná", "R. Claudio D. Cavalieri, 156 - Jd. Aruba - Londrina"),
            new Endereco("Paraná", "R Alm Barroso, 2490 - Centro - Toledo"),
            new Endereco("Paraná", "Tv Joao Prosdocimo, 145 - Alto Da Rua Xv - Curitiba"),
            new Endereco("Paraná", "R Afonso Botelho, 134 - Trianon - Guarapuava"),
            new Endereco("Paraná", "Rua Coronel Garcia, 761 - Centro - Irati"),
            new Endereco("Paraná", "Rua Coronel Cecílio Rocha, 425 - Centro - Jacarezinho"),
            new Endereco("Paraná", "Rua Gabriel De Lara, 481 - Centro Historico - Paranagua"),
            new Endereco("Paraná", "R Gen Osorio, 2390 - Centro - Ponta Grossa"),
            new Endereco("Paraná", "Rua Osório De Almeida Taques, 62 - Centro - Telemaco Borba"),
            new Endereco("Paraná", "Av Manaus, 4444 - Centro Cívico - Umuarama"),
            new Endereco("Paraná", "R Cap Souza Franco, 290 Casa - Batel - Curitiba"),
            new Endereco("Paraná", "R Avaetes, 37 - Santo Onofre - Cascavel"),
            new Endereco("Paraná", "Av Mandacaru, 1600 - Parque Das Laranjeiras - Maringa"),
            new Endereco("Paraná", "Av Gramado, 364 - Vila Residencial A - Foz Do Iguacu"),
            new Endereco("Paraná", "R Marilia, 1327 - Padre Ulrico - Francisco Beltrao"),
            new Endereco("Paraná", "R Rio G Do Sul, 2390 - Centro - Paranavai"),
            new Endereco("Paraná", "Av Agostinho L Junior, 108 Térreo - Centro - Curitiba"),
            new Endereco("Paraná", "R Dr Ovande Do Amaral, 201 Hospital Erasto Gaer - Jardim Das Americas - Curitiba"),
            new Endereco("Paraná", "R Parana, 1633 - Sambugaro - Pato Branco"),
            new Endereco("Paraná", "Pc Rui Barbosa, 694 - Centro - Curitiba"),
            new Endereco("Paraná", "Rua Castro Alves, 26 Prédio - Centro - Uniao Da Vitoria"),
            new Endereco("Paraná", "Praça Da Republica, 71 - Centro - Cianorte"),
            new Endereco("Paraná", "R Antonio Ostrenski, 03 - Centro - Apucarana"),
            new Endereco("Paraná", "R Mambore, 1500 - Centro - Campo Mourao"),
            new Endereco("Rio Grande Do Sul", "Rua Boa Vista, 401 - Centro - Santa Rosa"),
            new Endereco("Rio Grande Do Sul", "Av Francisco Trein, 596 - Passo D'areia - Porto Alegre"),
            new Endereco("Rio Grande Do Sul", "R Ramiro Barcelos, 2350 2º Andar - Santana - Porto Alegre"),
            new Endereco("Rio Grande Do Sul", "R Gen Sampaio, 10 - Vila Nova - Alegrete"),
            new Endereco("Rio Grande Do Sul", "R Ernesto Alves, 2260 - Nossa Senhora De Lourdes - Caxias Do Sul"),
            new Endereco("Rio Grande Do Sul", "R Br Do Rio Branco, 1445 Fundos - Centro - Cruz Alta"),
            new Endereco("Rio Grande Do Sul", "Rua Nassib Nassif, 503 - Loteamento Céu Azul - Palmeira Das Missoes"),
            new Endereco("Rio Grande Do Sul", "Al Santiago Do Chile, 35 Próximo Ao Fórum - Nossa Senhora De Lourdes - Santa Maria"),
            new Endereco("Rio Grande Do Sul", "Av Sete De Setembro, 1055 Bloco A - Centro - Passo Fundo"),
            new Endereco("Rio Grande Do Sul", "Av Bento Goncalves, 4569 - Centro - Pelotas"),
            new Endereco("Rio Grande Do Sul", "Av Bento Goncalves, 3722 - Partenon - Porto Alegre"),
            new Endereco("Santa Catarina", "Av Prf Othon Gama Deca, 756 Praça D. Pedro I - Centro - Florianopolis")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapaActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout container = findViewById(R.id.container);

        // Mapa para armazenar endereços por estado
        Map<String, List<Endereco>> enderecosPorEstado = new HashMap<>();

        // Adicionar endereços ao mapa
        for (Endereco endereco : enderecoss) {
            if (!enderecosPorEstado.containsKey(endereco.estado)) {
                enderecosPorEstado.put(endereco.estado, new ArrayList<>());
            }
            enderecosPorEstado.get(endereco.estado).add(endereco);
        }

        // Iterar sobre o mapa e criar containers
        for (Map.Entry<String, List<Endereco>> entry : enderecosPorEstado.entrySet()) {
            String estado = entry.getKey();
            List<Endereco> enderecos = entry.getValue();

            // Adicionar título do estado
            TextView estadoTextView = new TextView(this);
            estadoTextView.setText(estado);
            estadoTextView.setTextSize(28);
            estadoTextView.setTextColor(getColor(R.color.black));
            estadoTextView.setPadding(16, 16, 16, 16);
            container.addView(estadoTextView);

            // Adicionar endereços do estado
            for (Endereco endereco : enderecos) {
                addAddress(container, endereco);
            }
        }
    }

    private void addAddress(LinearLayout container, Endereco endereco) {
        TextView textView = new TextView(this);
        textView.setText(endereco.endereco);
        textView.setTextSize(20);
        textView.setTextColor(getColor(R.color.red));
        textView.setPadding(16, 16, 16, 16);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGoogleMaps(endereco.endereco);
            }
        });

        container.addView(textView);
    }

    private void openGoogleMaps(String address) {
        // Crie uma URI personalizada para abrir o Google Maps com o endereço
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + Uri.encode(address));
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");

        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }
}

