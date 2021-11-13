package collection;

import data.FilesEnum;
import data.GetSalesData;
import data.SalesVO;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class SetAdvancedStream  {

    public static void main(String[] args) {
        String records = FilesEnum.SalesRecords2M.toString();
        //convertSetToCllections(records);
        sortSet(records);   //collection.sort is giving better performnce.
        removeDuplicateFromSet(records);
        mergeSet(records);
        searchInSet(records);
    }

    private static void searchInSet(String records) {
        long start = new Date().getTime();
        long end = new Date().getTime();
        long difference = end - start ;

        start = new Date().getTime();
        end = new Date().getTime();
        difference = end - start ;
    }

    private static void mergeSet(String records) {
        long start = new Date().getTime();
        long end = new Date().getTime();
        long difference = end - start ;


        start = new Date().getTime();
        end = new Date().getTime();
        difference = end - start ;
    }

    private static void removeDuplicateFromSet(String records) {
        long start = new Date().getTime();
        long end = new Date().getTime();
        long difference = end - start ;

        start = new Date().getTime();
        end = new Date().getTime();
        difference = end - start ;
    }

    private static void sortSet(String records) {
        Set<SalesVO> salesSet = GetSalesData.getSalesSet(records);
        long start = new Date().getTime();
        Set<SalesVO> salesSetSorted = GetSalesData.getSalesSet(records).stream().sorted((p,q) -> p.getOrderID()-q.getOrderID()).collect(Collectors.toSet());
        long end = new Date().getTime();
        long difference = end - start ;
        log.info("Times Takn to Sort the Set Using Stream :"+difference+"  Size of the Sorted Set Is :"+salesSetSorted.size());
        log.info("First Element In Set :"+salesSetSorted.stream().findFirst().get().getOrderID());
        long count = salesSet.stream().count();
        Stream<SalesVO> stream = salesSet.stream();
        log.info("Last Element In Set :"+stream.skip(count - 1).findFirst().get().getOrderID());
        salesSet.clear();
        salesSetSorted.clear();
        Set<SalesVO> salesSet2 = GetSalesData.getSalesSet(records);
        start = new Date().getTime();
        Collections.sort(salesSet2.stream().collect(Collectors.toList()), new SalesComparator());
        end = new Date().getTime();
        difference = end - start ;
        log.info("Times Takn to Sort the Set using Collection :"+difference+"  Size of the Sorted Set Is :"+salesSet2.size());

    }


    private static void convertSetToCllections(String records) {
        long start = new Date().getTime();
        Set<SalesVO> salesSet = GetSalesData.getSalesSet(records);
        long end = new Date().getTime();
        long difference = end - start ;
        log.info("Time taken to load data in set :"+difference+"  Size of the Set :"+salesSet.size());

        start = new Date().getTime();
        List<SalesVO> salesListFromSet = salesSet.stream().collect(Collectors.toList());
        end = new Date().getTime();
        difference = end - start ;
        log.info("Time taken to convert Set to List :"+difference+"  Size of the List :"+salesListFromSet.size());

        start = new Date().getTime();
        SalesVO[] salesArrFromSet = new SalesVO[salesSet.size()];
        salesArrFromSet = salesSet.toArray(salesArrFromSet);
        end = new Date().getTime();
        difference = end - start ;
        log.info("Time taken to convert Set to Arrays :"+difference+"  Size of the List :"+salesArrFromSet.length);

        start = new Date().getTime();
        Map<Integer,SalesVO> salesMapFromSet = salesSet.stream().collect(Collectors.toMap(p -> p.getOrderID(), p -> p));
        end = new Date().getTime();
        difference = end - start ;
        log.info("Time taken to convert Set to Map :"+difference+"  Size of the List :"+salesMapFromSet.size());


    }

}
class SalesComparator implements Comparator<SalesVO>{
    @Override
    public int compare(SalesVO o1, SalesVO o2) {
        if (o1.getOrderID() < o2.getOrderID()) {
            return 1;
        } else {
            return -1;
        }

    }
}