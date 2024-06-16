
import java.util.Arrays;
import java.util.Random;


public class InsertionSort {
    
    public static void main(String[] args) {
        int[] data10 = generateRandomArray(10);
        int[] data100 = generateRandomArray(100);
        int[] data1000 = generateRandomArray(1000);
        int[] data10000 = generateRandomArray(10000);

        long Count10 = measureInsertionSort(data10);
        long Count100 = measureInsertionSort(data100);
        long Count1000 = measureInsertionSort(data1000);
        long Count10000 = measureInsertionSort(data10000);

        System.out.println("INSERTION SORT : ");
        System.out.println("10    Data : " + Count10 + " Nano");
        System.out.println("100   Data : " + Count100 + " Nano");
        System.out.println("1000  Data : " + Count1000 + " Nano");
        System.out.println("10000 Data : " + Count10000 + " Nano");
    }

    public static void insertionSort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }
    
    static long measureInsertionSort(int[] Data) {
        int[] DataCopy = Arrays.copyOf(Data, Data.length);
        long startTime = System.nanoTime();

        InsertionSort.insertionSort(DataCopy);

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
