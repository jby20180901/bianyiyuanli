package analyser;

import java.util.ArrayList;

import symboltable.DataKeywordType;
import symboltable.DataType;
import tokenizer.TokenType;

public class OperatorStack {
	private ArrayList<Object> stack = new ArrayList<>();
	private int p=0;
	public void push(Object in) {
		stack.add(in);
		p++;
	}
	
	public Object pop() {
		p--;
		Object out = stack.get(p);
		stack.remove(p);
		return out;
	}
	
	public Object getTop() {
		Object out = stack.get(p-1);
		return out;
	}
	
	public Object getSecond() {
		Object out = stack.get(p-2);
		return out;
	}
	
	public Object getThird() {
		Object out = stack.get(p-3);
		return out;
	}
	
	public TokenType getTopToken() {
		TokenType out = null;
		for(int i = p-1; i >= 0; i --) {
			if(stack.get(i) instanceof TokenType) {
				out = (TokenType)stack.get(i); 
				break;
			}
		}
		return out;
	}
	
	public String toString() {
		String out = "";
		for(int i = p-1; i >= 0; i --) {
			if(stack.get(i) instanceof TokenType) {
				out = out + " T " + (TokenType)stack.get(i); 
			}
			else if(stack.get(i) instanceof DataType) {
				out = out + " D " + (DataType)stack.get(i); 
			}
			else if(stack.get(i) instanceof DataKeywordType) {
				out = out + " K " + (DataKeywordType)stack.get(i); 
			}
		}
		return out;
	}
}
