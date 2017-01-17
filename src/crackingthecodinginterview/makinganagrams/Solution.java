package crackingthecodinginterview.makinganagrams;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static int numberNeeded(String first, String second) {
        Map<Character, Integer> firstCharacterNumberMap = buildCharacterNumberMap(first);
        Map<Character, Integer> secondCharacterNumberMap = buildCharacterNumberMap(second);

        int totalDiff = 0;

        for (Map.Entry<Character, Integer> firstEntry : firstCharacterNumberMap.entrySet()) {
            Character firstChar = firstEntry.getKey();
            Integer firstCharNum = firstEntry.getValue();

            Integer secondCharNum = secondCharacterNumberMap.get(firstChar);
            if (secondCharNum == null) {
                totalDiff += firstCharNum;
            } else {
                int numDifferences = Math.abs(secondCharNum - firstCharNum);
                totalDiff += numDifferences;
            }
        }

        for (Map.Entry<Character, Integer> secondEntry : secondCharacterNumberMap.entrySet()) {
            Character secondChar = secondEntry.getKey();
            Integer secondCharNum = secondEntry.getValue();

            Integer firstCharNum = firstCharacterNumberMap.get(secondChar);
            if (firstCharNum == null) {
                totalDiff += secondCharNum;
            }
        }

        return totalDiff;
    }

    private static Map<Character, Integer> buildCharacterNumberMap(String string) {
        Map<Character, Integer> characterNumberMap = new HashMap<>();
        for (int i = 0;i < string.length(); ++i) {
            Integer num = characterNumberMap.get(string.charAt(i));
            if (num == null) {
                num = 1;
            } else {
                ++num;
            }
            characterNumberMap.put(string.charAt(i), num);
        }
        return characterNumberMap;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
