package plp.functional2;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import plp.expressions2.expression.ExpEquals;
import plp.expressions2.expression.ExpSoma;
import plp.expressions2.expression.Expressao;
import plp.expressions2.expression.Id;
import plp.expressions2.expression.ValorInteiro;
import plp.expressions2.memory.VariavelJaDeclaradaException;
import plp.expressions2.memory.VariavelNaoDeclaradaException;
import plp.functional1.declaration.DecVariavel;
import plp.functional1.declaration.DeclaracaoFuncional;
import plp.functional2.declaration.DecFuncao;
import plp.functional2.expression.Aplicacao;
import plp.functional2.expression.ExpDeclaracao;
import plp.functional2.expression.ValorFuncao;

public class ExemplosTest {
	private static final ValorInteiro UM = new ValorInteiro(1);
	private static final ValorInteiro MENOS_UM = new ValorInteiro(-1);

	Id x = new Id("x");
	Id id = new Id("id");
	Id y = new Id("y");

	DecFuncao createFuncaoId() {
		return new DecFuncao(id, new ValorFuncao(asList(x), x));

	}

	@Test
	public void addCurry() throws VariavelJaDeclaradaException,
			VariavelNaoDeclaradaException {
		//let fun add x = fn y . x + y in
		//let var id = add(0), var x = 4 in
		//  id(1) + x

		Id idAdd = new Id("add");

		Aplicacao aplicId = new Aplicacao(id, Arrays
				.asList(new Expressao[] { new ValorInteiro(1) }));
		Aplicacao aplicAdd = new Aplicacao(idAdd, Arrays
				.asList(new Expressao[] { new ValorInteiro(0) }));
		DecVariavel decVarId = new DecVariavel(id, aplicAdd);
		DecVariavel decVarX = new DecVariavel(x, new ValorInteiro(4));

		ExpSoma expSomaFinal = new ExpSoma(aplicId, x);

		ExpDeclaracao expdecId = new ExpDeclaracao(Arrays
				.asList(new DeclaracaoFuncional[] { decVarId, decVarX }),
				expSomaFinal);

		ExpSoma expSoma = new ExpSoma(x, y);
		ValorFuncao valorFuncaoLambda = new ValorFuncao(Arrays.asList(y),
				expSoma);
		ValorFuncao valorFuncaoAdd = new ValorFuncao(Arrays.asList(x),
				valorFuncaoLambda);
		DecFuncao decFunAdd = new DecFuncao(idAdd, valorFuncaoAdd);

		ExpDeclaracao expdecAdd = new ExpDeclaracao(Arrays
				.asList((DeclaracaoFuncional) decFunAdd), expdecId);

		Programa prg = new Programa(expdecAdd);

		assertThat(prg.checaTipo(), is(true));
		assertThat(prg.executar().toString(), is("5"));

	}

	@Test
	public void simpleCurry() throws VariavelJaDeclaradaException,
			VariavelNaoDeclaradaException {
		//let var id = fn x . x in id

		List<DeclaracaoFuncional> declaracoes = new ArrayList<DeclaracaoFuncional>();
		ValorFuncao valorFuncaoLambda = new ValorFuncao(Arrays.asList(x), x);

		declaracoes.add(new DecVariavel(id, valorFuncaoLambda));

		ExpDeclaracao expDeclaracao = new ExpDeclaracao(declaracoes, id);
		Programa prg = new Programa(expDeclaracao);

		assertThat(prg.checaTipo(), is(true));
		assertEquals(prg.executar().toString(), "fn x . x");

	}

