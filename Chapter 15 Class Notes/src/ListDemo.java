import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This program demonstrates the LinkedList class
 * and ListIterator class.
*/
public class ListDemo
{
    public static void main(String[] args)
    {
        /* The addLast method can be used to populate a list. */
        LinkedList<String> staff = new LinkedList<>();
        staff.addLast("Tony");
        staff.addLast("Natasha");
        staff.addLast("Peter");
        staff.addLast("Gamora");

        System.out.println(staff); /* Ways to run: Click Run above main code, right click & Run, Run symbol at the top right, & Run at the top let menus */

        // The list is currently: TNPG (Tony, Natasha, Peter, Gamora)
        /*
         * The listIterator method creates a new list iterator that is positioned at the head of the list.
         * The | represents the iterator position.
         */
        ListIterator<String> iterator = staff.listIterator(); // |TNPG

        /* The next method advances the iterator OVER the next element in the list. */
        iterator.next(); // T|NPG --> Returns Tony

        /* The next method also returns the element that the iterator passes over. */
        String avenger = iterator.next(); // TN|PG
        System.out.println(avenger); // Should print Natasha

        /* The add method INSERTS an element at the iterator position. 
         * The iterator is then positioned AFTER the element that was added.
        */
        iterator.add("Steve"); // TNS|PG
        iterator.add("Clint"); // TNSC|PG

        System.out.println(staff);

        /* The remove method REMOVES the element returned by the last call to next() or previous(). 
         * The remove method can ONLY be called after calling next or previous.
         * The remove method CANNOT be called after calling add or remove.
        */
        iterator.next(); // TNSCP|G
        iterator.remove(); // Peter is removed now // TNSC|G
        System.out.println(staff); // IllegalStateException before next() was added--> can't remove right after adding; can only remove after call to next() or previous()

        /* The set method UPDATES the element returned by the last call to next or previous. */
        iterator.previous(); // TNS|CG
        iterator.set("T'Challa"); // TNS|TG // Clint is updated as that is what iterator passes over

        System.out.println(staff);

        /* The hasNext method determines if there is a NEXT NODE after the iterator (end of the list or no?). 
         * The hasNext method is often used in the condition of a while loop.
        */
        iterator = staff.listIterator(); // |TNSTG
        while (iterator.hasNext()) {
            String n = iterator.next();
            if (n.equals("Natasha")) { // TN|STG
                iterator.remove(); // T|STG
            }
        } // TSTG|

        /* Enhanced FOR LOOPS work wwith linked lists. */
        for (String n: staff) {
            System.out.println(n + " ");
        }

        System.out.println();

        /*
         * ConcurrentModificationException
         * 
         * CANNOT modify a linked list while using a iterator.
         * UNLESS you use the iterator to do the modification.
         */
        iterator = staff.listIterator(); // |TSTG
        while (iterator.hasNext()) {
            String n = iterator.next();
            if (n.equals("Tony")) {
                // staff.remove("Tony"); ConcurrentModificationException
            }
        }

        /* The enhanced for loop AUTOMATICALLY creates an iterator. */
        /* CANNOT add or remove when using an enhancer for loop this way because the iterator (staff) is hidden, so it's no accesable. */
        for (String n: staff) {
            if (n.equals("Tony")) {
                staff.add("Bruce"); 
            }
        }

        System.out.println(staff);
    }
}
