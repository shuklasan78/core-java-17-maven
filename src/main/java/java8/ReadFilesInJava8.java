package java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadFilesInJava8 {
    private static String filePaths = "/Users/sandeepkumarshukla/Applications/Technical/Intellij/core-java-17/src/com/java/practice/streams/data/";

    public static void main(String[] args) throws IOException {

        List<String> lines = readFileSimple("personfewrecords.csv");
        System.out.println("Line "+lines);
    }

    private static void readFileUisngStreams(String fileName) {
        String filePath = filePaths+fileName;
        List<String> list = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            //1. filter line 3
            //2. convert all content to upper case
            //3. convert it into a List
            list = stream
                    .filter(line -> !line.startsWith("line3"))
                    .map(String::toUpperCase)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        list.forEach(System.out::println);
    }

    private static List<String> readFileSimple(String fileName) {
        String filePath = filePaths+fileName;
        List<String> lstStr =  new ArrayList<>();
        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {

            stream.forEach(p-> lstStr.add(p));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return lstStr;
    }
}
