package miniplc0java;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import miniplc0java.analyser.Analyser;
import miniplc0java.error.CompileError;
import miniplc0java.error.TokenizeError;
import miniplc0java.symboltable.SymbolTable;
import miniplc0java.tokenizer.StringIter;
import miniplc0java.tokenizer.Token;
import miniplc0java.tokenizer.TokenType;
import miniplc0java.tokenizer.Tokenizer;

public class App {
	static int index = 0;
//	static boolean debug = true;
	static boolean debug = false;
//	static boolean all = true;
	static boolean all = false;
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
		FileWriter writer;
		if(debug) {
			try {
				if(all) {
					writer = new FileWriter("D:/编译原理作业/bianyiyuanli/ass/" + index + ".s");
					writer.write("");//清空原文件内容
					writer.write(analyzer.AssembleTo());
					writer.flush();
					writer.close();
				}
				else {
					writer = new FileWriter("D:/编译原理作业/bianyiyuanli/ass/" + index + ".spp");
					writer.write("");//清空原文件内容
					writer.write(analyzer.AssembleTo());
					writer.flush();
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws CompileError, IOException {
		if (debug) {
			int totalNum = 30;
			if(all) {
				for(int i=1;i<=totalNum;i++) {
					SymbolTable.symboltable.clear();
					System.out.println();
					System.out.println("----------------------------------------");
					System.out.println();
					System.out.println("CASE+"+i);
					System.out.println();
					String source = "in/"+i+".c";
					String outputPath = "out/"+i+".o";
					index = i;
					System.out.println("  原始文件 :  " + source );
					System.out.println();
					System.out.println("  中间代码 :  " + "ass/" + index + ".s" );
					System.out.println();
					System.out.println("  输出文件 :  " + outputPath );
					System.out.println();
					Analyze(source, outputPath);
//	                wordAnalyze(source);
//	                copy(source);
					System.out.println("----------- Compile pass ! ------------");
				}
			}
			else {
				SymbolTable.symboltable.clear();
				System.out.println();
				System.out.println("----------------------------------------");
				System.out.println();
				System.out.println("TEST");
				System.out.println();
				String source = "in/0.cpp";
				String outputPath = "out/0.opp";
				System.out.println("  原始文件 :  " + source );
				System.out.println();
				System.out.println("  中间代码 :  " + "ass/0.spp" );
				System.out.println();
				System.out.println("  输出文件 :  " + outputPath );
				System.out.println();
				Analyze(source, outputPath);
//                wordAnalyze(source);
//                copy(source);
				System.out.println("----------- Compile pass ! ------------");
				System.out.println();
				System.out.println();
			}
			return;
		}
		else {
			String source = args[1];
			String outputPath = args[3];
			Analyze(source,outputPath);
//			wordAnalyze(source);
//			copy(source);
		}
	}
}
