package kata.pact.provider;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class ReviewService {
    public ResponseEntity<List<Rating>> getRatings(String id, String name) {
        // use id and name to get the ratings from the backend

        List<Rating> result = new ArrayList<Rating>();
        result.add(new Rating(123, "ben", 4));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
