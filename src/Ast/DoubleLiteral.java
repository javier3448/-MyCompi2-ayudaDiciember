package Ast;

public class DoubleLiteral extends  Expression{

    public Double valor;

    public DoubleLiteral(Double valor,int linea, int col) {
        super(linea, col);
        this.valor = valor;
    }

    @Override
    public ExprResult execute() {
        return new ExprResult(Tipo.DOUBLE,valor);
    }
}
