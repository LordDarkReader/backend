package pl.czaki.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.czaki.model.Role;
import pl.czaki.model.User;
import pl.czaki.model.UserInput;
import pl.czaki.repo.RoleRepo;
import pl.czaki.repo.UserRepo;

import java.util.ArrayList;
import java.util.List;


@RestController
public class Mutation implements GraphQLMutationResolver {

    private UserRepo userRepo;
    private RoleRepo roleRepo;

    @Autowired
    public Mutation(UserRepo authorRepository, RoleRepo roleRepo) {
        this.userRepo = authorRepository;
        this.roleRepo = roleRepo;
    }

    @MutationMapping
    public User createUser(@Argument("input") UserInput userInput) {
        Role role_user = Role.builder().name("ROLE_USER").build();
        Role role_manager = Role.builder().name("ROLE_MANAGER").build();
        Role role_admin = Role.builder().name("ROLE_ADMIN").build();

        Role role_admin1 = roleRepo.findRoleByName("ROLE_ADMIN");
        Role role_user1 = roleRepo.findRoleByName("ROLE_USER");

        List<Role> roles = new ArrayList<>();
        roles.add(role_admin1);
        //roles.add(role_manager);
        roles.add(role_user1);

        User user = User.builder()
                .name(userInput.getName())
                .email(userInput.getEmail())
                .password(userInput.getPassword())
                .isAdmin(userInput.getIsAdmin())
                .roles(roles)
                .build();
        userRepo.save(user);
        return user;
    }
}