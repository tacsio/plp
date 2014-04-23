package plp.expressions1.util;

import static org.junit.Assert.*;

import org.junit.Test;


public class TestTipoPrimitivo {

	@Test
	public void testEBooleano() {
		assertTrue(TipoPrimitivo.BOOLEANO.eBooleano());
		assertFalse(TipoPrimitivo.BOOLEANO.eInteiro());
		assertFalse(TipoPrimitivo.BOOLEANO.eString());
	}

	@Test
	public void testEInteiro() {
		assertFalse(TipoPrimitivo.INTEIRO.eBooleano());
		assertTrue(TipoPrimitivo.INTEIRO.eInteiro());
		assertFalse(TipoPrimitivo.INTEIRO.eString());
	}

	@Test
	public void testEString() {
		assertFalse(TipoPrimitivo.STRING.eBooleano());
		assertFalse(TipoPrimitivo.STRING.eInteiro());
		assertTrue(TipoPrimitivo.STRING.eString());
	}

	@Test
	public void testEIgual() {
		assertFalse(TipoPrimitivo.BOOLEANO.eIgual(TipoPrimitivo.INTEIRO));
		assertFalse(TipoPrimitivo.BOOLEANO.eIgual(TipoPrimitivo.STRING));
		assertFalse(TipoPrimitivo.INTEIRO.eIgual(TipoPrimitivo.STRING));
		assertFalse(TipoPrimitivo.STRING.eIgual(TipoPrimitivo.INTEIRO));
	}

	@Test
	public void testEValido() {
		assertTrue(TipoPrimitivo.BOOLEANO.eValido());
		assertTrue(TipoPrimitivo.INTEIRO.eValido());
		assertTrue(TipoPrimitivo.STRING.eValido());
	}

	@Test
	public void testIntersecao() {
		assertSame(TipoPrimitivo.BOOLEANO, TipoPrimitivo.BOOLEANO.intersecao(TipoPrimitivo.BOOLEANO));
		assertSame(TipoPrimitivo.INTEIRO, TipoPrimitivo.INTEIRO.intersecao(TipoPrimitivo.INTEIRO));
		assertSame(TipoPrimitivo.STRING, TipoPrimitivo.STRING.intersecao(TipoPrimitivo.STRING));

		assertNull(TipoPrimitivo.BOOLEANO.intersecao(TipoPrimitivo.INTEIRO));
		assertNull(TipoPrimitivo.BOOLEANO.intersecao(TipoPrimitivo.STRING));
		assertNull(TipoPrimitivo.INTEIRO.intersecao(TipoPrimitivo.STRING));

		assertNull(TipoPrimitivo.INTEIRO.intersecao(TipoPrimitivo.BOOLEANO));
		assertNull(TipoPrimitivo.STRING.intersecao(TipoPrimitivo.BOOLEANO));
		assertNull(TipoPrimitivo.STRING.intersecao(TipoPrimitivo.INTEIRO));
	}

}
