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
        //convertArraysToCollections();
        //removeDuplicatesFromArrays();
        //sortingArrays();
        mergingArrays();
    }

    private static void mergingArrays() {

        SalesVO[] arr1 = GetSalesData.getSalesArray(FilesEnum.SalesRecordsBasic1.toString());
        SalesVO[] arr2 = GetSalesData.getSalesArray(FilesEnum.SalesRecordsBasic2.toString());
        SalesVO[] bks = (SalesVO[]) Stream.concat(Stream.of(arr1), Stream.of(arr2)).toArray(b -> new SalesVO[b]);
        //        Set<Book> set = Stream.concat(set1.stream(), set2.stream()).collect(Collectors.toSet());
        //        List<Book> list = Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
        System.out.println("`The size of the combine array is :"+bks.length);
    }

    private static void convertArraysToCollections() {
        SalesVO[] salesArr = GetSalesData.getSalesArray(FilesEnum.SalesRecords100Duplicate.toString());
        log.info("The size of the array is :"+salesArr.length);
        //converting Arrays to List
        List<SalesVO> salesList = Arrays.stream(salesArr).collect(Collectors.toList());
        log.info("The size of the List is :"+salesList.size());
        //Convert Arrays to Set
        Set<SalesVO> salesSet = Arrays.stream(salesArr).collect(Collectors.toSet());
        log.info("The size of the set is :"+salesSet.size());
        //convert arrays to Map case I - When duplicate keys
        Map<Integer, SalesVO> salesMap = Arrays
                .stream(salesArr)
                .collect(Collectors.toMap(p->p.getOrderID(),p->p, (n,o)->n));
        log.info("The size of the Map is :"+salesMap.size());
        //convert arrays to Map case I - When duplicate keys and add them as list
        Map<Integer, List<SalesVO>> salesMapGrouping = Arrays
                .stream(salesArr)
                .collect(Collectors.groupingBy(p->p.getOrderID(),Collectors.toList()));
        log.info("The size of the Map after grouping :"+salesMap.size());

    }

    private static void sortingArrays() {
        SalesVO[] salesArr = GetSalesData.getSalesArray(FilesEnum.SalesRecords5M.toString());
        sortArrays(salesArr);
    }

    private static void sortArrays(SalesVO[] salesArr) {
        long start = new Date().getTime();
        Arrays.sort(salesArr, Comparator.comparing(SalesVO::getOrderID));
        Arrays.sort(salesArr, Comparator.comparing(p -> p.getOrderID()));

        long end = new Date().getTime();
        log.info("Time taken :" +(end-start));
        for(SalesVO intg : salesArr) {
            //log.info("Order Id "+intg.getOrderID() +"  Country   :"+intg.getCountry());
        }

    }

    //Using Hashmap gives best result in removing duplicate from array for 2M records
    private static void removeDuplicatesFromArrays() {
        SalesVO[] salesArr = GetSalesData.getSalesArray(FilesEnum.SalesRecords2M.toString());
        log.info("Total Number of Records Including Duplicates :"+salesArr.length);
        getDistinctArray(salesArr);
        removeDuplicateFromArrayByPlacingInSet(salesArr);   // best performance
        getDistinctElementfromArrayAndStoreInMap(salesArr);
        extractDuplicateRecordsFromArrayInSet(salesArr);

    }

    private static SalesVO[] getDistinctArray( SalesVO[] salesArr) {
        long start = new Date().getTime();
        SalesVO[] salesArrDistinct =  Arrays.stream(salesArr).distinct().toArray(SalesVO[]::new);
        long end = new Date().getTime();
        log.info("Time Taken to Process distinct Logic In Array :"+String.valueOf(end-start));
        log.info("Total records in distinctArray :"+salesArrDistinct.length);

        return salesArrDistinct;
    }

    private static Set<SalesVO> extractDuplicateRecordsFromArrayInSet( SalesVO[] salesArr) {
        long start = new Date().getTime();
        Set<SalesVO> duplicateSet = Arrays.stream(salesArr)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .filter(m -> m.getValue()>1)
                .map((Map.Entry::getKey))
                .collect(Collectors.toSet());
        long end = new Date().getTime();
        log.info("Time taken for extractDuplicateRecordsFromArrayInSet:"+String.valueOf(end-start));
        log.info("Total Number of Duplicate recodrs in Set are : :"+duplicateSet.size());

        return duplicateSet;
    }

    private static void getDistinctElementfromArrayAndStoreInMap( SalesVO[] salesArr) {
        long start = new Date().getTime();
        Map<SalesVO, Integer> duplicateValueMap = new HashMap<>();
        for(SalesVO salesVO : salesArr) {
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

    private static void removeDuplicateFromArrayByPlacingInSet(SalesVO[] sales) {
        long start = new Date().getTime();
        Set<SalesVO> nonDuplicateSet = Arrays.stream(sales).collect(Collectors.toSet());
        long end = new Date().getTime();
        log.info("Time Taken to Process records from removing duplicate from array and placing in Set :"+String.valueOf(end-start));
        log.info("nonDuplicateSet has records :"+nonDuplicateSet.size());

    }

    private static void addElementToArray(SalesVO[] sales) {
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
    }
}
