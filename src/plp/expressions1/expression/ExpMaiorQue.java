package plp.expressions1.expression;

import plp.expressions1.util.Tipo;
import plp.expressions1.util.TipoPrimitivo;

public class ExpMaiorQue extends ExpBinaria {

	public ExpMaiorQue(Expressao esq, Expressao dir) {
		super(esq, dir, ">");
		// TODO Auto-generated constructor stub
	}

	public Valor avaliar() {
		// TODO Auto-generated method stub
		return new ValorBooleano ( ((ValorInteiro)getEsq().avaliar()).valor() 
				> ((ValorInteiro)getDir().avaliar()).valor() );
	}

	public Tipo getTipo() {
		// TODO Auto-generated method stub
		return TipoPrimitivo.INTEIRO;
	}

	@Override
	protected boolean checaTipoElementoTerminal() {
		// TODO Auto-generated method stub
		return (getEsq().getTipo().eInteiro() && getDir().getTipo().eInteiro());
	}
	

}
