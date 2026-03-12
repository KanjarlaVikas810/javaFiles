class PixelGraph {
    int width, height;
    double[][] image;

    public List<Edge> build() {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int id = i * width + j;

                if (j + 1 < width)
                    edges.add(new Edge(id, id + 1, similarity(i, j, i, j+1)));

                if (i + 1 < height)
                    edges.add(new Edge(id, id + width, similarity(i, j, i+1, j)));
            }
        }
        return edges;
    }
}
