import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
* Programi Java rendit një grup me numra të plotë duke përdorur algoritmin e renditjes radix.
 * hyrje: [80, 50, 30, 10, 90, 60, 0, 70, 40, 20, 50]
 * prodhimi: [0, 10, 20, 30, 40, 50, 50, 60, 70, 80, 90]
 *
 * Kompleksiteti kohor i zgjidhjes:
 * Rasti më i mirë O(n); Rasti mesatar O(n); Rasti më i keq O(n^2).
 *
 */

public class BuckeSort {

  public static void main(String[] args) {

    System.out.println("Bucket sort ne Java");
    int[] input = { 80, 50, 30, 10, 90, 60, 0, 70, 40, 20, 50 };

    System.out.println("Para Sortimit");
    System.out.println(Arrays.toString(input));

    //  radix Sort Algorithm
    bucketSort(input);

    System.out.println("Pas Sortimit");
    System.out.println(Arrays.toString(input));

  }

  /**
   * 
   * @param input
   */
  public static void bucketSort(int[] input) {
  
    final int[] code = hash(input);
    
   
    List[] buckets = new List[code[1]];
    for (int i = 0; i < code[1]; i++) {
      buckets[i] = new ArrayList();
    }
    
    
    for (int i : input) {
      buckets[hash(i, code)].add(i);
    }
    
   
    for (List bucket : buckets) {
      Collections.sort(bucket);
    }
    
    int ndx = 0;
   
    for (int b = 0; b < buckets.length; b++) {
      for (int v : buckets[b]) {
        input[ndx++] = v;
      }
    }
  }

  
  private static int[] hash(int[] input) {
    int m = input[0];
    for (int i = 1; i < input.length; i++) {
      if (m < input[i]) {
        m = input[i];
      }
    }
    return new int[] { m, (int) Math.sqrt(input.length) };
  }

  /**
   * 
   * @param i
   * @param code
   * @return
   */
  private static int hash(int i, int[] code) {
    return (int) ((double) i / code[0] * (code[1] - 1));
  }

}


Output
Bucket sort in Java
integer array before sorting
[80, 50, 30, 10, 90, 60, 0, 70, 40, 20, 50]
integer array after sorting using bucket sort algorithm
[0, 10, 20, 30, 40, 50, 50, 60, 70, 80, 90]
