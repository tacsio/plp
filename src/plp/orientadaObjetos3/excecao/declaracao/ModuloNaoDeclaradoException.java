package plp.orientadaObjetos3.excecao.declaracao;

import plp.orientadaObjetos1.expressao.leftExpression.Id;


public class ModuloNaoDeclaradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ModuloNaoDeclaradoException(String moduleName) {
		super(moduleName);
	}

	public ModuloNaoDeclaradoException(Id id) {
		super("Módulo " + id + " não declarado");
	}
}
