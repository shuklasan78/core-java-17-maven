package Interview.fibnacio;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Fibnaucia {

    public static void main(String[] args) {

        //fibSeriesWithSimpleLogic();
        System.out.println(fib(10));
    }

    private static int fibSeriesWithSimpleLogic() {

        //F{n}=F{n-1}+F{n-2}} is valid for n > 2

        int n1 = 0, n2 = 1, n3=0;
        System.out.print(n1 + " " + n2);//printing 0 and 1

       var finList = new ArrayList<BigInteger>();

        for (int i = 2; i < 30; i++)//loop starts from 2 because 0 and 1 are already printed
        {
            n3 = n1 + n2;
            System.out.print(" " + n3);
            n1 = n2;
            n2 = n3;
            finList.add(BigInteger.valueOf(n3));
        }
        Double sum = finList
                .stream()
                .mapToDouble(BigInteger::doubleValue)
                .sum();
        System.out.println("   The sum is :"+sum);
        return n3;
    }
    public static int fib(int n) {
        if (n == 0) {
            return 0;
        } if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

}
