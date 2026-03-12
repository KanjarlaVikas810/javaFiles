public class FEMSolver {
    public double[] solve(double[][] K, double[] F) {
        int n = K.length;

        for (int p = 0; p < n; p++) {
            for (int i = p+1; i < n; i++) {
                double factor = K[i][p] / K[p][p];
                for (int j = p; j < n; j++)
                    K[i][j] -= factor * K[p][j];
                F[i] -= factor * F[p];
            }
        }
        double[] x = new double[n];
        for (int i = n-1; i >= 0; i--) {
            double sum = 0;
            for (int j = i+1; j < n; j++)
                sum += K[i][j] * x[j];
            x[i] = (F[i] - sum) / K[i][i];
        }
        return x;
    }
}
