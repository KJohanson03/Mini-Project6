import java.util.Comparator;


/**
 * Sort using insertion sort.
 *
 * @author Kevin Johanson
 * Worked With luke Walters
 */

public class InsertionSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new InsertionSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  InsertionSort() {
  } // InsertionSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    int insertionPoint = 0; //current index at which we are sorting everything before is sorted everything at and after is not
    T tempVal = null; 
    int goingBackwards = 1; // keeps track of how many positions backs we moved 

    if (values.length == 0) { // checks if list is empty
      System.out.println("[]");
    } // if 

    for (int i = 1; i < values.length; i++) {
      for (int j = 0; j < i; j++) {


       if ( (order.compare(values[i],values[j])) <= 0 && (tempVal == null)){ // compares the array at i to everything before it until it hits one thats less than it
        tempVal = values[i];
        insertionPoint = j;
        values[i] = values[i-1];
       } // if

       if (tempVal != null) { // if weve already found the point were inserting to
        values[i-goingBackwards +1] = values[i - goingBackwards];
        goingBackwards++;
       } // if


       if (j == (i-1) && tempVal != null) { // on the last iteration of the loop
        values[insertionPoint] = tempVal;
       } 

      } // for 
      insertionPoint = 0;
      tempVal = null;
      goingBackwards = 1;
    } //for

  } // sort(T[], Comparator<? super T>
} // class InsertionSort
