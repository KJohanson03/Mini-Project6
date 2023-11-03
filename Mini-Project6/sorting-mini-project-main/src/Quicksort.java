import java.util.Comparator;

/**
 * Sort using Quicksort.
 *
 * @author Kevin Johanson
 * Worked with Luke Walters 
 */

public class Quicksort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new Quicksort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  Quicksort() {
  } // Quicksort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  public static <T> int partition(T[] arr, Comparator<? super T> comparator, int lb, int ub) {

    // determine a pivot point, midpoint here
    int p = lb + (ub - lb)/2;
    

    // swap the pivot to the front of the subarray
    // T temp = arr[lb];
    // arr[lb] = arr[p];
    // arr[p] = temp;

    swap(arr, lb, p);

    // set small and large indices
    int small = lb + 1;
    int large = ub;


    while (large != small) { 
      // if first unprocessed element is greater than pivot
      if(comparator.compare(arr[small], arr[lb]) > 0){
        swap(arr, small, large - 1);
        large--;
      } 
      else{
        small++;
      }
    }

    swap(arr, lb, large -1);

    return large-1;

  } // partition

  
    // Swaps two indices in a generic array
    // Void return type
    public static <T> void swap (T[] arr, int i, int j){
      T temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    } // swap

  
 /**
   * Sort the values in indices [lb..ub) of values using order to compare values.
   * taken /modified from SamR's class in CSC207
   */
  public static <T> void quicksort(T[] values, Comparator<? super T> order, int lb, int ub) {
    // Subarrays of one element or fewer are sorted.
    if (lb >= ub-1) {
      return;
    } else {
      int mid = partition(values, order, lb, ub);
      quicksort(values, order, lb, mid);
      quicksort(values, order, mid+1, ub);
    } // if/else
  } // quicksort(T[], Comparator, int, int)

 // taken /modified from SamR's Lab class in CSC207
 @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    quicksort(values, order, 0, values.length);
  } // quicksort

} // class Quicksort
