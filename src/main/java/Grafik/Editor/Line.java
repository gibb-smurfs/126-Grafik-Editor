package Grafik.Editor;

class Line extends Figure {
    private int x2;
    private int y2;

    Line(int x, int y, int x2, int y2) {
        super(x, y);
        this.x2 = x2;
        this.y2 = y2;
    }

    int getX2() {
        return x2;
    }

    int getY2() {
        return y2;
    }
}