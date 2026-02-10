public class NestedLoopExample {
    public static void main(String[] args) {

        for (int i = 1; i <= 3; i++) {            // outer loop
            for (int j = 1; j <= 4; j++) {        // inner loop
                System.out.print(j + " ");
            }
            System.out.println();                 // new line after each row
        }
        for (int j = 1; j <= 4; j++) {        // inner loop
                System.out.print(j + " ");
            }
    }
}
