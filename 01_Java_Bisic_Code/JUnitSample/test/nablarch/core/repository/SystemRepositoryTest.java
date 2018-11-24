package nablarch.core.repository;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import nablarch.core.repository.component.Component1;
import nablarch.core.repository.component.Component2;

public class SystemRepositoryTest {

	//<component name="stringResourceHolder" class="nablarch.core.message.MockStringResourceHolder">
	//</component>

	@Before
	public void setUp() throws Exception {
		SystemRepository.load(new ObjectLoader() {
			@Override
			public Map<String, Object> load() {
				HashMap<String, Object> result = new HashMap<String, Object>();
				Component1 component1 = new Component1();
				component1.setProp1("string value");
				component1.setComponent2(new Component2());
				result.put("comp1", component1);

				Component2 component2 = new Component2();
				component2.setProp1("prop2");
				result.put("comp2", component2);

				result.put("string", "string");
				result.put("boolean-on", "on");
				result.put("boolean-yes", "yes");
				result.put("boolean-true", "true");
				result.put("boolean-off", "off");
				return result;
			}
		});
	}

	@After
	public void tearDown() throws Exception {
		SystemRepository.clear();
	}

	@Test
	public void testLoad() throws Throwable {
		Component1 comp1 = SystemRepository.get("comp1");
		Component2 comp2 = SystemRepository.get("comp2");

		assertThat(comp1.getProp1(), CoreMatchers.is("string value"));
		assertThat(comp2.getProp1(), CoreMatchers.is("prop2"));

		assertThat(SystemRepository.getObject("comp1"), CoreMatchers.<Object> sameInstance(comp1));
	}

	@Test
	public void testGetMethod() throws Throwable {
		assertThat(SystemRepository.getString("string"), CoreMatchers.is("string"));
		assertThat(SystemRepository.getBoolean("boolean-on"), CoreMatchers.is(true));
		assertThat(SystemRepository.getBoolean("boolean-yes"), CoreMatchers.is(true));
		assertThat(SystemRepository.getBoolean("boolean-true"), CoreMatchers.is(true));
		assertThat(SystemRepository.getBoolean("boolean-off"), CoreMatchers.is(false));
	}

}
