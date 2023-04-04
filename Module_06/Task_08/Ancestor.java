import java.util.Objects;

public static class Ancestor<T> {
    private String from;
    private String to;
    private T content;

    public Ancestor(String from, String to, T content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public T getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ancestor<?> ancestor = (Ancestor<?>) o;
        return Objects.equals(from, ancestor.from) && Objects.equals(to, ancestor.to) && Objects.equals(content, ancestor.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, content);
    }
}
