package sorting;

import java.util.Arrays;

public class QuickSort {
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            System.out.println("From quicksort if block " + "start: " + start + " end: " + end);
            return;
        }
        System.out.println("From quicksort virtual else bock " + "start: " + start + " end: " + end);
        int pivotIndex = partition(arr, start, end);
        System.out.println("start: " + start + " end: " + end + " pivotIndex: " + pivotIndex);
        System.out.println("Left call");
        quickSort(arr, start, pivotIndex - 1); // left
        System.out.println("Right call");
        quickSort(arr, pivotIndex + 1, end); // right
    }

    private static int partition(int[] arr, int start, int end) {
        System.out.println("entered partition: ");
        int pivot = arr[end];
        int i = start;
        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

        int temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;

        System.out.println("Returning from partition " + Arrays.toString(arr) + " pivotIndex: " + i);
        return i;
    }
}
