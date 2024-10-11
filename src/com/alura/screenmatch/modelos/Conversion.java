package com.alura.screenmatch.modelos;

import com.alura.screenmatch.excepcion.ErrorEnConversionDeDuracionException;

public class Conversion implements Comparable<Conversion>{
    private String nombre;
    private double tasaConversion;
    private String conexion;
    private int cantidadMoneda;


    public Conversion(String nombre, double tasaConversion, String conexion) {
        this.nombre = nombre;
        this.tasaConversion = tasaConversion;
        this.conexion = conexion;
    }

    public Conversion(ConversionEXC miConversionEXT) {
        this.nombre = miConversionEXT.base_code();
        this.tasaConversion = miConversionEXT.conversion_rate();
        if (miConversionEXT.result().contains("error")){
            throw new ErrorEnConversionDeDuracionException("Falla de conexion por API");
        }
        this.conexion = miConversionEXT.result();
    }

    public String getNombre() {
        return nombre;
    }

    public double getTasaConversion() {
        return tasaConversion;
    }

    public String getConexion() {
        return conexion;
    }

    public int getCantidadMoneda() {
        return cantidadMoneda;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTasaConversion(double tasaConversion) {
        this.tasaConversion = tasaConversion;
    }

    public void setCantidadMoneda(int cantidadMoneda) {
        this.cantidadMoneda = cantidadMoneda;
    }

    public void setConexion(String conexion) {
        this.conexion = conexion;
    }

    public void muestraFichaTecnica(){
        System.out.println("Nombre de la moneda: " + nombre);
        System.out.println("Factor de conversion: " + tasaConversion);
    }

    public double convierteMoneda(){
        return tasaConversion*cantidadMoneda;
    }
    @Override
    public int compareTo(Conversion otroTitulo) {
        return this.getNombre().compareTo(otroTitulo.getNombre());
    }

    @Override
    public String toString() {
        return "(nombre=" + nombre +
                ", tasaConversion=" + tasaConversion+
                ", conexion="+conexion+")";
    }
}
