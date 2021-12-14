package collection.arrays;

import data.FilesEnum;
import data.GetSalesData;
import data.SalesVO;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Slf4j
public class SearchingArrays {

    public static void main(String[] args) {
        searchArrays();
    }

    private static void searchArrays() {
        String fileName = FilesEnum.SalesRecords5M.toString();
        linearSearchArray(fileName);
        listContains(fileName);
        streamSearch(fileName);
        binarySearch(fileName);
    }

    private static void linearSearchArray(String fileName) {
        SalesVO[] salesArr = GetSalesData.getSalesArray(fileName);
        var isFound = false;
        long start = new Date().getTime();
        for (SalesVO element : salesArr) {
            if (element.getOrderID() == 823702800) {
                isFound = true;
                System.out.println("The id found is :"+element.getOrderID());
            }
        }
        long end = new Date().getTime();
        log.info("Time taken for linear search :" +(end-start));
    }



    private static void listContains(String fileName) {
        SalesVO[] salesArr = GetSalesData.getSalesArray(fileName);
        var isFound = false;
        long start = new Date().getTime();
        boolean test = Arrays.asList(salesArr).contains(823702800);
        long end = new Date().getTime();
        System.out.println("Is " + 823702800 + " present in the array: " + test);
        log.info("Time taken using List search :" +(end-start));
    }

    private static void streamSearch(String fileName) {
        SalesVO[] salesArr = GetSalesData.getSalesArray(fileName);
        var isFound = false;
        long start = new Date().getTime();
        Predicate<SalesVO> orderId = e -> e.getOrderID() == 823702800;
        boolean result = Arrays.stream(salesArr).anyMatch(orderId);
        System.out.println("Is " + 823702800 + " present in the array: " + result);
        long end = new Date().getTime();
        log.info("Time taken for searching using streams:" +(end-start));
    }
    //best performance
    private static void binarySearch(String fileName) {
        SalesVO[] salesArr = GetSalesData.getSalesArray(fileName);
        //first sort the arrays before you go for binary search
        long start = new Date().getTime();
        Function<SalesVO, Integer> funcbyOrderId = SalesVO::getOrderID;
        Comparator<SalesVO> comparestr = Comparator.comparing(funcbyOrderId);
        Arrays.stream(salesArr).sorted(comparestr);
        SalesVO item = new SalesVO();
        item.setOrderID(823702800);
        int res = Arrays.binarySearch(salesArr, item, comparestr);
        boolean test = res > 0 ? true : false;
        System.out.println("Is " + 823702800 + " present in the array: " + test);
        long end = new Date().getTime();
        log.info("Time taken for binary search :" +(end-start));

    }
}
