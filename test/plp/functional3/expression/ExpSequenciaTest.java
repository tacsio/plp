package plp.functional3.expression;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import plp.expressions2.expression.Valor;
import plp.expressions2.expression.ValorBooleano;
import plp.expressions2.expression.ValorInteiro;
import plp.expressions2.memory.AmbienteCompilacao;
import plp.expressions2.memory.AmbienteExecucao;
import plp.expressions2.memory.ContextoCompilacao;
import plp.expressions2.memory.ContextoExecucao;

public class ExpSequenciaTest {

	private static final ValorInteiro MENOS_TRES = new ValorInteiro(-3);
	private static final ValorInteiro MENOS_DOIS = new ValorInteiro(-2);
	private static final ValorInteiro MENOS_UM = new ValorInteiro(-1);
	private static final ValorInteiro ZERO = new ValorInteiro(0);
	private static final ValorInteiro UM = new ValorInteiro(1);
	private static final ValorInteiro DOIS = new ValorInteiro(2);
	private static final ValorInteiro TRES = new ValorInteiro(3);

	private static final ValorBooleano TRUE = new ValorBooleano(true);

	AmbienteCompilacao ambCompilacao = new ContextoCompilacao();
	AmbienteExecucao ambExecucao = new ContextoExecucao();

	@Test
	public void verify_checaTipo() {
		assertThat(new ExpSequencia(UM, UM).checaTipo(ambCompilacao), is(true));
		assertThat(new ExpSequencia(TRUE, UM).checaTipo(ambCompilacao),
				is(false));
		assertThat(new ExpSequencia(TRUE, TRUE).checaTipo(ambCompilacao),
				is(false));

	}

	@Test
	public void verify_avaliar() {
		ExpSequencia expSequencia = new ExpSequencia(UM, UM);
		ValorLista lista = ValorLista.getInstancia(UM, null);
		assertThat(expSequencia.avaliar(ambExecucao), is((Valor) lista));

		ExpSequencia expSequencia2 = new ExpSequencia(UM, TRES);
		ValorLista lista2 = ValorLista.getInstancia(TRES, null).cons(DOIS)
				.cons(UM);
		assertThat(expSequencia2.avaliar(ambExecucao), is((Valor) lista2));

		ExpSequencia expSequencia3 = new ExpSequencia(TRES, ZERO);
		ValorLista lista3 = ValorLista.getInstancia(ZERO, null).cons(UM).cons(
				DOIS).cons(TRES);
		assertThat(expSequencia3.avaliar(ambExecucao), is((Valor) lista3));

		ExpSequencia expSequencia4 = new ExpSequencia(MENOS_UM, TRES);
		ValorLista lista4 = ValorLista.getInstancia(TRES, null).cons(DOIS)
				.cons(UM).cons(ZERO).cons(MENOS_UM);
		assertThat(expSequencia4.avaliar(ambExecucao), is((Valor) lista4));

		ExpSequencia expSequencia5 = new ExpSequencia(MENOS_TRES, MENOS_UM);
		ValorLista lista5 = ValorLista.getInstancia(MENOS_UM, null).cons(
				MENOS_DOIS).cons(MENOS_TRES);
		assertThat(expSequencia5.avaliar(ambExecucao), is((Valor) lista5));

	}

	@Test
	public void verify_toString() {
		ExpSequencia expSequencia = new ExpSequencia(UM, UM);
		assertThat(expSequencia.toString(), is("[1 .. 1]"));

	}
}
