package plp.expressions1.expression;

import plp.expressions1.util.Tipo;
import plp.expressions1.util.TipoPrimitivo;

public class ExpCode extends ExpUnaria {

	public ExpCode(Expressao exp) {
		super(exp, "code");
		// TODO Auto-generated constructor stub
	}

	public Valor avaliar() {
		// TODO Auto-generated method stub
		// para gerar o codigo ASCII de um char basta fazer cast para int.
		//
		//Racioc�nio:
		//ExpUnaria   ex: length "abc", code 'a', etc. O getExp() desta classe retorna a Express�o que � o parametro.
		//    \
		//     Expressao   -> Neste caso a express�o � do tipo ValorConcreto. O m�todo avaliar() retorna o objeto.
		//		\
		//		O cast pra ValorChar funciona porque � subtipo de ValorConcreto.
		//		  \
		//	 	 O m�todo valor() de ValorChar � herdado de ValorConcreto, e retorna o valor seguindo o tipo gen�rico definido na classe. Neste caso, character!
		return new ValorInteiro(Integer.valueOf(((ValorChar)getExp().avaliar()).valor()));
		
	}

	public Tipo getTipo() {
		// TODO Auto-generated method stub
		return TipoPrimitivo.CHAR;
	}

	@Override
	protected boolean checaTipoElementoTerminal() {
		// TODO Auto-generated method stub
		return (this.getExp().getTipo().eChar());
	}

}
