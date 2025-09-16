
/**
 * Anagram.java
 * HackerRank Prepare: Strings
 * 
 * =====Java Anagrams=====
 * Description:
 * This program determines whether two input strings are anagrams.
 * Two strings are considered anagrams if they contain the same characters
 * with the same frequencies, ignoring case.
 *
 * Approaches implemented in this class:
 *  - Frequency Counting (O(n) time, O(1) space with fixed array)
 *  - Sorting-based Comparison (O(n log n) time)
 *  - Modern Java Streams (illustrative, less efficient)
 * 
 * @author Drew Mayberry
 * @since 09-16-2025
 * 
 */

import java.util.Arrays;
import java.util.stream.IntStream;

public class Anagram {

    public static void main(String[] args) {

        String a = "anagram";
        String b = "margana";

        // Quick length check
        if (a.length() != b.length()) {
            System.out.println("Not Anagrams");
            return;
        }

        int[] counts = new int[26]; // frequency array

        for (char c : a.toCharArray()) {
            counts[c - 'a']++;
        }

        for (char c : b.toCharArray()) {
            counts[c - 'a']--;
        }

        // Verify all counts are zero
        for (int count : counts) {
            if (count != 0) {
                System.out.println("Not Anagrams");
                return;
            }
        }
        System.out.println("Anagrams");

        // ====Sorting Both====
        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        System.out.println(Arrays.equals(arrA, arrB) ? "Anagrams" : "Not Anagrams");

        // =====Streams / Modern Java=====
        String c = "anagram";
        String d = "margana";

        boolean isAnagram = c.length() == d.length() &&
                IntStream.range(0, c.length()).map(i -> c.toLowerCase().charAt(i) - d.toLowerCase().charAt(i))
                        .sum() == 0;

        System.out.println(isAnagram ? "Anagrams" : "Not Anagrams");

    }

}
