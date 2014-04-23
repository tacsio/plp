package plp.functional3.parser;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import plp.functional3.Programa;

@RunWith(Parameterized.class)
public class ProgramasAceitosTest {
	
	static Func3Parser parser;
	String input;
	String resultado;
	
	public ProgramasAceitosTest(String input, String resultado) {
		super();
		this.input = input;
		this.resultado = resultado;
	}
	
	@Before
	public void setup() {
		Func3Parser.disable_tracing();
		ByteArrayInputStream bis = new ByteArrayInputStream(this.input.getBytes());
		if ( parser == null ) {
			parser = new Func3Parser(bis);
		}
		else {
			Func3Parser.ReInit(bis);
		}
	}
	
	@Test
	public void testInput() throws ParseException {
		ByteArrayInputStream bis = new ByteArrayInputStream(this.input.getBytes());
		if ( parser == null ) {
			parser = new Func3Parser(bis);
		}
		else {
			Func3Parser.ReInit(bis);
		}
		
		Programa programa = Func3Parser.Input();
		assertThat("Erro de Tipo no programa: \n" + this.input, programa.checaTipo(),
				is(true));
		assertThat("Resultado errado para a avaliação de:\n" + this.input, programa
				.executar().toString(), is(this.resultado));
	}
	
	@Parameters
	public static List<Object[]> data() {
		ArrayList<Object[]> data = new ArrayList<Object[]>();
		
		data.add(new Object[] { "1:[]", "[1]" });
		data.add(new Object[] { "[]^^[]", "[]" });
		data.add(new Object[] { "[2,1]^^[3,4]", "[2, 1, 3, 4]" });
		data.add(new Object[] { "[2,1]^^[3]^^[4]", "[2, 1, 3, 4]" });
		data.add(new Object[] { "[]==[]", "true" });
		data.add(new Object[] { "[2,1]==[2,1]", "true" });
		data.add(new Object[] { "[2]==[2]", "true" });
		data.add(new Object[] { "let var li = [2,1] in li==li", "true" });
		data.add(new Object[] { "let var li = [2,1] in (li^^[])==li", "true" });
		data.add(new Object[] { "([2,1]^^[3,4]) == [2, 1, 3, 4]", "true" });
		data.add(new Object[] { "tail [2]", "[]" });
		data.add(new Object[] { "tail [1,2]", "[2]" });
		data.add(new Object[] { "tail tail [1,2]", "[]" });
		data.add(new Object[] { "head [1,2]", "1" });
		data.add(new Object[] { "head [1]", "1" });
		data.add(new Object[] { "head 2:[1]", "2" });
		data.add(new Object[] { "let var l = [] in l==[]", "true" });
		data.add(new Object[] { "let var l = [2] in l==[1]", "false" });
		data.add(new Object[] { "[2,1] == [1,2]", "false" });
		String prog = "let fun conc xs ys = xs ^^ ys in conc([1],[2])";
		data.add(new Object[] { prog, "[1, 2]" });
		
		prog = "let fun lLength lista = if lista==[] then 0 else 1 + (lLength(tail lista))"
				+ "in lLength([])";
		data.add(new Object[] { prog, "0" });
		
		prog = "let fun lLength lista = if lista==[] then 0 else 1 + (lLength(tail lista))"
				+ "in lLength([true])";
		data.add(new Object[] { prog, "1" });
		
		prog = "let fun lLength lista = if lista==[] then 0 else 1 + (lLength(tail lista))"
				+ "in lLength([true,true, false])";
		data.add(new Object[] { prog, "3" });
		prog = "let fun id x = x, fun map op xxs = if (xxs==[])then [] \n"
				+ "else (let var x = head xxs, var xs = tail xxs in  op(x) : map(op, xs)) in \n"
				+ "map(id,[2,3])";
		data.add(new Object[] { prog, "[2, 3]" });
		
		prog = "let fun suc x = x+1, fun map op xxs = if (xxs==[])then [] \n"
				+ "else (let var x = head xxs, var xs = tail xxs in  op(x) : map(op, xs)) in \n"
				+ "map(suc,[2,3])";
		data.add(new Object[] { prog, "[3, 4]" });
		
		prog = "let fun lLength lista = if lista==[] then 0 else 1 + (lLength(tail lista)), \n"
				+ "fun map op xxs = if (xxs==[])then [] \n"
				+ "else (let var x = head xxs, var xs = tail xxs in  op(x) : map(op, xs)) in \n"
				+ "map(lLength,[[1],[],[1,2,4],[],[1,5,4,6,5,4]])";
		data.add(new Object[] { prog, "[1, 0, 3, 0, 6]" });
		
		prog = "let fun suc x = x+1, fun map op xxs = if (xxs==[])then [] \n"
				+ "else (let var x = head xxs, var xs = tail xxs in  op(x) : map(op, xs)) in \n"
				+ "map(suc,[0])";
		data.add(new Object[] { prog, "[1]" });
		
		prog = "let fun suc x = x+1, fun map op xs = if (xs==[])then [] \n"
				+ "else (let var x = head xs in  op(x) : map(op, tail xs)) in \n"
				+ "map(suc,[0])";
		data.add(new Object[] { prog, "[1]" });
		
		prog = "let fun soma x y = x+y, fun fold op a xxs = if (xxs==[])then a \n"
				+ "else (let var x = head xxs, var xs = tail xxs in  op(x, fold(op,a, xs))) in \n"
				+ "fold(soma, 0, [])";
		data.add(new Object[] { prog, "0" });
		
		prog = "let fun soma x y = x+y, fun fold op a xxs = if (xxs==[])then a \n"
				+ "else (let var x = head xxs, var xs = tail xxs in  op(x, fold(op,a, xs))) in \n"
				+ "fold(soma, 0, [10])";
		data.add(new Object[] { prog, "10" });
		
		prog = "let fun soma x y = x+y, fun fold op a xxs = if (xxs==[])then a \n"
				+ "else (let var x = head xxs, var xs = tail xxs in  op(x, fold(op,a, xs))) in \n"
				+ "fold(soma, 0, [2,3])";
		data.add(new Object[] { prog, "5" });
		
		prog = "let fun even x = if x == 0 then true else ( if x == 1 then false else even(x-2)) in even(5)";
		data.add(new Object[] { prog, "false" });
		prog = "let fun even x = if x == 0 then true else ( if x == 1 then false else even(x-2)) in even(50)";
		data.add(new Object[] { prog, "true" });
		
		prog = "let fun even x = if x == 0 then true else ( if x == 1 then false else even(x-2)) in "
				+ "let fun filter p xxs = \n"
				+ "if xxs == [] then [] else "
				+ "let var x = head xxs, var xs = tail xxs in"
				+ "(if p(x) "
				+ "then x : filter(p, xs) "
				+ "else filter(p,xs)) in "
				+ "filter(even,[] )";
		data.add(new Object[] { prog, "[]" });
		
		prog = "let fun even x = if x == 0 then true else ( if x == 1 then false else even(x-2)) in "
				+ "let fun filter p xxs = \n"
				+ "if xxs == [] then [] else "
				+ "let var x = head xxs, var xs = tail xxs in"
				+ "(if p(x) "
				+ "then x : filter(p, xs) "
				+ "else filter(p,xs)) in "
				+ "filter(even,[1,3,5] )";
		data.add(new Object[] { prog, "[]" });
		
		prog = "let fun even x = if x == 0 then true else ( if x == 1 then false else even(x-2)) in "
				+ "let fun filter p xxs = \n"
				+ "if xxs == [] then [] else "
				+ "let var x = head xxs, var xs = tail xxs in"
				+ "(if p(x) "
				+ "then x : filter(p, xs) "
				+ "else filter(p,xs)) in "
				+ "filter(even,[2] )";
		data.add(new Object[] { prog, "[2]" });
		
		prog = "let fun even x = if x == 0 then true else ( if x == 1 then false else even(x-2)) in "
				+ "let fun filter p xxs = \n"
				+ "if xxs == [] then [] else "
				+ "let var x = head xxs, var xs = tail xxs in"
				+ "(if p(x) "
				+ "then x : filter(p, xs) "
				+ "else filter(p,xs)) in "
				+ "filter(even,[1,2,3,4,5,6] )";
		data.add(new Object[] { prog, "[2, 4, 6]" });
		
		prog = "let fun even x = if x == 0 then true else ( if x == 1 then false else even(x-2)) in "
				+ "let fun odd x = not (even(x)) in "
				+ "let fun filter p xxs = \n"
				+ "if xxs == [] then [] else "
				+ "let var x = head xxs, var xs = tail xxs in"
				+ "(if p(x) "
				+ "then x : filter(p, xs) "
				+ "else filter(p,xs)) in "
				+ "filter(odd,[1,2,3,4,5,6] )";
		data.add(new Object[] { prog, "[1, 3, 5]" });
		
		prog = "head ([fn x . x] ) ";
		data.add(new Object[] { prog, "fn x . x" });
		
		prog = "(head([fn x . x]))(1) ";
		data.add(new Object[] { prog, "1" });
		
		prog = "let fun soma x = fn y . x + y in (head([soma(1)]))(1) ";
		data.add(new Object[] { prog, "2" });
		
		// fold de listas de funcoes funcoes
		
		prog = "let fun id x = x, fun suc x = x + 1,  "
				+ "fun pred x = x-1, fun comp f g = fn k . f(g(k)) in "
				+ "let fun fold op a xxs = if (xxs==[]) then a "
				+ "else (let var x = head xxs, var xs = tail xxs in "
				+ " op(x, fold(op,a, xs))) in " + "fold(comp, id, [])(2)";
		data.add(new Object[] { prog, "2" });
		
		prog = "let fun id x = x, fun suc x = x + 1,  "
				+ "fun pred x = x-1, fun comp f g = fn k . f(g(k)) in "
				+ "let fun fold op a xxs = if (xxs==[]) then a "
				+ "else (let var x = head xxs, var xs = tail xxs in "
				+ " op(x, fold(op,a, xs))) in " + "fold(comp, id, [suc, suc])(2)";
		data.add(new Object[] { prog, "4" });
		
		prog = "let fun fold op a xxs = if (xxs==[]) then a "
				+ "else (let var x = head xxs, var xs = tail xxs in "
				+ " op(x, (fold(op, a, xs)))) in "
				+ "let fun id x = x, fun suc x = x + 1,  "
				+ "fun pred x = x-1, fun comp f g = fn k . f(g(k)) in "
				+ "fold(comp, id,  [])";
		data.add(new Object[] { prog, "fn x . x" });
		
		prog = "let fun id x = x, fun suc x = x + 1,  "
				+ "fun pred x = x-1, fun comp f g = fn k . f(g(k)) in "
				+ "let fun fold op a xxs = if (xxs==[]) then a "
				+ "else (let var x = head xxs, var xs = tail xxs in "
				+ " (op(x, fold(op,a, xs)))) in " + "fold(comp, id, [suc])";
		data.add(new Object[] { prog, "fn k . fn x . x + 1(fn x . x(k))" });
		
		prog = "let fun quicksort op xs = if (xs ==[]) then [] " + " else "
				+ "(quicksort(op, [k for k in tail(xs) if op(k, head(xs))])) ^^ "
				+ "([head(xs)] ^^ "
				+ "(quicksort(op, [y for y in tail(xs) if (not op(y, head(xs)))]))) "
				+ "in let fun maiorQue x y = x > y in " + "quicksort(maiorQue, [])";
		data.add(new Object[] { prog, "[]" });
		
		prog = "let fun quicksort op xs = if (xs ==[]) then [] " + " else "
				+ "(quicksort(op, [k for k in tail(xs) if op(k, head(xs))])) ^^ "
				+ "([head(xs)] ^^ "
				+ "(quicksort(op, [y for y in tail(xs) if (not op(y, head(xs)))]))) "
				+ "in let fun maiorQue x y = x > y in " + "quicksort(maiorQue, [1])";
		data.add(new Object[] { prog, "[1]" });
		
		prog = "let fun quicksort op xs = if (xs ==[]) then [] " + " else "
				+ "(quicksort(op, [k for k in tail(xs) if op(k, head(xs))])) ^^ "
				+ "([head(xs)] ^^ "
				+ "(quicksort(op, [y for y in tail(xs) if (not op(y, head(xs)))]))) "
				+ "in let fun maiorQue x y = x > y in "
				+ "quicksort(maiorQue, [2,1,4,3])";
		data.add(new Object[] { prog, "[4, 3, 2, 1]" });
		
		// Compreenssão de listas //
		
		prog = "let fun quicksort [] = [] | quicksort x:xs = quicksort([k for k in xs if k < x]) "
				+ "^^ [x] "
				+ "^^ quicksort([k for k in xs if k > x]) "
				+ "in quicksort([3,1,7,4,8,0])";
		data.add(new Object[] { prog, "[0, 1, 3, 4, 7, 8]" });
		
		prog = "let fun tamanho [] = 0 " + "| tamanho x:xs = 1 + tamanho(xs) "
				+ "in tamanho([1,5,3,7])";
		data.add(new Object[] { prog, "4" });
		
		prog = "let fun positivo x = true, if x > 0 " + "| positivo x = false, if x < 0 "
				+ "in let fun filter f [] = [] "
				+ "| filter f x:xs = x : filter(f,xs), if f(x)"
				+ "| filter f x:xs = filter(f,xs), if not f(x) "
				+ "in filter(positivo, [1,2,-1,-2])";
		data.add(new Object[] { prog, "[1, 2]" });
		
		prog = "let fun max x y = x, if x > y " + "| max x y = y , if x < y "
				+ "in max(3,4)";
		data.add(new Object[] { prog, "4" });
		
		prog = "let fun fat n = let fun mult x y = if (x == 0) "
				+ "then (0) else (y + (mult ((x - 1),y ))) "
				+ "in if (n == 0) then (1) else mult(n, fat(n - 1)) " + "in fat(5)";
		data.add(new Object[] { prog, "120" });
		
		prog = "let fun add2 x = x + 2, "
				+ "fun map f [] = [] | map f x:xs = f(x) : map(f,xs) "
				+ "in map(add2, [1,2])";
		data.add(new Object[] { prog, "[3, 4]" });
		
		prog = "let fun add2 [] = [] " + "| add2 x:xs = (x+2) : add2(xs) "
				+ "in add2([1,2])";
		data.add(new Object[] { prog, "[3, 4]" });
		
		prog = "let var teste = fn 0 . 0 " + "| x . x + 1  in teste(2)";
		data.add(new Object[] { prog, "3" });
		
		prog = "let var prod = fn 0 y . 0" + " | x y . y + 1, if x > 0"
				+ " | x y . x + 1, if x < 0 " + " in prod ";
		data.add(new Object[] { prog,
				"fn 0 y . 0 | x y . y + 1, if x > 0 | x y . x + 1, if x < 0" });
		
		prog = "let fun maxSales x 0 = 10 | maxSales y 5 = 11, if y > 10 "
				+ "| maxSales z 5 = 12, if z < 10 " + "in maxSales(1, 5)";
		data.add(new Object[] { prog, "12" });
		
		prog = "let fun teste 0 10 = 5 " + "| teste x 15 = 12, "
				+ "if (let fun maiorQue x y = "
				+ "if x > y then true else false in maiorQue(4,5)) "
				+ "| teste y 15 = 20, " + "if y > 10 " + "in teste(14, 15)";
		data.add(new Object[] { prog, "20" });
		
		prog = "let fun id x = x " + "in let fun suc x = x + 1 "
				+ "in let fun foo 1 = id " + "| foo x = suc in foo(5)";
		data.add(new Object[] { prog, "fn x . x + 1" });
		
		prog = "let fun add 1 x = 1 + x  | add 2 y = 2 + y in add(2, 6)";
		data.add(new Object[] { prog, "8" });
		
		prog = "let fun add x y = x + y in add(5, 6)";
		data.add(new Object[] { prog, "11" });
		
		prog = "let var x = 10, " + "fun retorno x y = x + y, if x < y "
				+ "| retorno w z = w - z, if w > z " + "in retorno(6,5)";
		data.add(new Object[] { prog, "1" });
		
		prog = "let fun id x = x, fun add x = fn y . x + y in add(2)";
		data.add(new Object[] { prog, "fn y . 2 + y" });
		
		prog = "let fun id x = x, fun pred x = x -1, fun suc x = x + 1, "
				+ "fun comp f g = fn k . f(g(k)) in comp(pred, suc)";
		data.add(new Object[] { prog, "fn k . fn x . x - 1(fn x . x + 1(k))" });
		
		prog = "let fun somatorial 0 = 0 | somatorial x = x + somatorial(x-1) ";
		data.add(new Object[] { prog + "in somatorial(4)", "10" });
		
		prog = "let var id = fn x. x in id(4)";
		data.add(new Object[] { prog, "4" });
		
		data.add(new Object[] { "5*6", "30" });
		
		prog = "let fun maxSales 1 = 15 \n" + "| maxSales 2 = 18 \n"
				+ "| maxSales 3 = 12 \n" + "in maxSales(1)";
		data.add(new Object[] { prog, "15" });
		
		prog = "let fun maxSales 1 = 15 \n" + "| maxSales 2 = 18 \n"
				+ "| maxSales x = 12 \n" + "in maxSales(5)";
		data.add(new Object[] { prog, "12" });
		
		prog = "let fun add x y = x +y in add(1,9)";
		data.add(new Object[] { prog, "10" });
		
		prog = "let fun const 1 = 10 in const(1)";
		data.add(new Object[] { prog, "10" });
		
		prog = "let fun const 1 = 10 | const x = 5 in const(2)";
		data.add(new Object[] { prog, "5" });
		
		prog = "let fun fat 1 = 1 | fat x = x*fat(x-1) " + "in fat(1)";
		data.add(new Object[] { prog, "1" });
		
		prog = "let fun fat 1 = 1 | fat x = x*fat(x-1) " + "in fat(5)";
		data.add(new Object[] { prog, "120" });
		
		prog = "let fun somatorial 0 = 0 | somatorial x = x+ somatorial( x-1) "
				+ "in somatorial(1)";
		data.add(new Object[] { prog, "1" });
		
		return data;
		
	}
}
