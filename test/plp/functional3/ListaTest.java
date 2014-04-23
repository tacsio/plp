package plp.functional3;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import plp.expressions2.expression.ExpEquals;
import plp.expressions2.expression.ValorBooleano;
import plp.expressions2.expression.ValorInteiro;
import plp.expressions2.expression.ValorString;
import plp.functional3.expression.ExpConcatLista;
import plp.functional3.expression.ExpCons;
import plp.functional3.expression.ExpHead;
import plp.functional3.expression.ExpTail;
import plp.functional3.expression.ValorLista;
import plp.functional3.util.ListaVaziaException;

public class ListaTest {

	private static final ValorInteiro QUATRO = new ValorInteiro(4);
	private static final ValorInteiro TRES = new ValorInteiro(3);
	private static final ValorInteiro DOIS = new ValorInteiro(2);
	private static final ValorInteiro UM = new ValorInteiro(1);
	private static final ValorBooleano TRUE = new ValorBooleano(true);

	@Test
	public void consSimpleTest() {
		// Avaliar 1:[]

		ValorLista lista = ValorLista.getInstancia(null, null);
		ExpCons cons = new ExpCons(UM, lista);
		Programa prg = new Programa(cons);
		assertThat(prg.checaTipo(), is(true));
		assertThat(prg.executar().toString(), is("[1]"));
	}

	@Test
	public void concatSimpleTest() {
		/*
		 * Avaliar []^^[]
		 */
		ValorLista lista1 = ValorLista.getInstancia(null, null);
		ValorLista lista2 = ValorLista.getInstancia(null, null);
		ExpConcatLista concat = new ExpConcatLista(lista1, lista2);
		Programa prg = new Programa(concat);
		assertThat(prg.checaTipo(), is(true));
		assertThat(prg.executar().toString(), is("[]"));
	}

	@Test
	public void concatComplexTest() {
		/*
		 * Avaliar [2,1]^^[3,4]
		 */
		ValorLista lista1 = ValorLista.getInstancia(DOIS, ValorLista
				.getInstancia(UM, null));
		ValorLista lista2 = ValorLista.getInstancia(TRES, ValorLista
				.getInstancia(QUATRO, null));
		ExpConcatLista concat = new ExpConcatLista(lista1, lista2);
		Programa prg = new Programa(concat);
		assertThat(prg.checaTipo(), is(true));
		assertThat(prg.executar().toString(), is("[2, 1, 3, 4]"));
	}

	@Test
	public void equalsLista() {
		/*
		 * Avaliar [2,1]==[2,1]
		 */
		ValorLista lista1 = ValorLista.getInstancia(new ValorInteiro(2), null);
		lista1.cons(new ValorInteiro(1));
		lista1.inverter();

		ValorLista lista2 = ValorLista.getInstancia(new ValorInteiro(2), null);
		lista2.cons(new ValorInteiro(1));
		lista2.inverter();

		ExpEquals equals = new ExpEquals(lista1, lista2);
		Programa prg = new Programa(equals);
		assertThat(prg.checaTipo(), is(true));
		assertThat(prg.executar().toString(), is("true"));
	}

	@Test
	public void equalsListaVazia() {
		/*
		 * Avaliar []==[]
		 */
		ValorLista lista1 = ValorLista.getInstancia(null, null);
		ValorLista lista2 = ValorLista.getInstancia(null, null);
		ExpEquals concat = new ExpEquals(lista1, lista2);
		Programa prg = new Programa(concat);
		assertThat(prg.checaTipo(), is(true));
		assertThat(prg.executar().toString(), is("true"));
	}

	@Test
	public void equalsListaErroTipo() {
		/*
		 * Avaliar [2,1]==[TRUE]
		 */
		ValorLista lista1 = ValorLista.getInstancia(DOIS, ValorLista
				.getInstancia(UM, null));
		ValorLista lista2 = ValorLista.getInstancia(TRUE, null);
		ExpEquals concat = new ExpEquals(lista1, lista2);
		Programa prg = new Programa(concat);
		assertThat(prg.checaTipo(), is(false));
	}

	@Test
	public void headSimpleTest() {
		ValorLista lista = ValorLista.getInstancia(DOIS, null);
		ValorLista lista2 = ValorLista.getInstancia(UM, lista);
		ExpHead head = new ExpHead(lista2);
		Programa prg = new Programa(head);
		assertThat(prg.checaTipo(), is(true));
		assertThat(prg.executar().toString(), is("1"));
	}

	@Test(expected = ListaVaziaException.class)
	public void headEmptyTest() {
		/*
		 * Avaliar tail([])
		 */
		ValorLista lista = ValorLista.getInstancia(null, null);
		ExpHead head = new ExpHead(lista);
		Programa prg = new Programa(head);
		assertThat(prg.checaTipo(), is(true));

		prg.executar();
	}

	@Test
	public void tailSimpleTest() {
		/*
		 * Avaliar tail [1,2]
		 */
		ValorLista lista = ValorLista.getInstancia(DOIS, null);
		ValorLista lista2 = ValorLista.getInstancia(UM, lista);
		ExpTail tail = new ExpTail(lista2);
		Programa prg = new Programa(tail);
		assertThat(prg.checaTipo(), is(true));
		assertThat(prg.executar().toString(), is("[2]"));
	}

	@Test(expected = ListaVaziaException.class)
	public void tailEmptyTest() {
		/*
		 * Avaliar tail([])
		 */
		ValorLista lista = ValorLista.getInstancia(null, null);
		ExpTail tail = new ExpTail(lista);
		Programa prg = new Programa(tail);
		assertThat(prg.checaTipo(), is(true));

		prg.executar();
	}

	@Test
	public void concatErrorTest() {
		// [1]^^["teste"] - erro de tipo
		ValorString str1 = new ValorString("teste");
		ValorLista lista1 = ValorLista.getInstancia(UM, null);
		ValorLista lista2 = ValorLista.getInstancia(str1, null);
		ExpConcatLista concat = new ExpConcatLista(lista1, lista2);
		Programa prg = new Programa(concat);
		assertThat(prg.checaTipo(), is(false));

	}

	@Test
	public void consErrorTest() {

		// 1:["teste"] - erro de tipo
		ValorString str1 = new ValorString("teste");
		ValorLista lista = ValorLista.getInstancia(str1, null);
		ExpCons cons = new ExpCons(UM, lista);
		Programa prg = new Programa(cons);
		assertThat(prg.checaTipo(), is(false));
	}

	@Test
	public void fold() {
		//		let fun fold op a lista = if (lista==[]) then a
		//		else op(head lista, fold(op, a, tail lista), 
		//		fun soma x y = x+y 
		//		in fold(soma, 0, [2]) 

		//		assertThat(prg.checaTipo(), is(true));
		//		assertThat(prg.executar().toString(), is("2"));
	}

}
