
/**
 * Palindrome.java
 * HackerRank Practice: Strings → Java Palindrome
 *
 * This program demonstrates multiple approaches to determine whether a string
 * is a palindrome. A palindrome is a word, phrase, or sequence that reads the
 * same backward as forward.
 *
 * Approaches implemented in this class:
 * - StringBuilder reverse check (concise, O(n) time, O(n) space)
 * - Two-pointer comparison (space-optimized, O(n) time, O(1) space)
 * - Case- and non-alphanumeric-tolerant check (normalizes input before testing)
 *
 * @author Drew Mayberry
 * @since 09-16-2025
 * 
 */
public class Palindrome {

    public static void main(String[] args) {
        String s1 = "poop";
        String s2 = "world";

        // ====Using StringBuilder====
        String reversed = new StringBuilder(s1).reverse().toString();
        System.out.println(s1.equals(reversed) ? "Yes" : "No");

        // ====Two-Pointer Character Comparison (No Extra String)====
        int left = 0;
        int right = s1.length() - 1;
        boolean isPalindrome = true;

        while (left < right) {
            if (s1.charAt(left) != s1.charAt(right)) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }
        System.out.println(isPalindrome ? "Yes" : "No");

        // ====Case / Non-Alphanumeric Tolerant Palindrome====
        String s3 = "A man, a plan, a canal: Panama";

        String cleaned = s3.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        isPalindrome = new StringBuilder(cleaned).reverse().toString().equals(cleaned);
        System.out.println(isPalindrome ? "Yes" : "No");

    }

}
