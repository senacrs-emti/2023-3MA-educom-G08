package com.app.sangue.Mapa;

public class Endereco {
    private String estado;
    private String endereco;
    private double x;
    private double y;

    public Endereco(String estado, String endereco, double x, double y) {
        this.estado = estado;
        this.endereco = endereco;
        this.x = x;
        this.y = y;
    }

    public String getEnderecoCompleto() {
        return endereco;
    }

    public String getEstado() {
        return estado;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}

