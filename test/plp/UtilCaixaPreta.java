package plp;

import java.util.ArrayList;
import java.util.List;

public class UtilCaixaPreta {

	public static List<Object[]>  getEntradaExp1Test(){ 

		ArrayList<Object[]> data = new ArrayList<Object[]>();

		//TESTE PValorInteiro
		data.add(new Object[] { "6", "6", true, true, false });
		data.add(new Object[] { "3", "5", true, false, false });       

		//TESTE PValorBooleano
		data.add(new Object[] { "true", "true", true, true, false });
		data.add(new Object[] { "false", "true", true, false, false });

		//TESTE PValorString
		data.add(new Object[] { "\"texto\"", "\"texto\"", true, true, false });
		data.add(new Object[] { "texto", "texto", true, true, true });
		data.add(new Object[] { "\"texto\"", "\"otxet\"", true, false, false });
		data.add(new Object[] { "texto", "otxet", true, false, true });

		//TEST PExpMenos
		data.add(new Object[] { "- 1", "-1", true, true, false });
		data.add(new Object[] { "-3 ", "-2", true, false, false });
		data.add(new Object[] { "- true", "- true", false, true, false });
		data.add(new Object[] { "- \"texto\"", "- \"texto\"", false, true, false });

		//TEST PExpNot
		data.add(new Object[] { "not 1", "not 1", false, true, false });
		data.add(new Object[] { "not \"texto\"", "not \"texto\"", false, true, false });
		data.add(new Object[] { "not true", "false", true, true, false });
		data.add(new Object[] { "not false", "true", true, true, false });


		//TEST PExpLength
		data.add(new Object[] { "length 1", "length 1", false, true, false });
		data.add(new Object[] { "length \"texto\"", "5", true, true, false });
		data.add(new Object[] { "length \"texto1\"", "5", true, false, false });
		data.add(new Object[] { "length true", "false", false, true, false });
		data.add(new Object[] { "length false", "true", false, true, false });

		//TEST PExpMenos & PExpLength & PExpNot
		data.add(new Object[] { " - (length \"texto\")", "-5", true, true, false });
		data.add(new Object[] { " not (length \"texto\") == 5", "false", false, true, false });
		data.add(new Object[] { " not ((length \"texto\") == 5)", "false", true, true, false });
		data.add(new Object[] { " - (not ((length \"texto\") == 5))", "-5", false, true, false });

		//TEST ExpBinaria 
		data.add(new Object[] { "2+3", "5", true, true, false });
		data.add(new Object[] { "2+3", "4", true, false, false });
		data.add(new Object[] { "2-3", "-1", true, true, false });
		data.add(new Object[] { "2-3", "-2", true, false, false });
		data.add(new Object[] { "2+true", "5", false, true, false });
		data.add(new Object[] { "2+\"texto\"", "5", false, true, false });

		data.add(new Object[] { "true and true", "true", true, true, false });
		data.add(new Object[] { "true and true", "false", true, false, false });
		data.add(new Object[] { "true or true", "true", true, true, false });
		data.add(new Object[] { "false or false", "true", true, false, false });
		data.add(new Object[] { "2 and true", "5", false, true, false });
		data.add(new Object[] { "true and \"texto\"", "5", false, true, false });

		data.add(new Object[] { "\"texto\" ++ \"texto\"", "\"textotexto\"", true, true, false });        
		data.add(new Object[] { "2 ++ \"texto\"", "5", false, true, false });
		data.add(new Object[] { "true ++ \"texto\"", "5", false, true, false });

		//TEST PRECEDENCIA
		data.add(new Object[] { "2 == 5 - 3 and true or not (length \"texto\" + 1 == 6 )", "true", false, true, false });
		data.add(new Object[] { "(2 == 5 - 3) and true or not (length \"texto\" + 1 == 6 )", "true", true, true, false });
		data.add(new Object[] { "false and false or true", "true", true, true, false });
		data.add(new Object[] { "true or false and false", "true", true, true, false });
		data.add(new Object[] { "length \"texto\" ++ \"texto\"", "true", false, true, false });
		data.add(new Object[] { " - 2 + 3", "1", true, true, false });

		return data;
	}

