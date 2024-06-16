
import java.util.Arrays;
import java.util.Random;


public class BubbleSort {
    public static void main(String[] args) {
        int[] data10 = generateRandomArray(10);
        int[] data100 = generateRandomArray(100);
        int[] data1000 = generateRandomArray(1000);
        int[] data10000 = generateRandomArray(10000);

        long Count10 = measureBubbleSort(data10);
        long Count100 = measureBubbleSort(data100);
        long Count1000 = measureBubbleSort(data1000);
        long Count10000 = measureBubbleSort(data10000);

        System.out.println("BUBBLE SORT :");
        System.out.println("10    Data : " + Count10 + " Nano");
        System.out.println("100   Data : " + Count100 + " Nano");
        System.out.println("1000  Data : " + Count1000 + " Nano");
        System.out.println("10000 Data : " + Count10000 + " Nano");

    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // Tukar elemen array[j] dengan array[j + 1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            // Jika tidak ada elemen yang ditukar, array sudah terurut
            if (!swapped) {
                break;
            }
        }
    }
    
    static long measureBubbleSort(int[] Data) {
        int[] DataCopy = Arrays.copyOf(Data, Data.length);
        long startTime = System.nanoTime();

        BubbleSort.bubbleSort(DataCopy);

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
