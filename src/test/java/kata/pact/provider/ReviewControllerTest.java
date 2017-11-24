package kata.pact.provider;

import au.com.dius.pact.provider.junit.Consumer;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.RestPactRunner;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.TestTarget;
import au.com.dius.pact.provider.spring.target.MockMvcTarget;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyString;

@RunWith(RestPactRunner.class)
@Provider("review_service")
@Consumer("ec_app")
@PactFolder("src/test/resources")
public class ReviewControllerTest {

    @TestTarget
    public final MockMvcTarget target = new MockMvcTarget();

    private ReviewController reviewController = new ReviewController();

    @Mock
    private ReviewService reviewService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        reviewController.withResponseService(reviewService);
        target.setControllers(reviewController);
    }

    @State("The ratings in Review service are ready")
    public void shouldGetRatings() {
        target.setRunTimes(1);

        List<Rating> ratings = asList(new Rating(1, "qin", 2));
        given(reviewService.getRatings(anyString(), anyString()))
                .willReturn(new ResponseEntity<>(ratings, HttpStatus.OK));
    }
}
