import javassist.expr.NewArray;

import java.util.ArrayList;
import java.util.List;

public class ListExercises {

    /** Returns the total sum in a list of integers */
	public static int sum(List<Integer> L) {
        // TODO: Fill in this function.
        int sum = 0;
        for (int item : L){
            sum+=item;
        }
        return sum;
    }

    /** Returns a list containing the even numbers of the given list */
    public static List<Integer> evens(List<Integer> L) {
        // TODO: Fill in this function.
        List<Integer> evens = new ArrayList<>();
        for (int item : L){
            if (item % 2 == 0) {
                evens.add(item);
            }
        }
        return evens;
    }

    /** Returns a list containing the common item of the two given lists */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        // TODO: Fill in this function.
        List<Integer> common = new ArrayList<>();
        for (int item1 : L1){
            for (int item2 : L2){
                if (item1 == item2){
                    common.add(item1);
                }
            }
        }
        return common;
    }


    /** Returns the number of occurrences of the given character in a list of strings. */
    public static int countOccurrencesOfC(List<String> words, char c) {
        // TODO: Fill in this function.
        int times = 0;
        for (String word: words){
            for (char c2 : word.toCharArray()){
                if (c2 == c){
                    times++;
                }
            }
        }
        return times;
    }
}
