package collection.streams;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import collection.service.JoinArrays_concat;
import collection.service.SimpleData;
import org.testng.annotations.Test;


public class JoinArrays_concatTest {
    private JoinArrays_concat jArray = new JoinArrays_concat();

    @Test
    public void join_arrays_by_IntStream_concat() {
        int[] int1 = new int[] { 1, 2, 3 };
        int[] int2 = new int[] { 4, 5, 6 };

        int[] joinedIntArray = jArray.by_IntStream_concat(int1, int2);
        assertEquals(6, joinedIntArray.length);
        assertEquals( "[1, 2, 3, 4, 5, 6]" , Arrays.toString(joinedIntArray));

    }

    @Test
    public void join_arrays_by_DoubleStream_concat() {
        double[] int1 = new double[] { 1, 2, 3 };
        double[] int2 = new double[] { 4, 5, 6 };

        double[] joinedArray = jArray.by_DoubleStream_concat(int1, int2);
        assertEquals(6, joinedArray.length);
        assertEquals( "[1.0, 2.0, 3.0, 4.0, 5.0, 6.0]" , Arrays.toString(joinedArray));

    }

    @Test
    public void join_arrays_by_LongStream_concat() {
        long[] int1 = new long[] { 1, 2, 3 };
        long[] int2 = new long[] { 4, 5, 6 };

        long[] joinedArray = jArray.by_LongStream_concat(int1, int2);
        assertEquals(6, joinedArray.length);
        assertEquals( "[1, 2, 3, 4, 5, 6]" , Arrays.toString(joinedArray));

    }

    @Test
    public void join_arrays_by_Stream_concat() {
        String[] animals1 = new String[] { "Dog", "Cat", "Bird" };
        String[] animals2 = new String[] { "Bird", "Cow" };

        String[] joinedArray = jArray.by_Stream_concat(animals1, animals2);

        assertEquals(5, joinedArray.length);
        assertEquals( "[Dog, Cat, Bird, Bird, Cow]" , Arrays.toString(joinedArray));

    }

    @Test
    public void join_arrays_by_Stream_concat_2() {
        String[] animals1 = new String[] { "Dog", "Cat", "Bird" };
        String[] animals2 = new String[] { "Bird", "Cow" };

        String[] joinedArray = jArray.by_Stream_concat_2(animals1, animals2);

        assertEquals(5, joinedArray.length);
        assertEquals( "[Dog, Cat, Bird, Bird, Cow]" , Arrays.toString(joinedArray));

    }


    @Test
    public void join_arrays_by_Stream_concat_Object() {
        SimpleData[] data1 =  {new SimpleData("Mary", 30), new SimpleData("Tom", 40)};
        SimpleData[] data2 =  {new SimpleData("Bob", 18), new SimpleData("John", 60)};

        SimpleData[] joinedArray = jArray.by_Stream_concat_Object(data1, data2);

        assertEquals(4, joinedArray.length);
        Arrays.stream(joinedArray).forEach(e->System.out.println(e.toString()));

    }

    @Test
    public void join_arrays_by_Stream_concat_Object_2() {
        SimpleData[] data1 =  {new SimpleData("Mary", 30), new SimpleData("Tom", 40)};
        SimpleData[] data2 =  {new SimpleData("Bob", 18), new SimpleData("John", 60)};

        SimpleData[] joinedArray = jArray.by_Stream_concat_Object_2(data1, data2);

        assertEquals(4, joinedArray.length);
        Arrays.stream(joinedArray).forEach(e->System.out.println(e.toString()));

    }

}
