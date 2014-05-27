package plp.orientadaObjetos3.modulo;

import java.util.HashSet;
import java.util.Iterator;

import plp.orientadaObjetos1.expressao.leftExpression.Id;

public class ListaId extends HashSet<Id> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2479577085391204540L;

	public ListaId() {
		super();
	}

	public ListaId(Id valor) {
		super();
		this.add(valor);
	}

	public ListaId(Id valor, ListaId lista) {
		super();
		this.add(valor);
		this.addAll(lista);
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();

		Iterator<Id> it = this.iterator();
		boolean first = true;
		while (it.hasNext()) {
			if (first) {
				buffer.append(it.next());
				first = false;
			} else
				buffer.append(", " + it.next());
		}
		return buffer.toString();
	}
}
