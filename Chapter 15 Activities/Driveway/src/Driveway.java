import java.util.Stack;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Class for simulating a driveway and a street, using stacks
 * of cars with license plate numbers as representation.
*/
public class Driveway
{
  /**
  * Stack representing the cars in the driveway.
  */
  private Stack<Integer> driveway;

  /**
  * Stack representing the cars in the street.
  */
  private Stack<Integer> street; 

  /**
  * List representing the moved cars.
  */
    private ArrayList<Integer> movedCars;

  /**
   * Constructor.
  */
  public Driveway()
  {
    // Complete the constructor
    driveway = new Stack<>();
    street = new Stack<>();
    movedCars = new ArrayList<>();
  }

  /**
  * Add the given license plate to the driveway.
  *
  * @param licensePlate number of license plate.
  */
  public void add(int licensePlate)
  {
    // Complete this method - Adds the car to the driveway
    driveway.push(licensePlate);
    //System.out.println(street);
    //System.out.println(driveway);
  }

  /**
  * Remove the given license plate from the driveway.
  *
  * @param licensePlate number of license plate.
  */
  public void remove(int licensePlate)
  {
    // Complete this method - removes the car accordingly
    if (driveway.contains(licensePlate)) 
    {
      // Move cars to the street until we find the requested car to remove
      while (!driveway.isEmpty() && driveway.peek() != licensePlate) 
      {
        int tempCar = driveway.pop();
        street.push(tempCar);
        movedCars.add(tempCar);
      }

      // Remove the requested car
      if (!driveway.isEmpty()) 
        driveway.pop();

      // Move cars that were temporarily transferred to the street back to the driveway
      while (!street.isEmpty()) 
      {
        driveway.push(street.pop());
      }
    } 
    // If the car isn't in the driveway
    else 
    {
      System.out.println("Car with license plate " + licensePlate + " is not found in driveway.");
    }
  }

  /**
  * Prints the driveway and street details to the screen.
  */
  public void print()
  {
    System.out.println("In Driveway, starting at first in (one license plate per line):");
    // Print the cars in the driveway here
    for (Integer licensePlate : driveway) 
    {
      System.out.print(licensePlate + " ");
    }
    System.out.println();

    System.out.println("In Street, starting at first in (one license plate per line):");
    // Print the cars in the street here
    for (Integer licensePlate : movedCars) 
    {
      System.out.print(licensePlate + " ");
    }
    System.out.println();
  }
}
