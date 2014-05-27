package plp.orientadaObjetos3.declaracao.constante;

import plp.orientadaObjetos1.expressao.leftExpression.Id;
import plp.orientadaObjetos1.expressao.valor.Valor;
import plp.orientadaObjetos1.util.Tipo;

public class Constante {
	private Id id;
	private Tipo tipo;
	private Valor valor; 
	
	public Constante (Id id, Tipo tipo, Valor valor){
		this.id = id;
		this.tipo = tipo;
		this.valor = valor;
	}
}
