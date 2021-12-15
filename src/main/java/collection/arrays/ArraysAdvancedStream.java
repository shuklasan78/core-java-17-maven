package collection.arrays;

import data.FilesEnum;
import data.GetSalesData;
import data.SalesVO;
import lombok.extern.slf4j.Slf4j;

import javax.swing.text.html.parser.Entity;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Slf4j
public class ArraysAdvancedStream {

    public static void main(String[] args) {
        //removePrimitiveUsingList();
        removePrimitiveUsingArrayCopy();
    }

    static void removePrimitive() {
        int[] arr = { 1, 2, 3, 4, 5 };
        int index = 2;
        int[] arr2 = IntStream.range(0, arr.length)
                .filter(i -> i != index)
                .map(i -> arr[i])
                .toArray();
        // Remove the element

        // Print the resultant array
        System.out.println("Resultant Array: "
                + Arrays.toString(arr2));
    }

    static void removePrimitiveUsingList() {
        int[] arr = { 1, 2, 3, 4, 5 };
        // Create ArrayList from the array
        List<Integer> arrayList = IntStream.of(arr)
                .boxed()
                .collect(Collectors.toList());
        int index = 2;
        // Remove the specified element
        arrayList.remove(index);
        // Print the resultant array

        int[] arr2 = arrayList.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        System.out.println("Resultant Array: "
                + Arrays.toString(arr2));
    }
    static void removePrimitiveUsingArrayCopy() {
        // Get the array
        int[] arr = { 1, 2, 3, 4, 5 };
        // Get the specific index
        int index = 2;

        // Create another array of size one less
        int[] anotherArray = new int[arr.length - 1];
        // Copy the elements from starting till index
        // from original array to the other array
        System.arraycopy(arr, 0, anotherArray, 0, index);
        // Copy the elements from index + 1 till end
        // from original array to the other array
        System.arraycopy(arr, index + 1,
                anotherArray, index,
                arr.length - index - 1);
        // Print the resultant array
        System.out.println("Resultant Array: "
                + Arrays.toString(anotherArray));
    }

    private static void deleteElementsUsingForLoop() {
        int[] arr = new int[]{1,2,3,4,5};
        int[] arr_new = new int[arr.length-1];
        int j=3;
        for(int i=0, k=0;i<arr.length;i++){
            if(i!=j){
                arr_new[k]=arr[i];
                k++;
            }
        }
        System.out.println("Before deletion :" + Arrays.toString(arr));
        System.out.println("After deletion :" + Arrays.toString(arr_new));

    }

    private static void removeElementsUsingValue() {
        int[] arr = new int[]{1,2,3,4,5};
        int[] arr_new = new int[arr.length-1];
        int j=3;
        for(int i=0, k=0;i<arr.length;i++){
            if(arr[i]!=j){
                arr_new[k]=arr[i];
                k++;
            }
        }
        System.out.println("Before deletion :" + Arrays.toString(arr));
        System.out.println("After deletion :" + Arrays.toString(arr_new));

    }
}

