package Interview.prime;

import data.Employee;
import data.GetData;

import java.util.*;
import java.util.stream.Collectors;

public class PrimeNumberBetwenSeries {

    public static void main(String[] args) {
        //getPrimeNumberInRange(17,171);
        getEvenOddPrime();
    }

    private static List<Integer> getPrimeNumberInRange(int min, int max) {
        var isPrime = true;
        List<Integer> primintList = new ArrayList<>();
        if(min<2) {
            isPrime = false;
        }
        for(int n=min; n<=max;n++) {
            if(isPrime(n)) {
                primintList.add(n);
            }

        }
        List<Integer> list = primintList;
        Integer sum = list.stream().mapToInt(Integer::intValue).sum();
        OptionalInt mx = list.stream().mapToInt(Integer::intValue).max();
        OptionalDouble average = list.stream().mapToInt(Integer::intValue).average();
        OptionalInt minn = list.stream().mapToInt(Integer::intValue).min();

        System.out.println("Sum of prime number is :"+sum);
        System.out.println("Maximum Prime number is :"+mx);
        System.out.println("Average Prime number is :"+average);
        System.out.println("Minimum Prime number is :"+minn);

        return primintList;

    }

    private static boolean isPrime(int number) {
        for (int i = 2; i <= number/2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
                return true;
    }
    private static HashMap<String, List<Integer>> getEvenOddPrime() {
        List<Employee> employeeList = GetData.getListWithfewRecords();
        List<Integer> allDataList = employeeList.stream().map(Employee::getEmpId).collect(Collectors.toList());
        List<Integer> evenList = new ArrayList<>();
        List<Integer> oddList = new ArrayList<>();
        List<Integer> primeList = new ArrayList<>();

        for(Integer num : allDataList) {
            if(num<1) {
                System.out.println("Nota a primae"+num);
            } else if(num%2==0 ) {
                evenList.add(num);
            } else {
                oddList.add(num);
                if(isPrime(num))
                {
                    primeList.add(num);
                }
            }
        }
        HashMap<String, List<Integer>> allNumber = new HashMap<>();
        allNumber.put("even",evenList);
        allNumber.put("odd",oddList);
        allNumber.put("prime",primeList);
        System.out.println("The num:"+evenList);
        System.out.println("Maximum Even Number :"+evenList.stream().mapToInt(Integer::intValue).max());
        System.out.println("Maximum Odd Number :"+oddList.stream().mapToInt(Integer::intValue).max());
        System.out.println("Maximum Prime Number :"+primeList.stream().mapToInt(Integer::intValue).max());

        // System.out.println("The num:"+oddList);
        //System.out.println("The prime number list :"+primeList);

        // System.out.println("Hasmap with Number even,odd,prime :"+allNumber);
        return allNumber;
    }
}
