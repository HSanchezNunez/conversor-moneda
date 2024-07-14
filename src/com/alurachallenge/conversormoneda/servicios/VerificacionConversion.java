package com.alurachallenge.conversormoneda.servicios;

import com.alurachallenge.conversormoneda.modelos.Moneda;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//Clase para conectar la API con el paquete HTTP
public class VerificacionConversion {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public Moneda realizaConversion(String monedaInicial, String monedaObjetivo, double valor){

        final String apiKey = "f10ed40943b491035ed1c59c";

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" +apiKey+ "/pair/"+monedaInicial+"/"+monedaObjetivo+"/"+valor);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                throw new RuntimeException("Error en la respuesta de la API: " + response.body());
            }
            ConsumoApi consumoApi = gson.fromJson(response.body(), ConsumoApi.class);
            return new Moneda(consumoApi.base_code(), consumoApi.target_code(), valor, consumoApi.conversion_result());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("No pude realizar la conversión: " + e.getMessage());
        }
    }
}
