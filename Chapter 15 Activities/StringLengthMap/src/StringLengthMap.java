import java.util.*;
import java.io.*;
/**
 * Read all words from a file and add them to a
 * map whose keys are word lengths and whose values
 * are comma-separated strings of words of the same length.
 * Then print out those strings, in increasing order by
 * the length of their entries.
 * Modify Worked Example 15.1.
 */
public class StringLengthMap
{
    public static void main(String[] args) throws FileNotFoundException
    {
        String filename = "Chapter 15 Activities//StringLengthMap//src//test1.txt";

        try (Scanner in = new Scanner(new File(filename)))
        {

            // Create your map here
            Map<Integer, Set<String>> StringLength = new HashMap<>();

            while (in.hasNext())
            {
                String word = clean(in.next());
                Integer len = word.length();

                // Update the map here
                // Modify Worked Example 15.1
                if (!StringLength.containsKey(len)) {
                    StringLength.put(len, new TreeSet<>()); // Use TreeSet to maintain alphabetical order
                }
                
                StringLength.get(len).add(word); // Add the word to the set corresponding to the first letter


            }

            // Print the strings, in increasing order of their length
            // Use this format: 1: i, a, i
            Set<Integer> keys = StringLength.keySet();
            for (Integer key: keys)
            {
            System.out.println(key + ": " + StringLength.get(key));  

            }
        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }
    }

    public static String clean(String s)
    {
        String r = "";
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (Character.isLetter(c))
            {
                r = r + c;
            }
        }
        return r.toLowerCase();
    }

}
