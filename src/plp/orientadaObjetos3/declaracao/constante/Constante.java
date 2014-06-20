package plp.orientadaObjetos3.declaracao.constante;

import plp.orientadaObjetos1.expressao.leftExpression.Id;
import plp.orientadaObjetos1.expressao.valor.Valor;
import plp.orientadaObjetos1.memoria.AmbienteCompilacaoOO1;
import plp.orientadaObjetos1.util.Tipo;
import plp.orientadaObjetos3.memoria.AmbienteCompilacaoOO3;
import plp.orientadaObjetos3.memoria.AmbienteExecucaoOO3;

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

		if (ret) {
			((AmbienteCompilacaoOO3) ambiente).mapConstantes(id, tipo);
		}

		return ret;
	}

	public AmbienteExecucaoOO3 elabora(AmbienteExecucaoOO3 ambiente) {
		ambiente.mapConstantes(id, valor);

		return ambiente;
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
