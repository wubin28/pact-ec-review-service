package kata.pact.provider;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.github.restdriver.clientdriver.ClientDriverRule;
import org.junit.ClassRule;
import org.junit.runner.RunWith;

import java.util.List;
import java.util.Map;

import static com.github.restdriver.clientdriver.RestClientDriver.giveResponse;
import static com.github.restdriver.clientdriver.RestClientDriver.onRequestTo;

@RunWith(PactRunner.class)
@Provider("review_service")
@PactFolder("src/test/resources")
public class ReviewServiceTest {
    @ClassRule
    public static final ClientDriverRule embeddedService = new ClientDriverRule(8332);

    @TestTarget
    public final Target target = new HttpTarget(8332);

    @State("The ratings in Review service are ready")
    public void shouldGetRatings(Map<String, Object> params) throws JsonProcessingException {
        // Get parameters from the pact
        // params.forEach((key, value) -> System.out.println(key + ":" + value));

        ReviewService reviewService = new ReviewService();
        final List<Rating> ratings = reviewService.getRatings(params.get("productId").toString(), params.get("userName").toString());
        ObjectMapper objectMapper = new ObjectMapper();
        //Set pretty printing of json
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        embeddedService.addExpectation(
                onRequestTo("/ratings").withParams(params)
                , giveResponse(objectMapper.writeValueAsString(ratings), "application/json;charset=UTF-8")
        );
    }
}
