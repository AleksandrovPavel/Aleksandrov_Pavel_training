import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.nio.charset.StandardCharsets.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Long> map = new BufferedReader(new InputStreamReader(System.in, UTF_8))
                .lines()
                .flatMap(proposal -> Arrays.stream(proposal.toLowerCase().split("[^a-zA-Zа-яА-Я0-9']+")))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        map.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed()
                        .thenComparing(Map.Entry.<String, Long>comparingByKey()))
                .limit(10)
                .forEach(x -> System.out.println(x.getKey()));
    }
}