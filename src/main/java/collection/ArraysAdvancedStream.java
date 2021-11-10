package collection;

import data.FilesEnum;
import data.GetSalesData;
import data.SalesVO;
import lombok.extern.slf4j.Slf4j;

import javax.swing.text.html.parser.Entity;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class ArraysAdvancedStream {

    public static void main(String[] args) {
        //convertArraysToCollections();
        removeDuplicatesFromArrays();
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

    }

    private static void removeDuplicatesFromArrays() {
        SalesVO[] salesArr = GetSalesData.getSalesArray(FilesEnum.SalesRecords100Duplicate.toString());
        log.info("Total Arrays number:"+salesArr.length);
        SalesVO[] salesArrDistinct =  Arrays.stream(salesArr).distinct().toArray(SalesVO[]::new);
        log.info("Total distinct Arrays :"+salesArrDistinct.length);


        // Extract Duplicate duplicate from Array and store them in Set
        Set<SalesVO> duplicateSet = Arrays.stream(salesArr)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .filter(m -> m.getValue()>1)
                .map((Map.Entry::getKey))
                .collect(Collectors.toSet());
        System.out.println("Duplicate Set :"+duplicateSet.size());
        for (SalesVO salesVO : duplicateSet) {
            log.info("Duplicate Id's are :"+salesVO.getOrderID());
        }
        //Extract to Set using list
        duplicateSet = Arrays.asList(salesArr)
                .stream().filter(i -> Collections.frequency(Arrays.stream(salesArr).toList(),1)>1).collect(Collectors.toSet());


        //Best solution to get the duplicate from arrays
        Map<Integer, Integer> duplicateValueMap = new HashMap<>();
        for(SalesVO salesVO : salesArr) {
            Integer count = duplicateValueMap.get(salesVO.getOrderID());
            if( count == null) {
                duplicateValueMap.put(salesVO.getOrderID(),1);
            } else {
                duplicateValueMap.put(salesVO.getOrderID(), ++count);
            }
        }
        //print duplicate values
        Set<Map.Entry<Integer,Integer>>  setEntry = duplicateValueMap.entrySet();
        for(Map.Entry<Integer,Integer> ent : setEntry) {
            if(ent.getValue()>1) {
                log.info("Duplicate ID are :"+ent.getKey()+"  Name  :"+ent.getKey()+"   Value  :"+ent.getValue());
            }
        }
    }



}
