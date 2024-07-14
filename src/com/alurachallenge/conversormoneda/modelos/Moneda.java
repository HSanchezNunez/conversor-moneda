package com.alurachallenge.conversormoneda.modelos;

public class Moneda {
    private String monedaOrigen;
    private String monedaCambio;
    private double valorInicial;
    private double valorConvertido;

    //Constructor
    public Moneda(String monedaOrigen, String monedaCambio, double valorInicial, double valorConvertido) {
        this.monedaOrigen = monedaOrigen;
        this.monedaCambio = monedaCambio;
        this.valorInicial = valorInicial;
        this.valorConvertido = valorConvertido;
    }
    //Getters y Setters
    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public void setMonedaOrigen(String monedaOrigen) {
        this.monedaOrigen = monedaOrigen;
    }

    public String getMonedaCambio() {
        return monedaCambio;
    }

    public void setMonedaCambio(String monedaCambio) {
        this.monedaCambio = monedaCambio;
    }

    public double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public double getValorConvertido() {
        return valorConvertido;
    }

    public void setValorConvertido(double valorConvertido) {
        this.valorConvertido = valorConvertido;
    }

    @Override
    public String toString() {
        return "De " + monedaOrigen + " a "+monedaCambio+": "+ valorInicial + " se convierte en "+ valorConvertido;
    }
}
