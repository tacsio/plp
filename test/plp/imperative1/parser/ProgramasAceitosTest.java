package plp.imperative1.parser;

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

import plp.expressions2.expression.ValorBooleano;
import plp.expressions2.expression.ValorInteiro;
import plp.imperative1.Programa;
import plp.imperative1.memory.AmbienteCompilacaoImperativa;
import plp.imperative1.memory.AmbienteExecucaoImperativa;
import plp.imperative1.memory.ContextoCompilacaoImperativa;
import plp.imperative1.memory.ContextoExecucaoImperativa;
import plp.imperative1.memory.ListaValor;

@RunWith(Parameterized.class)
public class ProgramasAceitosTest {

	static Imp1Parser parser;
	String input;
	private String saidaExperada;
	private ListaValor entrada;

	public ProgramasAceitosTest(String input, ListaValor entrada,
			String resultado) {
		super();
		this.input = input;
		this.saidaExperada = resultado;
		this.entrada = entrada;
	}

	@Before
	public void setup() {
		Imp1Parser.disable_tracing();
		ByteArrayInputStream bis = new ByteArrayInputStream(input.getBytes());
		if (parser == null)
			parser = new Imp1Parser(bis);
		else
			Imp1Parser.ReInit(bis);

	}

	@Test
	public void testInput() throws Exception {

		Programa programa = Imp1Parser.Input();

		AmbienteCompilacaoImperativa ambComp = new ContextoCompilacaoImperativa(
				entrada);
		assertThat("Erro de Tipo no programa: \n" + input, programa
				.checaTipo(ambComp), is(true));

		AmbienteExecucaoImperativa ambExec = new ContextoExecucaoImperativa(
				entrada);
		assertThat("Resultado errado para a avaliação de:\n" + input, programa
				.executar(ambExec).toString(), is(saidaExperada));
	}

	@Parameters
	public static List<Object[]> data() {
		ArrayList<Object[]> data = new ArrayList<Object[]>();
		String prog =

		"{\n" + " var a = 3, \n" + " var c = 0; \n" + " read(c);\n"
				+ " c := c +1; \n" + " write(a);\n" + " write(c);\n" + " {\n"
				+ "  var a = 2,\n" + "  var b = 5,\n" + "  var c = false,\n"
				+ "  var d = \"oi\";\n" + "  read(c);\n" + "  write(a);\n"
				+ "  write(b+a);\n" + "  write(c);\n" + "  write(d)\n" + "};\n"
				+ " write(a)\n" + "}";

		ValorInteiro UM = new ValorInteiro(1);
		ValorBooleano TRUE = new ValorBooleano(true);

		data.add(new Object[] { prog, new ListaValor(UM, new ListaValor(TRUE)),
				"3 2 2 7 true \"oi\" 3 " });

		return data;

	}
}
