package plp.expressions1.util;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static plp.expressions1.util.ToStringProvider.listToString;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ToStringProviderTest {

	@Test
	public void testListToString() {
		List<Integer> list = asList(1, 2, 3);
		assertThat(listToString(list, "{", "}", ";"), is("{1; 2; 3}"));

		assertThat(listToString(new ArrayList(), "[", "]", ","), is("[]"));
		assertThat(listToString(asList(""), "[", "]", ","), is("[]"));
	}

}
