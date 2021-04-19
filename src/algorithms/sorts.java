package algorithms;

public class sorts {
    static void bubbleSort(int[] array){
        int size = array.length;
        boolean swapped = true;

        while (swapped) {
            swapped = false;

            for (int i = 0; i < size - 1; i++){
                if (array[i] > array[i+1]) {
                    int tmp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = tmp;
                    swapped = true;
                }
            }
        }
    }

    static void selectionSort(int[] array){
        int size = array.length;
        int i, j, lowestValueIndex;

        for (i = 0; i < size; i++){
            lowestValueIndex = i;

            for (j = i + 1; j < size; j++){
                if (array[j] < array[lowestValueIndex]){
                    lowestValueIndex = j;
                }
            }

            int tmp = array[i];
            array[i] = array[lowestValueIndex];
            array[lowestValueIndex] = tmp;
        }
    }

    static void insertionSort(int[] array){
        int size = array.length;
        int i, j, itemToInsert;

        for (i = 1; i < size; i++){
            itemToInsert = array[i];
            j = i - 1;

            while (j >= 0 && array[j] > itemToInsert){
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = itemToInsert;
        }
    }

    static void merge(int[] array, int l, int m, int r){
        int ln = m - l + 1;
        int rn = r - m;

        int[] L = new int[ln];
        int[] R = new int[rn];

        for (int i = 0; i < ln; i++) L[i] = array[l + i];
        for (int i = 0; i < rn; i++) R[i] = array[m + 1 + i];

        int li = 0, ri = 0;
        int k = l;

        while (li < ln && ri < rn) {
            if (L[li] < R[ri]){
                array[k++] = L[li++];
            }
            else {
                array[k++] = R[ri++];
            }
        }

        while (li < ln){
            array[k++] = L[li++];
        }

        while (ri < rn){
            array[k++] = R[ri++];
        }
    }

    static void mergeSort(int[] array, int l, int r){
        if (l < r){
            int m = (l + r) / 2;

            mergeSort(array, l, m);
            mergeSort(array, m + 1, r);

            merge(array, l, m, r);
        }
    }

    static int partition(int[] array, int low, int high){
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++){
            if (array[j] <= pivot){
                int tmp = array[++i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }

        int tmp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = tmp;

        return i + 1;
    }

    static void quickSort(int[] array, int low, int high){
        if (low < high){
            int pi = partition(array, low, high);

            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    static int binarySearch(int[] array, int key){
        int left = 0;
        int right = array.length - 1;

        while (left < right){
            int middle = left + (right - left) / 2;

            if (array[middle] < key){
                left = middle + 1;
            } else if (array[middle] > key) {
                right = middle;
            } else {
                return middle;
            }
        }

        return -1;
    }

    static void printArray(int[] array){
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 2, 7, 1, 8, 9, 6, 2, 3, 7};
        printArray(arr);
        quickSort(arr, 0, arr.length - 1);
        printArray(arr);
    }
}
