package plp.orientadaObjetos3.memoria;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import plp.expressions2.memory.IdentificadorJaDeclaradoException;
import plp.expressions2.memory.VariavelNaoDeclaradaException;
import plp.orientadaObjetos1.expressao.leftExpression.Id;
import plp.orientadaObjetos1.memoria.colecao.ListaValor;
import plp.orientadaObjetos1.util.Tipo;
import plp.orientadaObjetos2.memoria.ContextoCompilacaoOO2;
import plp.orientadaObjetos3.excecao.declaracao.ModuloJaDeclaradoException;

public class ContextoCompilacaoOO3 extends ContextoCompilacaoOO2 implements
		AmbienteCompilacaoOO3 {

	private Map<Id, DefModulo> mapDefModulo;

	private Stack<HashMap<Id, Tipo>> pilhaConstantes;

	public ContextoCompilacaoOO3(ListaValor entrada) {
		super(entrada);
		this.mapDefModulo = new HashMap<Id, DefModulo>();
		this.pilhaConstantes = new Stack<HashMap<Id, Tipo>>();
	}

	public void mapDefModulo(Id id, DefModulo defModulo)
			throws ModuloJaDeclaradoException {
		if (this.mapDefModulo.put(id, defModulo) != null) {
			throw new ModuloJaDeclaradoException(id);
		}
	}

	public void incrementa() {
		super.incrementa();
		this.pilhaConstantes.push(new HashMap<Id, Tipo>());
	}

	public void restaura() {
		super.restaura();
		pilhaConstantes.pop();
	}

	@Override
	public Tipo get(plp.expressions2.expression.Id idArg)
			throws VariavelNaoDeclaradaException {
		Tipo tipo = null;

		try {
			tipo = super.get(idArg);
		} catch (VariavelNaoDeclaradaException e) {

			// TODO: extrair metodo
			Stack<HashMap<Id, Tipo>> auxStack = new Stack<HashMap<Id, Tipo>>();
			while (tipo == null && !pilhaConstantes.empty()) {
				HashMap<Id, Tipo> aux = pilhaConstantes.pop();
				auxStack.push(aux);
				tipo = aux.get(idArg);
			}
			while (!auxStack.empty()) {
				pilhaConstantes.push(auxStack.pop());
			}
			if (tipo == null) {
				throw new VariavelNaoDeclaradaException(idArg);
			}
		}

		return tipo;

	}

	public void mapConstantes(Id id, Tipo tipo)
			throws IdentificadorJaDeclaradoException {
		HashMap<Id, Tipo> aux = pilhaConstantes.peek();

		if (aux.put(id, tipo) != null) {
			throw new IdentificadorJaDeclaradoException("Constante " + id
					+ " já declarada");
		}
	}

	public DefModulo getDefModulo(Id id) {
		DefModulo retorno = null;
		
		if (this.mapDefModulo.containsKey(id)) {
			retorno = mapDefModulo.get(id);
		}

		return retorno;
	}
}
