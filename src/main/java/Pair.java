class Pair<X, Y> {
    private X x;
    private Y y;

    void setX(X x) {
        this.x = x;
    }

    X getX() {
        return x;
    }

    void setY(Y y) {
        this.y = y;
    }

    Y getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
