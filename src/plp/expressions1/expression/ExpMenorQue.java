package plp.expressions1.expression;

import plp.expressions1.util.Tipo;
import plp.expressions1.util.TipoPrimitivo;

public class ExpMenorQue extends ExpBinaria {

	public ExpMenorQue(Expressao esq, Expressao dir) {
		super(esq, dir, "<");
		// TODO Auto-generated constructor stub
	}

	public Valor avaliar() {
		// TODO Auto-generated method stub
		return new ValorBooleano( ((ValorInteiro)getEsq()).valor() 
				< ((ValorInteiro)getDir()).valor() ) ;
	}

	public Tipo getTipo() {
		// TODO Auto-generated method stub
		return TipoPrimitivo.BOOLEANO;
	}

	@Override
	protected boolean checaTipoElementoTerminal() {
		// TODO Auto-generated method stub
		return ( getEsq().getTipo().eInteiro() 
				&& getEsq().getTipo().eInteiro() );
	}

}
