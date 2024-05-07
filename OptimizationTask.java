import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptimizationTask {
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
        List<Integer> sumList = new ArrayList<>();

        for (String strElement : listForSum){
            int sum = 0;
            for (int i : strElement.toCharArray()) {
                switch (i) {
                    case 'a': sum += 3; break;
                    case 'b': sum += 2; break;
                    case 'c': sum += 1; break;
                }
            }
            sumList.add(Integer.valueOf(String.valueOf(sum)));
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
