package plp.orientadaObjetos3.declaracao;

import java.util.ArrayList;
import java.util.List;

import plp.expressions2.memory.VariavelJaDeclaradaException;
import plp.expressions2.memory.VariavelNaoDeclaradaException;
import plp.imperative1.util.Lista;
import plp.orientadaObjetos1.declaracao.Declaracao;
import plp.orientadaObjetos1.declaracao.classe.DecClasse;
import plp.orientadaObjetos1.excecao.declaracao.ClasseJaDeclaradaException;
import plp.orientadaObjetos1.excecao.declaracao.ClasseNaoDeclaradaException;
import plp.orientadaObjetos1.excecao.declaracao.ObjetoJaDeclaradoException;
import plp.orientadaObjetos1.excecao.declaracao.ObjetoNaoDeclaradoException;
import plp.orientadaObjetos1.excecao.declaracao.ProcedimentoJaDeclaradoException;
import plp.orientadaObjetos1.excecao.declaracao.ProcedimentoNaoDeclaradoException;
import plp.orientadaObjetos1.memoria.DefClasse;
import plp.orientadaObjetos2.declaracao.ConstrutorNaoDeclaradoException;
import plp.orientadaObjetos3.declaracao.classe.DecClasseSimplesOO3;
import plp.orientadaObjetos3.declaracao.modulo.DecModulo;
import plp.orientadaObjetos3.excecao.declaracao.ModuloJaDeclaradoException;
import plp.orientadaObjetos3.memoria.AmbienteCompilacaoOO3;
import plp.orientadaObjetos3.memoria.AmbienteExecucaoOO3;

public class ListaDeclaracaoOO3 extends Lista<Declaracao> {

	private List<DecModulo> modulos = new ArrayList<DecModulo>();

	public ListaDeclaracaoOO3() {
		super();
	}

	public ListaDeclaracaoOO3(DecModulo decModulo) {
		super(decModulo, new ListaDeclaracaoOO3());
		modulos.add(decModulo);
	}

	public ListaDeclaracaoOO3(DecClasse decClasse) {
		super(decClasse, new ListaDeclaracaoOO3());
	}

	public ListaDeclaracaoOO3(DecClasse decClasse, ListaDeclaracaoOO3 lista) {
		super(decClasse, lista);
		this.modulos.addAll(lista.getModulos());
	}

	public ListaDeclaracaoOO3(DecModulo decModulo, ListaDeclaracaoOO3 lista) {
		super(decModulo, lista);
		this.modulos.add(decModulo);
		this.modulos.addAll(lista.getModulos());
	}

	public boolean checaTipo(AmbienteCompilacaoOO3 ambiente)
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
			ClasseJaDeclaradaException, ProcedimentoNaoDeclaradoException,
			ProcedimentoJaDeclaradoException, ConstrutorNaoDeclaradoException,
			ModuloJaDeclaradoException, ClasseNaoDeclaradaException {

		//armazena definicoes das classes antes de checar e um tipo
		storeDefClasses(ambiente);
		
		boolean ret = false;
		Declaracao declaracao = getHead();

		if (declaracao instanceof DecClasse) {
			DecClasseSimplesOO3 classe = (DecClasseSimplesOO3) declaracao;
			ret = classe.checaTipo(ambiente);
		} else if (declaracao instanceof DecModulo) {
			DecModulo modulo = (DecModulo) declaracao;
			ret = modulo.checaTipo(ambiente);
		}

		// passo recursivo
		if (ret && length() > 1) {
			ret = ((ListaDeclaracaoOO3) getTail()).checaTipo(ambiente);
		}

		return ret;

	}
	
	private void storeDefClasses(AmbienteCompilacaoOO3 ambiente){
		Declaracao declaracao = getHead();

		if (declaracao instanceof DecClasse) {
			DecClasseSimplesOO3 classe = (DecClasseSimplesOO3) declaracao;
			DefClasse def = classe.getDefClasse();
			ambiente.mapDefClassTemporario(def.getIdClasse(), def);
		}

		// passo recursivo
		if (length() > 1) {
			((ListaDeclaracaoOO3) getTail()).storeDefClasses(ambiente);
		}
		
	}

	public AmbienteExecucaoOO3 elabora(AmbienteExecucaoOO3 ambiente)
			throws VariavelJaDeclaradaException, VariavelNaoDeclaradaException,
			ProcedimentoJaDeclaradoException,
			ProcedimentoNaoDeclaradoException, ClasseJaDeclaradaException,
			ObjetoNaoDeclaradoException, ObjetoJaDeclaradoException,
			ConstrutorNaoDeclaradoException, ClasseNaoDeclaradaException {

		Declaracao declaracao = getHead();

		if (declaracao instanceof DecClasse) {
			DecClasseSimplesOO3 classe = (DecClasseSimplesOO3) declaracao;
			ambiente = classe.elabora(ambiente);
		} else if (declaracao instanceof DecModulo) {
			DecModulo modulo = (DecModulo) declaracao;
			ambiente = (AmbienteExecucaoOO3) modulo.elabora(ambiente);
		}

		// passo recursivo
		if (length() > 1) {
			ambiente = ((ListaDeclaracaoOO3) getTail()).elabora(ambiente);
		}

		return ambiente;
	}

	public List<DecModulo> getModulos() {
		return modulos;
	}

	public void printDeclaracoes() {
		System.out.println();
		System.out.println();
		System.out.println("Modulos declarados:");
		for (DecModulo decModulo : modulos) {
			System.out.println("Name: " + decModulo.getId());
			// System.out.println("Constantes: "
			// + decModulo.getDecConstantes().count());
		}
		System.out.println();

		System.out.println("Declaracoes de classes:");
		System.out.println(this.toString());

		System.out.println();
		System.out.println();
	}

}
