package com.app.sangue.Mapa;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.sangue.R;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public class MapaActivity extends AppCompatActivity {

    private String[] enderecos = {
            "Av. Getúlio Vargas, 2787 - Vila Ivonete - Rio Branco, Acre - Cep:69914-500",
            "Av Fab, 0 - Central - Macapa, Amapá - Cep:68900-073",
            "Av Constantino Nery, 4397 - Chapada - Manaus, Amazonas - Cep:69050-000",
            "Travessa Padre Eutiquio, 2109 - Batista Campos - Belem, Pará - Cep:66033-000",
            "R Benedito De S Brito, 0 Fhemeron - Industrial - Porto Velho, Rondônia - Cep:76821-080",
            "R Vilagran Cabrita, 1440 - Centro - Ji-parana, Rondônia - Cep:76900-044",
            "Av Brg Eduardo Gomes, 3418 - Aeroporto - Boa Vista, Roraima - Cep:69304-015",
            "Rua Anicuns, 200 - Centro - Augustinópolis, Tocantins - Cep:77960-000",
            "301 Norte, Av. Ns 01, Conj. 02 Lote 01, 0 - Plano Diretor Norte - Palmas, Tocantins - Cep:77015-200",
            "R Treze De Maio, 1336 - Setor Central - Araguaina, Tocantins - Cep:77803-130",
            "R Quatorze De Novembro, 0 Qd: 117 Lote:18 - Setor Central - Gurupi, Tocantins - Cep:77405-070",
            "Av. Jorge De Lima, 58 - Trapiche - Maceio, Alagoas - Cep:57010-300",
            "Ld Do Hospital Geral, 0 2º Andar - Brotas - Salvador, Bahia - Cep:40286-240",
            "Av. José Bastos, 3390 Rodolfo Teófilo - Fortaleza - CE - Cep:60431-086",
            "R Cinco De Janeiro, 0 - Jordoa - Sao Luis, Maranhão - Cep:65040-450",
            "Av D Pedro Ii, 1119 - Centro - Joao Pessoa, Paraíba - Cep:58013-420",
            "Rua Joaquim Nabuco, 171 - Gracas - Recife, Pernambuco - Cep:52011-100",
            "Av Oswaldo Cruz, 0 - Mauricio De Nassau - Caruaru, Pernambuco - Cep:55012-040",
            "Av Goncalves Maia, 0 - Heliopolis - Garanhuns, Pernambuco - Cep:55296-270",
            "Av Joaquim Nabuco, 0 - Centro - Arcoverde, Pernambuco - Cep:56506-470",
            "Rua Ulisses Guimarães, 0 - Centro - Ouricuri, Pernambuco - Cep:56200-970",
            "R Pacifico Da Luz, 0 - Centro - Petrolina, Pernambuco - Cep:56304-010",
            "Rua Joaquim Gondim, 65 - Centro - Salgueiro, Pernambuco - Cep:56000-970",
            "R Joaquim Godoy, 0 - Nossa Senhora Da Penha - Serra Talhada, Pernambuco - Cep:56912-450",
            "Rua 1º De Maio, 235 - Centro/sul - Teresina, Piauí - Cep:64001-430",
            "Av Alm Alexandrino De Alencar, 1800 - Tirol - Natal, Rio Grande Do Norte - Cep:59015-350",
            "Av Nilo Pecanha, 199 - Petropolis - Natal, Rio Grande Do Norte - Cep:59012-300",
            "Av Pres Tancredo Neves, 0 C. Adm. Gov Augusto - Capucho - Aracaju, Sergipe - Cep:49080-470",
            "Smhn, 03 Qd.03 Conj.a Bloco03 - Asa Norte - Brasilia, Distrito Federal - Cep:70710-908",
            "Av Anhanguera, 5195 - Setor Coimbra - Goiania, Goiás - Cep:74535-010",
            "R Treze De Junho, 1055 - Porto - Cuiaba, Mato Grosso - Cep:78025-000",
            "Av Fernando C Da Costa, 1304 - Centro - Campo Grande, Mato Grosso Do Sul - Cep:79004-310",
            "Av Mal Campos, 1468 - Maruípe - Vitoria, Espírito Santo - Cep:29045-460",
            "Rua José Gabriel Medef, 221 - Bairro: Padre Libério - Cep: 35500-139",
            "R Maj Gote, 1255 - Centro - Patos De Minas, Minas Gerais - Cep:38700-001",
            "R Carlos Gomes, 17 - Esplanada - Ponte Nova, Minas Gerais - Cep:35430-069",
            "R Comendador José Garcia, 825 - Centro - Pouso Alegre, Minas Gerais - Cep:37550-000",
            "R Pref Nascimento Teixeira, 175 - Segredo - Sao Joao Del Rei, Minas Gerais - Cep:36307-404",
            "Av Renato Azeredo, 3170 - Canaa - Sete Lagoas, Minas Gerais - Cep:35700-312",
            "Rua Salvador Gonçalves Diniz, 191 - Baixada - Betim, Minas Gerais - Cep:36900-000",
            "Rua Felizardo Esquerdo, 45 - Ilha Recreio - Alem Paraiba, Minas Gerais - Cep:36660-000",
            "R Dr Cristiano Rezende, 2505 - Flavio Marques Lisboa - Belo Horizonte, Minas Gerais - Cep:30620-470",
            "Al Ezequiel Dias, 321 - Centro - Belo Horizonte, Minas Gerais - Cep:30130-110",
            "R Br De Cataguases, 0 - Santa Helena - Juiz De Fora, Minas Gerais - Cep:36015-370",
            "Rua Urbino Viana, 640 - Vila Guilhermina - Montes Claros, Minas Gerais - Cep:36900-000",
            "Av Getulio Guarita, 250 - Nossa Senhora Da Abadia - Uberaba, Minas Gerais - Cep:38025-440",
            "Av Levino De Souza, 1845 - Umuarama - Uberlandia, Minas Gerais - Cep:38405-322",
            "R Rui Barbosa, 149 - Centro - Governador Valadares, Minas Gerais - Cep:35020-510",
            "Av. 5 A, 0 - Progresso - Ituiutaba, Minas Gerais - Cep:38302-010",
            "R Dr Jose L De Barros, 313 - Belo Horizonte - Passos, Minas Gerais - Cep:37900-030",
            "Av Jose R Prezia, 303 - Jardim Dos Estados - Pocos De Caldas, Minas Gerais - Cep:37701-102",
            "Rua Da Glória, 469 Fundos - Centro - Diamantina, Minas Gerais - Cep:39100-000",
            "Rua Frederico Dolabela, 289 - Baixada - Manhuacu, Minas Gerais - Cep:36900-000",
            "Rua Rocha Leão, 2 – Cajú – Campos dos Goytacazes, RJ – Cep: 28051-170",
            "Boulevard 28 de setembro, 109 - Vila Isabel - Rio de Janeiro, RJ - CEP 20551-030",
            "Praça Cruz Vermelha, 23 2º Andar - Centro - Rio De Janeiro, Rio de Janeiro - Cep:20230-130",
            "Rua Paulino Botelho de Abreu Sampaio, 535 – Jardim Pureza – São Carlos, São Paulo – Cep: 13561-060",
            "R Ten Catao Roxo, 2501 - Vila Monte Alegre - Ribeirao Preto, São Paulo - Cep:14051-140",
            "Rua Oswaldo Cruz, 197 - Boqueirao - Santos, São Paulo - Cep:11045-904",
            "R Mns Claro, 888 - Centro - Bauru, São Paulo - Cep:17015-130",
            "R Da Silveria, 150 - Chacara Braz Miraglia - Jau, São Paulo - Cep:17210-080",
            "R Antenor D Vilela, 1331 - Doutor Paulo Prata - Barretos, São Paulo - Cep:14784-400",
            "Rua Dr° Diogo de Faria, nº 824 - 1º andar - Vila Clementino - Sao Paulo, São Paulo - Cep: 04037-002",
            "R Exps Do Brasil, 1621 - Centro - Araraquara, São Paulo - Cep:14801-360",
            "Av Cdor Pereira Inacio, 564 - Jardim Faculdade - Sorocaba, São Paulo - Cep:18030-005",
            "R Jamil Feres Kfouri, 80 - Jardim Panorama - Sao Jose Do Rio Preto, São Paulo - Cep:15091-240",
            "R Lourival Freire, 240 - Fragata - Marilia, São Paulo - Cep:17519-050",
            "R Mq De Itu, 579 Laboratório 2º Andar - Vila Buarque - Sao Paulo, São Paulo - Cep:01223-001",
            "Distrito De Rubião Júnior, 0 - Rubião Junior - Botucatu, São Paulo - Cep:18618-970",
            "R Carlos Chagas, 480 - Cidade Universitaria - Campinas, São Paulo - Cep:13083-878",
            "R. Claudio D. Cavalieri, 156 - Jd. Aruba - Londrina, Paraná - Cep:86038-350",
            "R Alm Barroso, 2490 - Centro - Toledo, Paraná - Cep:85900-020",
            "R. Claudio D. Cavalieri, 156 - Jd. Aruba - Londrina, Paraná - Cep:86038-350",
            "R Alm Barroso, 2490 - Centro - Toledo, Paraná - Cep:85900-020",
            "Tv Joao Prosdocimo, 145 - Alto Da Rua Xv - Curitiba, Paraná - Cep:80045-145",
            "R Afonso Botelho, 134 - Trianon - Guarapuava, Paraná - Cep:85015-000",
            "Rua Coronel Garcia, 761 - Centro - Irati, Paraná - Cep:84500-000",
            "Rua Coronel Cecílio Rocha, 425 - Centro - Jacarezinho, Paraná - Cep:86400-000",
            "Rua Gabriel De Lara, 481 - Centro Historico - Paranagua, Paraná - Cep:83203-250",
            "R Gen Osorio, 2390 - Centro - Ponta Grossa, Paraná - Cep:84010-080",
            "Rua Osório De Almeida Taques, 62 - Centro - Telemaco Borba, Paraná - Cep:84261-060",
            "Av Manaus, 4444 - Centro Cívico - Umuarama, Paraná - Cep:87501-130",
            "R Cap Souza Franco, 290 Casa - Batel - Curitiba, Paraná - Cep:80730-420",
            "R Avaetes, 37 - Santo Onofre - Cascavel, Paraná - Cep:85806-380",
            "Av Mandacaru, 1600 - Parque Das Laranjeiras - Maringa, Paraná - Cep:87083-240",
            "Av Gramado, 364 - Vila Residencial A - Foz Do Iguacu, Paraná - Cep:85860-460",
            "R Marilia, 1327 - Padre Ulrico - Francisco Beltrao, Paraná - Cep:85604-400",
            "R Rio G Do Sul, 2390 - Centro - Paranavai, Paraná - Cep:87703-320",
            "Av Agostinho L Junior, 108 Térreo - Centro - Curitiba, Paraná - Cep:80030-110",
            "R Dr Ovande Do Amaral, 201 Hospital Erasto Gaer - Jardim Das Americas - Curitiba, Paraná - Cep:81520-060",
            "R Parana, 1633 - Sambugaro - Pato Branco, Paraná - Cep:85501-090",
            "Pc Rui Barbosa, 694 - Centro - Curitiba, Paraná - Cep:80010-030",
            "Rua Castro Alves, 26 Prédio - Centro - Uniao Da Vitoria, Paraná - Cep:84600-000",
            "Praça Da Republica, 71 - Centro - Cianorte, Paraná - Cep:87200-000",
            "R Antonio Ostrenski, 03 - Centro - Apucarana, Paraná - Cep:86800-200",
            "R Mambore, 1500 - Centro - Campo Mourao, Paraná - Cep:87302-140",
            "Rua Boa Vista, 401 - Centro - Santa Rosa, Rio Grande Do Sul - Cep:98900-000",
            "Av Francisco Trein, 596 - Passo D'areia - Porto Alegre, Rio Grande Do Sul - Cep:91350-200",
            "R Ramiro Barcelos, 2350 2º Andar - Santana - Porto Alegre, Rio Grande Do Sul - Cep:90035-007",
            "R Gen Sampaio, 10 - Vila Nova - Alegrete, Rio Grande Do Sul - Cep:97541-260",
            "R Ernesto Alves, 2260 - Nossa Senhora De Lourdes - Caxias Do Sul, Rio Grande Do Sul - Cep:95020-360",
            "R Br Do Rio Branco, 1445 Fundos - Centro - Cruz Alta, Rio Grande Do Sul - Cep:98010-770",
            "Rua Nassib Nassif, 503 - Loteamento Céu Azul - Palmeira Das Missoes, Rio Grande Do Sul - Cep:98300-000",
            "Al Santiago Do Chile, 35 Próximo Ao Fórum - Nossa Senhora De Lourdes - Santa Maria, Rio Grande Do Sul - Cep:97050-685",
            "Av Sete De Setembro, 1055 Bloco A - Centro - Passo Fundo, Rio Grande Do Sul - Cep:99010-120",
            "Av Bento Goncalves, 4569 - Centro - Pelotas, Rio Grande Do Sul - Cep:96015-145",
            "Av Bento Goncalves, 3722 - Partenon - Porto Alegre, Rio Grande Do Sul - Cep:90650-001",
            "Av Prf Othon Gama Deca, 756 Praça D. Pedro I - Centro - Florianopolis, Santa Catarina - Cep:88015-240"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);


        LinearLayout container = findViewById(R.id.container);
        for (String endereco : enderecos) {
            addAddress(container, endereco);
        }
    }

    private void addAddress(LinearLayout container, final String address) {
        TextView textView = new TextView(this);
        textView.setText(address);
        textView.setTextSize(16);
        textView.setTextColor(getColor(R.color.black));
        textView.setPadding(10, 10, 10, 10);

        // Defina um ouvinte de clique para abrir o Google Maps com o endereço
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGoogleMaps(address);
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

