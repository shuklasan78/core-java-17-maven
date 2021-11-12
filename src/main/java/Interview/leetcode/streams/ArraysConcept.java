package Interview.leetcode.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysConcept {

    public static void main(String[] args) {
        leetArrays();
    }

    private static void leetArrays() {
        int[] nums = {1,1,0,0,5};
        List<Integer> intList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        System.out.println("The values of list is :"+intList);
    }
}
