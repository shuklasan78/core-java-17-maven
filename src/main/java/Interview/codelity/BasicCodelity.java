package Interview.codelity;

public class BasicCodelity {
//https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
    public static void main(String[] args) {
        getConceptsOnBinaries();
    }

    private static void getConceptsOnBinaries() {
        int i = 1041;
        String binString = Integer.toBinaryString(i);
        //int iNew = Integer.parseInt(binString, 2); //
        System.out.println(i>>1);
        System.out.println(" BinaryString  :"+binString);
        System.out.println("octal representation  :"+Integer.toString(1234,8) );  // prints 144 --octal representation
        System.out.println("binary representation   :"+Integer.toString(1234,2) ); // prints 1100100 --binary representation
        System.out.println("Hex representation   :"+Integer.toString(1234,16)); //prints 64  --Hex representation
        System.out.println("Base 5   :"+Integer.toString(1234,5)); // prints 400  --Base 5
    }


}
