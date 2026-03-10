public class ON3Example {
    public static void main(String[] args) {
        int n = 5;

        // Use long to avoid overflow when n^3 exceeds Integer.MAX_VALUE
        long count = 1L * n * n * n;

        System.out.println("Total operations: " + count);
    }
}
