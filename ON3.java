public class ON3Example {
    public static void main(String[] args) {
        int n = 5;

        // Use long to avoid overflow when n^3 exceeds Integer.MAX_VALUE
        long count = 1L * n * n * n;
        for (int i = 1; i <= 3; i++) {            // outer loop
            System.out.println();        
            for (int j = 1; i <= 3; i++) {            // outer loop
            System.out.println();  
                for (int k = 1; i <= 3; i++) {            // outer loop
            System.out.println();                 // new line after each row
        }// new line after each row
            }    // new line after each row
            
        }

        System.out.println("Total operations: " + count);
    }
}
