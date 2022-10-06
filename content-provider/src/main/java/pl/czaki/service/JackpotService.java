package pl.czaki.service;

import org.springframework.stereotype.Service;
import pl.czaki.api.JackpotResponse;

import java.util.ArrayList;

@Service
public class JackpotService {

    public JackpotResponse generateJackpotNumbers() {

        ArrayList<Integer> list50 = new ArrayList<>();
        ArrayList<Integer> list12 = new ArrayList<>();
        int hasda = 0;
        int hasda2 = 0;

        for (int j = 0; j < 5 + hasda; j++) {
            int randomInt = (int) (50.0 * Math.random());
            System.out.println("random: " + randomInt + " " + j);
            if (!list50.contains(randomInt) && randomInt != 0) {
                list50.add(randomInt);
            } else {
                hasda = +1;
            }
        }

        for (int j = 0; j < 2 + hasda2; j++) {
            int randomInt = (int) (12.0 * Math.random());
            System.out.println("random: " + randomInt + " " + j);
            if (!list12.contains(randomInt) && randomInt != 0) {
                list12.add(randomInt);
            } else {
                hasda2 = +1;
            }
        }

        return JackpotResponse.builder()
                .numbers50(list50)
                .numbers12(list12)
                .build();
    }
}
