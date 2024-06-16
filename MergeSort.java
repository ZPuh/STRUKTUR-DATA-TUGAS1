
import java.util.Arrays;
import java.util.Random;

public class MergeSort {

    public static void main(String[] args) {
        int[] data10 = generateRandomArray(10);
        int[] data100 = generateRandomArray(100);
        int[] data1000 = generateRandomArray(1000);
        int[] data10000 = generateRandomArray(10000);

        long Count10 = measureMergeSort(data10);
        long Count100 = measureMergeSort(data100);
        long Count1000 = measureMergeSort(data1000);
        long Count10000 = measureMergeSort(data10000);

        System.out.println("MERGE SORT :");
        System.out.println("10    Data : " + Count10 + " Nano");
        System.out.println("100   Data : " + Count100 + " Nano");
        System.out.println("1000  Data : " + Count1000 + " Nano");
        System.out.println("10000 Data : " + Count10000 + " Nano");
    }

    public static void mergeSort(int[] array) {
        if (array.length <= 1) {
            return;
        }

        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        // Memisahkan array menjadi dua bagian
        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }
        for (int i = mid; i < array.length; i++) {
            right[i - mid] = array[i];
        }

        // Memanggil mergeSort secara rekursif pada kedua bagian
        mergeSort(left);
        mergeSort(right);

        // Menggabungkan kedua bagian yang telah diurutkan
        merge(left, right, array);
    }

    public static void merge(int[] left, int[] right, int[] result) {
        int i = 0, j = 0, k = 0;

        // Menggabungkan dua bagian menjadi satu array
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        // Menyalin sisa elemen jika ada
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }
    }

    static long measureMergeSort(int[] Data) {
        int[] DataCopy = Arrays.copyOf(Data, Data.length);
        long startTime = System.nanoTime();

        MergeSort.mergeSort(DataCopy);

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
