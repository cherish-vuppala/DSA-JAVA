import sorting.Sorting;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        int[] arr = {6, 10, 7, 9, 2, 3, 5, 4};
        int[] arr = {1, 7, 9, 5, 11, 2};
        Sorting.selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}