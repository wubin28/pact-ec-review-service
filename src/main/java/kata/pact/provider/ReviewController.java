package kata.pact.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@EnableAutoConfiguration
@RestController
public class ReviewController {
    public static void main(String[] args) {
        SpringApplication.run(ReviewController.class, args);
    }

    @RequestMapping(value = "/ratings", method = RequestMethod.GET)
    public ResponseEntity<List<Rating>> getRatings() {
        ReviewService reviewService = new ReviewService();
        return reviewService.getRatings();
    }
}
