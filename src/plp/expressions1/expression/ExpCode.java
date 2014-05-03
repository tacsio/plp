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
		//Raciocínio:
		//ExpUnaria   ex: length "abc", code 'a', etc. O getExp() desta classe retorna a Expressão que é o parametro.
		//    \
		//     Expressao   -> Neste caso a expressão é do tipo ValorConcreto. O método avaliar() retorna o objeto.
		//		\
		//		O cast pra ValorChar funciona porque é subtipo de ValorConcreto.
		//		  \
		//	 	 O método valor() de ValorChar é herdado de ValorConcreto, e retorna o valor seguindo o tipo genérico definido na classe. Neste caso, character!
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
