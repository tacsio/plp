package plp.orientadaObjetos3.declaracao.modulo;

import plp.orientadaObjetos1.declaracao.procedimento.DecProcedimento;
import plp.orientadaObjetos1.expressao.leftExpression.Id;
import plp.orientadaObjetos3.declaracao.constante.DecConstantes;

public class DecModulo {
	private Id id;
	private DecConstantes decConstantes;
	private DecProcedimento decProcedimento;
	
	public DecModulo(Id id, DecConstantes decConstantes,
			DecProcedimento decProcedimento) {
		
		super();
		this.id = id;
		this.decConstantes = decConstantes;
		this.decProcedimento = decProcedimento;
	}

	public Id getId() {
		return id;
	}

	public DecConstantes getDecConstantes() {
		return decConstantes;
	}

	public DecProcedimento getDecProcedimento() {
		return decProcedimento;
	}
}
