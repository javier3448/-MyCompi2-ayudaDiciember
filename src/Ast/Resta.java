package Ast;

public class Resta extends Expression{

    public Expression izq;
    public Expression der;

    public Resta(Expression izq, Expression der,int linea,int col)
    {
        super(linea,col);
        this.izq = izq;
        this.der = der;
    }


    @Override
    public ExprResult execute(Entorno entorno) {

        ExprResult exprResultIzq  = izq.execute(entorno);
        ExprResult exprResultDer  = der.execute(entorno);

        if(exprResultIzq.tipo != Tipo.DOUBLE || exprResultDer.tipo != Tipo.DOUBLE){
            return new ExprResult(Tipo.ERROR, "Alguno de los operandos no son de tipo double");
        }

        Double resultado = (Double) exprResultIzq.value - (Double) exprResultDer.value;
        return new ExprResult(Tipo.DOUBLE,resultado);
    }
}
