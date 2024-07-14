package com.alurachallenge.conversormoneda.principal;

import com.alurachallenge.conversormoneda.modelos.Moneda;
import com.alurachallenge.conversormoneda.servicios.ConsumoApi;
import com.alurachallenge.conversormoneda.servicios.VerificacionConversion;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VerificacionConversion conversion = new VerificacionConversion();

        while (true){
            System.out.println("""
                *********************************************
                Seleccione la conversion que desea realizar:
                
                1. USD a ARS
                2. COP a USD
                3. BRL a USD
                4. COP a EUR
                5. MXN a COP
                6. ARS a USD
                7. USD a COP
                8. USD a BRL
                9. Salir
                
                *********************************************
                Ingrese la opcion:
                """);
            int opcion = scanner.nextInt();
            if (opcion == 9){
                break;
            }
            String monedaInicial = "";
            String monedaObjetivo = "";

            switch (opcion){
                case 1 ->{
                    monedaInicial = "USD";
                    monedaObjetivo = "ARS";
                }
                case 2 -> {
                    monedaInicial = "COP";
                    monedaObjetivo = "USD";
                }
                case 3 -> {
                    monedaInicial = "BRL";
                    monedaObjetivo = "USD";
                }
                case 4 -> {
                    monedaInicial = "COP";
                    monedaObjetivo = "EUR";
                }
                case 5 -> {
                    monedaInicial = "MXN";
                    monedaObjetivo = "COP";
                }
                case 6 -> {
                    monedaInicial = "ARS";
                    monedaObjetivo = "USD";
                }
                case 7 -> {
                    monedaInicial = "USD";
                    monedaObjetivo = "COP";
                }
                case 8 -> {
                    monedaInicial = "USD";
                    monedaObjetivo = "BRL";
                }
                default -> {
                    System.out.println("Opción no válida, por favor seleccione nuevamente.");
                    continue;
                }
            }
            System.out.println("Ingrese el valor a convertir:");
            double valor = scanner.nextDouble();



            try {
                Moneda resultado = conversion.realizaConversion(monedaInicial, monedaObjetivo, valor);
                System.out.println("Resultado de la conversión: " + resultado);
            } catch (RuntimeException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("Gracias por usar el conversor de monedas.");
        scanner.close();
    }
}
