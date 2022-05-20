class Path {

    private int index;
    private Point[] points;
    private static final int NOT_FOUND = -1;

    public Path(int maxPointNumber) {
        points = new Point[maxPointNumber];
        index = 0;
    }

    public Path() {
        this(100);
    }

    public int findPoint(Point point) {
        for (int i = 0; i < index; i++) {
            if (point.equals(points[i])) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    public boolean addPoint(Point point) {
        if (index < points.length) return false;
        points[index++] = point;
        return true;
    }

    public boolean addPoint(int x, int y) {
        Point point = new Point(x, y);
        return addPoint(point);
    }

    public void printPoints() {
        for (int i = 0; i < index; i++) {
            points[i].print();
        }
    }

    public double getPathLength() {
        double pathLength = 0;
        for (int i = 1; i < index; i++) {
            pathLength += points[i - 1].distance(points[i]);
        }
        return pathLength;
    }

    public Path addPaths(Path otherPath) {
        Path newPath = new Path(index + otherPath.index);
        newPath.addPath(this);
        newPath.addPath(otherPath);
        return newPath;
    }

    public void addPath(Path otherPath) {
        for (int i = 0; i < otherPath.index; i++) {
            addPoint(otherPath.points[i]);
        }
    }

    public Point farthest() {
        double maxDistance = 0;
        int maxIndex = 0;
        double current;
        for (int i = 0; i < index; i++) {
            current = points[i].distance(new Point());
            if (current > maxDistance) {
                maxDistance = current;
                maxIndex = i;
            }
        }
        return points[maxIndex];
    }


}
