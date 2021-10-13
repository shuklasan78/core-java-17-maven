package sorting;

import data.Employee;
import data.GetData;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
@Slf4j
public class ImplementMergeSort {


    public static void main(String[] args) {
        getEmployeeArray();
    }


    private static Employee[] getEmployeeArray() {
        long start = System.currentTimeMillis();
        List<Employee> empList = GetData.getListWithTwoMillionRecords();
        long finish = System.currentTimeMillis();
        log.info("Load `time for EmpList :"+Long.valueOf(finish-start).toString());
        Employee[] emp = new Employee[empList.size()];
        start = System.currentTimeMillis();
        emp = empList.toArray(emp);
        finish = System.currentTimeMillis();
        log.info("Time to convert List to Array :"+Long.valueOf(finish-start).toString());
        log.info("Total Number of records :"+empList.size());
        return emp;
    }


    public static void merge(Employee[] a, Employee[] l, Employee[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i].getEmpId() <= r[j].getEmpId()) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }

    }
    public static void mergeSort(Employee[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        Employee[] l = new Employee[mid];
        Employee[] r = new Employee[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }
}
