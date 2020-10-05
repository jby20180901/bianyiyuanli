#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<math.h>
#include<stdbool.h>
char c,res;
char token[10000];
int num;
enum sym{
	BEGINSY=1,ENDSY=2,FORSY=3,IFSY=4,THENSY=5,ELSESY=6,IDSY=7,INTSY=8,COLONSY=9,PLUSSY=10,STARSY=11,COMMASY=12,LPARSY=13,RPARSY=14,ASSIGNSY=15,UNKNOWNSY=16
};
int symbol;
FILE *p;

char symbols[17][20]={"","Begin","End","For","If","Then","Else","","","Colon","Plus","Star","Comma","LParenthesis","RParenthesis","Assign","Unknown"};

void getChar(){
	c=fgetc(p);
}

void clearToken(){
	memset(token,0,sizeof(token));
	token[0]='\0';
}

bool isEnter(){
	if(c=='\r') return true;
	else return false;
} 

bool isSpace(){
	if(c==' ') return true;
	else return false;
}

bool isNewline(){
	if(c=='\n') return true;
	else return false;
}

bool isTab(){
	if(c=='\t') return true;
	else return false;
}

bool isLetter(){
	if(c>='a'&&c<='z') return true;
	else if(c>='A'&&c<='Z') return true;
	else return false;
}

bool isDigit(){
	if(c>='0'&&c<='9') return true;
	else return false;
}

bool isColon(){
	if(c==':') return true;
	else return false;
}

bool isComma(){
	if(c==',') return true;
	else return false;
}

bool isEqu(){
	if(c=='=') return true;
	else return false;
}

bool isPlus(){
	if(c=='+') return true;
	else return false;
}

bool isStar(){
	if(c=='*') return true;
	else return false;
}

bool isLpar(){
	if(c=='(') return true;
	else return false;
}

bool isRpar(){
	if(c==')') return true;
	else return false;
}

void catToken(){
	int l=strlen(token);
	token[l]=c;
	token[l+1]='\0';
}

void retract(){
	fseek(p,-1,SEEK_CUR);
}

int reserver(){
	if(strcmp(token,"BEGIN")==0){
		return 1;
	}
	else if(strcmp(token,"END")==0){
		return 2;
	}
	else if(strcmp(token,"FOR")==0){
		return 3;
	}
	else if(strcmp(token,"IF")==0){
		return 4;
	}
	else if(strcmp(token,"THEN")==0){
		return 5;
	}
	else if(strcmp(token,"ELSE")==0){
		return 6;
	}
	else{
		return 0;
	}
}

int transNum(){
	int l=strlen(token);
	num=0;
	for(int i=0;i<=l-1;i++){
		num+=(token[i]-'0')*pow(10,l-1-i);
	}
	return num;
}

void error(){
	printf("Unknown\n");
	exit(0);
}

int getsym(){
	clearToken();
	while(isSpace()||isNewline()||isTab()||isEnter()){
		getChar();
	}
	if(c==EOF){
		return 1;
	}
	if(isLetter()){
		while(isLetter()||isDigit()){
			catToken();
			getChar();
		}
		retract();
		int resultValue=reserver();
		if(resultValue==0) symbol = IDSY;
		else symbol=resultValue;
	}
	else if(isDigit()){
		while(isDigit()){
			catToken();
			getChar();
		}
		retract();
		num=transNum();
		symbol = INTSY;
	}
	else if(isColon()){
		getChar();
		if(isEqu()) symbol=ASSIGNSY;
		else{ retract(); symbol=COLONSY;} 
	}
	else if(isPlus()){
		symbol=PLUSSY;
	}
	else if(isStar()){
		symbol=STARSY;
	}
	else if(isLpar()){
		symbol=LPARSY;
	}
	else if(isRpar()){
		symbol=RPARSY;
	}
	else if(isComma()){
		symbol=COMMASY;
	}
	else error();
	return 0;
}

void getout(){
	if(symbol==IDSY){
		printf("Ident(%s)\n",token);
	}
	else if(symbol==INTSY){
		printf("Int(%d)\n",num);
	}
	else{
		printf("%s\n",symbols[symbol]);
	}
}

int main (int argc,char *argv[])
{
	p=fopen(argv[1],"r");
	getChar();
	while(c!=EOF){ 
		if(getsym()==0){
			getout();
		}
		getChar();
	}
	return 0;
} 
