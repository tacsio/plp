package plp.functional1;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import plp.expressions2.expression.ExpEquals;
import plp.expressions2.expression.ExpSoma;
import plp.expressions2.expression.ExpSub;
import plp.expressions2.expression.Expressao;
import plp.expressions2.expression.Id;
import plp.expressions2.expression.ValorBooleano;
import plp.expressions2.expression.ValorInteiro;
import plp.expressions2.memory.VariavelJaDeclaradaException;
import plp.expressions2.memory.VariavelNaoDeclaradaException;
import plp.functional1.declaration.DecFuncao;
import plp.functional1.declaration.DecVariavel;
import plp.functional1.declaration.DeclaracaoFuncional;
import plp.functional1.expression.Aplicacao;
import plp.functional1.expression.ExpDeclaracao;
import plp.functional1.expression.IfThenElse;

public class ExemplosTest {

	private static final ValorBooleano TRUE = new ValorBooleano(true);
	private static final ValorBooleano FALSE = new ValorBooleano(false);
	private static final ValorInteiro ZERO = new ValorInteiro(0);
	private static final ValorInteiro UM = new ValorInteiro(1);
	private static final ValorInteiro DOIS = new ValorInteiro(2);
	private static final ValorInteiro QUATRO = new ValorInteiro(4);
	private static final ValorInteiro SETE = new ValorInteiro(7);

	Id mult = new Id("mult");
	Id x = new Id("x");
	Id y = new Id("y");
	Id z = new Id("z");
	Id fat = new Id("fat");
	Id f = new Id("f");
	Id n = new Id("n");
	Id id = new Id("id");

	DecFuncao createFuncaoId() {
		return new DecFuncao(id, asList(x), x);

	}

	@Test
	public void escopoDeAvaliacao() throws VariavelJaDeclaradaException,
			VariavelNaoDeclaradaException {

		// let var x = 3 in 
		//   let fun n y = y + x in 
		//      let var x = 5 in 
		//         n 1 

		DecVariavel decX1 = new DecVariavel(x, new ValorInteiro(3));
		DecVariavel decX2 = new DecVariavel(x, new ValorInteiro(5));
		Expressao exp = new Aplicacao(n, asList(UM));
		Expressao exp2 = new ExpDeclaracao(asList(decX2), exp);
		DecFuncao decN = new DecFuncao(n, asList(y), new ExpSoma(x, y));
		Expressao exp3 = new ExpDeclaracao(asList(decN), exp2);
		Expressao exp4 = new ExpDeclaracao(asList(decX1), exp3);
		Programa prg = new Programa(exp4);

		assertThat(prg.executar().toString(), is("6"));
		assertThat(prg.checaTipo(), is(true));
	}

	@Test
	@Ignore(value = "muda a regra de escopo de avaliação para testar")
	public void escopoDeAvaliacao2() throws VariavelJaDeclaradaException,
			VariavelNaoDeclaradaException {

		// let var x = 3 in 
		//   let fun n y = y + x in 
		//      let var x = 5 in 
		//         n 1 

		DecVariavel decX1 = new DecVariavel(x, new ValorInteiro(3));
		DecVariavel decX2 = new DecVariavel(x, new ValorInteiro(5));
		Expressao exp = new Aplicacao(n, asList(UM));
		Expressao exp2 = new ExpDeclaracao(asList(decX2), exp);
		DecFuncao decN = new DecFuncao(n, asList(y), new ExpSoma(x, y));
		Expressao exp3 = new ExpDeclaracao(asList(decN), exp2);
		Expressao exp4 = new ExpDeclaracao(asList(decX1), exp3);

		Programa prg = new Programa(exp4);
		assertThat(prg.executar().toString(), is("4"));
		assertThat(prg.checaTipo(), is(true));
	}

	@Test
	public void fatorial() throws VariavelJaDeclaradaException,
			VariavelNaoDeclaradaException {
		//		let fun fat n =
		//		    let fun mult x y = if (x == 0) then (0) else (y + (mult (x - 1) y))
		//		    in if (n == 0) then (1) else (mult n (fat (n - 1)))
		//		in fat 5
		Expressao expMult2 = new ExpSoma(y, new Aplicacao(mult,
				asList(new Expressao[] { new ExpSub(x, UM), y })));
		Expressao expMult1 = new IfThenElse(new ExpEquals(x, ZERO), ZERO,
				expMult2);
		DecFuncao funMult = new DecFuncao(mult, asList(x, y), expMult1);

		Expressao expFat2 = new Aplicacao(mult, asList(new Expressao[] { n,
				new Aplicacao(fat, asList(new ExpSub(n, UM))) }));
		Expressao expFat1 = new IfThenElse(new ExpEquals(n, ZERO), UM, expFat2);
		Expressao expFat0 = new ExpDeclaracao(asList(funMult), expFat1);
		DecFuncao funFat = new DecFuncao(fat, asList(n), expFat0);

		List<? extends Expressao> lexp = asList(new ValorInteiro(5));
		ExpDeclaracao exp = new ExpDeclaracao(asList(funFat), new Aplicacao(
				fat, lexp));
		Programa prg = new Programa(exp);
		assertThat(prg.executar().toString(), is("120"));
		assertThat(prg.checaTipo(), is(true));

	}

