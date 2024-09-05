package sorting;

public class MergeSort {
    public void sort(int[] arr) {
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
}
