package plp.expressions1;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import plp.expressions1.expression.ExpAnd;
import plp.expressions1.expression.ExpConcat;
import plp.expressions1.expression.ExpEquals;
import plp.expressions1.expression.ExpLength;
import plp.expressions1.expression.ExpMenos;
import plp.expressions1.expression.ExpNot;
import plp.expressions1.expression.ExpOr;
import plp.expressions1.expression.ExpSoma;
import plp.expressions1.expression.ExpSub;
import plp.expressions1.expression.ValorBooleano;
import plp.expressions1.expression.ValorInteiro;
import plp.expressions1.expression.ValorString;

public class ExemplosTest {

	private static final ValorInteiro DEZ = new ValorInteiro(10);
	private static final ValorInteiro QUATRO = new ValorInteiro(4);
	private static final ValorInteiro TRES = new ValorInteiro(3);
	private static final ValorInteiro UM = new ValorInteiro(1);
	private static final ValorBooleano FALSE = new ValorBooleano(false);
	private static final ValorBooleano TRUE = new ValorBooleano(true);
	private Programa prg;

	@Test
	public void avaliaSomaNegativo() {

		// Avalia -4 + 10 - 3
		prg = new Programa(new ExpSub(new ExpSoma(new ExpMenos(QUATRO), DEZ),
				TRES));
		assertThat(prg.checaTipo(), is(true));
		assertThat(prg.executar().toString(), is("3"));
	}

	@Test
	public void avaliaNOT_AND_OR() {
		// Avalia not ( (T and F) or (T and T) )
		prg = new Programa(new ExpNot(new ExpOr(new ExpAnd(TRUE, FALSE),
				new ExpAnd(TRUE, TRUE))));

		assertThat(prg.checaTipo(), is(true));
		assertThat(prg.executar().toString(), is("false"));
	}

	@Test
	public void avaliaStringConcat_LEngth() {

		// Avalia length("Hello" ++ " world" ++ "!");
		prg = new Programa(new ExpLength(new ExpConcat(
				new ValorString("Hello"), new ExpConcat(new ValorString(
						" world"), new ValorString("!")))));
		assertThat(prg.checaTipo(), is(true));
		assertThat(prg.executar().toString(), is("12"));
	}

	@Test
	public void avaliaLength_equals() {
		// Avalia length("forro") == 5
		prg = new Programa(new ExpEquals(
				new ExpLength(new ValorString("forro")), new ValorInteiro(5)));

		assertThat(prg.checaTipo(), is(true));
		assertThat(prg.executar().toString(), is("true"));
	}

	@Test
	public void avaliaConcat_Equals() {
		// Avalia "hello" + " world" == "hello world"
		prg = new Programa(new ExpEquals(new ExpConcat(
				new ValorString("hello"), new ValorString(" world")),
				new ValorString("hello world")));

		assertThat(prg.checaTipo(), is(true));
		assertThat(prg.executar().toString(), is("true"));
	}

	@Test()
	public void avaliaErroTipo() {
		// Avalia not T == F and 1
		prg = new Programa(new ExpEquals(new ExpNot(TRUE),
				new ExpAnd(FALSE, UM)));
		assertThat(prg.checaTipo(), is(false));
	}
}
