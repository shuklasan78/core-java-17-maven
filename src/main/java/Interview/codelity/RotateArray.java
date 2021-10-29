package Interview.codelity;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class RotateArray {

    public static void main(String[] args) {
//https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/
        int [] arr = new int [] {1, 2, 3, 4, 5};
        //n determine the number of times an array should be rotated.
        int n = 1;
        getRotatedArray(arr , n);
    }

    private static void getRotatedArray( int [] arr , int n) {

        //Rotate the given array by n times toward right
        for(int i = 0; i < n; i++){
            int j, last;
            //Stores the last element of array
            last = arr[arr.length-1];

            for(j = arr.length-1; j > 0; j--){
                //Shift element of array by one
                arr[j] = arr[j-1];
            }
            //Last element of array will be added to the start of array.
            arr[0] = last;
        }
        List<Integer> integerList1 = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println("The arrays values are :"+ integerList1);
    }
}
