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
        String fileName1 = FilesEnum.SalesRecords5M.toString();
        //removeDuplicateElementFromArrayByPlacingInSet(fileName1);
        //removeDuplicateElementFromArrayByUsingDistinctArray(fileName1);
        //extractDuplicateElementFromArrayAndStoreInSet(fileName1);
        //getDistinctElementfromArrayAndStoreInMap(fileName1);
        //addElementToArray(fileName1);
        //addElementToArrayAtIndex(fileName1);
        addElementToArrayUsingList(fileName1);
        //removeElementsFromArraysUisngStreamsByIndex(fileName1);
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

    private static void addElementToArrayAtIndex(String filenName) {
        SalesVO[] srcArray = GetSalesData.getSalesArray(filenName);
        int index = 15;
        System.out.println("Size of the arr Before Adding :"+srcArray.length +"   srcArray[20]    :"+srcArray[15]);
        SalesVO newElement = getItem();
        long start = new Date().getTime();//adding element at the end of the array index.
        SalesVO[] destArray = new SalesVO[srcArray.length+1];
        int j = 0;
        for(int i = 0; i < destArray.length-1; i++) {

            if(i == index) {
                destArray[i] = newElement;
            } else {
                destArray[i] = srcArray[j];
                j++;
            }
        }
        long end = new Date().getTime();
        log.info("Time Taken to add element in SalesVO :"+String.valueOf(end-start));
        System.out.println("Size of the arr After Adding :"+destArray.length+"  srcArray[20]  "+ destArray[15] );

    }

    private static void addElementToArrayUsingList(String filenName) {
        SalesVO[] srcArray = GetSalesData.getSalesArray(filenName);
        System.out.println("Size of the arr Before Adding :"+srcArray.length);
        SalesVO item = getItem();
        long start = new Date().getTime();//adding element at the end of the array index.
        List<SalesVO> arrList = new ArrayList( Arrays.asList(srcArray));
        arrList.add(item);
        arrList.add(1,item);
        //Convert the arraylist back to an array
        SalesVO[] arr = new SalesVO[arrList.size()];
        arr = arrList.toArray(arr);
        long end = new Date().getTime();
        log.info("Time Taken to add element in SalesVO :"+String.valueOf(end-start));
        System.out.println("Size of the arr After Adding :"+arr.length);
        //rodrigo.hammerly@capgemini.com
    }

    private static void addElementToArray(String filenName) {
        SalesVO[] arr = GetSalesData.getSalesArray(filenName);
        System.out.println("Size of the arr Before Adding :"+arr.length);
        SalesVO item = getItem();
        long start = new Date().getTime();//adding element at the end of the array index.
        SalesVO[] destArray = Arrays.copyOf(arr, arr.length + 1);
        destArray[destArray.length - 1]= item;
        long end = new Date().getTime();
        log.info("Time Taken to add element in SalesVO :"+String.valueOf(end-start));
        System.out.println("Size of the arr After Adding :"+destArray.length);

    }
    private static void removeElementsFromArraysUisngStreamsByIndex(String filenName) {
        SalesVO[] arr = GetSalesData.getSalesArray(filenName);
        System.out.println("Size of the arr Before deleting :"+arr.length);
        long start = new Date().getTime();
        System.out.println("Size of the arr :"+arr.length);

        Arrays.stream(arr).collect(Collectors.toList()).removeIf(p -> p.getOrderID() ==810711038);
        //arr = removeTheElement(arr, index);
        long end = new Date().getTime();
        log.info("Time Taken to remove element in SalesVO :"+String.valueOf(end-start));
        System.out.println("Size of the arr after deleting :"+arr.length);
    }

    private static SalesVO getItem() {
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
        return item;
    }
}
