package plp.orientadaObjetos3.comando;

import java.util.HashMap;
import java.util.List;

import plp.expressions2.memory.VariavelJaDeclaradaException;
import plp.expressions2.memory.VariavelNaoDeclaradaException;
import plp.orientadaObjetos1.comando.ChamadaProcedimento;
import plp.orientadaObjetos1.comando.New;
import plp.orientadaObjetos1.comando.Procedimento;
import plp.orientadaObjetos1.declaracao.variavel.DecVariavel;
import plp.orientadaObjetos1.excecao.declaracao.ClasseJaDeclaradaException;
import plp.orientadaObjetos1.excecao.declaracao.ClasseNaoDeclaradaException;
import plp.orientadaObjetos1.excecao.declaracao.ObjetoJaDeclaradoException;
import plp.orientadaObjetos1.excecao.declaracao.ObjetoNaoDeclaradoException;
import plp.orientadaObjetos1.excecao.declaracao.ProcedimentoJaDeclaradoException;
import plp.orientadaObjetos1.excecao.declaracao.ProcedimentoNaoDeclaradoException;
import plp.orientadaObjetos1.excecao.execucao.EntradaInvalidaException;
import plp.orientadaObjetos1.expressao.ListaExpressao;
import plp.orientadaObjetos1.expressao.leftExpression.Id;
import plp.orientadaObjetos1.expressao.leftExpression.LeftExpression;
import plp.orientadaObjetos1.expressao.valor.Valor;
import plp.orientadaObjetos1.expressao.valor.ValorRef;
import plp.orientadaObjetos1.memoria.AmbienteExecucaoOO1;
import plp.orientadaObjetos1.memoria.ContextoExecucaoOO1;
import plp.orientadaObjetos1.memoria.ContextoObjeto;
import plp.orientadaObjetos1.memoria.Objeto;
import plp.orientadaObjetos1.memoria.colecao.ListaValor;
import plp.orientadaObjetos2.memoria.AmbienteExecucaoOO2;
import plp.orientadaObjetos3.declaracao.constante.Constante;
import plp.orientadaObjetos3.excecao.declaracao.ModuloNaoDeclaradoException;
import plp.orientadaObjetos3.memoria.AmbienteExecucaoOO3;
import plp.orientadaObjetos3.memoria.ContextoExecucaoOO3;
import plp.orientadaObjetos3.memoria.DefClasseOO3;
import plp.orientadaObjetos3.modulo.ListaId;

public class NewOO3 extends New {

	private ListaExpressao parametrosReais;

	public NewOO3(LeftExpression av, Id classe, ListaExpressao parametrosReais) {
		super(av, classe);
		this.parametrosReais = parametrosReais;
	}

	private void extendsClasse(AmbienteExecucaoOO2 ambiente,
			DefClasseOO3 classe, Objeto objeto)
			throws ClasseNaoDeclaradaException, VariavelNaoDeclaradaException,
			VariavelJaDeclaradaException, ObjetoNaoDeclaradoException,
			ClasseJaDeclaradaException, ObjetoJaDeclaradoException {
		if (classe.getNomeSuperClasse() != null) {
			DefClasseOO3 classeMae = (DefClasseOO3) ambiente
					.getDefClasse(classe.getNomeSuperClasse());
			this.extendsClasse(ambiente, classeMae, objeto);
		}

		DecVariavel decVariavel = classe.getDecVariavel();
		AmbienteExecucaoOO1 aux = decVariavel.elabora(new ContextoExecucaoOO1(
				ambiente));
		HashMap<plp.expressions2.expression.Id, Valor> estadoObj = aux
				.getPilha().pop();

		for (plp.expressions2.expression.Id id : estadoObj.keySet()) {
			// Se a variavel nao havia sido declarada adicione
			if (!objeto.getEstado().containsKey(id)) {
				objeto.getEstado().put(id, estadoObj.get(id));
			}
		}
	}

	public AmbienteExecucaoOO3 executar(AmbienteExecucaoOO2 ambiente)
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
			ClasseJaDeclaradaException, ClasseNaoDeclaradaException,
			ObjetoJaDeclaradoException, ObjetoNaoDeclaradoException,
			ProcedimentoNaoDeclaradoException,
			ProcedimentoJaDeclaradoException, EntradaInvalidaException {

		// Inicializa elementos da classe
		super.executar(ambiente);

		// Recupera a definicao da classe
		DefClasseOO3 defClasse = (DefClasseOO3) ambiente
				.getDefClasse(getClasse());

		// Recupera o valor referencia
		ValorRef vr = (ValorRef) getAv().avaliar(ambiente);

		// elabora constantes dos modulos
		elaboraListaModulo((AmbienteExecucaoOO3) ambiente, defClasse, vr);

		// Extends classe mae
		if (defClasse.getNomeSuperClasse() != null) {
			DefClasseOO3 classeMae = (DefClasseOO3) ambiente
					.getDefClasse(defClasse.getNomeSuperClasse());

			this.extendsClasse(ambiente, classeMae, ambiente.getObjeto(vr));
		}

		Procedimento metodo = defClasse.getConstrutor().getProcedimento();
		AmbienteExecucaoOO3 aux = new ContextoExecucaoOO3(
				(AmbienteExecucaoOO3) ambiente);

		aux.changeValor(new Id("this"), vr);

		ListaValor valoresDosParametros = parametrosReais.avaliar(ambiente);
		new ChamadaProcedimento(metodo, parametrosReais, valoresDosParametros)
				.executar(aux);

		return (AmbienteExecucaoOO3) ambiente;
	}

	private void elaboraListaModulo(AmbienteExecucaoOO3 ambiente,
			DefClasseOO3 defClass, ValorRef vr)
			throws ModuloNaoDeclaradoException, ObjetoNaoDeclaradoException {

		ListaId included = defClass.getListaInclude();
		ListaId extended = defClass.getListaExtends();

		ContextoObjeto objeto = ambiente.getObjeto(vr).getEstado();

		for (Id id : included) {
			if (ambiente.getDefModulo(id) == null) {
				throw new ModuloNaoDeclaradoException(id);
			} else {
				elaboraConstantes(ambiente, objeto, id);
			}
		}

		for (Id id : extended) {
			if (ambiente.getDefModulo(id) == null) {
				throw new ModuloNaoDeclaradoException(id);
			} else {
				// FIXME: verifar
				elaboraConstantes(ambiente, objeto, id);
			}
		}
	}

	private void elaboraConstantes(AmbienteExecucaoOO3 ambiente,
			ContextoObjeto objeto, Id id) {

		List<Constante> constantes = ambiente.getDefModulo(id)
				.getDecConstantes().getListaConstantes();
		
		for(Constante constante : constantes){
			if(!objeto.containsKey(constante.getId())){
				objeto.put(constante.getId(),constante.getValor());
			}
		}
	}

}
