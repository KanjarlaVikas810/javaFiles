import java.util.Arrays;

public final class FloydWarshall {
    private final int n;
    private final double[][] dist;
    private final int[][] next;
    private static final double INF = 1e18;

    public FloydWarshall(double[][] adj) {
        this.n = adj.length;
        this.dist = new double[n][n];
        this.next = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(next[i], -1);
            for (int j = 0; j < n; j++) {
                dist[i][j] = (i == j) ? 0.0 : (adj[i][j] == 0 ? INF : adj[i][j]);
                if (adj[i][j] != 0) next[i][j] = j;
            }
        }
    }

    // O(n^3)
  }
    }

    public double[][] distances() { return dist; }

    public int[] reconstructPath(int u, int v) {
        if (next[u][v] == -1) return new int[0];
        java.util.List<Integer> path = new java.util.ArrayList<>();
        path.add(u);
        while (u != v) {
            u = next[u][v];
            if (u == -1) return new int[0];
            path.add(u);
        }
        return path.stream().mapToInt(Integer::intValue).toArray();
    }
}
