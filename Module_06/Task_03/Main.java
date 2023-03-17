import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int flag = 0;
        while (scanner.hasNextInt()) {
            if (flag % 2 != 0) {
                list.add(scanner.nextInt());
            } else {
                scanner.next();
            }
            flag++;
        }
        Collections.reverse(list);
        for (Integer elem : list) {
            System.out.print(" " + elem);
        }
    }
}
