/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyObjects;

import java.util.ArrayList;

/**
 *  PENDIENTE QUITAR EL toString();
 * @author Alvarez
 */

//Recuperence de errores como ustedes quieran.
//Pero esto es lo que hago yo:
//Estrategia de recuperacion de errores por ahora:
//Siempre que encontremos un error vamos a tirar una exception de tipo MyError. Es posible que no podamos determinar
//todos los atributos de MyError cuando tiremos la exception por primera vez. Por ejemplo talvez la funcion que tiro el
//error no tiene acceso al nodo ast con la linea y columna de donde ocurrio el error.
//por eso el .execute del nodo expression tiene un try-catch que atrapa cualquier exception de este tipo y, si no tiene,
//linea y columna, se las setea. y luego vuelve a tira la exception.
//el .execute de statement maneja los errores igual que Expression la unica diferencia es que el no tira la exception
//nuevamente, si no que solo la reporta (con el metodo 'reportError(MyError)') y continua con la ejecucion del interprete
//Nota:
//Con esta estrategia de errores no se pueden reportar varios errores en un mismo statement


public class MyError extends Exception {

    public static ArrayList<MyError> errorArrayList = new ArrayList<MyError>();

    //Lo imprime en la la consola y lo agrega a la lista de errores
    public static void reportarError(MyError myError){
        System.out.println("ERROR");
        System.out.println("    Linea:   " + (myError.line == null ? "-" : myError.line.toString()));
        System.out.println("    Columna: " + (myError.column == null ? "-" : myError.column.toString()));
        System.out.println("    Tipo:    " + (myError.kind == null ? "-" : myError.kind.toString()));
        System.out.println("    Mensaje: " + (myError.msg == null ? "-" : myError.msg));

        errorArrayList.add(myError);
    }

    public static void clearErrors(){
        errorArrayList.clear();
    }

    public MyErrorKind kind = null;
    public Integer line = null;
    public Integer column = null;
    public String msg = null;
    
    public MyError(MyErrorKind kind, Integer line, Integer column, String msg) {
        this.kind = kind;
        this.line = line;
        this.column = column;
        this.msg = msg;
    }
    
    public MyError(String msg){
        this.kind = null;
        this.line = null;
        this.column = null;
        this.msg = msg;
    }

    public enum MyErrorKind{
        //Cuando no encuentra el archivo o algun otro error que no tenga nada que ver con nuestro interprete
        SISTEMA,
        LEXICO,
        SINTACTICO,
        //Como vamos a hacer un interprete no va ser muy confuso ver la diferencia entre errores de compilacion y runtime
        //Como es interprete No Tenemos Errores De Compilacion :(
        //COMPILACION,
        RUNTIME;

        @Override
        public String toString() {
          switch(this) {
              case SISTEMA: return "Sistema";
              case LEXICO: return "Lexico";
              case SINTACTICO: return "Sintactico";
              case RUNTIME: return "Runtime";
              default: throw new IllegalArgumentException();
          }
        }
    }
}
