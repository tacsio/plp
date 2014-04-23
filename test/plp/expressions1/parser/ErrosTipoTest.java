package plp.expressions1.parser;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import plp.expressions1.Programa;

@RunWith(Parameterized.class)
public class ErrosTipoTest extends ProgramasAceitosTest {

	public ErrosTipoTest(String input) {
		super(input, null);
	}

	@Override
	@Test
	public void testInput() throws ParseException {

		Programa programa = Exp1Parser.Input();
		assertThat("Erro de tipo não encontrado no programa:\n" + input,
				programa.checaTipo(), is(false));
	}

	@Parameters
	public static List<Object[]> data() {
		ArrayList<Object[]> data = new ArrayList<Object[]>();

		data.add(new Object[] { "length 1" });
		data.add(new Object[] { "1 ++ 1" });
		data.add(new Object[] { "1 == true" });
		data.add(new Object[] { "true == 1" });
		data.add(new Object[] { "1 + true" });
		data.add(new Object[] { "true + 1" });
		data.add(new Object[] { "1 and true" });
		data.add(new Object[] { "true and 1" });
		data.add(new Object[] { "1 or true" });
		data.add(new Object[] { "true or 1" });

		return data;

	}
}
