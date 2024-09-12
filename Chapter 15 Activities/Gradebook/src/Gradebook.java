import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * A program to add, remove, modify or print
 * student names and grades.
*/
public class Gradebook
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        Map<String, String> studentGrade = new HashMap<>();

        boolean done = false;
        while(!done)
        {
            System.out.println("A)dd R)emove M)odify P)rint Q)uit");
            String input = in.next().toUpperCase();
            if (input.equals("Q"))
            {
                done = true;
            } else if (input.equals("A"))
            {
                System.out.println("What is the name of the student? ");
                String student = in.next();
                System.out.println("What is the grade of the student? ");
                String grade = in.next();

                if(!studentGrade.keySet().contains(student))
                    studentGrade.put(student, grade);
                else
                    System.out.println("That student is already in the gradebook.");

            } else if (input.equals("R"))
            {
                System.out.println("What is the name of the student? ");
                String student = in.next();

                studentGrade.remove(student);
                
            } else if (input.equals("M"))
            {
                System.out.println("What is the name of the student? ");
                String student = in.next();
                System.out.println("What is the grade of the student? ");
                String grade = in.next();

                if(studentGrade.keySet().contains(student))
                    studentGrade.put(student, grade);
                else
                    System.out.println("That student is not in the gradebook.");

            } else if (input.equalsIgnoreCase("P"))
            {
                Set<String> keys = studentGrade.keySet();
                ArrayList<String> keyList = new ArrayList<>(keys);
                keyList.sort(null);
                for (String key: keyList)
                    System.out.println(key + ": " + studentGrade.get(key));
            } else
            {
                done = true;
            }
        }
    }
}
