package plp.expressions2;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.LinkedList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import plp.expressions2.declaration.DecVariavel;
import plp.expressions2.expression.ExpDeclaracao;
import plp.expressions2.expression.ExpSoma;
import plp.expressions2.expression.Id;
import plp.expressions2.expression.ValorInteiro;
import plp.expressions2.memory.VariavelJaDeclaradaException;
import plp.expressions2.memory.VariavelNaoDeclaradaException;

public class ExemplosTest {

	@Test(expected = VariavelJaDeclaradaException.class)
	public void verificarVariavelJaDeclaradaException()
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException {

		// let var x = 3, var x = 2 in  x
		Id idX = new Id("x");
		Id idX2 = new Id("x");

		DecVariavel decX1 = new DecVariavel(idX, new ValorInteiro(3));
		DecVariavel decX2 = new DecVariavel(idX2, new ValorInteiro(2));

		List<DecVariavel> list1 = new LinkedList<DecVariavel>();
		list1.add(decX1);
		list1.add(decX2);
		ExpDeclaracao exp1 = new ExpDeclaracao(list1, idX);

		Programa prg = new Programa(exp1);

		assertThat(prg.checaTipo(), is(false));
		prg.executar();

	}

	@Test(expected = VariavelNaoDeclaradaException.class)
	public void verificarVariavelNaoDeclaradaException()
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException {

		// let var x = 3 in  y
		Id idX = new Id("x");
		Id idX2 = new Id("y");

		DecVariavel decX1 = new DecVariavel(idX, new ValorInteiro(3));

		List<DecVariavel> list1 = new LinkedList<DecVariavel>();
		list1.add(decX1);
		ExpDeclaracao exp1 = new ExpDeclaracao(list1, idX2);

		Programa prg = new Programa(exp1);

		assertThat(prg.checaTipo(), is(false));
		prg.executar();

	}

	@Test
	public void verificarEscopo() throws VariavelJaDeclaradaException,
			VariavelNaoDeclaradaException {

		// let var x = 3 in
		//    let var y = x + 1 in
		//      let var x = 5 in
		//          y
		Id idX = new Id("x");
		Id idY = new Id("y");

		DecVariavel decX2 = new DecVariavel(idX, new ValorInteiro(5));
		List<DecVariavel> list3 = new LinkedList<DecVariavel>();
		list3.add(decX2);
		ExpDeclaracao exp3 = new ExpDeclaracao(list3, idY);

		DecVariavel decY = new DecVariavel(idY, new ExpSoma(idX,
				new ValorInteiro(1)));
		List<DecVariavel> list2 = new LinkedList<DecVariavel>();
		list2.add(decY);
		ExpDeclaracao exp2 = new ExpDeclaracao(list2, exp3);

		DecVariavel decX1 = new DecVariavel(idX, new ValorInteiro(3));
		List<DecVariavel> list1 = new LinkedList<DecVariavel>();
		list1.add(decX1);
		ExpDeclaracao exp1 = new ExpDeclaracao(list1, exp2);

		Programa prg = new Programa(exp1);

		assertThat(prg.checaTipo(), is(true));
		assertThat(prg.executar().toString(), is("4"));

	}

	@Test
	public void verificarDeclaracaoColateral()
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException {

		// let var x = 3 in
		// let var x = x + 1, var y = x in
		// x + y
		//	     

		Id idX = new Id("x");
		Id idY = new Id("y");

		DecVariavel decVar1 = new DecVariavel(idX, new ValorInteiro(3));

		DecVariavel decVar2 = new DecVariavel(idX, new ExpSoma(idX,
				new ValorInteiro(1)));

		DecVariavel decVar3 = new DecVariavel(idY, idX);

		List<DecVariavel> list1 = new LinkedList<DecVariavel>();
		list1.add(decVar2);
		list1.add(decVar3);
		ExpDeclaracao expDeclara2 = new ExpDeclaracao(list1, new ExpSoma(idX,
				idY));

		List<DecVariavel> list01 = new LinkedList<DecVariavel>();
		list01.add(decVar1);
		ExpDeclaracao expDeclara = new ExpDeclaracao(list01, expDeclara2);

		Programa prg = new Programa(expDeclara);

		assertThat(prg.checaTipo(), is(true));
		assertThat(prg.executar().toString(), is("7"));

	}

	@Test
	@Ignore(value = "So passa quando temos a avaliacao da declaracao de forma sequencial")
	public void verificarDeclaracaoSequencial()
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException {

		// let var x = 3 in
		// let var x = x + 1, var y = x in
		// x + y
		//	     

		Id idX = new Id("x");
		Id idY = new Id("y");

		DecVariavel decVar1 = new DecVariavel(idX, new ValorInteiro(3));

		DecVariavel decVar2 = new DecVariavel(idX, new ExpSoma(idX,
				new ValorInteiro(1)));

		DecVariavel decVar3 = new DecVariavel(idY, idX);

		List<DecVariavel> list1 = new LinkedList<DecVariavel>();
		list1.add(decVar2);
		list1.add(decVar3);
		ExpDeclaracao expDeclara2 = new ExpDeclaracao(list1, new ExpSoma(idX,
				idY));

		List<DecVariavel> list01 = new LinkedList<DecVariavel>();
		list01.add(decVar1);
		ExpDeclaracao expDeclara = new ExpDeclaracao(list01, expDeclara2);

		Programa prg = new Programa(expDeclara);

		assertThat(prg.checaTipo(), is(true));
		assertThat(prg.executar().toString(), is("8"));

	}

}
