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
        String word =" ", backwards =""; String temp = "";
        
        // Complete this method. Use a Stack.
        Stack<String> reverser = new Stack<>();

        for (int i = 0; i < sentence.length(); i++)
        {
            if (sentence.substring(i, i + 1).equals(" "))
            {
              reverser.push(word.toLowerCase());
                word = "";

            }
            else if (sentence.substring(i, i + 1).equals("."))
            {
                
                reverser.push(word.toLowerCase());
                word = "";
                for (int j = 0; j < reverser.size()+4; j++){
                    temp = reverser.pop();
                    if (j == 0){
                        
                        backwards += temp.substring(0,2).toUpperCase() + temp.substring(2);
                    }
                    else
                       backwards += temp;

                    if (j == reverser.size()+4)
                        backwards += ".";
                }

            }
                word += sentence.substring(i, i + 1).toLowerCase();
            
            
        }


        return backwards;

    }
}