package sort;

class ClassicAlgo {


    /**
     * 冒泡排序
     * @param arr
     */
    public static void bubbleSort(int [] arr) {
        if (arr == null || arr.length == 0) return;
        for (int i = 0; i < arr.length - 1; ++i) {
            for (int j = 0; j < arr.length - 1 - i; ++j) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 选择排序
     * @param arr
     */
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        for (int i = 0; i < arr.length; ++i) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; ++j) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
    }


    /**
     * 插入排序
     * @param arr
     */
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        
        int prevIndex, cur;
        for (int i = 1; i < arr.length; ++i) {
            prevIndex = i - 1; 
            cur = arr[i];
            while (prevIndex >= 0 && cur < arr[prevIndex]) {
                arr[prevIndex + 1] = arr[prevIndex];
                prevIndex--;
            }
            arr[prevIndex + 1] = cur;
        }
    }

    /**
     * 希尔排序
     * @param arr
     */
    public static void shellSort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int cur = arr[i];
                while (j - gap >= 0 && cur < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j = j - gap;
                }
                arr[j] = cur;
            }
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        
        merge(arr, left, mid, right);
        
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] res = new int[right - left + 1];
        
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                res[k++] = arr[i++];
            } else {
                res[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            res[k++] = arr[i++];
        }
        while (j <= right) {
            res[k++] = arr[j++];
        }
        // set back
        for (int x = 0; x < res.length; ++x) {
            arr[left + x] = res[x];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4, 12, 3, 0, 88, 23, 99, 78};
        // bubbleSort(arr);
        // selectionSort(arr);
        // insertionSort(arr);
        // shellSort(arr);
        mergeSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}