package kata.pact.provider;

import com.reagroup.pact.provider.PactFile;
import com.reagroup.pact.provider.PactRunner;
import com.reagroup.pact.provider.ProviderState;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.mockito.Mockito.mock;

@RunWith(PactRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContextPactTest.xml"})
@PactFile("ec_app-review_service.json")
public class ReviewControllerTest {

    @Autowired
    private ReviewController myControllerWithService;

    private ReviewService myResponseService;

    @Before
    public void setUp() throws Exception {
        myResponseService = new ReviewService();
        myControllerWithService.withMyResponseService(myResponseService);
    }

    @ProviderState("The ratings in Review service are ready")
    public ReviewController shouldGetRatings() {
        return myControllerWithService;
    }

}
