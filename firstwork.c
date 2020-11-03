#include<stdio.h>
#include<string.h>
#include<math.h>
#include<stdlib.h>

enum symbol{
	PLUS,MULI,IDENT,LPAR,RPAR,ST,NOEND
};

enum relation{
	BIG,SMALL,EQUAL,ERROR,DIE
};

int rel[6][6] = {{BIG,SMALL,SMALL,SMALL,BIG,BIG},{BIG,BIG,SMALL,SMALL,BIG,BIG},{BIG,BIG,ERROR,ERROR,BIG,BIG},{SMALL,SMALL,SMALL,SMALL,EQUAL,ERROR},{BIG,BIG,ERROR,ERROR,BIG,BIG},{SMALL,SMALL,SMALL,SMALL,ERROR,DIE}};
char stack[1000];
int ebp=-1;
int symbol1,symbol2,relat;
char c;
int next=0;
FILE *p;

void init(){
	stack[++ebp]='#';
}

void getChar(){
	c=fgetc(p);
	next = 0;
}

void checksymbol(int *a,char c){
	switch (c){
		case '+': *a=PLUS;  break;
		case '*': *a=MULI;  break;
		case 'i': *a=IDENT; break;
		case '(': *a=LPAR;  break;
		case ')': *a=RPAR;  break;
		case '#': *a=ST;    break;
		case 'N': *a=NOEND; break;
	}
}

void rerror(){
	printf("RE\n");
	exit(0);
}

void analyseplus(){
	if(ebp<2){
		rerror();
	}
	if(stack[ebp] == 'N' && stack[ebp-1] == '+' && stack[ebp-2] == 'N'){
		ebp-=2;
	}
	else{
		rerror();
	}
}

void analysemuli(){
	if(ebp<2){
		rerror();
	}
	if(stack[ebp] == 'N' && stack[ebp-1] == '*' && stack[ebp-2] == 'N'){
		ebp-=2;
	}
	else{
		rerror();
	}
}

void analyseident(){
	if(ebp<0){
		rerror();
	}
	if(stack[ebp] == 'i'){
		stack[ebp] = 'N';
	}
	else{
		rerror();
	}
}

void analysepar(){
	if(ebp<2){
		rerror();
	}
	if(stack[ebp] == '(' && stack[ebp-1] == 'N' && stack[ebp-2] == ')'){
		ebp-=2;
		stack[ebp] = 'N';
	}
	else{
		rerror();
	}
}

void banin(){
	switch(symbol2){
		case PLUS: analyseplus();   break;
		case MULI: analysemuli();   break;
		case IDENT: analyseident(); break;
		case RPAR: analysepar();    break;
	}
	printf("R\n");
}

void getin(){
	stack[++ebp]=c;
	printf("I%c\n",c);
	next = 1;
}

void error(){
	printf("E\n");
	exit(0);
}

void die(){
	exit(0);
}

void analyse(){
	checksymbol(&symbol1,c);
	while(!next){
		int bp = ebp;
		while(stack[bp]=='N') bp--;
		checksymbol(&symbol2,stack[bp]);
		int result = rel[symbol2][symbol1];
		switch (result){
			case BIG: banin();   break;
			case SMALL: getin(); break;
			case EQUAL: getin(); break;
			case ERROR: error(); break;
			case DIE: die();	 break;
		}
	}
}

int main(int argc,char *argv[])
{
	init();
	p=fopen(argv[1],"r");
	getChar();
	while(c!='\n'&&c!='\r'&&c!=EOF){ 
		analyse();
		getChar();
	}
	c='#';
	analyse();
	return 0;
	exit(0);
} 
