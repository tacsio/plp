package plp.orientadaObjetos3.memoria;

import plp.expressions2.memory.IdentificadorJaDeclaradoException;
import plp.orientadaObjetos1.expressao.leftExpression.Id;
import plp.orientadaObjetos2.memoria.AmbienteCompilacaoOO2;
import plp.orientadaObjetos3.excecao.declaracao.ModuloJaDeclaradoException;

public interface AmbienteCompilacaoOO3 extends AmbienteCompilacaoOO2 {

	public void mapDefModulo(Id id, DefModulo defModulo) throws ModuloJaDeclaradoException;

	public void mapConstantes(Id id, DefConstante constante) throws IdentificadorJaDeclaradoException;

}
