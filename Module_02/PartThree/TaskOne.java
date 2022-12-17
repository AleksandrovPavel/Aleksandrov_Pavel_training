package PartThree;

public class TaskOne {
    public static boolean isPalindrome(String text) {

        String text1 = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String text2 = new StringBuilder(text1).reverse().toString();
        return text1.equals(text2);
    }
}
