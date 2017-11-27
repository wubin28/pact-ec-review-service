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

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(RestPactRunner.class)
@Provider("review_service")
@Consumer("ec_app")
@PactFolder("src/test/resources")
public class ReviewControllerTest {

    @TestTarget
    public final MockMvcTarget target = new MockMvcTarget();

    private ReviewController reviewController = new ReviewController();

    @Mock
    private ReviewService mockReviewService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        reviewController.withResponseService(mockReviewService);
        target.setControllers(reviewController);
    }

    @State("The ratings in Review service are ready")
    public void shouldGetRatings() {
        ReviewService reviewService = new ReviewService();
        when(mockReviewService.getRatings(anyString(), anyString()))
                .thenReturn(reviewService.getRatings("234567", "qin"));
    }
}