	public static List<Object[]>  getEntradaExp2Test(){ 
		ArrayList<Object[]> data = new ArrayList<Object[]>();

		//TESTE PValorInteiro
		data.add(new Object[] { "let var x = 6 in  x", "6", true, true, false });
		data.add(new Object[] { "let var x = 3 in  x", "6", true, false, false });

		//TESTE PValorBooleano
		data.add(new Object[] { "let var x = true in  x", "true", true, true, false });
		data.add(new Object[] { "let var x = false in  x", "true", true, false, false });

		//TESTE PValorString
		data.add(new Object[] { "let var x = \"texto\" in  x", "\"texto\"", true, true, false });
		data.add(new Object[] { "let var x = texto in  x", "texto", true, true, true });
		data.add(new Object[] { "let var x = \"texto\" in  x", "\"otxet\"", true, false, false });
		data.add(new Object[] { "let var x = texto in  x", "otxet", true, false, true });

		//TEST PExpMenos
		data.add(new Object[] { "let var x = 1 in -x", "-1", true, true, false });
		data.add(new Object[] { "let var x = 3 in -x ", "-2", true, false, false });
		data.add(new Object[] { "let var x = true in -x", "- true", false, true, false });
		data.add(new Object[] { "let var x = \"texto\" in -x", "- \"texto\"", false, true, false });

		//TEST PExpNot
		data.add(new Object[] { "let var x = 1 in not x", "not 1", false, true, false });
		data.add(new Object[] { "let var x = \"texto\" in not x ", "not \"texto\"", false, true, false });
		data.add(new Object[] { "let var x = true in not x ", "false", true, true, false });
		data.add(new Object[] { "let var x = false in not x ", "true", true, true, false });


		//TEST PExpLength
		data.add(new Object[] { "let var x = 1 in length x", "length 1", false, true, false });
		data.add(new Object[] { "let var x = \"texto\" in length x", "5", true, true, false });
		data.add(new Object[] { "let var x = \"texto1\" in length x ", "5", true, false, false });
		data.add(new Object[] { "let var x = true in length x", "false", false, true, false });
		data.add(new Object[] { "let var x = false in length x", "true", false, true, false });

		//TEST Declaração Colateral
		data.add(new Object[] {"let var x =2, var y = x in x + 1", "true", true, true, true });

		//TEST Escopo
		data.add(new Object[] {"let var x=2, var y=3 in let var y=5 in x + y", "7", true, true, false });

		return data;
	}

	public static List<Object[]>  getEntradaFunc1Test(){ 
		ArrayList<Object[]> data = new ArrayList<Object[]>();
		//TEST IF THEN ELSE
		data.add(new Object[] { "if true then 1 else false", "1", false, true, false });
		data.add(new Object[] { "if true then 1 else 2", "1", true, true, false });
		data.add(new Object[] { "if not true then 1 else 2", "2", true, true, false });
		data.add(new Object[] { "if 2 then 1 else 2", "1", false, true, false });
		data.add(new Object[] { "if \"texto\" then 1 else 2", "1", false, true, false });

		//TEST DECFUNCAO E APLICACAO   
		data.add(new Object[] {
				"let fun Id x = x in \n"
				+ "let fun sum x y = Id(x) + Id(y) in \n" + "sum(0,true)"
				,"0", false, true, false });

		data.add(new Object[] {
				"let fun Id x = x in \n"
				+ "let fun sum x y = Id(x) + Id(y) in \n" + "sum(false,true)"
				,"0", false, true, false });

		data.add(new Object[] {
				"let fun Id x = x in \n"
				+ "let fun sum x y = Id(x) + Id(y) in \n" + "sum(2,3)"
				,"5", true, true, false });       


		data.add(new Object[] {
				"let fun Id x = x in \n" + "let fun sub x y = x - y in \n"
				+ "let fun sum x y = x + Id(y) in \n"
				+ "sum(sub(2,1), sub(true,3))"
				,"1", false, true, false });

		data.add(new Object[] {
				"let fun Id x = x in \n" + "let fun sub x y = x - y in \n"
				+ "let fun sum x y = x + Id(y) in \n"
				+ "sum(sub(5,2), sub(7,3))"
				,"7", true, true, false });

		data.add(new Object[] {
				"let var x = 3 in \n" + "let fun n y = y + x in \n"
				+ "let var x = 5 in \n" + "n (1)"
				,"6", true, true, false });	

		data.add(new Object[] {
				"let var x = 3 in \n" + "let fun n y = y + x in \n"
				+ "let var x = 5 in \n" + "n (1+2)"
				,"8", true, true, false });	

		data.add(new Object[] {
				"let var x = 3 in \n" + "let fun n y = y + x in \n"
				+ "let var x = 5 in \n" + " n(n(1))"
				,"11", true, true, false });

		data.add(new Object[] {				
				"let fun mult x y = if (x == 0) "
				+ "then (0) " +
				"else (y + (mult ((x - 1),y ))) in \n"
				+ "let fun fat n = \n" + 
				"if (n == 0) then (1) " + "else mult( n, fat(n - 1))  in\n"
				+ "fat(6)"
				,"720", true, true, false });


		data.add(new Object[] {
				"let fun mult x y = if (x == 0) then (0) "
				+ "else (y + mult((x - 1), y)) in mult(4,7)"
				,"28", true, true, false });


		data.add(new Object[] {
				"let fun suc x = x+1, fun pred x = x-1, fun id x =  x in \n"
				+ "suc(pred(2)) == id(2)"
				,"true", true, true, false });

		data.add(new Object[] {
				"let fun suc x = x+1, fun pred x = x-1, fun id x =  x in \n"
				+ "suc(pred(2)) == id(true)"
				,"true", false, true, false });


		data.add(new Object[] {
				"let fun Id x = x in \n" + "let fun comp x y = x == y in \n"
				+ "comp(false,true)"
				,"false", true, true, false });

		data.add(new Object[] {
				"let fun Id x = x in \n" + "let fun comp x y = x == y in \n"
				+ "comp(0,1)"
				,"false", true, true, false });

		data.add(new Object[] {
				"let fun Id x = x in \n" + "let fun comp x y = x == y in \n"
				+ "comp(0,true)"
				,"false", false, true, false });

		data.add(new Object[] {
				"let fun Id x = x in \n"
				+ "let fun sum x y = if (Id(true)) then x + Id(y) else 1 in \n"
				+ "sum(0,1)"
				,"1", true, true, false });

		return data;
	}

