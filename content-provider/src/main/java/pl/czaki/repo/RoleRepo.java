package pl.czaki.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.czaki.model.Role;

@Repository
public interface RoleRepo extends MongoRepository<Role, String> {

    Role findRoleByName(String name);
}
