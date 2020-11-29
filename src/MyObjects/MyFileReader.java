/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyObjects;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author Alvarez
 */
//We needed this because jflex has some weird weirdness going on with how it read files and all that. idk
//Maybe we wont need it anymore because we will only work on 1 file
public class MyFileReader extends FileReader{
    
    private String path;
    
    public MyFileReader(File file) throws FileNotFoundException {
        super(file);
        this.path = file.getPath();
    }
    
    //Chapuz medio para que se pueda conseguir la direccion del archivo desde el scanner y el parser
    public String getPath(){
        return path;
    }
    
}
