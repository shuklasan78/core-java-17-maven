package collection.service;
import collection.service.SimpleData;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class JoinArrays_concat {

    public int[] by_IntStream_concat(int[] int1, int[] int2) {
        IntStream joinedStream = IntStream.concat(Arrays.stream(int1), Arrays.stream(int2));
        return joinedStream.toArray();
    }

    public double[] by_DoubleStream_concat(double[] double1, double[] double2) {
        DoubleStream joinedStream = DoubleStream.concat(Arrays.stream(double1), Arrays.stream(double2));
        return joinedStream.toArray();
    }

    public long[] by_LongStream_concat(long[] long1, long[] long2) {
        LongStream joinedStream = LongStream.concat(Arrays.stream(long1), Arrays.stream(long2));
        return joinedStream.toArray();
    }

    public String[] by_Stream_concat(String[] array1, String[] array2) {
        Stream stream1 = Arrays.stream(array1);
        Stream stream2 = Arrays.stream(array2);

        Stream joinedStream = Stream.concat(stream1, stream2);

        return (String[]) joinedStream.toArray(String[]::new);
    }

    public String[] by_Stream_concat_2(String[] array1, String[] array2) {
        Stream stream1 = Stream.of(array1);
        Stream stream2 = Stream.of(array2);

        Stream joinedStream = Stream.concat(stream1, stream2);

        return (String[]) joinedStream.toArray(String[]::new);
    }

    public SimpleData[] by_Stream_concat_Object(SimpleData[] data1, SimpleData[] data2) {
        Stream joined = Stream.concat(Arrays.stream(data1), Arrays.stream(data2));

        return (SimpleData[]) joined.toArray(SimpleData[]::new);
    }

    public SimpleData[] by_Stream_concat_Object_2(SimpleData[] data1, SimpleData[] data2) {
        Stream joinedStream = Stream.concat(Stream.of(data1), Stream.of(data2));

        return (SimpleData[]) joinedStream.toArray(SimpleData[]::new);
    }
}