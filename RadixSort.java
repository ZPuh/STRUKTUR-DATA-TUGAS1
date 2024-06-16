import java.util.Arrays;
import java.util.Random;

public class RadixSort {

    // Fungsi untuk mengurutkan array menggunakan Radix Sort
    public static void main(String[] args) {
        int[] data10 = generateRandomArray(10);
        int[] data100 = generateRandomArray(100);
        int[] data1000 = generateRandomArray(1000);
        int[] data10000 = generateRandomArray(10000);

        long timeFor10 = measureRadixSort(data10);
        long timeFor100 = measureRadixSort(data100);
        long timeFor1000 = measureRadixSort(data1000);
        long timeFor10000 = measureRadixSort(data10000);

        System.out.println("RADIX SORT : ");
        System.out.println("10    Data : " + timeFor10 + " Nano");
        System.out.println("100   Data : " + timeFor100 + " Nano");
        System.out.println("1000  Data : " + timeFor1000 + " Nano");
        System.out.println("10000 Data : " + timeFor10000 + " Nano");
    }

    public static void radixSort(int[] arr) {
        // Mencari nilai maksimum dalam array
        int max = Arrays.stream(arr).max().getAsInt();

        // Melakukan pengurutan berdasarkan digit dari LSD (Least Significant Digit) ke MSD (Most Significant Digit)
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    // Fungsi Counting Sort untuk mengurutkan array berdasarkan digit ke-eksponen
    private static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; // Output array
        int[] count = new int[10]; // Count array untuk menyimpan jumlah kemunculan digit

        // Menghitung jumlah kemunculan setiap digit
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // Menghitung posisi akhir setiap digit
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Membangun array output
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Menyalin array output ke array asli
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    static long measureRadixSort(int[] data) {
        int[] dataCopy = Arrays.copyOf(data, data.length);
        long startTime = System.nanoTime();

        radixSort(dataCopy);

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
