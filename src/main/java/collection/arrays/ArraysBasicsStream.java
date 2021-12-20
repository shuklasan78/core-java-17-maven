package collection.arrays;

import data.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
@Slf4j
public class ArraysBasicsStream {

    public static void main(String[] args) {

        String fileName = FilesEnum.SalesRecords100.toString();
        getStatistics(fileName);
    }


    private static void getStatistics(String fileName) {

        int[] unitSold = ArrayPrimitiveData.getUnitSold(fileName);
        IntSummaryStatistics sumaryStatics = Arrays.stream(unitSold).summaryStatistics();
        log.info("sumaryStatics minimumunitsold :"+sumaryStatics.getMin());
        log.info("sumaryStatics maximumunitsold :"+sumaryStatics.getMax());
        log.info("sumaryStatics totalsum   :"+sumaryStatics.getSum());
        log.info("sumaryStatics Average   :"+sumaryStatics.getAverage());
        log.info("sumaryStatics count   :"+sumaryStatics.getCount());

        double[] totalRevenue = ArrayPrimitiveData.getTotalRevenue(fileName);
        DoubleSummaryStatistics sumaryStatics2 = Arrays.stream(totalRevenue).summaryStatistics();
        log.info("DoublesumaryStatics minimumunitsold :"+sumaryStatics2.getMin());
        log.info("DoublesumaryStatics maximumunitsold :"+sumaryStatics2.getMax());
        log.info("DoublesumaryStatics totalsum   :"+sumaryStatics2.getSum());
        log.info("DoublesumaryStatics Average   :"+sumaryStatics2.getAverage());
        log.info("DoublesumaryStatics count   :"+sumaryStatics2.getCount());
    }
}
