import edu.princeton.cs.algs4.*;

public class InsertionSort {

    // Insertion Sort
    public static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;

            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }

            a[j + 1] = key;
        }
    }

    // Đo thời gian chạy của Insertion Sort
    public static double measure(int[] original) {
        int[] a = original.clone();

        long start = System.nanoTime();

        sort(a);

        long end = System.nanoTime();

        return (end - start) / 1_000_000.0;
    }

    // Tính thời gian trung bình
    public static double average(int[] a, int runs) {
        double total = 0;

        for (int i = 0; i < runs; i++) {
            total += measure(a);
        }

        return total / runs;
    }

    // Sinh dữ liệu ngẫu nhiên
    public static int[] randomArray(int n) {
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniformInt(0, n * 10);
        }

        return a;
    }

    // Dữ liệu đã sắp xếp tăng dần
    public static int[] sortedArray(int n) {
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = i;
        }

        return a;
    }

    // Dữ liệu sắp xếp giảm dần
    public static int[] reverseArray(int n) {
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = n - i;
        }

        return a;
    }

    // Dữ liệu toàn các giá trị bằng nhau
    public static int[] equalArray(int n) {
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = 1;
        }

        return a;
    }

    // Đọc dữ liệu từ file
    public static int[] readFile(String filename) {
        In in = new In(filename);
        return in.readAllInts();
    }

    public static void main(String[] args) {

        int[] sizes = {1000, 2000, 4000, 8000, 16000};

        System.out.println("===== INSERTION SORT =====");
        System.out.printf("%-15s %-10s %-20s%n",
                "Data", "N", "Average Time (ms)");

        // 1. Dữ liệu từ file
        String[] files = {
                "F:\\algs4-data\\1Kints.txt",
                "F:\\algs4-data\\2Kints.txt",
                "F:\\algs4-data\\4Kints.txt",
                "F:\\algs4-data\\8Kints.txt",
                "F:\\algs4-data\\16Kints.txt"
        };

        int[] fileSizes = {1000, 2000, 4000, 8000, 16000};

        for (int i = 0; i < files.length; i++) {
            int[] a = readFile(files[i]);

            System.out.printf("%-15s %-10d %-20.3f%n",
                    "File", fileSizes[i], average(a, 3));
        }

        // 2. Dữ liệu ngẫu nhiên
        for (int n : sizes) {
            int[] a = randomArray(n);

            System.out.printf("%-15s %-10d %-20.3f%n",
                    "Random", n, average(a, 5));
        }

        // 3. Dữ liệu đã sắp xếp
        for (int n : sizes) {
            int[] a = sortedArray(n);

            System.out.printf("%-15s %-10d %-20.3f%n",
                    "Sorted", n, average(a, 3));
        }

        // 4. Dữ liệu sắp xếp ngược
        for (int n : sizes) {
            int[] a = reverseArray(n);

            System.out.printf("%-15s %-10d %-20.3f%n",
                    "Reverse", n, average(a, 3));
        }

        // 5. Dữ liệu toàn giá trị bằng nhau
        for (int n : sizes) {
            int[] a = equalArray(n);

            System.out.printf("%-15s %-10d %-20.3f%n",
                    "Equal", n, average(a, 3));
        }
    }
}