package pl.czaki.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.czaki.model.User;
import pl.czaki.repo.UserRepo;

import java.util.Optional;


@RestController
public class Query implements GraphQLQueryResolver {

    private UserRepo userRepo;

    @Autowired
    public Query(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @QueryMapping
    public Iterable<User> findAllUsers() {
        return userRepo.findAll();
    }

    @QueryMapping
    public User findUserById(@Argument String id) {
        Optional<User> userOptional = userRepo.findById(id);
        return userOptional.get();
    }

    @QueryMapping
    public long countUsers() {
        return userRepo.count();
    }
}
