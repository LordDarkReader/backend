package pl.czaki.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInput {

    String name;
    String email;
    Boolean isAdmin;
    String password;
}
