package kata.pact.provider;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static org.junit.Assert.assertEquals;

@Controller
public class ReviewController {
    private ReviewService myResponseService;

    @RequestMapping(value = "/ratings", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<Rating>> getRatings(String id,String name) {
        ReviewService reviewService = new ReviewService();
        assertEquals("123", id);
        assertEquals("ben", name);
        return reviewService.getRatings();
    }

    public ReviewController withMyResponseService(ReviewService myResponseService) {
        this.myResponseService = myResponseService;
        return this;
    }
}
