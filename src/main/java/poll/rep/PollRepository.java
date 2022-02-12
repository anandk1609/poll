package poll.rep;

import org.springframework.data.mongodb.repository.MongoRepository;
import poll.models.Poll;

public interface PollRepository extends MongoRepository<Poll, Integer>{

}