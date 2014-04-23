package plp.functional1.parser;

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

import plp.functional1.Programa;

@RunWith(Parameterized.class)
public class ProgramasAceitosTest {

	static Func1Parser parser;
	String input;
	private String resultado;

	public ProgramasAceitosTest(String input, String resultado) {
		super();
		this.input = input;
		this.resultado = resultado;
	}

	@Before
	public void setup() {
		Func1Parser.disable_tracing();
		ByteArrayInputStream bis = new ByteArrayInputStream(input.getBytes());
		if (parser == null)
			parser = new Func1Parser(bis);
		else
			Func1Parser.ReInit(bis);

	}

	@Test
	public void testInput() throws ParseException {

		Programa programa = Func1Parser.Input();
		assertThat("Erro de Tipo no programa: \n" + input,
				programa.checaTipo(), is(true));
		assertThat("Resultado errado para a avaliação de:\n" + input, programa
				.executar().toString(), is(resultado));
	}

	@Parameters
	public static List<Object[]> data() {
		ArrayList<Object[]> data = new ArrayList<Object[]>();
		String prog = "let var x = 3 in \n" + "let fun n y = y + x in \n"
				+ "let var x = 5 in \n" + "n (1)";

		data.add(new Object[] { prog, "6" });

		prog = "let fun fat n = \n" + "let fun mult x y = if (x == 0) "
				+ "then (0) " + "else (y + (mult ((x - 1),y ))) in \n"
				+ "if (n == 0) then (1) " + "else mult( n, fat(n - 1))  in\n"
				+ "fat(5)";

		data.add(new Object[] { prog, "120" });

		prog = "let fun mult x y = if (x == 0) then (0) "
				+ "else (y + mult((x - 1), y)) in mult(4,7)";

		data.add(new Object[] { prog, "28" });

		prog = "let fun suc x = x+1, fun pred x = x-1, fun id x =  x in \n"
				+ "suc(pred(2)) == id(2)";
		data.add(new Object[] { prog, "true" });

		prog = "let fun Id x = x in \n"
				+ "let fun sum x y = Id(x) + Id(y) in \n" + " sum(10,1)";
		data.add(new Object[] { prog, "11" });

		prog = "let fun Id x = x in \n" + "let fun comp x y = x == y in \n"
				+ "comp(false,true)";
		data.add(new Object[] { prog, "false" });

		prog = "let fun Id x = x in \n"
				+ "let fun sum x y = if (Id(true)) then x + Id(y) else 1 in \n"
				+ "sum(0,1)";
		data.add(new Object[] { prog, "1" });

		return data;

	}
}
