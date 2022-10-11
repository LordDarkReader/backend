package pl.czaki.security.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.czaki.security.model.User;

@Repository
public interface UserRepo extends MongoRepository<User, String> {

    User findByUsername(String username);
}
