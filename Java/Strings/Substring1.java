
/**
 * Substring1.java
 * HackerRank Practice: Strings → Java Substring Comparisons
 *
 * Description:
 * This program finds the lexicographically smallest and largest substrings
 * of a given length from an input string.
 *
 * Two approaches are demonstrated in this class:
 *  - Iterative comparison using substring and compareTo (O(n * k))
 *  - Modern Java Streams with IntStream (O(n * k), more declarative style)
 *
 * @author Drew Mayberry
 * @since 09-16-2025
 * 
 */
import java.util.stream.IntStream;

public class Substring1 {

    public static void main(String[] args) {

        String string = "helloworldjava";
        int num = 3;
        int n = string.length();

        String largestSubstring = string.substring(0, num);
        String smallestSubstring = string.substring(0, num);

        for (int i = 0; i <= n - num; i++) {
            String current = string.substring(i, i + num);
            if (current.compareTo(largestSubstring) > 0) {
                largestSubstring = current;
            }
            if (current.compareTo(smallestSubstring) < 0) {
                smallestSubstring = current;
            }
        }

        System.out.println(smallestSubstring);
        System.out.println(largestSubstring);

        // Modern Optimized
        String smallest = IntStream.rangeClosed(0, n - num)
                .mapToObj(i -> string.substring(i, i + num)).min(String::compareTo).get();

        String largest = IntStream.rangeClosed(0, n - num).mapToObj(i -> string.substring(i, i + num))
                .max(String::compareTo).get();

        System.out.println(smallest);
        System.out.println(largest);

    }
}
