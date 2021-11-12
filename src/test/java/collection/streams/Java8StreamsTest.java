package collection.streams;

import collection.service.Car;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Java8StreamsTest {
    private static final Car volkswagenGolf = new Car(0, "Volkswagen", "Golf", "blue");
    private static final Car skodaOctavia = new Car(1, "Skoda", "Octavia", "green");
    private static final Car renaultKadjar = new Car(2, "Renault", "Kadjar", "red");
    private static final Car volkswagenTiguan = new Car(3, "Volkswagen", "Tiguan", "red");

    //stateless operation starts here
    @Test
    public void filterStream() {
        List<Car> expectedCars = Arrays.asList(volkswagenGolf, volkswagenTiguan);
        List<Car> filteredCars = Stream.of(volkswagenGolf, skodaOctavia, renaultKadjar, volkswagenTiguan)
                .filter(car -> car.getBrand().equals("Volkswagen"))
                .collect(Collectors.toList());
        assertIterableEquals(expectedCars, filteredCars);
    }

    @Test
    public void mapStream() {
        List<String> expectedBrands = Arrays.asList("Volkswagen", "Skoda", "Renault", "Volkswagen");
        List<String> brands = Stream.of(volkswagenGolf, skodaOctavia, renaultKadjar, volkswagenTiguan)
                .map(Car::getBrand)
                .collect(Collectors.toList());
        assertIterableEquals(expectedBrands, brands);
    }

    @Test
    public void filterMapStream() {
        List<String> expectedColors = Arrays.asList("blue", "red");
        List<String> volkswagenColors = Stream.of(volkswagenGolf, skodaOctavia, renaultKadjar, volkswagenTiguan)
                .filter(car -> car.getBrand().equals("Volkswagen"))
                .map(Car::getColor)
                .collect(Collectors.toList());
        assertIterableEquals(expectedColors, volkswagenColors);
    }

    //Ststeless operations ends here
    //stateful starts here
    @Test
    public void distinctStream() {
        List<String> expectedBrands = Arrays.asList("Volkswagen", "Skoda", "Renault");
        List<String> brands = Stream.of(volkswagenGolf, skodaOctavia, renaultKadjar, volkswagenTiguan)
                .map(Car::getBrand)
                .distinct()
                .collect(Collectors.toList());
        assertIterableEquals(expectedBrands, brands);
    }

    @Test
    public void sortedStream() {
        List<String> expectedSortedBrands = Arrays.asList("Renault", "Skoda", "Volkswagen", "Volkswagen");
        List<String> brands = Stream.of(volkswagenGolf, skodaOctavia, renaultKadjar, volkswagenTiguan)
                .map(Car::getBrand)
                .sorted()
                .collect(Collectors.toList());
        assertIterableEquals(expectedSortedBrands, brands);
    }

    //stateful ends here
    //pek for debussging purpose
    @Test
    public void peekStream() {
        List<String> expectedColors = Arrays.asList("blue", "red");
        List<String> volkswagenColors = Stream.of(volkswagenGolf, skodaOctavia, renaultKadjar, volkswagenTiguan)
                .filter(car -> car.getBrand().equals("Volkswagen"))
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(Car::getColor)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
        assertIterableEquals(expectedColors, volkswagenColors);

    }

    //terminal operations starts here
    @Test
    public void collectJoinStream() {
        String expectedBrands = "Volkswagen;Skoda;Renault;Volkswagen";
        String joinedBrands = Stream.of(volkswagenGolf, skodaOctavia, renaultKadjar, volkswagenTiguan)
                .map(Car::getBrand)
                .collect(Collectors.joining(";"));
        assertEquals(expectedBrands, joinedBrands);
    }

    @Test
    public void collectSummingIntStream() {
        int sumIds = Stream.of(volkswagenGolf, skodaOctavia, renaultKadjar, volkswagenTiguan)
                .collect(Collectors.summingInt(Car::getId));
        assertEquals(6, sumIds);
    }

    @Test
    public void collectGroupingByStream() {
        Map<String, List<Car>> expectedCars = new HashMap<>();
        expectedCars.put("Skoda", Arrays.asList(skodaOctavia));
        expectedCars.put("Renault", Arrays.asList(renaultKadjar));
        expectedCars.put("Volkswagen", Arrays.asList(volkswagenGolf, volkswagenTiguan));

        Map<String, List<Car>> groupedCars = Stream.of(volkswagenGolf, skodaOctavia, renaultKadjar, volkswagenTiguan)
                .collect(Collectors.groupingBy(Car::getBrand));
        assertTrue(expectedCars.equals(groupedCars));
    }

    @Test
    public void reduceStream() {
        int sumIds = Stream.of(volkswagenGolf, skodaOctavia, renaultKadjar, volkswagenTiguan)
                .map(Car::getId)
                .reduce(0, Integer::sum);
        assertEquals(6, sumIds);
    }
    //ends here

    @Test
    public void maxStream() {
        int maxId = Stream.of(volkswagenGolf, skodaOctavia, renaultKadjar, volkswagenTiguan)
                .map(Car::getId)
                .max((o1, o2) -> o1.compareTo(o2))
                .orElse(-1);
        assertEquals(3, maxId);
        //Long count = nameList.stream().filter(s -> s.length() > 5).count();
    }

}