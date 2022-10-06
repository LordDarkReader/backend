package pl.czaki.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.czaki.model.User;
import pl.czaki.repo.UserRepo;


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
    public long countUsers() {
        return userRepo.count();
    }



}
