package AUTOMATA;

import javax.swing.JOptionPane;


public class Automata{
	
	static char [] car;
	int pausaposicion=0;
	int posicionlexer=0;
	char abecedario[] =  {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','ñ','_'};
	char abecedarioM[] =  {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','Ñ','_'};
	char numeros[] =  {'0','1','2','3','4','5','6','7','8','9'};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Automata aut = new Automata();
		String palabra = JOptionPane.showInputDialog(null,"Ingrese cadena");
		String cadena = palabra;
		System.out.println("CODIGO A ANALIZAR:");
		System.out.println(palabra);
		System.out.println("");
		cadena=cadena+" ";
		car = cadena.toCharArray();
		System.out.println("");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>INICIO DE CODIGO<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		System.out.println("");
		aut.inicio();
	}

	public void pausa() {
		
		if(car[posicionlexer]==' ') {pausaposicion=posicionlexer;
		//System.out.println("			Analizador pausado POSICION: " + pausaposicion);
		}
		if(posicionlexer<car.length-1 && car[posicionlexer]==' ') {posicionlexer++;inicio();}
		
	}
	
	public void inicio() {
		boolean verificador = false;
		if(posicionlexer==car.length-1){
			
			System.out.println("");
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>FINAL DE CODIGO<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			System.exit(0);
		}
		
		
		if(car[posicionlexer]==' ') {pausa();}
		
	//RUTA PARA ID
		//arreglar para guines
	
			for(int i=0; i<abecedario.length;i++) 
			{
				if((car[posicionlexer]==abecedario[i] || car[posicionlexer] == abecedarioM[i] ) && car[posicionlexer] != '_') 
				{
					prAuto();
					prBreak();
					prCase();
					prChar();
					prConst();
					prContinue();
					prDefault();
					prDo();
					prDouble();
					prElse();
					prEnum();
					prExtern();
					prFloat();
					prFor();
					prGoto();
					prif();
					prInt();
					prLong();
					prRegister();
					prReturn();
					prShort();
					prsigned();
					prSizeof();
					prStatic();
					prStruct();
					prSwitch();
					prTypedef();
					prunion();
					prUnsigned();
					prVoid();
					prVolatile();
					prWhile();
					ID1();break;
				} 
			}
	
		
	//RUTA PARA ENTERO
			for(int i=0; i<numeros.length;i++) 
				{if(car[posicionlexer]==numeros[i] ) 
				{
					verificador=true;ENTERO1();break;
				} 
		}
			
			switch(car[posicionlexer]) {
			case '+' : incremento1();break;
			case '=' : equivalente1();break;
			case '<' : menor1();break;
			case '>' : mayor1();break;
			case '-' : decremento1();break;
			case '(' : parA();break;
			case ')' : parC();break;
			case '{' : llA();break;
			case '}' : llC();break;
			case '[' : corA();break;
			case ']' : corC();break;
			case '*' : por1();break;
			case ' ' : pausa();break;
			case '.' : punto();break;
			case '|' : Ologico();break;
			case '&' : Ilogico();break;
			case '/' : comentario();break;
			case '!' : diferente1();break;
			case '%' : modulo();break;
			case ';' : System.out.println("			PUNTOYCOMA: "+car[posicionlexer]);
					   posicionlexer++;
					   inicio();
					   ;break;
			default : reportelectura();
					  System.out.println("			TOKEN DESCONOCIDO: " + car[posicionlexer]);
					  posicionlexer++;
					  pausaposicion=posicionlexer;
					  inicio();break;
			
			}
		
			
	}
	
	public void inicio2() {

		boolean id = true;
		boolean entero= true;
		boolean real = true;
		
		if(car[posicionlexer]==' ') {pausa();}
		
	//RUTA PARA ID
		//arreglar para guines
			for(int i=0; i<abecedario.length;i++) 
			{
				if(car[posicionlexer]==abecedario[i] || car[posicionlexer] == abecedarioM[i] ) 
				{
					ID1();break;
				} else {id = false;}
			}
		
	//RUTA PARA ENTERO
			for(int i=0; i<numeros.length;i++) 
				{if(car[posicionlexer]==numeros[i] ) 
				{
					ENTERO1();break;
				} else {entero = false;}
		}
			if(car[posicionlexer]=='+') {incremento1();}
			if(car[posicionlexer]=='=') {equivalente1();}
			if(car[posicionlexer]=='<') {menor1();}
			if(car[posicionlexer]=='>') {mayor1();}
			if(car[posicionlexer]=='-') {decremento1();}
			if(car[posicionlexer]=='(') {parA();}
			if(car[posicionlexer]==')') {parC();}
			if(car[posicionlexer]=='{') {llA();}
			if(car[posicionlexer]=='}') {llC();}
			if(car[posicionlexer]=='[') {corA();}
			if(car[posicionlexer]==']') {corC();}
			if(car[posicionlexer]=='*') {por1();}
	}

//IDENTIFICADOR
	private void ID1() {
					
		
					boolean digito=false;
					boolean letra=false;
					
					for(int i=0; i<numeros.length;i++) 
					{
						if(car[posicionlexer]==numeros[i] ) 
						{
							digito=true;
							reportelectura();
							//System.out.println("---->"+car[posicionlexer]+ " 							POSICION: "+posicionlexer);
						posicionlexer++;
						ID1();
						break;
						}
					
					}
					
					for(int i=0; i<abecedario.length;i++) 
					{
						if(car[posicionlexer]==abecedario[i] || car[posicionlexer] == abecedarioM[i] ) 
						{
							letra=true;
							reportelectura();
						posicionlexer++;
						ID1();
						break;
						
						}
				
					}
					if(digito==false && letra==false) {ID2();}
				
	}
	private void ID2() {
	
		String identificador = "";
		
		for(int i=pausaposicion;i<posicionlexer;i++) {
			identificador = identificador + car[i];
		}
		System.out.println("			IDENTIFICADOR: "+identificador);
		if(posicionlexer==car.length-1){
			
			System.out.println("");
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>FINAL DE CODIGO<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			System.exit(0);
		}
		reportelectura();
		
		inicio();
	}
//FIN IDENTIFICADOR
	
//ENTERO
	private void ENTERO1() {

		
		boolean digito=false;
		for(int i=0; i<numeros.length;i++) 
		{
			if(car[posicionlexer]=='.') {
				reportelectura();
				posicionlexer++;
				REAL1();break;}
			if(car[posicionlexer]==numeros[i] ) 
			{
				
			digito=true;
			reportelectura();
			posicionlexer++;
			pausaposicion=posicionlexer;
			ENTERO1();
			break;
			}
			}
		if(digito==false && car[posicionlexer]!='.') {
			entero2();
		}
		
		}
	private void entero2() {
	String numeroentero = "";
	
	for(int i=pausaposicion;i<posicionlexer;i++) {
		numeroentero = numeroentero + car[i];
	}
	System.out.println("			NUMERO ENTERO:"+numeroentero);
	//System.out.println("posicion del lexer :" + posicionlexer);
	inicio();
}
//FIN ENTERO

//REAL
	boolean dospuntos=false;
	private void REAL1() {
	boolean digito=false;
	
	for(int i=0; i<numeros.length;i++) 
	{
		
		if(car[posicionlexer]==numeros[i] ) 
		{
		digito=true;
		reportelectura();
		posicionlexer++;
		REAL1();
		break;
		}
			
		}
	if(car[posicionlexer]=='.') {System.out.println("			ERROR: HAY DOS PUNTOS EN EL NUMERO REAL SE AGREGARA .0");dospuntos=true;}
	if(digito==false){REAL2();}
}
	private void REAL2() {
		String numeroreal = "";
		
		for(int i=pausaposicion;i<posicionlexer;i++) {
			numeroreal = numeroreal + car[i];}
		if(dospuntos==true)
		{
		numeroreal=numeroreal+'0';
	    }
		 System.out.println("			NUMERO REAL: "+numeroreal);
		
		//System.out.println("posicion del lexer :" + posicionlexer);
		inicio();
}
//FINREAL
//INCREMENTO
	private void incremento1() {
		
		reportelectura();
			posicionlexer++;
			
			//System.out.println("posicion del lexer :" + posicionlexer);
			incremento2();

		
	}
	private void incremento2() {
		if(car[posicionlexer]=='+') {
			reportelectura();
		System.out.println("			INCREMENTO: "+ "++");
		//System.out.println("Analizador pausado en la posicion: " + pausaposicion);
		posicionlexer++;
		pausaposicion=posicionlexer;
		inicio();} else {suma();}
		}
//FIN INCREMENTO
//SUMA
	private void suma() {
	//reportelectura();
	System.out.println("			SUMA: "+ "+");
	pausaposicion=posicionlexer;
	//System.out.println("Analizador pausado en la posicion: " + pausaposicion);
	inicio();
//suma
}
//FIN SUMA
//EQUIVALENTE
	private void equivalente1() {
	
	//OJOreportelectura();
	posicionlexer++;
	//System.out.println("posicion del lexer :" + posicionlexer);
	equivalente2();


}
	private void equivalente2() {
if(car[posicionlexer]=='=') {
	 reportelectura();
System.out.println("			EQUIVALENTE: "+ "==");
//System.out.println("Analizador pausado en la posicion: " + pausaposicion);
posicionlexer++;
pausaposicion=posicionlexer;
inicio();} else {asignacion();}
}
//FINEQUIVALENTE

//ASIGNACION
	private void asignacion() {
	
		
		System.out.println("			ASIGNACION: "+ "=");
		pausaposicion=posicionlexer;
		//System.out.println("Analizador pausado en la posicion: " + pausaposicion);
		inicio();
	
}
//FINASIGNACION

//MENOR,MENORIGUAL,DESIGUAL
	private void menor1() {
	
	reportelectura();
	posicionlexer++;
	//System.out.println("posicion del lexer :" + posicionlexer);
	desigual();


}
	private void desigual() {
if(car[posicionlexer]=='>') {
	reportelectura();
System.out.println("			DESIGUAL"+ "<>");
//System.out.println("Analizador pausado en la posicion: " + pausaposicion);
posicionlexer++;
pausaposicion=posicionlexer;
inicio();} else {menorigual();}
}
	private void menorigual() {
if(car[posicionlexer]=='=') {
	reportelectura();
System.out.println("			MENORIGUAL"+ "<=");
//System.out.println("Analizador pausado en la posicion: " + pausaposicion);
posicionlexer++;
pausaposicion=posicionlexer;
inicio();} else {menor2();}
}
	private void menor2() {

	System.out.println("			MENOR: "+ "<");
	pausaposicion=posicionlexer;
	//System.out.println("Analizador pausado en la posicion: " + pausaposicion);
	inicio();
//suma

}
//FIN MENOR,MENOR IGUAL, DESIGUAL
//DIFERENTE
	private void diferente1() {
		
	reportelectura();
	posicionlexer++;
	//System.out.println("posicion del lexer :" + posicionlexer);
	diferente2();
}
	private void diferente2() {
		
		if(car[posicionlexer]=='=') {
			 reportelectura();
		System.out.println("			DIFERENTE: "+ "!=");
		//System.out.println("Analizador pausado en la posicion: " + pausaposicion);
		posicionlexer++;
		pausaposicion=posicionlexer;
		inicio();} else {
			pausaposicion=posicionlexer;
			System.out.println("			OPERADOR LOGICO NOT: " + car[posicionlexer-1]);inicio();}
}
//DIFERENTE
//MAYOR,MAYOR IGUAL
	private void mayor1() {
		
		reportelectura();
	posicionlexer++;
	//System.out.println("posicion del lexer :" + posicionlexer);
	mayorigual();


}
	private void mayorigual() {
if(car[posicionlexer]=='=') {
	reportelectura();
System.out.println("			MAYORIGUAL: "+ ">=");
//System.out.println("Analizador pausado en la posicion: " + pausaposicion);
posicionlexer++;
pausaposicion=posicionlexer;
inicio();} else {mayor();}
}
	private void mayor() {
	
		
		System.out.println("			MAYOR: "+ ">");
		pausaposicion=posicionlexer;
		//System.out.println("Analizador pausado en la posicion: " + pausaposicion);
		inicio();
	
}
//FINMAYOR,MAYOR IFUAL
//&&
	private void Ilogico() {
		
		reportelectura();
		posicionlexer++;
		//System.out.println("posicion del lexer :" + posicionlexer);
		Ilogico2();
	}
	private void Ilogico2() {
			
			if(car[posicionlexer]=='&') {
				 reportelectura();
			System.out.println("			OPERADOR LOGICO Y: "+ "&&");
			//System.out.println("Analizador pausado en la posicion: " + pausaposicion);
			posicionlexer++;
			pausaposicion=posicionlexer;
			inicio();} else {
				pausaposicion=posicionlexer;
				System.out.println("			TOKEN DESCONOCIDO: " + car[posicionlexer-1]);inicio();}
	}
//&&
//||
	private void Ologico() {
			
			reportelectura();
			posicionlexer++;
			//System.out.println("posicion del lexer :" + posicionlexer);
			Ologico2();
		}
	private void Ologico2() {
				
				if(car[posicionlexer]=='|') {
					 reportelectura();
				System.out.println("			OPERADOR LOGICO O: "+ "||");
				//System.out.println("Analizador pausado en la posicion: " + pausaposicion);
				posicionlexer++;
				pausaposicion=posicionlexer;
				inicio();} else {
					pausaposicion=posicionlexer;
					System.out.println("			TOKEN DESCONOCIDO: " + car[posicionlexer-1]);inicio();}
		}
//||
//COMENTARIO
	private void comentario() {
		
		reportelectura();
		posicionlexer++;
		//System.out.println("posicion del lexer :" + posicionlexer);
		comentario2();
	}
	private void comentario2() {
			
			if(car[posicionlexer]=='/') {
				 reportelectura();
			System.out.println("			COMENTARIO: "+ "//");
			//System.out.println("Analizador pausado en la posicion: " + pausaposicion);
			posicionlexer++;
			pausaposicion=posicionlexer;
			inicio();} else {
				pausaposicion=posicionlexer;
				System.out.println("			DIVISION:  " + car[posicionlexer-1]);inicio();}
	}
//FIN COMENTARIO
//DECREMENTO
	private void decremento1() {
		
		reportelectura();
		posicionlexer++;
		
		//System.out.println("posicion del lexer :" + posicionlexer);
		decremento2();

}
	private void decremento2() {
	if(car[posicionlexer]=='-') {
		reportelectura();
	System.out.println("			DECREMENTO: "+ "--");
	//System.out.println("Analizador pausado en la posicion: " + pausaposicion);
	posicionlexer++;
	pausaposicion=posicionlexer;
	inicio();} else {resta();}
	}
//FIN DECREMENTO
//RESTA
	private void resta() {
System.out.println("			RESTA: "+ "-");
pausaposicion=posicionlexer;
//System.out.println("Analizador pausado en la posicion: " + pausaposicion);
inicio();
//suma
}
//FIN RESTA

//DELIMITADORES
	private void parA() {
		reportelectura();
	System.out.println("			PARENTESIS ABIERTO: "+ "(");
	posicionlexer++;
	pausaposicion=posicionlexer;
	inicio();

}
	private void parC() {
		reportelectura();
		System.out.println("			PARENTESIS CERRADO: "+ ")");
		posicionlexer++;
		pausaposicion=posicionlexer;
		inicio();
		
	}
	private void llA() {
		reportelectura();
		System.out.println("			LLAVE ABIERTA: "+ "{");
		posicionlexer++;
		pausaposicion=posicionlexer;
		inicio();
		
	}
	private void llC() {
		reportelectura();
		System.out.println("			LLAVE CERRADA: "+ "}");
		posicionlexer++;
		pausaposicion=posicionlexer;
		inicio();
		
	}
	private void corA() {
		reportelectura();
		System.out.println("			CORCHETE ABIERTO: "+ "[");
		posicionlexer++;
		pausaposicion=posicionlexer;
		inicio();
		
	}
	private void corC() {
		reportelectura();
	System.out.println("			CORCHETE CERRADO: "+ "]");
	posicionlexer++;
	pausaposicion=posicionlexer;
	inicio();
	
}
//FIN DELIMTIADORES
//PUNTO
	private void punto() {
		reportelectura();
		System.out.println("			PUNTO: "+ ".");
		posicionlexer++;
		pausaposicion=posicionlexer;
		inicio();
		
	}
//FINPUNTO
//POR
	private void por1() {
		reportelectura();
		System.out.println("			POR: "+ "*");
		posicionlexer++;
		pausaposicion=posicionlexer;
		inicio();
	}
//FINPOR
//MODULO
	private void modulo() {
		reportelectura();
		System.out.println("			MODULO : "+ "%");
		posicionlexer++;
		pausaposicion=posicionlexer;
		inicio();
	}
//FIN MODULO
//PALABRAS RESERVADA
	private void prAuto(){
		
		if((   (car[posicionlexer]  =='a' || car[posicionlexer]   == 'A')
				&& (car[posicionlexer+1]=='u' || car[posicionlexer+1] == 'U')
				&& (car[posicionlexer+2]=='t' || car[posicionlexer+2] == 'T')
				&& (car[posicionlexer+3]=='o' || car[posicionlexer+3] == 'O')))
			{
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			pausaposicion=posicionlexer;
			System.out.println("			PALABRA RESERVADA: Auto");
			inicio();}
		return;
	}
	private void prBreak(){
		
		if((   (car[posicionlexer]  =='b' || car[posicionlexer]   == 'B')
			&& (car[posicionlexer+1]=='r' || car[posicionlexer+1] == 'R')
			&& (car[posicionlexer+2]=='e' || car[posicionlexer+2] == 'E')
			&& (car[posicionlexer+3]=='a' || car[posicionlexer+3] == 'A')
			&& (car[posicionlexer+4]=='K' || car[posicionlexer+4] == 'k')))
		{
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			pausaposicion=posicionlexer;
			System.out.println("			PALABRA RESERVADA: Break");
			inicio();
		} 
		return;
		
	}
	private void prCase(){
		
		if((   (car[posicionlexer]  =='c' || car[posicionlexer]   == 'C')
			&& (car[posicionlexer+1]=='a' || car[posicionlexer+1] == 'A')
			&& (car[posicionlexer+2]=='s' || car[posicionlexer+2] == 'S')
			&& (car[posicionlexer+3]=='e' || car[posicionlexer+3] == 'E')))
		{
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			pausaposicion=posicionlexer;
			System.out.println("			PALABRA RESERVADA: Case");
			inicio();
		} 
		return;
		
	}
	private void prChar(){
	
	if((   (car[posicionlexer]  =='c' || car[posicionlexer]   == 'C')
		&& (car[posicionlexer+1]=='h' || car[posicionlexer+1] == 'H')
		&& (car[posicionlexer+2]=='a' || car[posicionlexer+2] == 'A')
		&& (car[posicionlexer+3]=='r' || car[posicionlexer+3] == 'R')))
	{
		reportelectura();
		posicionlexer++;
		reportelectura();
		posicionlexer++;
		reportelectura();
		posicionlexer++;
		reportelectura();
		posicionlexer++;
		pausaposicion=posicionlexer;
		System.out.println("			PALABRA RESERVADA: Char");
		inicio();
	} 
	return;
	
}
	private void prConst(){
		
		if((   (car[posicionlexer]  =='c' || car[posicionlexer]   == 'C')
			&& (car[posicionlexer+1]=='o' || car[posicionlexer+1] == 'O')
			&& (car[posicionlexer+2]=='n' || car[posicionlexer+2] == 'N')
			&& (car[posicionlexer+3]=='s' || car[posicionlexer+3] == 'S')
			&& (car[posicionlexer+4]=='t' || car[posicionlexer+4] == 'T')))
		{
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			pausaposicion=posicionlexer;
			System.out.println("			PALABRA RESERVADA: Const");
			inicio();
		} 
		return;
		
	}
	private void prContinue(){
		
		if((   (car[posicionlexer]  =='c' || car[posicionlexer]   == 'C')
			&& (car[posicionlexer+1]=='o' || car[posicionlexer+1] == 'O')
			&& (car[posicionlexer+2]=='n' || car[posicionlexer+2] == 'N')
			&& (car[posicionlexer+3]=='t' || car[posicionlexer+3] == 'T')
			&& (car[posicionlexer+4]=='i' || car[posicionlexer+4] == 'I')
			&& (car[posicionlexer+5]=='n' || car[posicionlexer+5] == 'N')
			&& (car[posicionlexer+6]=='u' || car[posicionlexer+6] == 'U')
			&& (car[posicionlexer+7]=='e' || car[posicionlexer+7] == 'E')))
		{
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			pausaposicion=posicionlexer;
			System.out.println("			PALABRA RESERVADA: Continue");
			inicio();
		} 
		return;
		
	}
	private void prDefault(){
		if((   (car[posicionlexer]  =='d' || car[posicionlexer]   == 'D')
			&& (car[posicionlexer+1]=='e' || car[posicionlexer+1] == 'E')
			&& (car[posicionlexer+2]=='f' || car[posicionlexer+2] == 'F')
			&& (car[posicionlexer+3]=='a' || car[posicionlexer+3] == 'A')
			&& (car[posicionlexer+4]=='u' || car[posicionlexer+4] == 'U')
			&& (car[posicionlexer+5]=='l' || car[posicionlexer+5] == 'L')
			&& (car[posicionlexer+6]=='t' || car[posicionlexer+6] == 'T')))
		{
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			pausaposicion=posicionlexer;
			System.out.println("			PALABRA RESERVADA: Default");
			inicio();
		} 
		return;
	}
	private void prDo(){
		if((   (car[posicionlexer]  =='d' || car[posicionlexer]   == 'D')
			&& (car[posicionlexer+1]=='o' || car[posicionlexer+1] == 'O')
			&& (car[posicionlexer+2]!='u' || car[posicionlexer+2] !='u')))
		{
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			pausaposicion=posicionlexer;
			System.out.println("			PALABRA RESERVADA: Do");
			inicio();
		} 
		return;
	}
	private void prDouble(){

		
		if((   (car[posicionlexer]  =='d' || car[posicionlexer]   == 'D')
			&& (car[posicionlexer+1]=='o' || car[posicionlexer+1] == 'O')
			&& (car[posicionlexer+2]=='u' || car[posicionlexer+2] == 'U')
			&& (car[posicionlexer+3]=='b' || car[posicionlexer+3] == 'B')
			&& (car[posicionlexer+4]=='l' || car[posicionlexer+4] == 'L')
			&& (car[posicionlexer+5]=='e' || car[posicionlexer+5] == 'E')))
		{
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			pausaposicion=posicionlexer;
			System.out.println("			PALABRA RESERVADA: Double");
			inicio();
		} 
		return;
		
	}
	private void prElse() {
		if((   (car[posicionlexer]  =='e' || car[posicionlexer]   == 'E')
			&& (car[posicionlexer+1]=='l' || car[posicionlexer+1] == 'L')
			&& (car[posicionlexer+2]=='s' || car[posicionlexer+2] == 'S')
			&& (car[posicionlexer+3]=='e' || car[posicionlexer+3] == 'E')))
		{
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			pausaposicion=posicionlexer;
			System.out.println("			PALABRA RESERVADA: Else");
			inicio();
		} 
		return;
		
	}
	private void prEnum(){
		
		if((   (car[posicionlexer]  =='e' || car[posicionlexer]   == 'E')
			&& (car[posicionlexer+1]=='n' || car[posicionlexer+1] == 'N')
			&& (car[posicionlexer+2]=='u' || car[posicionlexer+2] == 'U')
			&& (car[posicionlexer+3]=='m' || car[posicionlexer+3] == 'M')))
		{
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			pausaposicion=posicionlexer;
			System.out.println("			PALABRA RESERVADA: Enum");
			inicio();
		} 
		return;
		
	}
	private void prExtern(){
		
		if((   (car[posicionlexer]  =='e' || car[posicionlexer]   == 'E')
			&& (car[posicionlexer+1]=='x' || car[posicionlexer+1] == 'X')
			&& (car[posicionlexer+2]=='t' || car[posicionlexer+2] == 'T')
			&& (car[posicionlexer+3]=='e' || car[posicionlexer+3] == 'E')
			&& (car[posicionlexer+4]=='r' || car[posicionlexer+4] == 'R')
			&& (car[posicionlexer+5]=='n' || car[posicionlexer+5] == 'N')))
		{
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			pausaposicion=posicionlexer;
			System.out.println("			PALABRA RESERVADA: Extern");
			inicio();
		} 
		return;
		
	}
	private void prFloat(){
		
		if((   (car[posicionlexer]  =='f' || car[posicionlexer]   == 'F')
			&& (car[posicionlexer+1]=='l' || car[posicionlexer+1] == 'L')
			&& (car[posicionlexer+2]=='o' || car[posicionlexer+2] == 'O')
			&& (car[posicionlexer+3]=='a' || car[posicionlexer+3] == 'A')
			&& (car[posicionlexer+4]=='t' || car[posicionlexer+4] == 'T')))
		{
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			pausaposicion=posicionlexer;
			System.out.println("			PALABRA RESERVADA: float");
			inicio();
		} 
		return;
		
	}
	private void prFor(){
		
		if((   (car[posicionlexer]  =='f' || car[posicionlexer]   == 'F')
			&& (car[posicionlexer+1]=='o' || car[posicionlexer+1] == 'O')
			&& (car[posicionlexer+2]=='r' || car[posicionlexer+2] == 'R')))
		{
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			pausaposicion=posicionlexer;
			System.out.println("			PALABRA RESERVADA: For");
			inicio();
		} 
		return;
		
	}
	private void prGoto(){
		
		if((   (car[posicionlexer]  =='g' || car[posicionlexer]   == 'G')
			&& (car[posicionlexer+1]=='o' || car[posicionlexer+1] == 'O')
			&& (car[posicionlexer+2]=='t' || car[posicionlexer+2] == 'T')
			&& (car[posicionlexer+3]=='o' || car[posicionlexer+3] == 'O')))
		{
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			pausaposicion=posicionlexer;
			System.out.println("			PALABRA RESERVADA: Goto");
			inicio();
		} 
		return;
		
	}
	private void prif(){
		if((   (car[posicionlexer]  =='i' || car[posicionlexer]   == 'I')
			&& (car[posicionlexer+1]=='f' || car[posicionlexer+1] == 'F')))
		{
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			pausaposicion=posicionlexer;
			System.out.println("			PALABRA RESERVADA: If");
			inicio();
		} 
		return;
	}
	private void prInt(){
		if((   (car[posicionlexer]  =='i' || car[posicionlexer]   == 'I')
			&& (car[posicionlexer+1]=='n' || car[posicionlexer+1] == 'N')
			&& (car[posicionlexer+2]=='t' || car[posicionlexer+2] == 'T')))
		{
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			pausaposicion=posicionlexer;
			System.out.println("			PALABRA RESERVADA: Int");
			inicio();
		} 
		return;
	}
	private void prLong(){
		
		if((   (car[posicionlexer]  =='l' || car[posicionlexer]   == 'L')
			&& (car[posicionlexer+1]=='o' || car[posicionlexer+1] == 'O')
			&& (car[posicionlexer+2]=='n' || car[posicionlexer+2] == 'N')
			&& (car[posicionlexer+3]=='g' || car[posicionlexer+3] == 'G')))
		{
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			pausaposicion=posicionlexer;
			System.out.println("			PALABRA RESERVADA: Long");
			inicio();
		} 
		return;
		
	}
	private void prRegister(){
		
		if((   (car[posicionlexer]  =='r' || car[posicionlexer]   == 'R')
			&& (car[posicionlexer+1]=='e' || car[posicionlexer+1] == 'E')
			&& (car[posicionlexer+2]=='g' || car[posicionlexer+2] == 'G')
			&& (car[posicionlexer+3]=='i' || car[posicionlexer+3] == 'I')
			&& (car[posicionlexer+4]=='s' || car[posicionlexer+4] == 'S')
			&& (car[posicionlexer+5]=='t' || car[posicionlexer+5] == 'T')
			&& (car[posicionlexer+6]=='e' || car[posicionlexer+6] == 'E')
			&& (car[posicionlexer+7]=='r' || car[posicionlexer+7] == 'R')))
		{
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			pausaposicion=posicionlexer;
			System.out.println("			PALABRA RESERVADA: Register");
			inicio();
		} 
		return;
		
	}
	private void prReturn(){
		
		if((   (car[posicionlexer]  =='r' || car[posicionlexer]   == 'R')
			&& (car[posicionlexer+1]=='e' || car[posicionlexer+1] == 'E')
			&& (car[posicionlexer+2]=='t' || car[posicionlexer+2] == 'T')
			&& (car[posicionlexer+3]=='u' || car[posicionlexer+3] == 'U')
			&& (car[posicionlexer+4]=='r' || car[posicionlexer+4] == 'R')
			&& (car[posicionlexer+5]=='n' || car[posicionlexer+5] == 'N')))
		{
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			pausaposicion=posicionlexer;
			System.out.println("			PALABRA RESERVADA: Return");
			inicio();
		} 
		return;
		
	}
	private void prShort(){
		
		if((   (car[posicionlexer]  =='s' || car[posicionlexer]   == 'S')
			&& (car[posicionlexer+1]=='h' || car[posicionlexer+1] == 'H')
			&& (car[posicionlexer+2]=='o' || car[posicionlexer+2] == 'O')
			&& (car[posicionlexer+3]=='r' || car[posicionlexer+3] == 'R')
			&& (car[posicionlexer+4]=='t' || car[posicionlexer+4] == 'T')))
		{
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			pausaposicion=posicionlexer;
			System.out.println("			PALABRA RESERVADA: Short");
			inicio();
		} 
		return;
		
	}
	private void prsigned(){
		
		if((   (car[posicionlexer]  =='s' || car[posicionlexer]   == 'S')
			&& (car[posicionlexer+1]=='i' || car[posicionlexer+1] == 'I')
			&& (car[posicionlexer+2]=='g' || car[posicionlexer+2] == 'G')
			&& (car[posicionlexer+3]=='n' || car[posicionlexer+3] == 'N')
			&& (car[posicionlexer+4]=='e' || car[posicionlexer+4] == 'E')
			&& (car[posicionlexer+5]=='d' || car[posicionlexer+5] == 'D')))
		{
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			pausaposicion=posicionlexer;
			System.out.println("			PALABRA RESERVADA: Signed");
			inicio();
		} 
		return;
		
	}
	private void prSizeof(){
		
		if((   (car[posicionlexer]  =='s' || car[posicionlexer]   == 'S')
			&& (car[posicionlexer+1]=='i' || car[posicionlexer+1] == 'I')
			&& (car[posicionlexer+2]=='z' || car[posicionlexer+2] == 'Z')
			&& (car[posicionlexer+3]=='e' || car[posicionlexer+3] == 'E')
			&& (car[posicionlexer+4]=='o' || car[posicionlexer+4] == 'O')
			&& (car[posicionlexer+5]=='f' || car[posicionlexer+5] == 'F')))
		{
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			pausaposicion=posicionlexer;
			System.out.println("			PALABRA RESERVADA: Siseof");
			inicio();
		} 
		return;
		
	}
	private void prStatic(){
		
		if((   (car[posicionlexer]  =='S' || car[posicionlexer]   == 's')
			&& (car[posicionlexer+1]=='T' || car[posicionlexer+1] == 't')
			&& (car[posicionlexer+2]=='A' || car[posicionlexer+2] == 'a')
			&& (car[posicionlexer+3]=='T' || car[posicionlexer+3] == 't')
			&& (car[posicionlexer+4]=='I' || car[posicionlexer+4] == 'i')
			&& (car[posicionlexer+5]=='C' || car[posicionlexer+5] == 'c')))
		{
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			pausaposicion=posicionlexer;
			System.out.println("			PALABRA RESERVADA: Static");
			inicio();
		} 
		return;
		
	}
	private void prStruct(){
		
		if((   (car[posicionlexer]  =='s' || car[posicionlexer]   == 'S')
			&& (car[posicionlexer+1]=='t' || car[posicionlexer+1] == 'T')
			&& (car[posicionlexer+2]=='r' || car[posicionlexer+2] == 'R')
			&& (car[posicionlexer+3]=='u' || car[posicionlexer+3] == 'U')
			&& (car[posicionlexer+4]=='c' || car[posicionlexer+4] == 'C')
			&& (car[posicionlexer+5]=='t' || car[posicionlexer+5] == 'T')))
		{
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			pausaposicion=posicionlexer;
			System.out.println("			PALABRA RESERVADA: Struct");
			inicio();
		} 
		return;
		
	}
	private void prSwitch(){
		
		if((   (car[posicionlexer]  =='s' || car[posicionlexer]   == 'S')
			&& (car[posicionlexer+1]=='w' || car[posicionlexer+1] == 'W')
			&& (car[posicionlexer+2]=='i' || car[posicionlexer+2] == 'I')
			&& (car[posicionlexer+3]=='t' || car[posicionlexer+3] == 'T')
			&& (car[posicionlexer+4]=='c' || car[posicionlexer+4] == 'C')
			&& (car[posicionlexer+5]=='h' || car[posicionlexer+5] == 'H')))
		{
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			pausaposicion=posicionlexer;
			System.out.println("			PALABRA RESERVADA: Switch");
			inicio();
		} 
		return;
		
	}
	private void prTypedef(){
		
		if((   (car[posicionlexer]  =='t' || car[posicionlexer]   == 'T')
			&& (car[posicionlexer+1]=='y' || car[posicionlexer+1] == 'Y')
			&& (car[posicionlexer+2]=='p' || car[posicionlexer+2] == 'P')
			&& (car[posicionlexer+3]=='e' || car[posicionlexer+3] == 'E')
			&& (car[posicionlexer+4]=='d' || car[posicionlexer+4] == 'D')
			&& (car[posicionlexer+5]=='e' || car[posicionlexer+5] == 'E')
			&& (car[posicionlexer+6]=='f' || car[posicionlexer+6] == 'F')))
		{
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			pausaposicion=posicionlexer;
			System.out.println("			PALABRA RESERVADA: Typedef");
			inicio();
		} 
		return;
		
	}
	private void prunion(){
		
		if((   (car[posicionlexer]  =='u' || car[posicionlexer]   == 'U')
			&& (car[posicionlexer+1]=='n' || car[posicionlexer+1] == 'N')
			&& (car[posicionlexer+2]=='i' || car[posicionlexer+2] == 'I')
			&& (car[posicionlexer+3]=='o' || car[posicionlexer+3] == 'O')
			&& (car[posicionlexer+4]=='n' || car[posicionlexer+4] == 'N')))
		{
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			pausaposicion=posicionlexer;
			System.out.println("			PALABRA RESERVADA: Union");
			inicio();
		} 
		return;
		
	}
	private void prUnsigned(){
		
		if((   (car[posicionlexer]  =='u' || car[posicionlexer]   == 'U')
			&& (car[posicionlexer+1]=='n' || car[posicionlexer+1] == 'N')
			&& (car[posicionlexer+2]=='s' || car[posicionlexer+2] == 'S')
			&& (car[posicionlexer+3]=='i' || car[posicionlexer+3] == 'I')
			&& (car[posicionlexer+4]=='g' || car[posicionlexer+4] == 'G')
			&& (car[posicionlexer+5]=='n' || car[posicionlexer+5] == 'N')
			&& (car[posicionlexer+6]=='e' || car[posicionlexer+6] == 'E')
			&& (car[posicionlexer+7]=='d' || car[posicionlexer+7] == 'D')))
		{
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			pausaposicion=posicionlexer;
			System.out.println("			PALABRA RESERVADA: Unsigned");
			inicio();
		} 
		return;
		
	}
	private void prVoid(){
		
		if((   (car[posicionlexer]  =='v' || car[posicionlexer]   == 'V')
			&& (car[posicionlexer+1]=='o' || car[posicionlexer+1] == 'O')
			&& (car[posicionlexer+2]=='i' || car[posicionlexer+2] == 'I')
			&& (car[posicionlexer+3]=='d' || car[posicionlexer+3] == 'D')))
		{
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			pausaposicion=posicionlexer;
			System.out.println("			PALABRA RESERVADA: Void");
			inicio();
		} 
		return;
		
	}
	private void prVolatile(){
		
		if((   (car[posicionlexer]  =='v' || car[posicionlexer]   == 'V')
			&& (car[posicionlexer+1]=='o' || car[posicionlexer+1] == 'O')
			&& (car[posicionlexer+2]=='l' || car[posicionlexer+2] == 'L')
			&& (car[posicionlexer+3]=='a' || car[posicionlexer+3] == 'A')
			&& (car[posicionlexer+4]=='t' || car[posicionlexer+4] == 'T')
			&& (car[posicionlexer+5]=='i' || car[posicionlexer+5] == 'I')
			&& (car[posicionlexer+6]=='l' || car[posicionlexer+6] == 'L')
			&& (car[posicionlexer+7]=='e' || car[posicionlexer+7] == 'E')))
		{
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			pausaposicion=posicionlexer;
			System.out.println("			PALABRA RESERVADA: Volatile");
			inicio();
		} 
		return;
		
	}
	private void prWhile(){
		
		if((   (car[posicionlexer]  =='w' || car[posicionlexer]   == 'W')
			&& (car[posicionlexer+1]=='h' || car[posicionlexer+1] == 'H')
			&& (car[posicionlexer+2]=='i' || car[posicionlexer+2] == 'I')
			&& (car[posicionlexer+3]=='l' || car[posicionlexer+3] == 'L')
			&& (car[posicionlexer+4]=='e' || car[posicionlexer+4] == 'E')))
		{
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			reportelectura();
			posicionlexer++;
			pausaposicion=posicionlexer;
			System.out.println("			PALABRA RESERVADA: While");
			inicio();
		} 
		return;
		
	}
//FIN PALABRAS RESERVADAS

//REPORTADOR DE LECTURA
	private void reportelectura() {
	int encender_apagar =  0 ;
	//System.out.println("");
	if(encender_apagar==1) {
	System.out.println("---->[POSICION:"+posicionlexer+"] REC>>> ["+car[posicionlexer]+"]");
	}
}
//REPORTADOR DE LECTURA



}






	


	
