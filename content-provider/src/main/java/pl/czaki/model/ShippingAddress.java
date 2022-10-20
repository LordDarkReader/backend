package pl.czaki.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "shippingAddresses")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShippingAddress {

    @Id
    private String id;

    private String street;

    private String city;

    private String zipCode;

}
