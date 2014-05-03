package plp.expressions1.expression;

import plp.expressions1.util.Tipo;
import plp.expressions1.util.TipoPrimitivo;

public class ValorChar extends ValorConcreto<Character> {
	
/**
 * ValorChar - Construtor da subclasse.
 * @param valor
 */
public ValorChar(Character valor) {
		super(valor);
		// TODO Auto-generated constructor stub
	}

/* (non-Javadoc)
 * @see plp.expressions1.expression.Expressao#getTipo()
 */
public Tipo getTipo() {
	// TODO Auto-generated method stub
	return TipoPrimitivo.CHAR;
}

}
