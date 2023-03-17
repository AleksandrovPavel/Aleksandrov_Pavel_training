import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<Integer> num1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> num2 = new HashSet<>(Arrays.asList(0, 1, 2));

        Set<Integer> result = symmetricDifference(num1, num2);
        System.out.println(result); // {0,3}

    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {

        Set<T> result = new HashSet<T>(set1);
        result.addAll(set2);
        Set<T> result2 = new HashSet<T>(set1);
        result2.retainAll(set2);

        result.removeAll(result2);
        return result;

    }

}
