package plp.functional3.expression;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import plp.expressions2.expression.ExpEquals;
import plp.expressions2.expression.ExpLength;
import plp.expressions2.expression.ExpSoma;
import plp.expressions2.expression.Expressao;
import plp.expressions2.expression.Id;
import plp.expressions2.expression.ValorBooleano;
import plp.expressions2.expression.ValorInteiro;
import plp.expressions2.expression.ValorString;
import plp.functional3.Programa;

public class GeradorTest {

	Id x = new Id("x");
	Id y = new Id("y");
	Id z = new Id("z");
	private static final ValorInteiro ZERO = new ValorInteiro(0);
	private static final ValorInteiro UM = new ValorInteiro(1);
	private static final ValorInteiro DOIS = new ValorInteiro(2);
	private static final ValorInteiro TRES = new ValorInteiro(3);
	private static final ValorInteiro QUATRO = new ValorInteiro(4);
	private static final ValorInteiro CINCO = new ValorInteiro(5);
	private static final ValorInteiro DEZ = new ValorInteiro(10);

	@Test
	public void geradorSimpleTest() {
		// Avaliar [x + 1 for x in [0..4]]

		Expressao expressao = new ExpSoma(x, UM);
		ExpCompreensaoLista compreensao = new ExpCompreensaoLista(expressao);
		compreensao.add(new Gerador(x, new ExpSequencia(ZERO, QUATRO)));
		Programa prg = new Programa(compreensao);
		assertThat(prg.checaTipo(), is(true));
		assertThat(prg.executar().toString(), is("[1, 2, 3, 4, 5]"));
	}

	@Test
	public void geradorReversoSimpleTest() {
		// Avaliar [x + 1 for x in [4..0]]

		Expressao expressao = new ExpSoma(x, UM);
		ExpCompreensaoLista compreensao = new ExpCompreensaoLista(expressao);
		compreensao.add(new Gerador(x, new ExpSequencia(QUATRO, ZERO)));
		Programa prg = new Programa(compreensao);
		assertThat(prg.checaTipo(), is(true));
		assertThat(prg.executar().toString(), is("[5, 4, 3, 2, 1]"));
	}

	@Test
	public void geradorRangeUnitarioTest() {
		// Avaliar [x + 1 for x in [0..0]]

		Expressao expressao = new ExpSoma(x, UM);
		ExpCompreensaoLista compreensao = new ExpCompreensaoLista(expressao);
		ValorLista lista = ValorLista.getInstancia(ZERO, null);
		compreensao.add(new Gerador(x, lista));
		Programa prg = new Programa(compreensao);
		assertThat(prg.checaTipo(), is(true));
		assertThat(prg.executar().toString(), is("[1]"));
	}

	@Test
	public void geradorConstante() {
		// Avaliar ["a" for x in [0..5]]

		ExpCompreensaoLista compreensao = new ExpCompreensaoLista(
				new ValorString("a"));
		compreensao.add(new Gerador(x, new ExpSequencia(ZERO, DOIS)));
		Programa prg = new Programa(compreensao);
		assertThat(prg.checaTipo(), is(true));
		assertThat(prg.executar().toString(), is("[\"a\", \"a\", \"a\"]"));
	}

	@Test
	public void geradorComplexo() {
		// Avaliar [length (x) for x in ["a", "aaa", ""]]

		ExpCompreensaoLista compreensao = new ExpCompreensaoLista(
				new ExpLength(x));
		ValorLista lista = ValorLista.getInstancia(new ValorString(""), null)
				.cons(new ValorString("aaa")).cons(new ValorString("a"));

		compreensao.add(new Gerador(x, lista));
		Programa prg = new Programa(compreensao);
		assertThat(prg.checaTipo(), is(true));
		assertThat(prg.executar().toString(), is("[1, 3, 0]"));
	}

