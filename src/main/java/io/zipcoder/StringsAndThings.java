package io.zipcoder;


/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input){
        int counter = 0;
        char curChar;

        for(int i = 0; i < input.length(); i++){
            curChar = input.charAt(i);
            // current character must be a 'z' or a 'y'
            if(curChar == 'z' || curChar == 'Z' || curChar == 'Y' || curChar == 'y'){
                // next character must not be a letter
                if(i+1 < input.length() && !Character.isLetter(input.charAt(i + 1))){
                    counter++;
                }
                else if(i+1 >= input.length()){
                    counter++;
                }
            }
        }

        return counter;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){
        int curIndex;
        while(true) {
            curIndex = base.indexOf(remove);
            // not sure if this works - i'll have to test it
            // jk it really doesn't work
            // base.replaceAll("", remove);
            if(curIndex == -1){
                break;
            }

            base = base.substring(0, curIndex) + base.substring(curIndex + remove.length());
        }
        return base;
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input){
        int countNot = 0;
        int countIs = 0;
        int indexNot = -1;
        int indexIs = -1;

        do {
            indexNot = input.indexOf("not", indexNot+1);
            indexIs = input.indexOf("is", indexIs+1);

            if(indexNot != -1){
                countNot++;
            }
            if(indexIs != -1){
                countIs++;
            }
        } while(indexNot != -1 && indexIs != -1);

        return countNot == countIs;
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input){
        int gIndex = 0;
        do {
            // first find the 'g'
            gIndex = input.indexOf('g', gIndex + 1);
            //make sure no exceptions
            if(gIndex != -1){
                if(gIndex - 1 > 0 && input.charAt(gIndex-1) == 'g'){
                    // if you found a 'g' to the left
                    continue;
                }
                if(gIndex + 1 < input.length() && input.charAt(gIndex+1) == 'g'){
                    // if you found a 'g' to the right
                    continue;
                }
                return false;
            }
        } while(gIndex != -1);
        return true;
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){
        int i = 0;
        int count = 0;
        while(i < input.length()-2){
            if(input.charAt(i) == input.charAt(i+1) && input.charAt(i) == input.charAt(i+2)){
                count++;
                i += 1;
            }
            i++;
        }
        return count;
    }
}
