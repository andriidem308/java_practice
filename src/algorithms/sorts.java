package algorithms;

public class sorts {
    public static void selectionSort(int[] array){
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

    public static void insertionSort(int[] array){
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

    public static int binarySearch(int[] array, int key){
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

    public static void main(String[] args) {
        int[] arr = {5, 4, 2, 7, 1, 8, 9, 6, 2, 3, 7};
        for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");
        System.out.println();
//        selectionSort(arr);
        insertionSort(arr);
        System.out.println(binarySearch(arr, 4));
        System.out.println(binarySearch(arr, 7));
        for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");
    }
}
