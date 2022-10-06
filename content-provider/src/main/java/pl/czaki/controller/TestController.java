package pl.czaki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.czaki.api.JackpotResponse;
import pl.czaki.service.JackpotService;
import pl.czaki.service.TestService;

@RestController
//@CrossOrigin(value = "http://192.168.49.2:31129")
@CrossOrigin(value = "http://localhost:3000")
public class TestController {

    private TestService testService;

    private JackpotService jackpotService;

    @Autowired
    public TestController(TestService testService, JackpotService jackpotService) {
        this.testService = testService;
        this.jackpotService = jackpotService;
    }


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

    @GetMapping(value = "/jackpot")
    public JackpotResponse generateJackpotNumbers() {
        System.out.println("start generateJackpotNumbers");
        return jackpotService.generateJackpotNumbers();
    }
}
