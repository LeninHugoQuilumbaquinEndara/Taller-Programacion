
package test;

import Dominio.empleados;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class testEmpleados {

    static private FileWriter archivo;
    static private PrintWriter salida;
    static Scanner datos = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            archivo = new FileWriter("empleados.txt");
            salida = new PrintWriter(archivo);
            int edad = 0;
            System.out.println("Cuantos empleados  desea registrar");
            salida.println("Cuantos empleados  desea registrar");
            int n = datos.nextInt();
            salida.println(n);
            empleados emp[] = new empleados[n];
            llenaEmpresa(emp);
            System.out.println("Tabla de datos obtenidos");
            salida.println("Tabla de datos obtenidos");
            for (int i = 0; i < emp.length; i++) {
                edad = calcularEdad(emp[i].getDia(), emp[i].getMes(), emp[i].getAnio());
                System.out.println("Empleado No " + (i + 1));
                salida.println("Empleado No " + (i + 1));
                System.out.println("El emplado:" + emp[i].getNombre() + " Nacio el: " + emp[i].getDia() + "/" + emp[i].getMes()
                        + "/" + emp[i].getAnio());
                salida.println("El emplado:" + emp[i].getNombre() + " Nacio el: " + emp[i].getDia() + "/" + emp[i].getMes()
                        + "/" + emp[i].getAnio());
                System.out.println("Tiene : " + edad);
                salida.println("Tiene : " + edad);
                System.out.println("");
                salida.println();
                salida.flush();
            }
        } catch (IOException ex) {
            Logger.getLogger(testEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void llenaEmpresa(empleados emp[]) {
        String nombre;
        int dia, mes, anio;
        for (int i = 0; i < emp.length; i++) {
            datos.nextLine();
            System.out.println("Empleado No " + (i + 1));
            System.out.print("Nombre: ");
            nombre = datos.nextLine();
            System.out.println("fecha de nacimiendo");
            System.out.println("Ingrese año");
            anio = datos.nextInt();
            System.out.println("Ingrese mes");
            mes = datos.nextInt();
            System.out.println("Ingrese dia");
            dia = datos.nextInt();
            emp[i] = new empleados(nombre, dia, mes, anio);
        }
    }

    public static int calcularEdad(int dia, int mes, int anio) {
        LocalDate fechaHoy = LocalDate.now();
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        Period periodo = Period.between(fechaNacimiento, fechaHoy);
        return periodo.getYears();
    }
}
