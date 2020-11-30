package Ast;

public class Declaration extends Statement{
    public Tipo tipo;
    public String identifier;
    public Expression val;

    public Declaration(Tipo tipo, String identifier, Expression val) {
        this.tipo = tipo;
        this.identifier = identifier;
        this.val = val;
    }

    public void execute(Entorno entorno) {
        var exprResult = val.execute(entorno);

        if(tipo == exprResult.tipo){
            String mensajeError = "Tipos no compatibles: " + tipo.toString() + " y " + exprResult.tipo.toString() + "\n" +
                                  "Linea:   " + this.linea + "\n" +
                                  "Columna: " + this.col + "\n";

            System.out.println(mensajeError);
            return;
        }

        String mensajeError = entorno.tryAddVariable(this.identifier, exprResult);

        if(mensajeError != null){
            System.out.println(mensajeError + "\n" +
                    "Linea:   " + this.linea + "\n" +
                    "Columna: " + this.col + "\n");
        }
    }
}