	public static List<Object[]> getEntradaFunc2Test() {		
		ArrayList<Object[]> data = new ArrayList<Object[]>();

		//TEST EXPRESSAO LAMBDA &  FUNCAO COMPOSTA 	& CURRIFICACAO		
		data.add(new Object[] {"let var id = fn x . x +  3 in id"
				,"fn x . x + 3", true, true, false });

		data.add(new Object[] {"let var id = fn x . x +  3 in id"
				,"fn x . 3 + x", true, false, false });

		data.add(new Object[] {"let fun suc x = x + 1, fun pred x = x - 1 in \n"
				+ "let  fun comp f g k = f(g(k)) in \n" + " comp(pred,suc,7)"
				,"7", true, true, false });

		data.add(new Object[] {"let fun suc x = x + 1, fun pred x = x - 1 in \n"
				+ "let  fun comp f g k = f(g(k)) in \n" + " comp(suc,pred,7)"
				,"7", true, true, false });

		data.add(new Object[] {"let var suc = fn x . x+1, \n" + "var pred = fn  x . x-1, \n"
				+ "var id = fn x . x in \n" + " id(9) == id(suc(pred(id(9))))"
				,"true", true, true, false });

		data.add(new Object[] {"let fun add x = fn y . x + y in \n"
				+ "let var x = 10, var somar = add(0) in \n" + " somar(1) + x + (add(2)(7)) "
				,"20", true, true, false });	

		data.add(new Object[] {"let fun double x = x + x in \n"
				+ "let fun comp f = fn k . f(k) in \n" + " comp(double)(3)"
				,"6", true, true, false });

		data.add(new Object[] {"let fun double x = x + x in \n"
				+ "let fun comp f = fn k . f(k) in \n" + " comp(double)"
				,"fn k . fn x . x + x(k)", true, true, false });


		return data;
	}

