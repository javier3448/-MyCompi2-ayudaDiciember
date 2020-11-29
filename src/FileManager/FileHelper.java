/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

/**
 *
 * @author Alvarez
 */
public class FileHelper {
    public static String fileSeparator = System.getProperty("file.separator");
    /**
     * 
     * @param carpeta
     * @param nombre
     * @param lines NO PUEDE SER NULL
     * @throws IOException 
     */
    public static void saveNewFile(File carpeta, String nombre, String[] lines) throws IOException{
        File f = new File(carpeta.getPath() + fileSeparator + nombre);
        f.createNewFile();
        
        FileWriter writer = new FileWriter(f.getPath());
        BufferedWriter bw = new BufferedWriter(writer);
        
        for(int i = 0; i < lines.length; i++){
            bw.write(lines[i]);
            bw.newLine();
        }
        
        bw.close();
    }
    /**
     * 
     * @param carpeta
     * @param nombre
     * @param contenido NO PUEDE SER NULL
     * @throws IOException 
     */
    public static void saveFile(File carpeta, String nombre, String contenido) throws IOException{
        File f = new File(carpeta.getPath() + fileSeparator + nombre);
        
        FileWriter writer = new FileWriter(f.getPath());
        BufferedWriter bw = new BufferedWriter(writer);
        
        bw.write(contenido);
        
        bw.close();
    }
    public static File saveNewFile(File file, String content) throws IOException{
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(writer);
            
        bw.write(content);
        bw.close();
        return file;
    }
    public static File saveFile(File file, String content) throws IOException{
        FileWriter writer = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(writer);
            
        bw.write(content);
        bw.close();
        return file;
    }
    public static void saveFile(String dir, String content) throws IOException{
        FileWriter writer = new FileWriter(dir);
        BufferedWriter bw = new BufferedWriter(writer);
            
        bw.write(content);
        bw.close();
    }
    public static void saveFile(String dir, String[] lines)throws IOException{
        FileWriter writer = new FileWriter(dir);
        BufferedWriter bw = new BufferedWriter(writer);
            
        for (String line : lines) {
            bw.write(line);
            bw.newLine();
        }
        bw.close();
    }
    public static void saveFile(String dir, Iterable<String> lines)throws IOException{
        FileWriter writer = new FileWriter(dir);
        BufferedWriter bw = new BufferedWriter(writer);
            
        for (String line : lines) {
            bw.write(line);
            bw.newLine();
        }
        bw.close();
    }
    public static void saveFile(File file, Iterable<String> lines)throws IOException{
        FileWriter writer = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(writer);
            
        for (String line : lines) {
            bw.write(line);
            bw.newLine();
        }
        bw.close();
    }
    public static void saveFile(File file, String[] lines)throws IOException{
        FileWriter writer = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(writer);
            
        for (String line : lines) {
            bw.write(line);
            bw.newLine();
        }
        bw.close();
    }
    public static String readFile(File file) throws FileNotFoundException, IOException{
        FileReader reader = new FileReader(file);
        BufferedReader br = new BufferedReader(reader);
        StringBuilder sb = new StringBuilder();
        String st;
        while((st = br.readLine()) != null){
            sb.append(st);
            sb.append('\n');
        }
        return sb.toString();
    }
}
