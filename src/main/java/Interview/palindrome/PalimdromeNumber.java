package Interview.palindrome;

import java.nio.charset.StandardCharsets;
import java.util.stream.IntStream;

public class PalimdromeNumber {

    public static void main(String[] args) {
        var result = false;
        //result = isNumberPalimdrome();
        result = getPalindroneOdString("aa");
        //System.out.println("Result of palimdrome string is :"+result);
        //result = checkPalindromeUsingPointers("madam");
        //System.out.println("Result of palimdrome string is :"+result);
        //result = checkPalindromeUsingForLoops("madam");
        //System.out.println("Result of palimdrome string is :"+result);
        result = isPalindromeUsingIntStream("1221 1221 1");
        //System.out.println("Palimdrome Check Using Stream :"+result);
        //
        makePalindrome("mr owl ate my metal worm");
    }

    private static boolean isNumberPalimdrome() {
        int r,sum=0,temp;
        int n=454;//It is the number variable to be checked for palindrome

        temp=n;
        while(n>0){
            r=n%10;  //getting remainder
            sum=(sum*10)+r;
            n=n/10;
            System.out.println(" reminder  :"+r+ " sum "+sum +" n " +n);
        }
        if(temp==sum) {
            System.out.println("palindrome number ");
            return true;
        } else {
            System.out.println("not palindrome");
            return false;
        }
    }

    private static boolean getPalindroneOdString(String s) {
        var ispalindrome = true;
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        var revString = sb.toString();
        if(!revString.equals(s)) {
            ispalindrome = false;
        }
        return ispalindrome;
    }

    private static boolean checkPalindromeUsingPointers(String s) {
        int iStart = 0;
        int iEnd = s.length()-1;
        while ( iStart < iEnd) {
            if(s.charAt(iStart) !=s.charAt(iEnd)) {
                return false;
            }
            iStart++;
            iEnd--;
        }
        return true;
    }

    private static boolean checkPalindromeUsingForLoops(String s) {
       // int iStart = 0;
        int iEnd = s.length()-1;
        for (int iStart = 0; iStart < iEnd; iStart++,iEnd--)
        {
            if (s.charAt(iStart) != s.charAt(iEnd))
                return false;
        }
        return true;
    }

    public static boolean isPalindromeUsingIntStream(String text) {
        String temp  = text.replaceAll("\\s+", "").toLowerCase();
        return IntStream.range(0, temp.length() / 2)
                .noneMatch(i -> temp.charAt(i) != temp.charAt(temp.length() - i - 1));
    }

    //mr owl ate my metal worm

    private static String makePalindrome(String input) {
        //StringBuilder sb = new StringBuilder(str);
        if (input == null) {
            return input;
        }

        String output = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            output = output + input.charAt(i);
        }
        System.out.println(output);
        return output;
    }

}