	public static List<Object[]>  getEntradaImp1Test(){ 

		ArrayList<Object[]> data = new ArrayList<Object[]>();		

		//TESTE PValorInteiro
		data.add(new Object[] { "{var a = 6; write(a)}", "6 ", true, true, false });
		data.add(new Object[] { "{var a = 3; write(a)}", "5 ", true, false, false });       

		//TESTE PValorBooleano
		data.add(new Object[] { "{var a = true; write(a)}", "true ", true, true, false });
		data.add(new Object[] { "{var a = false; write(a)}", "true ", true, false, false });

		//TESTE PValorString
		data.add(new Object[] { "{var a = \"texto\"; write(a)}", "\"texto\" ", true, true, false });
		data.add(new Object[] { "{var a = texto; write(a)}", "texto ", true, false, true });
		data.add(new Object[] { "{var a = texto; write(a)}", "otxet ", true, false, true });
		data.add(new Object[] { "{var a = \"texto\"; write(a)}", "\"otxet\" ", true, false, false });


		//TEST PExpMenos
		data.add(new Object[] { "{var a = - 1; write(a)}", "-1 ", true, true, false });
		data.add(new Object[] { "{var a = -3 ; write(a)}", "-2 ", true, false, false });
		data.add(new Object[] { "{var a = - true; write(a)}", "- true ", false, true, false });
		data.add(new Object[] { "{var a = - \"texto\"; write(a)}", "- \"texto\" ", false, true, false });

		//TEST PExpNot
		data.add(new Object[] { "{var a = not 1; write(a)}", "not 1 ", false, true, false });
		data.add(new Object[] { "{var a = not \"texto\"; write(a)}", "not \"texto\" ", false, true, false });
		data.add(new Object[] { "{var a = not true; write(a)}", "false ", true, true, false });
		data.add(new Object[] { "{var a = not false; write(a)}", "true ", true, true, false });


		//TEST PExpLength
		data.add(new Object[] { "{var a = length 1; write(a)}", "length 1 ", false, true, false });
		data.add(new Object[] { "{var a = length \"texto\"; write(a)}", "5 ", true, true, false });
		data.add(new Object[] { "{var a = length \"texto1\"; write(a)}", "5 ", true, false, false });
		data.add(new Object[] { "{var a = length true; write(a)}", "false ", false, true, false });
		data.add(new Object[] { "{var a = length false; write(a)}", "true ", false, true, false });

		//TEST PExpMenos & PExpLength & PExpNot
		data.add(new Object[] { "{var a =  - (length \"texto\"); write(a)}", "-5 ", true, true, false });
		data.add(new Object[] { "{var a =  (not (length \"texto\")) == 5; write(a)}", "false ", false, true, false });
		data.add(new Object[] { "{var a =  not ((length \"texto\") == 5); write(a)}", "false ", true, true, false });
		data.add(new Object[] { "{var a =  - (not ((length \"texto\") == 5)); write(a)}", "-5 ", false, true, false });

		//TEST ExpBinaria 
		data.add(new Object[] { "{var a = 2+3; write(a)}", "5 ", true, true, false });
		data.add(new Object[] { "{var a = 2+3; write(a)}", "4 ", true, false, false });
		data.add(new Object[] { "{var a = 2-3; write(a)}", "-1 ", true, true, false });
		data.add(new Object[] { "{var a = 2-3; write(a)}", "-2 ", true, false, false });
		data.add(new Object[] { "{var a = 2+true; write(a)}", "5 ", false, true, false });
		data.add(new Object[] { "{var a = 2+\"texto\"; write(a)}", "5 ", false, true, false });

		data.add(new Object[] { "{var a = true and true; write(a)}", "true ", true, true, false });
		data.add(new Object[] { "{var a = true and true; write(a)}", "false ", true, false, false });
		data.add(new Object[] { "{var a = true or true; write(a)}", "true ", true, true, false });
		data.add(new Object[] { "{var a = false or false; write(a)}", "true ", true, false, false });
		data.add(new Object[] { "{var a = 2 and true; write(a)}", "5 ", false, true, false });
		data.add(new Object[] { "{var a = true and \"texto\"; write(a)}", "5 ", false, true, false });

		data.add(new Object[] { "{var a = (\"texto\" ++ \"texto\"); write(a)}", "\"textotexto\" ", true, true, false });        
		data.add(new Object[] { "{var a = 2 ++ \"texto\"; write(a)}", "5 ", false, true, false });
		data.add(new Object[] { "{var a = true ++ \"texto\"; write(a)}", "5 ", false, true, false });

		data.add(new Object[] { "{var a = true or false and false; write(a)}", "true ", true, true, false });
		data.add(new Object[] { "{var a = length \"texto\" ++ \"texto\" ; write(a)}", "10 ", true, true, false });


		data.add(new Object[] {
				"{var a = 2, var c = 2 + a; write(a); write(c)}"
				,"2 4 ", true, true, false });

		data.add(new Object[] {
				"{var a = 2, var c = 2 + a; read(a); write(a); write(c)}"
				,"1 4 ", true, true, false });

		data.add(new Object[] {
				"{var a = 2, var c = 2 + a; read(a); read(a); write(a); write(c)}"
				,"1 4 ", true, true, true });

		data.add(new Object[] {
				"{var a = 2, var c = false; read(a); read(c); write(a); write(c)}"
				,"1 true ", true, true, false });

		data.add(new Object[] {
				"{var a = 2, var c = false; read(a); read(c); read(a); write(a); write(c)}"
				,"1 true ", true, true, true });

		data.add(new Object[] {
				"	{ var a = 3;  write(a);" +
				"  { " +
				"	var a = 2, var b = 5; " +
				"	 write(a); write(b+a) " +
				"	};" +
				" write(a)}"
				,"3 2 7 3 ", true, true, false });

		data.add(new Object[] {
				"{ var i = 0;" +
				"  while not (i == 3) do i := i + 1;" +
				" write(\"Hello World\") }"
				,"\"Hello World\" \"Hello World\" \"Hello World\" ", true, true, false });	

		data.add(new Object[] {
				"{ var i = 0;" +
				"  while (not (i == 5)) do if (i + i) == 4 then i := i + 2; write(i + i)  else i := i + 1; write(i + i)" +
				"  }"
				,"2 4 8 10 ", true, true, false });	


		data.add(new Object[] {
				"{\n" + " var a = 3, \n" + " var c = 0; \n" + " read(c);\n"
				+ " c := c +1; \n" + " write(a);\n" + " write(c);\n" + " {\n"
				+ "  var a = 2,\n" + "  var b = 5,\n" + "  var c = false,\n"
				+ "  var d = \"oi\";\n" + "  read(c);\n" + "  write(a);\n"
				+ "  write(b+a);\n" + "  write(c);\n" + "  write(d)\n" + "};\n"
				+ " write(a)\n" + "}"
				,"3 2 2 7 true \"oi\" 3 ", true, true, false });

		return data;	 
	}

