package collection.arrays;

import data.GetSalesData;
import data.SalesVO;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Date;
@Slf4j
public class ArrayPrimitiveData {

    public static int[] getUnitSold(String fileName) {
        SalesVO[] salesArr = GetSalesData.getSalesArray(fileName);
        long start = new Date().getTime();
        int[] unitSoldArr =  Arrays.stream(salesArr).mapToInt(p -> p.getUnitsSold()).toArray();
        long end = new Date().getTime();
        log.info("Time taken to extract unit sold column into array :" +(end-start));
        System.out.println("The Size of the unitSoldArr Arrays :"+unitSoldArr.length);

        return unitSoldArr;

    }

    public static double[] getTotalRevenue(String fileName) {
        SalesVO[] salesArr = GetSalesData.getSalesArray(fileName);
        long start = new Date().getTime();
        double[] totaRevenueArr = Arrays.stream(salesArr).mapToDouble(p -> p.getTotalRevenue()).toArray();
        long end = new Date().getTime();
        log.info("Time taken to extract unit sold column into array :" +(end-start));
        System.out.println("The Size of the totaRevenueArr Arrays :"+totaRevenueArr.length);
        return totaRevenueArr;
    }

    public static String[] getItemType(String fileName) {
        SalesVO[] salesArr = GetSalesData.getSalesArray(fileName);
        long start = new Date().getTime();
        String[] itemTypeArr = (String[]) Arrays.stream(salesArr).map(p -> p.getItemType()).toArray(String[]::new);
        long end = new Date().getTime();
        log.info("Time taken to extract unit sold column into itemTypeArr array :" +(end-start));
        System.out.println("The Size of the itemTypeArr Arrays :"+itemTypeArr.length);
        return itemTypeArr;
    }
}
