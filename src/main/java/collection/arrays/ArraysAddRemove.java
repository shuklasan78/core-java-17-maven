package collection.arrays;

import data.FilesEnum;
import data.GetSalesData;
import data.SalesVO;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class ArraysAddRemove {
    public static void main(String[] args) {
        removeDuplicateFromArrays("");
    }

    private static void removeDuplicateFromArrays(String filenName) {
        String fileName1 = FilesEnum.SalesRecords2M.toString();
        removeDuplicateElementFromArrayByPlacingInSet(fileName1);
        removeDuplicateElementFromArrayByUsingDistinctArray(fileName1);
        extractDuplicateElementFromArrayAndStoreInSet(fileName1);
        getDistinctElementfromArrayAndStoreInMap(fileName1);
        addElementToArray(fileName1);
    }

    private static void removeDuplicateElementFromArrayByPlacingInSet(String filenName) {
        SalesVO[] arr = GetSalesData.getSalesArray(filenName);
        long start = new Date().getTime();
        Set<SalesVO> salesDistincElements = Arrays.stream(arr).collect(Collectors.toSet());
        long end = new Date().getTime();
        log.info("Time Taken to removeDuplicateElementFromArrayByPlacingInSet :"+String.valueOf(end-start));
        System.out.println("salesDistincElements :"+salesDistincElements.size());
    }

    private static void removeDuplicateElementFromArrayByUsingDistinctArray(String filenName) {
        SalesVO[] arr = GetSalesData.getSalesArray(filenName);
        long start = new Date().getTime();
        SalesVO[] arr2 = Arrays.stream(arr).distinct().toArray(SalesVO[]::new);
        long end = new Date().getTime();
        log.info("Time Taken to removeDuplicateElementFromArrayByUsingDistinctArray :"+String.valueOf(end-start));
        System.out.println("Original array Size :"+arr.length +"  Distinct Array Size :"+arr2.length);

    }

    private static void extractDuplicateElementFromArrayAndStoreInSet(String filenName) {
        SalesVO[] arr = GetSalesData.getSalesArray(filenName);
        long start = new Date().getTime();
        Map<SalesVO, Long> duplicateMap = Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        Set<SalesVO> salesDuplicateSetElements = duplicateMap.entrySet().stream()
                .filter(m -> m.getValue()>1)
                .map((Map.Entry::getKey))
                .collect(Collectors.toSet());
        long end = new Date().getTime();
        log.info("Time Taken to extractDuplicateElementFromArrayAndStoreInSet :"+String.valueOf(end-start));
        System.out.println("Extracted size of the Set :"+salesDuplicateSetElements.size());

    }

    private static void getDistinctElementfromArrayAndStoreInMap(String filenName) {
         SalesVO[] arr = GetSalesData.getSalesArray(filenName);
        long start = new Date().getTime();
         Map<SalesVO, Integer> duplicateValueMap = new HashMap<>();
         for(SalesVO salesVO : arr) {
             Integer count = duplicateValueMap.get(salesVO.getOrderID());
             if( count == null) {
                 duplicateValueMap.put(salesVO,1);
             } else {
                 duplicateValueMap.put(salesVO, ++count);
             }
         }
         //print duplicate values
         Set<Map.Entry<SalesVO,Integer>>  setEntry = duplicateValueMap.entrySet();
         for(Map.Entry<SalesVO,Integer> ent : setEntry) {
             if(ent.getValue()>1) {
                 //log.info("Duplicate ID are :"+ent.getKey()+"  Name  :"+ent.getKey()+"   Value  :"+ent.getValue());
             }
         }
         long end = new Date().getTime();
         log.info("Time Taken to Process records from removing duplicate from array and placing in Map :"+String.valueOf(end-start));
         log.info("Total records in Map After removing duplicate from Array :"+duplicateValueMap.size());
     }

    private static void addElementToArray(String filenName) {
        SalesVO[] arr = GetSalesData.getSalesArray(filenName);
        SalesVO item = new SalesVO();
        item.setRegion("UP");
        item.setCountry("India");
        item.setItemType("Cosmetics");
        item.setSalesChannel("Online");
        item.setOrderPriority("H");
        item.setOrderDate("7/20/2021");
        item.setOrderID(660993374);
        item.setShipDate("7/20/2020");
        item.setUnitsSold(9654);
        item.setUnitPrice(437.20);
        item.setUnitCost(263.33);
        item.setTotalRevenue(4220728.80);
        item.setTotalCost(2542187.82);
        item.setTotalProfit(1678540.98);
        long start = new Date().getTime();
        SalesVO[] addSalesDataArr = {item};
        long end = new Date().getTime();
        log.info("Time Taken to add element in SalesVO :"+String.valueOf(end-start));

    }
}
