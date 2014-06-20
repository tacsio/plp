package plp.orientadaObjetos3.declaracao.classe;

import java.util.List;
import java.util.Map;

import plp.expressions2.memory.VariavelJaDeclaradaException;
import plp.expressions2.memory.VariavelNaoDeclaradaException;
import plp.orientadaObjetos1.declaracao.procedimento.DecProcedimento;
import plp.orientadaObjetos1.declaracao.variavel.DecVariavel;
import plp.orientadaObjetos1.excecao.declaracao.ClasseJaDeclaradaException;
import plp.orientadaObjetos1.excecao.declaracao.ClasseNaoDeclaradaException;
import plp.orientadaObjetos1.excecao.declaracao.ProcedimentoJaDeclaradoException;
import plp.orientadaObjetos1.excecao.declaracao.ProcedimentoNaoDeclaradoException;
import plp.orientadaObjetos1.expressao.leftExpression.Id;
import plp.orientadaObjetos1.util.TipoClasse;
import plp.orientadaObjetos2.declaracao.ConstrutorNaoDeclaradoException;
import plp.orientadaObjetos2.declaracao.DecConstrutor;
import plp.orientadaObjetos2.declaracao.classe.DecClasseSimplesOO2;
import plp.orientadaObjetos2.memoria.AmbienteCompilacaoOO2;
import plp.orientadaObjetos2.memoria.AmbienteExecucaoOO2;
import plp.orientadaObjetos3.declaracao.constante.Constante;
import plp.orientadaObjetos3.excecao.declaracao.ModuloNaoDeclaradoException;
import plp.orientadaObjetos3.memoria.AmbienteCompilacaoOO3;
import plp.orientadaObjetos3.memoria.AmbienteExecucaoOO3;
import plp.orientadaObjetos3.memoria.DefClasseOO3;
import plp.orientadaObjetos3.modulo.ListaId;
import plp.orientadaObjetos3.modulo.UsaModulo;

public class DecClasseSimplesOO3 extends DecClasseSimplesOO2 {

	protected ListaId listaInclude;
	protected ListaId listaExtends;

	// XXX: estes atributos deveriam ser protected no DecClasseSimplesOO2
	protected Id nomeSuperClasse;
	protected DecConstrutor construtor;

	public DecClasseSimplesOO3(Id nomeClasse, Id nomeSuperClasse,
			UsaModulo usaModulo, DecVariavel atributos,
			DecConstrutor construtor, DecProcedimento metodos) {
		super(nomeClasse, nomeSuperClasse, atributos, construtor, metodos);

		// XXX: estes atributos deveriam ser protected no DecClasseSimplesOO2
		this.nomeSuperClasse = nomeSuperClasse;
		this.construtor = construtor;

		this.listaExtends = usaModulo.getListaExtends();
		this.listaInclude = usaModulo.getListaInclude();
	}

	public boolean checaTipo(AmbienteCompilacaoOO2 ambiente)
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
			ClasseJaDeclaradaException, ClasseNaoDeclaradaException,
			ProcedimentoNaoDeclaradoException,
			ProcedimentoJaDeclaradoException, ConstrutorNaoDeclaradoException {

		// Verifica se a super classe ja foi declarada
		if (nomeSuperClasse != null) {
			ambiente.mapSuperClasse(nomeClasse, nomeSuperClasse);
		}

		DefClasseOO3 defClass = new DefClasseOO3(nomeClasse, nomeSuperClasse,
				atributos, construtor, metodos, listaInclude, listaExtends);

		// Adiciona a classe no mapeameento de classes
		ambiente.mapDefClasse(nomeClasse, defClass);

		boolean resposta = false;

		// chega tipo dos modulos inclusos
		checaTipoListaModulo((AmbienteCompilacaoOO3) ambiente, defClass);

		ambiente.incrementa();

		DecVariavel atr = (DecVariavel) this.atributos;
		if (atr.checaTipo(ambiente)) {
			ambiente.map(new Id("this"), new TipoClasse(nomeClasse));

			if (nomeSuperClasse != null) {
				this
						.checaTipoVariaveisClasseMae(ambiente,
								this.nomeSuperClasse);
			}
			resposta = metodos.checaTipo(ambiente);
		}

		// Verifica se construtor esta declarado corretamente
		resposta = resposta && construtor.checaTipo(ambiente);

		ambiente.restaura();

		return resposta;
	}

