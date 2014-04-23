package plp.functional3.expression;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import plp.expressions2.expression.ExpSoma;
import plp.expressions2.expression.Expressao;
import plp.expressions2.expression.Id;
import plp.expressions2.expression.ValorInteiro;
import plp.expressions2.memory.AmbienteCompilacao;
import plp.expressions2.memory.ContextoCompilacao;
import plp.functional1.declaration.DeclaracaoFuncional;
import plp.functional3.Programa;
import plp.functional3.declaration.DecFuncao;
import plp.functional3.declaration.DecPadrao;
import plp.functional3.exception.FuncaoNomeDiferenteException;
import plp.functional3.exception.NumeroParametrosException;

public class AplicacaoTest {
	
	private AmbienteCompilacao ambienteCompilacao = new ContextoCompilacao();
	
	/*
	 * Teste de Checar Tipo
	 */

	// let fun add x y = x + y
	// in add(4, 5)
	@Test
	public void testChecarTipoAvaliarDefault() throws Exception {
		this.ambienteCompilacao.incrementa();
		
		Id idFuncao = new Id("add");
		Id xVar = new Id("x");
		Id yVar = new Id("y");
		
		// padrao add x y = x + y
		List<Expressao> listaPadrao = new ArrayList<Expressao>();
		listaPadrao.add(xVar);
		listaPadrao.add(yVar);
		
		ExpSoma soma = new ExpSoma(xVar, yVar);
		DecPadrao decPadrao = new DecPadrao(idFuncao, listaPadrao, soma);
		
		List<DecPadrao> declaracoesPadrao = new ArrayList<DecPadrao>();
		declaracoesPadrao.add(decPadrao);
		
		DecFuncao declaracaoFuncao = new DecFuncao(declaracoesPadrao);
		
		List<DeclaracaoFuncional> listaDecFuncional = new ArrayList<DeclaracaoFuncional>();
		listaDecFuncional.add(declaracaoFuncao);
		
		List<Expressao> listaPadraoAplicacao = new ArrayList<Expressao>();
		listaPadraoAplicacao.add(new ValorInteiro(4));
		listaPadraoAplicacao.add(new ValorInteiro(5));
		Aplicacao aplicacao = new Aplicacao(idFuncao, listaPadraoAplicacao);
		
		ExpDeclaracao expDeclaracao = new ExpDeclaracao(listaDecFuncional, aplicacao);
		Programa programa = new Programa(expDeclaracao);
		
		Assert.assertTrue(programa.checaTipo());
	}
	
	// let fun maxSales 1 x = 15
	// | maxSales 2 y = 18
	// | maxSales 3 z = 12
	// in maxSales(20)
	@Test
	public void testChecarTipoErroQtdParametrosFuncao3() throws Exception {
		this.ambienteCompilacao.incrementa();
		Id idFuncao = new Id("maxSales");
		
		// padrao maxSales 1 = 15
		List<Expressao> listaPadrao1 = new ArrayList<Expressao>();
		listaPadrao1.add(new ValorInteiro(1));
		listaPadrao1.add(new Id("x"));
		DecPadrao decPadrao1 = new DecPadrao(idFuncao, listaPadrao1, new ValorInteiro(15));
		
		// padrao maxSales 2 = 18
		List<Expressao> listaPadrao2 = new ArrayList<Expressao>();
		listaPadrao2.add(new ValorInteiro(2));
		listaPadrao2.add(new Id("y"));
		DecPadrao decPadrao2 = new DecPadrao(idFuncao, listaPadrao2, new ValorInteiro(18));
		
		// padrao maxSales x = 12
		List<Expressao> listaPadrao3 = new ArrayList<Expressao>();
		listaPadrao3.add(new ValorInteiro(3));
		listaPadrao3.add(new Id("z"));
		DecPadrao decPadrao3 = new DecPadrao(idFuncao, listaPadrao3, new ValorInteiro(12));
		
		List<DecPadrao> declaracoesPadrao = new ArrayList<DecPadrao>();
		declaracoesPadrao.add(decPadrao1);
		declaracoesPadrao.add(decPadrao2);
		declaracoesPadrao.add(decPadrao3);
		
		DecFuncao declaracaoFuncao = new DecFuncao(declaracoesPadrao);
		
		List<DeclaracaoFuncional> listaDecFuncional = new ArrayList<DeclaracaoFuncional>();
		listaDecFuncional.add(declaracaoFuncao);
		
		List<Expressao> listaPadraoAplicacao = new ArrayList<Expressao>();
		listaPadraoAplicacao.add(new ValorInteiro(20));
		Aplicacao aplicacao = new Aplicacao(idFuncao, listaPadraoAplicacao);
		
		ExpDeclaracao expDeclaracao = new ExpDeclaracao(listaDecFuncional, aplicacao);
		Programa programa = new Programa(expDeclaracao);
		// Checar tipo tem que ser false
		Assert.assertTrue(!programa.checaTipo());
	}
	