	@Test
	public void geradorListaVazia() {
		// Avaliar [x + 1 for x in []]

		Expressao expressao = new ExpSoma(x, UM);
		ExpCompreensaoLista compreensao = new ExpCompreensaoLista(expressao);
		ValorLista lista = ValorLista.getInstancia(null, null);
		compreensao.add(new Gerador(x, lista));
		Programa prg = new Programa(compreensao);
		assertThat(prg.checaTipo(), is(true));
		assertThat(prg.executar().toString(), is("[]"));
	}

	@Test
	public void geradorFiltroFalse() {
		// Avaliar [x + 1 for x in [1..10] if false]
		Expressao expressao = new ExpSoma(x, UM);
		ExpCompreensaoLista compreensao = new ExpCompreensaoLista(expressao);
		compreensao.add(new Gerador(x, new ExpSequencia(ZERO, DEZ)));
		compreensao.setFiltro(new ValorBooleano(false));
		Programa prg = new Programa(compreensao);
		assertThat(prg.checaTipo(), is(true));
		assertThat(prg.executar().toString(), is("[]"));
	}

	@Test
	public void geradorMultiploTest_Subconjuntos() {
		// Avaliar [x + y for x in [0..3], for y in [0..3]]

		Expressao expressao = new ExpSoma(x, y);
		ExpCompreensaoLista compreensao = new ExpCompreensaoLista(expressao);

		ValorLista listaX = ValorLista.getInstancia(TRES, null).cons(DOIS)
				.cons(UM);
		ValorLista listaY = ValorLista.getInstancia(TRES, null).cons(DOIS)
				.cons(UM);

		compreensao.add(new Gerador(x, listaX));
		compreensao.add(new Gerador(y, listaY));
		Programa prg = new Programa(compreensao);
		assertThat(prg.checaTipo(), is(true));
		assertThat(prg.executar().toString(), is("[2, 3, 4, 3, 4, 5, 4, 5, 6]"));
	}

	@Test
	public void geradorComFiltroTest() {
		// Avaliar [[x, y] for x in [0..2], for y in [3..5], if x + y < 5]

		ExpSoma soma = new ExpSoma(x, y);
		Expressao expressao = ValorLista.getInstancia(x, ValorLista
				.getInstancia(y, null));
		Expressao filtro = new ExpMenorQue(soma, CINCO);
		ExpCompreensaoLista compreensao = new ExpCompreensaoLista(expressao);
		compreensao.add(new Gerador(x, new ExpSequencia(ZERO, DOIS)));
		compreensao.add(new Gerador(y, new ExpSequencia(TRES, CINCO)));
		compreensao.setFiltro(filtro);

		Programa prg = new Programa(compreensao);
		assertThat(prg.checaTipo(), is(true));
		assertThat(prg.executar().toString(), is("[[0, 3], [0, 4], [1, 3]]"));
	}

	@Test
	public void geradorComplexoTest() {
		// Avaliar [ x:y:z:[] for x in [1..10], for y in [1..10], for z in [1..10], if x*x + y*y == z*z]

		ExpCons consZ = new ExpCons(z, ValorLista.getInstancia(null, null));
		ExpCons consY = new ExpCons(y, consZ);
		ExpCons consX = new ExpCons(x, consY);

		ExpSoma somaQuadrados = new ExpSoma(new ExpMult(x, x),
				new ExpMult(y, y));
		Expressao filtro = new ExpEquals(somaQuadrados, new ExpMult(z, z));
		ExpCompreensaoLista compreensao = new ExpCompreensaoLista(consX);
		compreensao.add(new Gerador(x, new ExpSequencia(UM, DEZ)));
		compreensao.add(new Gerador(y, new ExpSequencia(UM, DEZ)));
		compreensao.add(new Gerador(z, new ExpSequencia(UM, DEZ)));
		compreensao.setFiltro(filtro);

		Programa prg = new Programa(compreensao);
		assertThat(prg.checaTipo(), is(true));
		assertThat(prg.executar().toString(),
				is("[[3, 4, 5], [4, 3, 5], [6, 8, 10], [8, 6, 10]]"));
	}
}
