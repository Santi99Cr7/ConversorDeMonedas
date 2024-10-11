package com.alura.screenmatch.principal;

import com.alura.screenmatch.excepcion.ErrorEnConversionDeDuracionException;
import com.alura.screenmatch.modelos.Conversion;
import com.alura.screenmatch.modelos.ConversionEXC;
import com.alura.screenmatch.modelos.MonedasPosibles;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Bienvenido al conversor de monedas para Alura latam, desarrollado por Santiago Arenas:");
        while(true){


            try {
                System.out.println("Seleccione una combinación de monedas para convertir:");
                MonedasPosibles monedasPosibles = new MonedasPosibles();
                Scanner lectura = new Scanner(System.in);
                int numero = lectura.nextInt();
                String[] monedas = monedasPosibles.obtenerMonedas(numero);
                System.out.println("Las monedas para el número " + numero + " son: " + monedas[0] + " y " + monedas[1]);


                List<Conversion> titulos = new ArrayList<>();
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String direccion = "https://v6.exchangerate-api.com/v6/7388f8c1f794359132d6dde7/pair/"+monedas[0]+"/"+
                        monedas[1];
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccion))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);

                ConversionEXC miConversionEXC = gson.fromJson(json, ConversionEXC.class);
                //System.out.println(miConversionEXC);

                Conversion miConversion= new Conversion(miConversionEXC);
                //    System.out.println( miConversion);

                System.out.println("Ingrese el valor que desea convertir:");
                var cantidad = lectura.nextInt();
                miConversion.setCantidadMoneda(cantidad);
                System.out.println("El valor de: "+ cantidad +"["+monedas[0]+"] corresponde al valor final de =>>>" + miConversion.convierteMoneda()+"["+monedas[1]+"]");
            }catch (ErrorEnConversionDeDuracionException e) {   // cuando hay falla en la url de la api, reporta 0
                System.out.println(e.getMessage());
            }catch (IllegalArgumentException e) {  // cuando el numero ingresado no es de 1 al 30
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {//cuando se ingresa un caracter por teclado diferente a entero
                System.out.println("Ingrese un valor valido: del 1 al 30, error: "+e.getMessage());
            }catch (ConnectException e) {  // cuando no hay conexion del servidor o se cae el internet
                System.out.println("Falla de conexion al servidor "+e.getMessage());
            }

        }
    }
}
