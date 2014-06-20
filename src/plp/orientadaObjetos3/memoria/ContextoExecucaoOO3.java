package plp.orientadaObjetos3.memoria;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import plp.expressions2.memory.IdentificadorJaDeclaradoException;
import plp.expressions2.memory.VariavelNaoDeclaradaException;
import plp.orientadaObjetos1.expressao.leftExpression.Id;
import plp.orientadaObjetos1.expressao.valor.Valor;
import plp.orientadaObjetos2.memoria.ContextoExecucaoOO2;

public class ContextoExecucaoOO3 extends ContextoExecucaoOO2 implements
		AmbienteExecucaoOO3 {

	private Map<Id, DefModulo> mapDefModulo;

	private Stack<HashMap<Id, Valor>> pilhaConstantes;

	public ContextoExecucaoOO3() {
		super();
		this.mapDefModulo = new HashMap<Id, DefModulo>();
		this.pilhaConstantes = new Stack<HashMap<Id, Valor>>();
	}

	public ContextoExecucaoOO3(AmbienteExecucaoOO3 ambiente) {
		super(ambiente);
		this.mapDefModulo = ambiente.getMapDefModulo();
		this.pilhaConstantes = ambiente.getPilhaConstantes();
	}

	public void mapDefModulo(Id id, DefModulo defModulo) {
		this.mapDefModulo.put(id, defModulo);
	}

	public void mapConstantes(Id id, Valor valor)
			throws IdentificadorJaDeclaradoException {
		HashMap<Id, Valor> aux = pilhaConstantes.peek();

		if (aux.put(id, valor) != null) {
			throw new IdentificadorJaDeclaradoException("Constante " + id
					+ " já declarada");
		}
	}

	@Override
	public void incrementa() {
		super.incrementa();
		this.pilhaConstantes.push(new HashMap<Id, Valor>());
	}

	@Override
	public void restaura() {
		super.restaura();
		this.pilhaConstantes.pop();
	}

	@Override
	public Valor get(plp.expressions2.expression.Id idArg)
			throws VariavelNaoDeclaradaException {

		Valor valor = null;

		try {
			valor = super.get(idArg);
		} catch (VariavelNaoDeclaradaException e) {

			// TODO: extrair metodo
			Stack<HashMap<Id, Valor>> auxStack = new Stack<HashMap<Id, Valor>>();
			while (valor == null && !pilhaConstantes.empty()) {
				HashMap<Id, Valor> aux = pilhaConstantes.pop();
				auxStack.push(aux);
				valor = aux.get(idArg);
			}
			while (!auxStack.empty()) {
				pilhaConstantes.push(auxStack.pop());
			}
			if (valor == null) {
				throw new VariavelNaoDeclaradaException(idArg);
			}
		}

		return valor;
	}

	public DefModulo getDefModulo(Id id) {
		DefModulo retorno = null;

		if (this.mapDefModulo.containsKey(id)) {
			retorno = mapDefModulo.get(id);
		}

		return retorno;
	}

	public Map<Id, DefModulo> getMapDefModulo() {
		return mapDefModulo;
	}

	public Stack<HashMap<Id, Valor>> getPilhaConstantes() {
		return pilhaConstantes;
	}

}
