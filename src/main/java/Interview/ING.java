package Interview;

import data.Employee;
import data.GetEmployeeData;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class ING {

    public static void main(String[] args) {
        printEvenAndOddFromArray();
        //checkAnagram("moder IS BEST","rodem IS BEST");
        //checkPalimdrome();
    }

    private static void checkPalimdrome() {
        String str = "madam madam" ;
        StringBuilder sb = new StringBuilder(str).reverse();
        if(str.equals(sb.toString())) {
            System.out.println("The string is plaindrome");
        } else {
            System.out.println("Not a plaindrome using StringBuilder");
        }
        str = "Sir, I demand, I am a maid named Iris" ;
        str = str.replaceAll("\\s","").replaceAll(",","").toLowerCase();
       // StringBuilder sbPalin = new StringBuilder(str);

        int iStart =0;
        int iEnd = str.length()-1;
        var isPalin = true;
        while(iStart < iEnd) {
            if(str.charAt(iStart) != str.charAt(iEnd)) {
                isPalin = false;
            }
            iStart++;
            iEnd--;
        }
        System.out.println("Pailindrom using while loop :"+isPalin);


    }
    private static void checkAnagram(String s1, String s2) {
        var isAnangram = true;
        s1 = s1.replaceAll("\\s","");
        s2 = s2.replaceAll("\\s","");


        if(s1.length() != s2.length()) {
            isAnangram = false;
        } else {

            char[] char1 = s1.toLowerCase().toCharArray();
            char[] char2 = s2.toLowerCase().toCharArray();
            Arrays.sort(char1);
            Arrays.sort(char2);
            isAnangram = Arrays.equals(char1,char2);
        }
        if(isAnangram) {
            System.out.println("The supplied strings are anagram :");
        } else {
            System.out.println("The supplied strings are not anagram :");
        }


    }

    private static void printEvenAndOddFromArray() {
        List<Employee> emplList = GetEmployeeData.getEmployeeListWithfewRecords();
        Employee[] empArr = new Employee[emplList.size()];
        empArr = emplList.toArray(empArr);
        System.out.println("The size of the Array :"+empArr.length);
        Map<String,List<Employee>> numberMap = new HashMap<>();
        List<Employee> listOddEmp = new ArrayList<>();
        List<Employee> listEvenEmp = new ArrayList<>();
        List<Employee> listPrimeEmp = new ArrayList<>();

        for(Employee emp : empArr) {
            if(emp.getEmpId()%2 == 0) {
                listEvenEmp.add(emp);
            } else {
                listOddEmp.add(emp);
                boolean isPrime= true;
                for(int i=2 ; i<emp.getEmpId()/2 ; i++) {
                    if(emp.getEmpId()%i==0) {
                        isPrime= false;
                    }
                }
                if(isPrime) {
                    //System.out.println("The Id are :"+emp.getEmpId());
                    listPrimeEmp.add(emp);
                }
            }
        }
        numberMap.put("odd",listOddEmp);
        numberMap.put("even",listEvenEmp);
        //numberMap.put("prime",listPrimeEmp);
        System.out.println("Size of the Prime Number :"+listPrimeEmp.size());
        System.out.println("Size of the Even Number :"+listEvenEmp.size());
        System.out.println("Size of the Odd Number :"+listOddEmp.size());

        Stream<Employee> stream = emplList.stream();
        List<Employee> evenNumbersList = stream.filter(i -> i.getEmpId()%2 == 0)
                .collect(Collectors.toList());
        System.out.println("Size of the Even Number Using Streams :"+listEvenEmp.size());
    }

}
