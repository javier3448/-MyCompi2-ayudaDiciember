package Ast;

import java.util.HashMap;
import java.util.Optional;


//Siempre voy a tener el 'ultimo' entorno
public class Entorno {

    Entorno anterior;
    HashMap<String, ExprResult> tablaSimbolos;

    public Entorno(Entorno anterior){
        this.anterior = anterior;
        this.tablaSimbolos = new HashMap<>();
    }

    //No hace chequeo de tipos!
    //retorna null si no ocurrio error
    public String tryAddVariable(String id, ExprResult val){

        if(tablaSimbolos.containsKey(id)){
            return "Ya existe una variable con ese nombre en ";
        }

        //@Mejora: que solo visite el hashMap 1 vez
        tablaSimbolos.put(id, val);
        return null;
    }

    //retorna null si no ocurrio error
    public String trySetVariable(String id, ExprResult val){
        var iter = this;
        while (iter != null){
            //@Mejora: que solo visite el hashMap 1 vez
            if(tablaSimbolos.containsKey(id)){
                var oldValue = tablaSimbolos.get(id);
                if(oldValue.tipo != val.tipo){
                    return "Tipos no compatibles";
                }
                tablaSimbolos.put(id, val);
            }

            iter = iter.anterior;
        }
        return "No existe la varialbe con el nombre " +  id;
    }

    //retorna empty si no existe la variable en la pila de entornos
    public Optional<Object> tryGetVariable(String id){
        var iter = this;
        while (iter != null){
            //@Mejora: que solo visite el hashMap 1 vez
            if(tablaSimbolos.containsKey(id)){
                return Optional.of(tablaSimbolos.get(id));
            }

            iter = iter.anterior;
        }
        return Optional.empty();
    }
}