	// let fun maxSales 1 = 15
	// | maxSales 2 = 18
	// | maxSales 3 = 12
	// in maxSales(1)
	@Test
	public void testChecarTipoValoresInteiros() throws Exception {
		this.ambienteCompilacao.incrementa();
		Id idFuncao = new Id("maxSales");
		
		// padrao maxSales 1 = 15
		List<Expressao> listaPadrao1 = new ArrayList<Expressao>();
		listaPadrao1.add(new ValorInteiro(1));
		DecPadrao decPadrao1 = new DecPadrao(idFuncao, listaPadrao1, new ValorInteiro(15));
		
		// padrao maxSales 2 = 18
		List<Expressao> listaPadrao2 = new ArrayList<Expressao>();
		listaPadrao2.add(new ValorInteiro(2));
		DecPadrao decPadrao2 = new DecPadrao(idFuncao, listaPadrao2, new ValorInteiro(18));
		
		// padrao maxSales 3 = 12
		List<Expressao> listaPadrao3 = new ArrayList<Expressao>();
		listaPadrao3.add(new ValorInteiro(3));
		DecPadrao decPadrao3 = new DecPadrao(idFuncao, listaPadrao3, new ValorInteiro(12));
		
		List<DecPadrao> declaracoesPadrao = new ArrayList<DecPadrao>();
		declaracoesPadrao.add(decPadrao1);
		declaracoesPadrao.add(decPadrao2);
		declaracoesPadrao.add(decPadrao3);
		
		DecFuncao declaracaoFuncao = new DecFuncao(declaracoesPadrao);
		
		List<DeclaracaoFuncional> listaDecFuncional = new ArrayList<DeclaracaoFuncional>();
		listaDecFuncional.add(declaracaoFuncao);
		
		Aplicacao aplicacao = new Aplicacao(idFuncao, listaPadrao2);
		
		ExpDeclaracao expDeclaracao = new ExpDeclaracao(listaDecFuncional, aplicacao);
		Programa programa = new Programa(expDeclaracao);
		
		Assert.assertTrue(programa.checaTipo());
	}
	
	// let fun maxSales 1 = 15
	// | maxSales 2 = 18
	// | maxSales x = 12
	// in maxSales(1)
	@Test
	public void testChecarTipoVariavel() throws Exception {
		this.ambienteCompilacao.incrementa();
		Id idFuncao = new Id("maxSales");
		
		// padrao maxSales 1 = 15
		List<Expressao> listaPadrao1 = new ArrayList<Expressao>();
		listaPadrao1.add(new ValorInteiro(1));
		DecPadrao decPadrao1 = new DecPadrao(idFuncao, listaPadrao1, new ValorInteiro(15));
		
		// padrao maxSales 2 = 18
		List<Expressao> listaPadrao2 = new ArrayList<Expressao>();
		listaPadrao2.add(new ValorInteiro(2));
		DecPadrao decPadrao2 = new DecPadrao(idFuncao, listaPadrao2, new ValorInteiro(18));
		
		// padrao maxSales x = 12
		List<Expressao> listaPadrao3 = new ArrayList<Expressao>();
		listaPadrao3.add(new Id("x"));
		DecPadrao decPadrao3 = new DecPadrao(idFuncao, listaPadrao3, new ValorInteiro(12));
		
		List<DecPadrao> declaracoesPadrao = new ArrayList<DecPadrao>();
		declaracoesPadrao.add(decPadrao1);
		declaracoesPadrao.add(decPadrao2);
		declaracoesPadrao.add(decPadrao3);
		
		DecFuncao declaracaoFuncao = new DecFuncao(declaracoesPadrao);
		
		List<DeclaracaoFuncional> listaDecFuncional = new ArrayList<DeclaracaoFuncional>();
		listaDecFuncional.add(declaracaoFuncao);
		
		List<Expressao> listaPadraoAplicacao = new ArrayList<Expressao>();
		listaPadraoAplicacao.add(new ValorInteiro(20));
		Aplicacao aplicacao = new Aplicacao(idFuncao, listaPadraoAplicacao);
		
		ExpDeclaracao expDeclaracao = new ExpDeclaracao(listaDecFuncional, aplicacao);
		Programa programa = new Programa(expDeclaracao);
		
		Assert.assertTrue(programa.checaTipo());
	}
	
