package com.example.ursus.myapplication;

import com.example.ursus.myapplication.injection.DefaultComponent;
import com.example.ursus.myapplication.injection.DefaultModule;
import com.example.ursus.myapplication.net.Parser;
import com.example.ursus.myapplication.net.RestClient;

import org.junit.Test;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
		// Toto funguje len v IDEcku to je stale cervene lebo bohvie, od nejakej verzii
		// v Build Variants odstranili to prepinatko medzi Instrumentacnymi a Unit testami
		// lebo sa to nejako buildi spolu ale evidentne pre unittesty to veci z apt neberie
		// aj ked paradoxne apt generovane veci pre instrumentacne su ok aj v IDE
		FooTestComponent testComponent = DaggerExampleUnitTest_FooTestComponent.builder()
				.fooTestModule(new FooTestModule() {
					@Override
					public RestClient provideRestClient(Parser parser, Dao dao) {
						return new RestClient(parser, dao) {
							@Override
							public String toString() {
								return "FAKE RESTCLIENT";
							}
						};
					}
				})
				.build();

		assertEquals(4, 2 + 2);
    }

	@Module
	public static class FooTestModule extends DefaultModule {

		@Provides
		String provideKokot() {
			return "";
		}
	}

	@Singleton
	@Component(modules = FooTestModule.class)
	public interface FooTestComponent extends DefaultComponent {
		void exampleInstrumentedTest(ExampleUnitTest test);

	}
}