/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carrerahilos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que representa cada corredor 
 * @author ISAACELEAZAR
 */
public class Corredor extends Thread{
    /**
     * variable que representa la cantidad que ha avanzado cada corredor
     */
    private byte cantidadCorrida;
    /**
     * variable que represnta la posicion del corredor en el equipo
     */
    private final byte rango;
    /**
     * variable que representa el color del equipo
     */
    private String equipo; 
    /**
     * variablee que representa donde va a comenzar el corredor
     */
    private byte cantidad;
    /**
     * constructor de la clase que reecibee:
     * @param rango 
     * @param equipo
     * @param cant 
     */
    public Corredor(byte rango, String equipo, byte cant){
        this.rango = rango;
        this.equipo = equipo;
        this.cantidad = cant;
    }
    /**
     * método para obtner la cantidad
     * @return byte
     */
    public byte getCantidad() {
        return cantidad;
    }
    /**
     * metodo para establecer la cantidad
     * @param cantidad 
     */
    public void setCantidad(byte cantidad) {
        this.cantidad = cantidad;
    }
    /**
     * método para obtner la cantidad recorrida
     * @return 
     */
    public byte getCantidadCorrida() {
        return cantidadCorrida;
    }

    public void setCantidadCorrida(byte cantidadCorrida) {
        this.cantidadCorrida = cantidadCorrida;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }
    /**
     * metodo sobrecargado que ejecuta el hilo
     */
    @Override
    @SuppressWarnings("empty-statement")
    public void run(){
        if(cantidad == 0){
            System.out.print(this.getEquipo()+"Corredor 1:");                    
            this.avanzandoCorredor((byte) 1);
        }
        else if( cantidad == 34){                               
            this.avanzandoCorredor((byte) 2);
            System.out.print(this.getEquipo()+"Corredor 2:"); 
        }
        else if( cantidad == 67){                               
            this.avanzandoCorredor((byte) 3);
            System.out.print(this.getEquipo()+"Corredor 3:"); 
        }
        else{
            this.esperar();
        }
    }
    /**
     * metodo que detiene eel hilo mientras es informado
     */
    public void esperar(){
        synchronized(this){
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    /**
     * metodo que analiza el corredor que esta en marcha y lo pone a correr
     * @param rango 
     */
    private void avanzandoCorredor(byte rango){
        while(true){            
            if(rango == 1){
                byte cant = correr();                   
                if(cant >= 33){                  
                    synchronized(this){
                        this.notifyAll();
                    }
                    break;                
                }                                 
            }
            if(rango == 2){
                byte cant = correr();                
                
                if(cant >= 66){                        
                    synchronized(this){
                        this.notify();
                    }
                    break;
                }
            }
            if(rango == 3){
                byte cant = correr();               
                if(cant >= 100){               
                    System.out.println(this.getEquipo()+"¡LLEGAMOS PRIMERITO!" + getCantidadCorrida());
                    System.exit(0);
                }
            }
        }
    }
    /**
     * metodo que genera el numero de pasos que va a recorrer aleatoreamente
     * @return 
     */
    public byte correr(){
            try {                
                Thread.sleep(1000);
                this.setCantidadCorrida((byte) (getCantidadCorrida() + Math.floor(Math.random()*3+1)));                                              
            } catch (InterruptedException ex) {
                Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);                        
        }
        System.out.print(this.getEquipo()+"_"+ this.getCantidadCorrida());   
        return this.getCantidadCorrida();
    }   
}