	// let fun maxSales 1 = 15
	// | maxSalesss 2 = 18
	// | maxSales x = 12
	// in maxSales(1)
	@Test
	public void testChecarTipoErroNomeFuncao() throws Exception {
		try {
			this.ambienteCompilacao.incrementa();
			Id idFuncao = new Id("maxSales");
			
			// padrao maxSales 1 = 15
			List<Expressao> listaPadrao1 = new ArrayList<Expressao>();
			listaPadrao1.add(new ValorInteiro(1));
			DecPadrao decPadrao1 = new DecPadrao(idFuncao, listaPadrao1,
					new ValorInteiro(15));
			
			// padrao maxSales 2 = 18
			List<Expressao> listaPadrao2 = new ArrayList<Expressao>();
			listaPadrao2.add(new ValorInteiro(2));
			DecPadrao decPadrao2 = new DecPadrao(new Id("maxSalesss"), listaPadrao2,
					new ValorInteiro(18));
			
			// padrao maxSales x = 12
			List<Expressao> listaPadrao3 = new ArrayList<Expressao>();
			listaPadrao3.add(new Id("x"));
			DecPadrao decPadrao3 = new DecPadrao(idFuncao, listaPadrao3,
					new ValorInteiro(12));
			
			List<DecPadrao> declaracoesPadrao = new ArrayList<DecPadrao>();
			declaracoesPadrao.add(decPadrao1);
			declaracoesPadrao.add(decPadrao2);
			declaracoesPadrao.add(decPadrao3);
			
			DecFuncao declaracaoFuncao = new DecFuncao(declaracoesPadrao);
			
			List<DeclaracaoFuncional> listaDecFuncional = new ArrayList<DeclaracaoFuncional>();
			listaDecFuncional.add(declaracaoFuncao);
			
			List<Expressao> listaPadraoAplicacao = new ArrayList<Expressao>();
			listaPadraoAplicacao.add(new ValorInteiro(20));
			Aplicacao aplicacao = new Aplicacao(idFuncao, listaPadraoAplicacao);
			
			ExpDeclaracao expDeclaracao = new ExpDeclaracao(listaDecFuncional, aplicacao);
			Programa programa = new Programa(expDeclaracao);
			programa.checaTipo();
			Assert.assertTrue(false);
		}
		catch ( FuncaoNomeDiferenteException ex ) {
			Assert.assertTrue(true);
		}
		catch ( Exception ex ) {
			Assert.assertTrue(false);
		}
	}
	