	@Test
	public void sucPredId() throws VariavelJaDeclaradaException,
			VariavelNaoDeclaradaException {
		//let var suc = fn x . x+1, var pred = fn  x . x-1,var id = fn x . x in
		//suc(pred(2)) == (id(2))

		Id suc = new Id("suc");
		Id pred = new Id("pred");

		List<DeclaracaoFuncional> declaracoes = new ArrayList<DeclaracaoFuncional>();
		ValorFuncao idLambda = new ValorFuncao(Arrays.asList(x), x);
		ValorFuncao sucLambda = new ValorFuncao(Arrays.asList(x), new ExpSoma(
				x, new ValorInteiro(1)));
		ValorFuncao predLambda = new ValorFuncao(Arrays.asList(x), new ExpSoma(
				x, new ValorInteiro(-1)));

		declaracoes.add(new DecVariavel(id, idLambda));
		declaracoes.add(new DecVariavel(suc, sucLambda));
		declaracoes.add(new DecVariavel(pred, predLambda));

		Aplicacao id2 = new Aplicacao(id, Arrays
				.asList((Expressao) new ValorInteiro(2)));

		Aplicacao suc2 = new Aplicacao(suc, Arrays
				.asList((Expressao) new ValorInteiro(2)));
		Aplicacao predSuc2 = new Aplicacao(pred, Arrays
				.asList((Expressao) suc2));

		ExpEquals eq = new ExpEquals(predSuc2, id2);
		ExpDeclaracao expDeclaracao = new ExpDeclaracao(declaracoes, eq);
		Programa prg = new Programa(expDeclaracao);

		assertThat(prg.checaTipo(), is(true));
		assertEquals(prg.executar().toString(), "true");

	}

	@Test
	public void composicaoCurry() throws Exception {
		// let fun pred x = x -1, fun suc x = x + 1 in
		// let  fun comp f g  = fn x . f(g(x)) in 
		// comp(pred,suc)

		Id f = new Id("f");
		Id g = new Id("g");
		Id suc = new Id("suc");
		Id pred = new Id("pred");
		Id comp = new Id("comp");

		DecFuncao funSuc = new DecFuncao(suc, new ValorFuncao(asList(x),
				new ExpSoma(x, UM)));
		DecFuncao funPred = new DecFuncao(pred, new ValorFuncao(asList(x),
				new ExpSoma(x, MENOS_UM)));

		ValorFuncao corpoComp = new ValorFuncao(asList(f, g), new ValorFuncao(
				asList(x), new Aplicacao(f, new Aplicacao(g, x))));
		DecFuncao funComp = new DecFuncao(comp, corpoComp);

		Aplicacao inCompPredSuc = new Aplicacao(comp, asList(pred, suc));
		ExpDeclaracao inComp = new ExpDeclaracao(asList(funComp), inCompPredSuc);
		ExpDeclaracao expDeclaracao = new ExpDeclaracao(
				asList(funSuc, funPred), inComp);

		Programa prg = new Programa(expDeclaracao);

		assertThat(prg.checaTipo(), is(true));
		assertThat(prg.executar().toString(),
				is("fn x . fn x . x + -1(fn x . x + 1(x))"));

	}

	@Test
	public void composicaoCurry2() throws Exception {
		// let fun pred x = x -1, fun suc x = x + 1 in
		// let  fun comp f g  = fn x . f(g(x)) in 
		// comp(pred,suc)(1)

		Id f = new Id("f");
		Id g = new Id("g");
		Id suc = new Id("suc");
		Id pred = new Id("pred");
		Id comp = new Id("comp");

		DecFuncao funSuc = new DecFuncao(suc, new ValorFuncao(asList(x),
				new ExpSoma(x, UM)));
		DecFuncao funPred = new DecFuncao(pred, new ValorFuncao(asList(x),
				new ExpSoma(x, MENOS_UM)));

		ValorFuncao corpoComp = new ValorFuncao(asList(f, g), new ValorFuncao(
				asList(x), new Aplicacao(f, new Aplicacao(g, x))));
		DecFuncao funComp = new DecFuncao(comp, corpoComp);

		Aplicacao inCompPredSuc = new Aplicacao(comp, asList(pred, suc));
		Aplicacao CompPredSuc2 = new Aplicacao(inCompPredSuc, asList(UM));

		ExpDeclaracao inComp = new ExpDeclaracao(asList(funComp), CompPredSuc2);
		ExpDeclaracao expDeclaracao = new ExpDeclaracao(
				asList(funSuc, funPred), inComp);

		Programa prg = new Programa(expDeclaracao);

		assertThat(prg.checaTipo(), is(true));
		assertThat(prg.executar().toString(), is("1"));

	}
}
