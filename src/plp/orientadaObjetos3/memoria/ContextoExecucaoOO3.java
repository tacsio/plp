package plp.orientadaObjetos3.memoria;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import plp.orientadaObjetos1.expressao.leftExpression.Id;
import plp.orientadaObjetos1.util.Tipo;
import plp.orientadaObjetos2.memoria.ContextoExecucaoOO2;
import plp.orientadaObjetos3.excecao.declaracao.ModuloJaDeclaradoException;

public class ContextoExecucaoOO3 extends ContextoExecucaoOO2 implements
		AmbienteExecucaoOO3 {

	private Map<Id, DefModulo> mapDefModulo;

	private Stack<HashMap<Id, Tipo>> pilhaConstantes;
	
	public ContextoExecucaoOO3() {
		super();
		this.mapDefModulo = new HashMap<Id, DefModulo>();
	}

	public void mapDefModulo(Id id, DefModulo defModulo)
			throws ModuloJaDeclaradoException {
		if (this.mapDefModulo.put(id, defModulo) != null) {
			throw new ModuloJaDeclaradoException(id);
		}

	}

}
