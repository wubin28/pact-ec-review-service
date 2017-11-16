package kata.pact.provider;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

public class ReviewService {
    public ResponseEntity<List<Rating>> getRatings() {
        return new ResponseEntity<List<Rating>>(Arrays.asList(new Rating(3), new Rating(4)), HttpStatus.OK);
    }
}
