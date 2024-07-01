package sorting;

import java.util.Arrays;

public class Sorting {
    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        mergeSort(arr, start, mid); // left half
        mergeSort(arr, mid + 1, end); // right half
        merge(arr, start, mid, end); // merge left and right halves
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // filling the leftover elements
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // filling the leftover elements
        while (j <= end) {
            temp[k++] = arr[j++];
        }

        // copying elements back to original array from temp array
        for (int l = 0; l < temp.length; l++) {
            arr[start + l] = temp[l];
        }

    }

    public static void quickSort(int[] arr) {
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

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int prev = i - 1;

            // pushing back elements from sorted array
            while (prev >= 0 && arr[prev] >= curr) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = curr;
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            //finding the min index in unsorted part and place it in the beginning
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }


}
