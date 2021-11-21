package basics;

import java.util.*;
import java.util.stream.Collectors;

public class ElementsCount {

    public static void main(String[] args) {


    }

    public static void arrayElementCount(int inputArray[]) {
        //Creating a HashMap object with elements of inputArray as keys and their count as values

        HashMap<Integer, Integer> elementCountMap = new HashMap<Integer, Integer>();

        //checking every element of the inputArray

        for (int i : inputArray) {
            if (elementCountMap.containsKey(i)) {
                //If element is present in elementCountMap, incrementing it's count by 1

                elementCountMap.put(i, elementCountMap.get(i) + 1);
            } else {
                //If element is not present in elementCountMap,
                //adding this element to elementCountMap with 1 as it's value

                elementCountMap.put(i, 1);
            }
        }
    }

    public static void findDuplicatesUsingHashMap(int[] inputArray)
    {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int element : inputArray)
        {
            if(map.get(element) == null)
            {
                map.put(element, 1);
            }
            else
            {
                map.put(element, map.get(element)+1);
            }
        }

        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();

        for (Map.Entry<Integer, Integer> entry : entrySet)
        {
            if(entry.getValue() > 1)
            {
                System.out.println("Duplicate Element : "+entry.getKey()+" - found "+entry.getValue()+" times.");
            }
        }
    }
    private static void findDuplicatesUsingJava8(int[] inputArray)
    {
        Set<Integer> uniqueElements = new HashSet<>();

        Set<Integer> duplicateElements =  Arrays.stream(inputArray)
                .filter(i -> !uniqueElements.add(i))
                .boxed()
                .collect(Collectors.toSet());

        System.out.println(duplicateElements);
    }



}