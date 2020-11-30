/*********************************************************************/
/*------------------------------scanner------------------------------*/
/*********************************************************************/

//----------------User code----------------

package Parser;
import java_cup.runtime.*;
import MyObjects.MyError.MyErrorKind;
import MyObjects.MyError;
%%

//-----------------Options------------------
%public
%class Lexer
%cup
/* someSymbol.left */
%line
/* someSymbol.right */
%column

//------Member variables and functions------
%{
    StringBuilder stringBuilder = new StringBuilder();

    //Helper functions to return multiple java_cup.runtime.Symbol to the parser
    private Symbol symbol(int type){
        return new Symbol(type, yyline + 1, yycolumn + 1);
    }
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline + 1, yycolumn + 1, value);
    }
%}

//-----------Regular expressions-----------
LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace = {LineTerminator} | [ \t\f]

/* comments */
Comment = {TraditionalComment} | {EndOfLineComment}
TraditionalComment = "/*" [^*] ~"*/" | "/*" "*"+ "/"
                     | "/**" {CommentContent} "*"+ "/"
CommentContent = ( [^*] | \*+ [^/*] )*
EndOfLineComment = "//" {InputCharacter}* {LineTerminator}?

Number = -?[0-9]+(\.[0-9]+)?
Identifier = [:jletter:] [:jletterdigit:]*
%state STRING_STATE

%%

/* keywords */
<YYINITIAL> "while" { return symbol(sym.WHILE); }
<YYINITIAL> "if" { return symbol(sym.IF); }
<YYINITIAL> "else" { return symbol(sym.ELSE); }
<YYINITIAL> "struct" { return symbol(sym.STRUCT); }
<YYINITIAL> "return" { return symbol(sym.RETURN); }
<YYINITIAL> "print" { return symbol(sym.PRINT); }
<YYINITIAL> "scan" { return symbol(sym.SCAN); }
<YYINITIAL> "substring" { return symbol(sym.SUBSTRING); }
<YYINITIAL> "stringToDouble" { return symbol(sym.STRINGTODOUBLE); }
<YYINITIAL> "lengthOfArray" { return symbol(sym.LENGTHOFARRAY); }
<YYINITIAL> "lengthOfString" { return symbol(sym.LENGTHOFSTRING); }
<YYINITIAL> "double" { return symbol(sym.DOUBLE); }
<YYINITIAL> "boolean" { return symbol(sym.BOOLEAN); }
<YYINITIAL> "String" { return symbol(sym.STRING); }
<YYINITIAL> "Arreglo" { return symbol(sym.ARREGLO); }
<YYINITIAL> {
    /* literals */
    \" { stringBuilder.setLength(0); yybegin(STRING_STATE); }
    "true" { return symbol(sym.BOOLEAN_LITERAL, new Boolean(true)); }
    "false" { return symbol(sym.BOOLEAN_LITERAL, new Boolean(false)); }
    "null" { return symbol(sym.NULL_LITERAL); }
    {Number} { return symbol(sym.DOUBLE_LITERAL, Double.valueOf(yytext())); }
    /* non-literals */
    {Identifier} { return symbol(sym.IDENTIFIER, yytext()); }
    /* operators llaves y separators */
    "(" { return symbol(sym.O_PAREN); }
    ")" { return symbol(sym.C_PAREN); }
    ";" { return symbol(sym.SEMICOLON); }
    "," { return symbol(sym.COMMA); }
    "<=" { return symbol(sym.LESS_EQ); }
    ">=" { return symbol(sym.GREATER_EQ); }
    "<" { return symbol(sym.LESS); }
    ">" { return symbol(sym.GREATER); }
    "==" { return symbol(sym.EQ_EQ); }
    "!=" { return symbol(sym.NOT_EQ); }
    "=" { return symbol(sym.EQ); }
    "+" { return symbol(sym.PLUS); }
    "-" { return symbol(sym.MINUS); }
    "*" { return symbol(sym.MULT); }
    "%" { return symbol(sym.MOD); }
    "/" { return symbol(sym.DIV); }
    "&&" { return symbol(sym.AND); }
    "||" { return symbol(sym.OR); }
    "!" { return symbol(sym.NOT); }

    /* comments */
    {Comment} { /* ignore */ }
    /* whitespace */
    {WhiteSpace} { /* ignore */ }
}
<STRING_STATE> {
    \" { yybegin(YYINITIAL);
    return symbol(sym.STRING_LITERAL,
    stringBuilder.toString()); }
    [^\n\r\"\\]+ { stringBuilder.append( yytext() ); }
    \\t { stringBuilder.append('\t'); }
    \\n { stringBuilder.append('\n'); }
    \\r { stringBuilder.append('\r'); }
    \\\" { stringBuilder.append('\"'); }
    \\ { stringBuilder.append('\\'); }
}
/* error fallback */
[^] {
    MyError error = new MyError(MyErrorKind.LEXICO, yyline + 1, yycolumn + 1, "Illegal character <"+ yytext()+">");
    MyError.reportarError(error);
}