	private void checaTipoListaModulo(AmbienteCompilacaoOO3 ambiente,
			DefClasseOO3 defClass) throws ModuloNaoDeclaradoException {

		ListaId included = defClass.getListaInclude();
		ListaId extended = defClass.getListaExtends();

		for (Id id : included) {
			if (ambiente.getDefModulo(id) == null) {
				throw new ModuloNaoDeclaradoException(id);
			} else {
				Map<Id, Constante> constantes = ambiente.getDefModulo(id)
						.getDecConstantes().getListaConstantes();
				
				defClass.addConstantes(constantes);
			}
		}

		for (Id id : extended) {
			if (ambiente.getDefModulo(id) == null) {
				throw new ModuloNaoDeclaradoException(id);
			} else {
				//FIXME: ajuste constantes de classe
				ambiente.getDefModulo(id).getDecConstantes()
						.checaTipo(ambiente);
			}
		}
	}

	public AmbienteExecucaoOO3 elabora(AmbienteExecucaoOO2 ambiente)
			throws ClasseJaDeclaradaException, ClasseNaoDeclaradaException,
			ConstrutorNaoDeclaradoException {

		DefClasseOO3 defClass = new DefClasseOO3(nomeClasse, nomeSuperClasse,
				atributos, construtor, metodos, listaInclude, listaExtends);
		// Adiciona a classe no mapeamento de classes
		ambiente.mapDefClasse(nomeClasse, defClass);

		// Verifica se a super classe ja foi declarada
		if (nomeSuperClasse != null) {
			ambiente.mapSuperClasse(nomeClasse, nomeSuperClasse);
		}

		// elabora constantes de modulos
		elaboraListaModulo((AmbienteExecucaoOO3) ambiente, defClass);

		return (AmbienteExecucaoOO3) ambiente;
	}

	private void elaboraListaModulo(AmbienteExecucaoOO3 ambiente,
			DefClasseOO3 defClass) throws ModuloNaoDeclaradoException {

		ListaId included = defClass.getListaInclude();
		ListaId extended = defClass.getListaExtends();

		for (Id id : included) {
			if (ambiente.getDefModulo(id) == null) {
				throw new ModuloNaoDeclaradoException(id);
			} else {
				ambiente.getDefModulo(id).getDecConstantes().elabora(ambiente);
			}
		}

		for (Id id : extended) {
			if (ambiente.getDefModulo(id) == null) {
				throw new ModuloNaoDeclaradoException(id);
			} else {
				ambiente.getDefModulo(id).getDecConstantes().elabora(ambiente);
			}
		}
	}

	public String toString() {
		StringBuffer retorno = new StringBuffer();
		retorno.append(this.nomeClasse);
		retorno.append("\n");

		retorno.append("Included modules:");
		retorno.append("[");
		retorno.append(this.listaInclude);
		retorno.append("]\n");

		retorno.append("Extends modules:");
		retorno.append("[");
		retorno.append(this.listaExtends);
		retorno.append("]\n");
		retorno.append("\n");

		return retorno.toString();
	}

	private void checaTipoVariaveisClasseMae(AmbienteCompilacaoOO2 ambiente,
			Id nomeSuperClasse) throws ClasseNaoDeclaradaException,
			VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
			ClasseJaDeclaradaException {
		if (nomeSuperClasse != null) {
			DefClasseOO3 defClasseMae = (DefClasseOO3) ambiente
					.getDefClasse(nomeSuperClasse);
			defClasseMae.getDecVariavel().checaTipo(ambiente);
			this.checaTipoVariaveisClasseMae(ambiente, defClasseMae
					.getNomeSuperClasse());
		}
	}
}
