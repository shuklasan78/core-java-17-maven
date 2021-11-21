package basics;

public class MultiDimensionalArrays {

    public static void main(String[] args) {

        //loopTwoDimentionalArray();
        loopThreeDimensionalArray();
        //loopThreeDimensionalArray2();
    }

    private static void loopThreeDimensionalArray2() {
        int[][][] arr={
                {
                        {34,67,43},
                        {576,697,423},
                        {576,587,90}
                },
                {
                        {39,47,33},
                        {376,987,453},
                        {57,69,42}
                },
        };
        for(int i=0; i<=0; i++){
            for(int j=0; j<=0; j++){
                for(int k=0; k<=2; k++){
                    System.out.println("oopThreeDimensionalArray2()     :  "+arr[i][j][k]);
                }
            }
        }
    }

    private static void loopThreeDimensionalArray() {
        int[][][] arr={
                {
                        {34,67,43},
                        {576,697,423},
                        {576,587,90}
                },
                {
                        {39,47,33},
                        {376,987,453},
                        {57,69,42}
                },
        };
        System.out.println("Size of the Array is ::"+arr.length);
        for(int i =0; i<arr[0][0].length-2; i++) {

            for(int j= 0 ; j<arr[0][i].length ; j++) {

                System.out.println("The values are :"+arr[0][i][j]);
            }
        }

    }

    private static void loopTwoDimentionalArray() {
        int[][] a = {
                {1, 2, 3},
                {4, 5, 6, 9},
                {7},
        };

        for(int i =0; i<a[0].length ; i++) {
                System.out.println("The values are :"+a[0][i]);
        }
    }




}
