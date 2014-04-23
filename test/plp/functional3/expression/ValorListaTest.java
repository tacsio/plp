package plp.functional3.expression;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import plp.expressions1.util.Tipo;
import plp.functional1.util.TipoPolimorfico;
import plp.functional3.util.TipoLista;

public class ValorListaTest {
	ValorLista listaVazia = ValorLista.getInstancia(null, null);

	@Test
	public void testConcat() {
		assertThat(listaVazia.concat(listaVazia).toString(), is("[]"));
	}

	@Test
	public void testInverter() {

		assertThat(listaVazia.inverter().toString(), is("[]"));
	}

	@Test
	public void testGetTipo() {
		Tipo tipoListaVazia = listaVazia.getTipo(null);
		assertThat(tipoListaVazia, instanceOf(TipoLista.class));
		assertThat(((TipoLista) tipoListaVazia).getSubTipo(),
				instanceOf(TipoPolimorfico.class));
	}

}
