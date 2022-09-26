package pl.czaki.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TestService {



    public void dupaa() {

        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://jms:8080/test";
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        System.out.println("dsadsad " + response);
    }

}
