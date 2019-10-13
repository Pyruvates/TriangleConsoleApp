import java.util.Queue;

class Triangle {
    private Pair<Integer, Integer> pointA;
    private Pair<Integer, Integer> pointB;
    private Pair<Integer, Integer> pointC;
    private double sideAB;
    private double sideAC;
    private double sideBC;

    Triangle(Queue<Integer> coordinates) {
        try {
            setPoints(coordinates);
            calculateSidesOfTriangle(pointA, pointB, pointC);
        } catch (NullPointerException e) {
            System.out.println("Не удалось создать треугольник.");
        }
    }

    Pair<Integer, Integer> getPointA() {
        return pointA;
    }

    Pair<Integer, Integer> getPointB() {
        return pointB;
    }

    Pair<Integer, Integer> getPointC() {
        return pointC;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "pointA=" + pointA +
                ", pointB=" + pointB +
                ", pointC=" + pointC +
                ", sideAB=" + sideAB +
                ", sideAC=" + sideAC +
                ", sideBC=" + sideBC +
                '}';
    }

    double calculateTriangleArea() {
        int p, s, r, q;
        double area;
        p = pointA.getX() - pointC.getX();
        s = pointB.getY() - pointC.getY();
        r = pointB.getX() - pointC.getX();
        q = pointA.getY() - pointC.getY();
        area = ((p * s) - (r * q)) / 2.0;
        return Math.abs(area);
    }

    boolean isIsosceles() {
        if (sideAB == sideAC && sideAB == sideBC && sideAC == sideBC)
            return false;
        return sideAB == sideAC || sideAB == sideBC || sideAC == sideBC;
    }

    private void setPoints(Queue<Integer> coordinates) {
        this.pointA = assignPoint(coordinates);
        this.pointB = assignPoint(coordinates);
        this.pointC = assignPoint(coordinates);
    }

    private Pair<Integer, Integer> assignPoint(Queue<Integer> queue) {
        Pair<Integer, Integer> point = new Pair<>();
        point.setX(queue.poll());
        point.setY(queue.poll());
        return point;
    }

    private void calculateSidesOfTriangle(Pair<Integer, Integer> firstPoint,
                                          Pair<Integer, Integer> secondPoint,
                                          Pair<Integer, Integer> thirdPoint) {
        this.sideAB = calculateSegment(firstPoint, secondPoint);
        this.sideAC = calculateSegment(firstPoint, thirdPoint);
        this.sideBC = calculateSegment(secondPoint, thirdPoint);
    }

    private double calculateSegment(Pair<Integer, Integer> firstPoint, Pair<Integer, Integer> secondPoint) {
        int deltaX = secondPoint.getX() - firstPoint.getX();
        int deltaY = secondPoint.getY() - firstPoint.getY();
        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }
}
