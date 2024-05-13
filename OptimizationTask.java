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
            if((max < sum) || ((max == sum) && ((maxStr.length() > strElement.length()) || (maxStr == null))) ){
                max = sum;
                maxStr = strElement;
                resStr = strElement;
            } else if((maxStr.length() == strElement.length()) && (max == sum)) {
                maxStr = strElement;
                resStr = resStr + ", " + strElement;
            }
        }
        return resStr;
    }
}
