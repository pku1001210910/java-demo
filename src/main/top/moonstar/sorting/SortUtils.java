package top.moonstar.sorting;

public class SortUtils {
    public static void main(String[] args) {
        int[] arr = new int[] { 3, 4, 1, 2, 4, 56, 16, 16 };
        mergesort(arr);
        print(arr);
    }

    public static void mergesort(int[] array) {
        mergesortSortHelper(array, 0, array.length - 1);
    }

    private static void mergesortSortHelper(int[] array, int from, int to) {
        if (from >= to) {
            return;
        }
        int mid = (from + to) / 2;
        mergesortSortHelper(array, from, mid);
        mergesortSortHelper(array, mid + 1, to);
        mergesortMergeHelper(array, from, mid, to);
    }

    private static void mergesortMergeHelper(int[] array, int from, int mid, int to) {
        int[] temp = new int[to - from + 1];
        int index = 0;

        int i = from;
        int j = mid + 1;
        while (i <= mid && j <= to) {
            int val1 = array[i];
            int val2 = array[j];

            if (val1 < val2) {
                temp[index++] = val1;
                i++;
            } else {
                temp[index++] = val2;
                j++;
            }
        }
        while (i <= mid) {
            temp[index++] = array[i++];
        }
        while (j <= to) {
            temp[index++] = array[j++];
        }

        i = from;
        for (int num : temp) {
            array[i++] = num;
        }
    }

    public static void insertsort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int val = array[i];
            int insertIndex = i;
            while (insertIndex > 0) {
                if (array[insertIndex - 1] > val) {
                    insertIndex--;
                    continue;
                }
                break;
            }

            int moveIndex = i;
            while (moveIndex > insertIndex) {
                array[moveIndex] = array[moveIndex - 1];
                moveIndex--;
            }
            array[insertIndex] = val;
        }
    }

    public static void selectionsort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minValIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[minValIndex] > array[j]) {
                    minValIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minValIndex];
            array[minValIndex] = temp;
        }
    }

    public static void bubblesort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] <= array[j + 1]) {
                    continue;
                }

                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
    }

    public static void quicksort(int[] array) {
        quicksortHelper(array, 0, array.length - 1);
    }

    private static void quicksortHelper(int[] array, int from, int to) {
        if (from >= to) {
            return;
        }

        int pivot = array[to];
        int left = from;
        int right = to;
        while (left < right) {
            int leftVal = array[left];
            if (leftVal < pivot) {
                left++;
                continue;
            }

            array[left] = array[right - 1];
            array[right - 1] = pivot;
            array[right] = leftVal;
            right--;
        }
        quicksortHelper(array, from, left - 1);
        quicksortHelper(array, left + 1, to);
    }

    private static void print(int[] array) {
        for (int i : array) {
            System.out.println(i);
        }
    }
}
