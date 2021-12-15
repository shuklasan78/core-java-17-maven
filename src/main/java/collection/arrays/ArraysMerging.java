package collection.arrays;

import data.FilesEnum;
import data.GetSalesData;
import data.SalesVO;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;
@Slf4j
public class ArraysMerging {

    public static void main(String[] args) {

        mergeArrays();
    }

    private static void mergeArrays() {
        String fileName1 = FilesEnum.SalesRecords2M.toString();
        String fileName2 = FilesEnum.SalesRecords2M.toString();
        SalesVO[] arr1 = GetSalesData.getSalesArray(fileName1);
        SalesVO[] arr2 = GetSalesData.getSalesArray(fileName2);
        mergingArraysUsingStream(arr1,arr2);
        mergingArraysUsingList(arr1, arr2);
        mergingArraysUsingLoop(arr1, arr2);
        mergingArraysUsingForEach(arr1, arr2);
        mergingArraysUsingSystemArrayCopy(arr1, arr2);
        concatWithCollection(arr1, arr2);
    }

    private static void mergingArraysUsingStream(SalesVO[] arr1 , SalesVO[] arr2) {
        long start = new Date().getTime();
        SalesVO[] bks = (SalesVO[]) Stream.concat(Stream.of(arr1), Stream.of(arr2)).toArray(b -> new SalesVO[b]);
        long end = new Date().getTime();
        log.info("Time Taken to Merger Two Arrays mergingArraysUsingStream:"+String.valueOf(end-start));
        System.out.println("Size after merging using Stream :"+bks.length);

        //        Set<Book> set = Stream.concat(set1.stream(), set2.stream()).collect(Collectors.toSet());
        //        List<Book> list = Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());

    }

    private static void mergingArraysUsingList(SalesVO[] arr1 , SalesVO[] arr2) {

        long start = new Date().getTime();
        List<SalesVO> list = new ArrayList(Arrays.asList(arr1));
        list.addAll(Arrays.asList(arr2));
        SalesVO[] mergedArray = new SalesVO[list.size()]; // not while putting in array
        mergedArray = list.toArray(mergedArray);
        long end = new Date().getTime();
        log.info("Time Taken to Merger Two Arrays  mergingArraysUsingList :"+String.valueOf(end-start));
        System.out.println("Size after merging using List :"+mergedArray.length);

    }

    private static void mergingArraysUsingLoop(SalesVO[] arr1 , SalesVO[] arr2) {
        int arrSize = arr1.length + arr2.length;
        SalesVO[] mergedArray = new SalesVO[arrSize];
        int count = 0;
        long start = new Date().getTime();
        for(int i = 0; i < arr1.length; i++) {
            mergedArray[i] = arr1[i];
            count++;
        }
        for(int j = 0; j < arr2.length;j++) {
            mergedArray[count++] = arr2[j];
        }
        long end = new Date().getTime();
        log.info("Time Taken to Merger Two Arrays mergingArraysUsingLoop  :"+String.valueOf(end-start));
        System.out.println("Size after merging using Loop :"+mergedArray.length);
    }

    private static void mergingArraysUsingForEach(SalesVO[] arr1 , SalesVO[] arr2) {
        int arrSize = arr1.length + arr2.length;
        SalesVO[] mergedArray = new SalesVO[arrSize];
        long start = new Date().getTime();
        int pos = 0;
        for (SalesVO element : arr1) {
            mergedArray[pos] = element;
            pos++;
        }

        for (SalesVO element : arr2) {
            mergedArray[pos] = element;
            pos++;
        }
        long end = new Date().getTime();
        log.info("Time Taken to Merger Two Arrays mergingArraysUsingForEach  :"+String.valueOf(end-start));
        System.out.println("Size after merging using mergingArraysUsingForEach :"+mergedArray.length);
    }
    // this is the best result I got.
    private static void mergingArraysUsingSystemArrayCopy(SalesVO[] arr1 , SalesVO[] arr2) {
        int arrSize = arr1.length + arr2.length;
        SalesVO[] mergedArray = new SalesVO[arrSize];
        long start = new Date().getTime();
        System.arraycopy(arr1, 0, mergedArray, 0,  arr1.length);
        System.arraycopy(arr2, 0, mergedArray, arr1.length, arr2.length);
        long end = new Date().getTime();
        log.info("Time Taken to Merger Two Arrays mergingArraysUsingSystemArrayCopy  :"+String.valueOf(end-start));
        System.out.println("Size after merging using mergingArraysUsingSystemArrayCopy :"+mergedArray.length);
    }



    static <T> T[] concatWithCollection(T[] array1, T[] array2) {
        long start = new Date().getTime();
        List<T> resultList = new ArrayList<>(array1.length + array2.length);
        Collections.addAll(resultList, array1);
        Collections.addAll(resultList, array2);

        @SuppressWarnings("unchecked")
        //the type cast is safe as the array1 has the type T[]
        T[] resultArray = (T[]) Array.newInstance(array1.getClass().getComponentType(), 0);
        System.out.println("The size of the whole collection is :"+resultList.toArray(resultArray).length);
        long end = new Date().getTime();
        log.info("Time Taken to Merger Two Arrays concatWithCollection  :"+String.valueOf(end-start));
        System.out.println("FirstElement :"+resultList.toArray(resultArray)[0]);
        return resultList.toArray(resultArray);
    }
}
