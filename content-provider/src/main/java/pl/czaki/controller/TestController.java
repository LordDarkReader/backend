package pl.czaki.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.czaki.api.JackpotResponse;
import pl.czaki.repo.AddressRepo;
import pl.czaki.service.JackpotService;
import pl.czaki.service.TestService;

@RestController
@Slf4j
public class TestController {

    private TestService testService;

    private JackpotService jackpotService;

    private AddressRepo addressRepo;

    @Autowired
    public TestController(TestService testService, JackpotService jackpotService,  AddressRepo addressRepo) {
        this.testService = testService;
        this.jackpotService = jackpotService;
        this.addressRepo = addressRepo;
    }


    @GetMapping(value = "/test")
    public String testOK() {
        log.debug("dupa 1");
        return "OK";
    }

    @GetMapping(value = "/test2")
    public String test2() {
        log.debug("dupa 2");
        testService.dupaa();
        return "OK 2";
    }

    @GetMapping(value = "/jackpot")
    public JackpotResponse generateJackpotNumbers() {
        log.debug("start generateJackpotNumbers");
        return jackpotService.generateJackpotNumbers();
    }
}
