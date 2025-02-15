import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapExercises {
    /** Returns a map from every lower case letter to the number corresponding to that letter, where 'a' is
     * 1, 'b' is 2, 'c' is 3, ..., 'z' is 26.
     */
    public static Map<Character, Integer> letterToNum() {
        // TODO: Fill in this function.
        Map<Character,Integer> alphabet = new TreeMap<>();
        char word = 'a';
        for (int i = 1 ; i<27;i++){
            alphabet.put(word,i);
            word++;
        }
        return alphabet;
    }

    /** Returns a map from the integers in the list to their squares. For example, if the input list
     *  is [1, 3, 6, 7], the returned map goes from 1 to 1, 3 to 9, 6 to 36, and 7 to 49.
     */
    public static Map<Integer, Integer> squares(List<Integer> nums) {
        // TODO: Fill in this function.
        Map<Integer,Integer> squaresMap = new TreeMap<>();
        for (Integer a : nums){
            squaresMap.put(a,a*a);
        }
        return squaresMap;
    }

    /** Returns a map of the counts of all words that appear in a list of words. */
    public static Map<String, Integer> countWords(List<String> words) {
        // TODO: Fill in this function.
        Map<String,Integer> countWordsMap = new TreeMap<>();
        for (String word : words){
            if (countWordsMap.containsKey(word)){
                countWordsMap.compute(word,(k,v) -> v + 1);
            }
            else {
                countWordsMap.put(word,1);
            }
        }
        return countWordsMap;
    }
}
