package plp.expressions1.expression;

import plp.expressions1.util.Tipo;
import plp.expressions1.util.TipoPrimitivo;

public class ExpExp extends ExpBinaria {

	public ExpExp(Expressao esq, Expressao dir) {
		super(esq, dir, "^");
		// TODO Auto-generated constructor stub
	}

	public Valor avaliar() {
		// TODO Auto-generated method stub
		return new ValorReal( Math.pow(((ValorReal)getEsq().avaliar()).valor(), 
				((ValorReal)getDir().avaliar()).valor()));
	}

	public Tipo getTipo() {
		// TODO Auto-generated method stub
		return TipoPrimitivo.REAL;
	}

	@Override
	protected boolean checaTipoElementoTerminal() {
		// TODO Auto-generated method stub
		return (getEsq().getTipo().eReal() && getDir().getTipo().eReal());
	}

}
