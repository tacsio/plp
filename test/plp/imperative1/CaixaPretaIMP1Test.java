package plp.imperative1;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import plp.UtilCaixaPreta;
import plp.expressions2.expression.ValorBooleano;
import plp.expressions2.expression.ValorInteiro;
import plp.imperative1.memory.AmbienteCompilacaoImperativa;
import plp.imperative1.memory.AmbienteExecucaoImperativa;
import plp.imperative1.memory.ContextoCompilacaoImperativa;
import plp.imperative1.memory.ContextoExecucaoImperativa;
import plp.imperative1.memory.ListaValor;
import plp.imperative1.parser.Imp1Parser;


@RunWith(Parameterized.class)
public class CaixaPretaIMP1Test {

	static Imp1Parser parser;
	String input;
	private String resultado;
	private boolean aceitoTipo;
	private boolean aceitoValor;
	private boolean aceitoExcecao;	
	private ListaValor entrada;

	public CaixaPretaIMP1Test(String input, String resultado, boolean aceitoTipo, boolean aceitoValor
			, boolean aceitoExcecao) {
		super();
		this.input = input;
		this.resultado = resultado;
		this.aceitoTipo = aceitoTipo;
		this.aceitoValor = aceitoValor;
		this.aceitoExcecao = aceitoExcecao;		
		entrada = new ListaValor(new ValorInteiro(1), new ListaValor(new ValorBooleano(true)));
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

		try{
			AmbienteCompilacaoImperativa ambComp = new ContextoCompilacaoImperativa(
					entrada);
			Programa programa = Imp1Parser.Input();   
			boolean tipoOK = programa.checaTipo(ambComp);

			assertThat("Erro de Tipo no programa: \n" + input,
					tipoOK, is(this.aceitoTipo));

			if (tipoOK){
				AmbienteExecucaoImperativa ambExec = new ContextoExecucaoImperativa(
						entrada);
				String valor = programa.executar(ambExec).toString();
				boolean valorOK = valor.equalsIgnoreCase(resultado);                   
				assertThat("Resultado errado para a avaliação de:\n" + input, valorOK, is(this.aceitoValor));
			}           

			if  (this.aceitoExcecao){
				fail("Deveria lançar Excecao");               
			}

		}catch(Exception e){
			if  (!this.aceitoExcecao){
				System.out.println(input);
        		e.printStackTrace();         
            }   
		}

	}

	@Parameters
	public static List<Object[]> data() {
		ArrayList<Object[]> data = new ArrayList<Object[]>();		     
		//data.addAll(UtilCaixaPreta.getEntradaExp2Test());  
		data.addAll(UtilCaixaPreta.getEntradaImp1Test());  
		return data;
	}
	
}