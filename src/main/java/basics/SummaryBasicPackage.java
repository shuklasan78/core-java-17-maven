package basics;

import data.Employee;
import data.FilesEnum;
import data.GetEmployeeData;

import java.util.*;
import java.util.stream.Collectors;

public class SummaryBasicPackage {

    public static void main(String[] args) {
        Employee[] empArr = GetEmployeeData.getEmployeeArray(FilesEnum.EmployeeDuplicateRecords.toString());
        int[] empIdArr = new int[empArr.length];
        int j =0;
        for(Employee emp : empArr) {
            empIdArr[j] = emp.getEmpId();
            j++;
        }
        System.out.println("The size of the arrays is :"+empIdArr.length);
        Set<Integer> uniqueElements = new HashSet<>();
        Set<Integer> duplicateElements =  Arrays.stream(empIdArr)
                .filter(i -> !uniqueElements.add(i))
                .boxed()
                .collect(Collectors.toSet());

        System.out.println(duplicateElements);

        //Creating a HashMap object with elements of inputArray as keys and their count as values

        HashMap<Integer, Integer> elementCountMap = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> onlyDuplicate = new HashMap<Integer, Integer>();

        //checking every element of the inputArray

        for (int k : empIdArr) {
            if (elementCountMap.containsKey(k)) {
                //If element is present in elementCountMap, incrementing it's count by 1

                elementCountMap.put(k, elementCountMap.get(k) + 1);
                if(elementCountMap.get(k)>0) {
                    onlyDuplicate.put(k,elementCountMap.get(k));
                }
            } else {
                //If element is not present in elementCountMap,
                //adding this element to elementCountMap with 1 as it's value

                elementCountMap.put(k, 1);
            }
        }
        System.out.println(onlyDuplicate);

    }

    private static void testBasicsPackage() {

        Employee[] empArr = GetEmployeeData.getEmployeeArray(FilesEnum.EmployeeDuplicateRecords.toString());
        Map<Integer, Employee> empMap = Arrays.stream(empArr).collect(Collectors.toMap(p->p.getEmpId(),p -> p, (n,o) -> n));

    }
}
