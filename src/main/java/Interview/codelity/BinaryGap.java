package Interview.codelity;

public class BinaryGap {

    static int maxZeros(int N)
    {
        // variable to store the length of
        // longest consecutive 0's
        int maxm = -1;

        // to temporary store the consecutive 0's
        int cnt = 0;

        while (N != 0) {
            if ((N & 1) == 0 ) {
                cnt++;
                N >>= 1;
                maxm = Math.max(maxm, cnt);
            }
            else {

                maxm = Math.max(maxm, cnt);
                cnt = 0;
                N >>= 1;
            }
        }
        return maxm;
    }

    // Driver code
    public static void main(String args[])
    {
        int N = 1257;
        System.out.println(maxZeros(N));

    }
    // This Code is contributed by ANKITRAI1

}
