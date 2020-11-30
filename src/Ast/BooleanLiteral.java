package Ast;

public class BooleanLiteral extends Expression{

    public Boolean val;

    public BooleanLiteral(Boolean val, int linea, int columna){
        super(linea, columna);
        this.val = val;
    }

    @Override
    public ExprResult execute(Entorno entorno) {
        return new ExprResult(Tipo.BOOLEAN, val);
    }
}
