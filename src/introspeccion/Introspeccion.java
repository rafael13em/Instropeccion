/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package introspeccion;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafae
 */
public class Introspeccion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        String nombreClase;
        Class cl1;
        String seguir;
        System.out.println("Quiere buscar alguna clase?");
        seguir = entrada.nextLine();
        while (!seguir.equalsIgnoreCase("no")) 
        {
            System.out.println("Introduzca el nombre de la clase: ");
            nombreClase = entrada.nextLine();
            try 
            {
                cl1 = Class.forName(nombreClase);
                System.out.println("Nombre");
                System.out.println("\t"+cl1.getName());
                Field[] fields = cl1.getDeclaredFields();
                System.out.println("Campos: ");
                if(fields.length<1)
                    System.out.println("\tNo hay ninguno");
                else{
                    for (int i = 0; i < fields.length; i++)
                    System.out.println("\t"+fields[i].toGenericString());
                }
                
                
                Constructor[] constr = cl1.getConstructors();
                System.out.println("Constructores: ");
                for(int i=0; i<constr.length; i++)
                    System.out.println("\t"+constr[i].toGenericString());
                
                System.out.println("Metodos: ");
                Method[] meth = cl1.getDeclaredMethods();
                
                if(meth.length<0)
                {
                    System.out.println("\tNo hay niguno");
                }
                else
                {
                    for(int i = 0; i<meth.length; i++)
                        System.out.println("\t"+meth[i].toGenericString());
                }
                
            } catch (ClassNotFoundException ex) {
                System.out.println("Clase no encontrada");
            }
            System.out.println("Quiere seguir?");
            seguir = entrada.nextLine();
        }
    }
}

class Persona {

    private String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}

class Empleado extends Persona {

    private double salario;

    public Empleado(String nombre, double salario) {
        super(nombre);
        this.salario = salario;
    }

    public void setIncentivo(double incentivo) {
        salario = salario + incentivo;
    }

    public String getSalario() {
        return "El salario es: " + salario;
    }
}
