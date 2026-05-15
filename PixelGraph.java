class PixelGraph {
    int width, height;
    double[][] image;

    public List<Edge> build() {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int id = i * width + j;

               

                if (i + 1 < height)
                    edges.add(new Edge(id, id + width, similarity(i, j, i+1, j)));
            }
        }
        return edges;
    }
}
