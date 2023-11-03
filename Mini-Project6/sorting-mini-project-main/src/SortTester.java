import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.math.BigInteger;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * Tests of Sorter objects.
 *
 * @author Kevin Johanson
 */
public class SortTester {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  Sorter sorter;

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  @Test
  public void fakeTest() {
    assertTrue(true);
  } // fakeTest()


  @Test
  public void shortIntTest() {
    Integer[] original = {3, 2, 1};
    Integer[] expected = {1, 2, 3};

    this.sorter.sort(original, (x,y) -> x == y ? 0 : x < y ? -1 : 1);
    assertArrayEquals(original, expected);
  } // shortIntTest

  @Test
  public void orderedStringTest() {
    String[] original = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] expected = original.clone();
    this.sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest


  @Test
  public void reverseOrderedStringTest() {
    String[] original = { "foxtrot", "delta", "charlie", "bravo", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    this.sorter.sort(original, (x, y) -> x.compareTo(y));

    assertArrayEquals(original, expected);
  } // orderedStringTest

  // tests a regular list of unordred integers
  @Test
  public void unorderedOrderedIntegersTest() {
    Integer[] original = {2, 3, 10, 11, 5, 6};
    Integer[] expected = {2, 3, 5, 6, 10, 11};

    this.sorter.sort(original, (x,y) -> x == y ? 0 : x < y ? -1 : 1);
    assertArrayEquals(original, expected);
  }

  // tests a list of already ordered integers
  @Test
  public void orderedIntegerList() {
    Integer[] original = {1,2,3,4,5,6,7,8,9,10};
    Integer[] expected = original.clone();

    this.sorter.sort(original, (x,y) -> x == y ? 0 : x < y ? -1 : 1);
    assertArrayEquals(original, expected);
  }

  // tests the empty list edge case 
  @Test
  public void EmptyList() {
    Integer[] original = {};
    Integer[] expected = {};

    this.sorter.sort(original, (x,y) -> x == y ? 0 : x < y ? -1 : 1);
    assertArrayEquals(original, expected);
  }
  
  //tests a list of duplicate integers
  @Test
  public void duplicateIntegerList() {
    Integer[] original = {1,1,2,2,5,5,3,3,2,2,5,5,9,9,10,12};
    Integer[] expected = {1,1,2,2,2,2,3,3,5,5,5,5,9,9,10,12};

    this.sorter.sort(original, (x,y) -> x == y ? 0 : x < y ? -1 : 1);
    assertArrayEquals(original, expected);
  }

  // Tests a list of unordered strings
  @Test
  public void stringList() {
    String[] original = {"a", "c", "b", "e", "f", "a"};
    String[] expected = {"a", "a", "b", "c", "e", "f"};

    this.sorter.sort(original, (x,y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  }


} // class SortTester
