package plp.functional1.util;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import plp.expressions1.util.Tipo;
import plp.expressions1.util.TipoPrimitivo;

public class TestTipoPolimorfico {

	@Test
	public void testInferir() {
		TipoPolimorfico tq;

		tq = new TipoPolimorfico();
		assertEquals(tq, tq.inferir());
		assertEquals(tq.toString(), "?");

		tq = new TipoPolimorfico();
		TipoPolimorfico tq2 = new TipoPolimorfico();
		tq.eIgual(tq2);
		assertTrue(tq.eIgual(tq2.inferir()));

		tq = new TipoPolimorfico();
		tq.eIgual(TipoPrimitivo.BOOLEANO);
		assertEquals(TipoPrimitivo.BOOLEANO, tq.inferir());

		tq = new TipoPolimorfico();
		tq.eIgual(TipoPrimitivo.INTEIRO);
		assertEquals(TipoPrimitivo.INTEIRO, tq.inferir());

		tq = new TipoPolimorfico();
		tq.eIgual(TipoPrimitivo.STRING);
		assertEquals(TipoPrimitivo.STRING, tq.inferir());

		// Após inferir como curinga ("?") pode ser iqual a qualquer tipo
		// primitivo (por aplicação).

		tq = new TipoPolimorfico();
		tq.inferir();
		tq.eIgual(TipoPrimitivo.BOOLEANO);
		assertTrue(TipoPrimitivo.BOOLEANO.eIgual(tq));

		tq = new TipoPolimorfico();
		tq.inferir();
		tq.eIgual(TipoPrimitivo.INTEIRO);
		assertTrue(TipoPrimitivo.INTEIRO.eIgual(tq));

		tq = new TipoPolimorfico();
		tq.inferir();
		tq.eIgual(TipoPrimitivo.STRING);
		assertTrue(TipoPrimitivo.STRING.eIgual(tq));
	}

	@Test
	public void testEIgual() {
		TipoPolimorfico tq;

		tq = new TipoPolimorfico();
		assertTrue(tq.eIgual(new TipoPolimorfico()));

		// Um TipoQualquer vazio sempre é igual a um tipo primitivo.

		tq = new TipoPolimorfico();
		assertTrue(tq.eIgual(TipoPrimitivo.BOOLEANO));

		tq = new TipoPolimorfico();
		assertTrue(tq.eIgual(TipoPrimitivo.INTEIRO));

		tq = new TipoPolimorfico();
		assertTrue(tq.eIgual(TipoPrimitivo.STRING));

		tq = new TipoPolimorfico();
		assertTrue(TipoPrimitivo.BOOLEANO.eIgual(tq));

		tq = new TipoPolimorfico();
		assertTrue(TipoPrimitivo.INTEIRO.eIgual(tq));

		tq = new TipoPolimorfico();
		assertTrue(TipoPrimitivo.STRING.eIgual(tq));

		tq = new TipoPolimorfico();
		assertTrue(tq.eIgual(new TipoFuncao(
				asList((Tipo) new TipoPolimorfico()), new TipoPolimorfico())));
		assertTrue(new TipoFuncao(asList((Tipo) new TipoPolimorfico()),
				new TipoPolimorfico()).eIgual(tq));

		// Um TipoQualquer inferido só é igual ao tipo inferido.

		tq = new TipoPolimorfico();
		tq.eIgual(TipoPrimitivo.BOOLEANO);
		assertTrue(tq.eIgual(TipoPrimitivo.BOOLEANO));
		assertFalse(tq.eIgual(TipoPrimitivo.INTEIRO));
		assertFalse(tq.eIgual(TipoPrimitivo.STRING));

		tq = new TipoPolimorfico();
		tq.eIgual(TipoPrimitivo.INTEIRO);
		assertFalse(tq.eIgual(TipoPrimitivo.BOOLEANO));
		assertTrue(tq.eIgual(TipoPrimitivo.INTEIRO));
		assertFalse(tq.eIgual(TipoPrimitivo.STRING));

		tq = new TipoPolimorfico();
		tq.eIgual(TipoPrimitivo.STRING);
		assertFalse(tq.eIgual(TipoPrimitivo.BOOLEANO));
		assertFalse(tq.eIgual(TipoPrimitivo.INTEIRO));
		assertTrue(tq.eIgual(TipoPrimitivo.STRING));

		tq = new TipoPolimorfico();
		TipoPrimitivo.BOOLEANO.eIgual(tq);
		assertTrue(tq.eIgual(TipoPrimitivo.BOOLEANO));
		assertFalse(tq.eIgual(TipoPrimitivo.INTEIRO));
		assertFalse(tq.eIgual(TipoPrimitivo.STRING));

		tq = new TipoPolimorfico();
		TipoPrimitivo.INTEIRO.eIgual(tq);
		assertFalse(tq.eIgual(TipoPrimitivo.BOOLEANO));
		assertTrue(tq.eIgual(TipoPrimitivo.INTEIRO));
		assertFalse(tq.eIgual(TipoPrimitivo.STRING));

		tq = new TipoPolimorfico();
		TipoPrimitivo.STRING.eIgual(tq);
		assertFalse(tq.eIgual(TipoPrimitivo.BOOLEANO));
		assertFalse(tq.eIgual(TipoPrimitivo.INTEIRO));
		assertTrue(tq.eIgual(TipoPrimitivo.STRING));
	}

