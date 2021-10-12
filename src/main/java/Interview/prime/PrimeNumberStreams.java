package Interview.prime;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumberStreams {

    public static void main(String[] args) {

        List<Integer> naturalList = new ArrayList<Integer>();
        for(int i =0; i<100;i++ ) {
            naturalList.add(i);
        }
        int n=100;
        System.out.println(IntStream.rangeClosed(2, 10).boxed().toList());

        naturalList = IntStream.rangeClosed(2, n)
                .filter(x -> isPrime(x)).boxed()
                .collect(Collectors.toList());
        System.out.println(naturalList);

        int startingNumber =250;
        int endingNumber = 450;
        IntStream
                .rangeClosed(startingNumber, endingNumber)
                .filter(x -> isPrime(x)).boxed()
                .collect(Collectors.toList());

        IntStream stream = IntStream.range(1, 100);

        List<Integer> primes = stream.filter(PrimeNumberStreams::isPrimeScond)
                .boxed()
                .collect(Collectors.toList());
    }

    //Java 8 way to check if the number is prime or not
    private static boolean isPrime(int number) {
        return number > 1 && IntStream
                .range(2, number)
                .noneMatch(i -> number % i == 0);
    }

    public static boolean isPrimeScond(int i)
    {
        IntPredicate isDivisible = index -> i % index == 0;
        return i > 1 && IntStream.range(2, i).noneMatch(isDivisible);
    }


}
