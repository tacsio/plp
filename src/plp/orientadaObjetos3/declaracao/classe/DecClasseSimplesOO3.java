package plp.orientadaObjetos3.declaracao.classe;

import plp.orientadaObjetos1.declaracao.procedimento.DecProcedimento;
import plp.orientadaObjetos1.declaracao.variavel.DecVariavel;
import plp.orientadaObjetos1.expressao.leftExpression.Id;
import plp.orientadaObjetos2.declaracao.DecConstrutor;
import plp.orientadaObjetos2.declaracao.classe.DecClasseSimplesOO2;
import plp.orientadaObjetos3.modulo.ListaId;
import plp.orientadaObjetos3.modulo.UsaModulo;

public class DecClasseSimplesOO3 extends DecClasseSimplesOO2 {

	private ListaId listaInclude;
	private ListaId listaExtends;

	public DecClasseSimplesOO3(Id nomeClasse, Id nomeSuperClasse,
			UsaModulo usaModulo, DecVariavel atributos,
			DecConstrutor construtor, DecProcedimento metodos) {
		super(nomeClasse, nomeSuperClasse, atributos, construtor, metodos);

		this.listaExtends = usaModulo.getListaExtends();
		this.listaInclude = usaModulo.getListaInclude();
	}
	
	
	public String toString() {
		StringBuffer retorno = new StringBuffer();
		retorno.append(this.nomeClasse);
		retorno.append("\n");
		
		retorno.append("Included modules:");
		retorno.append("[");
		retorno.append(this.listaInclude);
		retorno.append("]\n");
		
		retorno.append("Extends modules:");
		retorno.append("[");
		retorno.append(this.listaExtends);
		retorno.append("]\n");
		retorno.append("\n");
		
		return retorno.toString();
	}
}
