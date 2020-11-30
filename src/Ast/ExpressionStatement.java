package Ast;

public class ExpressionStatement extends Statement{

    public Expression expr;

    public ExpressionStatement(Expression expr) {
        this.expr = expr;
    }

    public void execute(Entorno entorno) {
        expr.execute(entorno);
    }
}
