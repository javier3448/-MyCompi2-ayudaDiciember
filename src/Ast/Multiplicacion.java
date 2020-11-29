package Ast;

public class Multiplicacion extends Expression{

    public Expression izq;
    public Expression der;

    public Multiplicacion(Expression izq, Expression der,int linea,int col)
    {
        super(linea,col);
        this.izq = izq;
        this.der = der;
    }


    public ExprResult execute() {

        ExprResult exprResultIzq  = izq.execute();
        ExprResult exprResultDer  = der.execute();

        if(exprResultIzq.tipo != Tipo.DOUBLE || exprResultDer.tipo != Tipo.DOUBLE){
            return new ExprResult(Tipo.ERROR, "Alguno de los dos operandos no es de tipo Double");
        }

        Double resultado = (Double) exprResultIzq.value * (Double) exprResultDer.value;


        return new ExprResult(Tipo.DOUBLE, resultado);
    }
}
