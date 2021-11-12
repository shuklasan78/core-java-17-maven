package collection.service;
import collection.service.SimpleData;

import java.util.stream.Stream;

public class JoinArrays_flatmap {
    public String[] by_Stream_of_flatMap(String[] array1, String[] array2) {
        Stream joinedStream = Stream.of(array1, array2).flatMap(Stream::of);
        return (String[]) joinedStream.toArray(String[]::new);
    }

    public SimpleData[] by_Stream_of_flatMap_2(SimpleData[] data1, SimpleData[] data2) {
        Stream joined = Stream.of(data1,data2).flatMap(Stream::of);

        return (SimpleData[]) joined.toArray(SimpleData[]::new);
    }
}
