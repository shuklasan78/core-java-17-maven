package collection.arrays;

import java.util.Arrays;
import java.util.stream.Stream;

public class SimpleArrayWithStream {

    public static void main(String[] args) {
        arraysAsStream();
    }

    private static void arraysAsStream() {
        String[] array = {"a", "b", "c", "d", "e"};
        //Arrays.stream
        Stream<String> stream1 = Arrays.stream(array);
        stream1.forEach(x -> System.out.println(x));

        //Stream.of
        Stream<String> stream2 = Stream.of(array);
        stream2.forEach(x -> System.out.println(x));

        Integer[] arrayInt = {1, 2, 3, 4, 5};
        Stream<Integer> streamInt = Arrays.stream(arrayInt);
        streamInt.forEach(p->{
            if(p>2) {
                System.out.println("The values are :"+p);
            }
        });
    }


}
