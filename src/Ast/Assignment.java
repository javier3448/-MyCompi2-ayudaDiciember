package Ast;

public class Assignment extends Statement{
    public String identifier;
    public Expression val;

    public Assignment(String identifier, Expression val) {
        this.identifier = identifier;
        this.val = val;
    }

    public void execute(Entorno entorno) {
        var exprResult = val.execute(entorno);

        String mensajeError = entorno.trySetVariable(this.identifier, exprResult);

        if(mensajeError != null){
            System.out.println(mensajeError +
                    "Linea:   " + this.linea + "\n" +
                    "Columna: " + this.col + "\n");
        }
    }
}
