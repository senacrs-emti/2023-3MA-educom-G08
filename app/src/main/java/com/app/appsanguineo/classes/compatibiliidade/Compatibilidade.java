package com.app.appsanguineo.classes.compatibiliidade;

import java.util.ArrayList;
import java.util.List;

public class Compatibilidade {

    public static List<String> verificarCompatibilidade(String tipoSanguineo) {
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

//        System.out.println("Pode receber de: " + podeReceber);
//        System.out.println("Pode doar para: " + podeDoar);

        return lista;
    }
}
