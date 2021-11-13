package collection;

import data.FilesEnum;
import data.GetSalesData;
import data.SalesVO;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class ListAdvancedStream {

    public static void main(String[] args) {
        String record = FilesEnum.SalesRecords2M.toString();
        //convertListToCollections(record);
        //sortList(record);   //collection.sort is giving better performnce.
        //removeDuplicateFromList(record);
        //mergeList(record);
        //searchInList(record);
    }

    private static void searchInList(String record) {
        List<SalesVO> salesVOList1 = GetSalesData.getSalesRecord(record);
        long start = new Date().getTime();
        //138297116  for 2m records
        SalesVO sales = salesVOList1.stream()
                .filter(saless -> 289606320 == saless.getOrderID())
                .findAny()
                .orElse(null);
        long end = new Date().getTime();
        log.info("Reason1 : " + sales.getRegion() + "  Country  " + sales.getCountry() + "   Stream takes less Time in 2M records   :" + (end - start));
        start = new Date().getTime();
        //This takes more time in searching
        for (SalesVO s : salesVOList1) {
            if (s.getOrderID() == 138297116) {
                end = new Date().getTime();
                log.info("Reason2 : " + s.getRegion() + "  Country  " + s.getCountry() + "   For takes More time Time in 2M records   :" + (end - start));
            }
        }
            for (SalesVO sss : salesVOList1) {
                if (sss.getRegion().startsWith("Itarra")) {
                    end = new Date().getTime();
                    log.info("Reason3 : " + sss.getRegion() + "  Country  " + sss.getCountry() + "   For takes More time Time in 2M records   :" + (end - start));
                }

            }

    }
    private static void mergeList(String record) {
        List<SalesVO> salesVOList1 = GetSalesData.getSalesRecord(record);
        List<SalesVO> salesVOList2 = GetSalesData.getSalesRecord(record);
        long start = new Date().getTime();
        salesVOList1.addAll(salesVOList2);
        long end = new Date().getTime();
        log.info("Merging the list in traditionalWay Time taken :"+(end-start)+"   List Size is :"+salesVOList1.size());
        salesVOList1.clear();
        salesVOList2.clear();

        List<SalesVO> salesVOList3 = GetSalesData.getSalesRecord(record);
        List<SalesVO> salesVOList4 = GetSalesData.getSalesRecord(record);

        start = new Date().getTime();
        List<SalesVO> combinedList = Stream.of(salesVOList3, salesVOList4)
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());
        end = new Date().getTime();
        System.out.println("Merging the list in Stream Time taken :"+(end-start)+"   List Size is :"+combinedList.size());

        start = new Date().getTime();
        Set<SalesVO> mergeSet = new LinkedHashSet<>(salesVOList3);
        mergeSet.addAll(salesVOList4);
        end = new Date().getTime();
        System.out.println("Merging the list in Stream Using Set Time taken :"+(end-start)+"   List Size is :"+mergeSet.size());

        start = new Date().getTime();
        Stream<SalesVO> stream1 = salesVOList3.stream();
        Stream<SalesVO> stream2= salesVOList4.stream();
        List<SalesVO> joinedList = Stream.concat(stream1, stream2).collect(Collectors.toList());
        end = new Date().getTime();
        System.out.println("Merging the list in Stream Using stream Time taken :"+(end-start)+"   List Size is :"+joinedList.size());

    }

    private static void removeDuplicateFromList(String record) {
        record = FilesEnum.SalesRecords5M.toString();
        List<SalesVO> salesVOList = GetSalesData.getSalesRecord(record);
        long start = new Date().getTime();
        LinkedHashSet<SalesVO> hashSet = new LinkedHashSet<>(salesVOList);
        ArrayList<SalesVO> listWithoutDuplicates = new ArrayList<>(hashSet);
        long end = new Date().getTime();
        log.info("ListWithout Duplicate Time Taken using LinkedHashSet :"+(end-start)+"  Size of List is :=    "+listWithoutDuplicates.size());


        start = new Date().getTime();
        List<SalesVO> listWithoutDuplicates2 = salesVOList.stream().distinct().collect(Collectors.toList());
        end = new Date().getTime();
        log.info("ListWithout Duplicate Time Taken using Stream distinct  :"+(end-start)+"  Size of List is :=    "+listWithoutDuplicates2.size());


    }

    private static void sortList(String record) {
        List<SalesVO> salesVOList = GetSalesData.getSalesRecord(record);
        long start = new Date().getTime();
        List<SalesVO> salesVOList1 = salesVOList.stream().sorted(Comparator.comparing(p->p.getOrderID())).collect(Collectors.toList());
        long end = new Date().getTime();
        log.info("Time Taken for sorting the list :"+(end-start)+"  Size of List is :=    "+salesVOList1.size());
        start = new Date().getTime();
        List<SalesVO> salesVOList2 = salesVOList.stream().sorted((a,b) -> a.getOrderID() - b.getOrderID()).collect(Collectors.toList());
        end = new Date().getTime();
        log.info("Time Taken for sorting-II the list :"+(end-start)+"  Size of List is :=    "+salesVOList2.size());

        start = new Date().getTime();
        List<SalesVO> salesVOList3 = salesVOList.stream().sorted((a,b) -> a.getOrderID() - b.getOrderID()).collect(Collectors.toList());
        end = new Date().getTime();
        Collections.sort(salesVOList3,(a,b) -> a.getOrderID() - b.getOrderID());
        log.info("Time Taken for sorting-III the list :"+(end-start)+"  Size of List is :=    "+salesVOList3.size());

        SalesVO first = salesVOList.stream().findFirst().get();
        start = new Date().getTime();
       // Optional<SalesVO> last=salesVOList.stream().sorted((a,b)->-1).findFirst(); // very important concept
        SalesVO lstElement = salesVOList.get(salesVOList.size() - 1);
        end = new Date().getTime();
        log.info("Time Taken to sort again  :"+(end-start)+"    FirstElement :"+first.getOrderID() +"     LastEmelemt   :"+lstElement.getOrderID());
    }


    private static void convertListToCollections(String record) {
        List<SalesVO> salesVO = GetSalesData.getSalesRecord(record);
        convertListToArrays(record, salesVO);
        convertListToSet(record, salesVO);
        convertListToMap(record, salesVO);

    }

    private static void convertListToMap(String toString, List<SalesVO> salesVO) {
        long start = new Date().getTime();
        Map<Integer,SalesVO> salesMap = salesVO.stream().collect(Collectors.toMap(p -> p.getOrderID() , p -> p, (n,o) -> n));
        long end = new Date().getTime();
        log.info("Time Taken to convert List to Set :"+(end-start)+"  Size of Set is :=    "+salesMap.size());

    }

    private static void convertListToSet(String toString, List<SalesVO> salesVO) {
        long start = new Date().getTime();
        Set<SalesVO> salesSet = salesVO.stream().collect(Collectors.toSet());
        long end = new Date().getTime();
        log.info("Time Taken to convert List to Set :"+(end-start)+"  Size of Set is :=    "+salesSet.size());
    }

    private static void convertListToArrays(String toString,  List<SalesVO> salesVOList) {
        long start = new Date().getTime();
        SalesVO[] salesArr = new SalesVO[salesVOList.size()];
        salesArr = salesVOList.toArray(salesArr);
        long end = new Date().getTime();
        log.info("Time Taken to convert List to Array :"+(end-start)+"  Size of Set is :=    "+salesArr.length);
    }


}