	@Test
	public void multiplicacao() throws Exception {
		// mult x y = if (x == 0) then (0) else (y + mult (x - 1, y)) in mult (4,7)

		Expressao expIn = new Aplicacao(mult, asList(QUATRO, SETE));

		Expressao then = ZERO;

		List<Expressao> parametrosInterno = new ArrayList<Expressao>();
		parametrosInterno.add(new ExpSub(x, UM));
		parametrosInterno.add(y);
		Expressao expElse = new ExpSoma(y, new Aplicacao(mult,
				parametrosInterno));
		Expressao funcao = new IfThenElse(new ExpEquals(x, ZERO), then, expElse);
		Expressao exp = new ExpDeclaracao(asList(new DecFuncao(mult, asList(x,
				y), funcao)), expIn);
		Programa prg = new Programa(exp);

		assertThat(prg.executar().toString(), is("28"));
		assertThat(prg.checaTipo(), is(true));
	}

	@Test
	public void ifThenElse() throws VariavelJaDeclaradaException,
			VariavelNaoDeclaradaException {
		Expressao teste = new ValorBooleano(true);
		Expressao then = new ValorBooleano(true);
		Expressao expElse = new ValorBooleano(true);

		IfThenElse ifThenElse = new IfThenElse(teste, then, expElse);

		Programa prog = new Programa(ifThenElse);
		assertEquals(prog.checaTipo(), true);
		assertEquals(prog.executar().toString(), "true");

		Expressao then2 = new ValorInteiro(2);
		Expressao expElse2 = new ValorBooleano(true);

		IfThenElse ifThenElse2 = new IfThenElse(new ValorBooleano(true), then2,
				expElse2);

		Programa prg = new Programa(ifThenElse2);
		assertThat(prg.checaTipo(), is(false));

	}

	@Test
	public void sucPredId() throws VariavelJaDeclaradaException,
			VariavelNaoDeclaradaException {
		//let fun suc x = x+1, fun pred x = x-1,fun id x = x in
		//suc(pred(2)) == (id(2))

		Id suc = new Id("suc");
		Id pred = new Id("pred");

		List<DeclaracaoFuncional> declaracoes = new ArrayList<DeclaracaoFuncional>();

		declaracoes.add(createFuncaoId());
		declaracoes.add(new DecFuncao(suc, asList(x), new ExpSoma(x,
				new ValorInteiro(1))));
		declaracoes.add(new DecFuncao(pred, asList(x), new ExpSoma(x,
				new ValorInteiro(-1))));

		Aplicacao id2 = new Aplicacao(id,
				asList((Expressao) new ValorInteiro(2)));

		Aplicacao suc2 = new Aplicacao(suc,
				asList((Expressao) new ValorInteiro(2)));
		Aplicacao predSuc2 = new Aplicacao(pred, asList((Expressao) suc2));

		ExpEquals eq = new ExpEquals(predSuc2, id2);
		ExpDeclaracao expDeclaracao = new ExpDeclaracao(declaracoes, eq);
		Programa prg = new Programa(expDeclaracao);

		assertThat(prg.executar().toString(), is("true"));
		assertThat(prg.checaTipo(), is(true));

	}

	@Test
	public void testSomaId() throws VariavelJaDeclaradaException,
			VariavelNaoDeclaradaException {
		// let fun Id x = x in
		// let fun sum x y = Id(x) + Id(y) in
		// sum(0,1)

		Id sum = new Id("sum");

		Aplicacao idX = new Aplicacao(id, asList(x));

		Aplicacao idY = new Aplicacao(id, asList(y));

		ExpSoma somaId = new ExpSoma(idX, idY);

		DecFuncao funSum = new DecFuncao(sum, asList(x, y), somaId);

		Aplicacao sum01 = new Aplicacao(sum, asList(ZERO, UM));
		ExpDeclaracao letSumXY = new ExpDeclaracao(asList(funSum), sum01);

		DecFuncao idFun = createFuncaoId();

		ExpDeclaracao letFunId = new ExpDeclaracao(asList(idFun), letSumXY);

		Programa prg = new Programa(letFunId);

		assertThat(prg.executar().toString(), is("1"));
		assertThat(prg.checaTipo(), is(true));

	}

