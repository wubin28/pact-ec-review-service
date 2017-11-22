package kata.pact.provider;

import com.reagroup.pact.provider.PactFile;
import com.reagroup.pact.provider.PactRunner;
import com.reagroup.pact.provider.ProviderState;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@RunWith(PactRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContextPactTest.xml"})
@PactFile("ec_app-review_service.json")
public class ReviewControllerTest {

    @Autowired
    private ReviewController reviewController;

    private ReviewService reviewService;

    @Before
    public void setUp() throws Exception {
        reviewService = new ReviewService();
        reviewController.withResponseService(reviewService);
    }

    @ProviderState("The ratings in Review service are ready")
    public ReviewController shouldGetRatings() {
        // Pact will use the returned controller to call the production code
        return reviewController;
    }

}
