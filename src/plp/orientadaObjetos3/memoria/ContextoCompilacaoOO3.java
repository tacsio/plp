package plp.orientadaObjetos3.memoria;

import java.util.HashMap;
import java.util.Map;

import plp.expressions2.memory.IdentificadorJaDeclaradoException;
import plp.orientadaObjetos1.expressao.leftExpression.Id;
import plp.orientadaObjetos1.memoria.colecao.ListaValor;
import plp.orientadaObjetos2.memoria.ContextoCompilacaoOO2;
import plp.orientadaObjetos3.excecao.declaracao.ModuloJaDeclaradoException;

public class ContextoCompilacaoOO3 extends ContextoCompilacaoOO2 implements AmbienteCompilacaoOO3 {

	private Map<Id, DefModulo> mapDefModulo;
	
	private Map<Id, DefConstante> mapConstante;
	
	public ContextoCompilacaoOO3(ListaValor entrada) {
		super(entrada);
		this.mapDefModulo = new HashMap<Id, DefModulo>();
		this.mapConstante = new HashMap<Id, DefConstante>();
	}

	public void mapDefModulo(Id id, DefModulo defModulo) throws ModuloJaDeclaradoException {
		if(this.mapDefModulo.put(id, defModulo) != null){
			throw new ModuloJaDeclaradoException(id);
		}
	}

	public void mapConstantes(Id id, DefConstante constante) throws IdentificadorJaDeclaradoException {
		if(this.mapConstante.put(id, constante) != null) {
			throw new IdentificadorJaDeclaradoException("Constante " + id + " já declarada");
		}
		
	}

}
