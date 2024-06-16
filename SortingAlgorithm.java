
import java.util.Arrays;
import java.util.Random;

public class SortingAlgorithm {

    public static void main(String[] args) {
        int[] count10 = generateRandomArray(10);
        int[] count100 = generateRandomArray(100);
        int[] count1000 = generateRandomArray(1000);
        int[] count10000 = generateRandomArray(10000);
        
        int[] smallData = generateRandomArray(10);
        int[] largeData = generateRandomArray(1000);

        System.out.println("Perbandingan Waktu Sorting : ");
        System.out.println("Counting Sort : ");
        long count10Time = measureCountingSort(count10);
        long count100Time = measureCountingSort(count100);
        
        System.out.println("10   Data : " + count10Time + " Nano");
        System.out.println("1000 Data : " + count100Time + " Nano");

        System.out.println("Selection Sort : ");
        long smallSel = measureSelectionSort(smallData);
        long largeSel = measureSelectionSort(largeData);
        System.out.println("10   Data : " + smallSel + " Nano");
        System.out.println("1000 Data : " + largeSel + " Nano");

        System.out.println("Bubble Sort : ");
        long smallBub = measureBubbleSort(smallData);
        long largeBub = measureBubbleSort(largeData);
        System.out.println("10   Data : " + smallBub + " Nano");
        System.out.println("1000 Data : " + largeBub + " Nano");

        System.out.println("Insertion Sort : ");
        long smallIns = measureInsertionSort(smallData);
        long largeIns = measureInsertionSort(largeData);
        System.out.println("10   Data : " + smallIns + " Nano");
        System.out.println("1000 Data : " + largeIns + " Nano");

        System.out.println("Merge Sort : ");
        long smallMrg = measureMergeSort(smallData);
        long largeMrg = measureMergeSort(largeData);
        System.out.println("10   Data : " + smallMrg + " Nano");
        System.out.println("1000 Data : " + largeMrg + " Nano");

        System.out.println("Quick Sort : ");
        long smallQck = measureQuickSort(smallData);
        long largeQck = measureQuickSort(largeData);
        System.out.println("10   Data : " + smallQck + " Nano");
        System.out.println("1000 Data : " + largeQck + " Nano");

        System.out.println("Heap Sort : ");
        long smallHap = measureHeapSort(smallData);
        long largeHap = measureHeapSort(largeData);
        System.out.println("10   Data : " + smallHap + " Nano");
        System.out.println("1000 Data : " + largeHap + " Nano");

        System.out.println("Radix Sort : ");
        long smallRdx = measureRadixSort(smallData);
        long largeRdx = measureRadixSort(largeData);
        System.out.println("10   Data : " + smallRdx + " Nano");
        System.out.println("1000 Data : " + largeRdx + " Nano");

    }

    public static void countingSort(int[] array) {
        int n = array.length;
        int max = array[0];

        for (int i = 1; i < n; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        int[] count = new int[max + 1];
        for (int i = 0; i < n; i++) {
            count[array[i]]++;
        }
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }
        int[] output = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }
        for (int i = 0; i < n; i++) {
            array[i] = output[i];
        }
    }

    static long measureCountingSort(int[] Data) {
        int[] DataCopy = Arrays.copyOf(Data, Data.length);
        long startTime = System.nanoTime();

        CountingSort.countingSort(DataCopy);

        long endTime = System.nanoTime();

        return endTime - startTime;
    }

    static long measureSelectionSort(int[] Data) {
        int[] DataCopy = Arrays.copyOf(Data, Data.length);
        long startTime = System.nanoTime();

        SelectionSort.selectionSort(DataCopy);

        long endTime = System.nanoTime();

        return endTime - startTime;
    }

    static long measureBubbleSort(int[] Data) {
        int[] DataCopy = Arrays.copyOf(Data, Data.length);
        long startTime = System.nanoTime();

        BubbleSort.bubbleSort(DataCopy);

        long endTime = System.nanoTime();

        return endTime - startTime;
    }

    static long measureInsertionSort(int[] Data) {
        int[] DataCopy = Arrays.copyOf(Data, Data.length);
        long startTime = System.nanoTime();

        InsertionSort.insertionSort(DataCopy);

        long endTime = System.nanoTime();

        return endTime - startTime;
    }

    static long measureMergeSort(int[] Data) {
        int[] DataCopy = Arrays.copyOf(Data, Data.length);
        long startTime = System.nanoTime();

        MergeSort.mergeSort(DataCopy);

        long endTime = System.nanoTime();

        return endTime - startTime;
    }

    static long measureQuickSort(int[] Data) {
        int[] DataCopy = Arrays.copyOf(Data, Data.length);
        long startTime = System.nanoTime();

        QuickSort.quickSort(DataCopy, 0, DataCopy.length - 1);

        long endTime = System.nanoTime();

        return endTime - startTime;
    }

    static long measureHeapSort(int[] Data) {
        int[] DataCopy = Arrays.copyOf(Data, Data.length);
        long startTime = System.nanoTime();

        HeapSort.heapSort(DataCopy);

        long endTime = System.nanoTime();

        return endTime - startTime;
    }

    static long measureRadixSort(int[] Data) {
        int[] DataCopy = Arrays.copyOf(Data, Data.length);
        long startTime = System.nanoTime();

        RadixSort.radixSort(DataCopy);

        long endTime = System.nanoTime();

        return endTime - startTime;
    }

    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(10000);
        }
        return array;
    }
}
