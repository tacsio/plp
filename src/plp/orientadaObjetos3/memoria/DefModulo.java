package plp.orientadaObjetos3.memoria;

import plp.orientadaObjetos1.comando.Procedimento;
import plp.orientadaObjetos1.declaracao.procedimento.DecProcedimento;
import plp.orientadaObjetos1.excecao.declaracao.ProcedimentoNaoDeclaradoException;
import plp.orientadaObjetos1.expressao.leftExpression.Id;
import plp.orientadaObjetos3.declaracao.constante.DecConstantes;

public class DefModulo {

	private Id id;
	private DecConstantes decConstantes;
	private DecProcedimento decProcedimento;

	public DefModulo(Id id, DecConstantes decConstantes,
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
		if(decConstantes == null){
			decConstantes = new DecConstantes();
		}
		return decConstantes;
	}

	public DecProcedimento getDecProcedimento() {
		return decProcedimento;
	}
	
	public Procedimento getProcedimento(Id id)
			throws ProcedimentoNaoDeclaradoException{
		
		if(decProcedimento == null){
			throw new ProcedimentoNaoDeclaradoException(id);
		}
		
		return decProcedimento.getProcedimento(id);
	}

}
