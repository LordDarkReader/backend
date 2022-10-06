package pl.czaki.api;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class JackpotResponse {

    private List<Integer> numbers50;
    private List<Integer> numbers12;
}
