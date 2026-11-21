/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import model.Cliente;
import model.Empleado;
import model.Direccion;
import utiles.Rut;
import service.GestionPersonas;

/**
 *
 * @author Hxru
 */
public class CargarPersonas {
    public void cargarArchivo(String ruta, GestionPersonas gestion){
        try(BufferedReader lector = new BufferedReader(new FileReader(ruta))){
            
            String linea;
            
            while((linea = lector.readLine()) != null){
                String[] datos= linea.split(";");
                
                try{
                    String tipo =datos[0];
                    String nombre = datos[1];
                    String apellido = datos[2];
                    
                    int numeroRut = Integer.parseInt(datos[3]);
                    char dv = datos[4].charAt(0);
                    
                    String calle = datos[5];
                    int numero = Integer.parseInt(datos[6]);
                    String comuna = datos[7];
                    String ciudad = datos[8];
                    
                    Direccion direccion = new Direccion(calle, numero, comuna, ciudad);
                    
                    Rut rut = new Rut(numeroRut, dv);
                    
                    if(tipo.equalsIgnoreCase("CLIENTE")){
                        String codigo = datos[9];
                        boolean frecuente = Boolean.parseBoolean(datos[10]);
                        
                        Cliente cliente = new Cliente(nombre, apellido, direccion, rut, codigo, frecuente);
                        
                        gestion.agregarPersona(cliente);
                    }
                    else if(tipo.equalsIgnoreCase("EMPLEADO")){
                        String codigo = datos[9];
                        String cargo = datos[10];
                        int sueldo = Integer.parseInt(datos[11]);
                        
                        Empleado empleado = new Empleado(nombre, apellido, direccion, rut, codigo, cargo, sueldo);
                        
                        gestion.agregarPersona(empleado);
                    }
                    else
                        System.out.println("Tipo de persona desconocido: " + tipo);
                }
                catch(NumberFormatException | ArrayIndexOutOfBoundsException e){
                    System.out.println("Error en registro: " + linea);
                }
            }
        }
        catch(IOException e){
            System.out.println("Error al leer el archivo" + e.getMessage());
        }
    }
}
