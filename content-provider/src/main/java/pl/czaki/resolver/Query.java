package pl.czaki.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import pl.czaki.model.Role;
import pl.czaki.model.Token;
import pl.czaki.model.User;
import pl.czaki.repo.RoleRepo;
import pl.czaki.repo.UserRepo;

import java.util.Date;
import java.util.Optional;


@RestController
public class Query implements GraphQLQueryResolver {

    private UserRepo userRepo;
    private RoleRepo roleRepo;

    @Autowired
    public Query(UserRepo userRepo, RoleRepo roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    @QueryMapping
    public Iterable<User> findAllUsers() {
        return userRepo.findAll();
    }

    @QueryMapping
    public Iterable<Role> findAllRoles() {
        return roleRepo.findAll();
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

    @QueryMapping
    public Token getToken() {
        Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
        String access_token = JWT.create()
                .withSubject("Czarek")
                .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                //.withIssuer(request.getRequestURL().toString())
                .withIssuer("http://localhost:8083")
                .withClaim("roles", "ADMIN")
                .sign(algorithm);
        return Token.builder()
                .accessToken(access_token)
                .refreshToken("test")
                .build();


    }

}
