package com.gsonkeno.dssa.sort;

import com.gsonkeno.dsaa.sort.QuickSort;

import java.util.Arrays;

/**
 * Created by gaosong on 2017-12-28
 */
public class QuickSortTest {

    public static void main(String[] args) {
        int[] A = {3,7,3,6,3,5,6};
        QuickSort.quickSort(A,0,A.length - 1);

        System.out.println(Arrays.toString(A));
    }
}
