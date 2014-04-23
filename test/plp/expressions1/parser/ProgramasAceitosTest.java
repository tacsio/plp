package plp.expressions1.parser;

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

import plp.expressions1.Programa;

@RunWith(Parameterized.class)
public class ProgramasAceitosTest {

	static Exp1Parser parser;
	String input;
	private String resultado;

	public ProgramasAceitosTest(String input, String resultado) {
		super();
		this.input = input;
		this.resultado = resultado;
	}

	@Before
	public void setup() {
		Exp1Parser.disable_tracing();
		ByteArrayInputStream bis = new ByteArrayInputStream(input.getBytes());
		if (parser == null)
			parser = new Exp1Parser(bis);
		else
			Exp1Parser.ReInit(bis);

	}

	@Test
	public void testInput() throws ParseException {

		Programa programa = Exp1Parser.Input();
		assertThat("Erro de Tipo no programa: \n" + input,
				programa.checaTipo(), is(true));
		assertThat("Resultado errado para a avaliação de:\n" + input, programa
				.executar().toString(), is(resultado));
	}

	@Parameters
	public static List<Object[]> data() {
		ArrayList<Object[]> data = new ArrayList<Object[]>();

		data.add(new Object[] { "6", "6" });
		data.add(new Object[] { "true", "true" });
		data.add(new Object[] { "length \"a\"", "1" });
		data.add(new Object[] { "\"a\"++\"a\"", "\"aa\"" });
		data.add(new Object[] { "1 + 1", "2" });
		data.add(new Object[] { "1 - 1", "0" });
		data.add(new Object[] { "1 == 1", "true" });
		data.add(new Object[] { "true or false", "true" });
		data.add(new Object[] { "true and false", "false" });

		return data;

	}
}