	public static List<Object[]>  getEntradaImp2Test(){ 

		ArrayList<Object[]> data = new ArrayList<Object[]>();	

		//TESTE DEF PROCEDIMENTO; PROCEDIMENTO RECURSIVO; CHAMADA DE PROCEDIMENTO
		data.add(new Object[] {
				"{" + "var a  =  0 ," + "proc incA ()  {" + "a := a + 1" + "},"
				+ "proc decA ()  {" + "a := a - 1" + "};" + "call incA();"
				+ "call incA();" + "write(a);" + "read(a);" + "write(a)" + "}"
				,"2 1 ", true, true, false });

		data.add(new Object[] {
				"{ var b = 3,  " +
				"proc escreveRecursivo (int a) " +
				"{ " +
				"if (not (a == 0)) then " +
				"{ var x = 0; x := a - 1; write(\"Ola \" ++ \"PLP\"); call escreveRecursivo(x)} " +
				"else skip}; " +
				"call escreveRecursivo(b)}"
				,"\"Ola PLP\" \"Ola PLP\" \"Ola PLP\" ", true, true, false });


		data.add(new Object[] {
				"{ var x = 0, var b = true, var c =  \"PLP \"," +
				"  proc p (int y, boolean z, string w) {x := x + y; b := z and b; c := c ++ w }; " +
				" call p (2,true, \"2011.1\"); write(x);  write(b); write(c) }"			
				,"2 true \"PLP 2011\" ", true, false, false });

		data.add(new Object[] {
				"{ var x = 0, var b = true, var c =  \"PLP \"," +
				"  proc p (int y, boolean z, string w) {x := x + y; b := z and b; c := c ++ w }; " +
				" call p (true, 2,\"2011.1\"); write(x);  write(b); write(c) }"			
				,"2 true \"PLP 2011\" ", false, true, false });

		data.add(new Object[] {
				"{ var x = 0, var b = true, var c =  \"PLP \"," +
				"  proc p (int y, boolean z, string w) {x := x + y; b := z and b; c := c ++ w }; " +
				" call p (x, b, c); write(x);  write(b); write(c) }"			
				,"0 true \"PLP PLP \" ", true, true, false });

		return data;
	}

