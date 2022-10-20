package pl.czaki.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.czaki.model.Address;


@Repository
public interface AddressRepo extends MongoRepository<Address, String> {
}
