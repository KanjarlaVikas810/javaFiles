public class NBodySimulation {
    private final List<Body> bodies;
    private static final double G = 6.674e-11;

    public void computeForces() {
        int n = bodies.size();
        for (int i = 0; i < n; i++) {
            Body a = bodies.get(i);
            for (int j = i + 1; j < n; j++) {
                Body b = bodies.get(j);
                double dx = b.x - a.x;
                double dy = b.y - a.y;
                double dist = Math.sqrt(dx*dx + dy*dy);

                double force = G * a.mass * b.mass / (dist*dist);
                double fx = force * dx / dist;
                double fy = force * dy / dist;

                a.vx += fx / a.mass;
                a.vy += fy / a.mass;
                b.vx -= fx / b.mass;
                b.vy -= fy / b.mass;
            }
        }
    }
}
