/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.carrerahilos;

/**
 * clase que comienza la carrea
 * @author ISAACELEAZAR
 */
public final class Carrera {
    /**
     * contructor de la clase que llama al metodo
     */
    public Carrera(){
        this.empezarCarrera();
    }
    /**
     * metodo que inicializa los hilos para simular la carrera
     */
    public void empezarCarrera(){
        
        Corredor equipo1corr1 = new Corredor((byte) 1, "\033[32m", (byte) 0);
        equipo1corr1.start();
        
        Corredor equipo1corr2 = new Corredor((byte) 2, "\033[32m", (byte) 34);
        equipo1corr2.start();
        
        Corredor equipo1corr3 = new Corredor((byte) 3, "\033[32m", (byte) 67);
        equipo1corr3.start();
        
        Corredor equipo2corr1 = new Corredor((byte) 1, "\033[34m", (byte) 0);
        equipo2corr1.start();
        
        Corredor equipo2corr2 = new Corredor((byte) 2, "\033[34m", (byte) 34);
        equipo2corr2.start();
        
        Corredor equipo2corr3 = new Corredor((byte) 3, "\033[34m", (byte) 67);
        equipo2corr3.start();
        
        Corredor equipo3corr1 = new Corredor((byte) 1, "\033[31m", (byte) 0);
        equipo3corr1.start();
        
        Corredor equipo3corr2 = new Corredor((byte) 2, "\033[31m", (byte) 34);
        equipo3corr2.start();
        
        Corredor equipo3corr3 = new Corredor((byte) 3, "\033[31m", (byte) 67);
        equipo3corr3.start();
        
        
        
    }
}
