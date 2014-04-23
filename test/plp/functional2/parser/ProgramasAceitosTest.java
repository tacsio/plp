package plp.functional2.parser;

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

import plp.functional2.Programa;

@RunWith(Parameterized.class)
public class ProgramasAceitosTest {

	static Func2Parser parser;
	String input;
	private String resultado;

	public ProgramasAceitosTest(String input, String resultado) {
		super();
		this.input = input;
		this.resultado = resultado;
	}

	@Before
	public void setup() {
		Func2Parser.disable_tracing();
		ByteArrayInputStream bis = new ByteArrayInputStream(input.getBytes());
		if (parser == null)
			parser = new Func2Parser(bis);
		else
			Func2Parser.ReInit(bis);

	}

	@Test
	public void testInput() throws ParseException {

		Programa programa = Func2Parser.Input();
		assertThat("Erro de Tipo no programa: \n" + input,
				programa.checaTipo(), is(true));
		assertThat("Resultado errado para a avaliação de:\n" + input, programa
				.executar().toString(), is(resultado));
	}

	@Parameters
	public static List<Object[]> data() {
		ArrayList<Object[]> data = new ArrayList<Object[]>();
		String prog = "let fun add x = fn y . x + y in \n"
				+ "let var id = add(0), var x = 4 in \n" + "id(1) + x";
		data.add(new Object[] { prog, "5" });

		prog = "let var id = fn x . x in id";
		data.add(new Object[] { prog, "fn x . x" });

		prog = "let var suc = fn x . x+1, \n" + "var pred = fn  x . x-1, \n"
				+ "var id = fn x . x in \n" + "suc(pred(2)) == (id(2))";
		data.add(new Object[] { prog, "true" });

		prog = "let fun pred x = x -1, fun suc x = x + 1 in \n"
				+ "let  fun comp f g  = fn k . f(g(k)) in \n"
				+ " (comp(pred,suc))(1)";
		data.add(new Object[] { prog, "1" });

		prog = "let fun pred x = x -1, fun suc x = x + 1 in \n"
				+ "let  fun comp f g k = f(g(k)) in \n" + " comp(pred,suc,1)";
		data.add(new Object[] { prog, "1" });

		prog = "let fun pred x = x - 1 in \n"
				+ "let  fun comp f = fn k. f(k) in \n" + " comp(pred)(1)";
		data.add(new Object[] { prog, "0" });

		prog = "let fun pred x = x - 1 in \n"
				+ "let  fun comp f = fn k . f(k) in \n" + " comp(pred)";
		data.add(new Object[] { prog, "fn k . fn x . x - 1(k)" });

		prog = "let var suc = fn x . x+1, \n" + "var pred = fn  x . x-1, \n"
				+ "var id = fn x . x in \n" + "suc(pred(2)) == id(2)";
		data.add(new Object[] { prog, "true" });
		prog = "let fun id x = x in id";
		data.add(new Object[] { prog, "fn x . x" });
		return data;

	}
}
