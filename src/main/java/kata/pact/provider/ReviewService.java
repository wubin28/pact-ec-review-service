package kata.pact.provider;

import java.util.ArrayList;
import java.util.List;

public class ReviewService {
    public List<Rating> getRatings(String id, String name) {
        // use id and name to get the ratings from the backend

        List<Rating> result = new ArrayList<Rating>();
        result.add(new Rating("123456", "ben", "5"));
        return result;
    }
}