	public static List<Object[]>  getEntradaOO1Test(){ 

		ArrayList<Object[]> data = new ArrayList<Object[]>();	
		data.add(new Object[] {
				"    { "  +
				"       classe Contador { "  +
				"           int valor = 1; "  +
				"           proc print() { "  +
				"             write(this.valor) "  +
				"           } "  +
				"       }      "  +
				"       ; "  +
				"  "  +
				"       { "  +
				"         Contador c := new Contador "  +
				"         ; "  +
				" 	write(\"Teste do write\"); "  +
				"         c.print() "  +
				"      } "  +
				"  "  +
				"    } "			
				,"Teste do write 1 ", true, true, false });


		data.add(new Object[] {
				"    { "  +
				"       classe Contador { "  +
				"           int valor = 1; "  +
				"           proc print() { "  +
				"             write(this.valor) "  +
				"           }, "  +
				"  "  +
				"           proc incrementa() { "  +
				"             this.print(); "  +
				"             this.valor := this.valor + 1 "  +
				"  "  +
				"           } "  +
				"       }, "  +
				"       classe Contador1 { "  +
				"           int valor = 1; "  +
				"           proc print() { "  +
				"             write(this.valor) "  +
				"           }, "  +
				"  "  +
				"           proc incrementa(int a,Contador c) { "  +
				" 	    c.incrementa();	     "  +
				"             this.valor := this.valor + a; "  +
				" 	    write(\"O novo valor de Contador1 e: \"++this.valor) "  +
				"           } "  +
				"       }        "  +
				"       ; "  +
				"  "  +
				"       { "  +
				"         Contador c := new Contador, "  +
				" 	Contador1 c1 := new Contador1, "  +
				" 	boolean ok1 = true, "  +
				" 	boolean ok2 = false, "  +
				" 	string palavra = \"PLPOO\", "  +
				" 	int d = 6, int x = 3;	 "  +
				"  "  +
				" 	write(\"O valor de x e: \"++x); "  +
				" 	write(\"O valor de palavra e: \"++palavra); "  +
				" 	write(\"O valor de ok e: \"++ok1); "  +
				" 	write(ok1==ok2); "  +
				" 	write(ok1 or ok2); "  +
				" 	write(ok1 and ok2); "  +
				" 	write(d+x); "  +
				" 	write(d-x);  "  +
				" 	write(-d); "  +
				" 	write(not ok1); "  +
				" 	write(length palavra); "  +
				" 	write(not((((length palavra)+5-7)==-(-3)) or (false and true))); "  +
				" 	write(2-5+5); "  +
				" 	write(not (((length palavra )-7)==3)) "  +
				"  "  +
				"       } "  +
				"  "  +
				"    } "
				,"O valor de x e: 3 O valor de palavra e: PLPOO O valor de ok e: true false true false 9 3 -6 false 5 false 2 true ", true, true, false });



		data.add(new Object[] {
				"    { "  +			
				"       classe Contador { "  +
				"           int valor = 1; "  +
				"           proc print() { "  +
				"             write(this.valor) "  +
				"           }, "  +
				"  "  +
				"           proc incrementa() { "  +			
				"             this.print(); "  +				
				"             this.valor := this.valor + 1 "  +
				"  "  +
				"           } "  +
				"       }, "  +
				"       classe Contador1 { "  +
				"           int valor = 1, "  +
				" 	  Contador c := new Contador	 "  +
				"           ; "  +			
				"           proc print() { "  +
				"             write(this.valor) "  +
				"           }, "  +
				"  "  +
				"           proc incrementa(int a,Contador c) { "  +
				" 	    c.incrementa();	     "  +
				"             this.valor := this.valor + a; "  +
				" 	    write(\"O novo valor de Contador1 e: \"++this.valor) "  +
				"           } "  +
				"       }        "  +
				"       ; "  +
				"  "  +
				"       { "  +				
				"         Contador c := new Contador, "  +
				" 	Contador1 c1 := new Contador1, "  +
				" 	boolean ok1 = true, "  +
				" 	boolean ok2 = false, "  +
				" 	string palavra = \"PLP\", "  +
				" 	int d = 6, int x = 3 "  +
				"         ; "  +
				"  "  +				
				" 	if(ok1) then { "  +				
				" 		write(\"Entrou no 1 if\") "  +
				" 	}; "  +
				" 	 "  +				
				" 	if(not ok1) then { "  +
				" 		write(\"Entrou no 2 if\") "  +
				" 	} else { "  +			
				" 		write(\"Entrou no 2 else\") "  +
				" 	}; "  +
				"  "  +
				" 	if(not(ok1 and ok2)) then { "  +			
				" 		write(\"Entrou no 2 if\") "  +
				" 	} else { "  +
				" 		write(\"Entrou no 2 else\") "  +
				" 	}; "  +				
				" 	if(ok1 and ok2) then { "  +
				" 		write(\"Entrou no primeiro if do ifs aninhados\") "  +
				" 	} else { "  +
				" 		if(ok1 or ok2) then { "  +				
				" 			write(\"Entrou no if aninhado\") "  +
				" 		} "  +
				" 		else { "  +
				" 			write(\"Entrou no else aninhado\") "  +
				" 		} "  +
				" 	}; "  +
				"  "  +			
				" 	while ok1 do { "  +
				" 		if(x==0) then { "  +
				" 			ok1 := false "  +
				" 		} "  +
				" 		else { "  +
				" 			x := x - 1 "  +
				" 		} "  +
				" 	}; "  +				
				" 	write(\"O valor de x e: \"++x); "  +
				"  "  +				
				" 	if(c==null) then { "  +
				" 		write(\"c e null\") "  +
				" 	} else { "  +			
				" 		write(\"c nao e null\") "  +
				" 	}; "  +
				" 	c := null; "  +
				" 	if(c==null) then { "  +				
				" 		write(\"c agora e null\") "  +
				" 	} else { "  +
				" 		write(\"c continua nao sendo null\") "  +
				" 	}; "  +			
				" 	c1.c := null; "  +
				" 	if(c1.c==null) then { "  +				
				" 		write(\"O contador de Contador1 e null\") "  +
				" 	} else { "  +
				" 		write(\"O contador de Contador1 nao e null\") "  +
				" 	}; "  +				
				" 	c := new Contador; "  +
				"  if(not c==null) then { "  +			
				"  write(\"O comando new em c deu certo\") "  +
				" 	} else { "  +
				" 		write(\"O comando new em c deu erro\") "  +
				" 	}; "  +			
				" 	c1.c := new Contador; "  +
				" 	if(not c1.c==null) then { "  +			
				" 		write(\"O comando new com acesso atributo id deu certo\") "  +
				" 	} else { "  +
				" 		write(\"O comando new com acesso atributo id deu errado\") "  +
				" 	}; "  +
				" 	 "  +				
				" 	skip "  +
				"       }; "  +
				"  "  +				
				"       write(\"Saiu do ComDeclaracao\") "  +
				"    }"
				,"Entrou no 1 if Entrou no 2 else Entrou no 2 if Entrou no if aninhado O valor de x e: 0 c nao e null c agora e null O contador de Contador1 e null O comando new em c deu certo O comando new com acesso atributo id deu certo Saiu do ComDeclaracao ", true, true, false });

		data.add(new Object[] {
				"    { "  +
				"       classe Contador0 { "  +
				"           int valor = 1; "  +
				"         proc print() { "  +
				"             write(this.valor) "  +
				"           }, "  +
				"  "  +
				"           proc incrementa() { "  +
				"             this.print(); "  +
				"             this.valor := this.valor + 1 "  +
				"  "  +
				"           } "  +
				"       }, "  +
				"  "  +
				"       classe Contador { "  +
				"           Contador0 c2 := new Contador0, "  +
				"           int valor = 1; "  +
				"         proc print() { "  +
				"             write(this.valor) "  +
				"           }, "  +
				"  "  +
				"           proc incrementa() { "  +
				"             this.print(); "  +
				"             this.valor := this.valor + 1 "  +
				"           } "  +
				"  "  +
				"  "  +
				"       }, "  +
				"       classe Contador2 { "  +
				"           Contador c3 := new Contador, "  +
				"           int valor = 1; "  +
				"  "  +
				"           proc incrementa() { "  +
				"             this.valor := this.valor + 1 "  +
				"           }, "  +
				"  "  +
				"           proc print() { "  +
				"             write(((this).c3).valor); "  +
				"             (this.c3).c2.incrementa(); "  +
				"  "  +
				"             write(\"Vai imprimir um acesso atributo composto e com this\"); "  +
				"             write(((this.c3).c2).valor) "  +
				"           } "  +
				"  "  +
				"       } "  +
				"  "  +
				"      ; "  +
				"  "  +
				"      { "  +
				"         Contador c := new Contador, "  +
				"  	int d = 8, int x = 3, "  +
				"         Contador2 c2 := new Contador2 "  +
				" 	; "  +
				" 	c.valor := 4; "  +
				"     	write(\"Vai chamar metodo com Acesso Atributo id\"); "  +
				"     	(c2).c3.print(); "  +
				"     	write(\"vai imprimir C:\"++c.valor); "  +
				"     	c.print(); "  +
				" 	c2.print() "  +
				"      } "  +
				"  "  +
				"    } "
				,"Vai chamar metodo com Acesso Atributo id 1 vai imprimir C:4 4 1 1 Vai imprimir um acesso atributo composto e com this 2 ", true, true, false });


		data.add(new Object[] {
				"    { "  +
				"       classe Math { "  +
				"           int resultado = 0, "  +
				"           int temp = 0, "  +
				" 	  boolean ok = true "  +
				" 	  ; "  +
				"  "  +
				"           proc multiplica(int a,int b) { "  +
				"                 this.initMultiplica(); "  +
				" 		while(this.ok) do{ "  +
				" 			if (b==0) then { "  +
				" 				this.ok := false "  +
				" 			} "  +
				" 			else { "  +
				" 				this.resultado := this.resultado + a; "  +
				" 				b := b-1 "  +
				" 			} "  +
				" 		} "  +
				"           }, "  +
				"  "  +
				"           proc fatorialRecursivo(int n){ "  +
				"             if((n==0) or (n==1)) then { "  +
				"               this.resultado := 1 "  +
				"             } else { "  +
				"               this.fatorialRecursivo(n-1); "  +
				"               this.multiplica(this.resultado,n) "  +
				"             } "  +
				"           }, "  +
				"  "  +
				"           proc fatorialIterativo(int n) { "  +
				"             this.initFatorial(); "  +
				"             while(this.ok) do{ "  +
				"               if(n == 0) then{ "  +
				"                 this.ok := false "  +
				"               } "  +
				"               else { "  +
				"                 this.multiplica(this.resultado,n); "  +
				"                 this.ok := true; "  +
				"                 n := n-1 "  +
				"               } "  +
				"             } "  +
				"           }, "  +
				"  "  +
				"           proc initMultiplica(){ "  +
				"             this.ok := true; "  +
				"             this.resultado := 0 "  +
				"           }, "  +
				"  "  +
				"           proc initFatorial(){ "  +
				"             this.ok := true; "  +
				"             this.resultado := 1 "  +
				"           } "  +
				"       } "  +
				"       ; "  +
				"  "  +
				"       { "  +
				" 	  Math m := new Math, "  +
				"           int x = 200, "  +
				"           int y = 70 "  +
				" 	  ;        "  +
				" 	  m.multiplica(199+1+(-2)+2,70+9+(-7)+(-2)); "  +
				"           m.multiplica(x,y); "  +
				"           write(\"O resultado de 200*70 e: \"++m.resultado); "  +
				"           m.resultado := 0; "  +
				"           m.fatorialIterativo(5); "  +
				"           write(\"O fatorial de 5 e: \"++m.resultado); "  +
				"           m.fatorialRecursivo(6); "  +
				"           write(\"O fatorial de 6 e: \"++m.resultado); "  +
				" 	  skip "  +
				"       } "  +
				"  "  +
				"    } "
				,"O resultado de 200*70 e: 14000 O fatorial de 5 e: 120 O fatorial de 6 e: 720 ", true, true, false });



		data.add(new Object[] {
				" { "  +
				"     classe LValor { "  +
				"         int valor = -100, "  +
				"         LValor prox = null; "  +
				"  "  +
				"         proc insere(int v) { "  +
				"             { "  +
				"                 LValor aux = this; "  +
				"                 while ( not(aux.prox == null) ) do { "  +
				"                    aux := aux.prox "  +
				"                 }; "  +
				"                 aux.prox := new LValor; "  +
				"                 aux.valor := v "  +
				"             } "  +
				"         }, "  +
				"  "  +
				"         proc remove(int v) { "  +
				"             { "  +
				"  "  +
				"             LValor aux = this; "  +
				"             while( not( (aux.prox == null)  or (((aux).prox).valor == v) ) ) do { "  +
				"                 aux := aux.prox "  +
				"             }; "  +
				"             if ( not( aux.prox == null) ) then { "  +
				"                 aux.prox := ((aux).prox).prox "  +
				"             } "  +
				"  "  +
				"             } "  +
				"         }, "  +
				"  "  +
				"         proc print() { "  +
				"             write(this.valor); "  +
				"             if ( not( this.prox == null) ) then { "  +
				"                 (this).prox.print() "  +
				"             } "  +
				"         } "  +
				"     }; "  +
				"  "  +
				"     { "  +
				"         LValor lv := new LValor; "  +
				"         lv.insere(2); "  +
				"         lv.insere(3); "  +
				"         lv.insere(4); "  +
				"         lv.print(); "  +
				"         lv.remove(3); "  +
				"         lv.print() "  +
				"  } "  +
				" } "
				,"2 3 4 -100 2 4 -100 ", true, true, false });


		data.add(new Object[] {
				"    { "  +
				"       classe Contador { "  +
				"           int valor = 1; "  +
				"           proc print() { "  +
				"             write(this.valor) "  +
				"           } "  +
				"       }      "  +
				"       ; "  +
				"  "  +
				"       { "  +
				" 	int a = 2, "  +				
				" 	boolean ok = false "  +
				"         ; "  +			
				" 	read(a); "  +
				" 	read(ok); "  +				
				" 	write(\"O int lido foi: \"++a); "  +
				" 	write(\"O boolean lido foi: \"++ok) "  +
				"      } "  +
				"  "  +
				"    } "
				,"O int lido foi: 1 O boolean lido foi: true ", true, true, false });		

		return data;
	}

}
