package poll.rep;

import org.springframework.data.mongodb.repository.MongoRepository;
import poll.models.Users;

public interface UserRepository extends MongoRepository<Users, Integer>{

}