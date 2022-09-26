package pl.czaki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.czaki.service.TestService;

@RestController
@CrossOrigin(value = "http://frontend:31350")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping(value = "/test")
    public String testOK() {
        System.out.println("dupa");
        return "OK";
    }

    @GetMapping(value = "/test2")
    public String test2() {
        System.out.println("dupa 2");
        testService.dupaa();
        return "OK 2";
    }
}
