package Interview.anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnagramTest {

    public static void main(String[] args) {

        var answer =checkAnagram(getAnagramList1(), getAnagramList2());
        System.out.println("The answer :"+answer);

    }
    private static boolean checkAnagram(List<String> l1, List<String> l2) {
        var iAanagram = false;
        if(l1.size() != l2.size()) {
            return false;
        }
        var l1Str = "";
        var l2Str = "";
        Character[] char1 = null;
        Character[] char2 = null;
        List<String> lst1 = new ArrayList<>();
        List<String> lst2 = new ArrayList<>();
        Stream<Character> charStream = null;
        for(int i =0;i<l1.size(); i++) {
            l1Str = l1.get(i).replaceAll("\\s","").toUpperCase();
            l2Str = l2.get(i).replaceAll("\\s","").toUpperCase();
            char1 =l1Str.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
            char2 =l2Str.chars().mapToObj(c -> (char)c).toArray(Character[]::new);

            charStream = Arrays.stream(char1).sorted();
            String string = charStream.map(String::valueOf).collect(Collectors.joining());
            lst1.add(string);
            charStream = Arrays.stream(char2).sorted();
            string = charStream.map(String::valueOf).collect(Collectors.joining());
            lst2.add(string);
        }
        lst1 = lst1.stream().sorted().collect(Collectors.toList());
        lst2 = lst2.stream().sorted().collect(Collectors.toList());

        if(lst1.equals(lst2)) {
            iAanagram = true;
            System.out.println("Both are equals");
        }

        return iAanagram;
    }
    private static List<String> getAnagramList1() {
        List<String> list1 = new ArrayList<>();
        list1.add("Dormitory");
        list1.add("School master");
        list1.add("Conversation ");
        list1.add("Listen ");
        list1.add("Astronomer");
        list1.add("The eyes");
        list1.add("A gentleman");
        list1.add("Funeral");
        list1.add("The Morse Code");
        list1.add("Eleven plus two");
        list1.add("Slot machines");
        list1.add("Fourth of July");
        list1=list1.stream().sorted().collect(Collectors.toList());
        System.out.println("The sorted value are"+list1);
        //String string = Joiner.on("|").join(charArray);
        return list1;

    }
    private static List<String>  getAnagramList2() {
        List<String> list1 = new ArrayList<>();
        list1.add("Dirty room");
        list1.add("The classroom");
        list1.add("Voices rant on");
        list1.add("Silent");
        list1.add("Moon starer");
        list1.add("They see");
        list1.add("Elegant man");
        list1.add("Real fun");
        list1.add("Here come dots");
        list1.add("Twelve plus one");
        list1.add("Cash lost in me");
        list1.add("Joyful Fourth");
        list1=list1.stream().sorted().collect(Collectors.toList());
        return list1;
    }
}
