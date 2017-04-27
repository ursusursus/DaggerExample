package com.example.ursus.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.core.deps.dagger.Provides;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.ursus.myapplication.injection.DefaultComponent;
import com.example.ursus.myapplication.injection.DefaultModule;
import com.example.ursus.myapplication.net.Parser;
import com.example.ursus.myapplication.net.RestClient;
import com.example.ursus.myapplication.ui.MainActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

	@Rule
	public ActivityTestRule<MainActivity> mActivityRule =
			new ActivityTestRule<>(MainActivity.class, true, false);

	@Before
	public void setUp() throws Exception {
		FooTestComponent testComponent = DaggerExampleInstrumentedTest_FooTestComponent.builder()
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
//		DefaultComponent testComponent = DaggerDefaultComponent.builder()
//				.defaultModule(new FooTestModule())
//				.build();
		App app = (App) InstrumentationRegistry.getTargetContext().getApplicationContext();
		app.setComponent(testComponent);
	}

	@Test
	public void useAppContext() throws Exception {
		launchActivity();
		Espresso.onView(ViewMatchers.withId(R.id.button)).check(ViewAssertions.matches(ViewMatchers.withText("Click")));
	}

	private void launchActivity() {
		Context targetContext = InstrumentationRegistry.getInstrumentation()
				.getTargetContext();
		mActivityRule.launchActivity(new Intent(targetContext, MainActivity.class));
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
		void exampleInstrumentedTest(ExampleInstrumentedTest test);

	}
}
