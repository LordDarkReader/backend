package pl.czaki.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    private String id;

    private String name;

    private String email;

    private Boolean isAdmin;

    private String password;

    private List<Role> roles;

    private Address address;

}
