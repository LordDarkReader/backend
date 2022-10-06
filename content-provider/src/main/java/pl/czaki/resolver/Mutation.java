package pl.czaki.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import pl.czaki.model.User;
import pl.czaki.model.UserInput;
import pl.czaki.repo.UserRepo;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class Mutation implements GraphQLMutationResolver {

    private UserRepo userRepo;

    @Autowired
    public Mutation(UserRepo authorRepository) {
        this.userRepo = authorRepository;
    }

    @MutationMapping
    public User createUser(@Argument("input") UserInput userInput) {
        System.out.println("222222");
        User user = User.builder()
                .name(userInput.getName())
                .email(userInput.getEmail())
                .password(userInput.getPassword())
                .isAdmin(userInput.getIsAdmin())
                .build();
        userRepo.save(user);
        return user;
    }
}