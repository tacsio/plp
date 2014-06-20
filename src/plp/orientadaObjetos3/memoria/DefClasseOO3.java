package plp.orientadaObjetos3.memoria;

import java.util.HashMap;
import java.util.Map;

import plp.expressions2.memory.VariavelNaoDeclaradaException;
import plp.orientadaObjetos1.declaracao.procedimento.DecProcedimento;
import plp.orientadaObjetos1.declaracao.variavel.DecVariavel;
import plp.orientadaObjetos1.expressao.leftExpression.Id;
import plp.orientadaObjetos1.util.Tipo;
import plp.orientadaObjetos2.declaracao.DecConstrutor;
import plp.orientadaObjetos2.memoria.DefClasseOO2;
import plp.orientadaObjetos3.declaracao.constante.Constante;
import plp.orientadaObjetos3.modulo.ListaId;

public class DefClasseOO3 extends DefClasseOO2 {

	private ListaId listaInclude;
	private ListaId listaExtends;

	private Map<Id, Constante> constantes;

	public DefClasseOO3(Id idClasse, Id nomeSuperClasse,
			DecVariavel decVariavel, DecConstrutor construtor,
			DecProcedimento decProcedimento, ListaId listaInclude,
			ListaId listaExtends) {
		super(idClasse, nomeSuperClasse, decVariavel, construtor,
				decProcedimento);

		this.listaExtends = listaExtends;
		this.listaInclude = listaInclude;
		this.constantes = new HashMap<Id, Constante>();
	}

	@Override
	public Tipo getTipoAtributo(Id idAtributo)
			throws VariavelNaoDeclaradaException {

		Tipo tipo = null;
		try {
			tipo = super.getTipoAtributo(idAtributo);
		} catch (VariavelNaoDeclaradaException e) {
			// verifica se eh uma constante
			if(constantes.containsKey(idAtributo)){
				tipo = constantes.get(idAtributo).getTipo();
			} else {
				throw new VariavelNaoDeclaradaException(idAtributo);
			}
		}

		return tipo;
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

	public Constante getConstante(Id id) {
		return constantes.get(id);
	}

	public void addConstantes(Map<Id, Constante> constantes) {
		this.constantes.putAll(constantes);
	}
}
