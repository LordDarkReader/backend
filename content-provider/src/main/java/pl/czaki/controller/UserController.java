package pl.czaki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.czaki.model.User;
import pl.czaki.service.UserService;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/user")
    public String saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return "OK";
    }


    @GetMapping(value = "/user")
    public Optional<User> getUser(String userId) {
        return userService.findUser(userId);
    }

    @GetMapping(value = "/userd")
    public Optional<User> getUserd() {
        return userService.findUser("633d37931eecb670d15da206");
    }

    @GetMapping(value = "/user-test")
    public User getUserTest() {
       return User.builder()
                .id("1")
                .email("dupa@wp.pl")
                .isAdmin(false)
                .name("Dupa")
                .password("dupa1234")
                .build();
    }
}
