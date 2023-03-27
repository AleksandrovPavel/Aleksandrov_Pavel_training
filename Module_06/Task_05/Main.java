import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        pseudoRandomStream(13).limit(7).mapToObj(x -> " " + x).forEach(System.out::print);

    }

    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, x -> x * x / 10 % 1000);
    }
}
