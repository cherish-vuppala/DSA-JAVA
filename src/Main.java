import recursion.solutions.RecursionSolutions;
import sorting.*;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        int[] arr = {6, 10, 7, 9, 2, 3, 5, 4};
//        int[] arr = {1, 7, 9, 5, 11, 2};
//
//        System.out.println(Arrays.toString(arr));
//        var bubleSort = new BubbleSort();
//        Sorting sorting = bubleSort::sort;
//        sorting.sort(arr);
//        System.out.println(Arrays.toString(arr));
//
//        System.out.println(Arrays.toString(arr));
//        var selectionSort = new SelectionSort();
//        sorting = selectionSort::sort;
//        sorting.sort(arr);
//        System.out.println(Arrays.toString(arr));
//
//        System.out.println(Arrays.toString(arr));
//        var insertionSort = new InsertionSort();
//        sorting = insertionSort::sort;
//        sorting.sort(arr);
//        System.out.println(Arrays.toString(arr));
//
//        System.out.println(Arrays.toString(arr));
//        var mergeSort = new MergeSort();
//        sorting = mergeSort::sort;
//        sorting.sort(arr);
//        System.out.println(Arrays.toString(arr));
//
//        System.out.println(Arrays.toString(arr));
//        var quickSort = new QuickSort();
//        sorting = quickSort::sort;
//        sorting.sort(arr);
//        System.out.println(Arrays.toString(arr));

        var recursion = new RecursionSolutions();
//        var n = 14;
//        var result = String.format("recursion.countSteps(%s) = %s", 14, recursion.countSteps(14));
//        System.out.println(result);

//        var n = 3;
//        var result = String.format("Generate All Strings of length %s: %s", n, recursion.generateAllStrings(n));
//        System.out.println(result);
        var list = recursion.letterCombinations("23");
        System.out.println("list = " + list);
    }
}