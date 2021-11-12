package collection.streams;
import static org.junit.Assert.*;

import java.util.Arrays;

import collection.service.JoinArrays_arraycopy;
import collection.service.SimpleData;
import org.junit.Test;

public class JoinArrays_arraycopyTest {

    private JoinArrays_arraycopy testObject = new JoinArrays_arraycopy();

    @Test
    public void join_two_Integer_arrays() {
        Integer[] int1 = new Integer[] { 1, 2, 3 };
        Integer[] int2 = new Integer[] { 4, 5, 6 };
        Integer[] joinedArray = testObject.concat(int1, int2);

        assertEquals(6, joinedArray.length);
        assertEquals( "[1, 2, 3, 4, 5, 6]" , Arrays.toString(joinedArray));
    }

    @Test
    public void join_two_Long_arrays() {
        Long[] int1 = new Long[] { 1l, 2l, 3l };
        Long[] int2 = new Long[] { 4l, 5l, 6l };
        Long[] joinedArray = testObject.concat(int1, int2);

        assertEquals(6, joinedArray.length);
        assertEquals( "[1, 2, 3, 4, 5, 6]" , Arrays.toString(joinedArray));
    }

    @Test
    public void join_two_String_arrays() {
        String[] int1 = new String[] { "Dog", "Cat", "Bird"  };
        String[] int2 = new String[] { "Bird", "Cow" };
        String[] joinedArray = testObject.concat(int1, int2);

        assertEquals(5, joinedArray.length);
        assertEquals( "[Dog, Cat, Bird, Bird, Cow]" , Arrays.toString(joinedArray));
    }

    @Test
    public void join_two_SimpleData_Arrays() {
        SimpleData[] data1 =  {new SimpleData("Mary", 30), new SimpleData("Tom", 40)};
        SimpleData[] data2 =  {new SimpleData("Bob", 18), new SimpleData("John", 60)};

        SimpleData[] joinedArray = testObject.concat(data1, data2);

        assertEquals(4, joinedArray.length);
        Arrays.stream(joinedArray).forEach(e->System.out.println(e.toString()));
    }

}
