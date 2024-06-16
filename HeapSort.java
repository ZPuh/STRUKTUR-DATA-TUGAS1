
import java.util.Arrays;
import java.util.Random;


public class HeapSort {

    public static void main(String[] args) {
        int[] data10 = generateRandomArray(10);
        int[] data100 = generateRandomArray(100);
        int[] data1000 = generateRandomArray(1000);
        int[] data10000 = generateRandomArray(10000);

        long Count10 = measureHeapSort(data10);
        long Count100 = measureHeapSort(data100);
        long Count1000 = measureHeapSort(data1000);
        long Count10000 = measureHeapSort(data10000);

        System.out.println("HEAP SORT : ");
        System.out.println("10    Data : " + Count10 + " Nano");
        System.out.println("100   Data : " + Count100 + " Nano");
        System.out.println("1000  Data : " + Count1000 + " Nano");
        System.out.println("10000 Data : " + Count10000 + " Nano");

    }

    public static void heapSort(int[] array) {
        int n = array.length;

        // Membangun heap maksimum
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // Mengurutkan array dengan menghapus elemen satu per satu dari heap
        for (int i = n - 1; i >= 0; i--) {
            // Menukar root heap (elemen terbesar) dengan elemen terakhir array
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Memanggil heapify pada heap yang telah dikurangi ukurannya
            heapify(array, i, 0);
        }
    }

    public static void heapify(int[] array, int n, int i) {
        int largest = i; // Menetapkan root sebagai elemen terbesar
        int leftChild = 2 * i + 1; // Indeks anak kiri
        int rightChild = 2 * i + 2; // Indeks anak kanan

        // Jika anak kiri ada dan lebih besar dari root
        if (leftChild < n && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        // Jika anak kanan ada dan lebih besar dari root atau anak kiri
        if (rightChild < n && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        // Jika root tidak lagi menjadi elemen terbesar
        if (largest != i) {
            // Menukar root dengan elemen terbesar
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            // Memanggil rekursif untuk memastikan heap terbesar
            heapify(array, n, largest);
        }
    }
    static long measureHeapSort(int[] Data) {
        int[] DataCopy = Arrays.copyOf(Data, Data.length);
        long startTime = System.nanoTime();

        HeapSort.heapSort(DataCopy);

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
