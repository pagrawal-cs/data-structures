import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This class supplies a utility method to reverse the entries in a linked list.
*/
public class ListUtil
{
    /**
     * Reverses the elements in a linked list
     *
     * @param strings the linked list to reverse
    */
    public static void reverse(LinkedList<String> strings)
    {
        ListIterator<String> iterator = strings.listIterator();
        LinkedList<String> finalList = new LinkedList<>();

        while(iterator.hasNext())
        {
            iterator.next(); 
        }  
        
        int i = strings.size();
        
        while (i > 0)
        {
            String n = iterator.previous();
            finalList.addLast(n);
            i--;
        }

        strings.clear();
        strings.addAll(finalList);
    }
}