package kata.pact.provider;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ReviewController {
    private ReviewService reviewService;

    @RequestMapping(value = "/ratings", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<Rating>> getRatings(String id,String name) {
        // the value of "id" and "name" could be retrieved from ec_app-review_service.json
        // assertEquals("123", id);
        // assertEquals("ben", name);

        return reviewService.getRatings(id, name);
    }

    public ReviewController withResponseService(ReviewService reviewService) {
        this.reviewService = reviewService;
        return this;
    }
}
