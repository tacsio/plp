package plp.functional3.parser;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import plp.functional3.Programa;

@RunWith(Parameterized.class)
public class ProgramasAceitosCompreensaoListaTest extends ProgramasAceitosTest {
	
	public ProgramasAceitosCompreensaoListaTest(String input, String resultado) {
		super(input, resultado);
	}
	
	@Override
	@Test
	public void testInput() throws ParseException {
		ByteArrayInputStream bis = new ByteArrayInputStream(this.input.getBytes());
		if ( parser == null ) {
			parser = new Func3Parser(bis);
		}
		else {
			Func3Parser.ReInit(bis);
		}
		
		Programa programa = Func3Parser.Input();
		assertThat("Erro de Tipo no programa: \n" + this.input, programa.checaTipo(),
				is(true));
		assertThat("Resultado errado para a avaliação de:\n" + this.input, programa
				.executar().toString(), is(this.resultado));
	}
	
	@Parameters
	public static List<Object[]> data() {
		ArrayList<Object[]> data = new ArrayList<Object[]>();
		
		String prog = "1..1";
		data.add(new Object[] { prog, "[1]" });
		
		prog = "1..2";
		data.add(new Object[] { prog, "[1, 2]" });
		
		prog = "3..1";
		data.add(new Object[] { prog, "[3, 2, 1]" });
		
		prog = "[x+1 for x in 3..1 ]";
		data.add(new Object[] { prog, "[4, 3, 2]" });
		
		prog = "[x+1 for x in 3..1 if x==1 ]";
		data.add(new Object[] { prog, "[2]" });
		
		prog = "let var y = 2 in [x+y for x in 3..1]";
		data.add(new Object[] { prog, "[5, 4, 3]" });
		
		prog = "[x for x in [true, false] if x]";
		data.add(new Object[] { prog, "[true]" });
		
		prog = "[[x, y] for x in 0..2, for y in 3..5 if x + y == 5]";
		data.add(new Object[] { prog, "[[0, 5], [1, 4], [2, 3]]" });
		
		prog = "[[x, y, z] for x in 1..3, for y in 1..3 for z in 1..3 if x + y == z]";
		data.add(new Object[] { prog, "[[1, 1, 2], [1, 2, 3], [2, 1, 3]]" });
		
		prog = "let fun id x = x in [ f(x) for x in 1..3, for f in [id]]";
		data.add(new Object[] { prog, "[1, 2, 3]" });
		
		prog = "let fun pred x = x-1, fun suc x =  x+1 in [ g(f(x)) for x in 1..3, for f in [pred] for g in [suc]]";
		data.add(new Object[] { prog, "[1, 2, 3]" });
		
		prog = "let fun pred x = x-1, fun suc x = x+1 in [ f for f in [pred, suc, fn x . x + x ]]";
		data.add(new Object[] { prog, "[fn x . x - 1, fn x . x + 1, fn x . x + x]" });
		
		return data;
		
	}
}
