package FileManager;

import java.io.File;
import java.util.Scanner;

public class GeneradorJFlexCup {
    public static void main(String[] args) throws Exception
    {
        //generar lexer
        String lexerSpecificationPath = "src/Parser/scannerSpecification.jflex";

        File file = new File(lexerSpecificationPath);
        jflex.Main.generate(file);

        Scanner scanner = new Scanner(System.in);
        //scanner.nextLine();

        //generar parser
        String parserSpecificationPath = "src/Parser/parserSpecification.cup";
        String opciones[] = new String[4];
        opciones[0] = "-destdir";
        opciones[1] = "src/Parser";
        opciones[2] = "-nonterms";
        opciones[3] = parserSpecificationPath;

        java_cup.Main.main(opciones);
    }

}
