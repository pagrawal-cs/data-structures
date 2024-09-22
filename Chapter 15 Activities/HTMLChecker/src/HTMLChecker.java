import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/**
 * Write a program that checks whether a sequence of HTML tags
 * is properly nested. For each opening tag, such as <p>, there
 * must be a closing tag </p>. A tag such as <p> may have other
 * tags inside, for example <p> <ul> <li> </li> </ul> <a> </a> </p>
 * <p>
 * The inner tags must be closed before the outer ones.
 * Your program should process a file containing tags.
 * For simplicity, assume that the tags are separated by
 * spaces, and that there is no text inside the tags.
*/
public class HTMLChecker
{
    public static void main(String[] args)
    {
        String filename = "Chapter 15 Activities//HTMLChecker//src/TagSample3.html";
        
        try (Scanner in = new Scanner(new File(filename)))
        {
            // Your code goes here
            Stack<String> HTML = new Stack<>();
            boolean NestedProperly = true;

            while (in.hasNext())
            {
                String tag = in.next();

                // Adds the opening HTML tags to the stack
                if ((tag.startsWith("<")) && !(tag.startsWith("</")))
                {
                    // Checks if tags are opened more than once without being closed
                    if (HTML.contains(tag))
                    {
                        System.out.println("\nThe tag " + tag + " cannot be opened twice before closing it first.\n");
                        NestedProperly = false;
                        break;
                    }
                    HTML.push(tag);
                    //System.out.println(tag);
                }
                // Checks if tags are being closed in the proper order
                else if (tag.startsWith("</"))
                {
                    // Checks if uncreated tags are being closed
                    if (HTML.isEmpty())
                    {
                        System.out.println("\nThe tag " + tag + " hasn't been created yet, so it canot be closed.");
                        NestedProperly = false;
                        break;
                    }
                    // Checks if the correct tag is being closed
                    else
                    {
                        String last = HTML.pop();
                        String expectedTag = "<" + tag.substring(2);

                        if(!(last.equals(expectedTag)))
                        {
                            System.out.println("\nThe tag " + tag + " hasn't been properly nested - it has been closed before another tag should be closed.\n");
                            NestedProperly = false;
                            break;
                        }
                    }
                }
            }

            // Prints if everything runs smoothly
            if (NestedProperly == true)
                System.out.println("\nAll the HTML tags are properly nested! :)\n");
        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open: " + filename);
        }
        
    }
}
