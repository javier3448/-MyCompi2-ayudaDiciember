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

    public void execute() {

    }
}
