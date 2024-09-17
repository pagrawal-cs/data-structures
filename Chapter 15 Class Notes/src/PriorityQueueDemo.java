import java.util.PriorityQueue;
import java.util.Queue;


/**
 * This program demonstrates a priority queue of to-do items. The
 * most important to-do items are removed first.
*/
public class PriorityQueueDemo
{
    public static void main(String[] args)
    {
        // Create a to-do list
        // The WorkOrder class has a priority and description
        Queue<WorkOrder> toDo = new PriorityQueue<>();

        // Lower priority is more important
        toDo.add(new WorkOrder(3, "Water Plants"));
        toDo.add(new WorkOrder(2, "Make Dinner"));
        toDo.add(new WorkOrder(1, "Conquer World"));
        toDo.add(new WorkOrder(9, "Play Videogames"));
        toDo.add(new WorkOrder(1, "Study for the Ch. 15 Test"));

        // Objects are NOT stored in priority order
        System.out.println(toDo);
        
        // Objects will BE removed in priority order
        while (toDo.size() > 0)
        {
            System.out.println(toDo.remove());
        }
    }
}
