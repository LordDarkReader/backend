package pl.czaki.security.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.czaki.security.model.Role;

@Repository
public interface RoleRepo extends MongoRepository<Role, String> {

    Role findByName(String name);
}
