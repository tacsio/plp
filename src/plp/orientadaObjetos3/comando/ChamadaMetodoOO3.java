package plp.orientadaObjetos3.comando;

import plp.expressions2.memory.Ambiente;
import plp.expressions2.memory.VariavelJaDeclaradaException;
import plp.expressions2.memory.VariavelNaoDeclaradaException;
import plp.orientadaObjetos1.comando.ChamadaProcedimento;
import plp.orientadaObjetos1.comando.Procedimento;
import plp.orientadaObjetos1.excecao.declaracao.ClasseJaDeclaradaException;
import plp.orientadaObjetos1.excecao.declaracao.ClasseNaoDeclaradaException;
import plp.orientadaObjetos1.excecao.declaracao.ObjetoJaDeclaradoException;
import plp.orientadaObjetos1.excecao.declaracao.ObjetoNaoDeclaradoException;
import plp.orientadaObjetos1.excecao.declaracao.ProcedimentoJaDeclaradoException;
import plp.orientadaObjetos1.excecao.declaracao.ProcedimentoNaoDeclaradoException;
import plp.orientadaObjetos1.excecao.execucao.EntradaInvalidaException;
import plp.orientadaObjetos1.expressao.Expressao;
import plp.orientadaObjetos1.expressao.ListaExpressao;
import plp.orientadaObjetos1.expressao.leftExpression.Id;
import plp.orientadaObjetos1.expressao.valor.ValorRef;
import plp.orientadaObjetos1.memoria.AmbienteCompilacaoOO1;
import plp.orientadaObjetos1.memoria.AmbienteExecucaoOO1;
import plp.orientadaObjetos1.memoria.DefClasse;
import plp.orientadaObjetos1.memoria.Objeto;
import plp.orientadaObjetos1.memoria.colecao.ListaValor;
import plp.orientadaObjetos1.util.Tipo;
import plp.orientadaObjetos2.comando.ChamadaMetodoOO2;
import plp.orientadaObjetos3.memoria.AmbienteCompilacaoOO3;
import plp.orientadaObjetos3.memoria.AmbienteExecucaoOO3;
import plp.orientadaObjetos3.memoria.ContextoExecucaoOO3;
import plp.orientadaObjetos3.memoria.DefClasseOO3;
import plp.orientadaObjetos3.memoria.DefModulo;

public class ChamadaMetodoOO3 extends ChamadaMetodoOO2 {

	public ChamadaMetodoOO3(Expressao expressao, Id nomeMetodo,
			ListaExpressao parametrosReais) {
		super(expressao, nomeMetodo, parametrosReais);
	}

	private Procedimento getProcedimentoHierarquia(Ambiente ambiente,
			DefClasseOO3 defClasse, Id nomeMetodo)
			throws ClasseNaoDeclaradaException,
			ProcedimentoNaoDeclaradoException {
		Procedimento metodo = null;

		try {
			// tenta buscar o metodo na propria classe;
			metodo = defClasse.getMetodo(nomeMetodo);
		} catch (ProcedimentoNaoDeclaradoException e) {
			try {
				// tenta buscar o metodo no modulo;
				metodo = buscaHierarquiaModuloInclude(ambiente, defClasse,
						nomeMetodo);
				
				// tenta buscar o metodo na superclasse;
			} catch (ProcedimentoNaoDeclaradoException e2) {
				metodo = buscaHierarquiaSuperclasse(ambiente, defClasse,
						nomeMetodo, metodo);
			}
		}
		if (metodo == null) {
			throw new ProcedimentoNaoDeclaradoException(nomeMetodo);
		}
		return metodo;
	}

	private Procedimento buscaHierarquiaSuperclasse(Ambiente ambiente,
			DefClasseOO3 defClasse, Id nomeMetodo, Procedimento metodo)
			throws ClasseNaoDeclaradaException,
			ProcedimentoNaoDeclaradoException {

		if (defClasse.getNomeSuperClasse() != null) {
			if (ambiente instanceof AmbienteCompilacaoOO1) {
				AmbienteCompilacaoOO1 ambienteCompilacao = (AmbienteCompilacaoOO1) ambiente;
				DefClasseOO3 defClasseMae = (DefClasseOO3) ambienteCompilacao
						.getDefClasse(defClasse.getNomeSuperClasse());
				metodo = this.getProcedimentoHierarquia(ambiente, defClasseMae,
						nomeMetodo);
			} else if (ambiente instanceof AmbienteExecucaoOO1) {
				AmbienteExecucaoOO1 ambienteExecucao = (AmbienteExecucaoOO1) ambiente;
				DefClasseOO3 defClasseMae = (DefClasseOO3) ambienteExecucao
						.getDefClasse(defClasse.getNomeSuperClasse());
				metodo = this.getProcedimentoHierarquia(ambiente, defClasseMae,
						nomeMetodo);
			}
		}
		return metodo;
	}

