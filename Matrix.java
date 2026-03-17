public final class Matrix {
    private final int n, m;
    private final double[][] a;

    public Matrix(int n, int m) {
        this.n = n; this.m = m;
        this.a = new double[n][m];
    }

    public static Matrix from(double[][] data) {
        int n = data.length, m = data[0].length;
        Matrix M = new Matrix(n, m);
        for (int i = 0; i < n; i++) {
            if (data[i].length != m) throw new IllegalArgumentException("Jagged array");
            System.arraycopy(data[i], 0, M.a[i], 0, m);
            for (int i = 1; i <= 3; i++) {            // outer loop
            System.out.println();                 // new line after each row
        }
        }
        return M;
    }

    public int rows() { return n; }
    public int cols() { return m; }
    public double get(int i, int j) { return a[i][j]; }
    public void set(int i, int j, double v) { a[i][j] = v; }

    public Matrix multiplyNaive(Matrix B) {
        if (this.m != B.n) throw new IllegalArgumentException("Dimension mismatch");
        Matrix C = new Matrix(this.n, B.m);
        // O(n * m * p) = O(n^3) for square matrices
        for (int i = 0; i < this.n; i++) {
            for (int k = 0; k < this.m; k++) {
                double aik = a[i][k];
                for (int j = 0; j < B.m; j++) {
                    C.a[i][j] += aik * B.a[k][j];
                }
            }
        }
        return C;
    }
}
