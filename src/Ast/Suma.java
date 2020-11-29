package Ast;


public class Suma extends Expression {
    public Expression izq;
    public Expression der;

    public Suma(Expression izq, Expression der,int linea,int col) {
        super(linea,col);
        this.izq = izq;
        this.der = der;
    }

    @Override
    public ExprResult execute() {

        ExprResult exprResultIzq  = izq.execute();
        ExprResult exprResultDer  = der.execute();

        if(exprResultIzq.tipo==Tipo.DOUBLE && exprResultDer.tipo == Tipo.DOUBLE){
            Double resultado = (Double) exprResultIzq.value + (Double) exprResultDer.value;

            return new ExprResult(Tipo.DOUBLE, resultado);
        }
        else if(exprResultIzq.tipo==Tipo.STRING && exprResultDer.tipo == Tipo.STRING){
            String resultado = (String) exprResultIzq.value + (String) exprResultDer.value;
            return new ExprResult(Tipo.STRING, resultado);
        }
        else if(exprResultIzq.tipo==Tipo.STRING && exprResultDer.tipo == Tipo.DOUBLE){
            String resultado = (String) exprResultIzq.value + (String) exprResultDer.value;
            return new ExprResult(Tipo.STRING, resultado);
        }
        else if(exprResultIzq.tipo==Tipo.STRING && exprResultDer.tipo == Tipo.BOOLEAN) {
            //TODO:  ver como convertir el boolean
            String resultado = (String) exprResultIzq.value + (String)exprResultDer.value;
            return new ExprResult(Tipo.STRING, resultado);
        }

            return new ExprResult(Tipo.ERROR, "Algunos Tipos de Datos");


    }
}
