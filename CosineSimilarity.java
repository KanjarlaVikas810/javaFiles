import java.util.*;

public final class CosineSimilarity {
    // Sparse vector as term -> weight
    public static double dot(Map<String, Double> a, Map<String, Double> b) {
        Map<String, Double> small = a.size() < b.size() ? a : b;
        Map<String, Double> large = a.size() < b.size() ? b : a;
        double sum = 0.0;
        for (Map.Entry<String, Double> e : small.entrySet()) {
            Double y = large.get(e.getKey());
            if (y != null) sum += e.getValue() * y;
        }
        return sum;
    }

    public static double norm(Map<String, Double> v) {
        double s = 0.0;
        for (double x : v.values()) s += x * x;
        return Math.sqrt(s);
    }

    // O(n^2 * d) over n documents with avg d nonzeros
    public static double[][] fullSimilarity(List<Map<String, Double>> tfidf) {
        int n = tfidf.size();
        double[][] S = new double[n][n];
        double[] norm = new double[n];
        for (int i = 0; i < n; i++) norm[i] = norm(tfidf.get(i));

        for (int i = 0; i < n; i++) {
            S[i][i] = 1.0;
            for (int j = i + 1; j < n; j++) {
                double d = dot(tfidf.get(i), tfidf.get(j));
                double sim = (norm[i] == 0 || norm[j] == 0) ? 0.0 : d / (norm[i] * norm[j]);
                S[i][j] = S[j][i] = sim;
            }
        }
        return S;
    }
}
