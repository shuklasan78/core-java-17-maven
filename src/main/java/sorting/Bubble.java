package sorting;

public class Bubble {
    public static void main(String[] args) {

    }
    static void bubbleSort (int a[])    // function to implement bubble sort
    {
        int n = a.length;
        int i, j, temp;
        for (i = 0; i < n; i++)
        {
            for (j = i + 1; j < n; j++)
            {
                if (a[j] < a[i])
                {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
}
