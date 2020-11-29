package Ast;

import javax.swing.text.StyledEditorKit;

public class ExprResult {
    public Tipo tipo;
    public Object value;

    public ExprResult(Tipo tipo, Object value){
        this.tipo = tipo;
        this.value = value;
    }
}
