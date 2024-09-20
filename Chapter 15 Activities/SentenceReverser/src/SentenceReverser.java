import java.util.Scanner;
import java.util.Stack;

/**
 * Class for reversing the order of a sentence.
*/
public class SentenceReverser
{
    /**
     * Reverses the given sentence.
     *
     * @param sentence Sentence to be reversed.
     * @return reversed sentence.
    */
    public static String reverse(String sentence)
    {
    	Scanner scanner = new Scanner(sentence);
        String word ="";
    	
        // Complete this method. Use a Stack.
        Stack<String> reverser = new Stack<>();

        for (int i = 0; i < sentence.length()-1; i++)
        {
            if (sentence.substring(i, i + 1).equals(",") ){
                //word += sentence.substring(i, i + 1);
                word = ", " + word;

                reverser.push(word);
                word = "";


            }
            else if (!(sentence.substring(i, i + 1).equals(" ")))
            {
                word += sentence.substring(i, i + 1);
                reverser.push(word);
                word = "";

            }
            else if (!(sentence.substring(i, i + 1).equals(".")))
            {
                reverser.push(word);
                word = "";

                for (int j = 0; j < reverser.size(); j++){
                    System.out.println(reverser.pop());
                }

            }
            
            
        }






        return "";

    }
}
