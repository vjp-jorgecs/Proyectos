/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InicioSesion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author jcasqueros01
 */
public class Escribir {

    public static void escribir(String nombre, String contraseña) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("users.txt", true);
            pw = new PrintWriter(fichero);
            pw.println(nombre + "\t" + contraseña);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }

        }
    }

    public static boolean validar(String nombre, String contrasenia) {
        boolean valido = false;

        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader("users.txt");
            br = new BufferedReader(fr);
            String linea = br.readLine();
            String[] lineaSplit;
            while (linea != null && valido == false) {
                lineaSplit = linea.split("\t");
                if (lineaSplit[0].equalsIgnoreCase(nombre) && lineaSplit[1].equalsIgnoreCase(contrasenia)) {
                    valido = true;
                }
                linea = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return valido;
    }
}
