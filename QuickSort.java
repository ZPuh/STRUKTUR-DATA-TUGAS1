
import java.util.Arrays;
import java.util.Random;


public class QuickSort {
    public static void main(String[] args) {
        int[] data10 = generateRandomArray(10);
        int[] data100 = generateRandomArray(100);
        int[] data1000 = generateRandomArray(1000);
        int[] data10000 = generateRandomArray(10000);

        long Count10 = measureQuickSort(data10);
        long Count100 = measureQuickSort(data100);
        long Count1000 = measureQuickSort(data1000);
        long Count10000 = measureQuickSort(data10000);

        System.out.println("QUICK SORT : ");
        System.out.println("10    Data : " + Count10 + " Nano");
        System.out.println("100   Data : " + Count100 + " Nano");
        System.out.println("1000  Data : " + Count1000 + " Nano");
        System.out.println("10000 Data : " + Count10000 + " Nano");

    }
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Partition index adalah index elemen yang telah ditempatkan di posisi yang tepat
            int partitionIndex = partition(array, low, high);

            // Memanggil quickSort secara rekursif pada subarray sebelum dan sesudah partition index
            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        // Memilih pivot (dalam kasus ini, pivot adalah elemen terakhir dari array)
        int pivot = array[high];
        int i = low - 1;

        // Memindahkan elemen yang lebih kecil dari pivot ke sisi kiri, dan elemen yang lebih besar ke sisi kanan
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;

                // Menukar array[i] dengan array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Menukar array[i+1] dengan pivot
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
    static long measureQuickSort(int[] Data) {
        int[] DataCopy = Arrays.copyOf(Data, Data.length);
        long startTime = System.nanoTime();

        QuickSort.quickSort(DataCopy,0,DataCopy.length-1);

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
