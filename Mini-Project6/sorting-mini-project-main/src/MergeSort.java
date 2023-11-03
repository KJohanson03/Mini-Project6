import java.util.Comparator;

/**
 * Sort using merge sort.
 *
 * @author Kevin Johanson
 * CSC 207 Mini Project6 11/2/2023
 * Worked With Maria Roduriguez and Luke Walters on this
 */

public class MergeSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MergeSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  MergeSort() {
  } // MergeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    if (values == null || values.length <= 1) {
      return;
    } else{
     
      //calls mergesort on the array
      mergeSort(values, order, 0, values.length);
      //merges all the split (sorted) arrays
      merge(values, 0, values.length/2, values.length, order);
    }//else

  } // sort

  public static <T> void mergeSort(T[] values, Comparator<? super T> order, int lb, int ub){
    if(lb >= ub-1){
      return;
    } else{
      //these get redefined after every recursive call to mergesort
      int lo = lb;
      int hi = ub-1;
      int mid = lo + (ub - lo)/2;

      //sorts the left half of the split array
      while(lo < mid){
        if(order.compare(values[lo], values[lo+1]) > 0){
          swap(values, lo, lo+1);
        }
        lo++;
      }//while

      //sorts the right half of the split array
      while(mid < hi){
        if(order.compare(values[mid], values[mid+1]) > 0){
          swap(values, mid, mid+1);
        }
        mid++;
      }//while

      //recursively calls mergeSort
      mergeSort(values, order, lb, mid);
      mergeSort(values, order, mid+1, ub);
    }//else  
  }//MergeSort


  static <T> void merge(T[] vals, int lo, int mid, int hi, Comparator<? super T> comparator) {
    T[] merged = java.util.Arrays.copyOfRange(vals, lo, hi);
    //int left = hi -1;
    int right = mid+1;
    int current = lo;

    //performs the while loop until either left or right is completely sorted
    while((lo <= lo + (mid - lo)) && (right <= hi-1)){ //if the left array has a smaller val
      
      if(comparator.compare(vals[lo], vals[right]) <= 0){
        merged[current++] = vals[lo++];
      }//if

      
      else { //if the right array has a smaller val
        merged[current++] = vals[right++];
      }//else
    }//while

    //move over left
    while(lo < mid+1){
      merged[current++] = vals[lo++];
    }//while

    //move over right
    while(right < hi){
      merged[current++] = vals[right++];
    }//while

    for(int i = 0; i< vals.length; i++){
      vals[i] = merged[i];
    }//for
  } // merge


    // Swaps two indices in a generic array
    // Void return type
    public static <T> void swap (T[] arr, int i, int j){
      T temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    } // swap

} // class MergeSort
