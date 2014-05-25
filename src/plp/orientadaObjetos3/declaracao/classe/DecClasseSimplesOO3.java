package plp.orientadaObjetos3.declaracao.classe;

import plp.orientadaObjetos1.declaracao.procedimento.DecProcedimento;
import plp.orientadaObjetos1.declaracao.variavel.DecVariavel;
import plp.orientadaObjetos1.expressao.leftExpression.Id;
import plp.orientadaObjetos2.declaracao.DecConstrutor;
import plp.orientadaObjetos2.declaracao.classe.DecClasseSimplesOO2;

public class DecClasseSimplesOO3 extends DecClasseSimplesOO2 {

	public DecClasseSimplesOO3(Id nomeClasse, Id nomeSuperClasse,
			DecVariavel atributos, DecConstrutor construtor,
			DecProcedimento metodos) {
		super(nomeClasse, nomeSuperClasse, atributos, construtor, metodos);
	}

}
