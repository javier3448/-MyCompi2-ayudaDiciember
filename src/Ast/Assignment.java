package Ast;

public class Assignment extends Statement{
    public String identifier;
    public Expression val;

    public Assignment(String identifier, Expression val) {
        this.identifier = identifier;
        this.val = val;
    }

    public void execute() {
        //AQUI AQUI AQUI
    }
}
