package plp.functional3.expression;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import plp.expressions2.expression.Expressao;
import plp.expressions2.expression.Id;
import plp.expressions2.expression.ValorInteiro;
import plp.expressions2.memory.AmbienteExecucao;
import plp.functional1.memory.ContextoExecucaoFuncional;
import plp.functional3.util.Padrao;

public class PadraoTest {
	
	private AmbienteExecucao ambiente = new ContextoExecucaoFuncional();
	
	@Before
	public void initTest() {
		this.ambiente.incrementa();
	}
	
	@Test
	public void testMatchValorInteiro() throws Exception {
		ValorInteiro oneValue = new ValorInteiro(1);
		ValorInteiro fiveValue = new ValorInteiro(5);
		
		List<Expressao> listPadrao1 = new ArrayList<Expressao>();
		listPadrao1.add(oneValue);
		listPadrao1.add(fiveValue);
		
		List<Expressao> listPadrao2 = new ArrayList<Expressao>();
		listPadrao2.add(oneValue);
		listPadrao2.add(fiveValue);
		
		Padrao padrao2 = Padrao.createPadraoFrom(listPadrao2);
		
		Assert.assertEquals(true, padrao2.match(this.ambiente, listPadrao1));
	}
	
	@Test
	public void testMatchExpresoes() throws Exception {
		ValorInteiro oneValue = new ValorInteiro(1);
		ValorInteiro fiveValue = new ValorInteiro(5);
		
		List<Expressao> listPadrao1 = new ArrayList<Expressao>();
		listPadrao1.add(oneValue);
		listPadrao1.add(fiveValue);
		
		List<Expressao> listPadrao2 = new ArrayList<Expressao>();
		listPadrao2.add(oneValue);
		listPadrao2.add(fiveValue);
		
		Padrao padrao2 = Padrao.createPadraoFrom(listPadrao2);
		
		Assert.assertEquals(true, padrao2.match(this.ambiente, listPadrao1));
	}
	
	@Test
	public void testMatchVariables() {
		Id varId = new Id("x");
		ValorInteiro oneValue = new ValorInteiro(1);
		
		List<Expressao> listPadrao1 = new ArrayList<Expressao>();
		listPadrao1.add(oneValue);
		
		List<Expressao> listPadrao2 = new ArrayList<Expressao>();
		listPadrao2.add(varId);
		Padrao padrao2 = Padrao.createPadraoFrom(listPadrao2);
		
		Assert.assertEquals(true, padrao2.match(this.ambiente, listPadrao1));
	}
	
	// let var x = 5,
	// let fun add x = 1
	// in add(10)
	@Test
	public void testMatchDeclaredVariables() {
		Id varId = new Id("x");
		ValorInteiro varValue = new ValorInteiro(5);
		this.ambiente.map(varId, varValue);
		
		ValorInteiro tenValue = new ValorInteiro(10);
		
		List<Expressao> listPadrao1 = new ArrayList<Expressao>();
		listPadrao1.add(tenValue);
		
		List<Expressao> listPadrao2 = new ArrayList<Expressao>();
		listPadrao2.add(varId);
		Padrao padraoDeclaracao = Padrao.createPadraoFrom(listPadrao2);
		
		Assert.assertEquals(true, padraoDeclaracao.match(this.ambiente, listPadrao1));
	}
}
