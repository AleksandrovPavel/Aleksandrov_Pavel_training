package PartFour;

import java.util.Arrays;

public class TaskTwo {
    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] result = Arrays.copyOf(a1, a1.length + a2.length);
        System.arraycopy(a2, 0, result, a1.length, a2.length);
        Arrays.sort(result);
        return result;
    }
}
