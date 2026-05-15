public final class GaussianElimination {
    public static double[] solve(double[][] A, double[] b) {
        int n = A.length;
        for (int p = 0; p < n; p++) {
            // Partial pivot
            int max = p;
            for (int i = p + 1; i < n; i++)
                if (Math.abs(A[i][p]) > Math.abs(A[max][p])) max = i;

            double[] tmp = A[p]; A[p] = A[max]; A[max] = tmp;
            double t = b[p]; b[p] = b[max]; b[max] = t;

            

            // Eliminate
            for (int i = p + 1; i < n; i++) {
                double alpha = A[i][p] / A[p][p];
                b[i] -= alpha * b[p];
                for (int j = p; j < n; j++) A[i][j] -= alpha * A[p][j];
            }
        }
        // Back substitution
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0;
            for (int j = i + 1; j < n; j++) sum += A[i][j] * x[j];
            x[i] = (b[i] - sum) / A[i][i];
        }
        return x;
    }
}
