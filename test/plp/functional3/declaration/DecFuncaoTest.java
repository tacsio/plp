package plp.functional3.declaration;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import plp.expressions2.expression.Expressao;
import plp.expressions2.expression.Id;
import plp.expressions2.expression.ValorInteiro;

public class DecFuncaoTest {
	
	// let fun fat 1 = 5
	@Test
	public void testAridadeShouldReturnOne() throws Exception {
		Id idFuncao = new Id("fat");
		
		List<Expressao> listaExp1 = new ArrayList<Expressao>();
		listaExp1.add(new ValorInteiro(1));
		
		Expressao exp1 = new ValorInteiro(5);
		DecPadrao decPadrao1 = new DecPadrao(idFuncao, listaExp1, exp1);
		List<DecPadrao> padroes = new ArrayList<DecPadrao>();
		padroes.add(decPadrao1);
		
		DecFuncao decFuncao = new DecFuncao(padroes);
		
		Assert.assertEquals(1, decFuncao.getAridade());
	}
	
	// let fun fat 1 x z = 5
	@Test
	public void testAridadeShouldReturnThree() throws Exception {
		Id idFuncao = new Id("fat");
		
		List<Expressao> listaExp1 = new ArrayList<Expressao>();
		listaExp1.add(new ValorInteiro(1));
		listaExp1.add(new Id("x"));
		listaExp1.add(new Id("y"));
		
		Expressao exp1 = new ValorInteiro(5);
		DecPadrao valor1 = new DecPadrao(idFuncao, listaExp1, exp1);
		List<DecPadrao> padroes = new ArrayList<DecPadrao>();
		padroes.add(valor1);
		
		DecFuncao decFuncao = new DecFuncao(padroes);
		
		Assert.assertEquals(3, decFuncao.getAridade());
	}
	
	// let fun test x = 1
	@Test
	public void testGetId() throws Exception {
		Id idFuncao = new Id("test");
		
		List<Expressao> listaExp = new ArrayList<Expressao>();
		listaExp.add(new Id("x"));
		
		Expressao exp = new ValorInteiro(1);
		DecPadrao valor = new DecPadrao(idFuncao, listaExp, exp);
		List<DecPadrao> padroes = new ArrayList<DecPadrao>();
		padroes.add(valor);
		
		DecFuncao decFuncao = new DecFuncao(padroes);
		Assert.assertEquals(new Id("test"), decFuncao.getId());
	}
}
