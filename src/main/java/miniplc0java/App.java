
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import miniplc0java.analyser.Analyser;
import miniplc0java.error.CompileError;
import miniplc0java.error.TokenizeError;
import miniplc0java.symboltable.SymbolTable;
//import instruction.Instruction;
import miniplc0java.tokenizer.StringIter;
import miniplc0java.tokenizer.Token;
import miniplc0java.tokenizer.TokenType;
import miniplc0java.tokenizer.Tokenizer;

public class App {
	static StringIter it;
	static Scanner scanner;
	private static void copy(String source) throws FileNotFoundException, CompileError {
		InputStream is=new FileInputStream(source);
		scanner = new Scanner(is);
		it = new StringIter(scanner);
		it.readAll();
		while(!it.isEOF()) {
			System.out.print(it.nextChar());
		}
	}

	private static void wordAnalyze(String source) throws FileNotFoundException, CompileError {
		InputStream is=new FileInputStream(source);
		scanner = new Scanner(is);
		it = new StringIter(scanner);
		Tokenizer wordAnalyzer = new Tokenizer(it);
		Token a = wordAnalyzer.nextToken();
		while(!(a.getTokenType().equals(TokenType.EOF))) {
			System.out.println(a.getValueString()+"  "+a.getTokenType());
			a = wordAnalyzer.nextToken();
		}
	}

	private static void Analyze(String source ,String gotos) throws CompileError, IOException {
		InputStream is=new FileInputStream(source);
		FileOutputStream iss = new FileOutputStream(gotos);
		scanner = new Scanner(is);
		it = new StringIter(scanner);
		Tokenizer wordAnalyzer = new Tokenizer(it);
		Analyser analyzer = new Analyser(wordAnalyzer);
		analyzer.analyse();
		iss.write(analyzer.Assemble());
		iss.close();
	}

	public static void main(String[] args) throws CompileError, IOException {
//        boolean debug = true;
		boolean debug = false;
		if (debug) {
			boolean all = true;
//        	boolean all = false;
			int totalNum = 30;
			int totalNum1 = 1;
			if(all) {
				for(int i=1;i<=totalNum;i++) {
					SymbolTable.symboltable.clear();
					System.out.println();
					System.out.println("----------------------------------------");
					System.out.println();
					System.out.println("CASE+"+i);
					System.out.println();
					String source = "./bin/"+i+".c";
					String outputPath = "1.txt";
					Analyze(source, "./out.o");
//	                wordAnalyze(source);
//	                copy(source);
				}
				for(int i=1;i<=totalNum1;i++) {
					SymbolTable.symboltable.clear();
					System.out.println();
					System.out.println("----------------------------------------");
					System.out.println();
					System.out.println("CASE-SF+"+i);
					System.out.println();
					String source = "./bin/"+i+".cpp";
					String outputPath = "1.txt";
					Analyze(source,"./out.o");
//	                wordAnalyze(source);
//	                copy(source);
				}
			}
			else {
				SymbolTable.symboltable.clear();
				System.out.println();
				System.out.println("----------------------------------------");
				System.out.println();
				System.out.println();
				String source = "./bin/1.cpp";
				String outputPath = "1.txt";
				Analyze(source, "./out.o");
//                wordAnalyze(source);
//                copy(source);
			}
			return;
		}
		else {
			String source = args[1];
			String outputPath = args[3];
			Analyze(source,outputPath);
//			wordAnalyze(source);
		}
	}
}
