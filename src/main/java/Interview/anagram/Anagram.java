package Interview.anagram;

import com.java.practice.streams.data.Employee;
import com.java.practice.streams.data.GetData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Anagram {

    static void isAnagramA(String s1, String s2)
    {
        //Removing all white spaces from s1 and s2

        String copyOfs1 = s1.replaceAll("\\s", "");

        String copyOfs2 = s2.replaceAll("\\s", "");

        //Initially setting status as true

        boolean status = true;

        if(copyOfs1.length() != copyOfs2.length())
        {
            //Setting status as false if copyOfs1 and copyOfs2 doesn't have same length

            status = false;
        }
        else
        {
            //Changing the case of characters of both copyOfs1 and copyOfs2 and converting them to char array

            char[] s1Array = copyOfs1.toLowerCase().toCharArray();

            char[] s2Array = copyOfs2.toLowerCase().toCharArray();

            //Sorting both s1Array and s2Array

            Arrays.sort(s1Array);

            Arrays.sort(s2Array);

            //Checking whether s1Array and s2Array are equal

            status = Arrays.equals(s1Array, s2Array);
        }

        //Output

        if(status)
        {
            System.out.println(s1+" and "+s2+" are anagrams");
        }
        else
        {
            System.out.println(s1+" and "+s2+" are not anagrams");
        }
    }
    static void isAnagram(String s1, String s2)
    {
//Removing white spaces from s1 and s2 and converting case to lower case
        String copyOfs1 = s1.replaceAll("\\s", "").toLowerCase();
        String copyOfs2 = s2.replaceAll("\\s", "").toLowerCase();
//Initially setting status as true
        boolean status = true;
        if(copyOfs1.length() != copyOfs2.length())
        {
//Setting status as false if copyOfs1 and copyOfs2 doesn't have same length
            status = false;
        }
        else
        {
//Constructing a map containing character as a key and character occurrences as a value
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            for (int i = 0; i < copyOfs1.length(); i++)
            {
//Getting char from copyOfs1
                char charAsKey = copyOfs1.charAt(i);
//Initializing char count to 0
                int charCountAsValue = 0;
//Checking whether map contains this char
                if(map.containsKey(charAsKey))
                {
//If contains, retrieving it's count
                    charCountAsValue = map.get(charAsKey);
                }
//Putting char and it's count to map with pre-incrementing char count
                map.put(charAsKey, ++charCountAsValue);
//Getting char from copyOfs2
                charAsKey = copyOfs2.charAt(i);
//Initializing char count to 0
                charCountAsValue = 0;
//Checking whether map contains this char
                if(map.containsKey(charAsKey))
                {
//If contains, retrieving it's count
                    charCountAsValue = map.get(charAsKey);
                }
//Putting char and it's count to map with pre-decrementing char count
                map.put(charAsKey, --charCountAsValue);
            }
//Checking each character and it's count
            for (int value : map.values())
            {
                if(value != 0)
                {
//If character count is not equal to 0, then setting status as false
                    status = false;
                }
            }
        }
//Output
        if(status)
        {
            System.out.println(s1+" and "+s2+" are anagrams");
        }
        else
        {
            System.out.println(s1+" and "+s2+" are not anagrams");
        }
    }


}
