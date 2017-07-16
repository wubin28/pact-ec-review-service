package kata.pact.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@EnableAutoConfiguration
@RestController
public class ReviewService {
    public static void main(String[] args) {
        SpringApplication.run(ReviewService.class, args);
    }

    @RequestMapping(value = "/ratings", method = RequestMethod.GET)
    public ResponseEntity<List<Rating>> getRatings() {
        return new ResponseEntity<List<Rating>>(Arrays.asList(new Rating(3), new Rating(4)), HttpStatus.OK);
    }
}
