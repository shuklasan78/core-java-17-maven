package Interview.prime;

public class PrimeWithForLoop {

    public static void main(String[] args) {
        findPrimeUsingWhile(97);
    }

    private static void findPrimeUsingForLoop(int num) {

        boolean isPrime= true;
        for ( int i=2;i<=num/2;++i) {
            if(num%i==0) {
                isPrime = false;
                break;
            }
        }
        System.out.println("The value "+num+" is prime :"+isPrime);
    }

    private static void findPrimeUsingWhile(int num) {
        int i=2;
        var isPrime = true;
        while(i<=num/2) {
            if(num%i==0) {
                isPrime = false;
                break;
            }
           ++i;
        }

        System.out.println("The given Number check for prime is :"+isPrime);
    }

}
