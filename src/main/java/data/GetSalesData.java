package data;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GetSalesData {

    public static void main(String[] args) {
        System.out.println("Size  :"+getSalesSet("1K").size());
    }

    public static List<SalesVO> getSalesRecord5M(){
        List<SalesVO> originalList = CSVDataProcessor.readSalesCSVFile(FilesEnum.SalesRecords5M.toString());
        return originalList;
    }

    public static List<SalesVO> getSalesRecord2M(){
        List<SalesVO> originalList = CSVDataProcessor.readSalesCSVFile(FilesEnum.SalesRecords2M.toString());
        return originalList;
    }

    public static List<SalesVO> getSalesRecord1K(){
        List<SalesVO> originalList = CSVDataProcessor.readSalesCSVFile(FilesEnum.SalesRecords1000.toString());
        return originalList;
    }

    private static List<SalesVO> getSalesVOList(String records) {
        List<SalesVO> salesList = null;
        if(records.equals("1K")) {
            salesList = getSalesRecord1K();
        } else if(records.equals("2M")) {
            salesList = getSalesRecord2M();
        } else if (records.equals("5M")) {
            salesList = getSalesRecord5M();
        }
        return salesList;
    }

    public static SalesVO[] getSalesArray(String records) {
        List<SalesVO> salesList = getSalesVOList(records);
        SalesVO[] salesArr = new SalesVO[salesList.size()];
        salesArr = salesList.toArray(salesArr);
        return salesArr;
    }

    public static Map<Integer, SalesVO> getSalesMap(String records) {
        //convert list to map
        List<SalesVO> salesList = getSalesVOList(records);
        Map<Integer,SalesVO> salesMap = new HashMap<>();
        //salesMap = salesList.stream().collect(Collectors.toMap(SalesVO :: getOrderID, Function.identity()));
        salesMap = salesList
                .stream()
                .collect(Collectors.toMap(SalesVO::getOrderID,Function.identity(), (o,n)->n));

        salesMap = salesList
                .stream()
                .collect(Collectors.toMap(SalesVO::getOrderID,SalesVO-> SalesVO, (o,n)->n));

        salesMap = salesList
                .stream()
                .collect(Collectors.toMap(P -> P.getOrderID(), P-> P, (o,n)->n));

        return salesMap;
    }

    public static Set<SalesVO> getSalesSet(String records) {
        //convert list to Set
        List<SalesVO> salesList = getSalesVOList(records);
        Set<SalesVO> salesSet = new HashSet<>();
        salesSet = salesList.stream().collect(Collectors.toSet());
        return salesSet;
    }
}