	@Test
	public void testEBooleano() {
		TipoPolimorfico tq = new TipoPolimorfico();
		tq.eIgual(TipoPrimitivo.BOOLEANO);

		assertTrue(tq.eBooleano());
		assertFalse(tq.eInteiro());
		assertFalse(tq.eString());
	}

	@Test
	public void testEInteiro() {
		TipoPolimorfico tq = new TipoPolimorfico();
		tq.eIgual(TipoPrimitivo.INTEIRO);

		assertFalse(tq.eBooleano());
		assertTrue(tq.eInteiro());
		assertFalse(tq.eString());
	}

	@Test
	public void testEString() {
		TipoPolimorfico tq = new TipoPolimorfico();
		tq.eIgual(TipoPrimitivo.STRING);

		assertFalse(tq.eBooleano());
		assertFalse(tq.eInteiro());
		assertTrue(tq.eString());
	}

	@Test
	public void testEValido() {
		TipoPolimorfico tq;

		tq = new TipoPolimorfico();
		assertFalse(tq.eValido());

		tq = new TipoPolimorfico();
		tq.eIgual(TipoPrimitivo.BOOLEANO);
		assertTrue(tq.eValido());

		tq = new TipoPolimorfico();
		tq.eIgual(TipoPrimitivo.INTEIRO);
		assertTrue(tq.eValido());

		tq = new TipoPolimorfico();
		tq.eIgual(TipoPrimitivo.STRING);
		assertTrue(tq.eValido());

		tq = new TipoPolimorfico();
		TipoPrimitivo.BOOLEANO.eIgual(tq);
		assertTrue(tq.eValido());

		tq = new TipoPolimorfico();
		TipoPrimitivo.INTEIRO.eIgual(tq);
		assertTrue(tq.eValido());

		tq = new TipoPolimorfico();
		TipoPrimitivo.STRING.eIgual(tq);
		assertTrue(tq.eValido());
	}

	@Test
	public void testIntersecao() {
		TipoPolimorfico tq;

		tq = new TipoPolimorfico();
		assertEquals(TipoPrimitivo.BOOLEANO, tq
				.intersecao(TipoPrimitivo.BOOLEANO));

		tq = new TipoPolimorfico();
		assertEquals(TipoPrimitivo.INTEIRO, tq
				.intersecao(TipoPrimitivo.INTEIRO));

		tq = new TipoPolimorfico();
		assertEquals(TipoPrimitivo.STRING, tq.intersecao(TipoPrimitivo.STRING));

		tq = new TipoPolimorfico();
		assertEquals(TipoPrimitivo.BOOLEANO, TipoPrimitivo.BOOLEANO
				.intersecao(tq));

		tq = new TipoPolimorfico();
		assertEquals(TipoPrimitivo.INTEIRO, TipoPrimitivo.INTEIRO
				.intersecao(tq));

		tq = new TipoPolimorfico();
		assertEquals(TipoPrimitivo.STRING, TipoPrimitivo.STRING.intersecao(tq));

		tq = new TipoPolimorfico();
		tq.eIgual(TipoPrimitivo.BOOLEANO);
		assertEquals(TipoPrimitivo.BOOLEANO, tq
				.intersecao(TipoPrimitivo.BOOLEANO));

		tq = new TipoPolimorfico();
		tq.eIgual(TipoPrimitivo.INTEIRO);
		assertEquals(TipoPrimitivo.INTEIRO, tq
				.intersecao(TipoPrimitivo.INTEIRO));

		tq = new TipoPolimorfico();
		tq.eIgual(TipoPrimitivo.STRING);
		assertEquals(TipoPrimitivo.STRING, tq.intersecao(TipoPrimitivo.STRING));

		tq = new TipoPolimorfico();
		tq.eIgual(TipoPrimitivo.BOOLEANO);
		assertEquals(TipoPrimitivo.BOOLEANO, TipoPrimitivo.BOOLEANO
				.intersecao(tq));

		tq = new TipoPolimorfico();
		tq.eIgual(TipoPrimitivo.INTEIRO);
		assertEquals(TipoPrimitivo.INTEIRO, TipoPrimitivo.INTEIRO
				.intersecao(tq));

		tq = new TipoPolimorfico();
		tq.eIgual(TipoPrimitivo.STRING);
		assertEquals(TipoPrimitivo.STRING, TipoPrimitivo.STRING.intersecao(tq));

		//		assertSame(Tipo.TIPO_BOOLEANO, Tipo.TIPO_BOOLEANO.intersecao(Tipo.TIPO_BOOLEANO));
		//		assertSame(Tipo.TIPO_INTEIRO, Tipo.TIPO_INTEIRO.intersecao(Tipo.TIPO_INTEIRO));
		//		assertSame(Tipo.TIPO_STRING, Tipo.TIPO_STRING.intersecao(Tipo.TIPO_STRING));
		//
		//		assertNull(Tipo.TIPO_BOOLEANO.intersecao(Tipo.TIPO_INTEIRO));
		//		assertNull(Tipo.TIPO_BOOLEANO.intersecao(Tipo.TIPO_STRING));
		//		assertNull(Tipo.TIPO_INTEIRO.intersecao(Tipo.TIPO_STRING));
		//
		//		assertNull(Tipo.TIPO_INTEIRO.intersecao(Tipo.TIPO_BOOLEANO));
		//		assertNull(Tipo.TIPO_STRING.intersecao(Tipo.TIPO_BOOLEANO));
		//		assertNull(Tipo.TIPO_STRING.intersecao(Tipo.TIPO_INTEIRO));
	}

}
