package Interview.search;
/**
 * In computer science, linear search or sequential search is a method for
 * finding a target value within a list. It sequentially checks each element of
 * the list for the target value until a match is
 * found or until all the elements have been searched.
 * <p>
 * Worst-case performance      O(n)<br>
 * Best-case performance       O(1)<br>
 * Average performance         O(n)<br>
 * Worst-case space complexity O(1)<br>
 * <p>
 * @see <a href="https://en.wikipedia.org/wiki/Linear_search">Linear Search (Wikipedia)</a>
 * <br>
 * @author Sandeep Kumar Shukla
 */
public class LinearSearch {

    public static void main(String[] args) {

    }

    public static final int unorderedLinearSearch(int value, int[] array) {
        for (int i = 0; i < array.length; i++) {
            int iValue = array[i];
            if (value == iValue)
                return i;
        }
        return Integer.MAX_VALUE;
    }

    public static final int orderedLinearSearch(int value, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (value == array[i]){
                return i;
            }
            else if (array[i] > value){
                return -1;
            }
        }
        return Integer.MAX_VALUE;
    }
}
