package kata.pact.provider;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ReviewController {
    private ReviewService myResponseService;

    @RequestMapping(value = "/ratings", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<Rating>> getRatings() {
        ReviewService reviewService = new ReviewService();
        return reviewService.getRatings();
    }

    public ReviewController withMyResponseService(ReviewService myResponseService) {
        this.myResponseService = myResponseService;
        return this;
    }
}