	// let fun maxSales 1 = 15
	// | maxSales 2 x = 18
	// | maxSales 3 = 12
	// in maxSales(20)
	@Test
	public void testChecarTipoErroQtdParametrosFuncao1() throws Exception {
		try {
			this.ambienteCompilacao.incrementa();
			Id idFuncao = new Id("maxSales");
			
			// padrao maxSales 1 = 15
			List<Expressao> listaPadrao1 = new ArrayList<Expressao>();
			listaPadrao1.add(new ValorInteiro(1));
			DecPadrao decPadrao1 = new DecPadrao(idFuncao, listaPadrao1,
					new ValorInteiro(15));
			
			// padrao maxSales 2 = 18
			List<Expressao> listaPadrao2 = new ArrayList<Expressao>();
			listaPadrao2.add(new ValorInteiro(2));
			listaPadrao2.add(new Id("x"));
			DecPadrao decPadrao2 = new DecPadrao(idFuncao, listaPadrao2,
					new ValorInteiro(18));
			
			// padrao maxSales x = 12
			List<Expressao> listaPadrao3 = new ArrayList<Expressao>();
			listaPadrao3.add(new ValorInteiro(3));
			DecPadrao decPadrao3 = new DecPadrao(idFuncao, listaPadrao3,
					new ValorInteiro(12));
			
			List<DecPadrao> declaracoesPadrao = new ArrayList<DecPadrao>();
			declaracoesPadrao.add(decPadrao1);
			declaracoesPadrao.add(decPadrao2);
			declaracoesPadrao.add(decPadrao3);
			
			DecFuncao declaracaoFuncao = new DecFuncao(declaracoesPadrao);
			
			List<DeclaracaoFuncional> listaDecFuncional = new ArrayList<DeclaracaoFuncional>();
			listaDecFuncional.add(declaracaoFuncao);
			
			List<Expressao> listaPadraoAplicacao = new ArrayList<Expressao>();
			listaPadraoAplicacao.add(new ValorInteiro(20));
			Aplicacao aplicacao = new Aplicacao(idFuncao, listaPadraoAplicacao);
			
			ExpDeclaracao expDeclaracao = new ExpDeclaracao(listaDecFuncional, aplicacao);
			Programa programa = new Programa(expDeclaracao);
			programa.checaTipo();
			Assert.assertTrue(false);
		}
		catch ( NumeroParametrosException ex ) {
			Assert.assertTrue(true);
		}
		catch ( Exception ex ) {
			Assert.assertTrue(false);
		}
	}
	
	// let fun maxSales 1 = 15
	// | maxSales 2 = 18
	// | maxSales x = 12
	// in maxSales(20, 30)
	@Test
	public void testChecarTipoErroQtdParametrosFuncao2() throws Exception {
		this.ambienteCompilacao.incrementa();
		Id idFuncao = new Id("maxSales");
		
		// padrao maxSales 1 = 15
		List<Expressao> listaPadrao1 = new ArrayList<Expressao>();
		listaPadrao1.add(new ValorInteiro(1));
		DecPadrao decPadrao1 = new DecPadrao(idFuncao, listaPadrao1, new ValorInteiro(15));
		
		// padrao maxSales 2 = 18
		List<Expressao> listaPadrao2 = new ArrayList<Expressao>();
		listaPadrao2.add(new ValorInteiro(2));
		DecPadrao decPadrao2 = new DecPadrao(idFuncao, listaPadrao2, new ValorInteiro(18));
		
		// padrao maxSales x = 12
		List<Expressao> listaPadrao3 = new ArrayList<Expressao>();
		listaPadrao3.add(new Id("x"));
		DecPadrao decPadrao3 = new DecPadrao(idFuncao, listaPadrao3, new ValorInteiro(12));
		
		List<DecPadrao> declaracoesPadrao = new ArrayList<DecPadrao>();
		declaracoesPadrao.add(decPadrao1);
		declaracoesPadrao.add(decPadrao2);
		declaracoesPadrao.add(decPadrao3);
		
		DecFuncao declaracaoFuncao = new DecFuncao(declaracoesPadrao);
		
		List<DeclaracaoFuncional> listaDecFuncional = new ArrayList<DeclaracaoFuncional>();
		listaDecFuncional.add(declaracaoFuncao);
		
		List<Expressao> listaPadraoAplicacao = new ArrayList<Expressao>();
		listaPadraoAplicacao.add(new ValorInteiro(20));
		listaPadraoAplicacao.add(new ValorInteiro(30));
		Aplicacao aplicacao = new Aplicacao(idFuncao, listaPadraoAplicacao);
		
		ExpDeclaracao expDeclaracao = new ExpDeclaracao(listaDecFuncional, aplicacao);
		Programa programa = new Programa(expDeclaracao);
		// Checar tipo tem que retorna false
		Assert.assertTrue(!programa.checaTipo());
	}
	
}
