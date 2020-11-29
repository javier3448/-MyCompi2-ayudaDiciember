package Ast;

public abstract class Statement {
    public int linea;
    public int col;

    public abstract void execute();
}
