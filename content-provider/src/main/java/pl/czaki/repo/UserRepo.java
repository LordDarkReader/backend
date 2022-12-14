package pl.czaki.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.czaki.model.User;

@Repository
public interface UserRepo extends MongoRepository<User, String> {

    User findUserByName(String username);
}
