import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by vsinchuk on 27-Jul-16.
 */


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features/")
public class RunFeatures {
}
