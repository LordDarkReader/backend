package pl.czaki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.czaki.model.User;
import pl.czaki.repo.UserRepo;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public String saveUser(User user) {
        userRepo.save(user);
        return "OK";
    }

    public Optional<User> findUser(String userId) {
         return userRepo.findById(userId);
    }
}
