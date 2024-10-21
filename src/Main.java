//import patterns.Solutions;
import recursion.solutions.RecursionSolutions;

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
        int[] arr = {5, 12, 3, 17, 1, 18, 15, 3, 17 };
        var target = 6;
        var list = recursion.findAllSubsetsWhoseSumIsK(arr, target);
        System.out.println("list = " + list);
//        var n = 14;
//        var result = String.format("recursion.countSteps(%s) = %s", 14, recursion.countSteps(14));
//        System.out.println(result);

//        var n = 3;
//        var result = String.format("Generate All Strings of length %s: %s", n, recursion.generateAllStrings(n));
//        System.out.println(result);
//        var list = recursion.letterCombinations("23");
//        System.out.println("list = " + list);
//        var str = "abc";
//        var result = String.format("All permutations of string %s : %s", str, recursion.findAllPermutations(str));
//        System.out.println("result = " + result);
//        var patterns = new Solutions();
//        patterns.primePattern(5);
    }
}