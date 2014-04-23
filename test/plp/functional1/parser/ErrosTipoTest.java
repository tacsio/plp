package plp.functional1.parser;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import plp.functional1.Programa;

@RunWith(Parameterized.class)
public class ErrosTipoTest extends ProgramasAceitosTest {

	public ErrosTipoTest(String input) {
		super(input, null);
	}

	@Override
	@Test
	public void testInput() throws ParseException {

		Programa programa = Func1Parser.Input();
		assertThat("Erro de tipo não encontrado no programa:\n" + input,
				programa.checaTipo(), is(false));
	}

	@Parameters
	public static List<Object[]> data() {
		ArrayList<Object[]> data = new ArrayList<Object[]>();

		data.add(new Object[] { "if true then 1 else false" });

		String prog = "let fun Id x = x in \n"
				+ "let fun sum x y = Id(x) + Id(y) in \n" + "sum(0,true)";
		data.add(new Object[] { prog });

		prog = "let fun Id x = x in \n" + "let fun sub x y = x - y in \n"
				+ "let fun sum x y = x + Id(y) in \n"
				+ "sum(sub(2,1), sub(true,3))";
		data.add(new Object[] { prog });

		return data;

	}
}
