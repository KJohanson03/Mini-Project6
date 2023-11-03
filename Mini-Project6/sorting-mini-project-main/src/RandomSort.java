// Kevin Johanson   11/2/2023
// CSC207 MiniProject 6 
//
// Implements a random sort on generics

import java.util.Random;
import java.util.Comparator;

public class RandomSort implements Sorter{

    // Fields
    public static Sorter SORTER = new RandomSort();
    //--------
    
    // the main sort operation that calls the randomizer
    public <T> void sort(T[] values, Comparator<? super T> order) {
        if ((values.length == 0) || (values.length == 1)) { // checks if the array empty or equal to size 1
            return;
        }

        while (!(isSorted(values, order))) { // keep getting permutations of the list untill it is sorted
            randomizer(values, order);
        } // while

    } // sort

    //randomizes every index of the array 
    public <T> void randomizer(T[] values, Comparator<? super T> order) {
        Random rand = new Random(); // sets the seed for random
        int randInt = 0;  
        for (int i = 0; i < values.length; i++) { // creates a random permutation of the array
            randInt = rand.nextInt(values.length); 
            swap(values, i,  randInt);
        }// for 
    }

    //checks to see if the array is sorted
    //return type void
    public <T> boolean isSorted(T[] values, Comparator<? super T> order) {
        for (int i = 1; i < values.length; i++) {
            if (!(order.compare(values[i-1], values[i]) <= 0 )) {
                return false;
            }// if 
        } // for
        return true;
    } // isSorted

    // Swaps two indices in a generic array
    // Void return type
    public static <T> void swap (T[] arr, int i, int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      } // swap

} // RandomSort