	public Procedimento buscaHierarquiaModuloInclude(Ambiente ambiente,
			DefClasseOO3 defClasse, Id nomeMetodo)
			throws ProcedimentoNaoDeclaradoException {

		Procedimento metodo = null;

		for (Id id : defClasse.getListaInclude()) {

			if (ambiente instanceof AmbienteCompilacaoOO3) {
				DefModulo modulo = ((AmbienteCompilacaoOO3) ambiente)
						.getDefModulo(id);
				if (modulo != null) {
					try {
						metodo = modulo.getProcedimento(nomeMetodo);
						return metodo;
					} catch (ProcedimentoNaoDeclaradoException e) {
						continue;
					}
				}

			} else if (ambiente instanceof AmbienteExecucaoOO1) {
				DefModulo modulo = ((AmbienteExecucaoOO3) ambiente)
						.getDefModulo(id);
				if (modulo != null) {
					try {
						metodo = modulo.getProcedimento(nomeMetodo);
						return metodo;
					} catch (ProcedimentoNaoDeclaradoException e) {
						continue;
					}
				}
			}
		}

		if(metodo == null){
			throw new ProcedimentoNaoDeclaradoException(nomeMetodo);
		}
		
		return metodo;
	}

	public AmbienteExecucaoOO3 executar(AmbienteExecucaoOO1 ambiente)
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
			ProcedimentoNaoDeclaradoException,
			ProcedimentoJaDeclaradoException, ObjetoJaDeclaradoException,
			ObjetoNaoDeclaradoException, ClasseNaoDeclaradaException,
			ClasseJaDeclaradaException, EntradaInvalidaException {

		ValorRef vr = (ValorRef) expressao.avaliar(ambiente); // recupera o id
		// do objeto
		Objeto objeto = ambiente.getObjeto(vr); // recupera o objeto
		Id idClasse = objeto.getClasse(); // recupera o tipo do objeto
		DefClasse defClasse = ambiente
				.getDefClasse((plp.expressions2.expression.Id) idClasse);
		// recupera
		// a
		// definicaoo
		// da
		// classe
		Procedimento metodo = this.getProcedimentoHierarquia(ambiente,
				(DefClasseOO3) defClasse, nomeMetodo);

		// cria um novo ambiente para a execucao, pois
		// nao deve levar em conta as variaveis definidas na main
		AmbienteExecucaoOO3 aux = new ContextoExecucaoOO3((AmbienteExecucaoOO3) ambiente);
		// a change pois no construtor do ambiente

		// invocado na linha anterior ja eh feitoum mapeamento
		aux.changeValor(new Id("this"), vr);

		ListaValor valoresDosParametros = parametrosReais.avaliar(ambiente);
		new ChamadaProcedimento(metodo, parametrosReais, valoresDosParametros)
				.executar(aux);
		
		return (AmbienteExecucaoOO3) ambiente;
	}

	public boolean checaTipo(AmbienteCompilacaoOO1 ambiente)
			throws VariavelNaoDeclaradaException, VariavelJaDeclaradaException,
			ClasseNaoDeclaradaException {

		boolean resposta;

		Tipo tipoClasse = expressao.getTipo(ambiente);
		DefClasse defClasse = ambiente.getDefClasse(tipoClasse.getTipo());
		try {
			Procedimento metodo = this.getProcedimentoHierarquia(ambiente,
					(DefClasseOO3) defClasse, nomeMetodo);
			ambiente.incrementa();
			ambiente.map(new Id("this"), tipoClasse);
			resposta = new ChamadaProcedimento(metodo, parametrosReais)
					.checaTipo(ambiente);
			ambiente.restaura();
		} catch (ProcedimentoNaoDeclaradoException e) {
			resposta = false;
		}
		return resposta;
	}

}
