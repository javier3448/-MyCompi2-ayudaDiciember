/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileManager;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Alvarez
 */
public class UfeFiles {
    
    /**
     * Nombre y ubicacion (relativa a la carpeta del proyecto) de los directorios que se generan cada vez que se crea un nuevo project
     */
    public static final String[] DEFAULT_DIRS = {"src",
                                                 "public"
                                                };
    
    /**
     * Nombre y ubicacion (relativa a la carpeta del proyecto) de los archivos que se generan cada vez que se crea un nuevo project
     */
    public static final String[] DEFAULT_FILES = {DEFAULT_DIRS[0] + File.separator + "App.ufe",
                                                  DEFAULT_DIRS[0] + File.separator + "App.css",
                                                  DEFAULT_DIRS[1] + File.separator + "index.html",
                                                 };
    
    public static final String MAIN = DEFAULT_FILES[0];
    
    /**
     * Crea un nuevo proyecto. No
     * @param parentFile
     * @param name
     * @return
     * @throws IOException 
     */
    public static boolean newProject(File parentFile, String name) throws IOException{
        
        for (String DEFAULT_DIR : DEFAULT_DIRS) {
            File f = new File(parentFile.getPath() + File.separator + name + File.separator + DEFAULT_DIR);
            f.mkdirs();
        }
        int i = 0;
        for (String DEFAULT_FILE : DEFAULT_FILES) {
            File f = new File(parentFile.getPath() + File.separator + name + File.separator + DEFAULT_FILE);
            f.createNewFile();
            
            String[] content = getDefaultFileContent(i);
            
            FileHelper.saveFile(f, content);
            i++;
        }
        return true;
    }
    
    /**
     * Verifica que el file tenga los file default para ser un proyecto valido
     * @param projectFile
     * @return 
     */
    public static boolean isFileProject(File projectFile){
        if (!projectFile.isDirectory()) {
            return false;
        }

        for (String DEFAULT_FILE : DEFAULT_FILES) {
            File f = new File(projectFile.getPath() + File.separator + DEFAULT_FILE);
            if (!f.exists()) {
                return false;
            }
        }
        
        return true;
    }

    private static String[] getDefaultFileContent(int defaultFileIndex) {
        switch (defaultFileIndex) {
            case 0://App.ufe
                String[] cntUfe =  {"import \"./App.css\";" ,
                                    "" ,
                                    "render(<panelBienvenida/>, divBienvenida);" ,
                                    "" ,
                                    "var titulo = \"Bienvenido\";" ,
                                    "var nombre0 = \"Javier\", nombre1 = \"Antonio\";" ,
                                    "var apellidos = \"Alvarez\" + \" Gonzalez\";" ,
                                    "" ,
                                    "var carneInt0 = 201612;" ,
                                    "var carneInt1 = 166 + - ((2 pow 5 + 27/3)*2 + 10/10);" ,
                                    "" ,
                                    "var someInt = 3;" ,
                                    "var otherInt = 3;" ,
                                    "var visible = someInt > otherInt || someInt <= otherInt;" ,
                                    "" ,
                                    "var charHolaMundo = {'H', 'o', 'l', 'a', ' ', 'm', 'u', 'n', 'd', 'o', ' ', '!'};" ,
                                    "var charHolaMundoSize = 12;" ,
                                    "" ,
                                    "component panelBienvenida(){" ,
                                    "	" ,
                                    "	var stringHolaMundo = \"\";" ,
                                    "	var i = 0;" ,
                                    "	" ,
                                    "	repetir(charHolaMundoSize){" ,
                                    "		stringHolaMundo = stringHolaMundo + charHolaMundo[i];" ,
                                    "		i = i + 1;" ,
                                    "	}" ,
                                    "	imprimir(stringHolaMundo);" ,
                                    "" ,
                                    "	stringHolaMundo = \"\";" ,
                                    "	mientras(i > 0){" ,
                                    "		stringHolaMundo = stringHolaMundo + charHolaMundo[i-1];" ,
                                    "		i = i - 1;" ,
                                    "	}" ,
                                    "	imprimir(stringHolaMundo);" ,
                                    "" ,
                                    "	SI(!visible){" ,
                                    "		return(</panelVacio>);" ,
                                    "	}" ,
                                    "	" ,
                                    "	" ,
                                    "	return (" ,
                                    "		<panel x = 0  y = 0 classname = \"panelprincipal\">" ,
                                    "			<text y = 20 id = titulo classname = \"texto titulo\" >{titulo}</text>" ,
                                    "			<text y = 80 id = nombres classname = \"texto subtitulo\" >{nombre0 + \" \" + nombre1}</text>" ,
                                    "			<text y = 140 id = apellidos classname = \"texto subtitulo\" >{apellidos}</text>" ,
                                    "			<text y = 200 id = apellidos classname = \"texto subtitulo\" >{carneInt0 + \"\" + carneInt1}</text>" ,
                                    "		</panel>" ,
                                    "	);" ,
                                    "" ,
                                    "}" ,
                                    "" ,
                                    "component panelVacio(){" ,
                                    "	var errroMsg = \"No se pudo mostrar la bienvenida porque visible es igual a: \" + visible;" ,
                                    "	return (<button id = txt onclick = {errroMsg}>No es visible</button>);" ,
                                    "}"};
                return cntUfe;
            case 1://App.css
                String[] cntCss =  {"texto" ,
                                    "{ /**Comentario" ,
                                    "	*multi línea**/" ,
                                    "	font-size: 10;" ,
                                    "	font: 'Comic Sans MS';" ,
                                    "	align: center;" ,
                                    "	font-color: black;" ,
                                    "	height: 30;" ,
                                    "	width:600;" ,
                                    "}" ,
                                    "	.titulo " ,
                                    "	{	" ,
                                    "		font-size: 20;" ,
                                    "		font: 'Courier New';" ,
                                    "		font-color: #0465b5;" ,
                                    "		border-width: 2;" ,
                                    "		height:50;" ,
                                    "	}" ,
                                    "	.subtitulo" ,
                                    "	{" ,
                                    "		font: 'Courier New';" ,
                                    "		font-color: #006e5d;" ,
                                    "		font-size: 15;" ,
                                    "		height:40;" ,
                                    "	}" ,
                                    "panelprincipal" ,
                                    "{ /**Comentario" ,
                                    "	*multi línea**/" ,
                                    "	width :600;" ,
                                    "	height : 300;" ,
                                    "	background : #c2a99d;" ,
                                    "	border-color: #403733;" ,
                                    "	border-width: 4;" ,
                                    "}"};
                return cntCss;
            case 2://index.html
                String[] cntHtml = {"<html><!--Primer archivo de calificación -->" ,
                                    "	<head>" ,
                                    "		<title>Mensaje de bienvenida</title>" ,
                                    "	</head>" ,
                                    "	<body>" ,
                                    "		<noufe>No se ha encontrado componentes para esta aplicación</noufe>" ,
                                    "		<div id=\"divBienvenida\"></div>" ,
                                    "	</body>" ,
                                    "</html>"};
                return cntHtml;
            default:
                throw new AssertionError();
        }
    }
}
