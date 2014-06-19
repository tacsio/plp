package plp.orientadaObjetos3.memoria;

import plp.orientadaObjetos1.declaracao.procedimento.DecProcedimento;
import plp.orientadaObjetos1.declaracao.variavel.DecVariavel;
import plp.orientadaObjetos1.expressao.leftExpression.Id;
import plp.orientadaObjetos2.declaracao.DecConstrutor;
import plp.orientadaObjetos2.memoria.DefClasseOO2;
import plp.orientadaObjetos3.modulo.ListaId;

public class DefClasseOO3 extends DefClasseOO2 {

	private ListaId listaInclude;
	private ListaId listaExtends;

	public DefClasseOO3(Id idClasse, Id nomeSuperClasse,
			DecVariavel decVariavel, DecConstrutor construtor,
			DecProcedimento decProcedimento, ListaId listaInclude,
			ListaId listaExtends) {
		super(idClasse, nomeSuperClasse, decVariavel, construtor,
				decProcedimento);

		this.listaExtends = listaExtends;
		this.listaInclude = listaInclude;
	}

	public ListaId getListaInclude() {
		return listaInclude;
	}

	public void setListaInclude(ListaId listaInclude) {
		this.listaInclude = listaInclude;
	}

	public ListaId getListaExtends() {
		return listaExtends;
	}

	public void setListaExtends(ListaId listaExtends) {
		this.listaExtends = listaExtends;
	}

}
