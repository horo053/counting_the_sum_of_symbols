import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class CountingTheSumOfSymbols {
    public static void main(String[] args) {
        String[] myArray  = {"aaaa", "bbbb", "cccc", "abab", "abcabc", "aaccaab", "aabaab"};

        System.out.println(changingType(myArray));
        System.out.println(countingTheSumOfLetters(myArray));

        largestAmount(changingType(myArray), countingTheSumOfLetters(myArray));
    }

    public static List<String> changingType(String[] myArray) {
        List<String> myList = new ArrayList<>(Arrays.asList(myArray));
        List<String> validList = new ArrayList<>();

        int myListSize = myList.size();
        int k = 0;
        String str;
        String s;

        for (int i = 0; i<myListSize; i++){
            str = myList.get(i);
            for (int j = 0; j < str.length(); j++){
                s = String.valueOf(str.charAt(j));
                if (s.equals("a") || s.equals("b") || s.equals("c")){
                    k++;
                }
            }
            if (k == str.length()){
                validList.add(str);
            }
            k=0;
        }
        return validList;
    }

    public static List<Integer> countingTheSumOfLetters(String[] validList) {
        List<String> listForSum = new ArrayList<>(changingType(validList));
        int myListSize = listForSum.size();
        String str;
        List<Integer> sumList = new ArrayList<>();

        int a = 0;
        int b = 0;
        int c = 0;
        int sum = 0;
        int k = 0;

        for (int i = 0; i<myListSize; i++){
            str = listForSum.get(i);
            for (int j = 0; j < str.length(); j++) {
                switch (str.charAt(j)) {
                    case 'a': a += 3; break;
                    case 'b': b += 2; break;
                    case 'c': c += 1; break;
                }
                k++;
                sum = a+b+c;
            }
            if (k == str.length()){
                sumList.add(Integer.valueOf(String.valueOf(sum)));
            }
            k = 0;
            sum = 0;
            a = 0;
            b = 0;
            c = 0;
        }
        return sumList;
    }

    public static void largestAmount(List<String> validList, List<Integer> sumList) {
        List<String> validLettersList = validList;
        List<Integer> sumLettersList = sumList;

        int max = 0;
        String str = null;

        for(int i = 0; i<sumLettersList.size(); i++){
            if(max > sumLettersList.get(i)){
                max = max;
                str = str;
            } else if (max < sumLettersList.get(i)){
                max = sumLettersList.get(i);
                str = validLettersList.get(i);
            } else if (max == sumLettersList.get(i)){
                if (str.length() < validLettersList.get(i).length()){
                    max = max;
                    str = str;
                } else if (str.length() > validLettersList.get(i).length()){
                    max = sumLettersList.get(i);
                    str = validLettersList.get(i);
                } else if (str.length() == validLettersList.get(i).length()){
                    max = sumLettersList.get(i);
                    str = str + ", " + validLettersList.get(i);
                }
            }
        }
        System.out.println(str);
    }
}
