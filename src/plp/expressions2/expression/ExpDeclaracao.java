package plp.expressions2.expression;

import java.util.ArrayList;
import java.util.List;

import plp.expressions1.util.Tipo;
import plp.expressions2.declaration.DecVariavel;
import plp.expressions2.memory.AmbienteCompilacao;
import plp.expressions2.memory.AmbienteExecucao;
import plp.expressions2.memory.VariavelJaDeclaradaException;
import plp.expressions2.memory.VariavelNaoDeclaradaException;

public class ExpDeclaracao implements Expressao {

	private List<DecVariavel> seqdecVariavel;
	private Expressao expressao;

	public ExpDeclaracao(List<DecVariavel> declarations, Expressao expressaoArg) {
		seqdecVariavel = declarations;
		expressao = expressaoArg;
	}

	public Valor avaliar(AmbienteExecucao ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {

		ambiente.incrementa();
		resolveValueBindings(ambiente);
		Valor result = expressao.avaliar(ambiente);
		ambiente.restaura();

		return result;
	}

	private void includeValueBinding(AmbienteExecucao ambiente,DecVariavel declaration) 
		throws VariavelJaDeclaradaException {
	
		Id id = declaration.getId();
		Valor valor = declaration.getExpressao().avaliar(ambiente);
		ambiente.map(id, valor);
	}

	private void resolveValueBindings(AmbienteExecucao ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {

		for (DecVariavel declaration : this.seqdecVariavel) {
			includeValueBinding(ambiente, declaration);
		}
	}

	/**
	 * Realiza a verificacao de tipos desta expressao.
	 * 
	 * @param amb
	 *            o ambiente de compilação.
	 * @return <code>true</code> se os tipos da expressao sao validos;
	 *         <code>false</code> caso contrario.
	 * @exception VariavelNaoDeclaradaException
	 *                se existir um identificador nao declarado no ambiente.
	 * @exception VariavelNaoDeclaradaException
	 *                se existir um identificador declarado mais de uma vez no
	 *                mesmo bloco do ambiente.
	 */
	public boolean checaTipo(AmbienteCompilacao ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		ambiente.incrementa();
		boolean result = false;
		try {
			if (this.checkTypeBindings(ambiente)) {
				result = expressao.checaTipo(ambiente);
			} else {
				result = false;
			}
		} finally {
			ambiente.restaura();
		}
		return result;
	}


	private void resolveTypeBindings(AmbienteCompilacao ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {

		//sequential let
		for (DecVariavel declaration : this.seqdecVariavel) {
			Id id = declaration.getId();
			Tipo tipo = declaration.getExpressao().getTipo(ambiente);
			ambiente.map(id, tipo);
		}
	}
	
	private void resolveTypeBinding(AmbienteCompilacao ambiente, DecVariavel declaration) {
		Id id = declaration.getId();
		Tipo tipo = declaration.getExpressao().getTipo(ambiente);
		ambiente.map(id, tipo);
	}

	private boolean checkTypeBindings(AmbienteCompilacao ambiente)
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException {

		boolean result = true;

		for (DecVariavel declaration : this.seqdecVariavel) {
			if (!declaration.getExpressao().checaTipo(ambiente)) {
				result = false;
				break;
			}
			resolveTypeBinding(ambiente, declaration);
		}
		return result;
	}

	/**
	 * Retorna os tipos possiveis desta expressao.
	 * 
	 * @param amb
	 *            o ambiente de compilação.
	 * @return os tipos possiveis desta expressao.
	 * @exception VariavelNaoDeclaradaException
	 *                se existir um identificador nao declarado no ambiente.
	 * @exception VariavelNaoDeclaradaException
	 *                se existir um identificador declarado mais de uma vez no
	 *                mesmo bloco do ambiente.
	 */
	public Tipo getTipo(AmbienteCompilacao ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException {
		ambiente.incrementa();

		this.resolveTypeBindings(ambiente);
		Tipo result = expressao.getTipo(ambiente);

		ambiente.restaura();
		return result;
	}

	public Expressao reduzir(AmbienteExecucao ambiente) {
		ambiente.incrementa();
		
		for(DecVariavel dec : this.seqdecVariavel){
			ambiente.map(dec.getId(), null);
		}
		this.expressao = expressao.reduzir(ambiente);
		
		ambiente.restaura();
		
		return this;
	}

	public ExpDeclaracao clone(){
		ExpDeclaracao retorno;		
		List<DecVariavel> novaLista = new ArrayList<DecVariavel>(this.seqdecVariavel.size());
		
		for (DecVariavel dec : this.seqdecVariavel){
			novaLista.add(new DecVariavel(dec.getId().clone(), dec.getExpressao().clone()));
		}
		
		retorno = new ExpDeclaracao(novaLista, this.expressao.clone());
		
		return retorno;
	}
}