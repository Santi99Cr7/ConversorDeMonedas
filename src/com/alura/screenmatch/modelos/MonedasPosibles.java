package com.alura.screenmatch.modelos;

import java.util.ArrayList;
import java.util.List;

public class MonedasPosibles {
    private final List<String[]> combinaciones;
    private final String[] monedas = {"ARS", "BOB", "BRL", "CLP", "COP", "USD"};

    public MonedasPosibles() {
        combinaciones = new ArrayList<>();
        int opcionNumero = 1;
        // Generar todas las combinaciones posibles de monedas
        for (int i = 0; i < monedas.length; i++) {
            for (int j = 0; j < monedas.length; j++) {
                if (i != j) { // Evitar combinaciones de la misma moneda
                    combinaciones.add(new String[]{monedas[i], monedas[j]});
                    System.out.println(opcionNumero + ". " + monedas[i] + " - " + monedas[j]);
                    opcionNumero++;
                }
            }
        }
    }

    // Metodo para obtener un par de monedas específico según el índice
    public String[] obtenerMonedas(int numero) {
        if (numero < 1 || numero > combinaciones.size()) {
            throw new IllegalArgumentException("Número fuera de rango. Debe ser entre 1 y " + combinaciones.size());
        }
        return combinaciones.get(numero - 1);
    }
}
