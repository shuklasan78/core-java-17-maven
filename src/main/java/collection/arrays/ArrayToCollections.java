package collection.arrays;

import data.FilesEnum;
import data.GetSalesData;
import data.SalesVO;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class ArrayToCollections {

    public static void main(String[] args) {
        convertArrayToCollection();
    }

    private static void convertArrayToCollection() {
        String fileName = FilesEnum.SalesRecords5M.toString();
        SalesVO[] salesArr = GetSalesData.getSalesArray(fileName);
        arraysToList(salesArr);
        arraysToSet(salesArr);
        arraysToMap(salesArr);
    }

    private static void arraysToMap(SalesVO[] salesArr) {
        Map<Integer, SalesVO> salesMap = new HashMap<>();
        long start = new Date().getTime();
        salesMap = Arrays.stream(salesArr).collect(Collectors.toMap(p -> p.getOrderID() , p -> p , (n,o) -> o));
        long end = new Date().getTime();
        log.info("Time taken to convert Arrays to Map :" +(end-start));
        System.out.println("The Size of the Map :"+salesMap.size());
    }

    private static void arraysToSet(SalesVO[] salesArr) {
        Set<SalesVO> salesSet = new HashSet<>();
        long start = new Date().getTime();
        salesSet = Arrays.stream(salesArr).collect(Collectors.toSet());
        long end = new Date().getTime();
        log.info("Time taken to convert Arrays to Set :" +(end-start));
        System.out.println("The Size of the Set :"+salesSet.size());
    }

    private static void arraysToList(SalesVO[] salesArr) {
        List<SalesVO> salesList = new ArrayList<>();
        long start = new Date().getTime();
        salesList = Arrays.stream(salesArr).toList();
        long end = new Date().getTime();
        log.info("Time taken to convert Arrays to List :" +(end-start));
        System.out.println("The Size of the List :"+salesList.size());
    }
}
