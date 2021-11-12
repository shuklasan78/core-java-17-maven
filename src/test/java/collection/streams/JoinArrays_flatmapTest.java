package collection.streams;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import collection.service.JoinArrays_flatmap;
import collection.service.SimpleData;
import org.junit.Test;

public class JoinArrays_flatmapTest {
    private JoinArrays_flatmap jArray = new JoinArrays_flatmap();

    @Test
    public void join_arrays_by_Stream_of_flatMap() {
        String[] animals1 = new String[] { "Dog", "Cat", "Bird" };
        String[] animals2 = new String[] { "Bird", "Cow" };

        String[] joinedArray = jArray.by_Stream_of_flatMap(animals1, animals2);

        assertEquals(5, joinedArray.length);
        assertEquals("[Dog, Cat, Bird, Bird, Cow]", Arrays.toString(joinedArray));

    }

    @Test
    public void join_arrays_by_Stream_of_flatMap_2() {
        SimpleData[] data1 =  {new SimpleData("Mary", 30), new SimpleData("Tom", 40)};
        SimpleData[] data2 =  {new SimpleData("Bob", 18), new SimpleData("John", 60)};

        SimpleData[] joinedArray = jArray.by_Stream_of_flatMap_2(data1, data2);

        assertEquals(4, joinedArray.length);
        Arrays.stream(joinedArray).forEach(e->System.out.println(e.toString()));

    }


}