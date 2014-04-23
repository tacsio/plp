package plp.functional3.parser;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import plp.functional3.Programa;

@RunWith(Parameterized.class)
public class ErrosTipoTest extends ProgramasAceitosTest {

	public ErrosTipoTest(String input) {
		super(input, null);
	}

	@Override
	@Test
	public void testInput() throws ParseException {
		Programa programa = Func3Parser.Input();
		assertThat("Erro de tipo não encontrado no programa:\n" + input,
				programa.checaTipo(), is(false));
	}

	@Parameters
	public static List<Object[]> data() {
		ArrayList<Object[]> data = new ArrayList<Object[]>();

		data.add(new Object[] { "1:[\"teste\"]" });
		data.add(new Object[] { "[1]^^[\"teste\"]" });
		data.add(new Object[] { "[2,1]==[true]" });
		data.add(new Object[] { "[2,true]" });
		data.add(new Object[] { "[x+1 for x in [true, false]]" });
		data.add(new Object[] { "[x for x in [1, 2] if x]" });
		data.add(new Object[] { "[x for x in [1, 2] if x]" });
		data
				.add(new Object[] { "[f(z) for f in [fn x . x + x] for z in [true]]" });
		data
				.add(new Object[] { "[f(z, z) for f in [fn x . x + x] for z in [1]]" });

		return data;

	}
}
