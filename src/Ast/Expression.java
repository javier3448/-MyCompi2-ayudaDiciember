package Ast;

import Ast.ExprResult;

public abstract class Expression {
    public int linea;
    public int col;

    Expression(int linea,int col){
        this.linea = linea;
        this.col = col;
    }

    public abstract ExprResult execute();

}
