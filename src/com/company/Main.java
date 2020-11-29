package com.company;

import Ast.ExprResult;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {

		//createNecessaryDirectories();

		Scanner scanner = new Scanner(System.in);

		//System.out.println("Ingrese el archivo de entrada: ");
		//String archivoEntrada = scanner.nextLine();

		String archivoEntrada = "/home/javier/Dropbox/ayudacompi2Diciembre2020/[MyCompi2]Proyecto1/src/com/company/entrada.txt";

		FileReader fileReader;

		try {

			fileReader = new FileReader(archivoEntrada);

		} catch (FileNotFoundException ex) {

			System.out.println("ERROR:");
			System.out.println("    " + ex.getMessage());

			return;
		}

		var lexer = new Parser.Lexer(fileReader);

		var repParser = new Parser.parser(lexer);

		try {

			repParser.parse();
			var root = repParser.root;
			System.out.println(root);

		} catch (Exception ex) {

			System.out.println("ERROR:");
			System.out.println("    Error en el parseo rep ");

		}
	}

	private static void createNecessaryDirectories() {

		File res = new File("res");
		boolean b0 =res.mkdir();
		File reportes = new File("hello");
		boolean b1 =reportes.mkdir();
		String a = "hello";
		Scanner in = new Scanner(System.in);

	}

	public static Object pr(){

		Character c = 'a';
		return c * c;

	}
}
