/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileManager;

import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * SOLO PARA DEBUGGING. SOLO SIRVE EN UBUNTU Y NECESITA TENER INSTALADO GRAPHVIZ (O DOT. NO ESTOY SEGURO)
 * @author Alvarez
 */
public class GraphvizHelper {
    
    private static final String DIR_DOT = "ArchivosDePrueba/_DOT/";
    public static final String DIR_IMG = "ArchivosDePrueba/_IMAGES/";
    
    /**
     * genera un archivo dot con nombre name.dot en zGraphviz/DOT_files y escribe lines en el, lo compila y luego guarda la imagen en zGraphviz/Images
     * @param lines
     * @param name 
     */
    public static void draw(LinkedList<String> lines, String name) throws IOException{
        String dirDot = DIR_DOT + name + ".dot";
        String dirPng = DIR_IMG + name + ".png";
        FileHelper.saveFile(dirDot, lines);
//        compileDot(dirDot, dirPng);
    }
    
    
    /**
     * genera un archivo dot con nombre name.dot en zGraphviz/DOT_files y escribe lines en el, lo compila y luego guarda la imagen en zGraphviz/Images
     * si open es verdadero abre la imagen
     * @param lines
     * @param name 
     * @param open 
     */
    public static void draw(LinkedList<String> lines, String name, boolean open) throws IOException{
        draw(lines, name);
        if (false) {
            try {
                Runtime.getRuntime().exec("nohup display " + DIR_IMG + name +  ".png &");
            } catch (IOException ex) {
                Logger.getLogger(GraphvizHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * compila el archivo y guarda su resultado en la direccionPng
     * @param direccionDot
     * @param direccionPng 
     */
    public static void compileDot(String direccionDot, String direccionPng){
        try
        {       
            ProcessBuilder pbuilder;
            pbuilder = new ProcessBuilder( "dot", "-Tpng", "-o", direccionPng, direccionDot );
            pbuilder.redirectErrorStream( true );
            //Ejecuta el proceso
            pbuilder.start();

        } catch (Exception e) { e.printStackTrace(); }
    }
    
    
    public static void main(String args[]){
        LinkedList<String> lines = new LinkedList<String>();
        lines.add("digraph prrr{");
        lines.add("Javier");
        lines.add("}");
        try {
            draw(lines, "Prueba10", true);
        } catch (IOException ex) {
            Logger.getLogger(GraphvizHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
