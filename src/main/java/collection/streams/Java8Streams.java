package collection.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Streams {
    public static void main(String[] args) throws IOException {
        getStreams();
    }

    private static void getStreams() throws IOException {
        //Remove all empty Strings from List
        List<String> strList = Arrays.asList("abc", "", "bcd", "", "defg", "jk");
        List<String> filtered = strList.stream() .filter(x -> !x.isEmpty()) .collect(Collectors.toList());
        //Remove all empty Strings from List
        filtered = strList.stream() .filter(x -> !x.isEmpty()) .collect(Collectors.toList());

        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
        String G7Countries = G7.stream() .map(x -> x.toUpperCase()) .collect(Collectors.joining(", "));
        //List of the square of all distinct numbers
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream() .map( i -> i*i) .distinct() .collect(Collectors.toList());
        //Get count, min, max, sum, and the average for numbers
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream() .mapToInt((x) -> x) .summaryStatistics();
        //Sum by using Collectors Methods
        List<Product> productsList = new ArrayList<Product>();
        //Adding Products
        productsList.add(new Product(1,"HP Laptop",25000f));
        productsList.add(new Product(2,"Dell Laptop",30000f));
        productsList.add(new Product(3,"Lenevo Laptop",28000f));
        productsList.add(new Product(4,"Sony Laptop",28000f));
        productsList.add(new Product(5,"Apple Laptop",90000f));
        // Using Collectors's method to sum the prices.
        double totalPrice3 = productsList.stream()
                .collect(Collectors.summingDouble(product->product.price));
        System.out.println(totalPrice3);
        //reduce method
        Float totalPrice = productsList.stream()
                .map(product->product.price)
                .reduce(0.0f,(sum, price)->sum+price);   // accumulating price
        System.out.println(totalPrice);
        // More precise code
        float totalPrice2 = productsList.stream()
                .map(product->product.price)
                .reduce(0.0f,Float::sum);   // accumulating price, by referring method of Float class
        System.out.println(totalPrice2);

        Product productA = productsList.stream().max((product1, product2)->product1.price > product2.price ? 1: -1).get();
        System.out.println(productA.price);
        // min() method to get min Product price
        Product productB = productsList.stream().min((product1, product2)->product1.price > product2.price ? 1: -1).get();
        System.out.println(productB.price);
        // Converting product List into Set
        Set<Float> productPriceList =
                productsList.stream()
                        .filter(product->product.price < 30000)   // filter product on the base of price
                        .map(product->product.price)
                        .collect(Collectors.toSet());   // collect it as Set(remove duplicate elements)
        System.out.println(productPriceList);
        // Converting Product List into a Map
        Map<Integer,String> productPriceMap =
                productsList.stream()
                        .collect(Collectors.toMap(p->p.id, p->p.name));

        System.out.println(productPriceMap);
        productsList = new ArrayList<Product>();

        //Adding Products
        productsList.add(new Product(1,"HP Laptop",25000f));
        productsList.add(new Product(2,"Dell Laptop",30000f));
        productsList.add(new Product(3,"Lenevo Laptop",28000f));
        productsList.add(new Product(4,"Sony Laptop",28000f));
        productsList.add(new Product(5,"Apple Laptop",90000f));

        List<Float> productPriceList1 =
                        productsList.stream()
                        .filter(p -> p.price > 30000) // filtering data
                        .map(Product::getPrice)         // fetching price by referring getPrice method
                        .collect(Collectors.toList());  // collecting as list
        System.out.println(productPriceList1);
        //reading from the text file
        Stream<String> rows1 = Files.lines(Paths.get("data.txt"));
        int rowCount = (int)rows1
                .map(x -> x.split(","))
                .filter(x -> x.length == 3)
                .count();
        System.out.println(rowCount + " rows.");
        rows1.close();
        double total = Stream.of(7.3, 1.5, 4.8)
                .reduce(0.0, (Double a, Double b) -> a + b);
        System.out.println("Total = " + total);

        List<String> data = Arrays.asList("java", "not", "in", "use");

        data.stream().filter(line -> !"not".equals(line))
                .forEach(p -> System.out.println(p));
        numbers = new ArrayList<>();
        numbers.add(14);
        numbers.add(4);
        numbers.add(11);
        numbers.add(78);
        numbers.add(2);
        numbers.add(99);
        numbers.add(7);
        System.out.println("Before Customized Sorting");
        System.out.println(numbers);
        System.out.println("After Customized Sorting");
        System.out.println("Sorting Bigger to smaller number");
        numbers = numbers.stream().sorted((s2, s1) ->
                s1.compareTo(s2)).collect(Collectors.toList());
        System.out.println(numbers);

        Integer minNum = numbers.stream().min((s1, s2) -> s1.compareTo(s2)).get();
        System.out.println("Minimum number value in list is " + minNum);
        //Minimum number value in list is 2
        Integer maxNum = numbers.stream().max((s1, s2) -> s1.compareTo(s2)).get();
        System.out.println("Maximum number value is list is " + maxNum);
        //Maximum number value is list is 99
    }



}
