package plp.orientadaObjetos3.memoria;

import plp.orientadaObjetos1.expressao.leftExpression.Id;
import plp.orientadaObjetos2.memoria.AmbienteExecucaoOO2;
import plp.orientadaObjetos3.excecao.declaracao.ModuloJaDeclaradoException;

public interface AmbienteExecucaoOO3 extends AmbienteExecucaoOO2 {

	public void mapDefModulo(Id id, DefModulo defModulo) throws ModuloJaDeclaradoException;


}
