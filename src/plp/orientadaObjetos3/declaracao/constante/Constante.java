package plp.orientadaObjetos3.declaracao.constante;

import plp.orientadaObjetos1.expressao.leftExpression.Id;
import plp.orientadaObjetos1.expressao.valor.Valor;
import plp.orientadaObjetos1.memoria.AmbienteCompilacaoOO1;
import plp.orientadaObjetos1.util.Tipo;
import plp.orientadaObjetos3.memoria.AmbienteCompilacaoOO3;
import plp.orientadaObjetos3.memoria.DefConstante;

public class Constante {
	private Id id;
	private Tipo tipo;
	private Valor valor;

	public Constante(Id id, Tipo tipo, Valor valor) {
		this.id = id;
		this.tipo = tipo;
		this.valor = valor;
	}

	public boolean checaTipo(AmbienteCompilacaoOO1 ambiente) {

		boolean ret = false;
		ret = valor.getTipo(ambiente).equals(tipo);
		
		if(ret){
			DefConstante defConstante = new DefConstante(id, tipo, valor);
			((AmbienteCompilacaoOO3) ambiente).mapConstantes(id, defConstante);
		}
		
		return ret;
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
