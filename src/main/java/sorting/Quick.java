package sorting;

import data.Employee;

public class Quick {
    /* function that consider last element as pivot,
place the pivot at its exact position, and place
smaller elements to left of pivot and greater
elements to right of pivot.  */
    int partition(Employee a[], int start, int end) {
        Employee pivot = a[end]; // pivot element
        int i = (start - 1);

        for (int j = start; j <= end - 1; j++) {
            // If current element is smaller than the pivot
            if (a[j].getEmpId() < pivot.getEmpId()) {
                i++; // increment index of smaller element
                Employee t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        Employee t = a[i + 1];
        a[i + 1] = a[end];
        a[end] = t;
        return (i + 1);
    }

    /* function to implement quick sort */
    void quick(Employee a[], int start, int end) /* a[] = array to be sorted, start = Starting index, end = Ending index */ {
        if (start < end) {
            int p = partition(a, start, end);  //p is partitioning index
            quick(a, start, p - 1);
            quick(a, p + 1, end);
        }
    }

    /* function to print an array */
    void printArr(Employee a[], int n) {
        int i;
        for (i = 0; i < n; i++) {
            //System.out.print(a[i].getEmpId() + " ");
        }
    }
}