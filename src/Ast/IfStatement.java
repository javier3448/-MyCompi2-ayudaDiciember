package Ast;

import java.util.ArrayList;

public class IfStatement extends Statement {

    public Expression condition;
    public ArrayList<Statement> statements;

    public IfStatement(Expression condition, ArrayList<Statement> statements) {
        this.condition = condition;
        this.statements = statements;
    }

    public void execute(Entorno entorno) {
        var exprResult = condition.execute(entorno);
        if(exprResult.tipo != Tipo.BOOLEAN){
            String mensajeError = "condicion de if debe ser de tipo boolean, se obtuvo" + "\n" +
                    "Linea: " + this.linea + "\n" +
                    "columna: " + this.col;
            System.out.println(mensajeError);
            return;
        }

        if((Boolean)exprResult.value){
            entorno = new Entorno(entorno);

            for (var statement : statements) {
                statement.execute(entorno);
            }
        }
    }
}
