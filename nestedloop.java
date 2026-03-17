public class NestedLoop {
    public static void main(String[] args) {

        System.out.print(
            "1 2 3 4\n" +
            "1 2 3 4\n" +
            "1 2 3 4\n"
        );
        for (int i = 1; i <= 3; i++) {            // outer loop
            System.out.println();        
            for (int k = 1; k <= 3; k++) {            // outer loop
            System.out.println(i);                 // new line after each row
        }// new line after each row
        }

    }
}
