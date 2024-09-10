import java.util.HashSet;
import java.util.Scanner;

/**
 * A program that implements the sieve of Eratosthenes.
*/
public class Sieve
{
    public static void main(String[] args)
    {
        // Asking the user for a number (n-value)
        Scanner in = new Scanner(System.in);
        System.out.println("Compute primes up to which integer?");
        int n = in.nextInt();

        // Creating two variables to use it in the two while loops below
        int num = 2;
        int num2 = 2;

        // Creating a set
        HashSet<Integer> set = new HashSet<Integer>();

        // Inserting all prime numbers from 2 to n in a set
        while (num <= n)
        {
            set.add(num);
            num++;
        }
        
        // Removing all non-prime numbers
        while (num2 <= n)
        {
            for (int i = 2; i <= num2/2; i++)
            {
                if (num2 % i == 0)
                    set.remove(num2);
            }
            num2++;
        }

        // Printing the new set with all the prime numbers
        System.out.print("The prime numbers up to " + n + " are: " + set);
    }
}

