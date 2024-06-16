
import java.util.Arrays;
import java.util.Random;

public class CountingSort {
   
    public static void main(String[] args) {
        int[] data10 = generateRandomArray(10);
        int[] data100 = generateRandomArray(100);
        int[] data1000 = generateRandomArray(1000);
        int[] data10000 = generateRandomArray(10000);

        long Count10 = measureCountingSort(data10);
        long Count100 = measureCountingSort(data100);
        long Count1000 = measureCountingSort(data1000);
        long Count10000 = measureCountingSort(data10000);

        System.out.println("COUNTING SORT : ");
        System.out.println("10    Data : " + Count10 + " Nano");
        System.out.println("100   Data : " + Count100 + " Nano");
        System.out.println("1000  Data : " + Count1000 + " Nano");
        System.out.println("10000 Data : " + Count10000 + " Nano");

    }

    public static void countingSort(int[] array) {
        int n = array.length;
        int max = array[0];

        for (int i = 1; i < n; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        // Buat counting array dengan ukuran max+1 (untuk menampung semua nilai dari 0 hingga max)
        int[] count = new int[max + 1];
        // Hitung jumlah kemunculan setiap nilai dalam array input
        for (int i = 0; i < n; i++) {
            count[array[i]]++;
        }
        // Ubah counting array sehingga setiap posisi mencerminkan posisi akhir elemen di array terurut
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }
        // Buat array output yang akan berisi elemen-elemen terurut
        int[] output = new int[n];
        // Bangun array output dengan menelusuri array input dari belakang (untuk menjaga kestabilan)
        for (int i = n - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }
        // Salin elemen dari array output ke array input (sehingga array input menjadi terurut)
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

    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(10000);
        }
        return array;
    }
}