	@Test
	public void erroDeTipos1() throws VariavelJaDeclaradaException,
			VariavelNaoDeclaradaException {
		//	let fun Id x = x in
		//	let fun sum x y = Id(x) + Id(y) in
		//	sum(0,true)

		Id sum = new Id("sum");

		Aplicacao idX = new Aplicacao(id, asList(x));

		Aplicacao idY = new Aplicacao(id, asList(y));

		ExpSoma somaId = new ExpSoma(idX, idY);

		DecFuncao funSum = new DecFuncao(sum, asList(x, y), somaId);

		Aplicacao sum01 = new Aplicacao(sum, asList((Expressao) ZERO, TRUE));
		ExpDeclaracao letSumXY = new ExpDeclaracao(asList(funSum), sum01);

		DecFuncao idFun = createFuncaoId();

		ExpDeclaracao letFunId = new ExpDeclaracao(asList(idFun), letSumXY);

		Programa prg = new Programa(letFunId);

		assertThat(prg.checaTipo(), is(false));

	}

	@Test
	public void erroDeTipos2() throws VariavelJaDeclaradaException,
			VariavelNaoDeclaradaException {
		//		let fun Id x = x in
		//	let fun sub x y = x - y in
		//	let fun sum x y = x + Id(y) in
		//	sum(sub(2,1), sub(true,3))

		Id sum = new Id("sum");
		Id sub = new Id("sub");

		Aplicacao idY = new Aplicacao(id, asList(y));

		ExpSoma somaId = new ExpSoma(x, idY);
		DecFuncao funSum = new DecFuncao(sum, asList(x, y), somaId);

		Aplicacao sub21 = new Aplicacao(sub, asList(DOIS, UM));
		Aplicacao subTrue3 = new Aplicacao(sub,
				asList((Expressao) TRUE, QUATRO));

		Aplicacao sumSubSub = new Aplicacao(sum, asList(sub21, subTrue3));
		ExpDeclaracao letSumXY = new ExpDeclaracao(asList(funSum), sumSubSub);

		ExpSub subXY = new ExpSub(x, y);
		DecFuncao funSub = new DecFuncao(sub, asList(x, y), subXY);
		ExpDeclaracao letSubXY = new ExpDeclaracao(asList(funSub), letSumXY);

		DecFuncao idFun = createFuncaoId();
		ExpDeclaracao letFunId = new ExpDeclaracao(asList(idFun), letSubXY);

		Programa prg = new Programa(letFunId);

		assertThat(prg.checaTipo(), is(false));
	}

	@Test
	public void idcomp() throws VariavelJaDeclaradaException,
			VariavelNaoDeclaradaException {
		//	-- OK / false
		//	let fun Id x = x in
		//	let fun comp x y = x == y in
		//	comp(false,true)

		Id comp = new Id("comp");

		Aplicacao appComp = new Aplicacao(comp, asList(FALSE, TRUE));
		ExpEquals expEq = new ExpEquals(x, y);
		DecFuncao funComp = new DecFuncao(comp, asList(x, y), expEq);
		ExpDeclaracao letSubXY = new ExpDeclaracao(asList(funComp), appComp);

		ExpDeclaracao letid = new ExpDeclaracao(asList(createFuncaoId()),
				letSubXY);

		Programa prg = new Programa(letid);

		assertThat(prg.checaTipo(), is(true));
		assertThat(prg.executar().toString(), is("false"));
	}

	@Test
	public void funIdIfThenElse() throws VariavelJaDeclaradaException,
			VariavelNaoDeclaradaException {
		//	-- OK
		//	let fun Id x = x in
		//	let fun sum x y = if (Id(true)) then x + Id(y) else 1 in
		//	sum(0,1)

		Id sum = new Id("sum");

		Aplicacao idY = new Aplicacao(id, asList(y));
		Aplicacao idTrue = new Aplicacao(id, asList(TRUE));

		ExpSoma somaId = new ExpSoma(x, idY);
		IfThenElse ifthenElse = new IfThenElse(idTrue, somaId, UM);
		DecFuncao funSum = new DecFuncao(sum, asList(x, y), ifthenElse);

		Aplicacao soma01 = new Aplicacao(sum, asList(ZERO, QUATRO));
		ExpDeclaracao letSumIfThenElse = new ExpDeclaracao(asList(funSum),
				soma01);
		ExpDeclaracao letid = new ExpDeclaracao(asList(createFuncaoId()),
				letSumIfThenElse);

		Programa prg = new Programa(letid);
		assertThat(prg.checaTipo(), is(true));
		assertThat(prg.executar().toString(), is("4"));
	}

}
