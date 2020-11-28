
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import analyser.Analyser;
import error.CompileError;
import error.TokenizeError;
//import instruction.Instruction;
import tokenizer.StringIter;
import tokenizer.Token;
import tokenizer.TokenType;
import tokenizer.Tokenizer;

public class App {
	static StringIter it;
	static Scanner scanner;
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

	private static void Analyze(String source) throws FileNotFoundException, CompileError {
		InputStream is=new FileInputStream(source);
		scanner = new Scanner(is);
		it = new StringIter(scanner);
		Tokenizer wordAnalyzer = new Tokenizer(it);
		Analyser analyzer = new Analyser(wordAnalyzer);
		analyzer.analyse();
    }
	
    public static void main(String[] args) throws FileNotFoundException, CompileError {
        String source = "D:\\eclipse\\C0\\src\\1.c";
        String outputPath = "out";
        boolean text = true;
        boolean debug = true;
        if (debug) {
            outputPath = "1.txt";
            Analyze(source);
            //wordAnalyze(source);
            return;
        }
        else {
        	source = args[1];
        	Analyze(source);
        }
    }
}
