import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptimizationTask {
    public static void main(String[] args) {
        String[] myArray  = {"aabaab", "aaaa", "bbubb", "cccc", "abkab", "abcabc", "baaaab", "bbbbbb", "aabbaa"};

        System.out.println(changingType(myArray));
        System.out.println(countingTheSumOfLetters(myArray));

    }

    public static List<String> changingType(String[] myArray) {
        List<String> myList = new ArrayList<>(Arrays.asList(myArray));
        List<String> validList = new ArrayList<>();

        for (String strElement : myList){
            int k = 0;
            for (char i : strElement.toCharArray()){
                if (i == 'a' || i == 'b' ||i == 'c'){
                    k++;
                }
            }
            if (k == strElement.length()){
                validList.add(strElement);
            }
        }
        return validList;
    }

    public static String countingTheSumOfLetters(String[] validList) {
        List<String> listForSum = new ArrayList<>(changingType(validList));
        int max = 0;
        String maxStr = null;
        String resStr = null;

        for (String strElement : listForSum){
            int sum = 0;
            for (int i : strElement.toCharArray()) {
                switch (i) {
                    case 'a': sum += 3; break;
                    case 'b': sum += 2; break;
                    case 'c': sum += 1; break;
                }
            }
            if(max < sum){
                max = sum;
                maxStr = strElement;
                resStr = strElement;
            } else if(max > sum){
                max = max;
                maxStr = maxStr;
                resStr = resStr;
            } else {
                if(maxStr.length() > strElement.length()){
                    maxStr = strElement;
                    resStr = strElement;
                } else if(maxStr.length() < strElement.length()){
                    maxStr = maxStr;
                    resStr = resStr;
                } else if(maxStr.length() == strElement.length()) {
                    maxStr = strElement;
                    resStr = resStr + ", " + strElement;
                }
            }
        }
        return resStr;
    }

/*    public static void largestAmount(List<String> validList, List<Integer> sumList) {
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
    }*/
}
