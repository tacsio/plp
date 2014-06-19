package plp.orientadaObjetos3.declaracao.modulo;

import plp.expressions2.memory.VariavelJaDeclaradaException;
import plp.expressions2.memory.VariavelNaoDeclaradaException;
import plp.orientadaObjetos1.declaracao.Declaracao;
import plp.orientadaObjetos1.declaracao.procedimento.DecProcedimento;
import plp.orientadaObjetos1.excecao.declaracao.ClasseJaDeclaradaException;
import plp.orientadaObjetos1.excecao.declaracao.ClasseNaoDeclaradaException;
import plp.orientadaObjetos1.excecao.declaracao.ObjetoJaDeclaradoException;
import plp.orientadaObjetos1.excecao.declaracao.ObjetoNaoDeclaradoException;
import plp.orientadaObjetos1.excecao.declaracao.ProcedimentoJaDeclaradoException;
import plp.orientadaObjetos1.excecao.declaracao.ProcedimentoNaoDeclaradoException;
import plp.orientadaObjetos1.expressao.leftExpression.Id;
import plp.orientadaObjetos1.memoria.AmbienteCompilacaoOO1;
import plp.orientadaObjetos1.memoria.AmbienteExecucaoOO1;
import plp.orientadaObjetos3.declaracao.constante.DecConstantes;
import plp.orientadaObjetos3.memoria.AmbienteCompilacaoOO3;
import plp.orientadaObjetos3.memoria.AmbienteExecucaoOO3;
import plp.orientadaObjetos3.memoria.DefModulo;

public class DecModulo implements Declaracao {
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

	public boolean checaTipo(AmbienteCompilacaoOO1 ambiente)
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
			ProcedimentoJaDeclaradoException,
			ProcedimentoNaoDeclaradoException, ClasseJaDeclaradaException,
			ClasseNaoDeclaradaException {

		boolean ret = false;

		DefModulo defModulo = new DefModulo(id, decConstantes, decProcedimento);
		((AmbienteCompilacaoOO3) ambiente).mapDefModulo(id, defModulo);

		ambiente.incrementa();
		
		if (decConstantes != null) {
			ret = decConstantes.checaTipo(ambiente);
		} else {
			ret = true;
		}

		if (ret && decProcedimento != null) {
			ret = decProcedimento.checaTipo(ambiente);
		}
		
		ambiente.restaura();

		return ret;
	}

	public AmbienteExecucaoOO3 elabora(AmbienteExecucaoOO1 ambiente)
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
			ProcedimentoJaDeclaradoException,
			ProcedimentoNaoDeclaradoException, ClasseJaDeclaradaException,
			ObjetoNaoDeclaradoException, ObjetoJaDeclaradoException {

		// TODO Auto-generated method stub
		return (AmbienteExecucaoOO3) ambiente;
	}
}
