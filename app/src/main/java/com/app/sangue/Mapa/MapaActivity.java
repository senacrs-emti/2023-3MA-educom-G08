package com.app.sangue.Mapa;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
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
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


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

    private Endereco[] enderecos = {
            new Endereco("Rio Grande Do Sul", "Rua Boa Vista, 401 - Centro - Santa Rosa", -27.86822757830117, -54.4861568492684),
            new Endereco("Rio Grande Do Sul", "Av Francisco Trein, 596 - Passo D'areia - Porto Alegre", -30.016787814380926, -51.158979890386114),
            new Endereco("Rio Grande Do Sul", "R Ramiro Barcelos, 2350 2º Andar - Santana - Porto Alegre", -30.03860099666236, -51.206570589242766),
            new Endereco("Rio Grande Do Sul", "R Gen Sampaio, 10 - Vila Nova - Alegrete", -29.77276955990617, -55.79006102881572),
            new Endereco("Rio Grande Do Sul", "R Ernesto Alves, 2260 - Nossa Senhora De Lourdes - Caxias Do Sul", -29.16418134967675, -51.18458267881802),
            new Endereco("Rio Grande Do Sul", "R Br Do Rio Branco, 1445 Fundos - Centro - Cruz Alta", -28.641885130248, -53.608582847292),
            new Endereco("Rio Grande Do Sul", "Al Santiago Do Chile, 35 Próximo Ao Fórum - Nossa Senhora De Lourdes - Santa Maria", -29.692769131530678, -53.79459405476847),
            new Endereco("Rio Grande Do Sul", "Av Sete De Setembro, 1055 Bloco A - Centro - Passo Fundo", -28.260791318747515, -52.41724551814628),
            new Endereco("Rio Grande Do Sul", "Av Bento Goncalves, 4569 - Centro - Pelotas", -31.758444333997875, -52.348657983800166),
            new Endereco("Rio Grande Do Sul", "Av Bento Goncalves, 3722 - Partenon - Porto Alegre", -30.06316096588073, -51.179136196404286),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        //MAPA
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                for(Endereco endereco : enderecos) {
                    LatLng localizacao = new LatLng(endereco.getX(), endereco.getY());
                    googleMap.addMarker(new MarkerOptions().position(localizacao).title(endereco.getEnderecoCompleto()));
                }
            }
        });


        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapaActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });


    }
}

