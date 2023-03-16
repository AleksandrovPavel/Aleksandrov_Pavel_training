import java.util.Objects;

public class Pair<T, I> {
    private T first;
    private I second;

    private Pair(T first, I second) {
        this.first = first;
        this.second = second;
    }

    public static <T, I> Pair<T, I> of(T first, I second) {
        return new Pair<>(first, second);
    }

    public T getFirst() {
        return first;
    }

    public I getSecond() {
        return second;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}

