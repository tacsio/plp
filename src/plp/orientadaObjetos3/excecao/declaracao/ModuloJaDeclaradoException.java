package plp.orientadaObjetos3.excecao.declaracao;

import plp.orientadaObjetos1.expressao.leftExpression.Id;


public class ModuloJaDeclaradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ModuloJaDeclaradoException(String moduleName) {
		super(moduleName);
	}

	public ModuloJaDeclaradoException(Id id) {
		super("Módulo " + id + " já declarado");
	}
}
