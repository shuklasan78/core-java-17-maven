package basics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringAndRegEx {

    public static void main(String[] args) {
        String str = "Lorem adipising ipsum dolor sit Lorem amet Consectetur adipising elit Lorem ipsum dolor";
        //splitSentenceInWords(str);
        //specificLetterInWord(str);
        //characterCountUsingStream(str);
        //wordOccuranceUsingStreams(str);
        //specificCharacterCountUsingStream(str);
        characterCount(str);
    }

    private static void splitSentenceInWords(String strss) {
        String str = strss;
        String[] words = str.split("\\s+");
        System.out.println(Arrays.stream(words).toList());
    }

    private static void specificLetterInWord(String strss) {
        String str = strss;
        long count = str.chars().filter(ch -> ch == 'a').count();
        System.out.println("s"+count);
    }

    private static void characterCountUsingStream(String strss) {
        String str = strss;
        Map<String, Long> charCount = str.codePoints().mapToObj(Character::toString)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(charCount);
    }
    private static void specificCharacterCountUsingStream(String strss) {
        String str = strss;
        Map<String, Long> charCount = str.codePoints().mapToObj(Character::toString)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(charCount);
    }
    private static void wordOccuranceUsingStreams(String strss) {
        String str = strss;

        List<String> list = Stream.of(str).map(w -> w.split("\\s+")).flatMap(Arrays::stream)
                .collect(Collectors.toList());

        Map <String, Integer > wordCounter = list.stream()
                .collect(Collectors.toMap(w -> w.toLowerCase(), w -> 1, Integer::sum));

        System.out.println(wordCounter);
    }
    private static void characterCount(String inputString)
    {
        //Creating a HashMap containing char as a key and occurrences as a value

        HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();

        //Converting given string to char array

        char[] strArray = inputString.toCharArray();

        //checking each char of strArray

        for (char c : strArray)
        {
            if(charCountMap.containsKey(c))
            {
                //If char 'c' is present in charCountMap, incrementing it's count by 1

                charCountMap.put(c, charCountMap.get(c)+1);
            }
            else
            {
                //If char 'c' is not present in charCountMap,
                //putting 'c' into charCountMap with 1 as it's value

                charCountMap.put(c, 1);
            }
        }

        //Printing inputString and charCountMap

        System.out.println(inputString+" : "+charCountMap);
    }
}
