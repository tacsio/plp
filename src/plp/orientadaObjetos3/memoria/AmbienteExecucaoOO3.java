package plp.orientadaObjetos3.memoria;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import plp.expressions2.memory.IdentificadorJaDeclaradoException;
import plp.orientadaObjetos1.expressao.leftExpression.Id;
import plp.orientadaObjetos1.expressao.valor.Valor;
import plp.orientadaObjetos2.memoria.AmbienteExecucaoOO2;

public interface AmbienteExecucaoOO3 extends AmbienteExecucaoOO2 {

	public void mapDefModulo(Id id, DefModulo defModulo);

	public void mapConstantes(Id id, Valor valor)
			throws IdentificadorJaDeclaradoException;
	
	public DefModulo getDefModulo(Id id);
	
	public Map<Id, DefModulo> getMapDefModulo();
	
	public Stack<HashMap<Id, Valor>> getPilhaConstantes();

}
