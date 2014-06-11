package plp.orientadaObjetos3.memoria;

import plp.orientadaObjetos1.expressao.leftExpression.Id;
import plp.orientadaObjetos1.expressao.valor.Valor;
import plp.orientadaObjetos1.util.Tipo;

public class DefConstante {

	private Id id;
	private Tipo tipo;
	private Valor valor;

	public DefConstante(Id id, Tipo tipo, Valor valor) {
		this.id = id;
		this.tipo = tipo;
		this.valor = valor;
	}
	
	public Id getId() {
		return id;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public Valor getValor() {
		return valor;
	}
}
