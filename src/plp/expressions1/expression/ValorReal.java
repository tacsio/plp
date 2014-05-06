package plp.expressions1.expression;

import plp.expressions1.util.Tipo;
import plp.expressions1.util.TipoPrimitivo;

public class ValorReal extends ValorConcreto<Double> {

	public ValorReal(Double valor) {
		super(valor);
		// TODO Auto-generated constructor stub
	}

	public Tipo getTipo() {
		// TODO Auto-generated method stub
		return TipoPrimitivo.REAL;
	}

}
