package sorting;

/**
 * Quicksort is another Divide and Conquer algorithm. It picks one element of an array as the pivot and sorts all of the other elements around it,
 * for example smaller elements to the left, and larger to the right.
 * This guarantees that the pivot is in its proper place after the process. Then the algorithm recursively does the same for the left and
 * right portions of the array.
 * One of the reasons it is preferred to Merge Sort is that it doesn't take any extra space, all of the sorting is
 * done in-place, and there's no expensive allocation and deallocation calls
 */
public class Quicksort {

    static int partition(int[] array, int begin, int end) {
        int pivot = end;

        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[pivot]) {
                int temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }
        int temp = array[pivot];
        array[pivot] = array[counter];
        array[counter] = temp;

        return counter;
    }

    public static void quickSort(int[] array, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot-1);
        quickSort(array, pivot+1, end);
    }
}
