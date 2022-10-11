package pl.czaki.security.service;

import org.springframework.stereotype.Service;
import pl.czaki.security.model.Role;
import pl.czaki.security.model.User;

import java.util.List;

@Service
public interface UserService {

    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUser(String username);

    List<User> getUsers();
}
