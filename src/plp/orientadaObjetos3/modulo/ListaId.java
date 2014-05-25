package plp.orientadaObjetos3.modulo;

import plp.imperative1.util.Lista;
import plp.orientadaObjetos1.expressao.leftExpression.Id;

public class ListaId extends Lista<Id>{

	public ListaId(Id valor) {
		super(valor, null);
	}
	public ListaId(Id valor, ListaId lista){
		super(valor, lista);
	}
}
