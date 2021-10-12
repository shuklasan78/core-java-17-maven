package map;

import com.java.practice.streams.data.Employee;
import com.java.practice.streams.data.GetData;
import com.java.practice.streams.data.Person;
import com.java.practice.streams.data.ProcessRecords;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PracticeMap {

    public static void main(String[] args) {
        //getMapEmployeeWithDuplicateKeyException();
        getComvertedMapFromListWithDuplicateRecords();
    }
    //Get the list of persons and store in Map with age as key and names as list.
    private static Map<Integer, List<Person>> getPersonMap() {
        List<Person> personsList = ProcessRecords.getPerson();
        Map<Integer, List<Person>> personsByAge = personsList
                .stream().filter(p->p.getAge()==20)
                .collect(Collectors.groupingBy(p -> p.getAge()));

        return personsByAge;
    }
    private static void getBasicMapConcept() {
        //System.out.println("List converted o map :"+getPersonMap());
        Set<Map.Entry<Integer, List<Person>>> entries = getPersonMap().entrySet();
        //System.out.println("Entries from Map :"+entries);
        Set<Integer> keySet = getPersonMap().keySet();
        //System.out.println("Keyset from Map :"+keySet);
        Collection<List<Person>> mapValues = getPersonMap().values();
        // Collection contains the list of items which can be iterated with for and forEach.
        for(List<Person> pers : mapValues) {
            pers.forEach(p-> System.out.println(p.getName()));
        }
        //System.out.println("The values of map are "+mapValues);
        Optional<List<Person>> userName = getPersonMap().entrySet()
                .stream()
                .filter(user -> user.getKey().equals("20"))
                .map(Map.Entry::getValue)
                .findFirst();

        System.out.println(userName.get());
    }

    private static Map<Integer, Employee> getMapEmployeeWithDuplicateKeyException() {
        List<Employee> empList = GetData.getListWith50KRecords();
        System.out.println("The size of the list is :"+empList.size());
        //Java 8 using Lambdas
        Map<Integer, Employee> empMap =  empList.stream().collect(Collectors.toMap(Employee -> Employee.getEmpId(), Employee->Employee));
        System.out.println("The size of the map is :"+empMap.size());
        //Using Java 8 method reference
        Map<Integer, Employee> result = empList.stream() .collect(Collectors.toMap(Employee::getEmpId, Employee-> Employee));
        Map<Integer, Employee> result2 = empList.stream().collect(Collectors.toMap(Employee::getEmpId, Function.identity()));

        return result2;
    }

    private static Map<Integer, Employee> getComvertedMapFromListWithDuplicateRecords() {
        List<Employee> empList = GetData.getListWithfewRecords();
        //TODO
        //Map<Integer, Employee> myMap =  empList.stream().collect(Collectors.toMap(Function.identity(), String::length, (e1, e2) -> e1));
        Map<Integer, Employee> result1 = empList.stream()
                .collect(Collectors.toMap(Employee::getEmpId, Employee::new, (oldValue, newValue) -> newValue));
        System.out.println("ListSize :"+empList.size());
        System.out.println("MapSize :"+result1.size());
        Map<Integer, Employee> result2 = empList.stream()
                .collect(Collectors.toMap(Employee::getEmpId, e->e , (oldValue, newValue) -> newValue,LinkedHashMap:: new));
        System.out.println(result2);
        return result1;
    }
}
