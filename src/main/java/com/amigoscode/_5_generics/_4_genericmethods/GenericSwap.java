package com.amigoscode._5_generics._4_genericmethods;

import java.util.Arrays;

/**
 * Exercise: Generic Swap and Reverse
 * <p>
 * This exercise practices generic methods by implementing swap and reverse
 * operations that work with arrays of any type.
 * <p>
 * Complete the TODOs below.
 */
public class GenericSwap {

    // TODO: 1 - Create a static generic method: <T> void swap(T[] array, int i, int j)
    //  It should swap the elements at indices i and j in the array.
    //  Use a temporary variable of type T to perform the swap.
    static <T> void swap(T[] array, int i, int j) {
        T var1 = array[i];
        array[i] = array[j];
        array[j] = var1;
    }


    // TODO: 2 - Create a static generic method: <T> T[] reverse(T[] array)
    //  It should reverse the array in place and return it.
    //  Hint: swap elements from both ends, moving toward the center.
    //  Use the swap() method you wrote in TODO 1.
    static <T> T[] reverse(T[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right){
            swap(array,left,right);
            left++;
            right--;
        }
        return array;
    }



    public static void main(String[] args) {

        // TODO: 3 - Create an Integer[] array {1, 2, 3, 4, 5}.
        //  Use swap() to swap the first and last elements.
        //  Print the result using Arrays.toString().
        Integer[] elem = {1, 2, 3, 4, 5};
        swap(elem, 0, 4);
        System.out.println(Arrays.toString(elem));



        // TODO: 4 - Create a String[] array {"A", "B", "C", "D"}.
        //  Use swap() to swap elements at index 1 and index 2.
        //  Print the result using Arrays.toString().
        String[]arr = {"A", "B", "C", "D"};
        swap(arr,1,2);
        System.out.println(Arrays.toString(arr));


        // TODO: 5 - Use reverse() on both the Integer[] and String[] arrays.
        //  Print the reversed arrays using Arrays.toString().
        //  Verify the output is correct.
        System.out.println(Arrays.toString(reverse(elem)));
        System.out.println(Arrays.toString(reverse(arr)));

    }
}
