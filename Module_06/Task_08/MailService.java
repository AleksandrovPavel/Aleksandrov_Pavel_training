import java.util.*;
import java.util.function.Consumer;

public static class MailService<T> implements Consumer<Ancestor<T>> {

    private Map<String, List<T>> mailBox = new HashMap<>() {
        public List<T> get(Object key) {
            return getOrDefault(key, Collections.emptyList());
        }
    };

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }

    @Override
    public void accept(Ancestor<T> t) {
        mailBox.computeIfAbsent(t.getTo(), rez -> new ArrayList<>()).add(t.getContent());
    }
}
